package strategy.step4.modularization;

public abstract class Robot {
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
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
