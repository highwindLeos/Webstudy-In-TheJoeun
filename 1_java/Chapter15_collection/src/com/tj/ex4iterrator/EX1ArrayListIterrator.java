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
		} // 이터레이터를 이용한 반복문. list 의 모든 값을 가져온다.
		System.out.println();
		for (int i = 0 ; i < list.size(); i ++) {
			System.out.println(list.get(i)+"/t");
		} // 일반 for 문으로 출력한다.
		System.out.println();
		for (String lt : list) {
			System.out.println(lt + "\t");
		} // 확장 for 문으로 출력. colletion 에서 사용할때 map 이나 set 에는 쓰이지 않는다 (index 라는 개념이 없기 때문이다.)
	}
}
