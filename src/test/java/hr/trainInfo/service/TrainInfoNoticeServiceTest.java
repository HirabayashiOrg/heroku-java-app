package hr.trainInfo.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import hr.trainInfo.bean.TrainInfoBean;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@SuppressWarnings("deprecation")
public class TrainInfoNoticeServiceTest extends Assert {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	private TrainInfoNoticeService noticeService;

	@Test
	public void 新規登録確認() throws Exception {
		List<TrainInfoBean> list = noticeService.getNoticeInfomations();
		System.out.println(list);
	}

}
