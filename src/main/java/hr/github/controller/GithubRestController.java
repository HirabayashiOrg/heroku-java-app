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
import hr.line.uril.LinePushUtil;
import hr.master.bean.ErrorMessageBean;
import hr.master.repository.ErrorMessageRepository;

@RestController
public class GithubRestController {
	@Autowired
	GithubPushRepository repo;

	@Autowired
	ErrorMessageRepository errRepo;

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
		} catch (Exception e) {
			ErrorMessageBean bean = new ErrorMessageBean();
			bean.setMessage(e.getMessage());
			errRepo.saveAndFlush(bean);
		}
		repo.saveAll(beans);
		repo.flush();

		return;
	}
}
