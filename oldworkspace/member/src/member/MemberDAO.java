package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
	}
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "member";
			String dbPw = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("오라클 접속 성공");
		}catch(Exception e) {
			System.out.println("오라클 접속 실패");
			e.printStackTrace();
		}
	}
	
	public void quitConn() {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setInsert(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into memberdb values(?,?,?,?,?,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getBirth());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getAddr());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<MemberDTO> getListAll() {
		ArrayList<MemberDTO> list = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from memberdb where invalidCheck=0";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getInt("birth"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddr(rs.getString("addr"));
				dto.setJDate(rs.getDate("jDate"));
				dto.setInvalidCheck(0);
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return list;
	}
	
	public MemberDTO getSelect(String id) {
		getConn();
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select * from memberDB where id=? and invalidCheck=0";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getInt("birth"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddr(rs.getString("addr"));
				dto.setJDate(rs.getDate("jdate"));
				dto.setInvalidCheck(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return dto;
	}
	
	public int setUpdate(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update memberDB set phone=?, email=?, addr=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public int setDelete(String id) {
		int result = 0;
		getConn();
		try {
			String sql = "update memberDB set invalidCheck=1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
}
