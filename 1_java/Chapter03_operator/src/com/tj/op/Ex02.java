package com.tj.op;

public class Ex02 {

	public static void main(String[] args) {
		System.out.println("= == ���� ������ (++ --) == =");
		
		int n1 = 10;
		// int n2 = n1++; //n1 �� 1 ���� ��Ų��. ���� ���߿� �����ϱ⿡ 10.
		// System.out.println("n1 = " + n1 + "\t n2=" + n2);
		int n2 = ++n1; //���� ���� ���� ��Ų��.
		System.out.print("n1 = " + n1 + "\t n2 = " + n2);
		System.out.println("n1 = " + n1 + "\t n2 = " + n2);
		
		int n3 = 10;
		// printf() �Լ�. format�� �༭ print - "����", "������"
		// %d (10���� ����), %c (����), %f (�Ǽ�), %s (���ڿ�), %x (16���� ����) %b(����)���
		System.out.printf("n3 = %d \n", n3++); //����������� ����.
		System.out.printf("n3 = %d \n", ++n3); 
		
	
		int n4 = 10;
		System.out.printf("n4 = %d \n", n4--); //����������� ����.
		System.out.printf("n4 = %d \n", --n4);
		
		int temp = 10;
		System.out.printf("%d %d %d %d", temp++, ++temp, temp--, --temp);
	
	}

}
