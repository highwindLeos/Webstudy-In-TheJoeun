package com.tj.ex03sawon;

public class Main2 {

	public static void main(String[] args) {
		
		Sawon2 sawon1 = new Sawon2("a001", "��浿", PartType.COMPUTER);
		Sawon2 sawon2 = new Sawon2("a002", "ȫ�浿", PartType.COMPUTER);
		Sawon2 sawon3 = new Sawon2("a003", "�̸���", PartType.HUMANRESOURCES);
		Sawon2 sawon4 = new Sawon2("a004", "������", PartType.DESING);
		Sawon2 sawon5 = new Sawon2("a005", "���μ�", PartType.ACCOUNTING);
		Sawon2 sawon6 = new Sawon2("a006", "���ڻ�", PartType.COMPUTER);

		Sawon2[] sawons = { sawon1, sawon2, sawon3, sawon4, sawon5, sawon6 };
		
		for(Sawon2 st : sawons) {
			System.out.println(st.toStr());
		}

//		sawon1.print();
//		System.out.println(sawon1.toStr());
//		System.out.println(sawon2.toStr());
//		System.out.println(sawon3.toStr());
	}

}
