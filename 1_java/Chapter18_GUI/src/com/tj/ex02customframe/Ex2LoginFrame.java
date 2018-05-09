package com.tj.ex02customframe;

import java.awt.*;
import java.awt.event.*;

public class Ex2LoginFrame extends Frame {
	private Label label1;
	private Label label2;
	
	private TextField textId; // �⺻ ǥ�� ����. 20�� �Է� 
	private TextField textPass; // �⺻ ǥ�� ���� X. 20�� �Է� 
	
	private Button btn; 
	
	public Ex2LoginFrame() { // lable textfield Button
		setLayout(new FlowLayout()); // add �� ������� component �߰�
		
		label1 = new Label("�� �� ��");
		label2 = new Label("��й�ȣ");
		
		textId = new TextField("ID",20);// �⺻ ǥ�� ����. 20�� �Է� 
		textPass = new TextField(20);// �⺻ ǥ�� ���� X. 20�� �Է� 
		textPass.setEchoChar('*'); // Ÿ�����ϴ� ǥ�ø� * �� �ٲ�
		
		btn = new Button("�α���");
		
		add(label1); add(textId);
		add(label2); add(textPass);
		add(btn);
		
		setSize(new Dimension(300, 150)); //  â�� ũ�� 300 * 150
		setLocation(600, 300); // �������� 500 300 ��ġ�� ǥ��
		setBackground(Color.LIGHT_GRAY); // â�� ������ ȸ������ �ٲ�
		setVisible(true); // ���̰� �ϱ�

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}); // ������ �ݱ� ��ư �̺�Ʈ ����
	}
	
	public Ex2LoginFrame(String title) {
		this();
		setTitle(title);
	}


}
