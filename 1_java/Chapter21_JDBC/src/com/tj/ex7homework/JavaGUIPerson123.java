package com.tj.ex7homework;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JavaGUIPerson123 extends JFrame implements ActionListener{
	
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private JComboBox<String> comJob;
	private Vector<String> items; // combobox ������ ����Ʈ
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea textPool;
	private JScrollPane scrollPane;
	private ImageIcon icon1, icon2;
	
	// DB ������
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ArrayList<Person> person;
	
	public JavaGUIPerson123() {
		person = new ArrayList<Person>();
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �⺻â �ݱ�
		
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(5, 2)); // 5�� 2��
		jpbtn = new JPanel(new FlowLayout());
		
		txtName = new JTextField(20);
		items = new Vector<String>();
		items.add(""); // �󸮽�Ʈ �ϳ� �߰�.
		
		try {//SELECT JNAME FROM JOB;
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			String jobsql = "SELECT JNAME FROM JOB";
			stmt = conn.prepareStatement(jobsql);
			rs = stmt.executeQuery(jobsql);
			
			while(rs.next()) {
				items.add(rs.getString("jname"));
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {}
		} // END SELECT JNAME FROM JOB
		
		comJob = new JComboBox<String>(items);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		
		icon1 = new ImageIcon("src/0417write.gif");
		icon2 = new ImageIcon("src/0418search.gif");
		btnInput = new JButton("�Է�", icon1);
		btnSearch = new JButton("������ ��ȸ", icon2);
		btnOutput = new JButton("��ü ���");
		btnExit = new JButton("����");
		
		textPool = new JTextArea(7, 60);
		scrollPane = new JScrollPane(textPool);
		
		jpup.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(txtMat);
		
		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
	
		setSize(new Dimension(700, 400));
		setLocation(400, 300);
		setVisible(true);
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	
	public JavaGUIPerson123(String title) {
		this();
		setTitle(title);
	}

	public static void main(String[] args) {
		new JavaGUIPerson123("������ ���� ����");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) { 
			// console 1
			String sql = "INSERT INTO PERSON VALUES (SEQ_PERSON.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?)";
			
			try {
				
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, txtName.getText());
				pstmt.setString(2, comJob.getSelectedItem().toString());
				pstmt.setInt(3, Integer.parseInt(txtKor.getText()));
				pstmt.setInt(4, Integer.parseInt(txtEng.getText()));
				pstmt.setInt(5, Integer.parseInt(txtMat.getText()));
				
				int resulte = pstmt.executeUpdate();
				
				System.out.println(resulte > 0 ? "�Է¼���" : "�Է½���");
				
				txtName.setText("");
				comJob.setSelectedIndex(0);
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e1) {}
			}
			
		} else if (e.getSource() == btnSearch) {
			// console 2
			String serachSql = "SELECT ROWNUM||'��' RANK, NAME||'('||ID||'��)' NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
						 	   "FROM (SELECT P.*, JNAME, KOR+ENG+MAT SUM " + 
						 	   "FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = ? ORDER BY SUM DESC)"; 
			
			try {
				
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(serachSql);
				
				pstmt.setString(1, comJob.getSelectedItem().toString());

				rs = pstmt.executeQuery();

				person.clear();

				while (rs.next()) {
					Person p = new Person();
					
					p.setRank(rs.getString("rank"));
					p.setNameId(rs.getString("nameid"));
					p.setJname(rs.getString("jname"));
					p.setKor(rs.getInt("kor"));
					p.setEng(rs.getInt("eng"));
					p.setMat(rs.getInt("mat"));
					p.setSum(rs.getInt("sum"));
					
					person.add(p);
				}
				
				textPool.setText("���\t�̸�(ID)\t����\t����\t����\t����\t���� \n");
				textPool.append("====================================================================================\n");
				if (person.size() != 0) {
					for (Person pt : person) {
						textPool.append(pt.toString() + "\n");
					}
				} else {
					textPool.append("����� ����� �����ϴ�.");
				}
				
				txtName.setText("");
				// comJob.setSelectedIndex(0);
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e1) {}
			}
			
		} else if (e.getSource() == btnOutput) {
			// console 3
			String sql3 = "SELECT ROWNUM||'��' RANK, NAME||'('||ID||'��)' NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
					  	  "FROM (SELECT P.*, JNAME, KOR+ENG+MAT SUM FROM PERSON P, JOB J WHERE P.JNO = J.JNO ORDER BY SUM DESC)";
			try {
				
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(sql3);
				rs = pstmt.executeQuery();
				
				person.clear();

				while (rs.next()) {
					Person p = new Person();
					
					p.setRank(rs.getString("rank"));
					p.setNameId(rs.getString("nameid"));
					p.setJname(rs.getString("jname"));
					p.setKor(rs.getInt("kor"));
					p.setEng(rs.getInt("eng"));
					p.setMat(rs.getInt("mat"));
					p.setSum(rs.getInt("sum"));
					
					person.add(p);
				}
				
				textPool.setText("���\t�̸�(ID)\t����\t����\t����\t����\t���� \n");
				textPool.append("==================================================================================\n");
				if (person.size() != 0) {
					for (Person pt : person) {
						textPool.append(pt.toString() + "\n");
					}
				} else {
					textPool.append("����� ����� �����ϴ�.");
				}
				
			} catch (Exception e1) {
				System.out.println(e1.getMessage() + "����̹�");
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e1) { System.out.println(e1.getMessage()); }
			}
			
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	} // event end
}
