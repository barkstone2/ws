package model.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import model.board.dto.BoardDTO;
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
		int maxGroupNo = getMaxNo("bGroupNo");
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
			pstmt.setInt(6, maxGroupNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int getMaxNo(String noName) {
		int maxNo = 1;
		try {
			String sql = "select max("+noName+")+1 from board";
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
	
	
	
	
	
	public MemoDTO getView(int no) {
		MemoDTO dto = null;
		try {
			String sql = "select no, id, content, regi_date "
					+ "from memo where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemoDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("content"),
						rs.getTimestamp("regi_date")
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return dto;
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
