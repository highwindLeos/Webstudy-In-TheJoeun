package com.tj.ex01;

public class TestMain {

	public static void main(String[] args) {
		// interface 는 인스턴스와 (객체로 생성) 불가 (예외 :익명클래스)
		// InterfaceEx1 ex1 = new InterfaceEx1();
		InterfaceEx1 ifex1 = new ClassEx();
		InterfaceEx2 ifex2 = new ClassEx();
		ClassEx 	 cex   = new ClassEx();
		
		// new ClassEx() 해서 객체를 만들면 ex1() ex2() 상수 2개
		cex.ex1(); cex.ex2();
		System.out.println("CONSTANT_NUM : " + InterfaceEx1.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : " + ClassEx.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : " + cex.CONSTANT_NUM);
		System.out.println("CONSTANT_STRING : " + InterfaceEx2.CONSTANT_STRING);
		System.out.println("CONSTANT_STRING : " + ClassEx.CONSTANT_STRING);
		System.out.println("CONSTANT_STRING : " + cex.CONSTANT_STRING);
		
		ifex1.ex1(); 
		/* ifex.ex2(); 이것은 불가능 : 객체에는 있지만 변수형이 ClassEX 가 아니기 때문에 */ 
		/* ifex2.ex1(); 이것은 불가능 : 객체에는 있지만 변수형이 ClassEX 가 아니기 때문에 */
		ifex2.ex2();
			
	}

}
