package strategy.step2;

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
			if(r instanceof SuperRobot) {
				((SuperRobot)r).actionFly();
				((SuperRobot)r).actionMissile();
				((SuperRobot)r).actionKnife();
			}else if(r instanceof StandardRobot) {
				((StandardRobot)r).actionFly();
				((StandardRobot)r).actionMissile();
				((StandardRobot)r).actionKnife();
			}else if(r instanceof LowRobot) {
				((LowRobot)r).actionFly();
				((LowRobot)r).actionMissile();
				((LowRobot)r).actionKnife();
			}
		}//for
	}//main
}//class















