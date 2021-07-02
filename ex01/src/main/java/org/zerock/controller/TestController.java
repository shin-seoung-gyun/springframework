package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.TestDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/test/*")
@Log4j
public class TestController {

	@RequestMapping("quiz1")
	public void quiz1() {
	}
	
	@RequestMapping("login")
	public void login(TestDTO td, Model model) {
		if(td.getId().equals("admin") && td.getPw().equals("1234")) {
			model.addAttribute("result",1);
		}else {
			model.addAttribute("result",0);
		}
		
		
	}
	
	
}
