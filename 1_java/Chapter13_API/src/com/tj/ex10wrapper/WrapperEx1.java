package com.tj.ex10wrapper;

public class WrapperEx1 {
	
	public static void main(String[] args) {
		int i = 10;
		// Integer iobj = 10; �̷� ������ ���� ���� ���� �ִ�. (String �� ���)
		Integer iobj = new Integer(10); // ��ü ����.
		Integer jobj = new Integer(20); // ��ü ����.
		
		System.out.println("iObj ���� ���� "+ iobj); // toString() �� �����Ǿ��ִ�.
		System.out.println("jObj ���� ���� "+ jobj.intValue());
		
		// �ڿ� �ִ� ���ϱ⸦ �����ؾ� ���� ������ ���ڿ��� ���� ���ڿ��̵ȴ�.
		System.out.println("���� "+ (iobj + jobj)); 
		
		String str = "hellow";
		System.out.println(str.equals(new Integer(10))); // 10 �� �Է°����� �־ ���� ���� �ȴ�.
		System.out.println(str.equals(10)); // ���� ����� ����.

	}
	
}
