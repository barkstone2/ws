package com.gb.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gb.model.dto.GuestBookDTO;

public class GuestBookDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "aca";
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
	
	
	public int setInsert(GuestBookDTO dto) {
		int result=0;
		getConn();
		try {
			String sql = "insert into guestbook (no, name, email, passwd, content, write_date) "
					+ "values(seq_gbook.nextval, ?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getContent());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	public ArrayList<GuestBookDTO> getListAll(String searchType, String searchData){
		ArrayList<GuestBookDTO> dtos = new ArrayList<>();
		getConn();
		try {
			String coreSql = "select * from guestbook ";
			String orderBy = "order by no";
			if(searchType != null && searchData != null){
				if(searchType.equals("all")) {
					coreSql += "where name like ? or content like ? ";
				}else{
					coreSql += "where "+searchType+" like ? ";
				}
			}
			coreSql += orderBy;
			
			
			String sql = coreSql;
			pstmt = conn.prepareStatement(sql);
			
			if(searchType != null && searchData != null) {
				pstmt.setString(1, "%"+searchData+"%");
				if(searchType.equals("all")) {
					pstmt.setString(2, "%"+searchData+"%");
				}
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestBookDTO dto = new GuestBookDTO(
						rs.getInt("no"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("passwd"), 
						rs.getString("content"), 
						rs.getString("write_date"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return dtos;
	}
	
	
//	public int setUpdate(SurveyDTO dto) {
//		int result = 0;
//		getConn();
//		try {
//			String sql = "update survey set question=?, select1=?, select2=?, select3=?, select4=?, status=? where no=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dto.getQuestion());
//			pstmt.setString(2, dto.getSelect1());
//			pstmt.setString(3, dto.getSelect2());
//			pstmt.setString(4, dto.getSelect3());
//			pstmt.setString(5, dto.getSelect4());
//			pstmt.setString(6, dto.getStatus());
//			pstmt.setInt(7, dto.getNo());
//			result = pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			quitConn();
//		}
//		return result;
//	}
//	
//	public int setDelete(int no) {
//		int result = 0;
//		getConn();
//		try {
//			String sql = "delete from survey where no=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, no);
//			result = pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			quitConn();
//		}
//		return result;
//	}
	
}
