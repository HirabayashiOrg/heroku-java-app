package hr.trainInfo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.line.uril.LinePushUtil;
import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.bean.NTrainInfoNotificationBeans;
import hr.trainInfo.repository.NTrainInfoNotificationRepository;
import hr.trainInfo.util.TrainInfoUtil;

@Transactional
@Service
public class NTrainInfoNoticeService {
	@Autowired
	private NTrainInfoNotificationRepository repo;

	// DBに登録済の路線情報のみ抽出する
	public List<NTrainInfoNotificationBean> getNoticeInfomations() throws Exception {
		// ＜Yahoo路線＞から運行情報リスト取得
		List<NTrainInfoNotificationBean> infoList = TrainInfoUtil.getNotifications();
		// DBから通知対象の路線を取得
		List<NTrainInfoNotificationBean> noticeList = repo.findByName("all");
		// 一致するデータを抽出
		List<NTrainInfoNotificationBean> list = infoList.stream()
				.filter(info -> {
					// 路線が一致し、運行状態が違うものを抽出
					for(NTrainInfoNotificationBean notice: noticeList) {
						if(NTrainInfoNotificationBeans.isSameLineDiffInfo(notice, info)) {
							return true;
						}
					}
					return false;
				})
				.collect(Collectors.toList());

		return list;
	}

	public List<NTrainInfoNotificationBean> noticeTrainInfomations(List<NTrainInfoNotificationBean> list) throws Exception {
		// リストが空でなければ通知
		if(!list.isEmpty()) {
			// メッセージの作成
			String message = NTrainInfoNotificationBeans.createMessage(list);
			// 通知
			LinePushUtil.sendMessage(LinePushUtil.TO_RYO, message);
			LinePushUtil.sendMessage(LinePushUtil.TO_EMI, message);
		}

		return list;
	}
}
