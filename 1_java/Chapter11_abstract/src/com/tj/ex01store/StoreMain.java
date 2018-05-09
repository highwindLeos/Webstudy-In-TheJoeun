package com.tj.ex01store;

public class StoreMain {

	public static void main(String[] args) {

		HeadQuarterStore st1 = new Store1(); // 자식 클래스는 부모의 참조형을 가질수 있다 (동물은 생물이다. 라는 개념)
		HeadQuarterStore st2 = new Store2();
		HeadQuarterStore st3 = new Store3();

		HeadQuarterStore[] store = { st1, st2, st3 };

		System.out.println("--- Store Extended for ---");
		for (HeadQuarterStore stores : store) {
			System.out.println("-------------" + stores.getName() + "-------------"); // HeadQuarterStore에 getName()이 없기때문에 정의해주어야 오류가 없다.
			stores.kimchi();
			stores.bude();
			stores.bibim();
			stores.sunde();
			stores.gonggibob();
			System.out.println();
		} // 두 반복문은 완전히 같다. Extended for

/*		 System.out.println("--- Store for ---");
		 for (int i = 0; i < store.length; i++) {
		 store[i].kimchi();
		 store[i].bude();
		 store[i].bibim();
		 store[i].sunde();
		 store[i].gonggibob();
		 System.out.println();
		 } // 두 반복문은 완전히 같다. */

	}//main

}//class
