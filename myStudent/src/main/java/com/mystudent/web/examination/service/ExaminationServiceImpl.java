package com.mystudent.web.examination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudent.web.examination.dao.ExaminationDAO;
import com.mystudent.web.examination.entity.ExaminationDTO;

@Service
public class ExaminationServiceImpl implements ExaminationService{
	
	@Autowired
	private ExaminationDAO examinationDAO;
	
	@Override
	public int insert(ExaminationDTO examinationDTO) {
		
		
		return examinationDAO.insert(examinationDTO);
	}

	@Override
	public List<ExaminationDTO> getList() {
		
		return examinationDAO.getList();
	}

}
