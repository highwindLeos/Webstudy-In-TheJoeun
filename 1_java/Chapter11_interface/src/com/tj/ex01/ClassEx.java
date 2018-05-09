package com.tj.ex01;
//클래스 상속은 단일 상속만 가능 다중 상속은 불가하다.
// 인터패이스 implements(구현) 는 단일, 다중 구현이 모두 가능하다. 
// 
public class ClassEx implements InterfaceEx1, InterfaceEx2 {

	@Override
	public void ex1() {
		System.out.println("실제 구현은 클래스에서 ex1");
		System.out.println("ex1 상수 출력 : " + CONSTANT_NUM);
		System.out.println("ex2 상수 출력 : " + CONSTANT_STRING);
	}

	@Override
	public void ex2() {
		System.out.println("실제 구현은 클래스에서 ex2");
	}


}
