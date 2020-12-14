package exam07;

import java.io.File;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		
		try {
			File fi = new File("D:\\ws\\attach\\test.txt");
			Scanner sc = new Scanner(fi);
			while(sc.hasNextLine()) {
				String data = sc.nextLine();
				System.out.println(data);
			}
		
			sc.close();
		}catch(Exception e) {
			System.out.println("An error occurred.");
		}
		
		
		
	}
}
