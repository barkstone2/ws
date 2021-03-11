package com.mystudent.web.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mystudent.web.student.entity.StudentDTO;

@Mapper
public interface StudentDAO {

	List<StudentDTO> getList();

	int insert(StudentDTO dto);

}
