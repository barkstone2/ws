package email;

import java.util.Date;

public class MemberDTO {
	private String no;
	private String name;
	private String email;
	private Date birthDay;
	
	public MemberDTO() {
	}
	
	public MemberDTO(String no, String name, String email, Date birthDay) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.birthDay = birthDay;
	}

	
	
	
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
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
	
	
}
