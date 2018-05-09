package com.tj.ex06swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex0Frame extends JFrame implements ActionListener{ // swing frame ����Ѵ�.
	
//	private Container contanPane;
	private JPanel panel; // �����̳� ��Ȱ�� �� �г�
	private JLabel jlabel;
	private JButton jbtn;
	
	public Ex0Frame(String title) {
		super(title);
		// �����̳� �޾ƿ´�.
		panel = (JPanel)getContentPane(); // Jframe �̱⶧���� Jpanel �� ����ȯ�ؼ� ����.�޵�� �����̳ʷ� �־���Ѵ�.
		panel.setLayout(new FlowLayout());
		// lable btn ��ü�� ����� �����̳ʿ��ٰ� add
		
		jlabel = new JLabel("��ſ� ȭ����", (int) CENTER_ALIGNMENT);
		jbtn = new JButton("����");
		
		panel.add(jlabel); panel.add(jbtn);
		
		jlabel.setPreferredSize(new Dimension(250, 200)); // ������Ʈ�� ����� ���Ѵ�.
		jbtn.setPreferredSize(new Dimension(200, 200)); 
		// setVisuble() true setsize.
		setVisible(true);
		pack();
		setSize(new Dimension(500, 250));
		// �̺�Ʈ ó�� �۾� �߰� 
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ������ �⺻ �ݱ� ��ư �̺�Ʈ ó��
		
		jbtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
}
