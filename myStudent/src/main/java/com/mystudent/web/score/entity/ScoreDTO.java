package com.mystudent.web.score.entity;

import java.sql.Timestamp;

public class ScoreDTO {
	private int no;
	private String studentId;
	private int examNo;
	private int score;
	private Timestamp regDate;
	
	public ScoreDTO() {
	}

	public ScoreDTO(String studentId, int examNo, int score) {
		this.studentId = studentId;
		this.examNo = examNo;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getExamNo() {
		return examNo;
	}

	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ScroeDTO [no=" + no + ", studentId=" + studentId + ", examNo=" + examNo + ", score=" + score
				+ ", regDate=" + regDate + "]";
	}
	
	
	
}
