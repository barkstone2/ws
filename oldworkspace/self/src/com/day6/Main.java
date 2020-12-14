package com.day6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		//110 / 360
		Set set = new HashSet();
		int[][] board = new int[5][5];
		
		for(int i=0; set.size()<25; i++) {
			int r = (int)(Math.random()*30)+1;
			set.add(r+"");
		}//for end
		
		
		ArrayList list = new ArrayList(set);
		
		Collections.shuffle(list);
		
		
		Iterator it = list.iterator();
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j]<10 ? "  ":" ") + board[i][j]);
				
			}
			
			System.out.println();
			
		}
		
		
		
		
		
		
		
		
		
		
		
//		ArrayList list = new ArrayList();
//		
//		list.add(new Student("이자바",2,1,70,90,70));
//		list.add(new Student("안자바",2,2,60,100,80)); 
//		list.add(new Student("홍길동",1,3,100,100,100));
//		list.add(new Student("남궁성",1,1,90,70,80));
//		list.add(new Student("김자바",1,2,80,80,90));
//
//		calculateSchoolRank(list);
//		calculateClassRank(list);
//
//		Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		
		
		
	} // main end

	
	
//	public static void calculateSchoolRank(List list) {
//		Collections.sort(list); // list . 먼저 를 총점기준 내림차순으로 정렬한다
//		int prevRank = -1; // 이전 전교등수
//		int prevTotal = -1; // 이전 총점
//		int length = list.size();
//		int i = 1;
//		Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//			Student s1 = (Student)it.next();
//			if(s1.total == prevTotal) {
//				s1.schoolRank = prevRank;
//				i++;
//			}else {
//				s1.schoolRank = i;
//				i++;
//			}
//			prevRank = s1.schoolRank;
//			prevTotal = s1.total;
//			
//		}//while end
//	}//calculateSchoolRank method end
//	
//	public static void calculateClassRank(List list) {
//		Collections.sort(list, new ClassTotalComparator());
//		int prevBan = -1;
//		int prevRank = -1;
//		int prevTotal = -1;
//		int length = list.size();
//		int i = 1;
//		
//		Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//			Student s1 = (Student)it.next();
//			
//			if(s1.ban != prevBan) {
//				prevRank = -1;
//				prevTotal = -1;
//				i=1;
//			}
//			
//			if(s1.total == prevTotal) {
//				s1.classRank = prevRank;
//				i++;
//				
//			}else {
//				s1.classRank = i;
//				i++;
//			}
//			
//			prevBan = s1.ban;
//			prevRank = s1.classRank;
//			prevTotal = s1.total;
			
//		}
		
		
//	}
	
	
	
	
	
}// Class end
