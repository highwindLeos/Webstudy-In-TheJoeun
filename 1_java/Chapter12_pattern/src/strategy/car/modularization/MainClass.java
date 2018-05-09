package strategy.car.modularization;

import strategy.car.inter.FuelHybrid;
import strategy.car.inter.Km20;

public class MainClass {
	public static void main(String[] args) {
		Genesis genesis = new Genesis();
		Sonata  sonata  = new Sonata();
		Accent  accent  = new Accent();
		Car[] cars = {genesis, sonata, accent};
		for(Car c : cars) {
			c.shape();
			c.drive();
			c.isEngine();
			c.isKm();
			c.isFuel();
			System.out.println("--------------------");
		}//for
		// Sonata 형 객체의 부품을 Hybrid형 연료로 교체. 연비 20km/l
		sonata.setFuel(new FuelHybrid()); // 연료교체
		sonata.setKm(new Km20());  //연비교체
		System.out.println("* * * 교체 후 * * *");
		for(Car c : cars) {
			c.shape();
			c.drive();
			c.isEngine();
			c.isKm();
			c.isFuel();
			System.out.println("--------------------");
		}//for
	}//main
}//class







