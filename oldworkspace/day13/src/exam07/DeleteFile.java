package exam07;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		
		File fi = new File("D:\\ws\\attach\\test.txt");
		
		if(fi.delete()) {
			System.out.println("Delete : " + fi.getName());
		}else {
			System.out.println("Failed to delete.");
		}
		
		
		
	}
}
