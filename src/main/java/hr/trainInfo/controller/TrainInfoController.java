package hr.trainInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hr.trainInfo.bean.TrainInfoBean;
import hr.trainInfo.repository.TrainInfoNotificationRepository;
import hr.trainInfo.util.TrainInfoUtil;

@Controller
public class TrainInfoController {
	@Autowired
	TrainInfoNotificationRepository repo;

	@GetMapping("/trainInfo/info/list")
	public ModelAndView trainInfoList(ModelAndView mav) throws Exception {
		// 運行情報を取得する
		List<TrainInfoBean> list = TrainInfoUtil.getInfomations();
		mav.addObject("infoList", list);
		mav.setViewName("trainInfo/info_list");
		return mav;
	}
}
