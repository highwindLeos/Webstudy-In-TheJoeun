package strategy.step2;
// 날수X, 미사일O, 목검
public class StandardRobot extends Robot{
	public StandardRobot() {}
	public void actionFly() {
		System.out.println("날 수 없습니다");
	}
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 있습니다");
	}
	public void actionKnife() {
		System.out.println("목검이 있습니다.");
	}
}
