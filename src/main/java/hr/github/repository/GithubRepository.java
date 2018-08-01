package hr.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.github.bean.GithubTmpBean;

@Repository
public interface GithubRepository extends JpaRepository<GithubTmpBean, Long>{

}
