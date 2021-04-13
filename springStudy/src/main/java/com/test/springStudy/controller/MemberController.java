package com.test.springStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	
	@GetMapping("index")
	public String index(Model model) {
		
		model.addAttribute("viewAttr", "member/index.jsp");
		
		return "main/main";
	}
}
