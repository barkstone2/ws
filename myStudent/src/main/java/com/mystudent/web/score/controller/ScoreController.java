package com.mystudent.web.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mystudent.web.examination.entity.ExaminationDTO;
import com.mystudent.web.examination.service.ExaminationService;
import com.mystudent.web.score.entity.ScoreDTO;
import com.mystudent.web.score.entity.ScoreViewDTO;
import com.mystudent.web.score.service.ScoreService;
import com.mystudent.web.student.entity.StudentDTO;
import com.mystudent.web.student.service.StudentService;

@Controller
@RequestMapping("/score/")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private ExaminationService examinationService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("list")
	public String list(String studentName, Model model) {
		
		List<ScoreViewDTO> list = scoreService.getViewList(studentName);
		
		model.addAttribute("list", list);
		
		return "score.list";
	}
	
	@GetMapping("search")
	public String search(Model model) {
		
		List<StudentDTO> list = studentService.getList();
		
		model.addAttribute("list", list);
		
		return "score.search";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		List<StudentDTO> studentList = studentService.getList();
		List<ExaminationDTO> examList = examinationService.getList();
		model.addAttribute("examList", examList);
		model.addAttribute("studentList", studentList);
		
		
		return "score.reg";
	}
	
	@PostMapping("reg")
	public String reg(String studentId, int examNo, int score, Model model) {
		ScoreDTO scoreDTO = new ScoreDTO(studentId, examNo, score);
		int result = scoreService.insert(scoreDTO);
		String msg = "";
		String reUrl = "/score/search";
		
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
