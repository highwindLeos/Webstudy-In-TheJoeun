package com.tj.loof;

//*
//**
//***
//****
//*****
//******
//*******
public class ForEx04 {

	public static void main(String[] args) {
		for (int j = 1; j <= 5; j++) {
			for (int i = 0; i < j; i++) {
				System.out.print("*");
			} // for i end
			System.out.println();
		} // for j end
		// º°ÀÌ ²¨²Ù·Î.
		for (int j = 1; j <= 4; j++) {
			for (int i = j; i <= 4; i++) {
				System.out.print("*");
			}
			System.out.println();
		}//for j end
	} // main
}// class
