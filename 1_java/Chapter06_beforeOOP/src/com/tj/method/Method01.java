package com.tj.method;

public class Method01 {
	public static void main(String[] args) {
		printCh('��',45);
		System.out.println("Hellow Java");
		printCh();
		System.out.println("Hellow Java");
		printCh(15);
		System.out.println("Hellow Java");
		printCh('��');
	}
//	private static int printCh(char ch, int size) { 
//		
//	} 
	// �޼ҵ��� �������� �Ű������� ���еȴ�. (return type �δ� ���� �Ұ�)
	private static void printCh(char ch, int size) { // �Ű� ������ �ΰ� ����. ���ϰ� ����.
		for (int i =0; i < size; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	
	private static void printCh() { // �Ű����� ����. return �� ����.
		System.out.println("---------------------------------------------");
	} 
	
	private static void printCh(char ch) { // �Ű����� 1�� ����. return �� ����.
		for (int i = 0; i< 45 ; i++) { System.out.print(ch); }
		System.out.println();
	} 
	private static void printCh(int size) {
		for (int i = 0; i <size; i++) {
			System.out.print("-0-");
		}
		System.out.println();
	}
	// ���� �޼ҵ���� overloading �Ǿ��� (������) = ���� �̸��� �Լ��̳� �ٸ��� �����Ѵ�.
}
