package com.tj.ex6treeset;

import java.util.Random;
import java.util.TreeSet;

public class ExTreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
		Random ran = new Random();
		int i = 0;
		while(lotto.size() < 6) {
			lotto.add(ran.nextInt(45)+1);
			i++;
		}
		System.out.println(lotto);
		System.out.println("반복문 작업 횟수는 " + i);
	}
}

