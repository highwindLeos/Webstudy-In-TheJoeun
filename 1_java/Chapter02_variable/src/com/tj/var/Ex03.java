package com.tj.var;

public class Ex03 {

	public static void main(String[] args) {
		float f; // 4 byte �޸� ������ ��� �̸��� �Ǽ� �ָӴϿ� �ִ�.
		f = 10.1F; // �Ǽ�����  float F �� f �� �ٿ��� �־���Ѵ�.
		
		int i; // 4byte �޸� ������ i��� �̸��� ���� �ָӴϿ� �ִ�.
		i = 10; 
		
		System.out.println(i);
		
		long l; //8byte �޸� ������ l �̶�� ������ ū���� �ָӴϿ� �ִ�.
		l = 2200000000l;
		
		f = (float)10.0000017; // double ���� float ���� ������ ���� ��ȯ�Ѵ�.
		double d = 10.0000017;
		System.out.println("f = " + f + "\t d = " +d);
		
		if (f == d) { // 4����Ʈ�� ���� ���� 8����Ʈ�� ���� ���� �ٸ����̴�. false.
			System.out.println("f�� d �� ����.");
		} else  {
			System.out.println("f�� d �� �ٸ���.");
		}
	}

}
