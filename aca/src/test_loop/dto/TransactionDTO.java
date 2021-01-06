package test_loop.dto;

import java.sql.Timestamp;

public class TransactionDTO {
	private int no;
	private String name;
	private Timestamp regi_date;
	
	
	public TransactionDTO() {
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getRegi_date() {
		return regi_date;
	}


	public void setRegi_date(Timestamp regi_date) {
		this.regi_date = regi_date;
	}
	
	
	
	
}
