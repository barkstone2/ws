package jspInterfaceImplExam.model.resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.MySqlDB;
import db.OracleDB;

@SuppressWarnings("unused")
public class ResumeDAO {
	private Db db = new OracleDB();
	private Connection conn = db.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ResumeDAO() {
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
		try {
			pstmt = db.setInsert(dto, conn);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}

	
	
	public ArrayList<ResumeDTO> getListAll(){
		ArrayList<ResumeDTO> list = new ArrayList<>();
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
		}
		quitConn();
		return list;
	}
	
	public ResumeDTO getSelect(String no) {
		ResumeDTO dto = new ResumeDTO();
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
		try {
			String sql = "update resume set pic=?, email=?, phone=?, address=?, toeic=?, toefl=?, japan=?, china=?,"
					+ "gigan1=?, school1=?, jeongong1=?, gigan2=?, school2=?, jeongong2=?,"
					+ "gigan3=?, school3=?, jeongong3=?, gigan4=?, school4=?, jeongong4=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((ResumeDTO) dto).getPic());
			pstmt.setString(2, ((ResumeDTO) dto).getEmail());
			pstmt.setString(3, ((ResumeDTO) dto).getPhone());
			pstmt.setString(4, ((ResumeDTO) dto).getAddress());
			pstmt.setInt(5, ((ResumeDTO) dto).getToeic());
			pstmt.setInt(6, ((ResumeDTO) dto).getToefl());
			pstmt.setInt(7, ((ResumeDTO) dto).getJapan());
			pstmt.setInt(8, ((ResumeDTO) dto).getChina());
			pstmt.setString(9, ((ResumeDTO) dto).getGigan1());
			pstmt.setString(10, ((ResumeDTO) dto).getSchool1());
			pstmt.setString(11, ((ResumeDTO) dto).getJeongong1());
			pstmt.setString(12, ((ResumeDTO) dto).getGigan2());
			pstmt.setString(13, ((ResumeDTO) dto).getSchool2());
			pstmt.setString(14, ((ResumeDTO) dto).getJeongong2());
			pstmt.setString(15, ((ResumeDTO) dto).getGigan3());
			pstmt.setString(16, ((ResumeDTO) dto).getSchool3());
			pstmt.setString(17, ((ResumeDTO) dto).getJeongong3());
			pstmt.setString(18, ((ResumeDTO) dto).getGigan4());
			pstmt.setString(19, ((ResumeDTO) dto).getSchool4());
			pstmt.setString(20, ((ResumeDTO) dto).getJeongong4());
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
