package memo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import memo.model.dto.MemoDTO;


public class MemoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "model2";
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
	
	public int setInsert(MemoDTO dto) {
		int result=0;
		getConn();
		try {
			String sql = "insert into memo (no, writer, content, regi_date) "
					+ "values(seq_memo.nextval, ?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	public ArrayList<MemoDTO> getListAll(){
		ArrayList<MemoDTO> dtos = new ArrayList<>();
		getConn();
		try {
			String coreSql = "select * from memo ";
			String orderBy = "order by no";
			coreSql += orderBy;
			String sql = coreSql;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemoDTO dto = new MemoDTO(
						rs.getInt("no"), 
						rs.getString("writer"), 
						rs.getString("content"), 
						rs.getString("regi_date"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return dtos;
	}
	
	
	
	
}
