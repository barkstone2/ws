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
		
		return result+1;
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
	
	public int[] delete(String[] productNoArr) {
		int[] resultArr = {};
		try {
			String sql = "delete from "+tableName1
					+" where productNo = ?";
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<productNoArr.length; i++) {
				pstmt.setString(1, productNoArr[i]);
				pstmt.addBatch();
			}
			resultArr = pstmt.executeBatch();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.quitConn(rs, pstmt, conn);
		}
		return resultArr;
	}
	
	
}
