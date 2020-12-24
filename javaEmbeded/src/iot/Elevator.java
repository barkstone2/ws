package iot;

public class Elevator {
	private String aptId;
	
	public Elevator(String aptId) {
		this.aptId = aptId;
	}
	
	public String callElv(int nowFloor, int stopFloor) {
		String msg = "";
		if(nowFloor>stopFloor) {
			elvDown(nowFloor, stopFloor);
			msg = nowFloor+"층에서 "+stopFloor+"층으로 엘리베이터를 호출했습니다.";
		}else if(nowFloor<stopFloor) {
			elvUp(nowFloor, stopFloor);
			msg = nowFloor+"층에서 "+stopFloor+"층으로 엘리베이터를 호출했습니다.";
		}else {
			msg = "현재 층과 이동할 층이 동일합니다.";
			System.out.println("현재 층과 이동할 층이 동일합니다.");
		}
		return msg;
	}
	
	public boolean elvUp(int nowFloor, int stopFloor) {
		System.out.println(nowFloor+"층에서 "+stopFloor+"층으로 엘리베이터가 올라갑니다.");
		return true;
	}
	
	public boolean elvDown(int nowFloor, int stopFloor) {
		System.out.println(nowFloor+"층에서 "+stopFloor+"층으로 엘리베이터가 내려갑니다.");
		return true;
	}
	
	
}
