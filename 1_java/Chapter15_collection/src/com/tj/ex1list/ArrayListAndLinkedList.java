package com.tj.ex1list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedList {

	public static void main(String[] args) {
		// �� �� ����
		ArrayList<Object> arrayList = new ArrayList<Object>();
		LinkedList<Object> linkedList = new LinkedList<Object>();

		System.out.println("arraylist ������ �߰� �ð� : " + addSeqTime(arrayList));
		System.out.println("linkedList ������ �߰� �ð� : " + addSeqTime(linkedList));
		
		System.out.println("arraylist �߰��� �߰� �ð� : " + addRanTime(arrayList));
		System.out.println("linkedList �߰��� �߰� �ð� : " + addRanTime(linkedList));
		
		System.out.println("arraylist ������ ���� �ð� : " + removeSeqTime(arrayList));
		System.out.println("linkedList ������ ���� �ð� : " + removeSeqTime(linkedList));
		
		System.out.println("arraylist �߰��� ���� �ð� : " + removeRanTime(arrayList));
		System.out.println("linkedList �߰��� ���� �ð� : " + removeRanTime(linkedList));
		
	}

	private static long addSeqTime(List list) {
		long start = System.currentTimeMillis();
		// �۾� ����
		for (int i = 0; i < 5000000; i++) {
			list.add("���������� �߰�");
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // �۾��ð��� ���̸� ���.
	}
	
	private static long addRanTime(List list) {
		long start = System.currentTimeMillis();
		// �۾� ����
		for (int i = 0; i < 1000; i++) {
			list.add(500,"�߰��� �߰�");
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // �۾��ð��� ���̸� ���.
	}
	
	private static long removeSeqTime(List list) {
		long start = System.currentTimeMillis();
		// �۾� ����
		for (int i = list.size() - 1; i > 100000; i--) {
			list.remove(i);
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // �۾��ð��� ���̸� ���.
	}
	
	private static long removeRanTime(List list) {
		long start = System.currentTimeMillis();
		// �۾� ����
		for (int i = 10; i < 1000; i++) {
			list.remove(i);
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // �۾��ð��� ���̸� ���.
	}

}
