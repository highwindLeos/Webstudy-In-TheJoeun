package com.tj.ex10;

public class ParentClass {
	
	private int i = 0;
	
	public ParentClass() { // ������ �޼ҵ�  ��Ȱ : ������ �ʱ�ȭ
		System.out.println("ParentClass�� ������");
	}
	
	protected void method() {
		System.out.println("PraentClass �� method()");
	}
	
	
	public int getI() {
		return i;
	}
}
