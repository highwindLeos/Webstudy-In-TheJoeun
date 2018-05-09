package com.tj.ex03awtframe;

import java.awt.*;
import java.awt.event.*;

public class Ex3LoginFrame extends Frame {
	private Panel panel;
	
	private Label label1, label2;
	private TextField textId, textPass;
	private Button btnLogin;
	
	public Ex3LoginFrame() {
		this("");
	}
	
	public Ex3LoginFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		panel = new Panel(); 
		panel.setLayout(new GridLayout(4, 4));// 패널은 3행 4열 그리드레이아웃으로 한다.
		// 첫행 첫열 마지막 행은 여백처럼 보이게 하는게 목적.
		label1 = new Label("아 이 디");
		label2 = new Label("비밀번호");
		
		
		textId = new TextField("ID", 20);
		textPass = new TextField(20);
		textPass.setEchoChar('*');
		btnLogin = new Button("로그인");
		
		panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); 
		panel.add(new Label("")); panel.add(label1); panel.add(textId); panel.add(new Label("")); 
		panel.add(new Label("")); panel.add(label2); panel.add(textPass); panel.add(new Label("")); 
		panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); // 패널에 컴포넌트 추가

		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(new Dimension(400, 150));
		//pack(); 최소 사이즈
		addWindowListener(new WindowAdapter() { // 추상 클래스이라서 inner 타입으로 써야한다.
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		
	}
	
}
