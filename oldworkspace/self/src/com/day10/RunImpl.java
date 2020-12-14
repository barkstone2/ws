package com.day10;

public class RunImpl implements Runnable {
	volatile boolean suspended	= false;
	volatile boolean stopped		= false;
	@Override
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {}
			}
		}
		System.out.println(Thread.currentThread().getName()+" - stopped");
	}
	public void suspend() {
//		System.out.print("-suspended");
		suspended = true;}
	public void resume() {
//		System.out.print("-resume");
		suspended = false;}
	public void stop() {stopped = true;}
	
	
}
