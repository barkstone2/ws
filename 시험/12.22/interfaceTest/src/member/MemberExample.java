package member;

import java.util.ArrayList;

public class MemberExample {

//	private MemberDAO dao = new MemberDAOImplOracle();
	private MemberDAO dao = new MemberDAOImplMySQL();
	
	public MemberExample() {
	}

	public void getConn() {
		dao.getConn();
	}
	public int setInsert(MemberDTO dto) {
		return dao.setInsert(dto);
	}
	public ArrayList<MemberDTO> getListAll(){
		return dao.getListAll();
	}
	public MemberDTO getSelect(String id) {
		return dao.getSelect(id);
	}
	public int setUpdate(MemberDTO dto) {
		return dao.setUpdate(dto);
	}
	public int setDelete(String id) {
		return dao.setDelete(id);
	}
}
