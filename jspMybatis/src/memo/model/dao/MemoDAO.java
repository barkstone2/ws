package memo.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import memo.model.dto.MemoDTO;
import sqlmap.MybatisManager;

public class MemoDAO {
	private SqlSession session;
	
	public MemoDAO() {
		session = MybatisManager.getInstance().openSession();
	}
	
	public int setInsert(MemoDTO dto) {
		int result = session.insert("memo.setInsert", dto);
		session.commit();
		session.close();
		return result;
	}
	
	public MemoDTO getView(int no) {
		MemoDTO dto = session.selectOne("memo.getView", no);
		session.close();
		return dto;
	}
	
	public List<MemoDTO> getListAll(int startRecord, int endRecord){
		Map<String, String> map = new HashMap<>();
		map.put("startRecord", startRecord + "");
		map.put("endRecord", endRecord + "");
		List<MemoDTO> list = session.selectList("memo.getList", map);
		session.close();
		return list;
	}
	
	public int setUpdate(String id, String content, int no) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("content", content);
		map.put("no", no+"");
		int result = session.insert("memo.setUpdate", map);
		session.commit();
		session.close();
		return result;
	}
	
	public int getTotalCount() {
		int result = session.selectOne("memo.getTotalRecord");
		session.close();
		return result;
	}

	public void setDelete(int no) {
		session.insert("memo.setDelete", no);
		session.commit();
		session.close();
	}
	
	
}
