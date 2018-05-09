package com.tj.ex06swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex0Frame extends JFrame implements ActionListener{ // swing frame 상속한다.
	
//	private Container contanPane;
	private JPanel panel; // 컨테이너 역활을 할 패널
	private JLabel jlabel;
	private JButton jbtn;
	
	public Ex0Frame(String title) {
		super(title);
		// 컨테이너 받아온다.
		panel = (JPanel)getContentPane(); // Jframe 이기때문에 Jpanel 로 형변환해서 대입.받드시 컨테이너로 넣어야한다.
		panel.setLayout(new FlowLayout());
		// lable btn 객체를 만들어 컨테이너에다가 add
		
		jlabel = new JLabel("즐거운 화요일", (int) CENTER_ALIGNMENT);
		jbtn = new JButton("종료");
		
		panel.add(jlabel); panel.add(jbtn);
		
		jlabel.setPreferredSize(new Dimension(250, 200)); // 컴포넌트의 사이즈를 정한다.
		jbtn.setPreferredSize(new Dimension(200, 200)); 
		// setVisuble() true setsize.
		setVisible(true);
		pack();
		setSize(new Dimension(500, 250));
		// 이벤트 처리 작업 추가 
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 윈도우 기본 닫기 버튼 이벤트 처리
		
		jbtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
}
