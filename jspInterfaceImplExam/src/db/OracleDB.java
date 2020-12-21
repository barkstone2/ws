package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jspInterfaceImplExam.model.resume.ResumeDTO;


public class OracleDB implements Db {

	@Override
	public Connection getConn() {
		Connection conn = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "jspInterfaceImplExam";
			String dbPw = "1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public PreparedStatement setInsert(Object dto, Connection conn) {
		PreparedStatement pstmt = null;
		if(dto instanceof ResumeDTO) {
			try {
				String sql = "insert into resume (no, pic, name, email, phone, address, toeic, toefl, japan, china,"
						+ "gigan1, school1, jeongong1, gigan2, school2, jeongong2, gigan3, school3, jeongong3,"
						+ "gigan4, school4, jeongong4, wdate)"
						+ "values(seq_resume.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,default)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ((ResumeDTO) dto).getPic());
				pstmt.setString(2, ((ResumeDTO) dto).getName());
				pstmt.setString(3, ((ResumeDTO) dto).getEmail());
				pstmt.setString(4, ((ResumeDTO) dto).getPhone());
				pstmt.setString(5, ((ResumeDTO) dto).getAddress());
				pstmt.setInt(6, ((ResumeDTO) dto).getToeic());
				pstmt.setInt(7, ((ResumeDTO) dto).getToefl());
				pstmt.setInt(8, ((ResumeDTO) dto).getJapan());
				pstmt.setInt(9, ((ResumeDTO) dto).getChina());
				pstmt.setString(10, ((ResumeDTO) dto).getGigan1());
				pstmt.setString(11, ((ResumeDTO) dto).getSchool1());
				pstmt.setString(12, ((ResumeDTO) dto).getJeongong1());
				pstmt.setString(13, ((ResumeDTO) dto).getGigan2());
				pstmt.setString(14, ((ResumeDTO) dto).getSchool2());
				pstmt.setString(15, ((ResumeDTO) dto).getJeongong2());
				pstmt.setString(16, ((ResumeDTO) dto).getGigan3());
				pstmt.setString(17, ((ResumeDTO) dto).getSchool3());
				pstmt.setString(18, ((ResumeDTO) dto).getJeongong3());
				pstmt.setString(19, ((ResumeDTO) dto).getGigan4());
				pstmt.setString(20, ((ResumeDTO) dto).getSchool4());
				pstmt.setString(21, ((ResumeDTO) dto).getJeongong4());
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return pstmt;
	}

}
