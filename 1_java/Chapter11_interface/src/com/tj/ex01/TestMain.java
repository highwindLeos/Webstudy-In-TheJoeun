package com.tj.ex01;

public class TestMain {

	public static void main(String[] args) {
		// interface �� �ν��Ͻ��� (��ü�� ����) �Ұ� (���� :�͸�Ŭ����)
		// InterfaceEx1 ex1 = new InterfaceEx1();
		InterfaceEx1 ifex1 = new ClassEx();
		InterfaceEx2 ifex2 = new ClassEx();
		ClassEx 	 cex   = new ClassEx();
		
		// new ClassEx() �ؼ� ��ü�� ����� ex1() ex2() ��� 2��
		cex.ex1(); cex.ex2();
		System.out.println("CONSTANT_NUM : " + InterfaceEx1.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : " + ClassEx.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : " + cex.CONSTANT_NUM);
		System.out.println("CONSTANT_STRING : " + InterfaceEx2.CONSTANT_STRING);
		System.out.println("CONSTANT_STRING : " + ClassEx.CONSTANT_STRING);
		System.out.println("CONSTANT_STRING : " + cex.CONSTANT_STRING);
		
		ifex1.ex1(); 
		/* ifex.ex2(); �̰��� �Ұ��� : ��ü���� ������ �������� ClassEX �� �ƴϱ� ������ */ 
		/* ifex2.ex1(); �̰��� �Ұ��� : ��ü���� ������ �������� ClassEX �� �ƴϱ� ������ */
		ifex2.ex2();
			
	}

}
