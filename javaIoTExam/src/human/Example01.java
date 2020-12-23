package human;


import java.util.Scanner;

import db.DbMethod;
import db.HumanDTO;
import iot.AirConditioner;
import iot.Cucu;
import iot.Elevator;
import iot.Light;
import iot.RemoteControler;
import iot.Security;
import iot.Tv;

public class Example01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		RemoteControler rc;
		String aptId = "";
		String[] power = {"ON", "OFF", "OFF", "OFF", "OFF"};
		while(true) {
			System.out.print("명령어를 입력하세요.(0:종료 1:명령어 확인 2:입력)");
			int com = sc.nextInt();
			if(com==0) {
				System.out.println("시스템을 종료합니다.");
				break;
			}else if(com==1) {
				System.out.println("0:종료 1:Elevator Call 2:Security Off 3:AirConditioner On 4:Light On 5:Tv On 6:Cucu On");
			}else if(com==2) {
				System.out.print("aptId를 입력하세요:");
				aptId = sc.next();
				
				while(true) {
					System.out.print("리모트 명령어를 입력하세요:");
					int com2 = sc.nextInt();
					if(com2==1) {
						Elevator ev = new Elevator(aptId);
						ev.goingUp(1, 5);
					}else if(com2==2) {
						rc = new Security(aptId);
						rc.off();
						power[0] = "OFF";
					}else if(com2==3) {
						rc = new AirConditioner(aptId);
						rc.on();
						power[1] = "ON";
					}else if(com2==4) {
						rc = new Light(aptId);
						rc.on();
						power[2] = "ON";
					}else if(com2==5) {
						rc = new Tv(aptId);
						rc.on();
						power[3] = "ON";
					}else if(com2==6) {
						rc = new Cucu(aptId);
						rc.on();
						power[4] = "ON";
					}else if(com2==0) {
						System.out.println("리모트 컨트롤을 종료합니다.");
						break;
					}
				}
			}
		}
		HumanDTO dto = new HumanDTO(aptId, power[0], power[1], power[2], power[3], power[4]);
		DbMethod db = new DbMethod();
		db.setInsert(dto);
		
		
		
		
	}
}
