package com.tj.ex05tostring;

public class MarketMain {

	private static Customer[] cs = { 
									new Customer("010-0000-9999", "ȫ�浿", "04-12"),
									new Customer("010-0000-8888", "����", "01-01"), 
									new Customer("010-0000-7777", "������", "04-01") 
									};

	private static Goods[] gs = { 
								  new Goods("a01", "�����", 10, 1200), 
								  new Goods("a02", "���ڿ���", 10, 900),
								  new Goods("a03", "���ĸ�", 10, 1100) 
								};
// 
	public static void main(String[] args) {

		for (Customer ctemp : cs) {
			System.out.println(ctemp);
		}
		
		System.out.println();
		
		for (Goods gtemp : gs) {
			System.out.println(gtemp);
		}

	} // main()

}
