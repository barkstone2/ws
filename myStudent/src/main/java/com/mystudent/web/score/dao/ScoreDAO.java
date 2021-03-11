package com.mystudent.web.score.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mystudent.web.score.entity.ScoreDTO;
import com.mystudent.web.score.entity.ScoreViewDTO;

@Mapper
public interface ScoreDAO {

	int insert(ScoreDTO scoreDTO);

	List<ScoreViewDTO> getViewList(String studentName);

}
