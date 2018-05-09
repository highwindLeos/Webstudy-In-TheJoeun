package strategy.step4.modularization;

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
	}//main
}//class















