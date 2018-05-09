package com.tj.ex4iterrator;

import java.util.HashMap;
import java.util.Iterator;

public class Ex4HashMapIterator {
	public static void main(String[] args) {
		HashMap<String, Person> hashMap = new HashMap<String, Person>();
		// key �� value �� �̷�����ִ�.
		hashMap.put("010-0000-9999", new Person("ȫ�浿", "010-0000-9999", "����"));
		hashMap.put("010-0000-8888", new Person("�豸��", "010-0000-8888", "â��"));
		hashMap.put("010-0000-7777", new Person("�ڼ���", "010-0000-7777", "����"));
		
//		keyset �� �����ͼ� iterator�� ������ �Ѵ�. (HashMap �� Ư��)
//		Set<String> set = hashMap.keySet();
//		Iterator<String> iterator = set.iterator(); 
		
		Iterator<String> iterator = hashMap.keySet().iterator(); 
		
		while(iterator.hasNext()) {
			String key = iterator.next(); // Ű���� ������
			System.out.println(hashMap.get(key).getName());
			System.out.println(hashMap.get(key).getTel());
			System.out.println(hashMap.get(key).getAdd());
			System.out.println("----------------------------------------------");
		}
	}
}
