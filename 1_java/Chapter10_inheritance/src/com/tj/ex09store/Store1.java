package com.tj.ex09store;

// 매장 1호 클래스
public class Store1 extends HeadQuarterStore{
	
	@Override
	public void kimchi() {
		System.out.println("김치 찌개 : 4,500원 입니다.");
	}
	
	@Override
	public void bude() {
		System.out.println("부대 찌개 : 5,000원 입니다.");
	}
	
	@Override
	public void sunde() {
		System.out.println("순대국 : 취급하지 않습니다.");
	}
	
}
