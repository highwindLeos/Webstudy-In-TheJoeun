package com.tj.array;

public class Ex02 {
	public static void main(String[] args) {
		// 2. �迭 ����� �ʱ�ȭ�� ������
		int i;
		i = 10;

		int[] arr = new int[3]; // �ε����� Ȯ���Ѵ� index : 0 ~ 2
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
//		arr[3] = 4; // �Ҵ翡�� ������ ������ ������ ���� �ʴ´�. (�迭�� �ε����� ����.)
		for(int idx =0; idx < arr.length; idx++) {
			System.out.printf("arr[%d]=%d \n",idx ,arr[idx]);
		}

	}
}
