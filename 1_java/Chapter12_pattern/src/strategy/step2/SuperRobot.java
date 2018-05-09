package strategy.step2;
// 날수 O, 미사일O, 레이저검
public class SuperRobot extends Robot{
	public SuperRobot() {}
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
