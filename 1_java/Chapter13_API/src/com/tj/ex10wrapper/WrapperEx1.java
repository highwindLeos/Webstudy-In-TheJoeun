package com.tj.ex10wrapper;

public class WrapperEx1 {
	
	public static void main(String[] args) {
		int i = 10;
		// Integer iobj = 10; 이런 식으로 값을 넣을 수도 있다. (String 과 비슷)
		Integer iobj = new Integer(10); // 객체 생성.
		Integer jobj = new Integer(20); // 객체 생성.
		
		System.out.println("iObj 정수 값은 "+ iobj); // toString() 이 생략되어있다.
		System.out.println("jObj 정수 값은 "+ jobj.intValue());
		
		// 뒤에 있는 더하기를 먼저해야 값이 나오고 문자열와 더해 문자열이된다.
		System.out.println("합은 "+ (iobj + jobj)); 
		
		String str = "hellow";
		System.out.println(str.equals(new Integer(10))); // 10 만 입력값으로 주어도 같은 값이 된다.
		System.out.println(str.equals(10)); // 위의 문장과 같다.

	}
	
}
