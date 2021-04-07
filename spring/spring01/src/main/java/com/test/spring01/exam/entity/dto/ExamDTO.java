package com.test.spring01.exam.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExamDTO {
	private int no;
	private String name;
	private String jumin;
	private String gender;
	private int age;
	private String regDate;
	
}
