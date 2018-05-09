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
	
	private JComboBox<String> comboBox; // 2가지가 필요하다. 콤보박스 개체, 리스트 데이터
	private String[] items = {"A","B","C","D","E"}; //콤보 박스 리스트 요소. Vecter 나 String 만 가능.
	private Vector<String> item = new Vector<String>(); // 콤보 박스 리스트 요소.
	
	private JCheckBox checkBox;
	
	public Ex1SwingFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 창닫기 이벤트
		panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		lable1 = new JLabel("lable");
		btnAdd = new JButton("Button");
		textField = new JTextField();
		
		item.add("A"); 	item.add("B"); 	item.add("C"); // 벡터에 값을 넣는다.
		comboBox = new JComboBox<String>(item);
		
		checkBox = new JCheckBox("checkBox");
		lableBlank = new JLabel();
		btnExit = new JButton("exit");
		
		panel.add(lable1); panel.add(btnAdd); panel.add(textField);
		panel.add(comboBox); panel.add(checkBox); panel.add(lableBlank);
		panel.add(btnExit);
		// 컴포넌트 크기조정.
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
			if(textField.getText().trim().equals("")) { // 빈칸이라면 아래 실행들을 하지 않고 빠져나온다.
				return;
			}
			
			lableBlank.setText(textField.getText()); // 입력된 글씨를 빈 라벨에 보이게 한다
			item.add(textField.getText()); // 입력된 글자를 콤보박스 리스트에 추가한다. combobox.addItem() 으로 추가할수 있다.
			String name = JOptionPane.showInputDialog("이름을 입력하세요");
			textField.setText(name); // textField의 텍스트를 추가했다.
		} else if(e.getSource() == comboBox) {
			lableBlank.setText(comboBox.getSelectedItem().toString()); // 콤보박스 선택된 글이 빈 라벨에 보이게 한다
		} else if(e.getSource() == checkBox) {
			lableBlank.setText(checkBox.getText());
		} else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
		
}

