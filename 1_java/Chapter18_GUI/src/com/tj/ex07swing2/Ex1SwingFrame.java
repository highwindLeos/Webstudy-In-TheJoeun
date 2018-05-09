package com.tj.ex07swing2;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex1SwingFrame extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JLabel lable1, lableBlank;
	private JButton btnAdd, btnExit;
	private JTextField textField;
	
	private JComboBox<String> comboBox; // 2������ �ʿ��ϴ�. �޺��ڽ� ��ü, ����Ʈ ������
	private String[] items = {"A","B","C","D","E"}; //�޺� �ڽ� ����Ʈ ���. Vecter �� String �� ����.
	private Vector<String> item = new Vector<String>(); // �޺� �ڽ� ����Ʈ ���.
	
	private JCheckBox checkBox;
	
	public Ex1SwingFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // â�ݱ� �̺�Ʈ
		panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		lable1 = new JLabel("lable");
		btnAdd = new JButton("Button");
		textField = new JTextField();
		
		item.add("A"); 	item.add("B"); 	item.add("C"); // ���Ϳ� ���� �ִ´�.
		comboBox = new JComboBox<String>(item);
		
		checkBox = new JCheckBox("checkBox");
		lableBlank = new JLabel();
		btnExit = new JButton("exit");
		
		panel.add(lable1); panel.add(btnAdd); panel.add(textField);
		panel.add(comboBox); panel.add(checkBox); panel.add(lableBlank);
		panel.add(btnExit);
		// ������Ʈ ũ������.
		lable1.setPreferredSize(new Dimension(50, 50));
		btnAdd.setPreferredSize(new Dimension(100, 50));
		textField.setPreferredSize(new Dimension(300, 50));
		comboBox.setPreferredSize(new Dimension(50, 50));
		checkBox.setPreferredSize(new Dimension(100, 50));
		lableBlank.setPreferredSize(new Dimension(200, 50));
		btnExit.setPreferredSize(new Dimension(100, 50));
		
		setVisible(true);
		pack();
		setLocation(300,400);
		
		btnAdd.addActionListener(this);
		checkBox.addActionListener(this);
		comboBox.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			if(textField.getText().trim().equals("")) { // ��ĭ�̶�� �Ʒ� ������� ���� �ʰ� �������´�.
				return;
			}
			
			lableBlank.setText(textField.getText()); // �Էµ� �۾��� �� �󺧿� ���̰� �Ѵ�
			item.add(textField.getText()); // �Էµ� ���ڸ� �޺��ڽ� ����Ʈ�� �߰��Ѵ�. combobox.addItem() ���� �߰��Ҽ� �ִ�.
			String name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���");
			textField.setText(name); // textField�� �ؽ�Ʈ�� �߰��ߴ�.
		} else if(e.getSource() == comboBox) {
			lableBlank.setText(comboBox.getSelectedItem().toString()); // �޺��ڽ� ���õ� ���� �� �󺧿� ���̰� �Ѵ�
		} else if(e.getSource() == checkBox) {
			lableBlank.setText(checkBox.getText());
		} else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
		
}

