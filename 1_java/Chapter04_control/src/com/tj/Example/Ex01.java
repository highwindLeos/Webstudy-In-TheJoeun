package com.tj.Example;

// 1~20  ���� �����߿��� 2 �Ǵ� 3�� ����� �ƴѼ��� ��. ��� 73
// if((i % 2) != 0 && (i %3) != 0);
public class Ex01 {

	public static void main(String[] args) {
		int num = 0;

		for (int i = 0; i <= 20; i++) { // 20���� ����.
			if ((i % 2) != 0 && (i % 3) != 0) { // ����� �������� 0�� �ƴѰ�.(���)
				num += i;
			}
		}
		System.out.println(num);
	}

}
