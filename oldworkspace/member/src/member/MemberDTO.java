package member;

import java.util.Date;

public class MemberDTO {
	private String id;
	private String pw;
	private String pwc;
	private String name;
	private String gender;
	private int birth;
	private String phone;
	private String email;
	private String addr;
	private Date jDate;
	private int invalidCheck;
	
	public MemberDTO() {
	}

	
	
	public Date getJDate() {
		return jDate;
	}

	public void setJDate(Date jDate) {
		this.jDate = jDate;
	}

	public int getInvalidCheck() {
		return invalidCheck;
	}

	public void setInvalidCheck(int invalidCheck) {
		this.invalidCheck = invalidCheck;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	
}
