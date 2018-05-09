package com.tj.ex04awtexample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex4Frame extends Frame implements ActionListener { // 이벤트를 처리하기 위해서 ActionListener 를 구현한다.
	private Label label1;
	private TextField textField;
	private Button btnOk,btnExit;
	
	private List list;
	private Panel panel;
	
	public Ex4Frame() {
		this("");
	}
	
	public Ex4Frame(String title) {
		super(title);
		panel = new Panel(); // 컴포넌트 모아놓을 패널 기본 레이아웃은 FlowLayout 이다.
		list = new List(); // 리스트
		
		label1 = new Label("추가할 글"); // 라벨
		textField = new TextField(20); // 입력칸
		btnOk = new Button("추가"); // 추가 버튼
		btnExit = new Button("EXIT"); // 단기 버튼
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH); // 위쪽에 붙인다.
		add(list, BorderLayout.CENTER); // 아래쪽에 붙인다.
		setVisible(true);
		setSize(new Dimension(500, 200)); // 창크기
		setLocation(300, 200); // 창위치
		
		panel.add(label1);
		panel.add(textField);
		panel.add(btnOk);
		panel.add(btnExit);
		
		addWindowListener(new WindowAdapter() { // 추상 클래스이라서 inner 타입으로 써야한다.
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}); // 윈도우 기본 닫기 버튼 처리
		
		// 버튼에 이벤트처리자를 추가한다. 이벤트가 발생하면 actionPerformed() 함수를 실행하게된다.
		btnOk.addActionListener(this); 
		btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트에 따른 처리를 이 메소드에 코딩한다.
		if(e.getSource() == btnOk) {
			
			list.add(textField.getText()); //리스트에 글자 추가하고
			textField.setText(""); // 문자입력칸은 빈칸으로 만든다.
			
		} else if(e.getSource() == btnExit){
			
			setVisible(false);
			dispose();
			System.exit(0); // 창을 닫는 처리
			
		}
	}
	
	/*  이벤트를 처리하는 법.
	 * 1 implements ActionListener 한다.
	 * 2  객체.addActionListener(this); 
	 * 3 actionPreformed 메소드 내에 구현한다.
	*/

}
