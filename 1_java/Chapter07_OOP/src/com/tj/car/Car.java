package com.tj.car;

public class Car {
	private String color; // 데이터 (속성)
	private int cc;
	private String brand;
	private int speed;

	public void drive() {
		speed = 60;
		System.out.println("속도" + speed + "Km/h 로 운전하다");
	}

	public void parking() {
		speed = 0;
		System.out.println("주차한다. 속도는 " + speed);
	}

	public void race() {
		speed = 120;
		System.out.println("속도 " + speed + "Km/h 로 레이싱하다");
	}

	// setter 메소드 : private 데이터를 셋팅하는 함수.
	public void setColor(String color) {
		this.color = color;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// getter 메소드 : private 데이터를 가져오는 함수.
	public String getColor() {
		return this.color;
	}

	public int getCc() {
		return this.cc;
	}

	public int getSpeed() {
		return this.speed;
	}
}
