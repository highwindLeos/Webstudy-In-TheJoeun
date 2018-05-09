package com.tj.ex1;

// 클래스를 만드는 형식.
// 패키지명 - 클래스 명 - 데이터 - 생성자 - 메소드 - getter setter 함수 
public class Squre {
	private int side;

	public Squre() {
		System.out.println("매개변수 없는 생성자 호출");
	}

	public Squre(int side) {
		this.side = side; // 보통 생성자 함수의 역활은 변수 초기화.
		System.out.println("매개변수 있는 생성자 호출");
	}
	
	public int area() {
		return side * side;
	}

	// getter setter 함수
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}
