package com.tj.ex1list;

import java.util.ArrayList;

public class Ex01ArrayList {
	public static void main(String[] args) {
			
		String[] str = new String[3];
		str[0] = "str0";
		str[1] = "str1";
		str[2] = "str2";

		for (String ts : str) {
			System.out.println(ts);
		}// 배열 의 값을 가져오는 법. 확장 for 문이 사용가능하다.
		
		System.out.println();
		
		ArrayList<String> arrayList = new ArrayList<String>(); // String형 list 크기선언이 필요가 없다. (자동으로 확장됨)
		arrayList.add("str0"); // 0 index 에 str0 을 추가.
		arrayList.add("str1"); // 1 index 에 str1 을 추가.
		arrayList.add("str2"); // 2 index 에 str2 을 추가.
		arrayList.add(2, "str3"); // 2번 인덱스에 str2 원래의 2는 인덱스 3으로 밀려난다.

		System.out.println(arrayList.toString());

		for (String ts : arrayList) {
			System.out.println(ts);
		}// ArrayList 의 값을 가져오는 법. 확장 for 문이 사용가능하다.

		System.out.println();

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i)); //입력된 index 의 값을 반환한다.
		} // ArrayList 의 값을 가져오는 법. 일반 for 문

		arrayList.set(2, "str2"); // index 4번을 str4로 바꾼다.
		System.out.println(arrayList);

		arrayList.remove(2); // 입력된 값의 index를 삭제한다.
		System.out.println(arrayList);
		
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(i + "번째 인덱스 값 : " + arrayList.get(i));
		} 
		
		arrayList.clear(); // 해당 List 의 모든 값을 삭제한다.
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty() ? "비어있음" : "값이 있다."); 
		// 값이 있는지 없는지 확인해서 true/false 반환

		arrayList.add("str1");
		System.out.println(arrayList);
		
		arrayList = null; // null 값을 넣으면 생성된 ArrayList 객체를 삭제한다.
		System.out.println(arrayList);
		try {
			arrayList.add("str1"); // 객체가 삭제되어 메소드가 수행되지 않음. 예외발생.
		} catch (Exception e) {
			System.out.println("객체가 삭제되어 예외로 떨어짐");
		}
	}

}
