package survey.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SurveyDAO {
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
	
	
	public int setInsert(SurveyDTO dto) {
		int result=0;
		getConn();
		try {
			String sql = "insert into survey (no,question,select1,select2,select3,select4,status) "
					+ "values(seq_survey.nextval, ?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQuestion());
			pstmt.setString(2, dto.getSelect1());
			pstmt.setString(3, dto.getSelect2());
			pstmt.setString(4, dto.getSelect3());
			pstmt.setString(5, dto.getSelect4());
			pstmt.setString	(6, dto.getStatus());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	public ArrayList<SurveyDTO> getListAll(){
		ArrayList<SurveyDTO> dtos = new ArrayList<SurveyDTO>();
		getConn();
		try {
			String sql = "select * from survey order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyDTO dto = new SurveyDTO(
						rs.getInt("no"), 
						rs.getString("question"), 
						rs.getString("select1"), 
						rs.getString("select2"), 
						rs.getString("select3"), 
						rs.getString("select4"), 
						rs.getString("status"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return dtos;
	}
	
	public ArrayList<SurveyDTO> getSurveyAll(){
		ArrayList<SurveyDTO> dtos = new ArrayList<SurveyDTO>();
		getConn();
		try {
			String sql = "select * from survey where status='1'order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyDTO dto = new SurveyDTO(
						rs.getInt("no"), 
						rs.getString("question"), 
						rs.getString("select1"), 
						rs.getString("select2"), 
						rs.getString("select3"), 
						rs.getString("select4"), 
						rs.getString("status"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return dtos;
	}
	
	public SurveyDTO getSelect(int no) {
		SurveyDTO dto = null;
		getConn();
		try {
			String sql = "select * from survey where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new SurveyDTO(
						rs.getInt("no"), 
						rs.getString("question"), 
						rs.getString("select1"), 
						rs.getString("select2"), 
						rs.getString("select3"), 
						rs.getString("select4"), 
						rs.getString("status"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return dto;
	}
	
	public int setUpdate(SurveyDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update survey set question=?, select1=?, select2=?, select3=?, select4=?, status=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQuestion());
			pstmt.setString(2, dto.getSelect1());
			pstmt.setString(3, dto.getSelect2());
			pstmt.setString(4, dto.getSelect3());
			pstmt.setString(5, dto.getSelect4());
			pstmt.setString(6, dto.getStatus());
			pstmt.setInt(7, dto.getNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	public int setDelete(int no) {
		int result = 0;
		getConn();
		try {
			String sql = "delete from survey where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	
}
