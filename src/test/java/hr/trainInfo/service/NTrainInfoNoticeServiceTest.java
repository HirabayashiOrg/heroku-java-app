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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import hr.trainInfo.bean.NTrainInfoNotificationBean;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NTrainInfoNoticeServiceTest extends Assert {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	private NTrainInfoNoticeService noticeService;

	@Test
	public void 通知対象リスト取得() throws Exception {
		List<NTrainInfoNotificationBean> list = noticeService.getNoticeInfomations();
		System.out.println(list);
	}
	@Test
	public void テスト通知ー通知あり() throws Exception {
		List<NTrainInfoNotificationBean> list = new ArrayList<NTrainInfoNotificationBean>();
		NTrainInfoNotificationBean bean = NTrainInfoNotificationBean.builder()
				.line("南武線[川崎～立川]")
				.info("テスト")
				.build();
		list.add(bean);

		noticeService.noticeTrainInfomations(list);
	}
	@Test
	public void テスト通知ー通知なし() throws Exception {
		List<NTrainInfoNotificationBean> list = new ArrayList<NTrainInfoNotificationBean>();
		noticeService.noticeTrainInfomations(list);
	}
}
