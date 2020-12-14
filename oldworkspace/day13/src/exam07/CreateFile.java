package exam07;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	public static void main(String[] args) {
		File fi = new File("D:\\ws\\attach\\test.txt");
		
		
		try {
			if(fi.createNewFile()) {
				System.out.println("File created : "+fi.getName());
			}else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
