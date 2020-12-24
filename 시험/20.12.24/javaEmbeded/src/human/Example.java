package human;

import java.util.Scanner;

import iot.AirConditioner;
import iot.Elevator;
import iot.Light;
import iot.Remotable;
import iot.Security;
import iot.Television;

public class Example {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String aptId = "";
		String[] result = new String[5];;
		Remotable rm;
		
		Loop1 : while(true) {
			System.out.print("aptId를 입력하세요 (종료:0):");
			aptId = sc.next();
			if(aptId.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				while(true) {
					System.out.println("명령어를 입력하세요.");
					System.out.println("1:엘리베이터 호출");
					System.out.println("2:Security");
					System.out.println("3:Light");
					System.out.println("4:AirConditioner");
					System.out.println("5:Television");
					System.out.println("기타:종료");
					System.out.print(">>");
					int com = sc.nextInt();
					int com2;
					boolean power = true;
					if(com==1) {
						Elevator ev = new Elevator(aptId);
						System.out.print("현재 층을 입력하세요:");
						int nowFloor = sc.nextInt();
						result[0] = ev.callElv(5, nowFloor);
					}else if(com==2) {
						rm = new Security(aptId);
						System.out.println("1:Security On 2:Security OFF");
						System.out.print(">>");
						com2 = sc.nextInt();
						if(com2==1) {
							power = rm.turnOn();
						}else if(com2==2) {
							power = rm.turnOff();
						}else {
							System.out.println("잘못된 명령입니다. 다시 입력하세요.");
							continue;
						}
						result[1] = (power==true?"Security ON":"Security OFF");
					}else if(com==3) {
						rm = new Light(aptId);
						System.out.println("1:Light On 2:Light OFF");
						System.out.print(">>");
						com2 = sc.nextInt();
						if(com2==1) {
							power = rm.turnOn();
						}else if(com2==2) {
							power = rm.turnOff();
						}else {
							System.out.println("잘못된 명령입니다. 다시 입력하세요.");
							continue;
						}
						result[2] = (power==true?"Light ON":"Light OFF");
					}else if(com==4) {
						rm = new AirConditioner(aptId);
						System.out.println("1:AirConditioner On 2:AirConditioner OFF");
						System.out.print(">>");
						com2 = sc.nextInt();
						if(com2==1) {
							power = rm.turnOn();
						}else if(com2==2) {
							power = rm.turnOff();
						}else {
							System.out.println("잘못된 명령입니다. 다시 입력하세요.");
							continue;
						}
						result[3] = (power==true?"AirConditioner ON":"AirConditioner OFF");
					}else if(com==5) {
						rm = new Television(aptId);
						System.out.println("1:Television On 2:Television OFF");
						System.out.print(">>");
						com2 = sc.nextInt();
						if(com2==1) {
							power = rm.turnOn();
						}else if(com2==2) {
							power = rm.turnOff();
						}else {
							System.out.println("잘못된 명령입니다. 다시 입력하세요.");
							continue;
						}
						result[4] = (power==true?"Television ON":"Television OFF");
					}else {
						System.out.println("프로그램을 종료합니다.");
						break Loop1;
					}
				}
			}
		} //while end
		if(!aptId.equals("0")) System.out.println(aptId);
		for(String a:result) {
			if(a!=null)	System.out.println(a);
		}
		
		
	}
}
