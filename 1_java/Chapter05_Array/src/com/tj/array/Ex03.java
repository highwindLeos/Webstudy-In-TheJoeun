package com.tj.array;

public class Ex03 {
	public static void main(String[] args) {
		// 3. �迭 ����� ���� Ȯ���� �ʱ�ȭ�� ������
		int[] arr; // �迭 ������ ����.
//		arr[0] =100; //���� Ȯ���� �ȵǾ ������ ���� ���� �ʴ´�.
		
		arr = new int[3]; // �迭 ���� Ȯ��
		arr[0] = 100; arr[1] = 200; arr[2] = 300; //���� �Ҵ�
		
		for (int a : arr) {
			System.out.print(a + "\t");
		}
		
	}

}
