package com.tj.ex05game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuyBuyBoGame extends Frame implements ActionListener{
	private Panel panel;
	private Button btn1, btn2, btn3, btn4;
	private List list;
	
	public GuyBuyBoGame() {
		this("");
	}
	
	public GuyBuyBoGame(String title) {
		super(title);
		
		panel = new Panel();
		list = new List();
		
		btn1 = new Button("가위");
		btn2 = new Button("바위");
		btn3 = new Button("보");
		btn4 = new Button("close");
		
		btn1.setBackground(Color.PINK);
		btn2.setBackground(Color.PINK);
		btn3.setBackground(Color.PINK);
		
		panel.add(btn1); panel.add(btn2); panel.add(btn3); panel.add(btn4); 
		
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(new Dimension(500, 200)); // 창크기
		setBackground(Color.LIGHT_GRAY);// 창색상
		setLocation(300, 200); // 창위치
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		addWindowListener(new WindowAdapter() { // 추상 클래스이라서 inner 타입으로 써야한다.
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}); // 윈도우 기본 닫기 버튼 처리

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int computer = (int)(Math.random()*3); // 0 가위 1 바위 2보
		if(e.getSource() == btn1) {
			switch(computer) {
				case 0:
					list.add("비김. 둘다 가위"); break;
				case 1:
					list.add("당신이 짐. 당신 가위, 컴퓨터 바위"); break;
				case 2:
					list.add("당신이 이김. 당신 가위 컴퓨터 보"); break;
			}
		} else if(e.getSource() == btn2) {
			switch(computer) {
				case 0:
					list.add("당신이 이김. 당신 바위, 컴퓨터 가위"); break;
				case 1:
					list.add("비김. 둘다 바위"); break;
				case 2:
					list.add("당신이 짐. 당신 바위, 컴퓨터 보"); break;
			}
			
		} else if(e.getSource() == btn3) {
			switch(computer) {
				case 0:
					list.add("당신이 짐. 당신 보, 컴퓨터 가위"); break;
				case 1:
					list.add("당신이 이김.당신 보, 컴퓨터 바위"); break;
				case 2:
					list.add("비김. 둘다 보"); break;
			}
		} else if(e.getSource() == btn4) {
			setVisible(false);
			dispose();
			System.exit(0);
		} 
		
	}

}
