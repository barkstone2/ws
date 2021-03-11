package com.mystudent.web.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudent.web.score.dao.ScoreDAO;
import com.mystudent.web.score.entity.ScoreDTO;
import com.mystudent.web.score.entity.ScoreViewDTO;

@Service
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreDAO scoreDAO;
	
	@Override
	public int insert(ScoreDTO scoreDTO) {
		return scoreDAO.insert(scoreDTO);
	}

	@Override
	public List<ScoreViewDTO> getViewList(String studentName) {
		return scoreDAO.getViewList(studentName);
	}

}
