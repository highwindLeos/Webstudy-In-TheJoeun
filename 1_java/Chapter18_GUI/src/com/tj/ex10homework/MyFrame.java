package com.tj.ex10homework;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MyFrame extends JFrame implements ActionListener{
	
	private Container contenPane; // 컨테이너를 받아올 변수
	private JPanel    jpUp, jpDown;      
	private JTextField jtxtName, jtxtTel, jtxtAge;
	private JButton btnInput, btnOut;
	private ArrayList<Person> person;
	
	public MyFrame(String title) {
		super(title);
		person = new ArrayList<Person>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contenPane = getContentPane();
		jpUp = new JPanel(new GridLayout(3, 2));
		jpDown = new JPanel(new FlowLayout());
		
		jtxtName = new JTextField();
		jtxtTel  = new JTextField();
		jtxtAge  = new JTextField();
		
		ImageIcon icon1 = new ImageIcon("src/elephpant.gif");
		btnInput = new JButton("입력", icon1);
		ImageIcon icon2 = new ImageIcon("src/icon.png");
		btnOut = new JButton("출력", icon2);
		
		jpUp.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtName);
		jpUp.add(new JLabel("전화", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtTel);
		jpUp.add(new JLabel("나이", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtAge);
		
		jpDown.add(btnInput); 
		jpDown.add(btnOut);
		
		contenPane.add(jpUp, BorderLayout.CENTER);
		contenPane.add(jpDown, BorderLayout.SOUTH);
		
		setBounds(100, 100, 400, 200);
		setVisible(true);
		
		btnInput.addActionListener(this);
		btnOut.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) {
			String name, tel; int age;
			name = jtxtName.getText().trim();
			tel  = jtxtTel.getText().trim();
			try {
				age = Integer.parseInt(jtxtAge.getText().trim());
			}catch (Exception ex) {
				age = 0;
			}
			if(!name.equals("") && !tel.equals("") && age !=0) {
				person.add(new Person(name, tel, age));
				jtxtName.setText("");
				jtxtTel.setText("");
				jtxtAge.setText("");
			}
		} else if(e.getSource()==btnOut){
			
			for(Person p : person) {
				System.out.println(p);
			}
			
			Writer writer=null;
			try {
				writer = new FileWriter("homework.txt");
				for(Person p : person) {
					writer.write(p.toString());
				}
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if(writer!=null) writer.close();
				}catch (Exception e1) { }
			}// try-catch
		}//if
	}//actionPerformed
}//class
