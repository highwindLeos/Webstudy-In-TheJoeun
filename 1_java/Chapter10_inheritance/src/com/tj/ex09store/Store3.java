package com.tj.ex09store;
// 매장 3호
// 김치찌개 : 6000원 부대찌개 7000원 비빔밥 7000원 순대국 6000원
public class Store3 extends HeadQuarterStore {
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 6,000원 입니다.");
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 : 7,000원 입니다.");
	}
	
	@Override
	public void bibim() {
		System.out.println("비빔밥 : 7,000원 입니다.");
	}
	
	@Override
	public void sunde() {
		System.out.println("순대국 : 6,000원 입니다.");
	}
}
