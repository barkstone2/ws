package com.test.spring01.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.spring01.exam.dao.ExamDAO;
import com.test.spring01.exam.entity.dto.ExamDTO;

@Controller
@RequestMapping("/exam/")
public class ExamController {
	
	@Autowired
	private ExamDAO examDAO;
	
	@GetMapping("reg")
	public String reg() {
		
		return "exam/reg";
	}
	
	@PostMapping("reg")
	public String reg(String name, String jumin1, String jumin2) {
		String gender = jumin2.substring(0,1);
		if(gender.equals("1")||gender.equals("3")) {
			gender = "남자";
		}else if(gender.equals("2")||gender.equals("4")) {
			gender = "여자";
		}
		String bornStr = jumin1.substring(0, 2);
		int bornYear = Integer.parseInt(bornStr);
		if(bornYear<=21) {
			bornYear = Integer.parseInt("20"+bornStr);
		}else {
			bornYear = Integer.parseInt("19"+bornStr);
		}
		int age = 2021 - bornYear + 1;
		
		ExamDTO dto = ExamDTO.builder()
				.name(name)
				.jumin(jumin1+"-"+jumin2)
				.gender(gender)
				.age(age).build();
		
		examDAO.insert(dto);
		
		return "redirect:list";
	}
	
	
}
