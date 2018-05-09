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
	// GUI 에 필요한 변수들.
	private Container contanPane;
	private JPanel jpup, jpbtnpanel1, jpbtnpanel2, jptextarea;
	private JTextField textHakbun, textName, textPoint;
	private JComboBox<String> comboBox;
	private JButton btnJoin, btnSearch, btnUpdate, btnOutput, btnExpelOutput, btnExpel;
	private JTextArea jta;
	private JScrollPane scroll; // 스크롤바 만드는 변수.
	// 데이터를 담을 hashmap
	private ArrayList<Student> students, expels;
	
	public StudentArrayList(String title) {
		super(title);
		students = new ArrayList<Student>(); // 객체 생성
		expels = new ArrayList<Student>(); // 객체 생성

		setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기버튼 기본 기능.
		
		contanPane = getContentPane(); //기본 창프레임 을 생성
		contanPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4, 2));
		jpbtnpanel1 = new JPanel(new FlowLayout());
		jpbtnpanel2 = new JPanel(new FlowLayout());
		jptextarea = new JPanel(new FlowLayout()); // 기본 Bordered 레이아웃
		
		textHakbun = new JTextField(15);
		textName = new JTextField(15);
		String[] comboList = {"경영정보","컴퓨터공학","그래픽디자인","음악과","심리학과"};
		comboBox = new JComboBox<String>(comboList);
		
		textPoint = new JTextField("1000",15);
		
		btnJoin = new JButton("학생가입");
		btnSearch = new JButton("학번조회");
		btnUpdate = new JButton("학생수정");
		btnOutput = new JButton("전채출력");
		btnExpelOutput = new JButton("제적출력");
		btnExpel = new JButton("제적처리");
		
		jta = new JTextArea(15,40);
		scroll = new JScrollPane(jta);
		
		jpup.add(new JLabel("학번")); jpup.add(textHakbun);
		jpup.add(new JLabel("이름")); jpup.add(textName);
		jpup.add(new JLabel("전공")); jpup.add(comboBox);
		jpup.add(new JLabel("점수")); jpup.add(textPoint);
		
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
				System.out.println("학번과 점수는 정수로 입력해야합니다");
				return;
			}
			
			if (hakbun != 0 && !name.equals("") && !major.equals("") && point != 0 ) {
				Student newStudents = new Student(hakbun, name, major, point);
				
				students.add(newStudents); // 데이터 입력
				jta.append(newStudents.toString() + "\n"); 
				
				textHakbun.setText("");
				textName.setText("");
				comboBox.setSelectedIndex(0); // 0 번째 선택 
				textPoint.setText("");
				System.out.println(newStudents + "\t회원가입 성공");
			}
			
		} else if(event.getSource() == btnSearch) { //  가지고 조회
			int serchhakbun, idx;
			try {
				serchhakbun = Integer.parseInt(textHakbun.getText());
			} catch (Exception e) {
				System.out.println("학번은 정수로 입력해야합니다");
				return;
			}
			
			for (idx = 0; idx < students.size(); idx++) {				
				if (students.get(idx).getHakbun() == serchhakbun) {
					textName.setText(students.get(idx).getName());
					comboBox.setSelectedItem(students.get(idx).getMajor());
					textPoint.setText("" + students.get(idx).getPoint()); // 가져온 값이 int 라서 문자열로 바꾸어줌
					break;
				}
			}
			
			if (idx == students.size()) {
				textHakbun.setText("없는 학번입니다.");
				textName.setText("");
				comboBox.setSelectedItem(0); // 0번 선택
				textPoint.setText("");
			}
			
		} else if(event.getSource() == btnUpdate) {
			int hakbun, score, idx;

			try {
				hakbun = Integer.parseInt(textHakbun.getText().trim());
				score = Integer.parseInt(textPoint.getText().trim());
			} catch (Exception e) {
				System.out.println("학번과 점수는 정수로 입력해야합니다");
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
			 // 찾는 값이 없어서 반복문에서 idx 가 리스트의 size 만큼 증가했다면. 아래의 코드들을 실행한다.
			if(idx == students.size()) {
				textHakbun.setText("없는 학번입니다.");
				textName.setText("");
				comboBox.setSelectedItem(0); // 0번 선택
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
				System.out.println("학번은 정수만 "); 
				return;
			}
			
			studentSize = students.size(); // 입력된 학생의 수.
			
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
