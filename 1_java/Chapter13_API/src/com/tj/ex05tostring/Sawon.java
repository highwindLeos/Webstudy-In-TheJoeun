package com.tj.ex05tostring;

import java.text.SimpleDateFormat;

//데이터 : 사번, 이름, 부서(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), 입사일.
//생성자 : 사번, 이름, 부서, 입사일은 객체생성 당일로 합니다
// 메소드 : print() :[사번]200121  [이름]홍길동  [부서]COMPUTER  [입사일]2016년2월2일

import java.util.Date;
import java.util.TimeZone;

public class Sawon {
	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESING = "DESING";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";

	private String num; // 사번
	private String name; // 이름
	private String part; // 부서
	private Date enterDate; // 입사일

	// 생성자
	public Sawon() {}

	public Sawon(String num, String name, String part) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date();
	}

	// 메소드
//	public void print() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//		System.out
//				.println("[사번] : " + num + " [이름] : " + name + " [부서] : " + part + " [입사일] : " + sdf.format(enterDate));
//	} 이런 코드는 사용하지 않기로 한다.

	public String toStr() {
		String resulte = "[사번] : " + num + " [이름] : " + name + " [부서] : " + part;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		resulte += " [입사일] : " + sdf.format(enterDate);

		return resulte;
	} // 문자 반환
	
	@Override
	public String toString() { // Object 의 toString() 을 재정의.
		String resulte = "[사번] : " + num + " [이름] : " + name + " [부서] : " + part;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		resulte += " [입사일] : " + sdf.format(enterDate);

		return resulte;
	}

	
}