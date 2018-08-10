package hr.trainInfo.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hr.trainInfo.bean.NTrainInfoNotificationBean;

// SpringBootの機能を有効にする
@RunWith(SpringRunner.class)
// レポジトリのテストをするために付けるっぽい
@DataJpaTest
public class NTrainInfoNotificationRepositoryTest extends Assert{
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	private NTrainInfoNotificationRepository repo;

	@Test
	public void 疎通確認() {
		repo.findAll();
	}

	@Test
	public void 主キー検索() {
		repo.findByLineAndName("dummy", "dummy");
	}

	@Test
	public void 名前検索() {
		List<NTrainInfoNotificationBean> list = repo.findByName("all");
		list.forEach(obj -> System.out.println(obj.toString()));

		assertTrue(list.size() > 0);
	}
}
