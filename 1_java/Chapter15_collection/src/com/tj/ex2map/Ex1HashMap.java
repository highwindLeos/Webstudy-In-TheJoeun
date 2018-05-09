package com.tj.ex2map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex1HashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>(); // <ket type, date type> 주로 wrapper 객체를 넣는다.
		
		hashMap.put(3, "str3");// HashMap 에 데이터를 입력. key 값이 있기때문에 순차는 의미가 없다.
		hashMap.put(0, "str0");  
		hashMap.put(1, "str1");
		hashMap.put(2, "str2"); 
		
		
		System.out.println(hashMap.toString());
//		System.out.println("key 가 2인 data" + hashMap.get(new Integer(2)));
		System.out.println("key 가 2인 data" + hashMap.get(2));
		
		hashMap.remove(2); // key 값이 2인 데이터를 삭제
		System.out.println("key 가 2 삭제후 " + hashMap);
		
		hashMap.clear(); // 입력된 데이터를 모두 삭제
		System.out.println("clear() 후 " + hashMap);

		hashMap.put(3, "이데이");// HashMap 에 데이터를 입력. key 값이 있기때문에 순차는 의미가 없다.
		hashMap.put(0, "홍길동");  
		hashMap.put(1, "김동일");
		hashMap.put(2, "이순신"); 
		hashMap.put(4, "유아인");
		// hashmap 은 for 문으로 모든 데이터를 출력할수 있는것이 아니다. key 가 정수가 아닐수도 있기때문이다.
		// 그래서 Iterator(반복자) 로 keyset 을 만들어 그것으로 참조한다.
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		
		while(iterator.hasNext()) { // key값을 모두 가져온다.
			Integer key = iterator.next(); // 다음값을 가르킨다.
			System.out.println(key + "키의 값은 " + hashMap.get(key));
		}
		
	}

}
