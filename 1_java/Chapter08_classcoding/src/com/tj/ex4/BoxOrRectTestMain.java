package com.tj.ex4;

public class BoxOrRectTestMain {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 4, 3); // 박스 객체
		BoxOrRect rect = new BoxOrRect(10, 5); // 사각형 객체
		
		
		System.out.println("box 의 가로는 : " + box.getWidth());
		System.out.println("box 의 세로는 : " + box.getHeight());
		System.out.println("box 의 깊이는 : " + box.getDepth());
		System.out.println("box 의 부피는 : " + box.calVolum());
		
		System.out.println();
		
		System.out.println("rect 의 가로는 : " + rect.getWidth());
		System.out.println("rect 의 세로는 : " + rect.getHeight());
		System.out.println("rect 의 넓비는 : " + rect.calVolum());

	}

}
