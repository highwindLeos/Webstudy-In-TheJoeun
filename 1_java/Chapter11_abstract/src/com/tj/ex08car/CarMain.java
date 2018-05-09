package com.tj.ex08car;

public class CarMain {

	public static void main(String[] args) {
		HighradeCar highCar1 = 
				new HighradeCar(CarSpec.COLOR_RED, CarSpec.TIRE_WIDE, CarSpec.DISPLACEMENT_2400,
				CarSpec.HANDLE_POWER);
		
		HighradeCar highCar2 = 
				new HighradeCar(CarSpec.COLOR_BLACK, CarSpec.TIRE_WIDE, CarSpec.DISPLACEMENT_2000,
				CarSpec.HANDLE_POWER);

		LowGradeCar lowCar1 = new LowGradeCar(CarSpec.COLOR_GRAY, CarSpec.TIRE_NOMAL, CarSpec.DISPLACEMENT_1000,
				CarSpec.HANDLE_NOMAL);

		Car[] cars = { highCar1, highCar2, lowCar1 };
		
		for(Car c : cars) {
			System.out.println(c.getSpec());
		}//for
	}// main
}
