package strategy.step5.modularization;

import strategy.step5.inter.FlyHigh;

public class MainClass {
	public static void main(String[] args) {
		SuperRobot    superR = new SuperRobot();
		StandardRobot standR = new StandardRobot();
		LowRobot      lowR   = new LowRobot();
		Robot[] robots = {superR, standR, lowR};
		for(Robot r : robots) {
			System.out.println("----------------");
			r.shape();
			r.actionWalk(); r.actionRun();
			r.actionFly();
			r.actionMissile();
			r.actionKnife();
		}//for
		superR.setFly(new FlyHigh()); // 나는 부품 업그레이드
		superR.actionFly(); // 높이 날 수 있어요
		
	}//main
}//class















