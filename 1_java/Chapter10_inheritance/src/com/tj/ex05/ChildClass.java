package com.tj.ex05;

public class ChildClass extends ParentClass {
	
	public ChildClass() {
		System.out.println("c");
	}
	
	@Override
	public void method1() {
		System.out.println("ChildClass�� method1");
	}
	
//	public void method1() {
//		System.out.println("ChildClass�� method1");
//	} // overriding : �Ű������� ���� ���� ���� �Լ��� : ����� ������ ��ü�ȴ�. (���)
	
	public void method3() {
		System.out.println("ChildClass�� method3");
	} 
}
