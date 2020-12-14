package exam06;

public class Student {
	//이름, 국어, 영어, 수학, 과학, 역사, 총점, 평균, 등급
	String name;
	int kor;
	int eng;
	int mat;
	int sci;
	int his;
	int tot;
	double avg;
	String grade;
	
	public Student(String name, int kor, int eng, int mat, int sci, int his) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sci = sci;
		this.his = his;
		tot = kor+eng+mat+sci+his;
		avg = tot / 5D;
		grade();
		
	}
	
	public void grade(){
		if(avg>=90) {
			grade = "수";
		}else if(avg>=80) {
			grade = "우";
		}else if(avg>=70) {
			grade = "미";
		}else if(avg>=60) {
			grade ="양";
		}else {
			grade = "가";
		}
	}
	
	@Override
	public String toString() {
		return name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sci+"\t"+his+"\t"+tot+"\t"+avg+"\t"+grade;
	}
	
	
}
