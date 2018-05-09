package com.tj.ex6supermarket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private String tel;
	private String cName;
	private int money;
	private int point;
	private String birth;
	private boolean vip; // false

	public Customer() {
	}

	public Customer(String tel, String cName, String birth) {
		this.tel = tel;
		this.cName = cName;
		this.birth = birth;
		money = 0;
		point = 1000;
		vip = false;
	}

	public void changeTel(String tel) {
		System.out.println(cName+"�� ���� ����ó�� " + this.tel + "�Դϴ�.");
		this.tel = tel;
		System.out.println("����ó�� �����մϴ�.");
		System.out.println(cName+"�� ����� ����ó�� " + this.tel + "�Դϴ�.");
	}

	public void buy(String gName, int price, int su) throws Exception {
		if (price < 0) {
			throw new Exception("���� �ݾ��� �����Դϴ�. (����)");
		}

		money += price * su; // ���űݾ׿� ����
		int thisPoint = (int) (price * su * 0.1); // ����Ʈ ���
		thisPoint += msgBirth(); // ���� �������� üũ�ؼ� �����̸� �߰� ����Ʈ�� ���ϸ޼���.
		point += thisPoint; // �������Ʈ�� ����Ʈ�� ����

		System.out.println(gName + " " + su + "��" + " * " + price + "��" + " [�� ���űݾ�] : " + (price * su));
		System.out.println("�ݹ� ���� ����Ʈ " + thisPoint);
		System.out.println(cName + "�� ���� ����Ʈ " + point);

		if (money >= 1000000 && vip == false) {
			vip = true;
			System.out.println("VIP �������� ����Ǽ̽��ϴ�. �����մϴ�.");
		}
		System.out.println("�� �� �ڰ����մϴ�.�� �� ��");
	}

	private int msgBirth() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);

		if (birth.equals(today)) {
			System.out.println(cName + "���� ���� ���ϵ帳�ϴ�. �߰� ����Ʈ 3000��");
			return 3000;
		}

		System.out.println("�ڡڡڱ��� �����մϴ�.�ڡڡ�");
		return 0;
	}

	@Override
	public String toString() {
		String resulte;

		resulte = "[����ó] : " + tel + " [����] : " + cName + " [���Ŵ����ݾ�] : " + money + " [����Ʈ] : " + point;
		resulte += " [�����] : " + birth;
		String level;
		if (vip == false) {
			level = "�Ϲݰ�";
		} else {
			level = "VIP";
		}
		resulte += " [�����]" + level;

		return resulte;
	}

	// setter getter

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

}
