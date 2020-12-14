package com.day6;

import java.util.Comparator;

public class ClassTotalComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student)o1;
			Student s2 = (Student)o2;
			if(s1.ban == s2.ban) {
				
				return -(s1.total - s2.total);
				
			}
			return s1.ban-s2.ban;
		}
		
		return -1;
	}

}
