package com.tj.ex02;

public class ChildClass extends SuperClass {
	// Super ���� �߻� �޼ҵ�� �ݵ�� �������̵� �ؾ��ϰ� �Ϲ� �޼ҵ�� �ص��ǰ� �ʿ��Ұ�� �������̵� �Ѵ�.

	@Override
	public void method1() { 
		System.out.println("Child�� method1()");
	}
	
	@Override
	public void method2() {
		System.out.println("Child�� method2() �����ߴٰ� super �� �Ҳ���.");
		super.method2();
	} // �θ� �Ϲݸ޼ҵ� �������̵�.

}
