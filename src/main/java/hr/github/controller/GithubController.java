package hr.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hr.github.bean.GithubPushBean;
import hr.github.repository.GithubPushRepository;

@RestController
public class GithubController {
	@Autowired
	GithubPushRepository repo;

	@GetMapping("/github/pushes")
	public ModelAndView pushes(ModelAndView mav) {
		List<GithubPushBean> pushes = repo.findAll();

		mav.setViewName("github/push_history");
		mav.addObject("pushes", pushes);

		return mav;
	}

	@GetMapping("/github/push/chart")
	public ModelAndView pushChart(ModelAndView mav) {
		List<GithubPushBean> pushes = repo.findAll();

		mav.setViewName("github/v_push");
		mav.addObject("pushes", pushes);

		return mav;
	}
}
