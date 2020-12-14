package com.day7;

import java.util.Objects;

public class Student {

	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		this.name = "David";
		this.age = 20;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student)obj;
			return name.equals(s.name) && age==s.age;
			}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name,age);
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+age;
	}
	
}
