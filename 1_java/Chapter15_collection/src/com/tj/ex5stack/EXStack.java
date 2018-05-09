package com.tj.ex5stack;

import java.util.Stack;

public class EXStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		String[] asia = {"대한민국","중국","일본","우즈베키스탄","인도"};
		
		for (String st : asia) {
			stack.push(st); // 데이터 넣기.
		}
				
//		for (int i = 0; i < asia.length; i++ ) {
//			System.out.println(stack);
//		}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop()); // 데이터 꺼네기.
			System.out.println(stack.size());
		}

	}

}
