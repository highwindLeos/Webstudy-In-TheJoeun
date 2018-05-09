package com.tj.ex5stack;

import java.util.Stack;

public class EXStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		String[] asia = {"���ѹα�","�߱�","�Ϻ�","���Ű��ź","�ε�"};
		
		for (String st : asia) {
			stack.push(st); // ������ �ֱ�.
		}
				
//		for (int i = 0; i < asia.length; i++ ) {
//			System.out.println(stack);
//		}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop()); // ������ ���ױ�.
			System.out.println(stack.size());
		}

	}

}
