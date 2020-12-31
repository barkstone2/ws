package member.model;

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
			String dbId = "includeEx02";
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
			String sql = "insert into member (no, id, passwd, name, gender, bornYear, regiDate) "
					+ "values(seq_member.nextval,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getBornYear());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
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
						rs.getString("passwd"), 
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("bornYear"), 
						rs.getTimestamp("regiDate")
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();	
		return dto;
	}
	
	public MemberDTO getView(int no) {
		MemberDTO dto = new MemberDTO();
		getConn();
		try {
			String sql = "select * from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("passwd"), 
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("bornYear"), 
						rs.getTimestamp("regiDate")
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();	
		return dto;
	}
	
	public ArrayList<MemberDTO> getListAll(){
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		getConn();
		try {
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("passwd"), 
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("bornYear"), 
						rs.getTimestamp("regiDate")
						);
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return dtos;
	}
	
	public int setUpdate(MemberDTO dto, int cookNo) {
		int result = 0;
		getConn();
		try {
			String sql = "update member set bornYear=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBornYear());
			pstmt.setInt(2, cookNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public int setDelete(int cookNo) {
		int result = 0;
		getConn();
		try {
			String sql = "delete from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cookNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
}
