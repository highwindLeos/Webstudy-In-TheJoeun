package com.tj.var;

public class Ex05 {

	public static void main(String[] args) {

		int i1 = 10;
		long l1 = 22000000000L;
		
		// ����ȯ = 1. �������� ����ȯ 2. ����� ����ȯ.
		l1 = i1; // �ڹٰ� �˾Ƽ� 4����Ʈ �ڷḦ 8����Ʈ�� ��ȯ���ش�.
		
		double d1 = 10.91;
		i1 = (int)d1; //ū�ָӴ��� �����͸� ���� �ָӴϷ� ���� ��. (cascading)
		
		System.out.println("10.91�� int�� ����ȯ : " + i1);
		
	}

}
