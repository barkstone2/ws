package common;


public class Test {
	public static void main(String[] args) {
		Util util = new Util();
		
		String uuid = util.create_uuid();
		
		
		String aaa = "aaa";
		
		System.out.println(aaa.length());
		System.out.println(aaa.substring(0,aaa.length()));
		System.out.println(uuid);
	
		String test = "1,2,3,4,5";
		
		String[] aa = test.split(",");
		
		for(String a: aa)
			System.out.println(a);
		
		
		
	}
}
