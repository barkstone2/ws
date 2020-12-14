package com.day11;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forDonut = lock.newCondition();
	private Condition forBurger = lock.newCondition();
	
	public void add(String dish) {
		lock.lock();
		
		try {
			while(dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is wating.");
				try {
					forCook.await();
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			}
			
			dishes.add(dish);
				if(dish=="donut") {
					forDonut.signal();
				}else if(dish=="burger") {
					forBurger.signal();
					}
			System.out.println("Dishes:"+dishes.toString());
		}finally {
			lock.unlock();
		}
	}
	
	public void remove(String dishName) {
		lock.lock();
		String name = Thread.currentThread().getName();
		try {
			while(dishes.size()==0) {
				System.out.println(name+" is waiting.");
				try {
					if(dishName=="donut") {forDonut.await();}
					else if(dishName=="burger") {forBurger.await();}
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			}
			while(true) {
				for(int i=0; i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal();
						return;
					}
				}
				
				try {
					System.out.println(name + " is waiting.");
					if(dishName=="donut") {
						forDonut.await();
						}else if(dishName=="burger") {
							forBurger.await();
							}
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			}
			
		}finally {
			lock.unlock();
		}
	}
	
	public int dishNum() { return dishNames.length;}
	
	
}
