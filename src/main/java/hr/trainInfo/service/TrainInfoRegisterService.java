package hr.trainInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoRegisterBean;
import hr.trainInfo.repository.NTrainInfoNotificationRepository;

@Transactional
@Service
public class TrainInfoRegisterService {
	@Autowired
	NTrainInfoNotificationRepository repo;

	public TrainInfoRegisterBean register(String line) {
		String message = "";
		// DBから値を取得
		Optional<NTrainInfoNotificationBean> optional = repo.findByLineAndName(line, "all");
		// データが存在したら何もしない
		if(optional.isPresent()) {
			message = "登録済です。";
		// データが存在しない場合は新規で登録する
		} else {
			// 登録用データの生成
			NTrainInfoNotificationBean bean = NTrainInfoNotificationBean.builder()
					.line(line)
					.name("all")
					.build();
			// データ登録
			repo.saveAndFlush(bean);

			message = "登録しました！";
		}

		TrainInfoRegisterBean bean = TrainInfoRegisterBean.builder()
				.message(message)
				.build();

		return bean;
	}

	public void update(List<NTrainInfoNotificationBean> list) {
		repo.saveAll(list);
		repo.flush();
	}
}
