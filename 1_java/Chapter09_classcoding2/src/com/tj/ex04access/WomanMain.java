package com.tj.ex04access;

public class WomanMain {

	public static void main(String[] args) {
		Woman w = new Woman();
		
		// w.privateMethod(); ������ ����. private �Լ��̱� ����. (������ ����) : ���� Ŭ���� �ȿ����� ������ ����.
		
		w.defaultMethod(); // ���� ��Ű�� �ʿ� ������ �ٸ� class �� �־ ������ �ȴ�.
		
		w.protectedMethod(); // ���� ��Ű�� �ʿ� ������ �ٸ� class �� �־ ������ �ȴ�.
		 
		w.publicMethod();

	}

}
