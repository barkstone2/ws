package com.test.spring01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Test01Controller {

	@RequestMapping("/test01.do")
	public String test01() {
		
		return "/test01/exam01";
	}
	
	@RequestMapping("/test01Proc.do")
	public String test01Proc(String name, 
			@RequestParam(defaultValue = "XXX") String jumin, 
			@RequestParam(defaultValue = "F") String gender, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		model.addAttribute("gender", gender);
	
		return "/test01/exam01Result";
	}
	
	@RequestMapping("/test02.do")
	public String test02() {
		
		return "/test02/exam01";
	}
	
	@RequestMapping("/test02Proc.do")
	public String test02Proc(String name, 
			@RequestParam(defaultValue = "XXX") String jumin, 
			@RequestParam(defaultValue = "F") String gender, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		model.addAttribute("gender", gender);
	
		return "/test02/exam01Result";
	}
	
	@RequestMapping("/test03.do")
	public String test03() {
		
		return "/test03/exam01";
	}
	
	@RequestMapping("/test03Proc.do")
	public String test03Proc(
			String name, 
			@RequestParam(defaultValue = "XXX") String jumin, 
			@RequestParam(defaultValue = "F") String gender,
			String age, 
			HttpServletRequest request,
			Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		model.addAttribute("gender", gender);
		model.addAttribute("age", age);
	
		return "/test03/exam01Result";
	}
	
	@RequestMapping("/test04.do")
	public String test04() {
		
		return "/test04/exam01";
	}
	
	@RequestMapping("/test04Proc.do")
	public String test04Proc(
			@ModelAttribute Test04DTO dto, 
			Model model) {
		
		
		model.addAttribute("name", dto.getName());
		model.addAttribute("jumin", dto.getJumin());
		model.addAttribute("gender", dto.getGender());
		model.addAttribute("age", dto.getAge());
	
		return "/test04/exam01Result";
	}

	@RequestMapping("/test05.do")
	public String test05() {
		
		return "/test05/exam01";
	}
	
	@RequestMapping("/test05Proc.do")
	public String test05Proc(
			@ModelAttribute Test05DTO dto, 
			Model model) {
		
		model.addAttribute("name",dto.getName());
		model.addAttribute("kor",dto.getKor());
		model.addAttribute("eng",dto.getEng());
		model.addAttribute("mat",dto.getMat());
		model.addAttribute("sci",dto.getSci());
		model.addAttribute("his",dto.getHis());
		dto.setTot();
		dto.setAvg();
		model.addAttribute("tot",dto.getTot());
		model.addAttribute("avg",dto.getAvg());
		
		return "/test05/exam01Result";
	}
	
}
