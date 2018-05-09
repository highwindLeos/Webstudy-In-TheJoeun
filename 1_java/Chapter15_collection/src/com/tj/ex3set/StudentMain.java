package com.tj.ex3set;

import java.util.HashSet;
import java.util.Iterator;

public class StudentMain {

	public static void main(String[] args) { // 해쉬코드로 값이 동일 한지 비교한다. Hashset의 특성.
		HashSet<Student> set = new HashSet<Student>();
		
		Student lee = new Student("이만화", 2);
//		Student yi = new Student("이길우", 6);
		
		set.add(lee);
		set.add(new Student("이길우", 6));
		set.add(new Student("이길우", 6));
		set.add(lee);
		set.add(new Student("이길우", 6));
		
		System.out.println("set의 사이즈는 " + set.size());
		System.out.println(set);
		set.remove(new Student("이만화", 2)); // 삭제 메소드
		System.out.println(set);
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+"\t");
		}
		
	}

}
