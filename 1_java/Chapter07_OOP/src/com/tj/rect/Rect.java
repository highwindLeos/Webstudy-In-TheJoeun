package com.tj.rect;

public class Rect {
	private int width; // data
	private int height;
	
	// 생성자 함수 : 객체가 생성될때 한번 호출. 생성자가 없다면 JVM 이 생성해준다.
	// 생성자 함수는 리턴 타입이 없고 클래스 명과 함수명이 같다.
	public Rect() { System.out.println("매개 변수 없는 생성자 호출");}
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
		System.out.println("매개 변수 있는 생성자 호출.");
	} // 생성자의 overloading 함수. (함수명은 같으나 매개 변수로 다른 함수.)
	
	public int area() { // method
		int resulte = width * height;

		return resulte;
	}

	// set : 매개 변수 값을 받아서 데이터 변수에 저장해주는 함수
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeigth(int height) {
		this.height = height;
	}
	// get : 클래스 멤버의 변수를 리턴해주는 함수.
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
