package com.tj.ex03sawon;
//

import java.text.SimpleDateFormat;

//데이터 : 사번, 이름, 부서(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), 입사일.
//생성자 : 사번, 이름, 부서, 입사일은 객체생성 당일로 합니다
// 메소드 : print() :[사번]200121  [이름]홍길동  [부서]COMPUTER  [입사일]2016년2월2일

import java.util.Date;
import java.util.TimeZone;

public class Sawon2 {
//	public static final String COMPUTER = "COMPUTER";
//	public static final String PLANNING = "PLANNING";
//	public static final String DESING = "DESING";
//	public static final String ACCOUNTING = "ACCOUNTING";
//	public static final String HUMANRESOURCES = "HUMANRESOURCES";
	
	private String num; // 사번
	private String name; // 이름
	private PartType part; // 부서 enum : 열거타입
	private Date enterDate; // 입사일

	//생성자
	public Sawon2() {}

	public Sawon2(String num, String name, PartType part) { // 특정 타입을 강제할때 쓰는 : Enum
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date(); // 객체 생성시 시간을 시스템에서 생성해서 입력.
	}
	
	// 메소드
	public void print() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println("[사번] : " + num + " [이름] : " + name + " [부서] : " + part + " [입사일] : " + sdf.format(enterDate));
	}
	
	public String toStr() {
		String resulte = "[사번] : " + num + " [이름] : " + name + " [부서] : " + part;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		resulte += " [입사일] : " + sdf.format(enterDate);
		
		return resulte;
	} // 문자 반환
	
	// getter setter
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PartType getPart() {
		return part;
	}

	public void setPart(PartType part) {
		this.part = part;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
}
