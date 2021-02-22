package model.board.dto;

import java.sql.Timestamp;

public class BoardReplyDTO {
	private int rNo;
	private int bNo;
	private String rWriter;
	private String rContent;
	private String rPasswd;
	private int rMemberNo;
	private String rIp;
	private Timestamp rRegiDate;
	private int rGroupNo;
	private int rStepNo;
	
	public BoardReplyDTO() {
	}
	
	public BoardReplyDTO(int bNo, String rWriter, String rContent, String rPasswd, int rGroupNo, int rStepNo) {
		this.bNo = bNo;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.rPasswd = rPasswd;
		this.rGroupNo = rGroupNo;
		this.rStepNo = rStepNo;
	}
	
	public BoardReplyDTO(int rNo, int bNo, String rWriter, String rContent, String rPasswd, Timestamp rRegiDate,
			int rGroupNo, int rStepNo) {
		this.rNo = rNo;
		this.bNo = bNo;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.rPasswd = rPasswd;
		this.rRegiDate = rRegiDate;
		this.rGroupNo = rGroupNo;
		this.rStepNo = rStepNo;
	}




	public int getrMemberNo() {
		return rMemberNo;
	}

	public void setrMemberNo(int rMemberNo) {
		this.rMemberNo = rMemberNo;
	}

	public String getrIp() {
		return rIp;
	}

	public void setrIp(String rIp) {
		this.rIp = rIp;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrPasswd() {
		return rPasswd;
	}

	public void setrPasswd(String rPasswd) {
		this.rPasswd = rPasswd;
	}

	public Timestamp getrRegiDate() {
		return rRegiDate;
	}

	public void setrRegiDate(Timestamp rRegiDate) {
		this.rRegiDate = rRegiDate;
	}

	public int getrGroupNo() {
		return rGroupNo;
	}

	public void setrGroupNo(int rGroupNo) {
		this.rGroupNo = rGroupNo;
	}

	public int getrStepNo() {
		return rStepNo;
	}

	public void setrStepNo(int rStepNo) {
		this.rStepNo = rStepNo;
	}
	
	
}
