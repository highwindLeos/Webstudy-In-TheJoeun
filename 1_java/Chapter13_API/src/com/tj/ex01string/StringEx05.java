package com.tj.ex01string;

public class StringEx05 {
	public static void main(String[] args) {
		// 2002 ������
		System.out.println("������ " +2+0+0+2);
		// 2002 ������
		System.out.println(""+2+0+0+2+"������");
		
		String str1 = "������";
		String str2 = "������";
		String str3 = new String("������");
		String str4 = new String("������");
		System.out.println("str1 == str2 ? " + (str1 == str2)); // true
		System.out.println("str1 == str3 ? " + (str1 == str3)); // false
		System.out.println("str3 == str2 ? " + (str3 == str4)); // false
		
		/*System.out.println("str1 �� hashcode " + str1.hashCode());
		System.out.println("str2 �� hashcode " + str2.hashCode());*/
		System.out.println("str1 == str2 ? "+(str1 == str2));
		System.out.println("str3 �� ������ hashcode "+ str3.hashCode());
		
		str1 = "������ 2002"; // ���� �ٲ�.
		
		System.out.println("str1 ������ ��");
		// �ּҰ� �޶���.
		System.out.println("str1 == str2 ? " + (str1 == str2));
		System.out.println("str1 �� hashcode " + str1.hashCode());
		System.out.println("str2 �� hashcode " + str2.hashCode());
		System.out.println("str3 �� hashcode " + str3.hashCode());
		
		str3 = "������ 2002";
		
		System.out.println("str3 �� ������ hashcode " + str3.hashCode());

	}

}
