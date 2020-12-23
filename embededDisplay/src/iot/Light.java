package iot;

public class Light implements RemoteControler {
	private String aptId;

	public Light(String aptId) {
		this.aptId = aptId;
	}
	
	@Override
	public boolean on() {
		System.out.println(aptId+ " : Light On");
		return true;
	}
	@Override
	public boolean off() {
		System.out.println(aptId+" : Light Off");
		return true;
	}
	
}
