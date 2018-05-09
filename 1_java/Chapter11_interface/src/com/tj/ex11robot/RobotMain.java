package com.tj.ex11robot;

public class RobotMain {

	public static void main(String[] args) {
		SingRobot singRobot = new SingRobot();
		DanceRobot danceRobot = new DanceRobot();
		DrawRobot drawRobot = new DrawRobot();
		
		RobotOrder order = new RobotOrder(); // 로봇에게 action()을 시킴
		
		IRobot[] robots = {singRobot,danceRobot,drawRobot};
		
		for (int i = 0 ; i < robots.length; i++) {
			order.action(robots[i]); // 매개변수에 따라서 호출되는 결과가 달라짐.
		}
		System.out.println("-------------------------------------");
		for (IRobot rTemp : robots) {
			order.action(rTemp);
		}
		
		
		
//		((SingRobot)singRobot).sing();  // 인터페이스에 메소드가 없기때문에 해당 메소드가 있는 형태로 형변환	
		
		

	}

}
