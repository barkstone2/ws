package member02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.Db;
import db.MySqlDb;
import db.OracleDb;
import member.MemberDTO;

public class Member02DAO {
	private Db db = new MySqlDb();
	private Connection conn = db.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Member02DAO() {
	}
	
	public void quitConn() {
		try {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setInsert(MemberDTO dto) {
		int result = 0;
		try {
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1, java.sql.Types.NULL);
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, dto.getSid());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getGender());
			pstmt.setInt(9, dto.getAge());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
}
