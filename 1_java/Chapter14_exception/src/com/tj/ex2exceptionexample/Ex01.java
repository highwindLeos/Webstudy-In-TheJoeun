package com.tj.ex2exceptionexample;

public class Ex01 {
	public static void main(String[] args) {
		String name = null;
		
		String str = "a";
		int i = Integer.parseInt(str);
		
		System.out.println("i = "+i);
		System.out.println("끝");
		
//		System.out.println(name.charAt(0)); // 값이 없기때문에 포인트를 찾을수 없다.
	}
}
