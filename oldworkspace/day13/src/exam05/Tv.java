package exam05;

public class Tv implements RemoteControler{

	@Override
	public void turnOff() {
		System.out.println("티비를 끕니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("티비를 켭니다.");
	}

	@Override
	public void setVolume(int i) {
		System.out.println("티비의 볼륨을 "+ i + "로 설정합니다.");
	}

}
