package com.tj.ex05market;

public class Vvip extends Customer {
	private String birth; // �����

	public Vvip(String name, String phoneNum) {
		super(name, phoneNum); // �θ����� �Ű����� 2�� ���� �ִ� ������.
	}

	public Vvip(String name, String phoneNum, String birth) {// 3�� ���� �ִ� ������.
		super(name, phoneNum); // �θ����� �Ű����� 2�� ���� �ִ� ������.
		this.birth = birth;
	}

	public void sendMeassage() {
		System.out.println("VVIP " + getName() + " ȸ������ ������ ���� �մϴ�.");
		System.out.println("������ �� " + birth + " �̳׿�.");
	} // ����� ��� �޼ҵ�

	@Override
	public String outString() {
		return super.outString()+ "\n����� : "+ birth;
	} // ����� ���� ���ؼ� ����ϴ� �Լ��� �θ��Լ��� ����Ἥ ����.
	
	// getter setter
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}
