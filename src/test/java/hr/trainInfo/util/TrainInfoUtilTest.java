package hr.trainInfo.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hr.trainInfo.bean.TrainInfoBean;

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
