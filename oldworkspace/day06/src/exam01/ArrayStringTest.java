package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayStringTest {

	public static void main(String[] args) {
		//문자열배열
		
		//입력 : 이름, 출생년도 <5명
		//출력 : 이름: ㅇㅇ, 출생년도 : ㅇㅇㅇㅇ, 나이: ㅇㅇ
		
//		Scanner sc = new Scanner(System.in);
//		
//		String[] name = new String[5];
//		int[] birthYear = new int[5];
//		int nowYear = Calendar.getInstance().get(Calendar.YEAR);
//		int[] age = new int[5];
//		int i =0;
//		
//		while(i<name.length) {
//			System.out.print("이름,출생년도 입력>>");
//			String input = sc.nextLine();
//			
//			Scanner sc2 = new Scanner(input).useDelimiter(",");
//			
//			try {
//				if(input.equalsIgnoreCase("Q")) {
//					break;
//				}
//			}catch(Exception e) {
//				continue;
//			}
//			
//			if(sc2.hasNext()) {
//				name[i] = sc2.next();
//				birthYear[i] = sc2.nextInt();
//				age[i] = nowYear - birthYear[i] + 1;
//			}else {
//				continue;
//			}//if end
//			i++;
//		}//while end
//		
//		for(int j=0; j<name.length; j++) {
//			if(name[j] == null) {
//				break;
//			}
//			System.out.println("이름: " + name[j]+ ", 출생년도: " + birthYear[j]+", 나이: "+age[j]);
//		}
		
		
		//입력: 이름, 국어, 영어, 수학 < 5명
		//출력 : 
		
		//----------------------------
		//이름 국어 영어 수학 총점 평균 등급
		//----------------------------
		//
		//----------------------------
		
//		File fi = new File("student.txt");
//		String[] name = new String[5];
//		int[] kor = new int[5];
//		int[] eng = new int[5];
//		int[] math = new int[5];
//		int[] total = new int[5];
//		int[] avg = new int[5];
//		String[] grade = new String[5];
//			
//		
//		try {
//			Scanner sc = new Scanner(fi);
//			int i=0;
//			
//			while(sc.hasNextLine()) {
//					Scanner sc2 = new Scanner(sc.nextLine()).useDelimiter(",");
//					name[i] = sc2.next();
//					kor[i] = sc2.nextInt();
//					eng[i] = sc2.nextInt();
//					math[i] = sc2.nextInt();
//					total[i] = kor[i] + eng[i] +math[i];
//					avg[i] = total[i] / 3;
//					
//					if(avg[i]>=90) {
//						grade[i] = "수";
//					}else if(avg[i]>=80) {
//						grade[i] = "우";
//					}else if(avg[i]>=70) {
//						grade[i] = "미";
//					}else if(avg[i]>=60) {
//						grade[i] = "양";
//					}else {
//						grade[i] = "가";
//					}
//					
//				i++;
//			}//while end
//		} catch (FileNotFoundException e) {
//			}
//		
//		System.out.println("-------------------------------------------------");
//		System.out.println("이름	국어	영어	수학	총점	평균	등급");
//		System.out.println("-------------------------------------------------");
//		
//		for(int j=0; j<name.length; j++) {
//			System.out.println(name[j]+"\t"
//								+kor[j]+"\t"
//								+eng[j]+"\t"
//								+math[j]+"\t"
//								+total[j]+"\t"
//								+avg[j]+"\t"
//								+grade[j]);
//		}
//		
//		System.out.println("-------------------------------------------------");
		
		
		
//		String temp = "010-1111-2222";
//		String[] temps = temp.split("-");
//		System.out.print(temp+temps);
//		System.out.println(Arrays.toString(temps));
		
		
		String test = "가,나,다,라,마,바,사,아,자,차";
		String[] testArr = test.split(",");
		
		System.out.println(Arrays.toString(testArr));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int[] 변수이름 = {값1, 값2, 값3};
//		int[] 변수이름 = enw int[] {값1, 값2, 값3};
//		
//		int[] 변수이름 = new int[10];
//		변수이름[0] = 값1;
//		변수이름[1] = 값2;
//		변수이름[2] = 값3;
		
		
	}
	
	
}
