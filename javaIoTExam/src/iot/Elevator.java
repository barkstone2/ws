package iot;

public class Elevator {
	private String aptId;
	
	public Elevator(String aptId) {
		this.aptId = aptId;
	}
	public Elevator() {
	}
	
	public boolean goingUp(int nowFloor, int stopFloor) {
		System.out.println(nowFloor + "층에서 "+stopFloor+"층으로..");
		return true;
	}
	public boolean goingDown(int nowFloor, int stopFloor) {
		System.out.println(nowFloor + "층에서 "+stopFloor+"층으로..");
		return true;
	}
	public boolean goingNone(int nowFloor, int stopFloor) {
		System.out.println("현재 층과 이동할 층이 동일합니다.");
		return true;
	}
	
	
}
