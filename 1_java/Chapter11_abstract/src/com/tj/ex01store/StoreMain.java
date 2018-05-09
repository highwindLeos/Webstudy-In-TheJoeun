package com.tj.ex01store;

public class StoreMain {

	public static void main(String[] args) {

		HeadQuarterStore st1 = new Store1(); // �ڽ� Ŭ������ �θ��� �������� ������ �ִ� (������ �����̴�. ��� ����)
		HeadQuarterStore st2 = new Store2();
		HeadQuarterStore st3 = new Store3();

		HeadQuarterStore[] store = { st1, st2, st3 };

		System.out.println("--- Store Extended for ---");
		for (HeadQuarterStore stores : store) {
			System.out.println("-------------" + stores.getName() + "-------------"); // HeadQuarterStore�� getName()�� ���⶧���� �������־�� ������ ����.
			stores.kimchi();
			stores.bude();
			stores.bibim();
			stores.sunde();
			stores.gonggibob();
			System.out.println();
		} // �� �ݺ����� ������ ����. Extended for

/*		 System.out.println("--- Store for ---");
		 for (int i = 0; i < store.length; i++) {
		 store[i].kimchi();
		 store[i].bude();
		 store[i].bibim();
		 store[i].sunde();
		 store[i].gonggibob();
		 System.out.println();
		 } // �� �ݺ����� ������ ����. */

	}//main

}//class
