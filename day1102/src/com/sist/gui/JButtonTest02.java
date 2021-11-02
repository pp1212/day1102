package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {
	
	public JButtonTest02() {
		
		//버튼을 생성하여 창에 담아 봄
		JButton btn01 = new JButton("버튼1");
		JButton btn02 = new JButton("버튼2");
		
		add(btn01);
		add(btn02);
		
		
		//창을 만들었지만 창이 화면에 보이지는 않음
		//보이게 하려면 창의 가로,세로 길이를 설정해서 화면에 보이도록 설정해야 함
		//생성자에서 하려면 앞에 "변수명." 안해도 됨
		
		setSize(400,300);
		setVisible(true);
		
		//"창"을 닫을 때 프로그램도 같이 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		

		//우리가 만든 JButtonTest가 곧 JFrame
		//변수이름을 굳이 줄 필요가 없음
		//객체를 생성하기만 해도 좋음
		//JButtonTest02 f = new JButtonTest02();
		new JButtonTest02();
		
		
	}

}
