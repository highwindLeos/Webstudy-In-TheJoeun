package com.tj.op;

public class Ex05 {

	public static void main(String[] args) {
		System.out.println("== ��Ʈ ������ (& , |, <<, >>) ==");
		int n1 = 10; // 2���� 01010
		int n2 = 5;  // 2���� 00101
		
		int resulte = n1 & n2;
		System.out.println("n1 & n2 = " + resulte);
		
		resulte = n1 | n2; // 0 1 1 1 1 
		System.out.println("n1 | n2 = " + resulte);
		
		resulte = n1 << 1; // 0 1 0 1 0 0 : ���ϱ� 2�� ���
		System.out.println("n1 << n2 = " + resulte);
		
		resulte = n1 >> 1; // 0 0 1 0 1 : ������ 2�� ���
		System.out.println("n1 >> n2 = " + resulte);
		
	}

}
