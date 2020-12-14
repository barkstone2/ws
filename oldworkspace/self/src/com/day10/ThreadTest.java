package com.day10;

import javax.swing.JOptionPane;

public class ThreadTest {
	static long startTime = 0;
	
	public static void main(String[] args) {
//		ThreadTest_1 th1 = new ThreadTest_1();
//		th1.start();
//		startTime=System.currentTimeMillis();
//		
//		for(int i=0; i<300; i++) {
//			System.out.printf("%s",new String("-"));
//		}
//		System.out.print("소요시간1:" + (System.currentTimeMillis()-ThreadTest.startTime));
		RunImpl r1 = new RunImpl();
		RunImpl r2 = new RunImpl();
		RunImpl r3 = new RunImpl();
		Thread th1 = new Thread(r1, "*");
		Thread th2 = new Thread(r2, "**");
		Thread th3 = new Thread(r3, "***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			r1.suspend();
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		}catch(InterruptedException e) {}
		

		
		
		
//		for(int i=10; i>0; i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e) {}
//		}
		
		
		
		
		
	}
	
	
}
