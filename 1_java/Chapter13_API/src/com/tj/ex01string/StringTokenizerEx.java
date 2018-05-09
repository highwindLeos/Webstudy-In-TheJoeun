package com.tj.ex01string;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		String str1 = "유아인 황정민 강동원 김윤석 하정우";
		String str2 = "2017/12/25";
		// " " 마다 token 을 나누어 객체 생성
		StringTokenizer token1 = new StringTokenizer(str1);
		// "/" (매개변수로 입력되는 값이 기준) 를 기준으로 token 을 나누어 객체 생성
		StringTokenizer token2 = new StringTokenizer(str2, "/");
		System.out.println("token1 갯수 : " + token1.countTokens());
		System.out.println("token2 갯수 : " + token2.countTokens());

		while (token1.hasMoreTokens()) { // 토큰이 있는지 확인
			System.out.print(token1.nextToken() + "\t");
		}// nextToken() 메소드는 한번 처리하면 항상 마지막 포인터에 있다. 
		
		System.out.println();
		
		while (token2.hasMoreTokens()) { // 토큰이 있는지 확인
			System.out.print(token2.nextToken() + "\t");
		}

//		for (int i = 0; i < token2.countTokens(); i++) {
//			System.out.print(token2.nextToken() + "\t");
//		} Token 에서는 사용하지 않음.
	}

}
