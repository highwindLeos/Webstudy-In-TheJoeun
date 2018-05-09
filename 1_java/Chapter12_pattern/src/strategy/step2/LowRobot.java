package strategy.step2;
//날수X, 미사일X, 검X
public class LowRobot extends Robot{
	public LowRobot() {}
	public void actionFly() {
		System.out.println("날 수 없습니다");
	}
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없습니다");
	}
	public void actionKnife() {
		System.out.println("검이 없습니다");
	}
}
