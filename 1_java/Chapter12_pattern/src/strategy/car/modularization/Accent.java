package strategy.car.modularization;

import strategy.car.inter.EngineLow;
import strategy.car.inter.FuelDiesel;
import strategy.car.inter.Km10;

public class Accent extends Car {
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km10());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.println("Accent입니다. 문시트핸들 있어요");
	}
}
