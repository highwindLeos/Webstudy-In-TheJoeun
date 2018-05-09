package com.tj.ex09store;

public class StoreMain {

	public static void main(String[] args) {
		
		HeadQuarterStore st = new HeadQuarterStore();
		System.out.println("본사 지침");
		st.kimchi(); st.bude(); st.bibim(); st.sunde(); st.gonggibob();
		System.out.println();
		
		System.out.println("1호점");
		HeadQuarterStore st1 = new Store1(); // 자식 클래스는 부모의 참조형을 가질수 있다 (동물은 생물이다. 라는 개념)
		
		System.out.println(st1.equals(st));
		
		st1.kimchi(); st1.bude(); st1.bibim(); st1.sunde(); st1.gonggibob();
		System.out.println();
		
		System.out.println("2호점");
		HeadQuarterStore st2 = new Store2();
		st2.kimchi(); st2.bude(); st2.bibim(); st2.sunde(); st2.gonggibob();
		System.out.println();
		
		System.out.println("3호점");
		HeadQuarterStore st3 = new Store3();
		st3.kimchi(); st3.bude(); st3.bibim(); st3.sunde(); st3.gonggibob();
		System.out.println();
		
		HeadQuarterStore[] store = {st, st1, st2, st3};

		System.out.println("--- Store for ---");
		for (int i = 0; i < store.length; i++) {
			store[i].kimchi();
			store[i].bude();
			store[i].bibim();
			store[i].sunde();
			store[i].gonggibob();
			System.out.println();
		}
		
		System.out.println("--- Store Extended for ---");
		for(HeadQuarterStore stores : store) {
			stores.kimchi();
			stores.bude();
			stores.bibim();
			stores.sunde();
			stores.gonggibob();
			System.out.println();
		}

	}

}
