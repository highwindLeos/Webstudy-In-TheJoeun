package com.tj.loof;

public class ForEx05break {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			if(i == 3) { break; } // i�� 3�� �� ��������
			System.out.println(i+" ");
		}
		System.out.println("Done");
	}

}
