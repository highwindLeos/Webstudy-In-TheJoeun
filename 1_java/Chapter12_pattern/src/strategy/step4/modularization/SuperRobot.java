package strategy.step4.modularization;
import strategy.step4.inter.FlyYes;
import strategy.step4.inter.IFly;
import strategy.step4.inter.IKnife;
import strategy.step4.inter.IMissile;
import strategy.step4.inter.KnifeLazer;
import strategy.step4.inter.MissileYes;
public class SuperRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public SuperRobot() {
		fly = new FlyYes();
		missile = new MissileYes();
		knife = new KnifeLazer();
	}
	@Override
	public void actionFly() {
		fly.fly(); // 나는 부품
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






