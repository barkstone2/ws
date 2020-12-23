package iot;

public class Tv implements RemoteControler {
	private String aptId;
	private int channel = 15;
			
	public Tv(String aptId) {
		this.aptId = aptId;
	}
	
	@Override
	public boolean on() {
		System.out.println(aptId+" : Tv ON (채널:"+channel+")");
		return true;
	}
	@Override
	public boolean off() {
		System.out.println(aptId+ " : Tv OFF (채널:"+channel+")");
		return true;
	}
	
}
