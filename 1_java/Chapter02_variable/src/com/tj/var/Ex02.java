package com.tj.var;

public class Ex02 {
	public static void main(String[] agrs) {
		// ���� ���� ��
		
		//1. ���� ����� �Ҵ��� �и�
		int num1; //4byte
		num1 = 10;
		System.out.println("num1 = " + num1);
		
		//2. ��������� �Ҵ��� ���ÿ� �۾�
		int num2 = 20;
		System.out.print("num2 = " + num2 + "\n"); // \n�� �ٹٲ� (print �Լ�)
		
		//3. ������ �ڷ����� �ټ� ���� ����.
		
		int num3, num4, num5;
		
		num3 = 30; 
		num4 = 40; 
		num5 = 50;
		// format�� �־����� print - "����", "������"
		// %d 10���� ����, %c ����, %f �Ǽ�, %s ���ڿ�, %x 16���� ���
		System.out.printf("num3 = %d num4 = %d num4 = %d\n", num3, num4, num5);
		
		
		//4. ������ �ڷ����� ���ÿ� ����� �Ҵ�.
		int num6 = 60, num7 = 70, num8 = 80/*, num9 = 90*/;
		System.out.printf("num6 = %d \t num7 = %d \t num8 = %d\n", num6, num7, num8); // \t �鿩���� ���
	}
}
