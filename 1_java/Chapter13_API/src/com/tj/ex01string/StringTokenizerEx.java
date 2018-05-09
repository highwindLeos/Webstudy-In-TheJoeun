package com.tj.ex01string;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		String str1 = "������ Ȳ���� ������ ������ ������";
		String str2 = "2017/12/25";
		// " " ���� token �� ������ ��ü ����
		StringTokenizer token1 = new StringTokenizer(str1);
		// "/" (�Ű������� �ԷµǴ� ���� ����) �� �������� token �� ������ ��ü ����
		StringTokenizer token2 = new StringTokenizer(str2, "/");
		System.out.println("token1 ���� : " + token1.countTokens());
		System.out.println("token2 ���� : " + token2.countTokens());

		while (token1.hasMoreTokens()) { // ��ū�� �ִ��� Ȯ��
			System.out.print(token1.nextToken() + "\t");
		}// nextToken() �޼ҵ�� �ѹ� ó���ϸ� �׻� ������ �����Ϳ� �ִ�. 
		
		System.out.println();
		
		while (token2.hasMoreTokens()) { // ��ū�� �ִ��� Ȯ��
			System.out.print(token2.nextToken() + "\t");
		}

//		for (int i = 0; i < token2.countTokens(); i++) {
//			System.out.print(token2.nextToken() + "\t");
//		} Token ������ ������� ����.
	}

}
