package com.tj.ex4iterrator;

import java.util.ArrayList;
import java.util.Iterator;

import com.tj.ex3set.Student;

public class EX2ArrayListIterrator {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student("È«±æµ¿", 6));
		list.add(new Student("±èµ¿¼ö", 5));
		list.add(new Student("È«±æµ¿", 6));
		
		System.out.println(list);
		
		Iterator<Student> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName()+"\t");
		}
		
		System.out.println();
		
		for (Student lt : list) {
			System.out.println(lt.getName()+"\t");
		}
	}
}
