package com.tj.loof;

import java.util.Scanner;

// 2*1 =2 3*1 

public class ForEx09gugu {

	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			for (int dan = 2; dan <= 9; dan++) {
				System.out.print(dan + "*" + i + "=" + (dan * i) + "\t");
			} // for end
			System.out.println();
		} // for end
	} // main end
}
