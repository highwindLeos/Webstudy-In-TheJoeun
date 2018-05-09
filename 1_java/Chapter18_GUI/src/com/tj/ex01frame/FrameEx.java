package com.tj.ex01frame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

public class FrameEx {
	public static void main(String[] args) {
		Frame frame = new Frame("윈도우 창 만들기 first Example");
		Button btn = new Button("버튼");
		
		frame.add(btn); // 창에 버튼을 추가.
		
		frame.setSize(new Dimension(300, 300)); // 창 크기를 설정
		frame.setBackground(Color.DARK_GRAY); // 창배경을 어두운 회색으로 설정
		frame.setVisible(true); // 창을 보이게 설정한다.
		for (int i=0; i<5 ; i++) {
			frame.setLocation(i*100, i*100);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {	}
		}
		
		frame.setVisible(false); // 창을 보이지 않게 한다.
		frame.dispose(); // 창의 자원을 모두 해제한다.(메모리에서 사라짐)
		System.exit(0); // 강제 종료.
	}

}
