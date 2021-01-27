package model.survey.dto;

import java.sql.Timestamp;

public class SurveyDTO {
	private int no;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private char status;
	private Timestamp start_date;
	private Timestamp end_date;
	private Timestamp regi_date;
	private int survey_counter;
	private int ans1c;
	private int ans2c;
	private int ans3c;
	private int ans4c;
	
	public SurveyDTO() {
	}

	
	
	
	public SurveyDTO(int no, String question, String ans1, String ans2, String ans3, String ans4, char status,
			Timestamp start_date, Timestamp end_date, Timestamp regi_date) {
		this.no = no;
		this.question = question;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
		this.status = status;
		this.start_date = start_date;
		this.end_date = end_date;
		this.regi_date = regi_date;
	}




	public SurveyDTO(String question, String ans1, String ans2, String ans3, String ans4, char status,
			Timestamp start_date, Timestamp end_date) {
		this.question = question;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
		this.status = status;
		this.start_date = start_date;
		this.end_date = end_date;
	}


	

	public int getAns1c() {
		return ans1c;
	}




	public void setAns1c(int ans1c) {
		this.ans1c = ans1c;
	}




	public int getAns2c() {
		return ans2c;
	}




	public void setAns2c(int ans2c) {
		this.ans2c = ans2c;
	}




	public int getAns3c() {
		return ans3c;
	}




	public void setAns3c(int ans3c) {
		this.ans3c = ans3c;
	}




	public int getAns4c() {
		return ans4c;
	}




	public void setAns4c(int ans4c) {
		this.ans4c = ans4c;
	}




	public int getSurvey_counter() {
		return survey_counter;
	}

	public void setSurvey_counter(int survey_counter) {
		this.survey_counter = survey_counter;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public Timestamp getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(Timestamp regi_date) {
		this.regi_date = regi_date;
	}
	
	
	
}
