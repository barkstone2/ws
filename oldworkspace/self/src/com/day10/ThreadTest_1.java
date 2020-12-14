package com.day10;

public class ThreadTest_1 extends Thread{
	@Override
	public void run() {
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e) {}
		for(int i=0; i<300; i++) {
			System.out.print("-");
			for(int x=0; x < 10000000; x++);
		}
		System.out.println("<<th1 종료>>");
	}
}
