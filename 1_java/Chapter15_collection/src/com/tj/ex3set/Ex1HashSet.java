package com.tj.ex3set;

import java.util.HashSet;

public class Ex1HashSet { // Hashset 중복을 허용하지 않는다.

	public static void main(String[] args) {
		HashSet<String> hashset = new HashSet<String>();
		
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		hashset.add("str3");
		hashset.add("str3"); // 해쉬셋은 데이터 입력 중복 허용 안함. 
		
		System.out.println(hashset);
		
		System.out.println(hashset+ " hashset 사이즈는 " + hashset.size());

		hashset.remove("str1"); // 데이터 삭제
		System.out.println(hashset);

	}

}
