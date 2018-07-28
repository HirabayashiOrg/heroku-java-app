package hr.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
