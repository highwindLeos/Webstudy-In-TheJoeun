package strategy.step2;
//����X, �̻���X, ��X
public class LowRobot extends Robot{
	public LowRobot() {}
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}
	public void actionMissile() {
		System.out.println("�̻����� �� �� �����ϴ�");
	}
	public void actionKnife() {
		System.out.println("���� �����ϴ�");
	}
}
