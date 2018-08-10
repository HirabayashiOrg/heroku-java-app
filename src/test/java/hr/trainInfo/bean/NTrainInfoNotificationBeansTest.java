package hr.trainInfo.bean;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NTrainInfoNotificationBeansTest extends Assert{
	@Test
	public void isSameInfoテスト１() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 一致データ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		assertTrue(NTrainInfoNotificationBeans.isSameInfo(bean1, bean2));
	}
	@Test
	public void isSameInfoテスト２() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 路線だけ違うデータ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line2")
				.info("info1")
				.build();
		assertFalse(NTrainInfoNotificationBeans.isSameInfo(bean1, bean2));
	}
	@Test
	public void isSameInfoテスト３() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 運行情報だけ違うデータ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info2")
				.build();
		assertFalse(NTrainInfoNotificationBeans.isSameInfo(bean1, bean2));
	}
	@Test
	public void isSameInfoテスト４() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 路線も運行情報も違うデータ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line2")
				.info("info2")
				.build();
		assertFalse(NTrainInfoNotificationBeans.isSameInfo(bean1, bean2));
	}

	@Test
	public void isSameLineDiffInfoテスト１() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 一致データ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		assertFalse(NTrainInfoNotificationBeans.isSameLineDiffInfo(bean1, bean2));
	}
	@Test
	public void isSameLineDiffInfoテスト２() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 路線だけ違うデータ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line2")
				.info("info1")
				.build();
		assertFalse(NTrainInfoNotificationBeans.isSameLineDiffInfo(bean1, bean2));
	}
	@Test
	public void isSameLineDiffInfoテスト３() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 運行情報だけ違うデータ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info2")
				.build();
		assertTrue(NTrainInfoNotificationBeans.isSameLineDiffInfo(bean1, bean2));
	}
	@Test
	public void isSameLineDiffInfoテスト４() {
		// 比較元
		NTrainInfoNotificationBean bean1 = NTrainInfoNotificationBean.builder()
				.line("line1")
				.info("info1")
				.build();
		// 路線も運行情報も違うデータ
		NTrainInfoNotificationBean bean2 = NTrainInfoNotificationBean.builder()
				.line("line2")
				.info("info2")
				.build();
		assertFalse(NTrainInfoNotificationBeans.isSameLineDiffInfo(bean1, bean2));
	}
	@Test
	public void Line用メッセージ作成テスト１() {
		NTrainInfoNotificationBean bean = NTrainInfoNotificationBean.builder()
				.line("南武線")
				.info("平常運行")
				.build();
		System.out.println(NTrainInfoNotificationBeans.createMessage(bean));
	}
	@Test
	public void Line用メッセージ作成テスト２() {
		List<NTrainInfoNotificationBean> list = new ArrayList<NTrainInfoNotificationBean>();
		NTrainInfoNotificationBean bean = NTrainInfoNotificationBean.builder()
				.line("南武線")
				.info("平常運行")
				.build();
		list.add(bean);
		list.add(bean);
		System.out.println(NTrainInfoNotificationBeans.createMessage(list));
	}
}
