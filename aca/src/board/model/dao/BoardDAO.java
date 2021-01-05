package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.dto.BoardDTO;
import db.Db;
import db.DbImplOracle;

public class BoardDAO {
	private Db db = new DbImplOracle();
	private Connection conn = db.dbConn();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int setInsert(BoardDTO dto) {
		int maxNum = maxNum();
		int maxRef = maxRef();
		int result = 0;
		try {
			String sql = "insert into board "
					+"(no, num, writer, subject, content, email, passwd, ref, re_step, re_level, hit, regi_date) "
					+"values(seq_board.nextval,?,?,?,?,?,?,?,1,1,0,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPasswd());
			pstmt.setInt(7, maxRef);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		db.dbConnClose();
		return result;
	}
	
	public int maxNum() {
		int result = 0;
		try {
			String sql = "select max(num) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max(num)");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result+1;
	}
	
	public int maxRef() {
		int result = 0;
		try {
			String sql = "select max(ref) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max(ref)");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result+1;
	}
	
	public ArrayList<BoardDTO> getListAll(int contentNum){
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		try {
			String sql = "select rownum, A.no, A.ref, A.re_level, A.subject, A.writer,A.regi_date "
					+ "from (select * from board) A where rownum <=? and rownum >=? order by no, ref, re_level desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNum);
			pstmt.setInt(2, contentNum-contentNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegi_date(rs.getString("regi_date"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		db.dbConnClose();
		return dtos;
	}
	
	public BoardDTO getView(int no) {
		BoardDTO dto = new BoardDTO();
		try {
			String sql = "select * from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setHit(rs.getInt("hit"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRef(rs.getInt("ref"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegi_date(rs.getString("regi_date"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		db.dbConnClose();
		return dto;
	}
	
	public void setRe_level(int ref, int re_level) {
		try {
			String sql = "update board set re_level=(re_level+1) where ref=? and re_level>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_level);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setAnswer(BoardDTO dto) {
		int maxNum = maxNum();
		int result = 0;
		try {
			String sql = "insert into board "
					+"(no, num, writer, subject, content, email, passwd, ref, re_step, re_level, hit, regi_date) "
					+"values(seq_board.nextval,?,?,?,?,?,?,?,?,?,0,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPasswd());
			pstmt.setInt(7, dto.getRef());
			pstmt.setInt(8, dto.getRe_step());
			pstmt.setInt(9, dto.getRe_level());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		db.dbConnClose();
		return result;
	}
	
	public int getPageNum() {
		double result_ = 0;
		int result = 0;
		try {
			String sql = "select count(rownum) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result_ = rs.getDouble(1);
				result = (int)Math.ceil(result_/7);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		db.dbConnClose();
		return result;
	}
	
	
	
}
