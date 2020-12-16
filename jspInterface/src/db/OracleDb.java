package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import member.MemberDTO;

public class OracleDb implements Db{
	
	public OracleDb() {
	}
	
	@Override
	public Connection getConn() {
		Connection conn = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "jspinterface";
			String dbPw = "1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public PreparedStatement setInsert(Object dto, Connection conn) {
		PreparedStatement pstmt = null;
		if(dto instanceof MemberDTO) {
			try {
				String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,default)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ((MemberDTO) dto).getId());
				pstmt.setString(2, ((MemberDTO) dto).getPw());
				pstmt.setString(3, ((MemberDTO) dto).getName());
				pstmt.setString(4, ((MemberDTO) dto).getSid());
				pstmt.setString(5, ((MemberDTO) dto).getPhone());
				pstmt.setString(6, ((MemberDTO) dto).getEmail());
				pstmt.setString(7, ((MemberDTO) dto).getGender());
				pstmt.setInt(8, ((MemberDTO) dto).getAge());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return pstmt;
	}
	
	
}
