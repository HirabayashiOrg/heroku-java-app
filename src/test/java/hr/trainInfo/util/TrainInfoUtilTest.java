package hr.trainInfo.util;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoBean;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrainInfoUtilTest extends Assert {
	private static final String TRAIN_INFO_URL = "https://transit.yahoo.co.jp/traininfo/area/4/";

	@Rule
	public ExpectedException exceptedException = ExpectedException.none();

	@Test
	public void 運行情報リスト取得() throws Exception {
		@SuppressWarnings("deprecation")
		List<TrainInfoBean> list = TrainInfoUtil.getInfomations();
		// list.forEach(System.out::println);

		boolean bool = list.stream()
			.anyMatch(bean -> bean.getLine().equals("南武線[川崎～立川]"));
		assertTrue(bool);
	}

	@Test
	public void 運行情報リスト取得検証用() throws Exception {
		String url = TRAIN_INFO_URL;
		Document document = Jsoup.connect(url).get();

		Element element = document.getElementById("item1")
				.parent()
				.nextElementSibling();

		Elements rows = element.select("table tr");

		List<NTrainInfoNotificationBean> list = rows.stream()
			.skip(1)
			.map(e -> e.select("td"))
			.map(e -> {
				int idx = 0;
				NTrainInfoNotificationBean bean = NTrainInfoNotificationBean.builder()
						.url(e.select("a").get(0).attr("href"))
						.line(e.get(idx++).text())
						.name("all")
						.info(e.get(idx++).text())
						.detail(e.get(idx++).text())
						.build();
				return bean;
			})
			.collect(Collectors.toList());

		list.forEach(System.out::println);
	}
}
