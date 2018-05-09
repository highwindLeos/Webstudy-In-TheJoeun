package com.tj.ex2total;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StudentArrayList extends JFrame implements ActionListener{
	// GUI �� �ʿ��� ������.
	private Container contanPane;
	private JPanel jpup, jpbtnpanel1, jpbtnpanel2, jptextarea;
	private JTextField textHakbun, textName, textPoint;
	private JComboBox<String> comboBox;
	private JButton btnJoin, btnSearch, btnUpdate, btnOutput, btnExpelOutput, btnExpel;
	private JTextArea jta;
	private JScrollPane scroll; // ��ũ�ѹ� ����� ����.
	// �����͸� ���� hashmap
	private ArrayList<Student> students, expels;
	
	public StudentArrayList(String title) {
		super(title);
		students = new ArrayList<Student>(); // ��ü ����
		expels = new ArrayList<Student>(); // ��ü ����

		setDefaultCloseOperation(EXIT_ON_CLOSE); // �ݱ��ư �⺻ ���.
		
		contanPane = getContentPane(); //�⺻ â������ �� ����
		contanPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4, 2));
		jpbtnpanel1 = new JPanel(new FlowLayout());
		jpbtnpanel2 = new JPanel(new FlowLayout());
		jptextarea = new JPanel(new FlowLayout()); // �⺻ Bordered ���̾ƿ�
		
		textHakbun = new JTextField(15);
		textName = new JTextField(15);
		String[] comboList = {"�濵����","��ǻ�Ͱ���","�׷��ȵ�����","���ǰ�","�ɸ��а�"};
		comboBox = new JComboBox<String>(comboList);
		
		textPoint = new JTextField("1000",15);
		
		btnJoin = new JButton("�л�����");
		btnSearch = new JButton("�й���ȸ");
		btnUpdate = new JButton("�л�����");
		btnOutput = new JButton("��ä���");
		btnExpelOutput = new JButton("�������");
		btnExpel = new JButton("����ó��");
		
		jta = new JTextArea(15,40);
		scroll = new JScrollPane(jta);
		
		jpup.add(new JLabel("�й�")); jpup.add(textHakbun);
		jpup.add(new JLabel("�̸�")); jpup.add(textName);
		jpup.add(new JLabel("����")); jpup.add(comboBox);
		jpup.add(new JLabel("����")); jpup.add(textPoint);
		
		jpbtnpanel1.add(btnJoin);
		jpbtnpanel1.add(btnSearch);
		jpbtnpanel1.add(btnUpdate);
		
		jpbtnpanel2.add(btnOutput);
		jpbtnpanel2.add(btnExpelOutput);
		jpbtnpanel2.add(btnExpel);

		jptextarea.add(scroll);
		
		contanPane.add(jpup);
		contanPane.add(jpbtnpanel1);
		contanPane.add(jpbtnpanel2);
		contanPane.add(jptextarea);
		
		setBounds(300, 300, 550, 550);
		setVisible(true);
		
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExpelOutput.addActionListener(this);
		btnExpel.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnJoin) {
			int hakbun = -1, point = -1; 
			String major, name;
			
			try {
				hakbun = Integer.parseInt(textHakbun.getText().trim());
				name = textName.getText().trim();
				major = comboBox.getSelectedItem().toString();
				point = Integer.parseInt(textPoint.getText().trim());
			} catch (Exception e) {
				System.out.println("�й��� ������ ������ �Է��ؾ��մϴ�");
				return;
			}
			
			if (hakbun != 0 && !name.equals("") && !major.equals("") && point != 0 ) {
				Student newStudents = new Student(hakbun, name, major, point);
				
				students.add(newStudents); // ������ �Է�
				jta.append(newStudents.toString() + "\n"); 
				
				textHakbun.setText("");
				textName.setText("");
				comboBox.setSelectedIndex(0); // 0 ��° ���� 
				textPoint.setText("");
				System.out.println(newStudents + "\tȸ������ ����");
			}
			
		} else if(event.getSource() == btnSearch) { //  ������ ��ȸ
			int serchhakbun, idx;
			try {
				serchhakbun = Integer.parseInt(textHakbun.getText());
			} catch (Exception e) {
				System.out.println("�й��� ������ �Է��ؾ��մϴ�");
				return;
			}
			
			for (idx = 0; idx < students.size(); idx++) {				
				if (students.get(idx).getHakbun() == serchhakbun) {
					textName.setText(students.get(idx).getName());
					comboBox.setSelectedItem(students.get(idx).getMajor());
					textPoint.setText("" + students.get(idx).getPoint()); // ������ ���� int �� ���ڿ��� �ٲپ���
					break;
				}
			}
			
			if (idx == students.size()) {
				textHakbun.setText("���� �й��Դϴ�.");
				textName.setText("");
				comboBox.setSelectedItem(0); // 0�� ����
				textPoint.setText("");
			}
			
		} else if(event.getSource() == btnUpdate) {
			int hakbun, score, idx;

			try {
				hakbun = Integer.parseInt(textHakbun.getText().trim());
				score = Integer.parseInt(textPoint.getText().trim());
			} catch (Exception e) {
				System.out.println("�й��� ������ ������ �Է��ؾ��մϴ�");
				return;
			}
			
			for (idx = 0 ; idx < students.size(); idx++) {
				if (students.get(idx).getHakbun() == hakbun) {
					students.get(idx).setName(textName.getText());
					students.get(idx).setMajor(comboBox.getSelectedItem().toString());
					students.get(idx).setPoint(score);
					break;
				}
			}
			 // ã�� ���� ��� �ݺ������� idx �� ����Ʈ�� size ��ŭ �����ߴٸ�. �Ʒ��� �ڵ���� �����Ѵ�.
			if(idx == students.size()) {
				textHakbun.setText("���� �й��Դϴ�.");
				textName.setText("");
				comboBox.setSelectedItem(0); // 0�� ����
				textPoint.setText("");
			}
			
			jta.setText("");
			for (Student st : students) {
				System.out.println(st);
			}
			
		} else if(event.getSource() == btnOutput) {
			
			PrintWriter outfile = null;
			
			try {
				outfile = new PrintWriter("students.txt");
				
				for (Student st : students) {
					outfile.println(st);
					outfile.write(st.toString()+"\r\n");
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} finally {
				if (outfile != null) { outfile.close(); }
			}
			
			jta.setText("");
			for (Student st : students) {
				System.out.println(st);
			}
			
		} else if(event.getSource() == btnExpelOutput) {
			
			PrintWriter outfile = null;
			
			try {
				outfile = new PrintWriter("expel.txt");
				
				for(Student expel : expels) {
					outfile.println(expel.toString());
					System.out.println(expel);
				}
				
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			} finally {
				if (outfile != null) { outfile.close();}
			}
			
		} else if(event.getSource() == btnExpel) {
			
			int expelhakbun, idx, studentSize;
			
			try {
				expelhakbun = Integer.parseInt(textHakbun.getText());
			} catch (Exception e) {
				System.out.println("�й��� ������ "); 
				return;
			}
			
			studentSize = students.size(); // �Էµ� �л��� ��.
			
			for(idx = 0 ; idx < students.size(); idx++) {
				if (students.get(idx).getHakbun() == expelhakbun) {
					expels.add(students.get(idx));
					students.remove(idx);
					
					textHakbun.setText(""); 
					textName.setText("");
					comboBox.setSelectedIndex(0);
					textPoint.setText("");
					break;
				}
			}
			
			jta.setText("");
			for (Student st : students) {
				System.out.println(st);
			}
			
		} // event 
	}
}
