package com.test.spring01.test;

import lombok.Data;

@Data
public class Test06VO {
	private String type;
	private String name;
	private int price;
	private int dcRate;
	private int dcPrice;
	private String maker;
	
	public void setDcPrice() {
		dcPrice = (int)(price * (dcRate/100.0));
	}
	
}
