package com.tj.ex03overloading;

public class OverloadingTest {
	private int i1;
	private int i2;

	public OverloadingTest() { // overloading
		System.out.println("매개 변수 없는 생성자");
	}

	public OverloadingTest(int i) {
		System.out.println("int 매개 변수 하나 있는 생성자");
		i1 = i2 + i;
	}

	public OverloadingTest(String i) {
		System.out.println("String 매개 변수 하나 있는 생성자");
		i1 = i2 + Integer.parseInt(i); // 문자열을 정수로 바꾸어 준다.
	}

	public OverloadingTest(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}

	// 일반 메소드
	public int calculate() { // 오버로딩.
		return i1 + i2;
	}

	public int calculate(char c) {
		int resulte;
		
		switch (c) {
		case '+':
			resulte = i1 + i2;	break;
		case '-':
			resulte = i1 - i2;	break;
		case '*':
			resulte = i1 * i2;	break;		
		case '/':
			resulte = i1 / i2;	break;
		case '%':
			resulte = i1 % i2;	break;
		default:
			System.out.println("유효하지 않은 연산자 입니다.");
			resulte = 0;

		}
		return resulte;
	}
	// getter setter
	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}

}
