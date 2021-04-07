package com.test.spring01.exam.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.spring01.exam.entity.dto.ExamDTO;

@Repository
public class ExamDAOImpl implements ExamDAO{

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(ExamDTO dto) {
		return sqlSession.insert("exam.insert");
	}

}
