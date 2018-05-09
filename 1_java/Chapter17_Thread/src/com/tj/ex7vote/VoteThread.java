package com.tj.ex7vote;

import java.util.Random;

public class VoteThread extends Thread {
	private final int TARGETRATE = 100; // 100%
	
	private int voteRate; // ��ǥ��
	private Random random; // ��ǥ������ ���� �߻�.
	
	public VoteThread(String name) {
		super(name); // �������̸�
		random = new Random();
	}
	
	@Override
	public void run() {
		StringBuilder bar = new StringBuilder(); // ���ڿ��� �ϳ� ����.
		while(true) {
			// voteRate �� random ����  ������Ű�鼭 * �׷����� ����ϰ� 100% �� �����Ѵ�.
			voteRate += random.nextInt(20); // 0~20
			bar.delete(0, bar.toString().length()); // ���������� ��� ����
			
			if(voteRate >= TARGETRATE) {
				voteRate = TARGETRATE;
				for (int i = 0; i< voteRate; i++) {
					bar.append("*"); // �׷����� voteRate ��ŭ * �����
				}
				
			System.out.println(Thread.currentThread().getName() + "�� ��ǥ�� (" + voteRate + "%)\t" + bar);
			break; // ��ǥ���� 100�̸� while �� Ż��.
			} else {
				for(int i = 0; i< voteRate; i++) {
					bar.append("*"); // �׷����� voteRate ��ŭ *�� ����.
				}
				
			System.out.println(Thread.currentThread().getName() + "�� ��ǥ�� (" + voteRate + "%)\t" + bar);
			
			} // if
			
			try {
				Thread.sleep(300); // ���μ��� 0.3�� ����.
			} catch (InterruptedException e) {}
			
		}// while
	}// run();
}// class
