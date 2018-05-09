package com.tj.ex1list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedList {

	public static void main(String[] args) {
		// 각 각 선언
		ArrayList<Object> arrayList = new ArrayList<Object>();
		LinkedList<Object> linkedList = new LinkedList<Object>();

		System.out.println("arraylist 순차적 추가 시간 : " + addSeqTime(arrayList));
		System.out.println("linkedList 순차적 추가 시간 : " + addSeqTime(linkedList));
		
		System.out.println("arraylist 중간에 추가 시간 : " + addRanTime(arrayList));
		System.out.println("linkedList 중간에 추가 시간 : " + addRanTime(linkedList));
		
		System.out.println("arraylist 순차적 삭제 시간 : " + removeSeqTime(arrayList));
		System.out.println("linkedList 순차적 삭제 시간 : " + removeSeqTime(linkedList));
		
		System.out.println("arraylist 중간에 삭제 시간 : " + removeRanTime(arrayList));
		System.out.println("linkedList 중간에 삭제 시간 : " + removeRanTime(linkedList));
		
	}

	private static long addSeqTime(List list) {
		long start = System.currentTimeMillis();
		// 작업 시작
		for (int i = 0; i < 5000000; i++) {
			list.add("순차적으로 추가");
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // 작업시간의 차이를 계산.
	}
	
	private static long addRanTime(List list) {
		long start = System.currentTimeMillis();
		// 작업 시작
		for (int i = 0; i < 1000; i++) {
			list.add(500,"중간에 추가");
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // 작업시간의 차이를 계산.
	}
	
	private static long removeSeqTime(List list) {
		long start = System.currentTimeMillis();
		// 작업 시작
		for (int i = list.size() - 1; i > 100000; i--) {
			list.remove(i);
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // 작업시간의 차이를 계산.
	}
	
	private static long removeRanTime(List list) {
		long start = System.currentTimeMillis();
		// 작업 시작
		for (int i = 10; i < 1000; i++) {
			list.remove(i);
		}
		
		long end = System.currentTimeMillis();
		
		return end - start; // 작업시간의 차이를 계산.
	}

}
