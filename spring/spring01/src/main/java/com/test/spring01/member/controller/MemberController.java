package com.test.spring01.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.spring01.member.dao.MemberDAO;
import com.test.spring01.member.entity.MemberDTO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@GetMapping("list")
	public String list(Model model) {
		
		List<MemberDTO> list = memberDAO.getList();
		model.addAttribute("list", list);
		return "member/list";
	}
	
	@GetMapping("view")
	public String view(String id, Model model) {
		
		MemberDTO dto = memberDAO.getView(id);
		model.addAttribute("dto", dto);
		return "member/view";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "member/reg";
	}
	
	@PostMapping("reg")
	public String reg(String id, String pw, String name, String email, Model model) {
		
		MemberDTO dto = MemberDTO.builder()
				.id(id)
				.pw(pw)
				.name(name)
				.email(email).build();
		
		memberDAO.insert(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("modify")
	public String modify(String id, Model model) {
		
		MemberDTO dto = memberDAO.getView(id);
		model.addAttribute("dto", dto);
		return "member/modify";
	}
	
	@GetMapping("delete")
	public String delete(String id, Model model) {
		
		MemberDTO dto = memberDAO.getView(id);
		model.addAttribute("dto", dto);
		return "member/delete";
	}
	
}
