package com.tj.TodayEx;

// �迭���� ���Ұ� ����.
public class TodayEx04 {

	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int[] sortArr = new int[arr.length];

		System.arraycopy(arr, 0, sortArr, 0, arr.length); // �迭 ���� (���� �ּҴ� �ٸ���)

		for (int i = 0; i < sortArr.length; i++) {
			for (int j = i + 1; j < sortArr.length; j++) {
				if (sortArr[i] > sortArr[j]) { // ù��° ���� �ι�° ���� ���ؼ� ù��° ���� ũ�ٸ�.
					// ��ȣ�� �ٲٸ� ���� ���� ������ �ȴ�.

					int temp = sortArr[i]; // �ӽ� ������ ����� ù��° ���� ����.
					sortArr[i] = sortArr[j]; // �ι�° ���� ù��° ���� �ȱ�.
					sortArr[j] = temp; // �ӽ� ���� �ι�° ������ ����.

				}
			} // for-j
		} // for-i
		for (int a : arr) {
			System.out.print(a + "\t");
		}
		System.out.println("\n ���� ��");
		for (int a : sortArr) {
			System.out.print(a + "\t");
		}

	}

}
