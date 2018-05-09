package com.tj.ex08final;

public abstract class Parent {
	private int i;
	protected final int PORT_NUMBER = 80;
	
	public void method1() {
		System.out.println("method1()");
	}
	
	public final void method2() {
		System.out.println("method2()");
	} // 재정의 불가능 (override 금지.)
	
	public abstract void method3(); // 반드시 상속해야함.
}
