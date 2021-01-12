package survey.answer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import survey.model.SurveyDTO;

public class AnswerDAO {
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
	
	
	public int[] setInsert(ArrayList<AnswerDTO> dtos) {
		int[] result = null;
		getConn();
		try {
			String sql = "insert into survey_answer (no, survey_no, survey_answer) "
					+ "values(seq_survey_answer.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<dtos.size(); i++) {
				AnswerDTO dto = dtos.get(i);
				pstmt.setInt(1, dto.getServey_no());
				pstmt.setInt(2, dto.getServey_answer());
				pstmt.addBatch();
			}
			result = pstmt.executeBatch();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return result;
	}
	
	public ArrayList<HashMap<SurveyDTO, int[]>> getAnswerAll(){
		ArrayList<HashMap<SurveyDTO, int[]>> list = new ArrayList<>();
		
		
		getConn();
		try {
			String sql = "select a.no, a.question, a.select1, a.select2, a.select3, a.select4, "
					+"(select count(*) FROM survey_answer where survey_answer='1' and survey_no=a.no)AS c1,"
					+"(select count(*) from survey_answer where survey_answer='2' and survey_no=a.no)as c2, "
					+"(select count(*) from survey_answer where survey_answer='3' and survey_no=a.no)as c3, "
					+"(select count(*) from survey_answer where survey_answer='4' and survey_no=a.no)as c4 "
					+"from survey a order by a.no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<SurveyDTO, int[]> alist = new HashMap<>();
				SurveyDTO key = new SurveyDTO();
				int[] value = new int[4];
				key.setNo(rs.getInt("no"));
				key.setQuestion(rs.getString("question"));
				key.setSelect1(rs.getString("select1"));
				key.setSelect2(rs.getString("select2"));
				key.setSelect3(rs.getString("select3"));
				key.setSelect4(rs.getString("select4"));
				value[0] = rs.getInt("c1");
				value[1] = rs.getInt("c2");
				value[2] = rs.getInt("c3");
				value[3] = rs.getInt("c4");
				alist.put(key, value);
				list.add(alist);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		return list;
	}
	
	
	
}
