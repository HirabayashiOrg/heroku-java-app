package hr.trainInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hr.trainInfo.bean.NTrainInfoNotificationBean;
import hr.trainInfo.service.NTrainInfoNoticeService;
import hr.trainInfo.util.TrainInfoUtil;

@Controller
public class TrainInfoController {
	@Autowired
	private NTrainInfoNoticeService noticeService;

	@GetMapping("/trainInfo/info/list")
	public ModelAndView trainInfoList(ModelAndView mav) throws Exception {
		// 運行情報を取得する
		List<NTrainInfoNotificationBean> list = TrainInfoUtil.getNotifications();
		mav.addObject("infoList", list);
		mav.setViewName("trainInfo/info_list");
		return mav;
	}

	@GetMapping("/trainInfo/info/target/list")
	public ModelAndView trainInfoTargetList(ModelAndView mav) throws Exception {
		// 運行情報を取得する
		List<NTrainInfoNotificationBean> list = noticeService.getNoticeInfomations();
		mav.addObject("infoList", list);
		mav.setViewName("trainInfo/info_list");
		return mav;
	}
}
