package model.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import db.Db;
import db.DbImplOracle;
import model.board.dto.BoardDTO;
import model.board.dto.BoardReplyDTO;
import model.memo.dto.MemoDTO;
import model.survey.dto.SurveyDTO;

public class BoardDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public BoardDAO() {
		conn = db.getConn();		
	}
	
	public int setInsert(BoardDTO dto) {
		int result=0;
		try {
			String sql = "insert into board "
					+ "(bNo, bSubject, bWriter, bContent, bRegiDate, bSecretChk, bPasswd, bGroupNo, bStepNo, bParentNo) "
					+ "values(seq_board.nextval,?,?,?,default,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getbSubject());
			pstmt.setString(2, dto.getbWriter());
			pstmt.setString(3, dto.getbContent());
			pstmt.setInt(4, dto.getbSecretChk());
			pstmt.setString(5, dto.getbPasswd());
			pstmt.setInt(6, dto.getbGroupNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int getMaxNo(String noName, String tableName) {
		int maxNo = 1;
		try {
			String sql = "select max("+noName+")+1 from "+tableName;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNo = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}
	
	public ArrayList<BoardDTO> getListAll(int startRecord, int endRecord, String search_option, String search_data){
		ArrayList<BoardDTO> list = new ArrayList<>();
		String basicSql = "select a.bNo, a.bSubject, a.bWriter, a.bContent, a.bRegiDate, a.bSecretChk, a.bPasswd, a.bGroupNo, "
				+ "a.bStepNo, a.bParentNo, (select count(*) from board_reply where a.bNo=bNo) replyCounter "
				+ "from board a where bNo>0";
		String orderBy = " order by bGroupNo desc, bStepNo asc, bNo asc";
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
			basicSql += orderBy;
			int k = 0;  //++k
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?";
			pstmt = conn.prepareStatement(sql);
			if(sqlCheck[0]) {
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setString(2, "%"+search_data+"%");
				pstmt.setInt(2, startRecord);
				pstmt.setInt(3, endRecord);
			}else if(sqlCheck[1]) {
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setString(2, "%"+search_data+"%");
				pstmt.setString(3, "%"+search_data+"%");
				pstmt.setInt(4, startRecord);
				pstmt.setInt(5, endRecord);
			}else if(sqlCheck[2]){
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setInt(2, startRecord);
				pstmt.setInt(3, endRecord);
			}else {
				pstmt.setInt(1, startRecord);
				pstmt.setInt(2, endRecord);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("bNo"),
						rs.getString("bSubject"),
						rs.getString("bWriter"),
						rs.getString("bContent"),
						rs.getTimestamp("bRegiDate"),
						rs.getInt("bSecretChk"),
						rs.getString("bPasswd"),
						rs.getInt("bGroupNo"),
						rs.getInt("bStepNo"),
						rs.getInt("bParentNo"));
				dto.setReplyCounter(rs.getInt("replyCounter"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}
	
		
	public BoardDTO getView(int bNo) {
		BoardDTO dto = null;
		try {
			String sql = "select bNo, bSubject, bWriter, bContent, bRegiDate, "
					+ "bSecretChk, bPasswd, bGroupNo, bStepNo, bParentNo "
					+ "from board where bNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO(rs.getInt("bNo"),
						rs.getString("bSubject"),
						rs.getString("bWriter"),
						rs.getString("bContent"),
						rs.getTimestamp("bRegiDate"),
						rs.getInt("bSecretChk"),
						rs.getString("bPasswd"),
						rs.getInt("bGroupNo"),
						rs.getInt("bStepNo"),
						rs.getInt("bParentNo"));
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
				+ "from board_reply where bNo=?";
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
	
	
	
	public int setUpdate(String id, String content, int no) {
		int result = 0;
		try {
			String sql = "update memo set id=?, content=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int setInsertReply(BoardReplyDTO dto) {
		int result = 0;
		
		try {
			String sql = "insert into board_reply (rNo, bNo, rWriter,rContent, rPasswd, rRegiDate,rGroupNo, rStepNo) "
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
			String sql = "select count(*) from board_reply where bNo=?";
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
	
	
	public int getTotalCount(String search_option, String search_data) {
		int result = 0;
		try {
			String sql = "select count(*) from board where bNo>0";
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
			pstmt = conn.prepareStatement(sql);
			if(sqlCheck[0]) {
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setString(2, "%"+search_data+"%");
			}else if(sqlCheck[1]) {
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setString(2, "%"+search_data+"%");
				pstmt.setString(3, "%"+search_data+"%");
			}else if(sqlCheck[2]){
				pstmt.setString(1, "%"+search_data+"%");
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
}
