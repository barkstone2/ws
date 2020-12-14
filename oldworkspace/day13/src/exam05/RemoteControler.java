package exam05;

public interface RemoteControler {
	int MIN_VOLUME = 0;
	int MAX_VOLUME = 10;
	
	void turnOff();
	void turnOn();
	void setVolume(int i);
	
}
