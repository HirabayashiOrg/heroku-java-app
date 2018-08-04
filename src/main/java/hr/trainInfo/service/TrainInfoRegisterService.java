package hr.trainInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.trainInfo.bean.TrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoRegisterBean;
import hr.trainInfo.repository.TrainInfoNotificationRepository;

@Service
public class TrainInfoRegisterService {
	@Autowired
	TrainInfoNotificationRepository repo;

	public TrainInfoRegisterBean register(String line) {
		String message = "";
		// DBから値を取得
		Optional<TrainInfoNotificationBean> optional = repo.findByLineAndName(line, "all");
		// データが存在したら何もしない
		if(optional.isPresent()) {
			message = "登録済です。";
		// データが存在しない場合は新規で登録する
		} else {
			// 登録用データの生成
			TrainInfoNotificationBean bean = TrainInfoNotificationBean.builder()
					.line(line)
					.name("all")
					.status(1)
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
}
