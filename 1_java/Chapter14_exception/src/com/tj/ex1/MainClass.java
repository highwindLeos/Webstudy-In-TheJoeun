package com.tj.ex1;

public class MainClass {

	public static void main(String[] args){
		
			try {
				ThrowEx ex = new ThrowEx();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println("프로그램은 종료되지 않는다.");
	}

}