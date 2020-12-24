package iot;

public class Television implements Remotable {
	private String aptId;
	
	public Television(String aptId) {
		this.aptId = aptId;
	}

	@Override
	public boolean turnOn() {
		System.out.println(aptId+" : Television ON");
		return true;
	}

	@Override
	public boolean turnOff() {
		System.out.println(aptId+" : Television OFF");
		return false;
	}

}
