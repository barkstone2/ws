package com.test.spring01.test;

import lombok.Data;

@Data
public class Test05DTO {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sci;
	private int his;
	private int tot;
	private double avg;
	
	public void setTot() {
		tot = kor + eng + mat + sci + his;
	}
	
	public void setAvg() {
		avg = tot / 5.0;
	}
	
}
