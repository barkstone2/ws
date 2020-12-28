package etc.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDAO() {
	}
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "jspModel1";
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
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setInsert(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,?,default,default,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getGender());
			pstmt.setString(9, dto.getJob());
			pstmt.setString(10, dto.getIp());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<MemberDTO> getListAll(){
		ArrayList<MemberDTO> dtos = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setJob(rs.getString("job"));
				dto.setGrade(rs.getString("grade"));
				dto.setRegi_date(String.valueOf(rs.getDate("regi_date")));
				dto.setLoginFailCounter(rs.getInt("loginFailCounter"));
				dto.setIp(rs.getString("ip"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return dtos;
	}
	
	public MemberDTO getSelect(String id) {
		MemberDTO dto = new MemberDTO();
		getConn();
		try {
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setJob(rs.getString("job"));
				dto.setGrade(rs.getString("grade"));
				dto.setRegi_date(String.valueOf(rs.getDate("regi_date")));
				dto.setLoginFailCounter(rs.getInt("loginFailCounter"));
				dto.setIp(rs.getString("ip"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return dto;
	}
	
	public int setFailCounter(String id, int failCounter) {
		getConn();
		int result = 0;
		try {
			String sql = "update member set loginFailCounter=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, failCounter);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	
	
	
}
