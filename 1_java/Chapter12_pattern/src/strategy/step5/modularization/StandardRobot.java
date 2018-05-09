package strategy.step5.modularization;

import strategy.step5.inter.*;

public class StandardRobot extends Robot {
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
		//fly     = new FlyNo();     //날수X
		//missile = new MissileYes();//미사일O
		//knife   = new KnifeWood(); //목검
	}
	@Override
	public void shape() {
		System.out.println("StandardRobot입니다. 외형은 팔다리몸통머리.");
	}
}