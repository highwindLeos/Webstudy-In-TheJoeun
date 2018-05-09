package com.tj.ex02;

public class ChildClass extends SuperClass {
	// Super 단의 추상 메소드는 반드시 오버라이드 해야하고 일반 메소드는 해도되고 필요할경우 오버라이딩 한다.

	@Override
	public void method1() { 
		System.out.println("Child의 method1()");
	}
	
	@Override
	public void method2() {
		System.out.println("Child의 method2() 수행했다가 super 측 할꺼야.");
		super.method2();
	} // 부모 일반메소드 오버라이딩.

}
