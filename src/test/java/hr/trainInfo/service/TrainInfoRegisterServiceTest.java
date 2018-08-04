package hr.trainInfo.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hr.trainInfo.bean.TrainInfoRegisterBean;

@RunWith(SpringRunner.class)
@DataJpaTest

public class TrainInfoRegisterServiceTest extends Assert {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	TrainInfoRegisterService registerService;

	@Test
	public void 新規登録確認() throws Exception {
		TrainInfoRegisterBean bean = registerService.register("南武線");
		assertEquals(bean.getMessage(), "登録しました！");
	}

}
