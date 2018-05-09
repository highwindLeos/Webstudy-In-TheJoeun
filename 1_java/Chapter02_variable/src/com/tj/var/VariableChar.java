package com.tj.var;

public class VariableChar { // char 데이터 형을 한 글자의 문자만 저장한다.

	public static void main(String[] args) {
		char c1 = 'A'; // 문자를 직접 저장
		char c2 = 65; // 해당 수의 10진수 유니코드를 저장한다.
		char c3 = '\u0041'; // 해당 16진수 유니코드를 저장한다.
		
		char c4 = '가';
		char c5 = 44032;
		char c6 = '\uac00';
		
		int unicode = c1; //유니코드를 얻는다.
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(unicode);
		
	}

}
