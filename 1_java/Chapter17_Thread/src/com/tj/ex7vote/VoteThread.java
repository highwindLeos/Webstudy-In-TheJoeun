package com.tj.ex7vote;

import java.util.Random;

public class VoteThread extends Thread {
	private final int TARGETRATE = 100; // 100%
	
	private int voteRate; // 투표율
	private Random random; // 투표증가율 난수 발생.
	
	public VoteThread(String name) {
		super(name); // 스레드이름
		random = new Random();
	}
	
	@Override
	public void run() {
		StringBuilder bar = new StringBuilder(); // 문자열을 하나 선언.
		while(true) {
			// voteRate 를 random 으로  증가시키면서 * 그래프로 출력하고 100% 면 중지한다.
			voteRate += random.nextInt(20); // 0~20
			bar.delete(0, bar.toString().length()); // 변수내용을 모두 지음
			
			if(voteRate >= TARGETRATE) {
				voteRate = TARGETRATE;
				for (int i = 0; i< voteRate; i++) {
					bar.append("*"); // 그래프를 voteRate 만큼 * 만들기
				}
				
			System.out.println(Thread.currentThread().getName() + "의 개표율 (" + voteRate + "%)\t" + bar);
			break; // 개표율이 100이면 while 문 탈출.
			} else {
				for(int i = 0; i< voteRate; i++) {
					bar.append("*"); // 그래프를 voteRate 만큼 *로 만듬.
				}
				
			System.out.println(Thread.currentThread().getName() + "의 개표율 (" + voteRate + "%)\t" + bar);
			
			} // if
			
			try {
				Thread.sleep(300); // 프로세스 0.3초 중지.
			} catch (InterruptedException e) {}
			
		}// while
	}// run();
}// class
