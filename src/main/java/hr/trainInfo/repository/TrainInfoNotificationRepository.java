package hr.trainInfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.trainInfo.bean.TrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoNotificationPrimaryKey;

@Repository
public interface TrainInfoNotificationRepository extends JpaRepository<TrainInfoNotificationBean, TrainInfoNotificationPrimaryKey>{
	public Optional<TrainInfoNotificationBean> findByLineAndName(String line, String name);
	public List<TrainInfoNotificationBean> findByName(String name);
}
