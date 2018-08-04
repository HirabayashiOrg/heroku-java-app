package hr.trainInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.trainInfo.bean.TrainInfoBean;
import hr.trainInfo.bean.TrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoRegisterBean;
import hr.trainInfo.repository.TrainInfoNotificationRepository;
import hr.trainInfo.service.TrainInfoNoticeService;
import hr.trainInfo.service.TrainInfoRegisterService;

@RestController
public class TrainInfoRestController {
	@Autowired
	TrainInfoNotificationRepository repo;

	@Autowired
	TrainInfoRegisterService registerService;

	@Autowired
	private TrainInfoNoticeService noticeService;

	@PostMapping("/trainInfo/info/notice/reg")
	public TrainInfoRegisterBean info_notice_reg(@RequestParam("line") String line) {
		TrainInfoRegisterBean bean = registerService.register(line);

		return bean;
	}

	@GetMapping("/trainInfo/api/info/notice/list")
	public List<TrainInfoNotificationBean> info_notice_list() {
		return repo.findAll();
	}

	@GetMapping("/trainInfo/api/info/target/list")
	public List<TrainInfoBean> info_target_list() throws Exception {
		return noticeService.getNoticeInfomations();
	}
}
