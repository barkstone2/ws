package exam01;

public class Example {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Driver d = new Driver();
		Bus b = new Bus();
		Taxi t = new Taxi();
		
		Vehicle v = new Bus();
		
		Bus bus = (Bus)v;
		
		d.drive(v);
		
		
		
		
		
		
	}
}
