package com.tj.ex01string;

public class StringEx05 {
	public static void main(String[] args) {
		// 2002 월드컵
		System.out.println("월드컵 " +2+0+0+2);
		// 2002 월드컵
		System.out.println(""+2+0+0+2+"월드컵");
		
		String str1 = "월드컵";
		String str2 = "월드컵";
		String str3 = new String("월드컵");
		String str4 = new String("월드컵");
		System.out.println("str1 == str2 ? " + (str1 == str2)); // true
		System.out.println("str1 == str3 ? " + (str1 == str3)); // false
		System.out.println("str3 == str2 ? " + (str3 == str4)); // false
		
		/*System.out.println("str1 의 hashcode " + str1.hashCode());
		System.out.println("str2 의 hashcode " + str2.hashCode());*/
		System.out.println("str1 == str2 ? "+(str1 == str2));
		System.out.println("str3 의 수정전 hashcode "+ str3.hashCode());
		
		str1 = "월드컵 2002"; // 값을 바꿈.
		
		System.out.println("str1 수정후 비교");
		// 주소가 달라짐.
		System.out.println("str1 == str2 ? " + (str1 == str2));
		System.out.println("str1 의 hashcode " + str1.hashCode());
		System.out.println("str2 의 hashcode " + str2.hashCode());
		System.out.println("str3 의 hashcode " + str3.hashCode());
		
		str3 = "월드컵 2002";
		
		System.out.println("str3 의 수정후 hashcode " + str3.hashCode());

	}

}
