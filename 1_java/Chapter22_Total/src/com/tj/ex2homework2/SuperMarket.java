package com.tj.ex2homework2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.tj.ex1homework1.Student;

public class SuperMarket extends JFrame implements ActionListener {
	
	// GUI variable
	private Container containPane;
	private JPanel jpup, jpbtn;
	private JScrollPane JScrollpane;
	private JTextArea jtxtPool;
	private JTextField jtxtTel, jtxtName, jtxtPoint, JtxtAmount;
	private Vector<String> items;
	private JComboBox<String> jcomLevel;
	private JButton jbtnTelSearch, jbtnNameSearch, jbtnPoint;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAlloutput,
					jbtnInsert, jbtnTelupdate, jbtnDelete, jbtnExit;
	
	// DB variavble
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ArrayList<Customer> customer;
	
	public SuperMarket() {
		customer = new ArrayList<Customer>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Window object
		containPane = getContentPane();
		containPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(5, 3));
		jpbtn = new JPanel(new FlowLayout());
		
		jtxtTel = new JTextField(10);
		jtxtName = new JTextField(10);
		jtxtPoint = new JTextField(10);
		JtxtAmount = new JTextField(10);
		// combo list
		items = new Vector<String>();
		items.add(""); // 0�� �ε���
		try {
			String combosql = "SELECT GRADE FROM CGRADE";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(combosql);
			
			while (rs.next()) {
				items.add(rs.getString("grade"));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "Driver");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL");
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			} catch (SQLException e) { System.out.println(e.getMessage());}
		}
		jcomLevel = new JComboBox<String>(items); // �޺��ڽ�
		
		jbtnTelSearch = new JButton("�� �� 4�ڸ� �˻�");
		jbtnNameSearch = new JButton("�� �̸� �˻�");
		jbtnPoint = new JButton("����Ʈ�θ�  ����");
		
		jbtnBuy = new JButton("��ǰ ����");
		jbtnLevelOutput = new JButton("��޺� ���");
		jbtnAlloutput = new JButton("��ü���");
		jbtnInsert = new JButton("ȸ������");
		jbtnTelupdate = new JButton("��ȣ����");
		jbtnDelete = new JButton("ȸ��Ż��");
		jbtnExit = new JButton("������");
		
		jpup.add(new JLabel("����ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("���̸�", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(JtxtAmount);
		jpup.add(new JLabel("", (int) CENTER_ALIGNMENT));
		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		
		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAlloutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelupdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		
		containPane.add(jpup);
		containPane.add(jpbtn);
		jtxtPool = new JTextArea(10, 50);
		JScrollpane = new JScrollPane(jtxtPool);
		containPane.add(JScrollpane);
		
		setSize(new Dimension(700, 450));
		setLocation(400, 300);
		setVisible(true);
		
		// ������
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAlloutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelupdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);
	}
	
	public SuperMarket(String title){
		this();
		setTitle(title);
	}
	
	public static void main(String[] args) {
		new SuperMarket("���۸��� ���α׷�");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtnTelSearch) { // ����ó 4�ڸ� �˻�
			
			try {
				String selectSql = "SELECT C.*, G.GRADE " + 
								   "FROM CUSTOMER C, CGRADE G " + 
								   "WHERE C.GNO = G.GNO AND SUBSTR(CTEL, -4) = ?";

				pstmt = conn.prepareStatement(selectSql);
				pstmt.setString(1, jtxtTel.getText());
				rs = pstmt.executeQuery();
				
				customer.clear();
				
				if(rs.next()) {
					
					do {
						int cno = rs.getInt("cno");
						String ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int point = rs.getInt("point");
						int buy = rs.getInt("buy");
						String grade = rs.getString("grade");
						
						customer.add(new Customer(cno, ctel, cname, point, buy, grade));
					} while (rs.next());
					
				} else {
					jtxtPool.setText("�˻� ����� �����ϴ�.");
				}
				
				jtxtPool.setText("[��ID]   [������ó]   [����]   [����Ʈ]   [�����Ѿ�]   [�����] \n");
				jtxtPool.append("==================================================================================\n");
				
				if (customer.size() != 0) {
					for (Customer ct : customer) {
						jtxtPool.append(ct.toString());
					}
				} else {
					jtxtPool.append("����� ����� �����ϴ�.");
				}
					
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (SQLException e1) {	System.out.println(e1.getMessage()); }
			}
			
		} else if (e.getSource() == jbtnNameSearch) {// �̸��˻�
			
			
			
		} else if (e.getSource() == jbtnPoint) {// ����Ʈ ����
			
		} else if (e.getSource() == jbtnBuy) {// ����
			
		} else if (e.getSource() == jbtnLevelOutput) {// ��޺� ���
			
		} else if (e.getSource() == jbtnAlloutput) {// ��ü ���
			
		} else if (e.getSource() == jbtnInsert) {// ȸ������
			
		} else if (e.getSource() == jbtnTelupdate) {// ��ȣ����
			
		} else if (e.getSource() == jbtnDelete) {// ȸ��Ż��
			
		} else if (e.getSource() == jbtnExit) {// ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}
