package com.tj.ex09imagebtn2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

	private Container contanPane; // �����̳ʸ� �޾ƿ� ����
	private JPanel jPanel1 , jPanel2;
	private JTextField jtextName, jtextTel, jtextAge;
	private ImageIcon icon1, icon2; // ��� ��ư�� �� imageicon
	private JButton btnIn, btnOut;
	
	private ArrayList<Person> arrayList = new ArrayList<Person>();
	
	private String name;
	private String tel;
	private int age;
	
	public MyFrame(String title) {
		super(title); // JFrame �� ������
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contanPane = getContentPane(); // �����̳ʸ� �����´�.
		jPanel1 = new JPanel(new GridLayout(3, 2)); 
		jPanel2 = new JPanel(new GridLayout(1, 2)); // �г��� ����

		jtextName = new JTextField();
		jtextTel = new JTextField();
		jtextAge = new JTextField(); // textfeild ����

		icon1 = new ImageIcon("src/mac-mini.png");
		icon2 = new ImageIcon("src/elephpant.gif");
		
		btnIn = new JButton("�Է�", icon1); // �̹��� �����ܵ� �ִ´�.
		btnOut = new JButton("���", icon2); // �̹��� �����ܵ� �ִ´�.

		jPanel1.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextName);
		jPanel1.add(new JLabel("�� ȭ", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextTel);
		jPanel1.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextAge);
		
		jPanel2.add(btnIn);
		jPanel2.add(btnOut);

		contanPane.add(jPanel1, BorderLayout.CENTER);
		contanPane.add(jPanel2, BorderLayout.SOUTH); // ���� �����̳ʿ� ��� �ΰ��� ���δ�.

		setVisible(true);
		setBounds(100, 100, 300, 200); // location �� size �� ���� ����ش�.

		btnIn.addActionListener(this); // ��ư �̺�Ʈ�� ó���Ѵ�.
		btnOut.addActionListener(this); // ��ư �̺�Ʈ�� ó���Ѵ�.

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnIn) {
			
			 name = jtextName.getText().trim();  // trim() �¿� ������ ����
			 tel = jtextTel.getText().trim();
			 
			 try {
				 age = Integer.parseInt(jtextAge.getText().trim());
			 } catch (Exception e) {
				 age = 0;
			 }
			 
			if(!jtextName.equals("") && !jtextTel.equals("") && age != 0) {// ��ĭ�� �ƴҶ��� �Է���.
				arrayList.add(new Person(name, tel, age));
				
				jtextName.setText("");
				jtextTel.setText("");
				jtextAge.setText(""); // ��ư�� ������ ��ĭ���� ������ش�.
			} 

		} else if (event.getSource() == btnOut) {
			
			for(Person pt : arrayList) {
				System.out.println(pt.toString());
			}// �ֿܼ� ���
			
			Writer writer = null;
			File file = new File("src/person.txt");
			
			try {
				writer = new FileWriter(file, true); // ���Ͽ� �߰��ϰ� ó��
				
				for (Person pt : arrayList) {
					writer.write(pt.toString() + "\r\n"); // ���Ͽ� ����.
				}
				
			}catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(writer != null) { writer.close(); }
				} catch (Exception e) { }
			} //try catch
		}// if end 
	} //actionPerformed()
}
