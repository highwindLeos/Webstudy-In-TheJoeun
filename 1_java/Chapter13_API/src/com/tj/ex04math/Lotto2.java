package com.tj.ex04math;

public class Lotto2 {

	public static void main(String[] args) {
	
		int Lotto[] = new int[7];
		
		System.out.print("Lotto ���� ���ڴ� ");
		
		for(int i=0; i < Lotto.length; i++){
			Lotto[i] = (int)(Math.random()*45)+1; // Random �Լ� �� �̿��� ���� (1~45)
			for(int j = i - 1; j >= 0; j--){
				if(Lotto[i] == Lotto[j]){
					i--;
					break;
				}
			}
		}// �ߺ� �� ����2
		// ���
		for(int i=0; i < Lotto.length; i++){
			System.out.print(Lotto[i] + " ");
		}
		System.out.print("���ʽ� ���ڴ� " + Lotto[6] + "�Դϴ�.");
	}
	
}