package exam01;

public class Person {
	//Member Field
	private String name;
	private int height;
	private int weight;
	
	
	
	//Constructor
	public Person() {
	}
	
	public Person(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public Person(String name) {
		this.name = name;
	}
	
	public Person(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}




	//Member Method
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
