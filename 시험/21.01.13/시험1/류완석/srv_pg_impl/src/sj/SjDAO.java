package sj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;

public class SjDAO {
	private Connection conn = Db.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SjDAO() {
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
	
	public int setInsert(SjDTO dto) {
		int result = 0;
		try {
			String sql = "insert into sj values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getSname());
			pstmt.setInt(3, dto.getMun_1());
			pstmt.setInt(4, dto.getMun_2());
			pstmt.setInt(5, dto.getMun_3());
			pstmt.setInt(6, dto.getMun_4());
			pstmt.setInt(7, dto.getMun_5());
			pstmt.setString(8, dto.getMun_ox_1());
			pstmt.setString(9, dto.getMun_ox_2());
			pstmt.setString(10, dto.getMun_ox_3());
			pstmt.setString(11, dto.getMun_ox_4());
			pstmt.setString(12, dto.getMun_ox_5());
			pstmt.setInt(13, dto.getJumsu());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<SjDTO> getListAll(){
		ArrayList<SjDTO> list = new ArrayList<>();
		try {
			String sql = "select * from sj order by name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SjDTO dto = new SjDTO();
				dto.setName(rs.getString("name"));
				dto.setSname(rs.getString("sname"));
				dto.setMun_1(rs.getInt("mun_1"));
				dto.setMun_2(rs.getInt("mun_2"));
				dto.setMun_3(rs.getInt("mun_3"));
				dto.setMun_4(rs.getInt("mun_4"));
				dto.setMun_5(rs.getInt("mun_5"));
				dto.setMun_ox_1(rs.getString("mun_ox_1"));
				dto.setMun_ox_2(rs.getString("mun_ox_2"));
				dto.setMun_ox_3(rs.getString("mun_ox_3"));
				dto.setMun_ox_4(rs.getString("mun_ox_4"));
				dto.setMun_ox_5(rs.getString("mun_ox_5"));
				dto.setJumsu(rs.getInt("jumsu"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
