package com.tj.ex7vote;

public class VoteMain {

	public static void main(String[] args) {
		VoteThread location1 = new VoteThread("����1");
		VoteThread location2 = new VoteThread("����2");
		VoteThread location3 = new VoteThread("����3");
		
		location1.start();
		location2.start();
		location3.start();
	}

}
