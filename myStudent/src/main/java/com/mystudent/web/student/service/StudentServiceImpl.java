package com.mystudent.web.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudent.web.student.dao.StudentDAO;
import com.mystudent.web.student.entity.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<StudentDTO> getList() {
		return studentDAO.getList();
	}

	@Override
	public int insert(StudentDTO dto) {
		return studentDAO.insert(dto);
	}

}
