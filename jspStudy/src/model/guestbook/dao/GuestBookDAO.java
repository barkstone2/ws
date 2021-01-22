package model.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import model.guestbook.dto.GuestBookDTO;
import model.member.dto.MemberDTO;

public class GuestBookDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public GuestBookDAO() {
		conn = db.getConn();
	}
	
	public int setInsert(GuestBookDTO dto) {
		int result=0;
		try {
			String sql = "insert into guestbook "
					+ "(no, name, email, passwd, content, regi_date) "
					+ "values(seq_guestbook.nextval, ?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getContent());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<GuestBookDTO> getListAll(int startRecord, int endRecord){
		ArrayList<GuestBookDTO> list = new ArrayList<>();
		String basicSql = "select no, name, email, passwd, content, regi_date from guestbook order by no desc";
		try {
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRecord);
			pstmt.setInt(2, endRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestBookDTO dto = new GuestBookDTO(
						rs.getInt("no"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("passwd"),
						rs.getString("content"),
						rs.getDate("regi_date")
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
	
	
	
	public int getTotalCount() {
		int result = 0;
		try {
			String sql = "select count(*) from guestbook";
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
