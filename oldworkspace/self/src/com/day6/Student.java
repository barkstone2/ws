package com.day6;

public class Student implements Comparable {

	String name;
	int ban;
	int no;
	int kor, eng, math;
	int total;
	int schoolRank;
	int classRank;
	
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor + eng + math;
		
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	
	@Override
	public String toString() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage()+","+schoolRank+","+classRank;
	}
	
	
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			
			return -(total - tmp.total);
		}else {
		
		return -1;
		}
	}
	
}
