package hr.verify;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupVerify {
	private final String TRAIN_INFO_URL = "https://transit.yahoo.co.jp/traininfo/area/4/";

	@Test
	public void 動作検証() throws Exception {
		String url = TRAIN_INFO_URL;
		Document document = Jsoup.connect(url).get();

		// System.out.println(document.html());
	}

	@Test
	public void JR東日本のタイトルを取得する() throws Exception {
		String url = TRAIN_INFO_URL;
		Document document = Jsoup.connect(url).get();

		Element element = document.getElementById("item1");

		assertEquals("JR東日本", element.html());
	}

	@Test
	public void JR東日本の路線一覧を取得する() throws Exception {
		String url = TRAIN_INFO_URL;
		Document document = Jsoup.connect(url).get();

		Element element = document.getElementById("item1")
				.parent()
				.nextElementSibling();

		Elements rows = element.select("table tr");

		assertTrue(rows.html().contains("南武線"));
	}
}

