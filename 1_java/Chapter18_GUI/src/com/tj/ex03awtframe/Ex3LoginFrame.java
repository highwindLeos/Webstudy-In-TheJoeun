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
		panel.setLayout(new GridLayout(4, 4));// �г��� 3�� 4�� �׸��巹�̾ƿ����� �Ѵ�.
		// ù�� ù�� ������ ���� ����ó�� ���̰� �ϴ°� ����.
		label1 = new Label("�� �� ��");
		label2 = new Label("��й�ȣ");
		
		
		textId = new TextField("ID", 20);
		textPass = new TextField(20);
		textPass.setEchoChar('*');
		btnLogin = new Button("�α���");
		
		panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); 
		panel.add(new Label("")); panel.add(label1); panel.add(textId); panel.add(new Label("")); 
		panel.add(new Label("")); panel.add(label2); panel.add(textPass); panel.add(new Label("")); 
		panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); panel.add(new Label("")); // �гο� ������Ʈ �߰�

		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(new Dimension(400, 150));
		//pack(); �ּ� ������
		addWindowListener(new WindowAdapter() { // �߻� Ŭ�����̶� inner Ÿ������ ����Ѵ�.
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		
	}
	
}
