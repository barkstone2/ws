package db;

import java.sql.PreparedStatement;

import java.sql.Connection;

public class DbMethod {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	
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
	
}
