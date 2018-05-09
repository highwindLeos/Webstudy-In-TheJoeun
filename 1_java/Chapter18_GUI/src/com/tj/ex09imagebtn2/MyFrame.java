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

	private Container contanPane; // 컨테이너를 받아올 변수
	private JPanel jPanel1 , jPanel2;
	private JTextField jtextName, jtextTel, jtextAge;
	private ImageIcon icon1, icon2; // 명령 버튼에 들어간 imageicon
	private JButton btnIn, btnOut;
	
	private ArrayList<Person> arrayList = new ArrayList<Person>();
	
	private String name;
	private String tel;
	private int age;
	
	public MyFrame(String title) {
		super(title); // JFrame 의 생성자
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contanPane = getContentPane(); // 컨테이너를 가져온다.
		jPanel1 = new JPanel(new GridLayout(3, 2)); 
		jPanel2 = new JPanel(new GridLayout(1, 2)); // 패널을 생성

		jtextName = new JTextField();
		jtextTel = new JTextField();
		jtextAge = new JTextField(); // textfeild 생성

		icon1 = new ImageIcon("src/mac-mini.png");
		icon2 = new ImageIcon("src/elephpant.gif");
		
		btnIn = new JButton("입력", icon1); // 이미지 아이콘도 넣는다.
		btnOut = new JButton("출력", icon2); // 이미지 아이콘도 넣는다.

		jPanel1.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextName);
		jPanel1.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextTel);
		jPanel1.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextAge);
		
		jPanel2.add(btnIn);
		jPanel2.add(btnOut);

		contanPane.add(jPanel1, BorderLayout.CENTER);
		contanPane.add(jPanel2, BorderLayout.SOUTH); // 메인 컨테이너에 요소 두개를 붙인다.

		setVisible(true);
		setBounds(100, 100, 300, 200); // location 과 size 를 같이 잡아준다.

		btnIn.addActionListener(this); // 버튼 이벤트를 처리한다.
		btnOut.addActionListener(this); // 버튼 이벤트를 처리한다.

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnIn) {
			
			 name = jtextName.getText().trim();  // trim() 좌우 공백을 제거
			 tel = jtextTel.getText().trim();
			 
			 try {
				 age = Integer.parseInt(jtextAge.getText().trim());
			 } catch (Exception e) {
				 age = 0;
			 }
			 
			if(!jtextName.equals("") && !jtextTel.equals("") && age != 0) {// 빈칸이 아닐때만 입력함.
				arrayList.add(new Person(name, tel, age));
				
				jtextName.setText("");
				jtextTel.setText("");
				jtextAge.setText(""); // 버튼을 누르면 빈칸으로 만들어준다.
			} 

		} else if (event.getSource() == btnOut) {
			
			for(Person pt : arrayList) {
				System.out.println(pt.toString());
			}// 콘솔에 출력
			
			Writer writer = null;
			File file = new File("src/person.txt");
			
			try {
				writer = new FileWriter(file, true); // 파일에 추가하게 처리
				
				for (Person pt : arrayList) {
					writer.write(pt.toString() + "\r\n"); // 파일에 쓴다.
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
