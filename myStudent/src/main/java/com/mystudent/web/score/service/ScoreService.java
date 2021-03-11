package com.mystudent.web.score.service;

import java.util.List;

import com.mystudent.web.score.entity.ScoreDTO;
import com.mystudent.web.score.entity.ScoreViewDTO;

public interface ScoreService {

	int insert(ScoreDTO scoreDTO);

	List<ScoreViewDTO> getViewList(String studentName);

}
