package com.tj.car;

public class CarMain {

	public static void main(String[] args) {
		Car myPorsche = new Car();
		Car yourPorsche = new Car();

		myPorsche.setColor("red"); // myPorsche.color = "red";
		myPorsche.setCc(3000);
		myPorsche.setSpeed(120);
		myPorsche.drive();
		myPorsche.race();
		myPorsche.parking();
		System.out.println("myPorsche ���� �� ��ⷮ " + myPorsche.getColor() + " / " + myPorsche.getCc());

		yourPorsche.setColor("gray");
		yourPorsche.setCc(2400);
		yourPorsche.setSpeed(80);
		yourPorsche.drive();
		yourPorsche.race();
		yourPorsche.parking();
		System.out.println("yourPorsche ���� �� ��ⷮ " + yourPorsche.getColor() + " / " + yourPorsche.getCc());
	}

}
