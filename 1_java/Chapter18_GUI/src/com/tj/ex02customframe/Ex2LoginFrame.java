package com.tj.ex02customframe;

import java.awt.*;
import java.awt.event.*;

public class Ex2LoginFrame extends Frame {
	private Label label1;
	private Label label2;
	
	private TextField textId; // 기본 표시 글자. 20자 입력 
	private TextField textPass; // 기본 표시 글자 X. 20자 입력 
	
	private Button btn; 
	
	public Ex2LoginFrame() { // lable textfield Button
		setLayout(new FlowLayout()); // add 한 순서대로 component 추가
		
		label1 = new Label("아 이 디");
		label2 = new Label("비밀번호");
		
		textId = new TextField("ID",20);// 기본 표시 글자. 20자 입력 
		textPass = new TextField(20);// 기본 표시 글자 X. 20자 입력 
		textPass.setEchoChar('*'); // 타이핑하는 표시를 * 로 바꿈
		
		btn = new Button("로그인");
		
		add(label1); add(textId);
		add(label2); add(textPass);
		add(btn);
		
		setSize(new Dimension(300, 150)); //  창의 크기 300 * 150
		setLocation(600, 300); // 윈도우의 500 300 위치에 표시
		setBackground(Color.LIGHT_GRAY); // 창의 배경색을 회색으로 바꿈
		setVisible(true); // 보이게 하기

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}); // 윈도우 닫기 버튼 이벤트 정의
	}
	
	public Ex2LoginFrame(String title) {
		this();
		setTitle(title);
	}


}
