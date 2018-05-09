package com.tj.ex10;

public class TestMain {

	public static void main(String[] args) {
		ChildClass c = new ChildClass();
		
		c.method(); // 자식에 있는 method() 가 실행된다.
		
		System.out.println(c.getI());
		
	}

}
