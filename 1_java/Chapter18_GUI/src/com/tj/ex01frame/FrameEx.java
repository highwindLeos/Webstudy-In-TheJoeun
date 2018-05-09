package com.tj.ex01frame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

public class FrameEx {
	public static void main(String[] args) {
		Frame frame = new Frame("������ â ����� first Example");
		Button btn = new Button("��ư");
		
		frame.add(btn); // â�� ��ư�� �߰�.
		
		frame.setSize(new Dimension(300, 300)); // â ũ�⸦ ����
		frame.setBackground(Color.DARK_GRAY); // â����� ��ο� ȸ������ ����
		frame.setVisible(true); // â�� ���̰� �����Ѵ�.
		for (int i=0; i<5 ; i++) {
			frame.setLocation(i*100, i*100);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {	}
		}
		
		frame.setVisible(false); // â�� ������ �ʰ� �Ѵ�.
		frame.dispose(); // â�� �ڿ��� ��� �����Ѵ�.(�޸𸮿��� �����)
		System.exit(0); // ���� ����.
	}

}
