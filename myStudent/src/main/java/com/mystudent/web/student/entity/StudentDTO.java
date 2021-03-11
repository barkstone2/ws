package com.mystudent.web.student.entity;

import java.sql.Timestamp;

public class StudentDTO {
	private int no;
	private String id;
	private String name;
	private String major;
	private String grade;
	private String gender;
	private String phone;
	private String email;
	private String address;
	private Timestamp regDate;
	
	public StudentDTO() {
	}
	
	public StudentDTO(String id, String name, String major, String grade, String gender, String phone, String email,
			String address) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}



	@Override
	public String toString() {
		return "StudentDTO [no=" + no + ", id=" + id + ", name=" + name + ", major=" + major + ", grade=" + grade
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", address=" + address + ", regDate="
				+ regDate + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
}
