package model.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import model.member.dto.MemberDTO;

public class MemberDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDAO() {
		conn = db.getConn();
	}
	
	public int setInsert(MemberDTO dto) {
		int result=0;
		try {
			String sql = "insert into member (no, id, pw, name, gender, bornYear, regi_date) "
					+ "values(seq_member.nextval, ?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getBornYear());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	
	public int getLogin(String id, String pw) {
		int result = 0; // 등록되지 않은 ID
		try {
			String sql = "select * from member where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1; // 로그인 성공
			}else {
				sql = "select * from member where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result=-1; // 비밀번호 틀림
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public MemberDTO getSelect(String id) {
		MemberDTO dto = null;
		try {
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("pw"),
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("bornYear"), 
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
	
	public MemberDTO getView(int no) {
		MemberDTO dto = null;
		try {
			String sql = "select * from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("pw"),
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("bornYear"), 
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
	
	
	public ArrayList<MemberDTO> getListAll(){
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			String sql = "select no, id, pw, name, gender, bornYear, regi_date from member order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(
						rs.getInt("no"),
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getInt("bornYear"),
						rs.getTimestamp("regi_date")
						);
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}
	
	public int setUpdate(MemberDTO dto) {
		int result = 0; // 비밀번호 불일치
		try {
			String sql = "update member set gender=?, bornYear=? where no=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender());
			pstmt.setInt(2, dto.getBornYear());
			pstmt.setInt(3, dto.getNo());
			pstmt.setString(4, dto.getPw());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int setDelete(MemberDTO dto) {
		int result = 0; // 비밀번호 불일치
		try {
			String sql = "delete from member where no=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getPw());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	
}