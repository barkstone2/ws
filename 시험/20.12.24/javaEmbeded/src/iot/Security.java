package iot;

public class Security implements Remotable {
	private String aptId;
	
	public Security(String aptId) {
		this.aptId = aptId;
	}
	
	@Override
	public boolean turnOn() {
		System.out.println(aptId+" : Security ON");
		return true;
	}

	@Override
	public boolean turnOff() {
		System.out.println(aptId+" : Security OFF");
		return false;
	}

}
