package member.model;

import java.sql.Timestamp;

public class MemberDTO {
	private int no;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private int bornYear;
	private String postCode;
	private String bAddr;
	private String sAddr;
	private String rAddr;
	private Timestamp regiDate;
	
	public MemberDTO() {
	}

	
	
	public MemberDTO(String id, String pw, String name, String gender, int bornYear, String postCode, String bAddr,
			String sAddr, String rAddr) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.bornYear = bornYear;
		this.postCode = postCode;
		this.bAddr = bAddr;
		this.sAddr = sAddr;
		this.rAddr = rAddr;
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

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getbAddr() {
		return bAddr;
	}

	public void setbAddr(String bAddr) {
		this.bAddr = bAddr;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getrAddr() {
		return rAddr;
	}

	public void setrAddr(String rAddr) {
		this.rAddr = rAddr;
	}

	public Timestamp getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Timestamp regiDate) {
		this.regiDate = regiDate;
	}
	
	
}
