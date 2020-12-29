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
			String dbId = "jspws";
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
	
	public int setInsert(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into member "
					+ "(no,id,pw,name,nickname,phone,email,addr,gender,job,grade,rdate,ip,loginfailcounter) "
					+ "values(seq_member.nextval,?,?,?,?,?,?,?,?,?,default,default,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getAddr());
			pstmt.setString(8, dto.getGender());
			pstmt.setString(9, dto.getJob());
			pstmt.setString(10, dto.getIp());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<MemberDTO> getListAll(){
		ArrayList<MemberDTO> dtos = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from member order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = 
						new MemberDTO(
								rs.getInt("no"), 
								rs.getString("id"), 
								rs.getString("pw"),
								rs.getString("name"),
								rs.getString("nickname"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getString("addr"),
								rs.getString("gender"),
								rs.getString("job"),
								rs.getString("grade"),
								rs.getString("rdate"),
								rs.getString("ip"),
								rs.getInt("loginfailcounter")
								);
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
				dto = new MemberDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("nickname"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("addr"),
						rs.getString("gender"),
						rs.getString("job"),
						rs.getString("grade"),
						rs.getString("rdate"),
						rs.getString("ip"),
						rs.getInt("loginfailcounter")
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return dto;
	}
	
	public int setUpdate(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update member set nickname=?, phone=?, email=?, addr=?, job=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getJob());
			pstmt.setString(6, dto.getId());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public int setDelete(String id) {
		int result = 0;
		getConn();
		try {
			String sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public void setLoginFailCounter(String id, int loginFailCounter) {
		getConn();
		try {
			String sql = "update member set loginFailCounter=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, loginFailCounter);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
	}
	
	
	
}
