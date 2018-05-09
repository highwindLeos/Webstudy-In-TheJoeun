package com.tj.ex05;

public class ChildClass extends ParentClass {
	
	public ChildClass() {
		System.out.println("c");
	}
	
	@Override
	public void method1() {
		System.out.println("ChildClass의 method1");
	}
	
//	public void method1() {
//		System.out.println("ChildClass의 method1");
//	} // overriding : 매개변수와 리턴 값이 같은 함수로 : 기능이 완전히 대체된다. (덮어씀)
	
	public void method3() {
		System.out.println("ChildClass의 method3");
	} 
}
