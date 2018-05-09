package com.tj.ex04access.test;

import com.tj.ex04access.Woman;

public class WomanTestMain {

	public static void main(String[] args) {
		Woman w = new Woman();
		
		// w.privateMethod(); 에러가 난다. private 함수이기 때문. (접근을 제한)
		
		// w.defaultMethod(); // package 가 다르기때문에 에러가 난다. (접근이 안됨)
				
		// w.protectedMethod(); // package 가 다르기때문에 에러가 난다. (접근이 안됨)
				
		w.publicMethod(); 

	}

}
