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
		System.out.println("Sonata입니다. 문,시트,핸들있어");

	}

}
