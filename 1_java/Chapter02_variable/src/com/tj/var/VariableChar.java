package com.tj.var;

public class VariableChar { // char ������ ���� �� ������ ���ڸ� �����Ѵ�.

	public static void main(String[] args) {
		char c1 = 'A'; // ���ڸ� ���� ����
		char c2 = 65; // �ش� ���� 10���� �����ڵ带 �����Ѵ�.
		char c3 = '\u0041'; // �ش� 16���� �����ڵ带 �����Ѵ�.
		
		char c4 = '��';
		char c5 = 44032;
		char c6 = '\uac00';
		
		int unicode = c1; //�����ڵ带 ��´�.
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(unicode);
		
	}

}
