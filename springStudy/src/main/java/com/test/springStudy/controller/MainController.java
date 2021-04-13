package com.test.springStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("viewAttr", "main/main_sub.jsp");
		return "/main/main";
	}
}
