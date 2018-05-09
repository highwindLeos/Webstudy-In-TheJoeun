package com.tj.ex01;

public class TestMain {

	public static void main(String[] args) {
		
		ChildClass c = new ChildClass();
		ParentClass p = new ParentClass();
		
		System.out.println(p.pStr); 
		p.getMamiName(); 
		p.getMamiName();
		System.out.println();
		System.out.println(c.cStr);	//  ChildClass 의 데이터를 사용할수 있다.
		System.out.println(c.pStr);	// ChildClass 에서 ParentClass 를 상속했기에 ParentClass 데이터를 사용할수 있다.
		c.getMamiName(); c.getMamiName(); //ParentClass 를 상속했기에 ChildClass 객체에서 ParentClass 함수를 사용할수 있다.
		
	}

}
