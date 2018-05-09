package strategy.step5.modularization;
import strategy.step5.inter.*;
public class SuperRobot extends Robot {
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
		//fly = new FlyYes();
		//missile = new MissileYes();
		//knife = new KnifeLazer();
	}
	@Override
	public void shape() {
		System.out.println("SuperRobot�Դϴ�. ������ �ȴٸ�����Ӹ�.");
	}
}






