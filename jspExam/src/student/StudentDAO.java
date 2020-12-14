package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;


public class StudentDAO {

	private Connection conn = Db.getConn();;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public StudentDAO() {
	}
	
	public void quitConn() {
		try {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setInsert(StudentDTO dto) {
		int result = 0;
		try {
			String sql = "insert into student values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSid());
			pstmt.setString(2, dto.getSname());
			pstmt.setString(3, dto.getSphone());
			pstmt.setString(4, dto.getPname());
			pstmt.setString(5, dto.getPphone());
			pstmt.setString(6, dto.getAddr());
			pstmt.setString(7, dto.getHakyun());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<StudentDTO> getListAll(){
		ArrayList<StudentDTO> list = new ArrayList<>();
		try {
			String sql = "";
			sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setSid(rs.getString("sid"));
				dto.setSname(rs.getString("sname"));
				dto.setSphone(rs.getString("sphone"));
				dto.setPname(rs.getString("pname"));
				dto.setPphone(rs.getString("pphone"));
				dto.setAddr(rs.getString("addr"));
				dto.setHakyun(rs.getString("hakyun"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return list;
	}
	
	public StudentDTO getSelect(String sid) {
		StudentDTO dto = new StudentDTO();
		try {
			String sql = "select * from student where sid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setSid(rs.getString("sid"));
				dto.setSname(rs.getString("sname"));
				dto.setSphone(rs.getString("sphone"));
				dto.setPname(rs.getString("pname"));
				dto.setPphone(rs.getString("pphone"));
				dto.setAddr(rs.getString("addr"));
				dto.setHakyun(rs.getString("hakyun"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return dto;
	}
	
	public int setUpdate(StudentDTO dto) {
		int result = 0;
		try {
			String sql = "update student set sphone=?, pphone=?, addr=? where sid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSphone());
			pstmt.setString(2, dto.getPphone());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getSid());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
}
