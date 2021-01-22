package model.guestbook.dto;

import java.sql.Date;

public class GuestBookDTO {
	private int no;
	private String name;
	private String email;
	private String passwd;
	private String content;
	private Date regi_date;
	
	public GuestBookDTO() {
	}
	
	public GuestBookDTO(int no, String name, String email, String passwd, String content, Date regi_date) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.content = content;
		this.regi_date = regi_date;
	}
	
	public GuestBookDTO(String name, String email, String passwd, String content) {
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.content = content;
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

	public Date getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(Date regi_date) {
		this.regi_date = regi_date;
	}
	
	
	
}
