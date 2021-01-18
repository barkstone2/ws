package member.model;

public class Test {
	public static void main(String[] args) {
		int a[] = new int[1000000000];
		int sw = 1;
		
		long startTime = System.currentTimeMillis();
		
		int value = 300;
		if(sw==1)
			value = 100;
		else if(sw==2)
			value = 200;
		
//		a = getValue(a, sw);
//		for(int i=0; i<a.length; i++) 
//			if(sw==1)
//				a[i] = getValue(sw);
//			else if(sw==2)
//				a[i] = getValue(sw);
//			else 
//				a[i] = getValue(sw);
		
		for(int i=0; i<a.length; i++)
			a[i] = value;
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	
	}
	
	public static int[] getValue(int[] a, int sw){
		int value = 300;
		if(sw==1)
			value = 100;
		else if(sw==2)
			value = 200;
		for(int i=0; i<a.length; i++) 
		if(sw==1)
			a[i] = value;
		else if(sw==2)
			a[i] = value;
		else 
			a[i] = value;
		return a;
	}
	
}
