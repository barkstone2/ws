package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import member.MemberDTO;

public class MySqlDb implements Db{
	
	public MySqlDb() {
	}
	
	@Override
	public Connection getConn() {
		Connection conn = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/jspInterface";
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
				String sql = "insert into member values(?,?,?,?,?,?,?,?,?,now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setNull(1, java.sql.Types.NULL);
				pstmt.setString(2, ((MemberDTO) dto).getId());
				pstmt.setString(3, ((MemberDTO) dto).getPw());
				pstmt.setString(4, ((MemberDTO) dto).getName());
				pstmt.setString(5, ((MemberDTO) dto).getSid());
				pstmt.setString(6, ((MemberDTO) dto).getPhone());
				pstmt.setString(7, ((MemberDTO) dto).getEmail());
				pstmt.setString(8, ((MemberDTO) dto).getGender());
				pstmt.setInt(9, ((MemberDTO) dto).getAge());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return pstmt;
	}
	
	
}
