package hr.trainInfo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoRegisterBean;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TrainInfoRegisterServiceTest extends Assert {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	private TrainInfoRegisterService registerService;

	@Test
	@Rollback(true)  // 明示的にロールバックを設定
	public void 新規登録確認() throws Exception {
		TrainInfoRegisterBean bean = registerService.register("南武線");
		assertEquals(bean.getMessage(), "登録しました！");
	}

	@Test
	@Rollback(true)  // 明示的にロールバックを設定
	public void 更新確認() throws Exception {
		List<NTrainInfoNotificationBean> list = new ArrayList<NTrainInfoNotificationBean>();
		NTrainInfoNotificationBean bean = NTrainInfoNotificationBean.builder()
				.line("南武線[川崎～立川]")
				.name("all")
				.url("test")
				.info("test")
				.detail("test")
				.build();
		list.add(bean);

		registerService.update(list);
	}

	@Test
	@Rollback(true)
	public void 削除確認() throws Exception {
		String line = "テスト";

		String message = registerService.delete(line);

		assertEquals(message, "登録されていません。");
	}

}
