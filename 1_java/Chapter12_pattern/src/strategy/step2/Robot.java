package strategy.step2;

public class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�");
	}
	public void shape() {
		System.out.println(getClass().getName()+
				"�Դϴ�. ������ �� �ٸ� ���� �Ӹ��� �ֽ��ϴ�");
	}
}
