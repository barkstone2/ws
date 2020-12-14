package com.day17;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> pList = new ArrayList<>();
		
		while(true) {
			System.out.print("선택(1:상품관리, 2:회원관리, 기타:종료):");
			String com = sc.next();
			if(com.equals("1")) {
				System.out.println("-- 상품관리 --");
				while(true) {
					System.out.print("선택(1:상품목록, 2:상품등록, 기타:종료):");
					String pCom = sc.next();
					if(pCom.equals("1")) {
						System.out.println("-- 상품목록 --");
						System.out.println("상품명\t상품가격");
						for(Product p : pList) {
							System.out.println(p);
						}
					} else if(pCom.equals("2")) {
						System.out.println("-- 상품등록 --");
						System.out.print("상품명:");
						String pName = sc.next();
						System.out.print("상품가격:");
						int pPrice = sc.nextInt();
						pList.add(new Product(pName, pPrice));
					} else {
						break;
					}
				}//inner while end
				
			} else if(com.equals("2")) {
				System.out.println("-- 회원관리 --");
			} else {
				break;
			}
		} // outer while end
		
	}
}
