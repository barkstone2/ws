package resume;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ResumeDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ResumeDAO() {
	}
	
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
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setInsert(ResumeDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into resume (no, pic, name, email, phone, address, toeic, toefl, japan, china,"
					+ "gigan1, school1, jeongong1, gigan2, school2, jeongong2, gigan3, school3, jeongong3,"
					+ "gigan4, school4, jeongong4, wdate)"
					+ "values(seq_resume.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPic());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getAddress());
			pstmt.setInt(6, dto.getToeic());
			pstmt.setInt(7, dto.getToefl());
			pstmt.setInt(8, dto.getJapan());
			pstmt.setInt(9, dto.getChina());
			pstmt.setString(10, dto.getGigan1());
			pstmt.setString(11, dto.getSchool1());
			pstmt.setString(12, dto.getJeongong1());
			pstmt.setString(13, dto.getGigan2());
			pstmt.setString(14, dto.getSchool2());
			pstmt.setString(15, dto.getJeongong2());
			pstmt.setString(16, dto.getGigan3());
			pstmt.setString(17, dto.getSchool3());
			pstmt.setString(18, dto.getJeongong3());
			pstmt.setString(19, dto.getGigan4());
			pstmt.setString(20, dto.getSchool4());
			pstmt.setString(21, dto.getJeongong4());
			result = pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}

	
	
	public ArrayList<ResumeDTO> getListAll(){
		ArrayList<ResumeDTO> list = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from resume order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResumeDTO dto = new ResumeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setPic(rs.getString("pic"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setToeic(rs.getInt("toeic"));
				dto.setToefl(rs.getInt("toefl"));
				dto.setJapan(rs.getInt("japan"));
				dto.setChina(rs.getInt("china"));
				dto.setGigan1(rs.getString("gigan1"));
				dto.setSchool1(rs.getString("school1"));
				dto.setJeongong1(rs.getString("jeongong1"));
				dto.setGigan2(rs.getString("gigan2"));
				dto.setSchool2(rs.getString("school2"));
				dto.setJeongong2(rs.getString("jeongong2"));
				dto.setGigan3(rs.getString("gigan3"));
				dto.setSchool3(rs.getString("school3"));
				dto.setJeongong3(rs.getString("jeongong3"));
				dto.setGigan4(rs.getString("gigan4"));
				dto.setSchool4(rs.getString("school4"));
				dto.setJeongong4(rs.getString("jeongong4"));
				dto.setWdate(rs.getDate("wdate"));
				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return list;
	}
	
	public ResumeDTO getSelect(String no) {
		ResumeDTO dto = new ResumeDTO();
		getConn();
		try {
			String sql = "select * from resume where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setPic(rs.getString("pic"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setToeic(rs.getInt("toeic"));
				dto.setToefl(rs.getInt("toefl"));
				dto.setJapan(rs.getInt("japan"));
				dto.setChina(rs.getInt("china"));
				dto.setGigan1(rs.getString("gigan1"));
				dto.setSchool1(rs.getString("school1"));
				dto.setJeongong1(rs.getString("jeongong1"));
				dto.setGigan2(rs.getString("gigan2"));
				dto.setSchool2(rs.getString("school2"));
				dto.setJeongong2(rs.getString("jeongong2"));
				dto.setGigan3(rs.getString("gigan3"));
				dto.setSchool3(rs.getString("school3"));
				dto.setJeongong3(rs.getString("jeongong3"));
				dto.setGigan4(rs.getString("gigan4"));
				dto.setSchool4(rs.getString("school4"));
				dto.setJeongong4(rs.getString("jeongong4"));
				dto.setWdate(rs.getDate("wdate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int setUpdate(ResumeDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update resume set pic=?, email=?, phone=?, address=?, toeic=?, toefl=?, japan=?, china=?,"
					+ "gigan1=?, school1=?, jeongong1=?, gigan2=?, school2=?, jeongong2=?,"
					+ "gigan3=?, school3=?, jeongong3=?, gigan4=?, school4=?, jeongong4=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPic());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddress());
			pstmt.setInt(5, dto.getToeic());
			pstmt.setInt(6, dto.getToefl());
			pstmt.setInt(7, dto.getJapan());
			pstmt.setInt(8, dto.getChina());
			pstmt.setString(9, dto.getGigan1());
			pstmt.setString(10, dto.getSchool1());
			pstmt.setString(11, dto.getJeongong1());
			pstmt.setString(12, dto.getGigan2());
			pstmt.setString(13, dto.getSchool2());
			pstmt.setString(14, dto.getJeongong2());
			pstmt.setString(15, dto.getGigan3());
			pstmt.setString(16, dto.getSchool3());
			pstmt.setString(17, dto.getJeongong3());
			pstmt.setString(18, dto.getGigan4());
			pstmt.setString(19, dto.getSchool4());
			pstmt.setString(20, dto.getJeongong4());
			pstmt.setInt(21, dto.getNo());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public int setDelete(String no) {
		int result = 0;
		getConn();
		try {
			String sql = "delete from resume where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	
	
	
	
}
