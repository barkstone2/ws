package exam03;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDTO {
	
	static final int TUIT = 2000000;
	
	private String stNum;
	private String name;
	private int stYear;
	private double gradeP = -1;
	private int scholaship;
	
	public StudentDTO(String stNum, String name, int stYear, double gradeP) throws Exception{
			
				setStNum(stNum);
				setName(name);
				setStYear(stYear);
				setGradeP(gradeP);
				setScholaship();
		
	}

	public StudentDTO() {
	}
	
	public ArrayList<StudentDTO> inputStInfo() {
		ArrayList<StudentDTO> result = new ArrayList<StudentDTO>();
		StudentDTO tmp;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학번,이름,학년,학점 순으로 입력하세요.");
		System.out.println("입력을 종료하려면 Q를 입력하세요.");
		
		while(true) {
			System.out.print(">>");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			
			@SuppressWarnings("resource")
			Scanner sc2 = new Scanner(input).useDelimiter(",");
			
			try {
				tmp = new StudentDTO(sc2.next(), sc2.next(), sc2.nextInt(), sc2.nextDouble());
				
			}catch(Exception e) {
				System.out.println("양식에 맞춰 다시 입력하세요.");
				continue;
			}
			
			result.add(tmp);
			
		}//while end
		
		return result;
	}
	
	
	
	public void printList(ArrayList<StudentDTO> list) {
		if(!list.isEmpty()) {
			String msg = "학번\t\t이름\t학년\t학점\t장학금\n";
			msg += "===============================================\n";
			for(StudentDTO t : list) {
				msg += (t+"\n");
			}
			System.out.println(msg);
		}else {
			System.out.println("목록이 비어있습니다.");
		}
	}
	
	
	
	
	
	
	
	
	public void setScholaship() {
		if(gradeP==-1) {
			System.out.println("학점을 먼저 입력하세요.");
		}else {
			if(gradeP==4.5) {
				scholaship = TUIT;
			}else if(gradeP>=4.0) {
				scholaship = 1500000;
			}else if(gradeP>=3.5) {
				scholaship = 1000000;
			}else if(gradeP>=3.0) {
				scholaship = 500000;
			}else {
				scholaship = 0;
			}
		}
	}
	
	public void setStNum(String stNum) throws Exception{
		if(stNum.length()==8) {
			this.stNum = stNum;
		}else {
			System.out.println("학번을 잘못 입력했습니다.(8자리)");
			throw new Exception("학번을 잘못 입력했습니다.(8자리)");
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStYear(int stYear) throws Exception{
		if(1<=stYear && stYear <= 4) {
			this.stYear = stYear;
		}else {
			System.out.println("학년을 잘못 입력했습니다(1~4)");
			throw new Exception("학년을 잘못 입력했습니다(1~4)");
		}
	}

	public void setGradeP(double gradeP) throws Exception {
		if(0<=gradeP && gradeP<=4.5) {
			this.gradeP = gradeP;
		}else {
			System.out.println("학점을 잘못 입력했습니다.(0~4.5)");
			throw new Exception("학점을 잘못 입력했습니다.(0~4.5)");
		}
	}
	
	
	
	
	
	
	public static int getTuit() {
		return TUIT;
	}

	public String getStNum() {
		return stNum;
	}

	public String getName() {
		return name;
	}

	public int getStYear() {
		return stYear;
	}

	public double getGradeP() {
		return gradeP;
	}

	public int getScholaship() {
		return scholaship;
	}

	@Override
	public String toString() {
		return stNum+"\t"+name+"\t"+stYear+"\t"+gradeP+"\t"+scholaship;
	}
		
	
}
