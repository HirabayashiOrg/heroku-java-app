package hr.trainInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.bean.TrainInfoRegisterBean;
import hr.trainInfo.repository.NTrainInfoNotificationRepository;
import hr.trainInfo.service.NTrainInfoNoticeService;
import hr.trainInfo.service.TrainInfoRegisterService;

@RestController
public class TrainInfoRestController {
	@Autowired
	NTrainInfoNotificationRepository repo;

	@Autowired
	TrainInfoRegisterService registerService;

	@Autowired
	private NTrainInfoNoticeService noticeService;

	@PostMapping("/trainInfo/info/notice/reg")
	public TrainInfoRegisterBean info_notice_reg(@RequestParam("line") String line) {
		TrainInfoRegisterBean bean = registerService.register(line);

		return bean;
	}

	@GetMapping("/trainInfo/api/info/notice/list")
	public List<NTrainInfoNotificationBean> info_notice_list() {
		return repo.findAll();
	}

	@GetMapping("/trainInfo/api/info/target/list")
	public List<NTrainInfoNotificationBean> info_target_list() throws Exception {
		return noticeService.getNoticeInfomations();
	}

	@GetMapping("/trainInfo/line/notice/all")
	public List<NTrainInfoNotificationBean> notice_info() throws Exception {
		// 通知対象のリストを取得
		List<NTrainInfoNotificationBean> list = noticeService.getNoticeInfomations();
		// DBを更新
		registerService.update(list);
		return noticeService.noticeTrainInfomations(list);
	}

	@GetMapping("/trainInfo/api/notice/update")
	public List<NTrainInfoNotificationBean> noticeUpdateAPI() throws Exception {
		List<NTrainInfoNotificationBean> list = noticeService.getNoticeInfomations();
		registerService.update(list);
		return list;
	}

	@PostMapping("/trainInfo/api/notice/del")
	public String noticeDeleteAPI(@RequestParam("line") String line) throws Exception {
		return registerService.delete(line);
	}
}
