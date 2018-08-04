package hr.trainInfo.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hr.trainInfo.bean.TrainInfoBean;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrainInfoUtilTest extends Assert {
	@Rule
	public ExpectedException exceptedException = ExpectedException.none();

	@Test
	public void 運行情報リスト取得() throws Exception {
		List<TrainInfoBean> list = TrainInfoUtil.getInfomations();
		// list.forEach(System.out::println);

		boolean bool = list.stream()
			.anyMatch(bean -> bean.getLine().equals("南武線[川崎～立川]"));
		assertTrue(bool);
	}
}
