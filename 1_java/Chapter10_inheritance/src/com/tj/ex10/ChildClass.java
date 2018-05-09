package com.tj.ex10;

public class ChildClass extends ParentClass {
	private int i = 99;
	
	public ChildClass() {
		super(); // �θ��� �����ڸ� ȣ��. �ݵ�� �Լ� ù�� ������� �;��Ѵ�.
		System.out.println("ChildClass �� ������");
	}
	
	/* overriding �� 
	 * �޼ҵ�� ���� , 
	 * �Ű����� ������ Ÿ��,
	 * ����Ÿ�� 
	 * ���������ڰ� ���ų� �� ���� ������ ����
	 * �θ� �޼ҵ带 overriding �ȴ�. */
	@Override 
	public void method() { 
		System.out.println("ChildClass�� method()");
		super.method(); // �θ��� �ִ� method()�� ȣ���Ҽ� �ִ�.
		System.out.println("super. �� ��ġ�� �ƹ����� �ü� �ִ�.");
	}
	
	@Override
	public int getI() {
		return super.getI(); 
	}

}
