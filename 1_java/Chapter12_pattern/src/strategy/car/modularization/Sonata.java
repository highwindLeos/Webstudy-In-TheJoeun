package strategy.car.modularization;

import strategy.car.inter.EngineMid;
import strategy.car.inter.FuelGasoline;
import strategy.car.inter.Km15;

public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("Sonata�Դϴ�. ��,��Ʈ,�ڵ��־�");

	}

}
