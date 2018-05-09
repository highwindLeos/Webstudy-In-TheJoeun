package strategy.step1;

public class MainClass {
	public static void main(String[] args) {
		SuperRobot    superR = new SuperRobot();
		StandardRobot standR = new StandardRobot();
		LowRobot      lowR   = new LowRobot();
		System.out.println("----------------");
		superR.shape();
		superR.actionWalk(); superR.actionRun();
		superR.actionFly();  superR.actionMissile();
		superR.actionKnife();
		System.out.println("----------------");
		standR.shape();
		standR.actionWalk(); standR.actionRun();
		standR.actionFly();  standR.actionMissile();
		standR.actionKnife();
		System.out.println("----------------");
		lowR.shape();
		lowR.actionWalk();  lowR.actionRun();
		lowR.actionFly();   lowR.actionMissile();
		lowR.actionKnife();
	}
}
