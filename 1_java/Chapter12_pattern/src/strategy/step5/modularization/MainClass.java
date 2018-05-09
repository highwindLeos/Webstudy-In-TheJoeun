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
		superR.setFly(new FlyHigh()); // ���� ��ǰ ���׷��̵�
		superR.actionFly(); // ���� �� �� �־��
		
	}//main
}//class















