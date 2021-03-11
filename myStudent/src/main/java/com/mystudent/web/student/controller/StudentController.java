package com.mystudent.web.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mystudent.web.student.entity.StudentDTO;
import com.mystudent.web.student.service.StudentService;

@Controller
@RequestMapping("/student/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("reg")
	public String reg() {
	
		return "student.reg";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<StudentDTO> list = studentService.getList();
		model.addAttribute("list",list);
		return "student.list";
	}
	
	@PostMapping("reg")
	public String reg(String id, String name, String major, String grade, String gender, 
			String phone, String email, String address, Model model) {
		
		StudentDTO dto = new StudentDTO(id, name, major, grade, gender, phone, email, address);
		int result = studentService.insert(dto);
		
		String msg = "";
		String reUrl = "/student/list";
		
		if(result>0) {
			msg = "작성 성공";
		}else {
			msg = "작성 실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("reUrl", reUrl);
		
		return "/util/message";
	}
	
	
	
}
