package exam03;

public class PointDTO {
	
	private String name;
	private String[] sub = { "국어", "영어", "수학" };
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public PointDTO(String name, int kor, int eng, int math) {
		setName(name);
		setKor(kor);
		setEng(eng);
		setMath(math);
		setTot();
		avg();
	}

	public PointDTO() {
	}

	private void avg() {
		avg = tot / (double) sub.length;
	}

	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		if(0<=kor && kor <=100) {
			this.kor = kor;
		}
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		if(0<=eng && eng <=100)	{
			this.eng = eng;
		}
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		if(0<=math && math <=100) {
			this.math = math;
		}
		
	}

	public int getTot() {
		return tot;
	}

	public void setTot() {
		this.tot = kor + eng + math;
	}

	public double getAvg() {
		return avg;
	}

	
	
	
	
}
