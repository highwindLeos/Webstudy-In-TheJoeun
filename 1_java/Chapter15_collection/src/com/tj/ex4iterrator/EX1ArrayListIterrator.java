package com.tj.ex4iterrator;

import java.util.ArrayList;
import java.util.Iterator;

public class EX1ArrayListIterrator {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("str0");
		list.add("str1");
		list.add("str2");
		
		System.out.println(list);
		System.out.println();
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+"\t");
		} // ���ͷ����͸� �̿��� �ݺ���. list �� ��� ���� �����´�.
		System.out.println();
		for (int i = 0 ; i < list.size(); i ++) {
			System.out.println(list.get(i)+"/t");
		} // �Ϲ� for ������ ����Ѵ�.
		System.out.println();
		for (String lt : list) {
			System.out.println(lt + "\t");
		} // Ȯ�� for ������ ���. colletion ���� ����Ҷ� map �̳� set ���� ������ �ʴ´� (index ��� ������ ���� �����̴�.)
	}
}
