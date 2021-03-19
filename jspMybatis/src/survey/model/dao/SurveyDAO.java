package survey.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import sqlmap.MybatisManager;
import survey.model.dto.SurveyAnswerDTO;
import survey.model.dto.SurveyDTO;

public class SurveyDAO {
	private SqlSession session;
	
	//String tableName01 = "survey";
	//String tableName02 = "survey_answer";
	
	public SurveyDAO() {
		session = MybatisManager.getInstance().openSession();
	}
	
	public int setInsert(SurveyDTO dto) {
		int result = session.insert("survey.setInsert", dto);
		session.commit();
		session.close();
		return result;
	}
	
	public List<SurveyDTO> getListAll(int startRecord, int endRecord, String list_gubun, String search_option, 
			String search_data, String search_date_s, String search_date_e){
		Map<String, String> map = new HashMap<>();
		map.put("startRecord", startRecord + "");
		map.put("endRecord", endRecord + "");
		map.put("list_gubun", list_gubun);
		map.put("search_option", search_option);
		map.put("search_data", search_data);
		map.put("search_date_s", search_date_s);
		map.put("search_date_e", search_date_e);
		List<SurveyDTO> list = session.selectList("survey.getList", map);
		session.close();
		return list;
	}
	
	
	public SurveyDTO getView(int no) {
		SurveyDTO dto = session.selectOne("survey.getView", no);
		session.close();
		return dto;
	}
	
	public int setAnswer(SurveyAnswerDTO dto) {
		int result = session.insert("survey.setAnswer", dto);
		session.commit();
		session.close();
		return result;
	}
	
	
	public int getTotalCount(String list_gubun, String search_option, 
			String search_data, String search_date_s, String search_date_e) {
		Map<String, String> map = new HashMap<>();
		map.put("list_gubun", list_gubun);
		map.put("search_option", search_option);
		map.put("search_data", search_data);
		map.put("search_date_s", search_date_s);
		map.put("search_date_e", search_date_e);
		int result = session.selectOne("survey.getTotalRecord", map);
		return result;
	}
	
	public int setUpdate(SurveyDTO dto) {
		int result = session.insert("survey.setUpdate", dto);
		session.commit();
		session.close();
		return result;
	}
	
	
}
