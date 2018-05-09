package com.tj.ex13account;

public class CheakingAccount extends Account {
	private String cardNo;
	// new SheckingAccount("11-11", "ȫ�浿", 10, "1111-1111-1~")
	// new SheckingAccount("11-11", "ȫ�浿", 10, "1111-1111-1~")

	// ������
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
	
	// �޼ҵ�
	// ���ϰ��� ������ �ݾ� / �Ű����� amount : ������ �ϰ��� �ϴ� �ݾ�
	public int pay(String cardNo, int amount){
		int resulte = 0;
		// 
		if(this.cardNo.equals(cardNo)) { // ������ �����ʹ� equals() �� ���� ��.
			//ī���ȣ ������ �ܾ� ���ؼ� �����Ѵ�.
			if(getBalance() >= amount) {
				//balance = balance - amount
				setBalance(getBalance() - amount); // �θ� Ŭ������ �����͸� �����Ҷ�.
				System.out.println(getOwnerName()+"���� "+amount+"�����Ͽ� �ܾ� "+getBalance());
				resulte = amount;
			}else {
				System.out.println("ī�� �ܾ��� �����մϴ�.");
			}
		}else {
			System.out.println("ī���ȣ�� Ʋ���ϴ�");
		}
		return resulte;
	}
	
	@Override
	public void printAccount() {
		System.out.print("[���¹�ȣ] : " + getAccountNo());
		System.out.print("\t[������] : " + getOwnerName());
		System.out.print("\t[��  ��] : " + getBalance());
		System.out.println("\t[ī���ȣ] : " + cardNo);
	}
	
	// getter setter
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	

	
	
}
