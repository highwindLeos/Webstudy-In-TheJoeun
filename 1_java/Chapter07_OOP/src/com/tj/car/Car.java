package com.tj.car;

public class Car {
	private String color; // ������ (�Ӽ�)
	private int cc;
	private String brand;
	private int speed;

	public void drive() {
		speed = 60;
		System.out.println("�ӵ�" + speed + "Km/h �� �����ϴ�");
	}

	public void parking() {
		speed = 0;
		System.out.println("�����Ѵ�. �ӵ��� " + speed);
	}

	public void race() {
		speed = 120;
		System.out.println("�ӵ� " + speed + "Km/h �� ���̽��ϴ�");
	}

	// setter �޼ҵ� : private �����͸� �����ϴ� �Լ�.
	public void setColor(String color) {
		this.color = color;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// getter �޼ҵ� : private �����͸� �������� �Լ�.
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
