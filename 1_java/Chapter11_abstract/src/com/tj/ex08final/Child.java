package com.tj.ex08final;
// Parent - PORT_NUMBER , method 1() method2() method3()
//			상수	      일반메소드 final메소드 추상메소드
public class Child extends Parent {

	@Override
	public void method1() {
		System.out.println("child의 method1()"+PORT_NUMBER);
	}
	
/*	@Override
	public void method2() {
		
	} overrride 불가능 (final 메소드) */
	
	@Override
	public void method3() {
		
	}

}
