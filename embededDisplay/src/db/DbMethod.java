package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

public class DbMethod {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	Db db = new DbImplOracle();
	
	public void setInsert(HumanDTO dto) {
		conn = db.getConn();
		try {
			String sql = "insert into wallPad values(?,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAptId());
			pstmt.setString(2, dto.getSecurity());
			pstmt.setString(3, dto.getLight());
			pstmt.setString(4, dto.getAirConditioner());
			pstmt.setString(5, dto.getTelevision());
			pstmt.setString(6, dto.getCucu());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.getConnClose();
		}
	}
	
	public ArrayList<HumanDTO> getListAll(){
		ArrayList<HumanDTO> dtos = new ArrayList<>();
		conn = db.getConn();
		try {
			String sql = "select * from wallpad";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HumanDTO dto = new HumanDTO(
						rs.getString("aptid"), 
						rs.getString("security"), 
						rs.getString("light"), 
						rs.getString("airConditioner"), 
						rs.getString("television"), 
						rs.getString("cucu"));
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.getConnClose();
		}
		return dtos;
	}
	
	
}
