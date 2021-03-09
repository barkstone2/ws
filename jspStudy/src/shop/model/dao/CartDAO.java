package shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.Db;
import db.DbImplOracle;
import shop.model.dto.CartDTO;

public class CartDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String tableName1 = "cart";
	private String tableName2 = "product";
	private String tableName3 = "";
	
	public CartDAO() {
		conn = db.getConn();
	}
	
	public int updateAmount(CartDTO dto) {
		int result=0;
		try {
			String sql = "update "+ tableName1
					+ " set amount=? "
					+ "where memberNo=? and productNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getAmount());
			pstmt.setInt(2, dto.getMemberNo());
			pstmt.setInt(3, dto.getProductNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	
	public int add(CartDTO dto) {
		int result=0;
		try {
			String sql = "insert into "+ tableName1
					+ " (no, memberNo, productNo, amount, regiDate) "
					+ "values(seq_cart.nextval,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMemberNo());
			pstmt.setInt(2, dto.getProductNo());
			pstmt.setInt(3, dto.getAmount());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int checkCart(int memberNo, int productNo) {
		int result = 0;
		try {
			String sql = "select amount from "+ tableName1
					+ " where memberNo=? and productNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, productNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("amount");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<CartDTO> getList(int memberNo){
		List<CartDTO> list = new ArrayList<>();
		try {
			String sql = "select a.no, a.memberNo, a.productNo, a.amount, a.regiDate, "
					+ "b.name productName, b.description, b.product_img, b.price "
					+ "from "+ tableName1 +" a, "+tableName2+" b "
					+ "where a.memberNo=? and a.productNo=b.no "
					+ "order by regidate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setProductNo(rs.getInt("productNo"));
				dto.setAmount(rs.getInt("amount"));
				
				dto.setProduct_name(rs.getString("productName"));
				dto.setProduct_description(rs.getString("description"));
				dto.setProduct_img(rs.getString("product_img"));
				dto.setProduct_price(rs.getInt("price"));
				
				dto.setBuy_money();
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return list;
	}

	public int deleteAll(int cookNo) {
		int result = 0;
		try {
			String sql = "delete from "+tableName1
					+" where memberNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cookNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return result;
	}
	
	public int[] delete(String[] productNoArr, int cookNo) {
		int[] resultArr = {};
		try {
			conn.setAutoCommit(false);
			String sql = "delete from "+tableName1
					+" where productNo = ? and memberNo=?";
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<productNoArr.length; i++) {
				pstmt.setString(1, productNoArr[i]);
				pstmt.setInt(2, cookNo);
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			resultArr = pstmt.executeBatch();
			conn.commit();
		}catch (Exception e) {
			try {
				conn.rollback();
			}catch (Exception ee) {
				ee.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return resultArr;
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

	public List<CartDTO> getListCartProductGroup() {
		List<CartDTO> list = new ArrayList<>();
		try {
			String sql = "select p.name product_name, sum(c.amount * p.price) buy_money "
					+ "from cart c inner join product p on c.productNo = p.no "
					+ "group by p.name "
					+ "order by product_name asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setProduct_name(rs.getString("product_name"));
				dto.setBuy_money(rs.getInt("buy_money"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		
		
		return list;
	}
}
