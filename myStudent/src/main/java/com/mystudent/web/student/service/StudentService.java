package com.mystudent.web.student.service;

import java.util.List;

import com.mystudent.web.student.entity.StudentDTO;

public interface StudentService {


	int insert(StudentDTO dto);

	List<StudentDTO> getList();


}
