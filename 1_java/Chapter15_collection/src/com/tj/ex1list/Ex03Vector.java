package com.tj.ex1list;

import java.util.Vector;

public class Ex03Vector {

	public static void main(String[] args) {
		Vector<Object> vector = new Vector<Object>();

		vector.add(new AClass()); // ��ü�� ������ �����͸� �Է�.
		vector.add(1, new BClass());
		vector.add("string");

		for (int i = 0; i < vector.size(); i++) {
			System.out.println(vector.get(i));
		} // �Ϲ� for ������ Vector �� ���� ����Ѵ�.
		
		System.out.println(vector);
	}
}
