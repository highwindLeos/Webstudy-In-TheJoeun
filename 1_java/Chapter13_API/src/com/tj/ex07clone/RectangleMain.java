package com.tj.ex07clone;

public class RectangleMain {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(6, 10);
		
		Class cls = r1.getClass();
		
		System.out.println("��ü Ÿ�� : " + cls.getName());
		System.out.println("�� ��ü�� Class �� �θ��(���۴�) : " + cls.getSuperclass());
		System.out.println("�� ��ü�� Class �� �θ��(���۴�) : " + cls.getSuperclass().getName());
	}

}
