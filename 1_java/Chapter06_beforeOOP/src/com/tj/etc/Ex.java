package com.tj.etc;

import com.tj.method.ArtisMetic;

public class Ex {

	public static void main(String[] args) {
		ArtisMetic sansu = new ArtisMetic();
		
		int sum = sansu.sum(1,10);
		System.out.println("누적합 은 " + sum);
		
	}

}
