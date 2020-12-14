package com.day11;

public class ThreadTest01 {
	public static void main(String[] args) throws Exception {
		Table table = new Table();
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"),"CUST1").start();
		new Thread(new Customer(table, "burger"),"CUST2").start();
		
		Thread.sleep(2000);
		System.exit(0);
		
	}
	
	
	
	
}
