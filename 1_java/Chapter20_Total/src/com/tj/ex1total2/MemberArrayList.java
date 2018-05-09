package com.tj.ex1total2;

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

public class MemberArrayList extends JFrame implements ActionListener{
	// GUI �� �ʿ��� ������.
	private Container contanPane;
	private JPanel jpup, jpdown, jptextarea;
	private JTextField textPhoneNum, textName, textPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scroll; // ��ũ�ѹ� ����� ����.
	// �����͸� ���� hashmap
	private ArrayList<Member> members;
	private Iterator<String> iterator;
	
	public MemberArrayList(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �ݱ��ư �⺻ ���.
		
		members = new ArrayList<Member>(); // ��ü ����
		
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
				members.add(newMember); // ������ �Է�
				
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
			for(idx = 0; idx < members.size(); idx++) {
				String phone = members.get(idx).getPhoneNum();
				String postPhone = phone.substring(phone.lastIndexOf('-')+1);
				
				if(postPhone.equals(serchphone)) {
					textPhoneNum.setText(members.get(idx).getPhoneNum());
					textName.setText(members.get(idx).getName());
					textPoint.setText(String.valueOf(members.get(idx).getPoint())); 
					// int �̱⶧���� ���ڸ� ���ڷ� �ٲپ� �����ؾ��Ѵ�.
					break;
				}
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
								
				for (Member mt : members) {
					out.write(mt.toString() + "\r\n");
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} finally {
				if (out != null) out.close();
			}
			
			// textArea ���.
			jta.setText("");
			for (Member mt : members) {
				System.out.println(mt);
				out.println(mt.toString());
			}
			
		} else if(event.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}
