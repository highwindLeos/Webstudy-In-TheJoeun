package com.tj.ex11robot;
// 로봇의 특성을 파악 하여 일을 시킨다.
public class RobotOrder {
	public void action(IRobot robot) {
		// robot이 Singrobot 형 객체변수면 robot을 Singrobot 으로 형변환후 sing();
		// robot이 Dancerobot 형 객체변수면 robot을 Dancerobot 으로 형변환후 dance();
		// robot이 Drawrobot 형 객체변수면 robot을 Drawrobot 으로 형변환후 draw();
		
		if (robot instanceof SingRobot) { //instanceof : 객체변수가 우측에 적흰 형인지 물어봄 맞다면 true
			((SingRobot)robot).sing();
		}else if (robot instanceof DanceRobot) {
			((DanceRobot)robot).dance();
		}else if (robot instanceof DrawRobot) {
			((DrawRobot)robot).draw();
		} else {
			System.out.println("익명 클래스로 만들었나. 확인해보세요.(다른 타입이 세로 들어왔습니까?)");
		}

	}
}
