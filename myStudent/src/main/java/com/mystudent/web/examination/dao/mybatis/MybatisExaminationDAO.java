package com.mystudent.web.examination.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudent.web.examination.dao.ExaminationDAO;
import com.mystudent.web.examination.entity.ExaminationDTO;

@Repository
public class MybatisExaminationDAO implements ExaminationDAO{

	private ExaminationDAO mapper;
	
	@Autowired
	public MybatisExaminationDAO(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(ExaminationDAO.class);
	}
	
	@Override
	public int insert(ExaminationDTO examinationDTO) {
		
		return mapper.insert(examinationDTO);
	}

	@Override
	public List<ExaminationDTO> getList() {
		
		return mapper.getList();
	}

}
