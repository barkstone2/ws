package etc.member;

public class MemberDTO {
	
	private int no;
	private String id;
	private String passwd;
	private String passwdChk;
	private String name;
	private String nickname;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private String job;
	private String grade;
	private String regi_date;
	private String ip;
	private int loginFailCounter;
	
	public MemberDTO() {
	}

	
	
	
	public String getIp() {
		return ip;
	}




	public void setIp(String ip) {
		this.ip = ip;
	}




	public int getLoginFailCounter() {
		return loginFailCounter;
	}




	public void setLoginFailCounter(int loginFailCounter) {
		this.loginFailCounter = loginFailCounter;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswdChk() {
		return passwdChk;
	}

	public void setPasswdChk(String passwdChk) {
		this.passwdChk = passwdChk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(String regi_date) {
		this.regi_date = regi_date;
	}
	
	
	
	
}
