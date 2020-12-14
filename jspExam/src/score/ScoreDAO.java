package score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import student.StudentDTO;

public class ScoreDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ScoreDAO() {
	}
	
	public void getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "jspExam";
		String dbPw = "1234";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("오라클 접속 성공");
			
		}catch(Exception e) {
			System.out.println("오라클 접속 실패");
			e.printStackTrace();
		}
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
	
	public int setInsert(ScoreDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into score values(seq_score.nextval,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getHakyun());
			pstmt.setString(2, dto.getTestType());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			pstmt.setInt(6, dto.getSci());
			pstmt.setInt(7, dto.getTot());
			pstmt.setDouble(8, dto.getAvg());
			pstmt.setString(9, dto.getSid());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<ScoreDTO> getListAll(){
		ArrayList<ScoreDTO> list = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from score";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreDTO dto = new ScoreDTO();
				dto.setHakyun(rs.getString("hakyun"));
				dto.setTestType(rs.getString("testType"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSci(rs.getInt("sci"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				dto.setSid(rs.getString("sid"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return list;
	}
	
	public StudentDTO getSelect(String sid) {
		getConn();
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
		getConn();
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
