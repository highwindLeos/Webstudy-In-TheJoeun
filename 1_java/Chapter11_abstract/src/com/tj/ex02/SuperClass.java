package com.tj.ex02;

public abstract class SuperClass {
	
	// 생성자
	public SuperClass () { System.out.println("SuperClass 생성자 호출됨"); }
	
	public abstract void method1(); // 추상메소드
	
	public void method2() {
		System.out.println("SuperClass의 method2() 호출 되었습니다.");
	} // 일반 메소드
	
}
