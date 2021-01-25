package model.survey.dto;

import java.sql.Timestamp;

public class SurveyAnswerDTO {
	private int answer_no;
	private int no;
	private int answer;
	private Timestamp regi_date;
	
	
	public SurveyAnswerDTO() {
	}
	
	public Timestamp getRegi_date() {
		return regi_date;
	}
	
	public void setRegi_date(Timestamp regi_date) {
		this.regi_date = regi_date;
	}

	public int getAnswer_no() {
		return answer_no;
	}

	public void setAnswer_no(int answer_no) {
		this.answer_no = answer_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	
}
