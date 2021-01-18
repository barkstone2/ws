package member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int setInsert(MemberDTO dto) {
		int result=0;
		getConn();
		try {
			String sql = "insert into member (id, pw, name, addr, bAddr, sAddr) "
					+ "values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getbAddr());
			pstmt.setString(6, dto.getsAddr());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	public int getLogin(String id, String pw) {
		int result = 0; // 등록되지 않은 ID
		getConn();
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
			quitConn();
		}
		return result;
	}
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "test0118";
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
		}
	}
	
}
