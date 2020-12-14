package com.study.self;

public class Student {

	String name;
	int ban; // 반
	int no; // 번호
	int kor; // 국어점수
	int eng;
	int math;
	
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String info() {
		String info;
		info = name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
		
		return info;
	}
	
	
	public int getTotal() {
		int total = kor + eng + math;
		
		return total;
	}
	
	public float getAverage() {
		float avg = (kor+eng+math)/3F;
		avg = (float)Math.round(avg*10)/10;
		
		return avg;
	}
	
	
	
	
	
	
	
	
}
