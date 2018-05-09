package strategy.step5.modularization;

import strategy.step5.inter.*;

public class LowRobot extends Robot{
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
		//fly     = new FlyNo();
		//missile = new MissileNo();
		//knife   = new KnifeNo();
	}
	@Override
	public void shape() {
		System.out.println("LowRobot�Դϴ�. ������ �ȴٸ�����Ӹ�.");
	}
}
