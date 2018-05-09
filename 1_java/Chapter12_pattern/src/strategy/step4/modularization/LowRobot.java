package strategy.step4.modularization;

import strategy.step4.inter.*;

public class LowRobot extends Robot{
	private IFly     fly;
	private IMissile missile;
	private IKnife   knife;
	public LowRobot() {
		fly     = new FlyNo();
		missile = new MissileNo();
		knife   = new KnifeNo();
	}
	@Override
	public void actionFly() {
		fly.fly();
	}
	@Override
	public void actionMissile() {
		missile.missile();
	}
	@Override
	public void actionKnife() {
		knife.knife();
	}
	public IFly getFly() {
		return fly;
	}
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public IMissile getMissile() {
		return missile;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public IKnife getKnife() {
		return knife;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
}
