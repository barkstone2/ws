package member.model;

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
			String dbId = "test0201";
			String dbPw = "1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("오라클 접속 성공");
		}catch (Exception e) {
			System.out.println("오라클 접속 실패");
			e.printStackTrace();
		}
	}
	
	public void quitConn(ResultSet rs, PreparedStatement pstmt, Connection conn) {
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
	
	public int idCheck(String id) {
		getConn();
		int result = 0;
		try {
			String sql = "select id from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn(rs, pstmt, conn);
		}
		return result;
	}
	public int setInsert(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql ="insert into member (no, id, pw, name, gender, bornYear, postCode, bAddr, sAddr, rAddr, regiDate) "
					+ "values (seq_member.nextval, ?,?,?,?,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getBornYear());
			pstmt.setString(6, dto.getPostCode());
			pstmt.setString(7, dto.getbAddr());
			pstmt.setString(8, dto.getsAddr());
			pstmt.setString(9, dto.getrAddr());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<MemberDTO> getListAll(){
		ArrayList<MemberDTO> list = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getInt("bornYear"),
						rs.getString("postCode"),
						rs.getString("bAddr"),
						rs.getString("sAddr"),
						rs.getString("rAddr"));
				dto.setNo(rs.getInt("no"));
				dto.setRegiDate(rs.getTimestamp("regiDate"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn(rs, pstmt, conn);
		}
		return list;
	}
	
	public MemberDTO getView(int no) {
		MemberDTO dto = null;
		getConn();
		try {
			String sql = "select * from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getInt("bornYear"),
						rs.getString("postCode"),
						rs.getString("bAddr"),
						rs.getString("sAddr"),
						rs.getString("rAddr"));
				dto.setNo(rs.getInt("no"));
				dto.setRegiDate(rs.getTimestamp("regiDate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn(rs, pstmt, conn);
		}
		return dto;
	}
	
	public int setUpdate(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update member set gender=?, bornYear=?, postCode=?, bAddr=?, sAddr=?, rAddr=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender());
			pstmt.setInt(2, dto.getBornYear());
			pstmt.setString(3, dto.getPostCode());
			pstmt.setString(4, dto.getbAddr());
			pstmt.setString(5, dto.getsAddr());
			pstmt.setString(6, dto.getrAddr());
			pstmt.setInt(7, dto.getNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
}
