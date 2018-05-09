package com.tj.ex6supermarket;

public class MarketMain {

	private static Goods[] g = { 
			new Goods("a01", "새우깡", 10, 1200), 
			new Goods("a02", "우유", 10, 1000),
			new Goods("a03", "캔커피", 10, 2000), 
			new Goods("a04", "세제", 10, 3000), 
			new Goods("a05", "휴지", 10, 4000) 
			};

	private static Customer[] c = { 
			new Customer("010-9999-9999", "홍길동", "04-10"),
			new Customer("010-8888-8888", "김말동", "04-12"), 
			new Customer("010-7777-7777", "이화여", "01-12"),
			new Customer("010-6666-6666", "세종대", "01-06"), 
			new Customer("010-5555-5555", "로사거", "04-12") 
			};

	public static void main(String[] args) {

		for (Customer ct : c) {
			System.out.println(ct);
		}
		System.out.println("-------------------------------------");
		for (Goods gt : g) {
			System.out.println(gt);
		}

		c[4].changeTel("010-9090-9090");

		sell("a01", "9999", 2);
		sell("a02", "8888", 5);// 생일인자 구매한 경우

		System.out.println("슈퍼마켓을 이용해주셔서 감사합니다.");

		for (Customer ct : c) {
			System.out.println(ct);
		}
		System.out.println("-------------------------------------");
		for (Goods gt : g) {
			System.out.println(gt);
		}

	}

	private static void sell(String gCode, String subTel, int su) {

		int i, gIndex, cIndex, changedStock;

		for (i = 0; i < g.length; i++) {
			if (g[i].getgCode().equals(gCode)) { // 구매시 입력값과 생성한 상품과 같은 코드 상품이 있는지 확인.
				break; // 있다면 인덱스를 안고 반복문 탈출
			} // if
		} // for

		if (i == g.length) { // 인덱스 길이까지 반복문이 되어 빠져나왔다는 것은 인덱스에 동일한 값이 없다는 것.
			System.out.println("상품코드가 잘못되어 구매가 불가능 합니다.");
			return;
		}

		gIndex = i; // 구매할 상품의 인덱스를 얻어온다.

		for (i = 0; i < c.length; i++) {
			String tel = c[i].getTel();
			String postTel = tel.substring(tel.lastIndexOf("-") + 1); // 마지막 - 의 1더한 인덱스 (연락처의 뒷부분)
			if (subTel.equals(postTel)) {
				break; // 입력한 연락처와 같은 값이 고객 연락처 인덱스에 있다면 true
			}
		} // for

		if (i == c.length) {// 인덱스 길이까지 반복문이 되어 빠져나왔다는 것은 인덱스에 동일한 값이 없다는 것.
			System.out.println("고객리스트에 없는 전화번호입니다. 회원가입후 구매해주세요.");
			return;
		} // if

		cIndex = i; // 구매고객의 인덱스를 얻어온다.

		try {
			changedStock = g[gIndex].stockCheck(su);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 예외 처리 출력을 정의한 메세지를 가져온다.
			return;
		}

		g[gIndex].setStock(changedStock); // 재고 수량을 구매후 바뀐 수량으로 바꾼다.
		String gName = g[gIndex].getgName();
		int price = g[gIndex].getPrice();

		try {
			c[cIndex].buy(gName, price, su);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 예외 처리 출력을 정의한 메세지를 가져온다.
		}

	}

}
