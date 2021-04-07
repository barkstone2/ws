package com.test.spring01.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.spring01.member.entity.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(MemberDTO dto) {
		return sqlSession.insert("member.insert", dto);
	}

	@Override
	public List<MemberDTO> getList() {
		return sqlSession.selectList("member.getList");
	}

	@Override
	public MemberDTO getView(String id) {
		return sqlSession.selectOne("member.getView", id);
	}

}
