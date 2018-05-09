package com.tj.ex10;

public class ChildClass extends ParentClass {
	private int i = 99;
	
	public ChildClass() {
		super(); // 부모의 생성자를 호출. 반드시 함수 첫줄 명령으로 와야한다.
		System.out.println("ChildClass 의 생성자");
	}
	
	/* overriding 시 
	 * 메소드명 동일 , 
	 * 매개변수 개수와 타입,
	 * 리턴타입 
	 * 접근제한자가 같거나 더 넓은 범위로 지정
	 * 부모 메소드를 overriding 된다. */
	@Override 
	public void method() { 
		System.out.println("ChildClass의 method()");
		super.method(); // 부모의 있는 method()를 호출할수 있다.
		System.out.println("super. 의 위치는 아무데나 올수 있다.");
	}
	
	@Override
	public int getI() {
		return super.getI(); 
	}

}
