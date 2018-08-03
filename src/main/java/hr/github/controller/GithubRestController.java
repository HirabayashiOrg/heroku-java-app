package hr.github.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.github.bean.GithubPushBean;
import hr.github.bean.GithubPushViewBean;
import hr.github.repository.GithubPushRepository;
import hr.github.repository.GithubPushViewRepository;
import hr.github.util.CommitUtil;
import hr.line.uril.LinePushUtil;
import hr.master.repository.ErrorMessageRepository;

@RestController
public class GithubRestController {
	@Autowired
	GithubPushRepository repo;

	@Autowired
	GithubPushViewRepository repo_v;

	@Autowired
	ErrorMessageRepository errRepo;

	@RequestMapping("/github/webhook/push")
	public int webhook(@RequestBody String body) throws Exception {
		String commitStr = "";
		List<String> commits = new ArrayList<String>();
		List<GithubPushBean> beans = new ArrayList<GithubPushBean>();

		// jsonデータをマップにバインド
		JSONObject json = new JSONObject(body);
		// コミット番号を取得
		commits = CommitUtil.getCimmitIdList(body);
		// コミット取得APIのURLを生成
		String url = CommitUtil.getCommitUrl(body);
		// String jsondata = CommitUtil.getAPIData(url);

		for(String commit: commits) {
			String json_commit = CommitUtil.getAPIData(url + commit);
			JSONObject json_obj_commit = new JSONObject(json_commit);
			int total     = json_obj_commit.getJSONObject("stats").getInt("total");
			int addtions  = json_obj_commit.getJSONObject("stats").getInt("additions");
			int deletions = json_obj_commit.getJSONObject("stats").getInt("deletions");

			GithubPushBean bean = new GithubPushBean();
			bean.setTotal(total);
			bean.setAdditions(addtions);
			bean.setDeletions(deletions);
			beans.add(bean);
			// Lineに通知する
			LinePushUtil.sendMessage(LinePushUtil.TO_RYO, bean.toString());
		}
		repo.saveAll(beans);
		repo.flush();

		return 200;
	}

	@GetMapping("/github/api/t/github_push")
	public List<GithubPushBean> commit() {
		return repo.findAll();
	}

	@GetMapping("/github/api/v/github_push")
	public List<GithubPushViewBean> v_github_push__findAll() {
		return repo_v.findAll();
	}
}
