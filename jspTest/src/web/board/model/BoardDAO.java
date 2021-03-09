package web.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BoardDAO() {
	}
	
	public void getConn() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "jspTest";
			String dbPw = "1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("오라클 접속 성공");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
	}
	
	public void quitConn() {
		try {
			if(conn!=null)conn.close();
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insert(BoardDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into board (no, name, title, content, pwd, regDate) "
					+ "values(seq_board.nextval, ?, ?, ?, ?, default)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getPwd());
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		
		return result;
	}
	
	public int update(BoardDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update board set name=?, title=?, content=?, pwd=? where no=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getPwd());
			ps.setInt(5, dto.getNo());
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		
		return result;
	}
	
	public int delete(int no) {
		int result = 0;
		getConn();
		try {
			String sql = "delete from board where no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		
		return result;
	}
	
	public BoardDTO getView(int no) {
		BoardDTO dto = null;
		getConn();
		try {
			String sql = "select no, name, title, content, pwd, regDate from board where no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO(
						rs.getInt("no"), 
						rs.getString("name"), 
						rs.getString("title"), 
						rs.getString("content"), 
						rs.getString("pwd"), 
						rs.getDate("regDate")
					);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		
		return dto;
	}
	
	public List<BoardDTO> getList(int startRecord, int endRecord) {
		List<BoardDTO> list = new ArrayList<>();
		getConn();
		try {
			String basicSql = "select a.no, a.title, a.name, a.content, a.regDate, a.pwd "
					+ "from board a where no>0";
			String orderBy = " order by regDate desc";
			basicSql += orderBy;
			String sql = "select * from (select rownum rn, a.* from ("+basicSql+") a) where rn between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRecord);
			ps.setInt(2, endRecord);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt("no"), 
						rs.getString("name"), 
						rs.getString("title"), 
						rs.getString("content"), 
						rs.getString("pwd"), 
						rs.getDate("regDate")
					);
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		
		return list;
	}
	
	public int pwdChk(int no, String pwd) {
		getConn();
		int result = 0;
		try {
			String sql = "select pwd from board where no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				String temp = rs.getString("pwd");
				if(temp.equals(pwd)) {
					result = 1;
				}else {
					result = -1;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		
		return result;
	}

	public int getTotalCount() {
		int result = 0;
		getConn();
		try {
			String sql = "select count(*) from board where no>0";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			quitConn();
		}
		
		return result;
	}
	
	
	
	
}
