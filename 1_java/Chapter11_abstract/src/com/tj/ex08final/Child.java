package com.tj.ex08final;
// Parent - PORT_NUMBER , method 1() method2() method3()
//			���	      �Ϲݸ޼ҵ� final�޼ҵ� �߻�޼ҵ�
public class Child extends Parent {

	@Override
	public void method1() {
		System.out.println("child�� method1()"+PORT_NUMBER);
	}
	
/*	@Override
	public void method2() {
		
	} overrride �Ұ��� (final �޼ҵ�) */
	
	@Override
	public void method3() {
		
	}

}
