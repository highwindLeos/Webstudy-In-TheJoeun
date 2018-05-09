package com.tj.ex8homework2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIMain extends JFrame implements ActionListener {
	// GUI Variable
	private Container containPane;
	private JPanel jpup, jp1, jp2;
	private JScrollPane scrollpane;
	private JTextArea txtPool;
	private JTextField txtNo, txtName, txtscore;
	private JComboBox<String> comMajor;
	private Vector<String> items;
	private JButton btnNoSearch, btnNameSearch, btnMajorSearch;
	private JButton btnInput, btnUpdate, btnStudentOut;
	private JButton btnExpel, btnExit, btnExpelOut;
	
	// DB variable
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// ArrayList<Student> student;
	public GUIMain() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		containPane = getContentPane();
		containPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(3, 4));
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		
		btnNoSearch = new JButton("학번검색");
		btnNameSearch = new JButton("이름검색");
		btnMajorSearch = new JButton("전공검색");
		
		// table에서 백터를 가져와서 combobox 의 요소로 넣는 코드
		items = new Vector<String>();
		items.add("");
		comMajor = new JComboBox<String>(items);
		
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		btnExpelOut = new JButton("제적자출력");
		
		txtPool = new JTextArea(7, 40);
		scrollpane = new JScrollPane(txtPool);
		
		txtNo = new JTextField();
		txtName = new JTextField();
		txtscore = new JTextField();
		
		jpup.add(new JLabel("학번"), (int) CENTER_ALIGNMENT);
		jpup.add(txtNo);
		jpup.add(btnNoSearch);
		jpup.add(new JLabel("이름"), (int) CENTER_ALIGNMENT);
		jpup.add(txtName);
		jpup.add(btnNameSearch);
		jpup.add(new JLabel("전공"), (int) CENTER_ALIGNMENT);
		jpup.add(comMajor);
		jpup.add(btnMajorSearch);
		jpup.add(new JLabel("점수"), (int) CENTER_ALIGNMENT);
		jpup.add(txtscore);
		//jpup.add(new JLabel(""), (int) CENTER_ALIGNMENT);

		
		jp1.add(btnInput);
		jp1.add(btnUpdate);
		jp1.add(btnStudentOut);
		
		jp2.add(btnExpel);
		jp2.add(btnExpelOut);
		jp2.add(btnExit);
		
		containPane.add(jpup);
		containPane.add(jp1);
		containPane.add(jp2);
		containPane.add(scrollpane);
		
		setSize(new Dimension(500, 400));
		setLocation(400, 300);
		setVisible(true);
		
		btnNoSearch.addActionListener(this);
		btnNameSearch.addActionListener(this);
		btnMajorSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExit.addActionListener(this);

	}
	
	public GUIMain(String title){
		this();
		setTitle(title);
	}
	
	public static void main(String[] args) {
		new GUIMain("학생관리");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNoSearch) {// 학번검색
			
		} else if(e.getSource() == btnNameSearch) {// 이름검색
			
		} else if(e.getSource() == btnMajorSearch) {// 학과검색
			
		} else if(e.getSource() == btnInput) {// 학생정보 입력
			
		} else if(e.getSource() == btnUpdate) {// 학생정보 수정
			
		} else if(e.getSource() == btnStudentOut) {// 학생정보 출력
			
		} else if(e.getSource() == btnExpel) {// 제적처리
			
		} else if(e.getSource() == btnExpelOut) {// 제적자 출력
			
		} else if(e.getSource() == btnExit) {// 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}

}
