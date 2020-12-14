package exam07;

import java.io.File;

public class GetFileInfo {
	public static void main(String[] args) {
		File fi = new File("D:\\ws\\attach\\test.txt");
		if(fi.exists()) {
			System.out.println("파일이름 : "+fi.getName());
			System.out.println("절대경로 : " + fi.getAbsolutePath());
			System.out.println("사이즈 : "+ fi.length());
		}else {
			System.out.println("파일없음");
		}
		
		
		
	}
}
