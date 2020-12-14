package com.study.self;

public class SutdaCard {
	final int NUM; // 카드의 숫자 1~10 사이의 정수
	final boolean ISKWANG; //광이면 true 아니면 false
	
	
	public SutdaCard() {
		this(1, true);
	}
	
	public SutdaCard(int num, boolean isKwang) {
		this.NUM = num;
		this.ISKWANG = isKwang;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SutdaCard) {
			SutdaCard c = (SutdaCard)obj;
			return NUM==c.NUM && ISKWANG == c.ISKWANG;
		}
		
		return false;
	}
	
	
	@Override
	public String toString() {
		return NUM + (ISKWANG ? "K" : "");
	}
	
	
	
//	public String info() {
//		String tmp = Integer.toString(num);
//		String kwang = " ";
//		
//		if(isKwang == true) {
//			kwang = "K";
//		}
		
//		return tmp+kwang;
//	}
	
}
