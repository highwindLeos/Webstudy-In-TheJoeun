package com.tj.ex08imagebtn;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class ImageButtonFrame extends JFrame implements ActionListener {

	private Container contanPane; // �����̳ʸ� �޾ƿ� ����
	private JPanel jPanel1;
	private JTextField jtextName, jtextTel, jtextAge;
	private ImageIcon icon; // ��� ��ư�� �� imageicon
	private JButton btnOut, btnIn;
	
	private ArrayList<String> text = new ArrayList<String>();

	public ImageButtonFrame(String title) {
		super(title); // JFrame �� ������
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contanPane = getContentPane();
		jPanel1 = new JPanel(new GridLayout(3, 2));

		jtextName = new JTextField();
		jtextTel = new JTextField();
		jtextAge = new JTextField();

		icon = new ImageIcon("src/mac-mini.png");
		btnOut = new JButton("���", icon); // �̹��� �����ܵ� �ִ´�.
		btnIn = new JButton("�Է�", icon); // �Է¹�ư

		jPanel1.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextName);
		jPanel1.add(new JLabel("�� ȭ", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextTel);
		jPanel1.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextAge);
		

		contanPane.add(jPanel1, BorderLayout.CENTER);
		contanPane.add(btnIn, BorderLayout.SOUTH);
		contanPane.add(btnOut, BorderLayout.SOUTH); // ���� �����̳ʿ� ��� �ΰ��� ���δ�.

		setVisible(true);
		setBounds(100, 100, 300, 200); // location �� size �� ���� ����ش�.

		btnOut.addActionListener(this); // ��ư �̺�Ʈ�� ó���Ѵ�.

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnOut) {
			System.out.println("[��   ��] : " + jtextName.getText() + "\t");
			System.out.println("[����ó] : " + jtextTel.getText() + "\t");
			int age;
			try {
				age = Integer.parseInt(jtextAge.getText()); // ���ڿ��� �Է��� �ؽ�Ʈ�� �����θ����.
			} catch (Exception e) {
				age = 0;
			}
			
			if (age >= 80) {
				System.out.println("���� : ** ��");
			} else if (age > 0 && age < 80) {
				System.out.println("���� : " + age + "��");
			} else {
				System.out.println("���̸� �߸� �Է��ϼ̳׿�.");
			}
			// System.out.println("[����] : " + ((age != 0) ? age + "��" : "���̰� �̻���") + "\t");

			jtextName.setText("");
			jtextTel.setText("");
			jtextAge.setText(""); // ��ư�� ������ ��ĭ���� ������ش�.
		}

	}

}
