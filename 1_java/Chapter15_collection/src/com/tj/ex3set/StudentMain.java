package com.tj.ex3set;

import java.util.HashSet;
import java.util.Iterator;

public class StudentMain {

	public static void main(String[] args) { // �ؽ��ڵ�� ���� ���� ���� ���Ѵ�. Hashset�� Ư��.
		HashSet<Student> set = new HashSet<Student>();
		
		Student lee = new Student("�̸�ȭ", 2);
//		Student yi = new Student("�̱��", 6);
		
		set.add(lee);
		set.add(new Student("�̱��", 6));
		set.add(new Student("�̱��", 6));
		set.add(lee);
		set.add(new Student("�̱��", 6));
		
		System.out.println("set�� ������� " + set.size());
		System.out.println(set);
		set.remove(new Student("�̸�ȭ", 2)); // ���� �޼ҵ�
		System.out.println(set);
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+"\t");
		}
		
	}

}
