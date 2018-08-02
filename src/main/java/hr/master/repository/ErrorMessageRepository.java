package hr.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.master.bean.ErrorMessageBean;

@Repository
public interface ErrorMessageRepository extends JpaRepository<ErrorMessageBean, Long>{

}
