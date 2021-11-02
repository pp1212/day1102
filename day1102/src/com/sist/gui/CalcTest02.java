package com.sist.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest02 extends JFrame implements ActionListener{
	
	//������� ����� �ؽ�Ʈ�ʵ带 �ɹ������� ����
	JTextField result;
	
	int num1;		//������ ���� ù��° ���� ���� ����
	int num2;		//������ ���� �ι�° ���� ���� ����
	String op;		//� ������ ���� ���� ����
	
	
	public CalcTest02() {
		
		result = new JTextField(10);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,4));
		
		//16���� ��ư�� ǥ�õ� ���ڿ��� �迭�� ��´�
		String []arr = {"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0","c","=","/"};
		
		//��ư�迭�� ����
		JButton []btn = new JButton[arr.length];
		
		//��ư�迭�� ����ŭ �ݺ� �����Ͽ� ��ư�� �����Ͽ� �гο� ����
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(arr[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		//�������� ���ʿ� �ؽ�Ʈ�ʵ带 ��� ����� ��ư�� ��� �г��� ����
		add(result,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);

		
		setSize(300,400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalcTest02();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//������ ��ư�� ���ڸ� �о��(getActionCommand()->������ ��ư�� ���ڸ� �о���� �޼ҵ�)
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num1)�� ����
			num1 = Integer.parseInt(result.getText());
			
			//�׸��� � ������ �ؾ������� ����(op)�� ����
			op = cmd;
			
			//�׸��� ȭ���� ������ ������
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num2)�� ����
			num2 = Integer.parseInt(result.getText());
			
			//�׸��� op �������� ������ ���� num1�� num2�� �ش� ������ �����Ͽ� result�� ���
			if(op == "+") {
				result.setText(num1 + num2 +"");
			}else if(op == "-"){
				result.setText(num1 - num2 +"");
			}else if(op == "*") {
				result.setText(num1 * num2 +"");
			}else if(op == "/"){
				result.setText(num1 / num2 +"");
			}
			
		}else if(cmd.equals("c")) {
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� ����
			result.setText("");
		}else {
			//������ ��ư�� ���ڸ� �ؽ�Ʈ�ʵ忡 ��� �����Ͽ� ���
			result.setText(result.getText() + cmd );
		}
		
		
	}

}
