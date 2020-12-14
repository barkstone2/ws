package exam05;

public class Audio implements RemoteControler {

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
	}

	@Override
	public void setVolume(int i) {
		System.out.println("오디오의 볼륨을 "+i+"로 설정합니다.");
	}

}
