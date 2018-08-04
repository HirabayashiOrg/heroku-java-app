package hr.trainInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hr.trainInfo.bean.TrainInfoRegisterBean;
import hr.trainInfo.repository.TrainInfoNotificationRepository;
import hr.trainInfo.service.TrainInfoRegisterService;

@Controller
public class TrainInfoRestController {
	@Autowired
	TrainInfoNotificationRepository repo;

	@Autowired
	TrainInfoRegisterService registerService;

	@PostMapping("/trainInfo/info/notice/reg")
	public TrainInfoRegisterBean info_notice_reg(@RequestParam("line") String line) {
		TrainInfoRegisterBean bean = registerService.register(line);

		return bean;
	}
}
