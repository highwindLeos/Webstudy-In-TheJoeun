package com.tj.ex3set;

import java.util.HashSet;

public class Ex1HashSet { // Hashset �ߺ��� ������� �ʴ´�.

	public static void main(String[] args) {
		HashSet<String> hashset = new HashSet<String>();
		
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		hashset.add("str3");
		hashset.add("str3"); // �ؽ����� ������ �Է� �ߺ� ��� ����. 
		
		System.out.println(hashset);
		
		System.out.println(hashset+ " hashset ������� " + hashset.size());

		hashset.remove("str1"); // ������ ����
		System.out.println(hashset);

	}

}
