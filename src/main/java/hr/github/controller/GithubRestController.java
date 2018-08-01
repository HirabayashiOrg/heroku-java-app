package hr.github.controller;

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

	@RequestMapping("/github/webhook")
	public Object webhook(@RequestBody String body) {
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
