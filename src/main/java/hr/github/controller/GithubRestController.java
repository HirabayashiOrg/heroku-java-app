package hr.github.controller;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.github.bean.GithubTmpBean;
import hr.github.repository.GithubRepository;
import hr.github.util.CommitUtil;

@RestController
public class GithubRestController {
	@Autowired
	GithubRepository repo;

	@RequestMapping("/github/webhook/push")
	public Object webhook(@RequestBody String body) {
		String commitStr = "";
		List<String> commits = new ArrayList<String>();
		// jsonデータをマップにバインド
		try {
			JSONObject json = new JSONObject(body);

			commits = CommitUtil.getCimmitIdList(body);

			String url = json.getString("commits_url");
			url = url.replaceAll("{.*}", "");
			commitStr = url;

			URL urlObj = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlObj.openConnection();
	        http.setRequestMethod("GET");
	        http.connect();

	        InputStream is = http.getInputStream();
		} catch (Exception e) {
			commitStr = e.getMessage();
		}

		GithubTmpBean obj = new GithubTmpBean();
		obj.setBody(body);

		repo.saveAndFlush(obj);

		return new Object() {
			private String result = "ok";

			public String getResult() {
				return this.result;
			}
		};
	}
}
