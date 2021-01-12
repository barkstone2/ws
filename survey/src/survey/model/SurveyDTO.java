package survey.model;

public class SurveyDTO {
	private int no;
	private String question;
	private String select1;
	private String select2;
	private String select3;
	private String select4;
	private String status;

	public SurveyDTO() {
	}

	public SurveyDTO(int no, String question, String select1, String select2, String select3, String select4,
			String status) {
		this.no = no;
		this.question = question;
		this.select1 = select1;
		this.select2 = select2;
		this.select3 = select3;
		this.select4 = select4;
		this.status = status;
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

	public String getSelect1() {
		return select1;
	}

	public void setSelect1(String select1) {
		this.select1 = select1;
	}

	public String getSelect2() {
		return select2;
	}

	public void setSelect2(String select2) {
		this.select2 = select2;
	}

	public String getSelect3() {
		return select3;
	}

	public void setSelect3(String select3) {
		this.select3 = select3;
	}

	public String getSelect4() {
		return select4;
	}

	public void setSelect4(String select4) {
		this.select4 = select4;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
