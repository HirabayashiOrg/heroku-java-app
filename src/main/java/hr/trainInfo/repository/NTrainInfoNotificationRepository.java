package hr.trainInfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoNotificationPrimaryKey;

@Repository
public interface NTrainInfoNotificationRepository extends JpaRepository<NTrainInfoNotificationBean, TrainInfoNotificationPrimaryKey>{
	public Optional<NTrainInfoNotificationBean> findByLineAndName(String line, String name);
	public List<NTrainInfoNotificationBean> findByName(String name);
}
