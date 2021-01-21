package model;

import java.util.Date;

public class MemberDTO {
	private String id;
	private String passwd;
	private Date changeDate;
	
	public MemberDTO() {
	}

	public MemberDTO(String id, String passwd, Date changeDate) {
		this.id = id;
		this.passwd = passwd;
		this.changeDate = changeDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	
	
}
