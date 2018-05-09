package com.tj.ex1list;

import java.util.LinkedList;

public class Ex02LinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.add("str0");
		linkedList.add("str1");
		linkedList.add("str2");
		linkedList.add(1,"str1 ���� �߰�"); // 1�� �ε����� ���ڿ� �߰�
		
		System.out.println(linkedList);
		System.out.println(linkedList.size()); // ������ �ε����� ���̸� ������ �����´�.
		
		linkedList.remove(1);  // 1���ε��� ���� ����.
		System.out.println(linkedList);
		
		linkedList.clear(); // ��� �ε����� ���� ����
		System.out.println(linkedList.size() == 0 ? "�������" : "�� �������"); // ���� ��� ��.
		
		linkedList.add("string0");
		System.out.println(linkedList.get(0)); // index�� �����͸� �����´�.
		
	}
}
