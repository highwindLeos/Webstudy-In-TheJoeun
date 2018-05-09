package com.tj.ex11robot;

public class RobotMain {

	public static void main(String[] args) {
		SingRobot singRobot = new SingRobot();
		DanceRobot danceRobot = new DanceRobot();
		DrawRobot drawRobot = new DrawRobot();
		
		RobotOrder order = new RobotOrder(); // �κ����� action()�� ��Ŵ
		
		IRobot[] robots = {singRobot,danceRobot,drawRobot};
		
		for (int i = 0 ; i < robots.length; i++) {
			order.action(robots[i]); // �Ű������� ���� ȣ��Ǵ� ����� �޶���.
		}
		System.out.println("-------------------------------------");
		for (IRobot rTemp : robots) {
			order.action(rTemp);
		}
		
		
		
//		((SingRobot)singRobot).sing();  // �������̽��� �޼ҵ尡 ���⶧���� �ش� �޼ҵ尡 �ִ� ���·� ����ȯ	
		
		

	}

}
