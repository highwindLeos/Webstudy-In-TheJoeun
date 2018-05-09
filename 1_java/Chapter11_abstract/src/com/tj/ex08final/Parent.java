package com.tj.ex08final;

public abstract class Parent {
	private int i;
	protected final int PORT_NUMBER = 80;
	
	public void method1() {
		System.out.println("method1()");
	}
	
	public final void method2() {
		System.out.println("method2()");
	} // ������ �Ұ��� (override ����.)
	
	public abstract void method3(); // �ݵ�� ����ؾ���.
}
