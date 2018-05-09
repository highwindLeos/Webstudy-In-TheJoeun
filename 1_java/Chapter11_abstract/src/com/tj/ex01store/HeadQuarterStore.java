package com.tj.ex01store;

// 본사 클래스
public abstract class HeadQuarterStore { // keyword : abstract
	 /* 추상메소드 : 나를 상속받는 클래스 측에서 반드시 오버라이딩 해야한다. (추상메소드)
	  * 			구현부가 없고 메소드가 선언만 되어있다.
	  * 추상 클래스 (abstract class) : 추상 메소드가 한개 이상은 있다.
	  */
	
	public abstract String getName(); 
	
	public abstract void kimchi(); 

	public abstract void bude();

	public abstract void bibim();

	public abstract void sunde();
	
	public abstract void gonggibob();
	
}
