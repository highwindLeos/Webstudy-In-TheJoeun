package com.tj.ex03sawon;

public class Main {

	public static void main(String[] args) {
		Sawon sawon1 = new Sawon("a001", "��浿", Sawon.COMPUTER);
		Sawon sawon2 = new Sawon("a002", "ȫ�浿", Sawon.COMPUTER);
		Sawon sawon3 = new Sawon("a003", "�̸���", Sawon.HUMANRESOURCES);
		
		sawon1.print();
		System.out.println(sawon1.toStr());
		System.out.println(sawon2.toStr());
		System.out.println(sawon3.toStr());
	}

}
