package strategy.step3;
// ����X, �̻���O, ���
public class StandardRobot extends Robot{
	public StandardRobot() {}
	@Override
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}
	@Override
	public void actionMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�");
	}
	@Override
	public void actionKnife() {
		System.out.println("����� �ֽ��ϴ�.");
	}
}
