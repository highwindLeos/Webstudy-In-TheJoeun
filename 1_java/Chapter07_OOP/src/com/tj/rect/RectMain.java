package com.tj.rect;

// 사각형의 가로 세로 너비를 구하는 프로그램.
public class RectMain {

	public static void main(String[] args) {

		Rect rect1 = new Rect();

		rect1.setWidth(10);
		rect1.setHeigth(5);

		System.out.println("사각형의 가로는 " + rect1.getWidth());
		System.out.println("사각형의 세로는 " + rect1.getHeight());
		System.out.println("사각형의 넓이는 " + rect1.area());
		System.out.println();
		
		Rect rect2 = new Rect(10,5);
		
		//rect2.setWidth(10);
		//rect2.setHeigth(5);

		System.out.println("사각형의 가로는 " + rect2.getWidth());
		System.out.println("사각형의 세로는 " + rect2.getHeight());
		System.out.println("사각형의 넓이는 " + rect2.area());
		System.out.println();

		int i = 10, j = 10;
		if (i == j)
			System.out.println("i 랑 j 가 같다.");
		if (rect1.equals(rect2)) // equals() 오브젝트가 같은지. 같으면 true 다르면 false
			System.out.println("rect1 랑 rect2 가 같다.");
		else
			System.out.println("rect1 랑 rect2 가 다르다.");
	}

}
