package hr.trainInfo.util;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoBean;

@Service
public class TrainInfoUtil {
	private static final String TRAIN_INFO_URL = "https://transit.yahoo.co.jp/traininfo/area/4/";

	@Deprecated
	public static List<TrainInfoBean> getInfomations() throws Exception {
		String url = TRAIN_INFO_URL;
		Document document = Jsoup.connect(url).get();

		Element element = document.getElementById("item1")
				.parent()
				.nextElementSibling();

		Elements rows = element.select("table tr");

		List<TrainInfoBean> list = rows.stream()
			.skip(1)
			.map(e -> e.select("td"))
			.map(e -> {
				int idx = 0;
				TrainInfoBean bean = TrainInfoBean.builder()
						.line(e.get(idx++).text())
						.info(e.get(idx++).text())
						.detail(e.get(idx++).text())
						.build();
				return bean;
			})
			.collect(Collectors.toList());

		return list;
	}

	public static List<NTrainInfoNotificationBean> getNotifications() throws Exception {
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

		return list;
	}
}
