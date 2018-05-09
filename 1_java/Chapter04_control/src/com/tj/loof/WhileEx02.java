package com.tj.loof;

public class WhileEx02 {

	public static void main(String[] args) {
		
		for(int i = 10; i >= 1; i--) {
			System.out.print("for¹®"+i+" ");
		}
		
		System.out.println();
		
		int i = 10;
		while (i >= 1) {
			if(i != 1) {
				System.out.print(i+", ");
			} else {
				System.out.println(i);
			}
			i--;
		}
	}
}
