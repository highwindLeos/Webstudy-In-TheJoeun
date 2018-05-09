package com.tj.ex07clone;

public class RectangleMain {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(6, 10);
		
		Class cls = r1.getClass();
		
		System.out.println("객체 타입 : " + cls.getName());
		System.out.println("내 객체의 Class 의 부모단(슈퍼단) : " + cls.getSuperclass());
		System.out.println("내 객체의 Class 의 부모단(슈퍼단) : " + cls.getSuperclass().getName());
	}

}
