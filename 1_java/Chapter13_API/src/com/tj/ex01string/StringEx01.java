package com.tj.ex01string;

import java.util.Scanner;

public class StringEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 10;
		
		String str1 = new String("java"); // 이렇게 되는 것을 
		String str2 = "java"; // 이렇게 되게 만들어 놓은 것이 String 참조형 데이터 객체
		
		String str01 = "Java";
		String str02 = "Java";
		String str03 = new String("Java");
		String str04 = new String("Java");
		
		if(str01 == str02) {
			System.out.println("str01 과 str02 같은곳을 참조한다.");
		} else {
			System.out.println("다른곳을 참조한다.");
		}
		
		 System.out.println( str1 == str2 ? "1과 2는 같은주소" : "1과 2는 다른주소");  
		 System.out.println(str01.equals(str02) ? "1과 2는 같은주소" : "1과 2는 다른주소");// equals() : 이것은 값을 비교한다.

		 System.out.println(str01 == str03 ? "1과 3은 같은주소" : "1과 3은 다른주소");
		 System.out.println(str01.equals(str03) ? "1과 3은 같은주소" : "1과 3은 다른주소");// equals() : 이것은 값을 비교한다.
	
		 System.out.println(str03 == str04 ? "3과 4는 같은주소" : "3과 4는 다른 주소");
		 System.out.println(str03.equals(str04) ? "3과 4는 같은주소" : "3과 4는 다른 주소");// equals() : 이것은 값을 비교한다.
	}
}
