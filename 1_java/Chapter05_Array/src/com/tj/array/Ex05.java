package com.tj.array;

// �迭 ���� : 
public class Ex05 {
	public static void main(String[] args) {
		int[] num = { 100, 20, 30, 40, 50 };
		int[] newNum = new int[num.length];

		// for (int i = 0; i < num.length; i++) { // �迭�� �����ϴ� �۾��� for ������ �ߴ�.
		// newNum[i] = num[i];
		// }
		// arraycopy() : ī�ǿ��� �迭, �迭 �ε���, ī�ǵ� �迭, ī�ǵ� �迭�ε���, ������ ����.
		System.arraycopy(num, 0, newNum, 0, num.length);

		for (int i = 0; i < num.length; i++) {
			System.out.printf("num[%d] = %d\t newNum[%d] = %d \n", i, num[i], i, newNum[i]);
		}

		System.out.println("newNum �迭�� ����.");

		newNum[0] = 9;
		newNum[2] = 9;
		newNum[4] = 9;
		for (int i = 0; i < num.length; i++) { // �迭�� �����ص� �ּҰ� �ٸ��⶧���� num �� �ٸ���.
			System.out.printf("num[%d] = %d\t newNum[%d] = %d \n", i, num[i], i, newNum[i]);
		}
	}
}
