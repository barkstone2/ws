package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "apptest";
			String dbPw = "1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("오라클 접속 성공");
		}catch (Exception e) {
			System.out.println("오라클 접속 실패");
			e.printStackTrace();
		}
	}
	
	public void quitConn() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("오라클 접속 종료");
		}
	}
	
	public MemberDTO getLogin(String id, String passwd) {
		getConn();
		MemberDTO dto = null;
		try {
			String sql = "select id, passwd, changeDate from member where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(
						rs.getString("id"), 
						rs.getString("passwd"), 
						rs.getDate("changeDate")
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return dto;
	}
	
	public int setUpdate(String passwd, String id) {
		getConn();
		int result = 0;
		try {
			String sql = "update member set passwd=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passwd);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	
}
