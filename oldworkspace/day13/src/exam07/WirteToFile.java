package exam07;

import java.io.FileWriter;
import java.io.IOException;

public class WirteToFile {
	public static void main(String[] args) {
		
		try {
			FileWriter fi = new FileWriter("D:\\ws\\attach\\test.txt");
			fi.write("안녕하세요!!");
			fi.write("안녕하세요!!");
			fi.write("안녕하세요!!");
			fi.write("안녕하세요!!");
			fi.write("안녕하세요!!");
			fi.close();
			System.out.println("성공");
		} catch (IOException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
