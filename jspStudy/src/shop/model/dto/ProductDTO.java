package shop.model.dto;

import java.sql.Timestamp;

public class ProductDTO {
	private int no;
	private String name;
	private int price;
	private String description;
	private String product_img;
	private Timestamp regiDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public Timestamp getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Timestamp regiDate) {
		this.regiDate = regiDate;
	}
	
	
	
	
}
