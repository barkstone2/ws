package iot;

public class Security implements RemoteControler {
	private String aptId;
	
	public Security(String aptId) {
		this.aptId = aptId;
	}
	public Security() {
	}
	
	@Override
	public boolean on() {
		System.out.println(aptId+ " : Security ON");
		return true;
	}
	@Override
	public boolean off() {
		System.out.println(aptId+" : Security OFF");
		return true;
	}
	
	
}
