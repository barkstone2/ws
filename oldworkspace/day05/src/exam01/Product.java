package exam01;

public class Product {
	
	String name;
	int price;
	int count;
	int totalP;
	int point;
	int pointTotal;
	
	public Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.totalP = price*count;
		if(this.totalP>=5000) {
			this.point = totalP / 10 ;
		}
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"\t"+count+"\t"+totalP+"원("+price+"원)\t"+point+"P";
	}
	
}
