package strategy.car.modularization;

import strategy.car.inter.EngineHigh;
import strategy.car.inter.FuelGasoline;
import strategy.car.inter.Km10;

public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("Genesis입니다. sheet, door, handle있어");
	}
}
