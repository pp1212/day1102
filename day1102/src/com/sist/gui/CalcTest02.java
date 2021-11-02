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
	
	//계산결과를 출력할 텍스트필드를 맴버변수로 만듬
	JTextField result;
	
	int num1;		//연산을 위한 첫번째 수를 담을 변수
	int num2;		//연산을 위한 두번째 수를 담을 변수
	String op;		//어떤 연산을 할지 담을 변수
	
	
	public CalcTest02() {
		
		result = new JTextField(10);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,4));
		
		//16개의 버튼에 표시될 문자열을 배열에 담는다
		String []arr = {"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0","c","=","/"};
		
		//버튼배열을 선언
		JButton []btn = new JButton[arr.length];
		
		//버튼배열의 수만큼 반복 실행하여 버튼을 생성하여 패널에 담음
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(arr[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		//프레임의 위쪽에 텍스트필드를 담고 가운데에 버튼이 담긴 패널을 담음
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
		
		//눌러진 버튼의 글자를 읽어옴(getActionCommand()->눌러진 버튼의 글자를 읽어오는 메소드)
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			//지금화면에 보이고 있는 숫자를 변수(num1)에 저장
			num1 = Integer.parseInt(result.getText());
			
			//그리고 어떤 연산을 해야할지를 변수(op)에 저장
			op = cmd;
			
			//그리고 화면을 깨끗이 지워줌
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//지금화면에 보이고 있는 숫자를 변수(num2)에 저장
			num2 = Integer.parseInt(result.getText());
			
			//그리고 op 연산자의 종류에 따라 num1과 num2를 해당 연산을 수행하여 result에 출력
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
			//지금화면에 보이고 있는 숫자를 지움
			result.setText("");
		}else {
			//눌러진 버튼의 글자를 텍스트필드에 계속 누적하여 출력
			result.setText(result.getText() + cmd );
		}
		
		
	}

}
