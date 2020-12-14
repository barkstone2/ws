package exam02;

public class Example {
	public static void main(String[] args) {
		
		ImplClass i = new ImplClass();
		
		FaceA fa = i;
		FaceB fb = i;
		FaceC fc = i;
		
		fa.methodA();
		fb.methodB();
		
		fc.methodA();
		fc.methodB();
		fc.methodC();
		
		
		
		
		
		
	}
}
