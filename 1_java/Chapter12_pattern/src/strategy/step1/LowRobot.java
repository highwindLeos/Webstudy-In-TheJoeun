package strategy.step1;
//����X, �̻���X, ��X
public class LowRobot {
	public LowRobot() {}
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�");
	}
	public void shape() {
		System.out.println("LowRobot�Դϴ�. ������ �� �ٸ� ���� �Ӹ��� �ֽ��ϴ�");
	}
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
