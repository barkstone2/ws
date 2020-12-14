package exam01;

public class Student {
	String name;
	int kor;
	int eng;
	int math;
	int total;
	int avg;
	String grade;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor+eng+math;
		this.avg = total/3;
		if(this.avg>=90) {
			this.grade = "수";
		}else if(this.avg>=80) {
			this.grade = "우";
		}else if(this.avg>=70) {
			this.grade = "미";
		}else if(this.avg>=60) {
			this.grade = "양";
		}else {
			this.grade = "가";
		}
		
	}
	
	
	@Override
	public String toString() {
		return this.name +"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+this.total+"\t"+this.avg+"\t"+this.grade;
	}
	
	
	
}
