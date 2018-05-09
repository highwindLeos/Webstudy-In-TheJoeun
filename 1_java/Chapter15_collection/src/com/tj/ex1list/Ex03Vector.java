package com.tj.ex1list;

import java.util.Vector;

public class Ex03Vector {

	public static void main(String[] args) {
		Vector<Object> vector = new Vector<Object>();

		vector.add(new AClass()); // 객체로 생성된 데이터를 입력.
		vector.add(1, new BClass());
		vector.add("string");

		for (int i = 0; i < vector.size(); i++) {
			System.out.println(vector.get(i));
		} // 일반 for 문으로 Vector 의 값을 출력한다.
		
		System.out.println(vector);
	}
}
