package com.tj.ex1;

public class ThrowEx {

	public ThrowEx() throws Exception {
		actionC();
	}

	private void actionC() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}

	private void actionB() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB ���ݺ�");
		actionA();		
		System.out.println("actionB ���ݺ�");

	}

	private void actionA() throws ArrayIndexOutOfBoundsException { // ���ܸ� �� �޼ҵ忡�� ó���Ѵ�.
		System.out.println("actionA ���ݺ�");
		int[] iArr = { 0, 1, 2 };
		System.out.println("�ε��� 4 ��" + iArr[4]);
//		try {
//			System.out.println("�ε��� 4 ��" + iArr[4]);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("actionA �Ĺݺ�");
	}

}
