package com.sist.homework;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumber extends JFrame implements ActionListener{

	JTextField guess;
	JTextField hint;
	
	public GuessNumber() {
		guess = new JTextField(15);
		hint = new JTextField("�ʹ� �����ϴ�.");

		setLayout(new FlowLayout());
		
		JPanel p = new JPanel();
		JButton btn01 = new JButton("�ٽ� �ѹ�");
		JButton btn02 = new JButton("����");
		p.add(btn01);
		p.add(btn02);
		
		add(new JLabel("���ڸ� �����Ͻÿ�:"));
		add(guess,BorderLayout.NORTH);
		add(hint,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		
		setTitle("���ڰ���");
		setSize(500,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GuessNumber();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		if(cmd.equals("�ٽ� �ѹ�")) {
			
		}else if(cmd.equals("����")){
			
		}
	}

}
