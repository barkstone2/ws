package model.member.dto;

import java.sql.Timestamp;

public class MemberDTO {
	private int no;
	private String id;
	private String pw;
	private String pwc;
	private String name;
	private String gender;
	private int bornYear;
	private Timestamp regi_date;
	
	public MemberDTO() {
	}

	public MemberDTO(String id, String pw, String pwc,String name, String gender, int bornYear) {
		super();
		this.id = id;
		this.pw = pw;
		this.pwc = pwc;
		this.name = name;
		this.gender = gender;
		this.bornYear = bornYear;
	}

	public MemberDTO(int no, String id, String pw, String name, String gender, int bornYear,
			Timestamp regi_date) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.bornYear = bornYear;
		this.regi_date = regi_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Timestamp getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(Timestamp regi_date) {
		this.regi_date = regi_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPwc() {
		return pwc;
	}

	public void setPwc(String pwc) {
		this.pwc = pwc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBornYear() {
		return bornYear;
	}

	public void setBornYear(int bornYear) {
		this.bornYear = bornYear;
	}
	
	
}
