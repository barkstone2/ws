package web.board.model;

import java.util.Date;

public class BoardDTO {
	private int no;
	private String name;
	private String title;
	private String content;
	private String pwd;
	private Date regDate;
	
	public BoardDTO() {
	}
	
	public BoardDTO(int no, String name, String title, String content, String pwd, Date regDate) {
		this.no = no;
		this.name = name;
		this.title = title;
		this.content = content;
		this.pwd = pwd;
		this.regDate = regDate;
	}
	
	public BoardDTO(String name, String title, String content, String pwd) {
		this.name = name;
		this.title = title;
		this.content = content;
		this.pwd = pwd;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
