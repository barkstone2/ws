package memo.model.dto;

import java.sql.Timestamp;

public class MemoDTO {
	private int no;
	private String id;
	private String content;
	private Timestamp regi_date;
	
	public MemoDTO() {
	}

	public MemoDTO(int no, String id, String content, Timestamp regi_date) {
		this.no = no;
		this.id = id;
		this.content = content;
		this.regi_date = regi_date;
	}

	public MemoDTO(String id, String content) {
		this.id = id;
		this.content = content;
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

	public void setid(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegi_date() {
		return regi_date;
	}

	public void setRegi_Date(Timestamp regi_date) {
		this.regi_date = regi_date;
	}
	
	
	
}
