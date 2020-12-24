package iot;

public class AirConditioner implements Remotable {
	private String aptId;
	private double desiredTemperature = 23.0;

	public AirConditioner(String aptId) {
		this.aptId = aptId;
	}

	@Override
	public boolean turnOn() {
		System.out.println(aptId+" : AirConditioner ON (설정온도:"+desiredTemperature+")");
		return true;
	}

	@Override
	public boolean turnOff() {
		System.out.println(aptId+" : AirConditioner OFF (설정온도:"+desiredTemperature+")");
		return false;
	}

}
