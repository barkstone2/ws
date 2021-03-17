package member.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import member.model.dto.MemberDTO;
import sqlmap.MybatisManager;

public class MemberDAO {
	private SqlSession session;
	
	public MemberDAO() {
		session = MybatisManager.getInstance().openSession();
	}
	
	public int setInsert(MemberDTO dto) {
		int result = session.insert("member.setInsert", dto);
		session.commit();
		session.close();
		return result;
	}
	
	public int getLogin(String id, String pw) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		int result = 0;
		int temp = session.selectOne("member.getLogin", map);
		
		if(temp>0) {
			result = 1;
		}else {
			temp = session.selectOne("member.getLoginChk", map);
			if(temp>0) result = -1;
		}
		
		session.close();
		return result;
	}
	
	public MemberDTO getSelect(String id) {
		MemberDTO dto = session.selectOne("member.getSelect", id);
		session.close();
		return dto;
	}
	
	public MemberDTO getView(int no) {
		MemberDTO dto = session.selectOne("member.getView", no);
		session.close();
		return dto;
	}
	
	public List<MemberDTO> getListAll(int startRecord, int endRecord, String search_option, String search_data){
		Map<String, String> map = new HashMap<>();
		map.put("startRecord", startRecord + "");
		map.put("endRecord", endRecord + "");
		map.put("search_option", search_option);
		map.put("search_data", search_data);
		List<MemberDTO> list = session.selectList("member.getList", map);
		session.close();
		return list;
	}
	
	
	
	public int setUpdate(MemberDTO dto) {
		int result = session.insert("member.setUpdate", dto);
		session.commit();
		session.close();
		return result;
	}
	
	public int setDelete(MemberDTO dto) {
		int result = session.insert("member.setDelete", dto);
		session.commit();
		session.close();
		return result;
	}
	
	public int idCheck(String id) {
		int result = session.selectOne("member.idCheck", id);
		return result;
	}

	public int getTotalCount(String search_option, String search_data) {
		Map<String, String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("search_data", search_data);
		int result = session.selectOne("member.getTotalRecord", map);
		return result;
	}
	
	
}
