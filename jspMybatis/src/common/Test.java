package common;


public class Test {
	public static void main(String[] args) {
		Util util = new Util();
		
		String uuid = util.create_uuid();
		
		
		
		int[] A = {1,2,3,4};
		
		
		
		
		String aaa = "aaa";
		
		System.out.println(aaa.length());
		System.out.println(aaa.substring(0,aaa.length()));
		System.out.println(uuid);
	}
	
	public int solution(int []A, int []B)
    {
        int answer = 0;
        int minNum = 0;
        int maxNum = 0;
        
        minNum = minNum(A);
        A = arrRefresh(A, minNum);
        maxNum = maxNum(B);
        B = arrRefresh(B, maxNum);
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
    
        
        
        return answer;
    }
	
	public int minNum(int[] A) {
		int minNum = 0;
        
        for(int i=0; i<A.length; i++){
            if(A[i] == 0) continue;
            
            if(i==0) minNum = A[i]; 
            if(i != 0){
                if(A[i] < minNum){
                    minNum = A[i];
                }
            }
        }
        return minNum;
	}
	
	public int maxNum(int[] B) {
		int maxNum = 0;
		
		for(int i=0; i<B.length; i++) {
			
		}
	}
	
	public int[] arrRefresh(int[] A, int num) {
		 for(int i=0; i<A.length; i++) {
        	if(A[i] == num) {
        		A[i] = 0;
        		break;
        	}
        }
		 return A;
	}
	
	
	
}
