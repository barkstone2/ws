package guestbook.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import guestbook.model.dto.GuestBookDTO;
import sqlmap.MybatisManager;

public class GuestBookDAO {
	private SqlSession session;
	
	public GuestBookDAO() {
		session = MybatisManager.getInstance().openSession();
	}
	
	public int setInsert(GuestBookDTO dto) {
		int result = session.insert("guestBook.setInsert", dto);
		session.commit();
		session.close();
		return result;
	}
	
	public List<GuestBookDTO> getListAll(int startRecord, int endRecord){
		
		Map<String, String> map = new HashMap<>();
		map.put("startRecord", startRecord + "");
		map.put("endRecord", endRecord + "");
		List<GuestBookDTO> list = session.selectList("guestBook.getList", map);
		session.close();
		return list;
	}
	
	public int getTotalCount() {
		int result = session.selectOne("guestBook.getTotalRecord");
		session.close();
		return result;
	}
	
}
