package strategy.step5.modularization;

import strategy.step5.inter.*;

public class StandardRobot extends Robot {
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
		//fly     = new FlyNo();     //����X
		//missile = new MissileYes();//�̻���O
		//knife   = new KnifeWood(); //���
	}
	@Override
	public void shape() {
		System.out.println("StandardRobot�Դϴ�. ������ �ȴٸ�����Ӹ�.");
	}
}