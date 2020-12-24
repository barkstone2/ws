package iot;

public class Light implements Remotable {
	private String aptId;
	
	public Light(String aptId) {
		this.aptId = aptId;
	}

	@Override
	public boolean turnOn() {
		System.out.println(aptId+" : Light ON");
		return true;
	}

	@Override
	public boolean turnOff() {
		System.out.println(aptId+" : Light OFF");
		return false;
	}

}
