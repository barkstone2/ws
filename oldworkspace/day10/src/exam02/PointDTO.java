package exam02;

import java.util.ArrayList;
import java.util.Scanner;

public class PointDTO {

	private String name;
	private String[] sub = { "국어", "영어", "수학" };
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private String grade;

	public PointDTO(String name, int kor, int eng, int math) {
		setName(name);
		setKor(kor);
		setEng(eng);
		setMath(math);
		total();
		avg();
		grade();
	}

	public PointDTO() {
	}
	
	
	public ArrayList<PointDTO> input() {
		
		PointDTO temp = null;
		ArrayList<PointDTO> tempL = new ArrayList<>();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				break;
			}
			
			@SuppressWarnings("resource")
			Scanner sc2 = new Scanner(input).useDelimiter(",");
			
			try {
				temp = new PointDTO(sc2.next(), sc2.nextInt(), sc2.nextInt(), sc2.nextInt());
				
			}catch(Exception e) {
				System.out.println("잘못 입력");
				continue;
			}
			tempL.add(temp);
		}
		return tempL;
	}
	
	
	
	public void printList(ArrayList<PointDTO> list) {
		String msg = "이름\t";
		if(list.size()>0) {
			for(String tmp : sub) {
				msg += (tmp+"\t");
			}
			msg +="총점\t평균\t등급\n";
			msg +="======================================================";
			System.out.println(msg);
			for(PointDTO tmp : list) {
				System.out.println(tmp);
			}
		}
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	private void total() {
		tot = kor + eng + math;
	}

	private void avg() {
		avg = tot / (double) sub.length;
	}

	private void grade() {
		if (avg >= 90) {
			grade = "수";
		} else if (avg >= 80) {
			grade = "우";
		} else if (avg >= 70) {
			grade = "미";
		} else if (avg >= 60) {
			grade = "양";
		} else {
			grade = "가";
		}
	}

	
	
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		if(0<=kor && kor<=100) {
			this.kor = kor;
		}else {
			System.out.println("잘못된 국어 점수");
		}
	}

	public void setEng(int eng) {
		if(0<=eng && eng<=100) {
			this.eng = eng;
		}else {
			System.out.println("잘못된 영어 점수");
		}
		
	}

	public void setMath(int math) {
		if(0<=math && math<=100) {
			this.math = math;
		}else {
			System.out.println("잘못된 수학 점수");
		}
		
	}
	
	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg + "\t" + grade;
	}

	
}
