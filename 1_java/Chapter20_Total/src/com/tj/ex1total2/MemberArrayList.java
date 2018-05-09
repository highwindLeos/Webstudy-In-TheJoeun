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
	// GUI 에 필요한 변수들.
	private Container contanPane;
	private JPanel jpup, jpdown, jptextarea;
	private JTextField textPhoneNum, textName, textPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scroll; // 스크롤바 만드는 변수.
	// 데이터를 담을 hashmap
	private ArrayList<Member> members;
	private Iterator<String> iterator;
	
	public MemberArrayList(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기버튼 기본 기능.
		
		members = new ArrayList<Member>(); // 객체 생성
		
		contanPane = getContentPane(); //기본 창프레임 을 생성
		contanPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		jptextarea = new JPanel(new FlowLayout()); // 기본 Bordered 레이아웃
		
		textPhoneNum = new JTextField(15);
		textName = new JTextField(15);
		textPoint = new JTextField("1000",15);
		
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰 조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		
		jta = new JTextArea(15,40);
		scroll = new JScrollPane(jta);
		
		jpup.add(new JLabel("폰번호")); jpup.add(textPhoneNum);
		jpup.add(new JLabel("이   름")); jpup.add(textName);
		jpup.add(new JLabel("포인트")); jpup.add(textPoint);
		
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
			// 전화번호는 반드시 '-' 를 입력해야 가입됨.
			if (tel.lastIndexOf('-') == -1) { return; }
			
			try {
				point = Integer.parseInt(textPoint.getText().trim());
			} catch (Exception e) {
				point = 0;
			}
			
			if (!tel.equals("") && !name.equals("") && point != 0) { // 모든 값이 빈값이 아닐경우만 true
				Member newMember = new Member(tel, name, point);
				members.add(newMember); // 데이터 입력
				
				jta.setText(jta.getText() + newMember.toString()+"\n");
				
				textPhoneNum.setText("");
				textName.setText("");
				textPoint.setText("1000");
				System.out.println(newMember + "\t회원가입 성공");
			} else {
				System.out.println("회원 정보를 입력해주세요.");
			}
		} else if(event.getSource() == btnSearch) { // postPhone 가지고 조회
			
			String serchphone = textPhoneNum.getText(); // 폰번호 뒤 4자리
			int idx = 0;
			for(idx = 0; idx < members.size(); idx++) {
				String phone = members.get(idx).getPhoneNum();
				String postPhone = phone.substring(phone.lastIndexOf('-')+1);
				
				if(postPhone.equals(serchphone)) {
					textPhoneNum.setText(members.get(idx).getPhoneNum());
					textName.setText(members.get(idx).getName());
					textPoint.setText(String.valueOf(members.get(idx).getPoint())); 
					// int 이기때문에 숫자를 문자로 바꾸어 셋팅해야한다.
					break;
				}
			}
			
			if (idx == members.size()) {
				textPhoneNum.setText("없는 번호예요.");
				textName.setText("");
				textPoint.setText("1000");
			}
			
		} else if(event.getSource() == btnOutput) {
			// 1 byte 단위 출력 스트림
			/*OutputStream writer = null;
			try {
				writer = new FileOutputStream("Member.txt");
				Iterator<String> iterator = members.keySet().iterator();
				String filePrint = "";
				
				while(iterator.hasNext()) {
					String phone = iterator.next(); 
					filePrint += members.get(phone).toString() + "\r\n";
				} 
				
				filePrint += "총 " + members.size() + "명";
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
			
			// 2 byte 단위 출력 스트림
			/*Writer writer = null;
			try {
				writer = new FileWriter("Member.txt");
				Iterator<String> iterator = members.keySet().iterator();
				
				while(iterator.hasNext()) {
					String phone = iterator.next(); 
					writer.write(members.get(phone).toString() + "\r\n");
				} 
				
				writer.write("총 " + members.size() + "명");
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (writer != null) { writer.close(); }
				} catch (Exception e) {	}
			}*/
			// 보조 스트림
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
			
			// textArea 출력.
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
