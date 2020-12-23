package iot;

public class Cucu implements RemoteControler {
	private String aptId;
	
	public Cucu(String aptId) {
		this.aptId = aptId;
	}
	
	@Override
	public boolean on() {
		System.out.println(aptId+" : Cucu 취사시작");
		return true;
	}

	@Override
	public boolean off() {
		System.out.println(aptId+" : Cucu 취사종료");
		return false;
	}
}

