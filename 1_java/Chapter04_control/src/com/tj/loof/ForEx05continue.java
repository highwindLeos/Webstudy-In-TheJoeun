package com.tj.loof;
// 0 10 20 4  Done
public class ForEx05continue {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			if(i == 3) { continue; } // i�� 3�� �� �������� �ʰ� �ٽ� (����)���� ����.
			System.out.println(i+" ");
			
		}
		System.out.println("Done");
	}

}
