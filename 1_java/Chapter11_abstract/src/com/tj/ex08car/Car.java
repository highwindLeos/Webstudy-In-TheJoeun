package com.tj.ex08car;

//color tire displacement handle  method : getSpec()
public abstract class Car {
	private String color;
	private String tire;
	private int displacement;
	private String handle;

	// 생성자
	public Car() {
	}

	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	} // 멤버 변수를 모두 인자값으로 받는 생성자.

	// 메소드
	public abstract String getSpec();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

}
