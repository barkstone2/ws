package model.board.dto;

import java.sql.Timestamp;

public class BoardDTO2 {
	// ** DB처리용 데이터 **
	private int bNo; // 고유번호
	private int bNum; // 그냥 붙인 번호
	private String boardType; // 아직 사용 안함
	//사용자 입력값
	private String bSubject;
	private String bWriter;
	private String bContent;
	private String bPasswd;
	private String bEmail;
	private int bSecretChk; // 비밀글 판단용
	private int bNoticeNum; // 공지 판단용
	//기타 정보
	private String bIp;
	private int bMemberNo; // 0일시 비회원, 0보다 크면 회원
	private int bHit; // 조회수
	private Timestamp bRegiDate;
	// 계층형 게시판 표시용
	private int bGroupNo;
	private int bStepNo;
	private int bLevelNo;
	private int bParentNo;
	private int childCount;

	//이전글 다음글 표시용
	private int bPreNo;
	private int bNextNo;
	private String bPreSubject;
	private String bNextSubject;
	private int replyCounter; // 댓글 수 표시용
	
	public BoardDTO2() {
	}

	public BoardDTO2(int bNo, int bNum, String boardType, String bSubject, String bWriter, String bContent,
			String bPasswd, String bEmail, int bSecretChk, int bNoticeNum, String bIp, int bMemberNo, int bHit,
			Timestamp bRegiDate, int bGroupNo, int bStepNo, int bLevelNo, int bParentNo) {
		this.bNo = bNo;
		this.bNum = bNum;
		this.boardType = boardType;
		this.bSubject = bSubject;
		this.bWriter = bWriter;
		this.bContent = bContent;
		this.bPasswd = bPasswd;
		this.bEmail = bEmail;
		this.bSecretChk = bSecretChk;
		this.bNoticeNum = bNoticeNum;
		this.bIp = bIp;
		this.bMemberNo = bMemberNo;
		this.bHit = bHit;
		this.bRegiDate = bRegiDate;
		this.bGroupNo = bGroupNo;
		this.bStepNo = bStepNo;
		this.bLevelNo = bLevelNo;
		this.bParentNo = bParentNo;
		this.bPreNo = bPreNo;
		this.bNextNo = bNextNo;
		this.bPreSubject = bPreSubject;
		this.bNextSubject = bNextSubject;
		this.replyCounter = replyCounter;
	}










	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
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

	public String getbPasswd() {
		return bPasswd;
	}

	public void setbPasswd(String bPasswd) {
		this.bPasswd = bPasswd;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public int getbSecretChk() {
		return bSecretChk;
	}

	public void setbSecretChk(int bSecretChk) {
		this.bSecretChk = bSecretChk;
	}

	public int getbNoticeNum() {
		return bNoticeNum;
	}

	public void setbNoticeNum(int bNoticeNum) {
		this.bNoticeNum = bNoticeNum;
	}

	public String getbIp() {
		return bIp;
	}

	public void setbIp(String bIp) {
		this.bIp = bIp;
	}

	public int getbMemberNo() {
		return bMemberNo;
	}

	public void setbMemberNo(int bMemberNo) {
		this.bMemberNo = bMemberNo;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public Timestamp getbRegiDate() {
		return bRegiDate;
	}

	public void setbRegiDate(Timestamp bRegiDate) {
		this.bRegiDate = bRegiDate;
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

	public int getbLevelNo() {
		return bLevelNo;
	}

	public void setbLevelNo(int bLevelNo) {
		this.bLevelNo = bLevelNo;
	}

	public int getbParentNo() {
		return bParentNo;
	}

	public void setbParentNo(int bParentNo) {
		this.bParentNo = bParentNo;
	}

	public int getbPreNo() {
		return bPreNo;
	}

	public void setbPreNo(int bPreNo) {
		this.bPreNo = bPreNo;
	}

	public int getbNextNo() {
		return bNextNo;
	}

	public void setbNextNo(int bNextNo) {
		this.bNextNo = bNextNo;
	}

	public String getbPreSubject() {
		return bPreSubject;
	}

	public void setbPreSubject(String bPreSubject) {
		this.bPreSubject = bPreSubject;
	}

	public String getbNextSubject() {
		return bNextSubject;
	}

	public void setbNextSubject(String bNextSubject) {
		this.bNextSubject = bNextSubject;
	}

	public int getReplyCounter() {
		return replyCounter;
	}

	public void setReplyCounter(int replyCounter) {
		this.replyCounter = replyCounter;
	}

	
}
