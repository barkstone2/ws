package shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;
import db.DbImplOracle;
import shop.model.dto.ProductDTO;

public class ProductDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String tableName1 = "product";
	private String tableName2 = "";
	private String tableName3 = "";
	
	public ProductDAO() {
		conn = db.getConn();		
	}
	
	public int setInsert(ProductDTO dto) {
		int result=0;
		try {
			String sql = "insert into "+ tableName1
					+ " (no, name, price, description, product_img, regiDate) "
					+ "values(seq_product.nextval,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getDescription());
			pstmt.setString(4, dto.getProduct_img());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<ProductDTO> getListAll(int startRecord, int endRecord, String search_option, String search_data){
		ArrayList<ProductDTO> list = new ArrayList<>();
		String basicSql = "select a.no, a.name, a.price, a.description, a.product_img, a.regiDate "
				+ "from "+tableName1+" a where no>0";
		String orderBy = " order by no desc";
		try {
			boolean[] sqlCheck = new boolean[3];
			if(search_option.length()>0&&search_data.length()>0) {
				if(search_option.equals("nameDis")) {
					basicSql+= " and (name like ? or description like ?)";
					sqlCheck[0] = true;
				}else if(search_option.equals("all")) {
					basicSql+= " and (bSubject like ? or bContent like ? or bWriter like ?)";
					sqlCheck[1] = true;
				}else {
					basicSql+= " and "+search_option+" like ?";
					sqlCheck[2] = true;
				}
			}
			basicSql += orderBy;
			int k = 0;  //++k
			String sql = "select c.* "
					+ "from (select rownum rn, b.* from ("+basicSql+") b) c where rn between ? and ?";
			pstmt = conn.prepareStatement(sql);
			if(sqlCheck[0]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[1]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[2]){
				pstmt.setString(++k, "%"+search_data+"%");
			}
			pstmt.setInt(++k, startRecord);
			pstmt.setInt(++k, endRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setDescription(rs.getString("description"));
				dto.setProduct_img(rs.getString("product_img"));
				dto.setRegiDate(rs.getTimestamp("regiDate"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}
	
	
	public ProductDTO getView(int no) {
		ProductDTO dto = null;
		try {
			String sql = "select a.no, a.name, a.price, a.description, a.product_img, a.regiDate "
					+ "from "+tableName1+" a where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setDescription(rs.getString("description"));
				dto.setProduct_img(rs.getString("product_img"));
				dto.setRegiDate(rs.getTimestamp("regiDate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return dto;
	}
	
	
	public int getTotalCount(String search_option, String search_data) {
		int result = 0;
		try {
			String sql = "select count(*) from "+tableName1+" where no>0";
			boolean[] sqlCheck = new boolean[3];
			if(search_option.length()>0&&search_data.length()>0) {
				if(search_option.equals("subcon")) {
					sql+= " and (bSubject like ? or bContent like ?)";
					sqlCheck[0] = true;
				}else if(search_option.equals("all")) {
					sql+= " and (bSubject like ? or bContent like ? or bWriter like ?)";
					sqlCheck[1] = true;
				}else {
					sql+= " and "+search_option+" like ?";
					sqlCheck[2] = true;
				}
			}
			pstmt = conn.prepareStatement(sql);
			int k = 0;
			if(sqlCheck[0]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[1]) {
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
				pstmt.setString(++k, "%"+search_data+"%");
			}else if(sqlCheck[2]){
				pstmt.setString(++k, "%"+search_data+"%");
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
//	
//	public void setHit(int bNo) {
//		try {
//			String sql = "update "+tableName1+" set bHit=(bHit+1) where bNo=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bNo);
//			pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public int setAnswer(BoardDTO2 dto) {
//		int result=0;
//		int maxNoticeNum = 0;
//		if(dto.getbNoticeNum()>0) {
//			maxNoticeNum = getMaxNo("bNoticeNum", tableName1);
//		}
//		setLevelNo(dto.getbGroupNo(), dto.getbLevelNo());
//		try {
//			String sql = "insert into "+ tableName1
//					+ " (bNo, bNum, boardType, bSubject, bWriter, bContent, bPasswd, bEmail, "
//					+ "bSecretChk, bNoticeNum, bIp, bMemberNo, bHit, bRegiDate, bGroupNo, bStepNo, bLevelNo, bParentNo) "
//					+ "values(seq_board2.nextval,0,?,?,?,?,?,?,?,?,?,?,default,default,?,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dto.getBoardType());
//			pstmt.setString(2, dto.getbSubject());
//			pstmt.setString(3, dto.getbWriter());
//			pstmt.setString(4, dto.getbContent());
//			pstmt.setString(5, dto.getbPasswd());
//			pstmt.setString(6, dto.getbEmail());
//			pstmt.setInt(7, dto.getbSecretChk());
//			pstmt.setInt(8, maxNoticeNum);
//			pstmt.setString(9, dto.getbIp());
//			pstmt.setInt(10, dto.getbMemberNo());
//			pstmt.setInt(11, dto.getbGroupNo());
//			pstmt.setInt(12, dto.getbStepNo()+1);
//			pstmt.setInt(13, dto.getbLevelNo()+1);
//			pstmt.setInt(14, dto.getbNo());
//			result = pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			db.quitConn(rs, pstmt, conn);
//		}
//		return result;
//	}
//	
//	public void setLevelNo(int bGroupNo, int bLevelNo) {
//		try {
//			String sql = "update "+tableName1+" set bLevelNo=bLevelNo+1 where bGroupNo=? and bLevelNo>?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bGroupNo);
//			pstmt.setInt(2, bLevelNo);
//			pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public int setUpdate(BoardDTO2 dto) {
//		int result = 0;
//		int maxNoticeNum = 0;
//		if(dto.getbNoticeNum()>0) {
//			maxNoticeNum = getMaxNo("bNoticeNum", tableName1);
//		}
//		try {
//			String sql = "update "+tableName1+" set BoardType=?, bSubject=?, bWriter=?, "
//					+ "bContent=?, bPasswd=?, bEmail=?, bSecretChk=?, bNoticeNum=?, "
//					+ "bIp=?, bMemberNo=? where bNo=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dto.getBoardType());
//			pstmt.setString(2, dto.getbSubject());
//			pstmt.setString(3, dto.getbWriter());
//			pstmt.setString(4, dto.getbContent());
//			pstmt.setString(5, dto.getbPasswd());
//			pstmt.setString(6, dto.getbEmail());
//			pstmt.setInt(7, dto.getbSecretChk());
//			pstmt.setInt(8, maxNoticeNum);
//			pstmt.setString(9, dto.getbIp());
//			pstmt.setInt(10, dto.getbMemberNo());
//			pstmt.setInt(11, dto.getbNo());
//			result = pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			db.quitConn(rs, pstmt, conn);
//		}
//		return result;
//	}
//	
//	public int setDelete(int bNo) {
//		int result = 0;
//		try {
//			String sql = "delete from "+tableName1+" where bNo=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bNo);
//			result = pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			db.quitConn(rs, pstmt, conn);
//		}
//		return result;
//	}
//	
//	public String checkBoardType(String boardType) {
//		String boardName = "";
//		try {
//			String sql = "select boardName from "+tableName3+" where boardType=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, boardType);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				boardName = rs.getString("boardName");
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return boardName;
//	}
//	
//}

}
