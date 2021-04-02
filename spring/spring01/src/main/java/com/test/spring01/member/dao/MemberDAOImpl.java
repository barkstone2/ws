package com.test.spring01.member.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.test.spring01.member.entity.MemberDTO;

@Component
public class MemberDAOImpl implements MemberDAO{

	
	public MemberDAOImpl() {
	}
	
	@Override
	public int insert(MemberDTO dto) {
		return 0;
	}

	@Override
	public List<MemberDTO> getList() {
		return null;
	}

	@Override
	public MemberDTO getView(String id) {
		return null;
	}

}
