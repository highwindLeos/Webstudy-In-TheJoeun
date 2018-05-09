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
		
		btnNoSearch = new JButton("�й��˻�");
		btnNameSearch = new JButton("�̸��˻�");
		btnMajorSearch = new JButton("�����˻�");
		
		// table���� ���͸� �����ͼ� combobox �� ��ҷ� �ִ� �ڵ�
		items = new Vector<String>();
		items.add("");
		comMajor = new JComboBox<String>(items);
		
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		btnExpelOut = new JButton("���������");
		
		txtPool = new JTextArea(7, 40);
		scrollpane = new JScrollPane(txtPool);
		
		txtNo = new JTextField();
		txtName = new JTextField();
		txtscore = new JTextField();
		
		jpup.add(new JLabel("�й�"), (int) CENTER_ALIGNMENT);
		jpup.add(txtNo);
		jpup.add(btnNoSearch);
		jpup.add(new JLabel("�̸�"), (int) CENTER_ALIGNMENT);
		jpup.add(txtName);
		jpup.add(btnNameSearch);
		jpup.add(new JLabel("����"), (int) CENTER_ALIGNMENT);
		jpup.add(comMajor);
		jpup.add(btnMajorSearch);
		jpup.add(new JLabel("����"), (int) CENTER_ALIGNMENT);
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
		new GUIMain("�л�����");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNoSearch) {// �й��˻�
			
		} else if(e.getSource() == btnNameSearch) {// �̸��˻�
			
		} else if(e.getSource() == btnMajorSearch) {// �а��˻�
			
		} else if(e.getSource() == btnInput) {// �л����� �Է�
			
		} else if(e.getSource() == btnUpdate) {// �л����� ����
			
		} else if(e.getSource() == btnStudentOut) {// �л����� ���
			
		} else if(e.getSource() == btnExpel) {// ����ó��
			
		} else if(e.getSource() == btnExpelOut) {// ������ ���
			
		} else if(e.getSource() == btnExit) {// ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}

}
