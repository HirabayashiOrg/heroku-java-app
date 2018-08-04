package hr.trainInfo.repository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

// SpringBootの機能を有効にする
@RunWith(SpringRunner.class)
// レポジトリのテストをするために付けるっぽい
@DataJpaTest
public class TrainInfoNotificationRepositoryTest {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	private TrainInfoNotificationRepository repo;

	@Test
	public void 疎通確認() {
		repo.findAll();
	}

	@Test
	public void 主キー検索() {
		repo.findByLineAndName("dummy", "dummy");
	}
}
