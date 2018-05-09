package com.tj.ex6atmcardn;

public class Account {
	private int balence; // �ܾ�.

	public Account(int balence) {
		this.balence = balence;
	}

	public synchronized void deposit(int amount, String who) { // �� �۾��� ��ĥ�� ���� �ٸ� �۾��� ���۵��� ����.
		System.out.println("��" + who + "�� �Աݽ���");
		balence += amount;
		System.out.println(who + "�� " + amount + "�Ա��Ͽ� �ܾ� " + balence);
		System.out.println("��--" + who + "�� �Ա� �Ϸ� --��");
	}
	
	public synchronized void whitdrow(int amount, String who) { // �� �۾��� ��ĥ�� ���� �ٸ� �۾��� ���۵��� ����.
		System.out.println("��" + who + "�� ��ݽ���");
		if (balence >= amount) {
			balence -= amount;
			System.out.println(who + "�� " + amount + "����Ͽ� �ܾ� " + balence);
		} else {
			System.out.println("�ܾ� : "+ balence + " �ܾ��� �����մϴ�.");
		}
		System.out.println("��--" + who + "�� ��� �Ϸ� --��");
	}

}
