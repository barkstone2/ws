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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setInsert(ProductDTO dto) {
		int result = 0;
		try {
			String sql = "insert into product values(seq_product.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCate());
			pstmt.setString(2, dto.getPname());
			pstmt.setInt(3, dto.getPrice());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		quitConn();
		return result;
	}
	
	public ArrayList<ProductDTO> getListAll(){
		ArrayList<ProductDTO> list = new ArrayList<>();
		try {
			String sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setNo(rs.getInt("no"));
				dto.setCate(rs.getString("cate"));
				dto.setPname(rs.getString("pname"));
				dto.setPrice(rs.getInt("price"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
