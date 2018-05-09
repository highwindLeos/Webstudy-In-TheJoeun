package com.tj.ex1total1;

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

public class MemberHashMap extends JFrame implements ActionListener{
	// GUI �� �ʿ��� ������.
	private Container contanPane;
	private JPanel jpup, jpdown, jptextarea;
	private JTextField textPhoneNum, textName, textPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scroll; // ��ũ�ѹ� ����� ����.
	// �����͸� ���� hashmap
	private HashMap<String, Member> members;
	private Iterator<String> iterator;
	
	public MemberHashMap(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �ݱ��ư �⺻ ���.
		
		members = new HashMap<String, Member>(); // ��ü ����
		
		contanPane = getContentPane(); //�⺻ â������ �� ����
		contanPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		jptextarea = new JPanel(new FlowLayout()); // �⺻ Bordered ���̾ƿ�
		
		textPhoneNum = new JTextField(15);
		textName = new JTextField(15);
		textPoint = new JTextField("1000",15);
		
		btnJoin = new JButton("����");
		btnSearch = new JButton("�� ��ȸ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");
		
		jta = new JTextArea(15,40);
		scroll = new JScrollPane(jta);
		
		jpup.add(new JLabel("����ȣ")); jpup.add(textPhoneNum);
		jpup.add(new JLabel("��   ��")); jpup.add(textName);
		jpup.add(new JLabel("����Ʈ")); jpup.add(textPoint);
		
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		
		jptextarea.add(scroll);
		
		contanPane.add(jpup);
		contanPane.add(jpdown);
		contanPane.add(jptextarea);
		
		setBounds(300, 300, 500, 450);
		setVisible(true);
		
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnJoin) {
			String tel, name; int point;

			tel = textPhoneNum.getText().trim();
			name = textName.getText().trim();
			// ��ȭ��ȣ�� �ݵ�� '-' �� �Է��ؾ� ���Ե�.
			if (tel.lastIndexOf('-') == -1) { return; }
			
			try {
				point = Integer.parseInt(textPoint.getText().trim());
			} catch (Exception e) {
				point = 0;
			}
			
			if (!tel.equals("") && !name.equals("") && point != 0) { // ��� ���� ���� �ƴҰ�츸 true
				Member newMember = new Member(tel, name, point);
				members.put(tel, newMember); // ������ �Է�
				
				jta.setText(jta.getText() + newMember.toString()+"\n");
				
				textPhoneNum.setText("");
				textName.setText("");
				textPoint.setText("1000");
				System.out.println(newMember + "\tȸ������ ����");
			} else {
				System.out.println("ȸ�� ������ �Է����ּ���.");
			}
		} else if(event.getSource() == btnSearch) { // postPhone ������ ��ȸ
			
			String serchphone = textPhoneNum.getText(); // ����ȣ �� 4�ڸ�
			int idx = 0;
			Iterator<String> iterator = members.keySet().iterator(); // HashMap ���ͷ�����
			while(iterator.hasNext()) {
				String phone = iterator.next();
				String postphone = phone.substring(phone.lastIndexOf('-')+1); // ������ - ���ڸ��� ������ ��ȣ
				
				if (serchphone.equals(postphone)) {
					textPhoneNum.setText(members.get(phone).getPhoneNum());
					textName.setText(members.get(phone).getName());
					textPoint.setText(String.valueOf(members.get(phone).getPoint()));
//					textPoint.setText(""+members.get(phone).getPoint());
//					textPoint.setText(String.format("%d", members.get(phone).getPoint()));
					break; // ��� ���� �������� ��������
				}
				
				idx++; 
			}
			
			if (idx == members.size()) {
				textPhoneNum.setText("���� ��ȣ����.");
				textName.setText("");
				textPoint.setText("1000");
			}
			
		} else if(event.getSource() == btnOutput) {
			// 1 byte ���� ��� ��Ʈ��
			/*OutputStream writer = null;
			try {
				writer = new FileOutputStream("Member.txt");
				Iterator<String> iterator = members.keySet().iterator();
				String filePrint = "";
				
				while(iterator.hasNext()) {
					String phone = iterator.next(); 
					filePrint += members.get(phone).toString() + "\r\n";
				} 
				
				filePrint += "�� " + members.size() + "��";
				System.out.println(filePrint);
				writer.write(filePrint.getBytes());
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (writer != null) { writer.close(); }
				} catch (Exception e) {	}
			}*/
			
			// 2 byte ���� ��� ��Ʈ��
			/*Writer writer = null;
			try {
				writer = new FileWriter("Member.txt");
				Iterator<String> iterator = members.keySet().iterator();
				
				while(iterator.hasNext()) {
					String phone = iterator.next(); 
					writer.write(members.get(phone).toString() + "\r\n");
				} 
				
				writer.write("�� " + members.size() + "��");
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (writer != null) { writer.close(); }
				} catch (Exception e) {	}
			}*/
			// ���� ��Ʈ��
			PrintWriter out =null;
			
			try {
				out = new PrintWriter("customer.txt");
				
				Iterator<String> iterator = members.keySet().iterator();
				
				while (iterator.hasNext()) {
					String phone = iterator.next();
					System.out.println(members.get(phone));
					System.out.println(members.get(phone).toString());
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} finally {
				out.close();
			}
			
			// textArea ���.
			iterator = members.keySet().iterator();
			jta.setText("");
			while(iterator.hasNext()) {
				String key = iterator.next();
				jta.setText(jta.getText() + members.get(key).toString()+"\n");
			}
			
		} else if(event.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}
