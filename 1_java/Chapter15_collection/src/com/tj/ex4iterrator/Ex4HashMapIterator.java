package com.tj.ex4iterrator;

import java.util.HashMap;
import java.util.Iterator;

public class Ex4HashMapIterator {
	public static void main(String[] args) {
		HashMap<String, Person> hashMap = new HashMap<String, Person>();
		// key 와 value 로 이루어져있다.
		hashMap.put("010-0000-9999", new Person("홍길동", "010-0000-9999", "서울"));
		hashMap.put("010-0000-8888", new Person("김구라", "010-0000-8888", "창원"));
		hashMap.put("010-0000-7777", new Person("박성재", "010-0000-7777", "군산"));
		
//		keyset 을 가져와서 iterator로 만들어야 한다. (HashMap 의 특성)
//		Set<String> set = hashMap.keySet();
//		Iterator<String> iterator = set.iterator(); 
		
		Iterator<String> iterator = hashMap.keySet().iterator(); 
		
		while(iterator.hasNext()) {
			String key = iterator.next(); // 키값만 가져옴
			System.out.println(hashMap.get(key).getName());
			System.out.println(hashMap.get(key).getTel());
			System.out.println(hashMap.get(key).getAdd());
			System.out.println("----------------------------------------------");
		}
	}
}
