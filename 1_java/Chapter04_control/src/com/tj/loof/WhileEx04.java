package com.tj.loof;

public class WhileEx04 {

	public static void main(String[] args) {
		int i = 1; //�ݺ� ����
		int total = 0; // ���� ����
		while(i <= 100) {
			if((i%3) == 0) {
				total += i;
			} //if
			i++;
		}//while
		System.out.println("1~100 ���� 3�� ����� ���� + "+total);
	}// main
}
