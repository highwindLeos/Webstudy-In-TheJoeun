package strategy.step2;
// ����X, �̻���O, ���
public class StandardRobot extends Robot{
	public StandardRobot() {}
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
