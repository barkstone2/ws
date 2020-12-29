package etc.member;

public class MemberDTO {
	private int no;
	private String id;
	private String pw;
	private String pwc;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String addr;
	private String gender;
	private String job;
	private String grade;
	private String rdate;
	private String ip;
	private int loginfailcounter;
	
	public MemberDTO() {
	}
	
	public MemberDTO(int no, String id, String pw, String name, String nickname, String phone, String email,
			String addr, String gender, String job, String grade, String rdate, String ip, int loginfailcounter) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.gender = gender;
		this.job = job;
		this.grade = grade;
		this.rdate = rdate;
		this.ip = ip;
		this.loginfailcounter = loginfailcounter;
	}





	public int getNo() {
		return no;
	}

	
	public String getPwc() {
		return pwc;
	}

	public void setPwc(String pwc) {
		this.pwc = pwc;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getLoginfailcounter() {
		return loginfailcounter;
	}

	public void setLoginfailcounter(int loginfailcounter) {
		this.loginfailcounter = loginfailcounter;
	}
	
	
	
}
