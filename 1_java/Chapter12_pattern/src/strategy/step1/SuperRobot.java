package strategy.step1;
// 날수 O, 미사일O, 레이저검
public class SuperRobot {
	public SuperRobot() {}
	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다");
	}
	public void shape() {
		System.out.println("SuperRobot입니다. 외형은 팔 다리 몸통 머리가 있습니다");
	}
	public void actionFly() {
		System.out.println("날 수 있습니다");
	}
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 있습니다");
	}
	public void actionKnife() {
		System.out.println("레이저 검이 있습니다");
	}
}
