package strategy.step3;
//����X, �̻���X, ��X
public class LowRobot extends Robot{
	public LowRobot() {}
	@Override
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}
	@Override
	public void actionMissile() {
		System.out.println("�̻����� �� �� �����ϴ�");
	}
	@Override
	public void actionKnife() {
		System.out.println("���� �����ϴ�");
	}
}
