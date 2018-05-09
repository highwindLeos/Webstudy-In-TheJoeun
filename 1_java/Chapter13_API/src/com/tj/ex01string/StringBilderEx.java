package com.tj.ex01string;

public class StringBilderEx {
	public static void main(String[] args) {
		String str = "abc";
		
		StringBuilder strB = new StringBuilder("abc"); // 문자열을 설정하는 다른 객체
		str = str.concat("def");
		System.out.println(str);
		
		System.out.println(strB.append("def")); // 문자열을 추가해준다. abcdef
		strB.insert(1, 'X'); // 문자를 해당 인덱스에 추가한다. aXbcdef
		System.out.println(strB);
		strB.insert(1, "XX"); // 문자열을 해당 인덱스에 추가한다. aXXXbcdef
		System.out.println(strB);
		strB.delete(1, 4);	// 1번째부터 4번째 앞까지 삭제 (index : 1~3 )
		System.out.println(strB); // abcdef
		System.out.println("strB 의 capa?" + strB.capacity()); //  19 (가용범위)
		strB.append("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("strB 의 capa? " + strB.capacity()); //  44 (가용범위) 문자를 추가해도 알아서 늘어난다.
		strB.ensureCapacity(100);	// 수동으로 가용범위를 늘려준다.
		System.out.println("strB 의 capa? " + strB.capacity()); 
		
	}
}
