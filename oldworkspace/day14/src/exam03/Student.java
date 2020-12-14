package exam03;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sci;
	private int his;
	private int tot;
	private double avg;
	
	public Student(String name, int kor, int eng, int mat, int sci, int his) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sci = sci;
		this.his = his;
		tot = kor+eng+mat+sci+his;
		avg = tot / 5D;
	}
	
	public Student() {
	}
	
	
	public int compare(Student s1, Student s2) {
		
		
		return s2.getTot() - s1.getTot();
	}
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getSci() {
		return sci;
	}

	public int getHis() {
		return his;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

	@Override
	public String toString() {
		return name +"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sci+"\t"+his+"\t"+tot+"\t"+avg;
	}

	
	
	
	
}
