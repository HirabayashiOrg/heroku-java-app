package hr.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.github.bean.GithubPushViewBean;

@Repository
public interface GithubPushViewRepository extends JpaRepository<GithubPushViewBean, Long>{

}
