package com.study.self;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.Box.Filler;

public class MainClass {

	public static void main(String[] args) {
		MethodClass mc = new MethodClass();
		//두 개의 주사위, 눈의 합 6, 모든 경우의 수 출력 프로그램
		//주사위 두개 - 변수 두개, if를 통해 눈의 합 6인 경우의 수 선별, 출력.
		//합을 판별하는 변수 생성.
		//이중 반복문을 통해 주사위 두개의 합 구하기
		
		
//		int dice1;
//		int dice2;
//		int tmpSum;
//		
//		for(int i=1; i<7; i++) {
//			tmpSum = 0;
//			for(int j=1; j<7; j++) {
//				tmpSum = i+j;
//				if(tmpSum==6) {
//					System.out.println(i + " + " + j);
//					
//				}
//			}
//			
//		}
		
		
//		int value = (int)(Math.random()*6) + 1;
//		System.out.println("value = " + value);
		
		
		//x+2y = 5의 해 구하기.
		//x,y의 범위는 0~10
		//
		
//		int tmpSum = 0;
//		
//		for(int i=0; i<11; i+=2) {
//			for(int j=0; j<11; j+=4) {
//				tmpSum = i + j;
//				if(tmpSum == 10) {
//					System.out.print("x의 값 : " + i/2 + ", ");
//					System.out.println("y의 값 : " + j/4);
//				}
//			}
//		}
		
		//숫자로 이루어진 문자열 str
		//각 자리의 합을 구하라
		
//		String str = "12345";
//		int sum = 0;
//		
//		for(int i=0; i<str.length(); i++) {
//			sum += (str.charAt(i)-'0');//char에서 '0'을 빼면 int변환
//		}
//		System.out.println("sum = " + sum);
		
		
		
		//int 각 자리의 합.
		//몫과 나머지.
		//10000으로 나눈 몫을 1으로 나누기 = 1자리., 1000으로 나눈 몫을 10으로 나눈 나머지 2, 100으로 나눈 몫을 10으로 나눈 나머지 3
		//1의 자리-> 10으로 나눈 나머지.
		//10의 자리 -> 
//		int num = 12345;
//		int sum = 0;
//		
//		
//		for(int i=1; i<6; i++) {
//			sum += num%10;
//			num /= 10;
//		}
//		
//		System.out.println("sum = " + sum);
		
		//피보나치 수열
//		int num1 = 1;
//		int num2 = 1;
//		int num3 = 0;
//		System.out.print(num1 + ", " + num2);
//		
//		for(int i=0; i<8; i++) {
//			num3 = num1 + num2;
//			num1 = num2;
//			num2 = num3;
//			System.out.print(", " + num3);
//			
//		}
		
		
		//구구단 출력
		
//		for(int i=1; i<4; i++) {
//			for(int j=2; j<5; j++) {
//					System.out.print(j + "*" + i + "=" + j*i + "\t");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
//		
//		for(int i=1; i<4; i++) {
//			for(int j=5; j<8; j++) {
//					System.out.print(j + "*" + i + "=" + j*i + "\t");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
//		
//		for(int i=1; i<4; i++) {
//			for(int j=8; j<10; j++) {
//					System.out.print(j + "*" + i + "=" + j*i + "\t");
//			}
//			System.out.println();
//		}
		
		
//		String value = "12o34";
//		char ch = ' ';
//		boolean isNumber = true;
//		
//		for(int i=0; i<value.length(); i++) {
//			ch = value.charAt(i);
//			
//			if(!('0'<= ch && ch <='9')) {
//				isNumber = false;
//				break;
//			}
//		}
//		
//		
//		if(isNumber) {
//			System.out.println(value + "는 숫자입니다.");
//		} else {
//			System.out.println(value + "는 숫자가 아닙니다.");
//		}
//				
		
		//랜덤 숫자 맞추기 게임
//		int answer = (int)(Math.random()*100+1);
//		int input = 0;
//		int count = 0;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println(answer);
//		
//		do {
//			count++;
//			System.out.print("1과 100사이의 값을 입력하세요 :");
//			input = sc.nextInt();
//			
//			if(answer==input) {
//				System.out.print("정답! " + count + "번 만에 맞춤");
//				break;
//			}
//		} while(true); 

		
		//회문수(거꾸로 해도 똑같은 수) 구하기
//		int num = 12321;
//		int tmp = num;
//		int result = 0;
//		
//		while(tmp != 0) {
//			result = result*10 + tmp%10;
//			tmp /= 10;
//		}
//		System.out.println(result);
//		
//		if(num == result) {
//			System.out.println(num + "는 회문수입니다.");
//		} else {
//			System.out.println(num + "는 회문수가 아닙니다.");
//		}
		
		
//		int[] arr = {10,20,30,40,50};
//		int sum = 0;
//		
//		for(int i=0; i<arr.length; i++) {
//			sum += arr[i];
//		}
//		
//		System.out.println(sum);
		
		
		
		
		//총합에 사용될 개체의 개수를 구하는 방법...
		//arr[0]~arr[3]의 길이
		//변수를 안 만들고 하는 방법.
		//2차원 배열의 길이가 고정이라는 가정으로 문제풀이 돼 있음.
		
		//배열 값의 합, 평균 구하기
		
		
//		int[][] arr = {
//				{ 5,  5,  5,  5,  5},
//				{10, 10, 10, 10, 10},
//				{20, 20, 20, 20, 20},
//				{30, 30, 30, 30, 30}
//		};
//		
//		int total = 0;
//		float avg = 0;
//		
//		
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				total += arr[i][j];
//			}
//		}
//		
//		avg = (float)total / (arr.length * arr[0].length);
//		
//		System.out.println(total);
//		System.out.println(avg);
		
		
		//배열의 값 랜덤배치 후 다른 배열로 복사
		
//		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//		int[] ball3 = new int[3];
		
		//ballArr의 값의 위치를 랜덤하게 변경한 뒤 ballArr의 0~2번 인덱스의 값을 ball3에 넣음.
		
//		for(int i=0; i<ballArr.length; i++) {
//			int j = (int)(Math.random()*ballArr.length);
//			int tmp;
//			tmp = ballArr[i];
//			ballArr[i] = ballArr[j];
//			ballArr[j] = tmp;
//		}
//		ball3 = Arrays.copyOfRange(ballArr, 0, 3);
//		
//		
//		for(int i=0; i<ball3.length; i++) {
////			ball3[i] = ballArr[i];
//			System.out.println(ball3[i]);
//		}
		
		
		//거스름돈 큰 순으로 거슬러 주기
		
//		int[] coinUnit = {500, 100, 50, 10};
//		
//		int money = 2680;
//		System.out.println("money = " + money);
//		
//		for(int i=0; i<coinUnit.length; i++) {
//			
//			System.out.println(coinUnit[i]+"원 : " + money/coinUnit[i] );
//			money = money%coinUnit[i];
//		}
		
		
		
		//커맨드 라인 입력 받아 거스름돈 주기
		
//		if(args.length != 1) {
//			System.out.println("USAGE: java Exercise5_7 3120");
//			System.exit(0);
//		}
//		
//		int money = Integer.parseInt(args[0]);
//		System.out.println("money = " + money);
//		
//		int[] coinUnit = {500, 100, 50, 10};
//		int[] coin = {5, 5, 5, 5};
//		
//		for(int i=0; i<coinUnit.length; i++) {
//			int coinNum = 0;
//			coinNum = money / coinUnit[i];
//			if(coinNum <=5) {
//				money = money - coinUnit[i]*coinNum; 
//				coin[i] -= coinNum;
//			} else {
//				coinNum = coin[i];
//				money = money - coinUnit[i]*coinNum;
//				coin[i] -= coinNum;
//			}
//			System.out.println(coinUnit[i]+"원: " + coinNum);
//			
//		}
//		
//		if(money > 0) {
//			System.out.println("거스름 돈이 부족합니다.");
//			System.exit(0);
//		}
//		
//		System.out.println("=남은 동전의 개수=");
//		
//		for(int i=0; i<coin.length; i++) {
//			System.out.println(coinUnit[i] + "원 : " + coin[i]);
//		}
		
		
		
		//배열 값의 숫자를 세서 숫자만큼 *출력
//		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
//		int[] counter = new int[4];
//		
//		
//		for(int i=0; i<answer.length; i++) {
//			counter[answer[i]-1]++;
//		}
//		
//		
//		for(int i=0; i<counter.length; i++) {
//			System.out.print(counter[i]);
//			for(int j=0; j<counter[i]; j++) {
//				System.out.print('*');
//				
//			}
//			System.out.println();
//		}

		
		
//		SutdaCard card1 = new SutdaCard(3, false);
//		SutdaCard card2 = new SutdaCard();
//		
//		System.out.println(card1.info());
//		System.out.println(card2.info());
		
		
		
//		Student s = new Student();
//		s.name = "홍길동";
//		s.ban = 1;
//		s.no = 1;
//		s.kor = 100;
//		s.eng = 60;
//		s.math = 76;
//		
//		
//		System.out.println("이름: " + s.name);
//		System.out.println("총점: " + s.getTotal());
//		System.out.println("평균: " + s.getAverage());
		
		
		
//		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
//		System.out.println(s.info());
		
		
		
//		MyTv t = new MyTv();
//		
//		t.channel = 100;
//		t.volume = 0;
//		System.out.println("CH: "+t.channel+", VOL: "+t.volume);
//		
//		t.channelDown();
//		t.volumeDown();
//		System.out.println("CH: "+t.channel+", VOL: "+t.volume);
//		
//		t.volume = 100;
//		t.channelUp();
//		t.volumeUp();
//		System.out.println("CH: "+t.channel+", VOL: "+t.volume);
		
		
		
//		String str = "123";
//		String str2 = "123o";
//		String str3 = "123 456";
//		
//		System.out.println(isNumber(str));
//		System.out.println(isNumber(str2));
//		System.out.println(isNumber(str3));
		
//		int[] data = {3,2,9,4,7};
//		
//		System.out.println(Arrays.toString(data));
//		System.out.println("최대값: " + mc.max(data));
//		System.out.println("최대값: " + mc.max(null));
//		System.out.println("최대값: " + mc.max(new int[] {}));
		
//		int value = 5;
//		System.out.println(mc.abs(value));
//		
//		value = -10;
//		System.out.println(mc.abs(value));
		
//		SutdaDeck deck = new SutdaDeck();
		
//		for(int i=0; i<deck.cards.length; i++) {
//			System.out.print(deck.cards[i]+",");
//		}
		
		
//		System.out.println(deck.pick(0));
//		System.out.println(deck.pick());
//		deck.shuffle();
//		
//		for(int i=0; i<deck.cards.length; i++) {
//			System.out.print(deck.cards[i]+",");
//		}
//		
//		System.out.println();
//		System.out.println(deck.pick(0));
		
		
//		MyTv2 t = new MyTv2();
//		
//		t.setChannel(10);
//		System.out.println(t.getChannel());
//		t.setChannel(20);
//		System.out.println(t.getChannel());
//		t.goToPrevChannel();
//		System.out.println(t.getChannel());
//		t.goToPrevChannel();
//		System.out.println(t.getChannel());
		
		
//		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
//		
//		for(int i=0; i<arr.length; i++) {
//			mc.action(arr[i]);
//		}
		
		
//		Point3D p1 = new Point3D(1,2,3);
//		Point3D p2 = new Point3D(1,2,3);
//		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p1==p2);
//		System.out.println(p1.equals(p2));
		
		
//		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
//		String path = "";
//		String fileName = "";
//		
//		int pos = fullPath.lastIndexOf("\\");
//		
//		if(pos != -1) {
//			path = fullPath.substring(0, pos);
//			fileName = fullPath.substring(pos+1);
//		}
//		
//		
//		double d = 1.23456789;
//		System.out.println(round(d, 5));
		
		
		System.out.println(delChar("(1!2!@3^4~5)","~!@#$%^&()"));
		
		
	} // main

	
//	public static double round(double d, int n) {
//		double tmp = Math.pow(10, n);
//		
//		return Math.round(d*tmp)/tmp;
//	}
	
	
	public static String delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer(src);
		
		for(int j=0; j<src.length(); j++) {
			for(int i=0; i<delCh.length(); i++) {
				String ch = String.valueOf(delCh.charAt(i));
				int index = sb.indexOf(ch);
				if(index !=-1) {
					sb.deleteCharAt(index);
				}
			}
		}
		
		
		return sb.toString();
	}
	
	// 79p / 318p
	
	
	
}
