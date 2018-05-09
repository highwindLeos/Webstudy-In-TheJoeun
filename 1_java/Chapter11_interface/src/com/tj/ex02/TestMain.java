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

		IFunction[] phones = { a, b, c }; // 부모의 형으로 배열을 생성해서 각 객체를 넣는다.
		
		for (IFunction phTemp : phones) {
			System.out.println("==================================");
			phTemp.dmbRecive();
			phTemp.lte();
			phTemp.tvremoteControl();
			System.out.println("==================================");
		}
		
		for (int i = 0; i < phones.length; i++) {
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			phones[i].dmbRecive();
			phones[i].lte();
			phones[i].tvremoteControl();
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		}
	}

}
