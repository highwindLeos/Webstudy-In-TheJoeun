package com.tj.ex02;

public class TestMain {

	public static void main(String[] args) {
		/*
		 * AModle a = new AModle(); BModel b = new BModel(); CModel c = new CModel();
		 */

		IFunction a = new AModle();
		IFunction b = new BModel();
		IFunction c = new CModel();

		a.dmbRecive();	a.lte();	a.tvremoteControl();
		
		b.dmbRecive();	b.lte();	b.tvremoteControl();
		
		c.dmbRecive();	c.lte();	c.tvremoteControl();

		IFunction[] phones = { a, b, c }; // �θ��� ������ �迭�� �����ؼ� �� ��ü�� �ִ´�.
		
		for (IFunction phTemp : phones) {
			System.out.println("==================================");
			phTemp.dmbRecive();
			phTemp.lte();
			phTemp.tvremoteControl();
			System.out.println("==================================");
		}
		
		for (int i = 0; i < phones.length; i++) {
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
			phones[i].dmbRecive();
			phones[i].lte();
			phones[i].tvremoteControl();
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
		}
	}

}
