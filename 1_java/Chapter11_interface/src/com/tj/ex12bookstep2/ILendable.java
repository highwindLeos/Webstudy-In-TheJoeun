package com.tj.ex12bookstep2;
// ���� ���� Ŭ������ �۾����� ��Ȱ
public interface ILendable {
	// �������̸� å�� ���¸� 1 ���� �����ϸ� ���¸� 0
	byte STATE_BORROWED = 1;
	byte STATE_NOMAL = 0;
	
	void checkOut(String borrower, String checkOutDate); // ���� �޼ҵ�
	
	void checkIn(); // �ݳ� �޼ҵ�
	
	void printState(); // ���� ��ȸ (������ ���� ����) �� ���
	
}
