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
		// Sonata �� ��ü�� ��ǰ�� Hybrid�� ����� ��ü. ���� 20km/l
		sonata.setFuel(new FuelHybrid()); // ���ᱳü
		sonata.setKm(new Km20());  //����ü
		System.out.println("* * * ��ü �� * * *");
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







