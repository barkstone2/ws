package com.mystudent.web.score.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudent.web.score.dao.ScoreDAO;
import com.mystudent.web.score.entity.ScoreDTO;
import com.mystudent.web.score.entity.ScoreViewDTO;

@Repository
public class MybatisScoreDAO implements ScoreDAO{
	
	private ScoreDAO mapper;
	
	@Autowired
	public MybatisScoreDAO(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(ScoreDAO.class);
	}
	
	@Override
	public int insert(ScoreDTO scoreDTO) {
		return mapper.insert(scoreDTO);
	}

	@Override
	public List<ScoreViewDTO> getViewList(String studentName) {
		return mapper.getViewList(studentName);
	}

}
