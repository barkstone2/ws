package com.study.self;

public class MethodClass {

	public MethodClass() {
		// TODO Auto-generated constructor stub
	}
	
//	public static boolean isNumber(String str) {
//		if (str==null || str.equals("")) {
//			
//			return false;
//		}
//		for(int i=0; i<str.length(); i++) {
//			char ch = str.charAt(i);
//			if(ch < '0' || ch > '9') {
//				return false;
//			}
//		}
//		
//		return true;
//	}
//	
//	public int max(int[] arr) {
//		if(arr == null || arr.length == 0) {
//			return -999999;
//		}
//		for(int i=0; i<arr.length-1; i++) {
//			//arr[i]와 arr[i+1]을 비교해서 큰 값을 뒤로 보냄.
//			//반복문을 통해 배열의 끝까지 진행.
//			//배열의 마지막 값을 반환
//			//0 1 2 3 4
//			if(arr[i] > arr[i+1]) {
//				int tmp = arr[i+1];
//				arr[i+1] = arr[i];
//				arr[i] = tmp;
// 			}
//		} // for end
//		return arr[arr.length-1];
//	} // max method end
	
//	public int abs(int value) {
//		if(value<0) {
//			value = -value;
//		}
//		
//		return value;
//	}
	
	
	public void action(Robot r) {
		if(r instanceof DanceRobot) {
			((DanceRobot) r).dance();
		}else if(r instanceof SingRobot) {
			((SingRobot) r).sing();
		}else if(r instanceof DrawRobot) {
			((DrawRobot) r).draw();
		}
	}
	
	
	
	
	
	
	
	
}
