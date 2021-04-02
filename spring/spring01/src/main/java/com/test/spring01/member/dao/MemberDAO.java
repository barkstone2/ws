package com.test.spring01.member.dao;

import java.util.List;

import com.test.spring01.member.entity.MemberDTO;

public interface MemberDAO {
	int insert(MemberDTO dto);

	List<MemberDTO> getList();

	MemberDTO getView(String id);
}
