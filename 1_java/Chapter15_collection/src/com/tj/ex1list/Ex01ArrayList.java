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
		}// �迭 �� ���� �������� ��. Ȯ�� for ���� ��밡���ϴ�.
		
		System.out.println();
		
		ArrayList<String> arrayList = new ArrayList<String>(); // String�� list ũ�⼱���� �ʿ䰡 ����. (�ڵ����� Ȯ���)
		arrayList.add("str0"); // 0 index �� str0 �� �߰�.
		arrayList.add("str1"); // 1 index �� str1 �� �߰�.
		arrayList.add("str2"); // 2 index �� str2 �� �߰�.
		arrayList.add(2, "str3"); // 2�� �ε����� str2 ������ 2�� �ε��� 3���� �з�����.

		System.out.println(arrayList.toString());

		for (String ts : arrayList) {
			System.out.println(ts);
		}// ArrayList �� ���� �������� ��. Ȯ�� for ���� ��밡���ϴ�.

		System.out.println();

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i)); //�Էµ� index �� ���� ��ȯ�Ѵ�.
		} // ArrayList �� ���� �������� ��. �Ϲ� for ��

		arrayList.set(2, "str2"); // index 4���� str4�� �ٲ۴�.
		System.out.println(arrayList);

		arrayList.remove(2); // �Էµ� ���� index�� �����Ѵ�.
		System.out.println(arrayList);
		
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(i + "��° �ε��� �� : " + arrayList.get(i));
		} 
		
		arrayList.clear(); // �ش� List �� ��� ���� �����Ѵ�.
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty() ? "�������" : "���� �ִ�."); 
		// ���� �ִ��� ������ Ȯ���ؼ� true/false ��ȯ

		arrayList.add("str1");
		System.out.println(arrayList);
		
		arrayList = null; // null ���� ������ ������ ArrayList ��ü�� �����Ѵ�.
		System.out.println(arrayList);
		try {
			arrayList.add("str1"); // ��ü�� �����Ǿ� �޼ҵ尡 ������� ����. ���ܹ߻�.
		} catch (Exception e) {
			System.out.println("��ü�� �����Ǿ� ���ܷ� ������");
		}
	}

}
