package com.tj.ex3set;

import java.util.HashSet;
import java.util.Random;

public class Ex2Lotto {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		
		Random ran = new Random();
		while(lotto.size() < 6) { // 6���� ���ö� ����.
			lotto.add(ran.nextInt(45)+1);
		} // HashSet �� �ߺ����� �Է¹����� ������� �ʱ⶧���� �̷� ������ ���ȴ�.
		
		System.out.println(lotto);
	}

}
