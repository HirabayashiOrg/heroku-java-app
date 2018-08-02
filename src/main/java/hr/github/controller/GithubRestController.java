package hr.github.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.github.bean.GithubPushBean;
import hr.github.repository.GithubPushRepository;
import hr.github.util.CommitUtil;

@RestController
public class GithubRestController {
	@Autowired
	GithubPushRepository repo;

	@RequestMapping("/github/webhook/push")
	public void webhook(@RequestBody String body) {
		String commitStr = "";
		List<String> commits = new ArrayList<String>();
		List<GithubPushBean> beans = new ArrayList<GithubPushBean>();

		// jsonデータをマップにバインド
		try {
			JSONObject json = new JSONObject(body);
			// コミット番号を取得
			commits = CommitUtil.getCimmitIdList(body);
			// コミット取得APIのURLを生成
			String url = CommitUtil.getCommitUrl(body);
			// String jsondata = CommitUtil.getAPIData(url);

			for(String commit: commits) {
				String json_commit = CommitUtil.getAPIData(url + "commit");
				JSONObject json_obj_commit = new JSONObject(json_commit);
				String total     = json_obj_commit.getJSONObject("stats").getString("total");
				String addtions  = json_obj_commit.getJSONObject("stats").getString("additions");
				String deletions = json_obj_commit.getJSONObject("stats").getString("deletions");

				GithubPushBean bean = new GithubPushBean();
				bean.setTotal(Integer.parseInt(total));
				bean.setAdditions(Integer.parseInt(addtions));
				bean.setDeletions(Integer.parseInt(deletions));
				beans.add(bean);
			}
		} catch (Exception e) {
			commitStr = e.getMessage();
		}
		repo.saveAll(beans);

		return;
	}
}
