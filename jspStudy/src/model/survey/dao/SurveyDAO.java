package model.survey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import model.survey.dto.SurveyAnswerDTO;
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
	
	public ArrayList<SurveyDTO> getListAll(int startRecord, int endRecord, String list_gubun, String search_option, 
			String search_data, String search_date_s, String search_date_e){
		ArrayList<SurveyDTO> list = new ArrayList<>();
		String basicSql = "select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, "
				+ "a.end_date, a.regi_date, (select count(*) from survey_answer where a.no=no) survey_counter "
				+ "from survey a where no>0";
		String orderBy = " order by end_date desc, regi_date desc";
		try {
			boolean[] sqlCheck = new boolean[2];
			if(list_gubun!=null) {
				if(list_gubun.equals("doing")) {
					basicSql+= " and status=1 and current_timestamp between start_date and end_date";
				}else if(list_gubun.equals("ended")) {
					basicSql+= " and (status=0 or current_timestamp > end_date)";
				}
			}
			if(search_option.length()>0&&search_data.length()>0) {
				basicSql+= " and "+search_option+" like ?";
				sqlCheck[0] = true;
			}
			if(search_date_s.length()>0 && search_date_e.length()>0) {
				basicSql+= " and (start_date>=to_timestamp(?) and end_date<=to_timestamp(?))";
				sqlCheck[1] = true;
			}
			basicSql += orderBy;
			int k = 0;  //++k
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?";
			pstmt = conn.prepareStatement(sql);
			if(sqlCheck[0]&&!sqlCheck[1]) {
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setInt(2, startRecord);
				pstmt.setInt(3, endRecord);
			}else if(sqlCheck[0]&&sqlCheck[1]) {
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setString(2, search_date_s);
				pstmt.setString(3, search_date_e);
				pstmt.setInt(4, startRecord);
				pstmt.setInt(5, endRecord);
			}else if(sqlCheck[1]&&!sqlCheck[0]) {
				pstmt.setString(1, search_date_s);
				pstmt.setString(2, search_date_e);
				pstmt.setInt(3, startRecord);
				pstmt.setInt(4, endRecord);
			}else {
				pstmt.setInt(1, startRecord);
				pstmt.setInt(2, endRecord);
			}
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
				+ "a.end_date, a.regi_date, (select count(*) from survey_answer where a.no=no) survey_counter, "
				+ "b.ans1c, b.ans2c, b.ans3c, b.ans4c "
				+ "from survey a, v_ansCount b where a.no=b.no(+)";
		try {
			String sql = "select rownum rn, tb.* from ("+basicSql+") tb where tb.no=?"; 
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
				dto.setAns1c(rs.getInt("ans1c"));
				dto.setAns2c(rs.getInt("ans2c"));
				dto.setAns3c(rs.getInt("ans3c"));
				dto.setAns4c(rs.getInt("ans4c"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return dto;
	}
	
	public int setAnswer(SurveyAnswerDTO dto) {
		int result =0;
		try {
			String sql = "insert into survey_answer "
					+ "(answer_no, no, answer, regi_date) "
					+ "values(seq_answer.nextval, ?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setInt(2, dto.getAnswer());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	
	public int getTotalCount(String list_gubun, String search_option, 
			String search_data, String search_date_s, String search_date_e) {
		int result = 0;
		try {
			boolean[] sqlCheck = new boolean[2];
			String sql = "select count(*) from survey where no>0";
			if(list_gubun!=null) {
				if(list_gubun.equals("doing")) {
					sql+= " and status=1 and current_timestamp between start_date and end_date";
				}else if(list_gubun.equals("ended")) {
					sql+= " and (status=0 or current_timestamp > end_date)";
				}
			}
			if(search_option.length()>0&&search_data.length()>0) {
					sql+= " and "+search_option+" like ?";
					sqlCheck[0] = true;
			}
			if(search_date_s.length()>0&&search_date_e.length()>0) {
				sql+= " and (start_date>=to_timestamp(?) and end_date<=to_timestamp(?))";
				sqlCheck[1] = true;
			}
			pstmt = conn.prepareStatement(sql);
			if(sqlCheck[0]&&sqlCheck[1]) {
				pstmt.setString(1, "%"+search_data+"%");
				pstmt.setString(2, search_date_s);
				pstmt.setString(3, search_date_e);
			}else if(sqlCheck[0]&&!sqlCheck[1]) {
				pstmt.setString(1, "%"+search_data+"%");
			}else if(sqlCheck[1]&&!sqlCheck[0]) {
				pstmt.setString(1, search_date_s);
				pstmt.setString(2, search_date_e);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int setUpdate(SurveyDTO dto) {
		int result=0;
		try {
			String sql = "update survey set question=?, ans1=?, ans2=?, ans3=?, ans4=?, status=?, start_date=?, end_date=?"
					+ " where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQuestion());
			pstmt.setString(2, dto.getAns1());
			pstmt.setString(3, dto.getAns2());
			pstmt.setString(4, dto.getAns3());
			pstmt.setString(5, dto.getAns4());
			pstmt.setString(6, String.valueOf(dto.getStatus()));
			pstmt.setTimestamp(7, dto.getStart_date()); 
			pstmt.setTimestamp(8, dto.getEnd_date());
			pstmt.setInt(9, dto.getNo());
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
	
	
}
