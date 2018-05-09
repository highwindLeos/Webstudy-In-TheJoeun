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

	private Container contanPane; // 컨테이너를 받아올 변수
	private JPanel jPanel1;
	private JTextField jtextName, jtextTel, jtextAge;
	private ImageIcon icon; // 명령 버튼에 들어간 imageicon
	private JButton btnOut, btnIn;
	
	private ArrayList<String> text = new ArrayList<String>();

	public ImageButtonFrame(String title) {
		super(title); // JFrame 의 생성자
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contanPane = getContentPane();
		jPanel1 = new JPanel(new GridLayout(3, 2));

		jtextName = new JTextField();
		jtextTel = new JTextField();
		jtextAge = new JTextField();

		icon = new ImageIcon("src/mac-mini.png");
		btnOut = new JButton("출력", icon); // 이미지 아이콘도 넣는다.
		btnIn = new JButton("입력", icon); // 입력버튼

		jPanel1.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextName);
		jPanel1.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextTel);
		jPanel1.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
		jPanel1.add(jtextAge);
		

		contanPane.add(jPanel1, BorderLayout.CENTER);
		contanPane.add(btnIn, BorderLayout.SOUTH);
		contanPane.add(btnOut, BorderLayout.SOUTH); // 메인 컨테이너에 요소 두개를 붙인다.

		setVisible(true);
		setBounds(100, 100, 300, 200); // location 과 size 를 같이 잡아준다.

		btnOut.addActionListener(this); // 버튼 이벤트를 처리한다.

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnOut) {
			System.out.println("[이   름] : " + jtextName.getText() + "\t");
			System.out.println("[연락처] : " + jtextTel.getText() + "\t");
			int age;
			try {
				age = Integer.parseInt(jtextAge.getText()); // 문자열로 입력한 텍스트를 정수로만든다.
			} catch (Exception e) {
				age = 0;
			}
			
			if (age >= 80) {
				System.out.println("나이 : ** 살");
			} else if (age > 0 && age < 80) {
				System.out.println("나이 : " + age + "살");
			} else {
				System.out.println("나이를 잘못 입력하셨네요.");
			}
			// System.out.println("[나이] : " + ((age != 0) ? age + "살" : "나이가 이상해") + "\t");

			jtextName.setText("");
			jtextTel.setText("");
			jtextAge.setText(""); // 버튼을 누르면 빈칸으로 만들어준다.
		}

	}

}
