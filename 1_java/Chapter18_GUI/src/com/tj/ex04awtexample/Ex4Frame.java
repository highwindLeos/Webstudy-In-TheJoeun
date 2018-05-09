package com.tj.ex04awtexample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex4Frame extends Frame implements ActionListener { // �̺�Ʈ�� ó���ϱ� ���ؼ� ActionListener �� �����Ѵ�.
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
		panel = new Panel(); // ������Ʈ ��Ƴ��� �г� �⺻ ���̾ƿ��� FlowLayout �̴�.
		list = new List(); // ����Ʈ
		
		label1 = new Label("�߰��� ��"); // ��
		textField = new TextField(20); // �Է�ĭ
		btnOk = new Button("�߰�"); // �߰� ��ư
		btnExit = new Button("EXIT"); // �ܱ� ��ư
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH); // ���ʿ� ���δ�.
		add(list, BorderLayout.CENTER); // �Ʒ��ʿ� ���δ�.
		setVisible(true);
		setSize(new Dimension(500, 200)); // âũ��
		setLocation(300, 200); // â��ġ
		
		panel.add(label1);
		panel.add(textField);
		panel.add(btnOk);
		panel.add(btnExit);
		
		addWindowListener(new WindowAdapter() { // �߻� Ŭ�����̶� inner Ÿ������ ����Ѵ�.
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}); // ������ �⺻ �ݱ� ��ư ó��
		
		// ��ư�� �̺�Ʈó���ڸ� �߰��Ѵ�. �̺�Ʈ�� �߻��ϸ� actionPerformed() �Լ��� �����ϰԵȴ�.
		btnOk.addActionListener(this); 
		btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ�� ���� ó���� �� �޼ҵ忡 �ڵ��Ѵ�.
		if(e.getSource() == btnOk) {
			
			list.add(textField.getText()); //����Ʈ�� ���� �߰��ϰ�
			textField.setText(""); // �����Է�ĭ�� ��ĭ���� �����.
			
		} else if(e.getSource() == btnExit){
			
			setVisible(false);
			dispose();
			System.exit(0); // â�� �ݴ� ó��
			
		}
	}
	
	/*  �̺�Ʈ�� ó���ϴ� ��.
	 * 1 implements ActionListener �Ѵ�.
	 * 2  ��ü.addActionListener(this); 
	 * 3 actionPreformed �޼ҵ� ���� �����Ѵ�.
	*/

}
