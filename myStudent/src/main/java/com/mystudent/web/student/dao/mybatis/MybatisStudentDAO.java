package com.mystudent.web.student.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudent.web.student.dao.StudentDAO;
import com.mystudent.web.student.entity.StudentDTO;

@Repository
public class MybatisStudentDAO implements StudentDAO{
	
	private StudentDAO mapper;
	
	@Autowired
	public MybatisStudentDAO(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(StudentDAO.class);
	}
	
	@Override
	public List<StudentDTO> getList() {
		return mapper.getList();
	}

	@Override
	public int insert(StudentDTO dto) {
		return mapper.insert(dto);
	}
	
}
