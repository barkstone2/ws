package model.board.dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int bNo;
	private String bSubject;
	private String bWriter;
	private String bContent;
	private Timestamp bRegiDate;
	private int bSecretChk;
	private String bPasswd;
	private int bGroupNo;
	private int bStepNo;
	private int bParentNo;
	private int replyCounter;
	
	public BoardDTO() {
	}

	public BoardDTO(int bNo, String bSubject, String bWriter, String bContent, Timestamp bRegiDate, int bSecretChk,
			String bPasswd, int bGroupNo, int bStepNo, int bParentNo) {
		this.bNo = bNo;
		this.bSubject = bSubject;
		this.bWriter = bWriter;
		this.bContent = bContent;
		this.bRegiDate = bRegiDate;
		this.bSecretChk = bSecretChk;
		this.bPasswd = bPasswd;
		this.bGroupNo = bGroupNo;
		this.bStepNo = bStepNo;
		this.bParentNo = bParentNo;
	}




	public int getReplyCounter() {
		return replyCounter;
	}

	public void setReplyCounter(int replyCounter) {
		this.replyCounter = replyCounter;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbSubject() {
		return bSubject;
	}

	public void setbSubject(String bSubject) {
		this.bSubject = bSubject;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbRegiDate() {
		return bRegiDate;
	}

	public void setbRegiDate(Timestamp bRegiDate) {
		this.bRegiDate = bRegiDate;
	}

	public int getbSecretChk() {
		return bSecretChk;
	}

	public void setbSecretChk(int bSecretChk) {
		this.bSecretChk = bSecretChk;
	}

	public String getbPasswd() {
		return bPasswd;
	}

	public void setbPasswd(String bPasswd) {
		this.bPasswd = bPasswd;
	}

	public int getbGroupNo() {
		return bGroupNo;
	}

	public void setbGroupNo(int bGroupNo) {
		this.bGroupNo = bGroupNo;
	}

	public int getbStepNo() {
		return bStepNo;
	}

	public void setbStepNo(int bStepNo) {
		this.bStepNo = bStepNo;
	}

	public int getbParentNo() {
		return bParentNo;
	}

	public void setbParentNo(int bParentNo) {
		this.bParentNo = bParentNo;
	}
	
	
}
