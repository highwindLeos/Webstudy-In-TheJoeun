package com.tj.ex01;

public class TestMain {

	public static void main(String[] args) {
		
		ChildClass c = new ChildClass();
		ParentClass p = new ParentClass();
		
		System.out.println(p.pStr); 
		p.getMamiName(); 
		p.getMamiName();
		System.out.println();
		System.out.println(c.cStr);	//  ChildClass �� �����͸� ����Ҽ� �ִ�.
		System.out.println(c.pStr);	// ChildClass ���� ParentClass �� ����߱⿡ ParentClass �����͸� ����Ҽ� �ִ�.
		c.getMamiName(); c.getMamiName(); //ParentClass �� ����߱⿡ ChildClass ��ü���� ParentClass �Լ��� ����Ҽ� �ִ�.
		
	}

}
