package com.gb.model.dto;

public class GuestBookDTO {
	private int no;
	private String name;
	private String email;
	private String passwd;
	private String content;
	private String write_date;
	
	public GuestBookDTO() {
	}

	
	public GuestBookDTO(int no, String name, String email, String passwd, String content, String write_date) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.content = content;
		this.write_date = write_date;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	
	
}
