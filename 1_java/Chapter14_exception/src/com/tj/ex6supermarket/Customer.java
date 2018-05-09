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
		System.out.println(cName+"님 현제 연락처는 " + this.tel + "입니다.");
		this.tel = tel;
		System.out.println("연락처를 변경합니다.");
		System.out.println(cName+"님 변경된 연락처는 " + this.tel + "입니다.");
	}

	public void buy(String gName, int price, int su) throws Exception {
		if (price < 0) {
			throw new Exception("구매 금액이 음수입니다. (예외)");
		}

		money += price * su; // 구매금액에 누적
		int thisPoint = (int) (price * su * 0.1); // 포인트 계산
		thisPoint += msgBirth(); // 고객이 생일인지 체크해서 생일이면 추가 포인트와 축하메세지.
		point += thisPoint; // 계산포인트를 포인트의 누적

		System.out.println(gName + " " + su + "개" + " * " + price + "원" + " [총 구매금액] : " + (price * su));
		System.out.println("금번 누적 포인트 " + thisPoint);
		System.out.println(cName + "총 누적 포인트 " + point);

		if (money >= 1000000 && vip == false) {
			vip = true;
			System.out.println("VIP 고객님으로 등업되셨습니다. 감사합니다.");
		}
		System.out.println("★ ★ ★감사합니다.★ ★ ★");
	}

	private int msgBirth() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);

		if (birth.equals(today)) {
			System.out.println(cName + "고객님 생일 축하드립니다. 추가 포인트 3000점");
			return 3000;
		}

		System.out.println("★★★구매 감사합니다.★★★");
		return 0;
	}

	@Override
	public String toString() {
		String resulte;

		resulte = "[연락처] : " + tel + " [고객명] : " + cName + " [구매누적금액] : " + money + " [포인트] : " + point;
		resulte += " [기념일] : " + birth;
		String level;
		if (vip == false) {
			level = "일반고객";
		} else {
			level = "VIP";
		}
		resulte += " [고객등급]" + level;

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
