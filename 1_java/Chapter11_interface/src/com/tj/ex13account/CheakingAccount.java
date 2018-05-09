package com.tj.ex13account;

public class CheakingAccount extends Account {
	private String cardNo;
	// new SheckingAccount("11-11", "홍길동", 10, "1111-1111-1~")
	// new SheckingAccount("11-11", "홍길동", 10, "1111-1111-1~")

	// 생성자
	public CheakingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		/*setAccountNo(accountNo);
		setOwnerName(ownerName);
		setBalance(balance);*/
		super(accountNo,ownerName,balance);
		this.cardNo = cardNo;
	}
	
	public CheakingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo,ownerName);
		this.cardNo = cardNo;
	}
	
	// 메소드
	// 리턴값은 결제된 금액 / 매개변수 amount : 결제를 하고자 하는 금액
	public int pay(String cardNo, int amount){
		int resulte = 0;
		// 
		if(this.cardNo.equals(cardNo)) { // 참조형 데이터는 equals() 로 값을 비교.
			//카드번호 맞으면 잔액 비교해서 결제한다.
			if(getBalance() >= amount) {
				//balance = balance - amount
				setBalance(getBalance() - amount); // 부모 클래스의 데이터를 연산할때.
				System.out.println(getOwnerName()+"계좌 "+amount+"결제하여 잔액 "+getBalance());
				resulte = amount;
			}else {
				System.out.println("카드 잔액이 부족합니다.");
			}
		}else {
			System.out.println("카드번호가 틀립니다");
		}
		return resulte;
	}
	
	@Override
	public void printAccount() {
		System.out.print("[계좌번호] : " + getAccountNo());
		System.out.print("\t[예금주] : " + getOwnerName());
		System.out.print("\t[잔  액] : " + getBalance());
		System.out.println("\t[카드번호] : " + cardNo);
	}
	
	// getter setter
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	

	
	
}
