package com.tj.loof;

import java.util.Scanner;

// ��ǻ�Ͱ� ���� Lotto ��ȣ �� ���ߴ� ����.
//1�ܰ� : �ζ� ��ȣ�� su ���� ū�� ������ ��Ʈ.

public class DoWhileEx03 {

	public static void main(String[] args)  {
		// 0.0 <= Math.random() �Ǽ� < 1
		// 0.0 <= Math.random()*45<45 
		// 0 <= (int)(Math.random()*45<45
		// 1 <= (int)(Math.random()*45)+1 < 46
		int lotto, userNum;
		lotto = (int)(Math.random()*45) + 1; //1~45
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Lotto ��ȣ�� ���纸����. 1 ~ 45");
			userNum = sc.nextInt();
			
			if (userNum == lotto) {
				break;
			} else if(userNum > lotto) {
				System.out.print(userNum + "���� ���� ��ȣ�� �����ϼ���.");
			} else if(userNum < lotto) {
				System.out.print(userNum +"���� ū ��ȣ�� �����ϼ���.");
			} 
		}while(true);
			System.out.println("���߼̽��ϴ�!! Lotto  ��ȣ�� " + lotto + " �Դϴ�.");
	}// main
}
