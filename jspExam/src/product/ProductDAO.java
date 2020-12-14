package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Db;

public class ProductDAO {
	private Connection conn = Db.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ProductDAO() {
	}
	
	public void quitConn() {
		try {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setInsert(ProductDTO dto) {
		int result = 0;
		try {
			String sql = "insert into product values(seq_product.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getpName());
			pstmt.setInt(2, dto.getpPrice());
			pstmt.setInt(3, dto.getSalePrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<ProductDTO> getListAll(){
		ArrayList<ProductDTO> list = new ArrayList<>();
		try {
			String sql = "";
			sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setpName(rs.getString("pName"));
				dto.setpPrice(rs.getInt("pPrice"));
				dto.setSalePrice(rs.getInt("salePrice"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return list;
	}
	
	
}
