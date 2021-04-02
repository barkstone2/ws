package com.test.spring01.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.spring01.member.dao.MemberDAO;
import com.test.spring01.member.entity.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@GetMapping("aa")
	public String aa() {
		String id = "aa";
		List<MemberDTO> list = memberDAO.getList();
		MemberDTO dto = memberDAO.getView(id);
		
		return "aa";
	}
}
