package model.board.dto;

import java.sql.Timestamp;

public class BoardDTO2 {
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
	
	private int bNum; // 그냥 붙인 번호
	private String bTbl; // 아직 사용 안함
	private String bEmail;
	private int bLevelNo; // 계층형 게시판 용
	private int bHit; // 조회수
	private int bMemberNo; // 0일시 비회원, 0보다 크면 회원
	private int bNoticeChk; // 공지 판단용
	private String bIp;
	
	//이전글 다음글 표시용
	private int bPreNo;
	private int bNextNo;
	private String bPreSubject;
	private String bNextSubject;
	
	public BoardDTO2() {
	}

	public BoardDTO2(int bNo, String bSubject, String bWriter, String bContent, Timestamp bRegiDate, int bSecretChk,
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
