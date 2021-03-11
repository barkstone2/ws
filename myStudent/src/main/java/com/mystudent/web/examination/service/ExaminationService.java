package com.mystudent.web.examination.service;

import java.util.List;

import com.mystudent.web.examination.entity.ExaminationDTO;

public interface ExaminationService {

	int insert(ExaminationDTO examinationDTO);

	List<ExaminationDTO> getList();

}
