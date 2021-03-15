package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import member.model.dto.MemberDTO;

public class MemberDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDAO() {
		conn = db.getConn();
	}
	
	public int setInsert(MemberDTO dto) {
		int result=0;
		try {
			String sql = "insert into member "
					+ "(no, id, pw, name, gender, bornYear, regi_date, postcode, bAddr, sAddr, refAddr) "
					+ "values(seq_member.nextval, ?,?,?,?,?,default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getBornYear());
			pstmt.setString(6, dto.getPostcode());
			pstmt.setString(7, dto.getbAddr());
			pstmt.setString(8, dto.getsAddr());
			pstmt.setString(9, dto.getRefAddr());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	
	public int getLogin(String id, String pw) {
		int result = 0; // 등록되지 않은 ID
		try {
			String basicSql = "select no, id, pw, name, gender, bornYear, regi_date, postcode, bAddr, sAddr, refAddr "
					+ "from member";
			String sql = basicSql+ " where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1; // 로그인 성공
			}else {
				sql = basicSql +" where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result=-1; // 비밀번호 틀림
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public MemberDTO getSelect(String id) {
		MemberDTO dto = null;
		try {
			String sql = "select no, id, pw, name, gender, bornYear, regi_date, postcode, bAddr, sAddr, refAddr "
					+ "from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("pw"),
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("bornYear"), 
						rs.getTimestamp("regi_date"),
						rs.getString("postcode"),
						rs.getString("bAddr"),
						rs.getString("sAddr"),
						rs.getString("refAddr")
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return dto;
	}
	
	public MemberDTO getView(int no) {
		MemberDTO dto = null;
		try {
			String sql = "select no, id, pw, name, gender, bornYear, regi_date, postcode, bAddr, sAddr, refAddr "
					+ "from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("pw"),
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("bornYear"), 
						rs.getTimestamp("regi_date"),
						rs.getString("postcode"),
						rs.getString("bAddr"),
						rs.getString("sAddr"),
						rs.getString("refAddr")
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return dto;
	}
	
	public ArrayList<MemberDTO> getListAll(){
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			String sql = "select no, id, pw, name, gender, bornYear, regi_date from member order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(
						rs.getInt("no"),
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getInt("bornYear"),
						rs.getTimestamp("regi_date")
						);
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}
	public ArrayList<MemberDTO> getListAll2(int startRecord, int endRecord, String search_option, String search_data){
		ArrayList<MemberDTO> list = new ArrayList<>();
		String basicSql = "select no, id, pw, name, gender, bornYear, regi_date from member "
				+ "where no>0";
		String orderBy = " order by no desc";
		try {
			if(!(search_option.equals("")&&search_data.equals(""))){
				if(search_option.equals("id")||search_option.equals("name")||search_option.equals("gender")) 
					basicSql += " and "+search_option+" like ?";
				if(search_option.equals("id_name_gender")) basicSql += " and (id like ? or name like ? or gender like ?)";
			}
			basicSql += orderBy;
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?"; 
			pstmt = conn.prepareStatement(sql);
			int k = 0;
			if(!(search_option.equals("")&&search_data.equals(""))){
				if(search_option.equals("id_name_gender")) {
					pstmt.setString(++k, "%"+search_data+"%");
					pstmt.setString(++k, "%"+search_data+"%");
					pstmt.setString(++k, "%"+search_data+"%");
				}else {
					pstmt.setString(++k, "%"+search_data+"%");
				}
			}
			
			pstmt.setInt(++k, startRecord);
			pstmt.setInt(++k, endRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(
						rs.getInt("no"),
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getInt("bornYear"),
						rs.getTimestamp("regi_date")
						);
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}
	
	
	
	public int setUpdate(MemberDTO dto) {
		int result = 0; // 비밀번호 불일치
		try {
			String sql = "update member set gender=?, bornYear=?, postcode=?, bAddr=?, sAddr=?, refAddr=?"
					+ " where no=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender());
			pstmt.setInt(2, dto.getBornYear());
			pstmt.setString(3, dto.getPostcode());
			pstmt.setString(4, dto.getbAddr());
			pstmt.setString(5, dto.getsAddr());
			pstmt.setString(6, dto.getRefAddr());
			pstmt.setInt(7, dto.getNo());
			pstmt.setString(8, dto.getPw());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int setDelete(MemberDTO dto) {
		int result = 0; // 비밀번호 불일치
		try {
			String sql = "delete from member where no=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getPw());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int idCheck(String id) {
		int result = 0;
		try {
			String sql = "select id from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}

	public int getTotalCount(String search_option, String search_data) {
		int result = 0;
		try {
			String sql = "select count(*) from member where no>0";
			
			if(!(search_option.equals("")&&search_data.equals(""))){
				if(search_option.equals("id")||search_option.equals("name")||search_option.equals("gender")) 
					sql += " and "+search_option+" like ?";
				if(search_option.equals("id_name_gender")) sql += " and (id like ? or name like ? or gender like ?)";
			}
			
			pstmt = conn.prepareStatement(sql);
			if(!(search_option.equals("")&&search_data.equals(""))){
				if(search_option.equals("id_name_gender")) {
					pstmt.setString(1, "%"+search_data+"%");
					pstmt.setString(2, "%"+search_data+"%");
					pstmt.setString(3, "%"+search_data+"%");
				}else {
					pstmt.setString(1, "%"+search_data+"%");
				}
				
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
	
	
}
