package com.tj.loof;
// 0 10 20 4  Done
public class ForEx05continue {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			if(i == 3) { continue; } // i가 3일 때 실행하지 않고 다시 (증감)으로 간다.
			System.out.println(i+" ");
			
		}
		System.out.println("Done");
	}

}
