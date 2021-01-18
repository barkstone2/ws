package member.model;

public class MemberDTO {
	private String id;
	private String pw;
	private String pwc;
	private String name;
	private String addr; 
	private String bAddr;
	private String sAddr;
	
	public MemberDTO() {
	}

	public MemberDTO(String id, String pw, String name, String addr, String bAddr, String sAddr) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.bAddr = bAddr;
		this.sAddr = sAddr;
	}

	
	
	
	public String getPwc() {
		return pwc;
	}

	public void setPwc(String pwc) {
		this.pwc = pwc;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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
	
	
	
}
