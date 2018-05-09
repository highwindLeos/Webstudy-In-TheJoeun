package com.tj.ex05tostring;

public class MarketMain {

	private static Customer[] cs = { 
									new Customer("010-0000-9999", "홍길동", "04-12"),
									new Customer("010-0000-8888", "김길순", "01-01"), 
									new Customer("010-0000-7777", "박지순", "04-01") 
									};

	private static Goods[] gs = { 
								  new Goods("a01", "새우깡", 10, 1200), 
								  new Goods("a02", "초코우유", 10, 900),
								  new Goods("a03", "양파링", 10, 1100) 
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
