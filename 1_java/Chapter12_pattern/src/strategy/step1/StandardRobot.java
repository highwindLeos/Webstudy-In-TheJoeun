package strategy.step1;
// ����X, �̻���O, ���
public class StandardRobot {
	public StandardRobot() {}
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�");
	}
	public void shape() {
		System.out.println("StandardRobot�Դϴ�. ������ �� �ٸ� ���� �Ӹ��� �ֽ��ϴ�");
	}
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}
	public void actionMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�");
	}
	public void actionKnife() {
		System.out.println("����� �ֽ��ϴ�.");
	}
}
