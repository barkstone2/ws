package model.survey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import model.survey.dto.SurveyDTO;

public class SurveyDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	//String tableName01 = "survey";
	//String tableName02 = "survey_answer";
	
	public SurveyDAO() {
		conn = db.getConn();
	}
	
	public int setInsert(SurveyDTO dto) {
		int result=0;
		try {
			String sql = "insert into survey "
					+ "(no, question, ans1, ans2, ans3, ans4, status, start_date, end_date, regi_date) "
					+ "values(seq_survey.nextval, ?,?,?,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQuestion());
			pstmt.setString(2, dto.getAns1());
			pstmt.setString(3, dto.getAns2());
			pstmt.setString(4, dto.getAns3());
			pstmt.setString(5, dto.getAns4());
			pstmt.setString(6, String.valueOf(dto.getStatus()));
			pstmt.setTimestamp(7, dto.getStart_date()); 
			pstmt.setTimestamp(8, dto.getEnd_date());
			//pstmt.setString(7, "2021-1-1 00:00:00.0"); to_timestamp(?) -> timestamp로 변환
			//pstmt.setString(8, "2021-1-1 23:59:59.9");
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<SurveyDTO> getListAll(int startRecord, int endRecord){
		ArrayList<SurveyDTO> list = new ArrayList<>();
		String basicSql = "select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, "
				+ "a.end_date, a.regi_date, (select count(*) from survey_answer where a.no=no) survey_counter "
				+ "from survey a order by no desc";
		try {
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRecord);
			pstmt.setInt(2, endRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyDTO dto = new SurveyDTO(
						rs.getInt("no"),
						rs.getString("question"),
						rs.getString("ans1"),
						rs.getString("ans2"),
						rs.getString("ans3"),
						rs.getString("ans4"),
						rs.getString("status").charAt(0),
						rs.getTimestamp("start_date"),
						rs.getTimestamp("end_date"),
						rs.getTimestamp("regi_date")
						);
				dto.setSurvey_counter(rs.getInt("survey_counter"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}
	
	public SurveyDTO getView(int no) {
		SurveyDTO dto = null;
		String basicSql = "select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, "
				+ "a.end_date, a.regi_date, (select count(*) from survey_answer where a.no=no) survey_counter "
				+ "from survey a order by no desc";
		try {
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where no=?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new SurveyDTO(
						rs.getInt("no"),
						rs.getString("question"),
						rs.getString("ans1"),
						rs.getString("ans2"),
						rs.getString("ans3"),
						rs.getString("ans4"),
						rs.getString("status").charAt(0),
						rs.getTimestamp("start_date"),
						rs.getTimestamp("end_date"),
						rs.getTimestamp("regi_date")
						);
				dto.setSurvey_counter(rs.getInt("survey_counter"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return dto;
	}
	
	public int getTotalCount() {
		int result = 0;
		try {
			String sql = "select count(*) from survey";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
