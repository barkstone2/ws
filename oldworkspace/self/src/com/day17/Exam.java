package com.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exam {
	public static void main(String[] args) {
		
		ArrayList<String> barcode = new ArrayList<>();
		ArrayList<HashMap<String, String>> product = new ArrayList<>();		

		barcode.add("code001");
		barcode.add("code002");
		barcode.add("code003");
		
		HashMap<String, String> p1 = new HashMap<>();
		p1.put("이름", "맥주");
		p1.put("가격", "2500");
		p1.put("할인", "20");
		
		HashMap<String, String> p2 = new HashMap<>();
		p2.put("이름", "소주");
		p2.put("가격", "1500");
		p2.put("할인", "20");
		
		HashMap<String, String> p3 = new HashMap<>();
		p3.put("이름", "막걸리");
		p3.put("가격", "2000");
		p3.put("할인", "10");
		
		product.add(p1);
		product.add(p2);
		product.add(p3);
		
		//---------------------------------
		
		Scanner sc = new Scanner(System.in);
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		while(true) {
			System.out.println("선택(0:종료,1:결제,2:구매):");
			int menu = sc.nextInt();
			if(menu==0) {
				break;
			} else if(menu==1) {
				double subTotal = 0;
				double total = 0;
				for(HashMap<String,String> m:list) {
					String name = m.get("이름");
					int price = Integer.parseInt(m.get("가격"));
					int sale = Integer.parseInt(m.get("할인"));
					subTotal = price - (price * (sale * 0.01));
					total += subTotal;
				}
			} else if(menu==2) {
				System.out.println("바코드 입력");
				String bcode = sc.next();
				int index = barcode.indexOf(bcode);
				list.add(product.get(index));
				
				
			}
		}
		
		
		
	}
}
