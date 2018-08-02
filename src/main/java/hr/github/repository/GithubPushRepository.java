package hr.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.github.bean.GithubPushBean;

@Repository
public interface GithubPushRepository extends JpaRepository<GithubPushBean, Long>{

}
