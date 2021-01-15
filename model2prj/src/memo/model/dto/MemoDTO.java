package memo.model.dto;

public class MemoDTO {
	private int no;
	private String writer;
	private String content;
	private String regi_date;
	
	public MemoDTO() {
	}

	
	
	
	
	public MemoDTO(int no, String writer, String content, String regi_date) {
		super();
		this.no = no;
		this.writer = writer;
		this.content = content;
		this.regi_date = regi_date;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(String regi_date) {
		this.regi_date = regi_date;
	}
	
	
}
