package exam01;

public class Test02 {
	
	String str;
	int num;
	
	public Test02() {
	}
	
	//Method
	//재사용 가능성이 있는 것을 미리 등록해놓고, 필요할 때마다 호출
	void method1() {
		System.out.println("--method1--");
	}

	void method2(String name){
		System.out.println(name + "님 안녕하세요?");
	}
	
	void method3(String name, int age) {
		System.out.println("이름 : "+name+", 나이 : "+age);
	}
	
	
	
	
	public static void main(String[] args) {
		Test02 t1 = new Test02();
		t1.method1();
		t1.method1();
		t1.method1();
		t1.method2("홍길동");
		t1.method3("홍길동", 30);
		
	}
}
