package com.tj.ex10;

public class ParentClass {
	
	private int i = 0;
	
	public ParentClass() { // 생성자 메소드  역활 : 데이터 초기화
		System.out.println("ParentClass의 생성자");
	}
	
	protected void method() {
		System.out.println("PraentClass 의 method()");
	}
	
	
	public int getI() {
		return i;
	}
}
