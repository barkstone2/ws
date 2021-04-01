package com.test.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "홍길동님");
		model.addAttribute("msg", "안녕하세요?");
		return "index";
	}
	
}
