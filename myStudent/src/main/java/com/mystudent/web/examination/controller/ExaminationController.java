package com.mystudent.web.examination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mystudent.web.examination.entity.ExaminationDTO;
import com.mystudent.web.examination.service.ExaminationService;

@Controller
@RequestMapping("/examination/")
public class ExaminationController {
	
	@Autowired
	private ExaminationService examinationService;
	
	@GetMapping("list")
	public String list(Model model) {
		
		List<ExaminationDTO> list = examinationService.getList();
		
		model.addAttribute("list", list);
		
		return "examination.list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "examination.reg";
	}
	
	@PostMapping("reg")
	public String reg(String name, String type, Model model) {
		
		ExaminationDTO examinationDTO = new ExaminationDTO(name, type);
		int result = examinationService.insert(examinationDTO);
		String msg = "";
		String reUrl = "/examination/list";
		
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
