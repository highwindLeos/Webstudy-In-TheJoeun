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
		
		btn1 = new Button("����");
		btn2 = new Button("����");
		btn3 = new Button("��");
		btn4 = new Button("close");
		
		btn1.setBackground(Color.PINK);
		btn2.setBackground(Color.PINK);
		btn3.setBackground(Color.PINK);
		
		panel.add(btn1); panel.add(btn2); panel.add(btn3); panel.add(btn4); 
		
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(new Dimension(500, 200)); // âũ��
		setBackground(Color.LIGHT_GRAY);// â����
		setLocation(300, 200); // â��ġ
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		addWindowListener(new WindowAdapter() { // �߻� Ŭ�����̶� inner Ÿ������ ����Ѵ�.
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}); // ������ �⺻ �ݱ� ��ư ó��

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int computer = (int)(Math.random()*3); // 0 ���� 1 ���� 2��
		if(e.getSource() == btn1) {
			switch(computer) {
				case 0:
					list.add("���. �Ѵ� ����"); break;
				case 1:
					list.add("����� ��. ��� ����, ��ǻ�� ����"); break;
				case 2:
					list.add("����� �̱�. ��� ���� ��ǻ�� ��"); break;
			}
		} else if(e.getSource() == btn2) {
			switch(computer) {
				case 0:
					list.add("����� �̱�. ��� ����, ��ǻ�� ����"); break;
				case 1:
					list.add("���. �Ѵ� ����"); break;
				case 2:
					list.add("����� ��. ��� ����, ��ǻ�� ��"); break;
			}
			
		} else if(e.getSource() == btn3) {
			switch(computer) {
				case 0:
					list.add("����� ��. ��� ��, ��ǻ�� ����"); break;
				case 1:
					list.add("����� �̱�.��� ��, ��ǻ�� ����"); break;
				case 2:
					list.add("���. �Ѵ� ��"); break;
			}
		} else if(e.getSource() == btn4) {
			setVisible(false);
			dispose();
			System.exit(0);
		} 
		
	}

}
