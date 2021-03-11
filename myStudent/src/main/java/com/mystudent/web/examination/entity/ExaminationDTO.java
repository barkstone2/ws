package com.mystudent.web.examination.entity;

import java.sql.Timestamp;

public class ExaminationDTO {
	private int no;
	private String name;
	private String type;
	private Timestamp regDate;
	
	public ExaminationDTO() {
	}

	public ExaminationDTO(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ExaminationDTO [no=" + no + ", name=" + name + ", type=" + type + ", regDate=" + regDate + "]";
	}
	
	
}
