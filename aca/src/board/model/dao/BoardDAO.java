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
	
	
	public void quitConn() {
		db.dbConnClose();
	}
	
	
	
	public int setInsert(BoardDTO dto) {
		int maxNum = maxNum();
		int maxRef = maxRef();
		int result = 0;
		try {
			String sql = "insert into board "
					+"(no, num, writer, subject, content, email, passwd, ref, re_step, re_level, parentNo, hit, regi_date) "
					+"values(seq_board.nextval,?,?,?,?,?,?,?,1,1,default,0,default)";
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
		}finally {
			db.dbConnClose();
		}
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
	
	public ArrayList<BoardDTO> getListAll(int startRow, int endRow, String searchType, String searchData){
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		try {
			//String coreSql = "select no, ref, re_level, subject, writer, regi_date, hit, re_step,parentNo "
			//		+ "from board order by ref desc, re_level asc";
			String coreSql = "select a.no, a.ref, a.re_level, a.subject, a.writer, "
					+ "a.regi_date, a.hit, a.re_step, a.parentNo, "
					+ "(select count(*) from board b where b.parentNo=a.no) childNum from board a ";
			String orderBy = "order by ref desc, re_level asc";
			if(searchType != null && searchData != null){
				if(searchType.equals("all")) {
					coreSql += "where subject like ? or content like ? ";
				}else{
					coreSql += "where "+searchType+" like ? ";
				}
			}
			coreSql += orderBy;
			
			String sql = "select * from "
					+ "(select rownum as rn, A.* from ("+coreSql+") A) "
					+ "where rn >=? and rn <=?";
			
			pstmt = conn.prepareStatement(sql);
			if(searchType != null && searchData != null) {
				pstmt.setString(1, "%"+searchData+"%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				if(searchType.equals("all")) {
					pstmt.setString(1, "%"+searchData+"%");
					pstmt.setString(2, "%"+searchData+"%");
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
				}
			}else {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegi_date(rs.getString("regi_date"));
				dto.setHit(rs.getInt("hit"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRef(rs.getInt("ref"));
				dto.setParentNo(rs.getInt("parentNo"));
				dto.setChildNum(rs.getInt("childNum"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.dbConnClose();
		}
		return dtos;
	}
	
	public ArrayList<BoardDTO> getView(int no) {
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		setHit(no);
		try {
			/* CREATE VIEW FIRST
			 * VIEW-RNBOARD SQL
			 * select rownum rn, A.* 
			 * from (select * from board order by ref desc, re_level asc) A;
			 */     
			
			String sql = "select b.* from rnBoard b "
					+"where no=? "
					+"or rn=((select rn from rnboard where no=?)+1) "
					+"or rn=((select rn from rnboard where no=?)-1) "
					+"order by rn asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			pstmt.setInt(3, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setHit(rs.getInt("hit")+1);
				dto.setRe_level(rs.getInt("re_level"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRef(rs.getInt("ref"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegi_date(rs.getString("regi_date"));
				dto.setParentNo(rs.getInt("parentNo"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.dbConnClose();
		}
		return dtos;
	}
	
	public BoardDTO getSelect(int no) {
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
				dto.setHit(rs.getInt("hit")+1);
				dto.setRe_level(rs.getInt("re_level"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRef(rs.getInt("ref"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegi_date(rs.getString("regi_date"));
				dto.setParentNo(rs.getInt("parentNo"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.dbConnClose();
		}
		return dto;
	}
	
	
	
	public void setRe_level(int ref, int re_level, boolean method) {
		try {
			String sql = "";
			if(method) {
				sql ="update board set re_level=(re_level+1) where ref=? and re_level>?";
			}else {
				sql = "update board set re_level=(re_level-1) where ref=? and re_level>?";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_level);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setAnswer(BoardDTO dto) {
		int maxNum = maxNum();
		int result = 0;
		try {
			String sql = "insert into board "
					+"(no, num, writer, subject, content, email, passwd, ref, re_step, re_level,parentNo, hit, regi_date) "
					+"values(seq_board.nextval,?,?,?,?,?,?,?,?,?,?,0,default)";
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
			pstmt.setInt(10, dto.getNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.dbConnClose();
		}
		return result;
	}
	
	public int getPageNum(int contentNum) {
		double result_ = 0;
		int result = 0;
		try {
			String sql = "select count(rownum) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result_ = rs.getDouble(1);
				result = (int)Math.ceil(result_/contentNum);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.dbConnClose();
		}
		return result;
	}
	
	public int getTotalRecordCount(String searchType, String searchData) {
		int result = 0;
		try {
			String sql = "select count(rownum) from board";
			if(searchType == null || searchData == null){
			}else{
				if(searchType.equals("all")) {
					sql += " where subject like ? or content like ?";
				}else{
					sql += " where "+searchType+" like ?";
				}
			}
			pstmt = conn.prepareStatement(sql);
			if(searchType == null || searchData == null) {
			}else {
				pstmt.setString(1, "%"+searchData+"%");
				if(searchType.equals("all")) pstmt.setString(2, "%"+searchData+"%");
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.dbConnClose();
		}
		return result;
	}
	
	public void setHit(int no) {
		try {
			String sql = "update board set hit=hit+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getAnsNum(int no) {
		int result = 0;
		try {
			String sql = "select count(*) from board where parentNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getMaxRestep(int ref) {
		int result = 0;
		try {
			String sql = "select max(re_step) from board where ref=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<BoardDTO> getChild(int no){
		ArrayList<BoardDTO> childs = new ArrayList<BoardDTO>();
		try {
			String sql = "select * from board where paretnNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO child = new BoardDTO();
				child.setNo(rs.getInt("no"));
				child.setRe_step(rs.getInt("re_step"));
				child.setRe_level(rs.getInt("re_level"));
				child.setRef(rs.getInt("ref"));
				child.setParentNo(rs.getInt("parentNo"));
				childs.add(child);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return childs;
	}
	
	public int setDelete(int no) {
		int result = 0;
		try {
			String sql = "delete from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int delCheck(int no) {
		int result = 0;
		try {
			String sql = "select * from board where parentNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = -1;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
