package com.tj.loof;
//1+2+3+4+5+6+7+8+9+10 = ?
public class ForEx02 {

	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i <= 10; i++) { //1~10
			total += i; // total = total + i;
			if(i != 10) {
				System.out.print(i+"+");
			} else {
				System.out.print(i+"=");
			}
		}
		System.out.println(total);
	}

}
