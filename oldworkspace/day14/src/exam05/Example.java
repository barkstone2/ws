package exam05;

public class Example {
	public static void main(String[] args) {

		Printer dp = new DotPrinter();
		dp.printer();

		Printer ip = new InkjetPrinter();
		ip.printer();

		Printer lp = new LaserPrinter();
		lp.printer();

		System.out.println("---------------------------------");

		Printer p = new Printer();
		p.printer();

		p = new InkjetPrinter();
		p.printer();

		p = new LaserPrinter();
		p.printer();
		
		

	}
}
