package com.tj.ex3set;

import java.util.HashSet;
import java.util.Random;

public class Ex2Lotto {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		
		Random ran = new Random();
		while(lotto.size() < 6) { // 6개가 들어올때 까지.
			lotto.add(ran.nextInt(45)+1);
		} // HashSet 은 중복값을 입력받을때 허용하지 않기때문에 이런 로직에 사용된다.
		
		System.out.println(lotto);
	}

}
