package com.tj.ex01;

public class ParentClass {
	public String pStr = "부모 클래스";
	
	// 생성자.
	public ParentClass () {
		
	}
	
	// 사용자 정의 함수.
	public void getPapaName(){
		System.out.println("아빠이름 : 홍길동");
	}
	
	public void getMamiName(){
		System.out.println("엄마이름 : 김길순");
	}
}
