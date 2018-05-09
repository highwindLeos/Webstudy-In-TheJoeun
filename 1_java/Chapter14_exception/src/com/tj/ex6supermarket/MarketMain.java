package com.tj.ex6supermarket;

public class MarketMain {

	private static Goods[] g = { 
			new Goods("a01", "�����", 10, 1200), 
			new Goods("a02", "����", 10, 1000),
			new Goods("a03", "ĵĿ��", 10, 2000), 
			new Goods("a04", "����", 10, 3000), 
			new Goods("a05", "����", 10, 4000) 
			};

	private static Customer[] c = { 
			new Customer("010-9999-9999", "ȫ�浿", "04-10"),
			new Customer("010-8888-8888", "�踻��", "04-12"), 
			new Customer("010-7777-7777", "��ȭ��", "01-12"),
			new Customer("010-6666-6666", "������", "01-06"), 
			new Customer("010-5555-5555", "�λ��", "04-12") 
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
		sell("a02", "8888", 5);// �������� ������ ���

		System.out.println("���۸����� �̿����ּż� �����մϴ�.");

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
			if (g[i].getgCode().equals(gCode)) { // ���Ž� �Է°��� ������ ��ǰ�� ���� �ڵ� ��ǰ�� �ִ��� Ȯ��.
				break; // �ִٸ� �ε����� �Ȱ� �ݺ��� Ż��
			} // if
		} // for

		if (i == g.length) { // �ε��� ���̱��� �ݺ����� �Ǿ� �������Դٴ� ���� �ε����� ������ ���� ���ٴ� ��.
			System.out.println("��ǰ�ڵ尡 �߸��Ǿ� ���Ű� �Ұ��� �մϴ�.");
			return;
		}

		gIndex = i; // ������ ��ǰ�� �ε����� ���´�.

		for (i = 0; i < c.length; i++) {
			String tel = c[i].getTel();
			String postTel = tel.substring(tel.lastIndexOf("-") + 1); // ������ - �� 1���� �ε��� (����ó�� �޺κ�)
			if (subTel.equals(postTel)) {
				break; // �Է��� ����ó�� ���� ���� �� ����ó �ε����� �ִٸ� true
			}
		} // for

		if (i == c.length) {// �ε��� ���̱��� �ݺ����� �Ǿ� �������Դٴ� ���� �ε����� ������ ���� ���ٴ� ��.
			System.out.println("������Ʈ�� ���� ��ȭ��ȣ�Դϴ�. ȸ�������� �������ּ���.");
			return;
		} // if

		cIndex = i; // ���Ű��� �ε����� ���´�.

		try {
			changedStock = g[gIndex].stockCheck(su);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // ���� ó�� ����� ������ �޼����� �����´�.
			return;
		}

		g[gIndex].setStock(changedStock); // ��� ������ ������ �ٲ� �������� �ٲ۴�.
		String gName = g[gIndex].getgName();
		int price = g[gIndex].getPrice();

		try {
			c[cIndex].buy(gName, price, su);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // ���� ó�� ����� ������ �޼����� �����´�.
		}

	}

}
