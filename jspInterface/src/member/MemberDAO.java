package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.MySqlDb;
import db.OracleDb;

@SuppressWarnings("unused")
public class MemberDAO {
//	private Db db = new OracleDb();
	private Db db = new MySqlDb();
	private Connection conn = db.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
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
			pstmt = db.setInsert(dto, conn);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<MemberDTO> getListAll(){
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			String sql = "select * from member order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setSid(rs.getString("sid"));
				dto.setAge(rs.getInt("age"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setPhone(rs.getString("phone"));
				dto.setWdate(rs.getDate("wdate"));
				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return list;
	}
	
	public MemberDTO getSelect(String id) {
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setSid(rs.getString("sid"));
				dto.setAge(rs.getInt("age"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setPhone(rs.getString("phone"));
				dto.setWdate(rs.getDate("wdate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int setUpdate(MemberDTO dto) {
		int result = 0;
		try {
			String sql = "update member set phone=?, email=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public int setDelete(String id) {
		int result = 0;
		try {
			String sql = "delete from member where id=?";
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
