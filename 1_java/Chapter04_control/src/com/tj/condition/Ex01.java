package com.tj.condition;

public class Ex01 {

	public static void main(String[] args) {
		int i = 10, j = 20, h=30;
		
		if(i > j) {
			System.out.println("i가 j보다 " + (i - j) + "크다");
		} else if( i < j ) { 
			System.out.println("j가 i보다 " + (j - i) +"크다");
		} else {
			System.out.println("i와 j는 같다.");
		}
		
		if((i + j) == h) {
			System.out.println("i + j 는 h와 같다");
		} else {
			System.out.println("i + j 는 다르다.");
		}
	}
}
