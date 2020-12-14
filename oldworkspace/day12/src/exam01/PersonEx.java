package exam01;

public class PersonEx {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("홍길동");
		p1.setHeight(190);
		p1.setWeight(100);
		
		Person p2 = new Person("이성순", 170, 70);
		Person p3 = new Person("장천용");
		Person p4 = new Person(180,80);
		
		p3.setHeight(160);
		p3.setWeight(50);
		p4.setName("홍길순");
		
		
		System.out.println(p1.getName()+"/"+p1.getHeight()+"/"+p1.getWeight());
		System.out.println(p2.getName()+"/"+p2.getHeight()+"/"+p2.getWeight());
		System.out.println(p3.getName()+"/"+p3.getHeight()+"/"+p3.getWeight());
		System.out.println(p4.getName()+"/"+p4.getHeight()+"/"+p4.getWeight());
		
		
	}
	
	
}
