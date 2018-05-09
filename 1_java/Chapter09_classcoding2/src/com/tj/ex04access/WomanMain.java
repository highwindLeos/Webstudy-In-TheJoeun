package com.tj.ex04access;

public class WomanMain {

	public static void main(String[] args) {
		Woman w = new Woman();
		
		// w.privateMethod(); 에러가 난다. private 함수이기 때문. (접근을 제한) : 같은 클래스 안에서만 접근이 가능.
		
		w.defaultMethod(); // 같은 패키지 않에 있으면 다른 class 에 있어도 접근이 된다.
		
		w.protectedMethod(); // 같은 패키지 않에 있으면 다른 class 에 있어도 접근이 된다.
		 
		w.publicMethod();

	}

}
