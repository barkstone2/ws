package com.test.spring01.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
	
	@RequestMapping("/test06.do")
	public String test06() {
		
		return "/test06/exam01";
	}
	
	@RequestMapping("/test06Proc.do")
	public String test06Proc(
			@ModelAttribute Test06VO vo, 
			Model model) {
		
		vo.setDcPrice();
		model.addAttribute("vo", vo);
		
		return "/test06/exam01Result";
	}
	
	@RequestMapping("/test07.do")
	public String test07() {
		
		return "/test07/exam01";
	}
	
	@RequestMapping("/test07Proc.do")
	public ModelAndView test07Proc(
			@ModelAttribute Test06VO vo, 
			ModelAndView mv) {
		
		vo.setDcPrice();
		mv.setViewName("/test07/exam01Result");
		mv.addObject("vo", vo);
		return mv;
	}
	
	@RequestMapping("/test08.do")
	public String test08() {
		
		return "/test08/exam01";
	}
	
	@RequestMapping("/test08Proc.do")
	public String test08Proc(String id, String pwd,
			Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		
		return "/test08/exam01Result";
	}
	
	@RequestMapping("/test09.do")
	public String test09() {
		
		return "/test09/exam01";
	}
	
	@RequestMapping("/test09Proc.do")
	@ResponseBody
	public String test09Proc(String id, String pwd, String email,
			Model model) {
		return "id: " + id + "<br>pwd: " + pwd + "<br>email: " + email;
	}
}
