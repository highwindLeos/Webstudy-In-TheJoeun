package com.tj.ex4iterrator;

import java.util.HashSet;
import java.util.Iterator;

public class EX3SetIterator { // hashset 에서 iterator 를 만드는 법.

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		
		hashSet.add("str0");
		hashSet.add("str1");
		hashSet.add("str2");
		
		System.out.println(hashSet);
		
		Iterator<String> iterator = hashSet.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+"\t");			
		}
		
	}

}
