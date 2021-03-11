package com.mystudent.web.examination.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mystudent.web.examination.entity.ExaminationDTO;

@Mapper
public interface ExaminationDAO {

	int insert(ExaminationDTO examinationDTO);

	List<ExaminationDTO> getList();

}
