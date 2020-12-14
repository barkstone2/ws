package exam04;

class Dog{
	String dogName;
	int dogAge;
	
	public Dog(String dogName, int dogAge) {
		this.dogName = dogName;
		this.dogAge = dogAge;
	}
	
	@Override
	public String toString() {
		return dogName+" "+dogAge;
	}
}



class Temp{
	String name;
	int age;
	Dog dog;
	
	
	public Temp(String name, int age, Dog dog) {
		this.name = name;
		this.age = age;
		this.dog = dog;
	}
	
	@Override
	public String toString() {
		return name+" "+age+" "+dog;
	}
	
}



public class ReferenceType {
	public static void main(String[] args) {
		//출력 : 이름, 나이, 애완견이름, 애완견나이
		
		
		
		Temp tp = new Temp("홍길동", 20, new Dog("멍멍이",3));
		System.out.println(tp);
		
		tp = new Temp("홍길순", 23, new Dog("댕댕이",1));
		System.out.println(tp);
		
		
	}
}
