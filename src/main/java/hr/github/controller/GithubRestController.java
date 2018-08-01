package hr.github.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hr.github.bean.GithubTmpBean;
import hr.github.repository.GithubRepository;

@RestController
public class GithubRestController {
	@Autowired
	GithubRepository repo;

	@RequestMapping("/github/webhook/push")
	public Object webhook(@RequestBody String body) {
		// jsonデータをマップにバインド
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			map = mapper.readValue(
					body,
					new TypeReference<LinkedHashMap<String, Object>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}

		String commitStr = "";
		commitStr = map.get("commits").toString();

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
