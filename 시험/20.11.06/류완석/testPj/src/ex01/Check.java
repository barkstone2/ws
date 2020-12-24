package ex01;

import java.util.Scanner;

public class Check {
	public static void main(String[] args) {
		UserData ud = new UserData();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("id를 입력하세요>>");
		String dbId = sc.next();
		
		System.out.print("password를 입력하세요>>");
		String dbPwd = sc.next();
		
		if(dbId.equals(ud.getDbId()) && dbPwd.equals(ud.getDbPwd())) {
			System.out.println("일치");
		}else {
			System.out.println("불일치");
		}
		
		
	}
}
