package hr.trainInfo.util;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hr.trainInfo.bean.TrainInfoBean;

public class TrainInfoUtil {
	private static final String TRAIN_INFO_URL = "https://transit.yahoo.co.jp/traininfo/area/4/";

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
}