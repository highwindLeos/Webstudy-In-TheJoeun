package com.tj.ex4;

public class BoxOrRectTestMain {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 4, 3); // �ڽ� ��ü
		BoxOrRect rect = new BoxOrRect(10, 5); // �簢�� ��ü
		
		
		System.out.println("box �� ���δ� : " + box.getWidth());
		System.out.println("box �� ���δ� : " + box.getHeight());
		System.out.println("box �� ���̴� : " + box.getDepth());
		System.out.println("box �� ���Ǵ� : " + box.calVolum());
		
		System.out.println();
		
		System.out.println("rect �� ���δ� : " + rect.getWidth());
		System.out.println("rect �� ���δ� : " + rect.getHeight());
		System.out.println("rect �� �к�� : " + rect.calVolum());

	}

}
