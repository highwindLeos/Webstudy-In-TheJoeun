package com.tj.ex01;
/* interface의 멤버는 static final 상수와 추상메소드만 가능.
 * static final 키워드는 생략가능.
 * abstract는 생략가능
 * private 불가. 일반 정의 메소드 불가능.
*/
public interface InterfaceEx1 {
	public /*static final*/ int CONSTANT_NUM = 100; //static final 키워드는 생략가능.
	
	// private int i; // 인터페이스에는 일반 변수는 선언 불가.
	
	public /*abstract*/ void ex1(); // abstract는 생략가능
	
//	public void ex(); // 인터페이스에 정의된 모든 메소드는 추상 메소드다.
}
