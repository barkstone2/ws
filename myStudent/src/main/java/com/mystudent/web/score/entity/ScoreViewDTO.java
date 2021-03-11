package com.mystudent.web.score.entity;

public class ScoreViewDTO extends ScoreDTO{
	private String studentName;
	private String examType;
	private String examName;
	
	public ScoreViewDTO() {
	}

	public ScoreViewDTO(String studentId, int examNo, int score, String studentName,
			String examType, String examName) {
		super(studentId, examNo, score);
		this.studentName = studentName;
		this.examType = examType;
		this.examName = examName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "ScoreViewDTO [studentName=" + studentName + ", examType=" + examType + ", examName=" + examName
				+ ", getNo()=" + getNo() + ", getStudentId()=" + getStudentId() + ", getExamNo()=" + getExamNo()
				+ ", getScore()=" + getScore() + ", getRegDate()=" + getRegDate() + "]";
	}

	
	
	
}
