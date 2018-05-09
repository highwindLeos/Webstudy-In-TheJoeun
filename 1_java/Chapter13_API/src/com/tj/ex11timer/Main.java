package com.tj.ex11timer;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Ÿ�̸� �����Ҳ���.");
		Timer timer = new Timer(false); // true : ���α׷��� ���� �ɶ� ������ Timer �� �۵�.
		
		TimerTask task1 = new TimertaskEx1();
		TimertaskEx2 task2 = new TimertaskEx2();
		
		timer.schedule(task1, 500, 1000); // 0.5�� �ĺ��� 1�ʿ� �ѹ� task1.run() ȣ���϶�. 
		timer.schedule(task2, 5000); // 5���Ŀ� -�ѹ�- task2.run() ȣ���϶�. 
		
		Thread.sleep(10000); // 10�ʵ��� �����.
		System.out.println("���α׷� ����");
 	}
}
