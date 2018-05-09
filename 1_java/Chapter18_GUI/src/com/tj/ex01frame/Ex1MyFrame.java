package com.tj.ex01frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1MyFrame extends Frame {
	
	public Ex1MyFrame() {
		this(""); //�⺻ �����ڴ� String �Ű������� �ִ� �����ڸ� ȣ���ϰ� �ȴ�.
	}
	
	public Ex1MyFrame(String title) {
		super(title);
		Button btn = new Button("��ư");
		add(btn);
		setVisible(true);
		pack(); // ����� �������� �ּ����� ������� ����.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			} // window �� x ��ư�� Ŭ���ϸ�.
		});
	}
}
