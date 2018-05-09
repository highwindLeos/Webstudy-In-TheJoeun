package com.tj.ex1list;

import java.util.LinkedList;

public class Ex02LinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.add("str0");
		linkedList.add("str1");
		linkedList.add("str2");
		linkedList.add(1,"str1 으로 추가"); // 1번 인덱스에 문자열 추가
		
		System.out.println(linkedList);
		System.out.println(linkedList.size()); // 생성된 인덱스의 길이를 정수로 가져온다.
		
		linkedList.remove(1);  // 1번인덱스 값을 삭제.
		System.out.println(linkedList);
		
		linkedList.clear(); // 모든 인덱스의 값을 삭제
		System.out.println(linkedList.size() == 0 ? "비워졌네" : "안 비워졌네"); // 값이 없어서 참.
		
		linkedList.add("string0");
		System.out.println(linkedList.get(0)); // index의 데이터를 가져온다.
		
	}
}
