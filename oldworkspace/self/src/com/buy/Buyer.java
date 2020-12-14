package com.buy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Buyer {
	int money = 1000;
	Product[] cart = new Product[3];
	int i = 0;
	
	public void buy(Product p) {
		if(money <p.price) {
			System.out.println("잔액부족" + p);
			return;
		}
		
		money = money - p.price;
		add(p);

	}
	
	
	public void add(Product p) {
		if(i>=cart.length) {
			Product[] tmp = new Product[cart.length*2];
			System.arraycopy(cart, 0, tmp, 0, cart.length);
			cart = tmp;
		}
		cart[i] = p;
		i++;

	}
	
	public void summary() {
		String itemList = "";
		int sum = 0;
		for(int i=0; i<cart.length; i++) {
			if(cart[i]==null) {
				break;
			}
			itemList += cart[i] + ", ";
			sum = sum + cart[i].price;
		} // for end
		
		System.out.println(itemList);
		System.out.println(sum);
		System.out.println(money);
	}
	
	
}
