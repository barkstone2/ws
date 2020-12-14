package exam01;

public class PersonDTO {
	//이름, 나이, 키, 몸무게
	String name;
	int age;
	double height;
	double weight;
	
	public PersonDTO(String name, int age, double height, double weight) {
		//super(); - 부모 클래스의 생성자를 호출
		//this(); - 자기 자신의 생성자를 호출
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
	
	
	@Override
	public String toString() {
		return name+"\t"+age+"\t"+height+"\t"+weight;
	}

	
	
	
	
	
	
}
