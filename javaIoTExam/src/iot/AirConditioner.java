package iot;

public class AirConditioner implements RemoteControler{
	private String aptId;
	double desiredTemperature = 23.0;
	
	public AirConditioner(String aptId) {
		this.aptId = aptId;
	}
	@Override
	public boolean on() {
		System.out.println(aptId+" : Aircon ON (설정온도:"+desiredTemperature+")");
		return true;
	}
	@Override
	public boolean off() {
		System.out.println(aptId+" : Aircon OFF (설정온도:"+desiredTemperature+")");
		return true;
	}
	
	
	
	
}
