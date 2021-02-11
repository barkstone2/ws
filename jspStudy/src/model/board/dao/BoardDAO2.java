package model.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import db.Db;
import db.DbImplOracle;
import model.board.dto.BoardDTO;
import model.board.dto.BoardDTO2;
import model.board.dto.BoardReplyDTO;
import model.memo.dto.MemoDTO;
import model.survey.dto.SurveyDTO;

public class BoardDAO2 {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String tableName1 = "board2";
	private String tableName2 = "board_reply2";
	
	public BoardDAO2() {
		conn = db.getConn();		
	}
	
	public int setInsert(BoardDTO2 dto) {
		int result=0;
		int maxGroupNo = getMaxNo("bGroupNo", tableName1);
		int maxLevelNo = getMaxNo("bLevelNo", tableName1);
		int maxNoticeNum = 0;
		if(dto.getbNoticeNum()>0) {
			maxNoticeNum = getMaxNo("bNoticeNum", tableName1);
		}
		try {
			String sql = "insert into "+ tableName1
					+ " (bNo, bNum, boardType, bSubject, bWriter, bContent, bPasswd, bEmail, "
					+ "bSecretChk, bNoticeNum, bIp, bMemberNo, bHit, bRegiDate, bGroupNo, bStepNo, bLevelNo, bParentNo) "
					+ "values(seq_board2.nextval,0,?,?,?,?,?,?,?,?,?,?,default,default,?,default,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardType());
			pstmt.setString(2, dto.getbSubject());
			pstmt.setString(3, dto.getbWriter());
			pstmt.setString(4, dto.getbContent());
			pstmt.setString(5, dto.getbPasswd());
			pstmt.setString(6, dto.getbEmail());
			pstmt.setInt(7, dto.getbSecretChk());
			pstmt.setInt(8, maxNoticeNum);
			pstmt.setString(9, dto.getbIp());
			pstmt.setInt(10, dto.getbMemberNo());
			pstmt.setInt(11, maxGroupNo);
			pstmt.setInt(12, maxLevelNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int getMaxNo(String noName, String tableName) {
		int maxNo = 0;
		try {
			String sql = "select max("+noName+") from "+tableName;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNo = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo+1;
	}
	
	public ArrayList<BoardDTO2> getNoticeAll(String boardType){
		ArrayList<BoardDTO2> list = new ArrayList<>();
		String basicSql = "select a.bNo, a.bNum, a.boardType, a.bSubject, a.bWriter, a.bContent, "
				+ "a.bPasswd, a.bEmail, a.bSecretChk, a.bNoticeNum, a.bIp, a.bMemberNo, a.bHit, a.bRegiDate, "
				+ "a.bGroupNo, a.bStepNo, a.bLevelNo, a.bParentNo, "
				+ "(select count(*) from "+tableName2+" where a.bNo=bNo) replyCounter, "
				+ "(select count(*) from "+tableName1+" where a.bNo=bParentNo) childCount "
				+ "from "+tableName1+" a where bNo>0 and boardType=? and bNoticeNum>0";
		String orderBy = " order by bNoticeNum desc, bGroupNo desc, bStepNo asc, bLevelNo asc, bNo asc";
		try {
			basicSql += orderBy;
			int k = 1;  //++k
			String sql = "select * from (select rownum rn, b.* from ("+basicSql+") b)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardType);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO2 dto = new BoardDTO2(
						rs.getInt("bNo"),
						rs.getInt("bNum"),
						rs.getString("boardType"),
						rs.getString("bSubject"),
						rs.getString("bWriter"),
						rs.getString("bContent"),
						rs.getString("bPasswd"),
						rs.getString("bEmail"),
						rs.getInt("bSecretChk"),
						rs.getInt("bNoticeNum"),
						rs.getString("bIp"),
						rs.getInt("bMemberNo"),
						rs.getInt("bHit"),
						rs.getTimestamp("bRegiDate"),
						rs.getInt("bGroupNo"),
						rs.getInt("bStepNo"),
						rs.getInt("bLevelNo"),
						rs.getInt("bParentNo")
						);
				dto.setReplyCounter(rs.getInt("replyCounter"));
				dto.setChildCount(rs.getInt("childCount"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<BoardDTO2> getListAll(String boardType, int startRecord, int endRecord, String search_option, String search_data){
		ArrayList<BoardDTO2> list = new ArrayList<>();
		String basicSql = "select a.bNo, a.bNum, a.boardType, a.bSubject, a.bWriter, a.bContent, "
				+ "a.bPasswd, a.bEmail, a.bSecretChk, a.bNoticeNum, a.bIp, a.bMemberNo, a.bHit, a.bRegiDate, "
				+ "a.bGroupNo, a.bStepNo, a.bLevelNo, a.bParentNo, "
				+ "(select count(*) from "+tableName2+" where a.bNo=bNo) replyCounter, "
				+ "(select count(*) from "+tableName1+" where a.bNo=bParentNo) childCount "
				+ "from "+tableName1+" a where bNo>0 and boardType=?";
		String orderBy = " order by bGroupNo desc, bLevelNo asc, bNo asc";
		try {
			boolean[] sqlCheck = new boolean[3];
			if(search_option.length()>0&&search_data.length()>0) {
				if(search_option.equals("subcon")) {
					basicSql+= " and (bSubject like ? or bContent like ?)";
					sqlCheck[0] = true;
				}else if(search_option.equals("all")) {
					basicSql+= " and (bSubject like ? or bContent like ? or bWriter like ?)";
					sqlCheck[1] = true;
				}else {
					basicSql+= " and "+search_option+" like ?";
					sqlCheck[2] = true;
				}
			}
			basicSql += " and bNoticeNum=0";
			basicSql += orderBy;
			int k = 1;  //++k
			String sql = "select c.*, "
					+ "lag(bNo) over(order by rn) bPreNo, "
					+ "lead(bNo) over(order by rn) bNextNo, "
					+ "lag(bSubject) over(order by rn) bPreSubject, "
					+ "lead(bSubject) over(order by rn) bNextSubject "
					+ "from (select rownum rn, b.* from ("+basicSql+") b) c where rn between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardType);
			if(sqlCheck[0]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[1]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[2]){
				pstmt.setString(++k, "%"+search_data+"%");
			}
			pstmt.setInt(++k, startRecord);
			pstmt.setInt(++k, endRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO2 dto = new BoardDTO2(rs.getInt("bNo"),
						rs.getInt("bNum"),
						rs.getString("boardType"),
						rs.getString("bSubject"),
						rs.getString("bWriter"),
						rs.getString("bContent"),
						rs.getString("bPasswd"),
						rs.getString("bEmail"),
						rs.getInt("bSecretChk"),
						rs.getInt("bNoticeNum"),
						rs.getString("bIp"),
						rs.getInt("bMemberNo"),
						rs.getInt("bHit"),
						rs.getTimestamp("bRegiDate"),
						rs.getInt("bGroupNo"),
						rs.getInt("bStepNo"),
						rs.getInt("bLevelNo"),
						rs.getInt("bParentNo")
						);
				dto.setReplyCounter(rs.getInt("replyCounter"));
				dto.setbPreNo(rs.getInt("bPreNo"));
				dto.setbNextNo(rs.getInt("bNextNo"));
				dto.setbPreSubject(rs.getString("bPreSubject"));
				dto.setbNextSubject(rs.getString("bNextSubject"));
				dto.setChildCount(rs.getInt("childCount"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}
	
		
	public BoardDTO2 getView(int bNo) {
		BoardDTO2 dto = null;
		try {
			String basicSql = "select a.bNo, a.bNum, a.boardType, a.bSubject, a.bWriter, a.bContent, "
					+ "a.bPasswd, a.bEmail, a.bSecretChk, a.bNoticeNum, a.bIp, a.bMemberNo, a.bHit, a.bRegiDate, "
					+ "a.bGroupNo, a.bStepNo, a.bLevelNo, a.bParentNo "
					+ "from "+tableName1+" a";
			String orderBy = " order by bGroupNo desc, bStepNo asc, bLevelNo asc, bNo asc";
			String basicSql2 = "select c.*, "
					+ "lag(bNo) over(order by rn) bPreNo, "
					+ "lead(bNo) over(order by rn) bNextNo, "
					+ "lag(bSubject) over(order by rn) bPreSubject, "
					+ "lead(bSubject) over(order by rn) bNextSubject "
					+ "from (select rownum rn, b.* from ("+basicSql+") b) c";
			String sql = "select * from ("+basicSql2+") where bNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO2(rs.getInt("bNo"),
						rs.getInt("bNum"),
						rs.getString("boardType"),
						rs.getString("bSubject"),
						rs.getString("bWriter"),
						rs.getString("bContent"),
						rs.getString("bPasswd"),
						rs.getString("bEmail"),
						rs.getInt("bSecretChk"),
						rs.getInt("bNoticeNum"),
						rs.getString("bIp"),
						rs.getInt("bMemberNo"),
						rs.getInt("bHit"),
						rs.getTimestamp("bRegiDate"),
						rs.getInt("bGroupNo"),
						rs.getInt("bStepNo"),
						rs.getInt("bLevelNo"),
						rs.getInt("bParentNo")
						);
				dto.setbPreNo(rs.getInt("bPreNo"));
				dto.setbNextNo(rs.getInt("bNextNo"));
				dto.setbPreSubject(rs.getString("bPreSubject"));
				dto.setbNextSubject(rs.getString("bNextSubject"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return dto;
	}
	
	
	public ArrayList<BoardReplyDTO> getReply(int bNo, int startRecord, int endRecord){
		ArrayList<BoardReplyDTO> replList = new ArrayList<>();
		String basicSql = "select rNo, bNo, rWriter, rContent, rPasswd, rRegiDate, rGroupNo, rStepNo "
				+ "from "+tableName2+" where bNo=?";
		try {
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?";
			sql += " order by rGroupNo, rNo";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, startRecord);
			pstmt.setInt(3, endRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardReplyDTO dto = new BoardReplyDTO(
						rs.getInt("rNo"), 
						rs.getInt("bNo"), 
						rs.getString("rWriter"), 
						rs.getString("rContent"),
						rs.getString("rPasswd"),
						rs.getTimestamp("rRegiDate"),
						rs.getInt("rGroupNo"),
						rs.getInt("rStepNo"));
				replList.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return replList;
	}
	
	public int setInsertReply(BoardReplyDTO dto) {
		int result = 0;
		
		try {
			String sql = "insert into "+tableName2+" (rNo, bNo, rWriter,rContent, rPasswd, rRegiDate,rGroupNo, rStepNo) "
					+ "values(seq_board_repl.nextval, ?,?,?,?,default,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getbNo());
			pstmt.setString(2, dto.getrWriter());
			pstmt.setString(3, dto.getrContent());
			pstmt.setString(4, dto.getrPasswd());
			pstmt.setInt(5, dto.getrGroupNo());
			pstmt.setInt(6, dto.getrStepNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	
	
	
	public int getReplyCount(int bNo) {
		int result = 0;
		try {
			String sql = "select count(*) from "+tableName2+" where bNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// ** 공지글을 제외한 총 글 개수 **
	public int getTotalCount(String search_option, String search_data) {
		int result = 0;
		try {
			String sql = "select count(*) from "+tableName1+" where bNo>0";
			boolean[] sqlCheck = new boolean[3];
			if(search_option.length()>0&&search_data.length()>0) {
				if(search_option.equals("subcon")) {
					sql+= " and (bSubject like ? or bContent like ?)";
					sqlCheck[0] = true;
				}else if(search_option.equals("all")) {
					sql+= " and (bSubject like ? or bContent like ? or bWriter like ?)";
					sqlCheck[1] = true;
				}else {
					sql+= " and "+search_option+" like ?";
					sqlCheck[2] = true;
				}
			}
			sql += " and bNoticeNum=0";
			pstmt = conn.prepareStatement(sql);
			int k = 0;
			if(sqlCheck[0]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[1]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[2]){
				pstmt.setString(++k, "%"+search_data+"%");
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void setHit(int bNo) {
		try {
			String sql = "update "+tableName1+" set bHit=(bHit+1) where bNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setAnswer(BoardDTO2 dto) {
		int result=0;
		int maxNoticeNum = 0;
		if(dto.getbNoticeNum()>0) {
			maxNoticeNum = getMaxNo("bNoticeNum", tableName1);
		}
		setLevelNo(dto.getbGroupNo(), dto.getbLevelNo());
		try {
			String sql = "insert into "+ tableName1
					+ " (bNo, bNum, boardType, bSubject, bWriter, bContent, bPasswd, bEmail, "
					+ "bSecretChk, bNoticeNum, bIp, bMemberNo, bHit, bRegiDate, bGroupNo, bStepNo, bLevelNo, bParentNo) "
					+ "values(seq_board2.nextval,0,?,?,?,?,?,?,?,?,?,?,default,default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardType());
			pstmt.setString(2, dto.getbSubject());
			pstmt.setString(3, dto.getbWriter());
			pstmt.setString(4, dto.getbContent());
			pstmt.setString(5, dto.getbPasswd());
			pstmt.setString(6, dto.getbEmail());
			pstmt.setInt(7, dto.getbSecretChk());
			pstmt.setInt(8, maxNoticeNum);
			pstmt.setString(9, dto.getbIp());
			pstmt.setInt(10, dto.getbMemberNo());
			pstmt.setInt(11, dto.getbGroupNo());
			pstmt.setInt(12, dto.getbStepNo()+1);
			pstmt.setInt(13, dto.getbLevelNo()+1);
			pstmt.setInt(14, dto.getbNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public void setLevelNo(int bGroupNo, int bLevelNo) {
		try {
			String sql = "update "+tableName1+" set bLevelNo=bLevelNo+1 where bGroupNo=? and bLevelNo>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bGroupNo);
			pstmt.setInt(2, bLevelNo);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setUpdate(BoardDTO2 dto) {
		int result = 0;
		int maxNoticeNum = 0;
		if(dto.getbNoticeNum()>0) {
			maxNoticeNum = getMaxNo("bNoticeNum", tableName1);
		}
		try {
			String sql = "update "+tableName1+" set BoardType=?, bSubject=?, bWriter=?, "
					+ "bContent=?, bPasswd=?, bEmail=?, bSecretChk=?, bNoticeNum=?, "
					+ "bIp=?, bMemberNo=? where bNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardType());
			pstmt.setString(2, dto.getbSubject());
			pstmt.setString(3, dto.getbWriter());
			pstmt.setString(4, dto.getbContent());
			pstmt.setString(5, dto.getbPasswd());
			pstmt.setString(6, dto.getbEmail());
			pstmt.setInt(7, dto.getbSecretChk());
			pstmt.setInt(8, maxNoticeNum);
			pstmt.setString(9, dto.getbIp());
			pstmt.setInt(10, dto.getbMemberNo());
			pstmt.setInt(11, dto.getbNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int setDelete(int bNo) {
		int result = 0;
		try {
			String sql = "delete from "+tableName1+" where bNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
}
