package com.tj.ex5booklib;

import java.util.Scanner;

public interface ILendable {
	byte STATE_BORROWED = 1; // �������
	byte STATE_NOMAL = 0; // ���Ⱑ�ɻ��� 
	
	public void checkOut(String borrower) throws Exception; // ����
	public void checkIn(Scanner sc) throws Exception; // �ݳ�
}
