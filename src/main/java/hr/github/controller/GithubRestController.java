package hr.github.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.github.bean.GithubTmpBean;
import hr.github.repository.GithubRepository;

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
			JSONArray json_ary = json.getJSONArray("commits");
			for(int i=0; i < json_ary.length(); i++) {
				JSONObject json_obj = json_ary.getJSONObject(i);
				commits.add(json_obj.getString("id"));
			}

			commitStr += json.getJSONObject("comments_url");

		} catch (JSONException e) {
			e.printStackTrace();
		}

		GithubTmpBean obj = new GithubTmpBean();
		obj.setBody(commitStr);

		repo.saveAndFlush(obj);

		return new Object() {
			private String result = "ok";

			public String getResult() {
				return this.result;
			}
		};
	}
}
