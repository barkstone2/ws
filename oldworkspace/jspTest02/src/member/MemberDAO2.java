package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO2 {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO2() {
	}
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "jspTest";
			String dbPw = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("오라클 접속 성공");
		}catch(Exception e) {
			System.out.println("오라클 접속 에러");
			e.printStackTrace();
		}
	} //getConn() End
	
	public int setInsert(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into joinTBL01 values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.setInt(6, dto.getBirth());
			result = pstmt.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	} //setInsert() End
	
	
}
