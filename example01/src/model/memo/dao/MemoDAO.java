package model.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import model.memo.dto.MemoDTO;

public class MemoDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemoDAO() {
		conn = db.getConn();
	}
	
	public int setInsert(MemoDTO dto) {
		int result=0;
		try {
			String sql = "insert into memo "
					+ "(no, id, content, regi_date) "
					+ "values(seq_memo.nextval,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getContent());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<MemoDTO> getListAll(int startRecord, int endRecord){
		ArrayList<MemoDTO> list = new ArrayList<>();
		try {
			String basicSql = "select no, id, content, regi_date from memo order by no desc";
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRecord);
			pstmt.setInt(2, endRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemoDTO dto = new MemoDTO(
						rs.getInt("no"), 
						rs.getString("id"), 
						rs.getString("content"),
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
	
	public int getTotalCount() {
		int result = 0;
		try {
			String sql = "select count(*) from memo";
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
