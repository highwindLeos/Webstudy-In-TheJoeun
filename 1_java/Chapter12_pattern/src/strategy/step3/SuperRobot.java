package strategy.step3;
// ���� O, �̻���O, ��������
public class SuperRobot extends Robot{
	public SuperRobot() {}
	@Override
	public void actionFly() {
		System.out.println("�� �� �ֽ��ϴ�");
	}
	@Override
	public void actionMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�");
	}
	@Override
	public void actionKnife() {
		System.out.println("������ ���� �ֽ��ϴ�");
	}
}
