package hr.trainInfo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.trainInfo.bean.TrainInfoBean;
import hr.trainInfo.bean.TrainInfoNotificationBean;
import hr.trainInfo.repository.TrainInfoNotificationRepository;
import hr.trainInfo.util.TrainInfoUtil;

@Transactional
@Service
public class TrainInfoNoticeService {
	@Autowired
	private TrainInfoNotificationRepository repo;

	// DBに登録済の路線情報のみ抽出する
	public List<TrainInfoBean> getNoticeInfomations() throws Exception {
		// 運行情報リスト取得
		List<TrainInfoBean> infoList = TrainInfoUtil.getInfomations();
		// DBから通知対象の路線を取得
		List<TrainInfoNotificationBean> noticeList = repo.findByName("all");
		// 一致するデータを抽出
		List<TrainInfoBean> list = infoList.stream()
				.filter(info -> {
					for(TrainInfoNotificationBean notice: noticeList) {
						// 通知対象リストに含まれる
						if(notice.getLine().equals(info.getLine()) && !"平常運転".equals(info.getInfo())) {
							return true;
						}
					}
					return false;
				})
				.collect(Collectors.toList());

		return list;
	}
}
