package com.tj.ex04access.test;

import com.tj.ex04access.Woman;

public class WomanTestMain {

	public static void main(String[] args) {
		Woman w = new Woman();
		
		// w.privateMethod(); ������ ����. private �Լ��̱� ����. (������ ����)
		
		// w.defaultMethod(); // package �� �ٸ��⶧���� ������ ����. (������ �ȵ�)
				
		// w.protectedMethod(); // package �� �ٸ��⶧���� ������ ����. (������ �ȵ�)
				
		w.publicMethod(); 

	}

}
