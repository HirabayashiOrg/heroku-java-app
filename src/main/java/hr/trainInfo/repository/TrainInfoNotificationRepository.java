package hr.trainInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.trainInfo.bean.TrainInfoNotificationBean;

@Repository
public interface TrainInfoNotificationRepository extends JpaRepository<TrainInfoNotificationBean, Long>{

}
