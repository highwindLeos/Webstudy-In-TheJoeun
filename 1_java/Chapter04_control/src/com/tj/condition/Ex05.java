package com.tj.condition;

import java.util.Scanner;

/* �� �� �� �� �Է¹޾� ����� ���ϰ�
 * �������� ��պ��� ������ ������ ���.
*/

public class Ex05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ������ �Է��ϼ���.");
		int kor = sc.nextInt();
		
		System.out.println("���� ������ �Է��ϼ���.");
		int eng = sc.nextInt();
		
		System.out.println("���� ������ �Է��ϼ���.");
		int math = sc.nextInt();
		
		double avg = (double)(kor + eng + math) / 3; // ����� ���Ѵ�.
//		double avg = (kor + eng + math) / 3.0; // �Ǽ��� ����Ͽ� �Ǽ����� ���Եȴ�.
		
//		System.out.println("����� " + avg);
		System.out.printf("����� %.2f \n", avg);
		
		// ����
		if (kor > avg) {
			System.out.println("����� ��պ��� " + (kor - avg) + "�� ����.");
		} else if(kor < avg){
			System.out.println("����� ��պ��� " + (avg - kor) + "�� ����.");
		} else {
			System.out.println("����� ��հ� ����.");
		}
		// ����
		if (eng > avg) {
			System.out.println("����� ��պ��� " + (eng - avg) + "�� ����.");
		} else if(kor < avg){
			System.out.println("����� ��պ��� " + (avg - eng) + "�� ����.");
		} else {
			System.out.println("����� ��հ� ����.");
		}
		// ����
		if (math > avg) {
			System.out.println("������ ��պ��� " + (kor - math) + "�� ����.");
		} else if(kor < avg){
			System.out.println("������ ��պ��� " + (math - kor) + "�� ����.");
		} else {
			System.out.println("������ ��հ� ����.");
		}

		
	}

}
