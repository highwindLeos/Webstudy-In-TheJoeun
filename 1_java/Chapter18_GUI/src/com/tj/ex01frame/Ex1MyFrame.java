package com.tj.ex01frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1MyFrame extends Frame {
	
	public Ex1MyFrame() {
		this(""); //기본 생성자는 String 매개변수가 있는 생성자를 호출하게 된다.
	}
	
	public Ex1MyFrame(String title) {
		super(title);
		Button btn = new Button("버튼");
		add(btn);
		setVisible(true);
		pack(); // 사이즈를 프레임의 최소한의 사이즈로 설정.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			} // window 의 x 버튼을 클릭하면.
		});
	}
}
