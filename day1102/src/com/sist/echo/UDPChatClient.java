package com.sist.echo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener{

	//UDP방식으로 데이터를 주고받기 위한 DatagramSocket과 DatagramPacket을 맴버변수로 선언
	DatagramSocket socket;
	DatagramPacket packet;
	
	
	//대화내용을 표시하기 위한 텍스트에리어를 맴버변수로 선언
	JTextArea jta;
	
	//대화내용을 입력하기 위한 텍스트필드를 맴버변수로 선언
	JTextField jtf;
	
	
	public UDPChatClient() {
		
		//맴버변수들을 생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//전송을 위한 버튼 생성
		JButton btn = new JButton("전송");
		
		//텍스트필드와 버튼을 담을 패널 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//텍스트에리어에 스크롤을 표현하는 스크롤팬 생성
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데에 텍스트에리어를 감싸고 있는 스크롤팬을 담기
		add(jsp,BorderLayout.CENTER);
		
		//프레임의 아래에 텍스트필드와 버튼을 담고 있는 패널 담기
		add(p,BorderLayout.SOUTH);
		
		//프레임의 크기 설정
		setSize(800,600);
		
		//화면에 보여주도록 설정
		setVisible(true);
		
		try {
			//데이터를 주고 받기 위한 메소드를 갖고 있는 DatagramSocket 객체 생성
			socket = new DatagramSocket();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		//전송버튼에 이벤트를 등록하여 텍스트필드에 입력한 내용을 서버로 전송하도록 함
		btn.addActionListener(this);
		
		//서버로부터 데이터를 계속하여 수신하기 위한 쓰레드클래스를 inner클래스로 만듬
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte []data = new byte[100];
			public void run() {
				
				//데이터를 수신하기 위한 패킷을 따로 생성
				packet = new DatagramPacket(data, data.length);
				
				//계속하여 서버로부터 데이터를 수신하도록 함
				while(true) {
					try {
						//데이터를 수신하기 위해서는 어떤 클래스의 어떤 메소드를 이용?
						socket.receive(packet);
						
						//서버로부터 수신된 데이터가 있는 배열의 내용을 문자열로 만듬
						String msg = new String(data);
						
						//수신된 문자열을 텍스트에리어에 추가
						jta.append(msg.trim() + "\n");
						
						//다음 데이터 수신을 위하여 배열을 지워줌
						Arrays.fill(data, (byte)0);
						
					}catch (Exception e) {
						System.out.println("예외발생:"+e.getMessage());
					}//end catch
				}//end while
				
			}//end run
		}//end inner클래스
		
		//쓰레드객체를 생성하고 쓰레드 가동
		new Thread(new ClientThread()).start();
		
		
	}//end 생성자
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChatClient();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			//사용자가 입력한 대화내용이 있는 텍스트필드의 문자열을 갖고 옴
			String msg = jtf.getText();
			
			//UDP방식으로 데이터를 보내려면 패킷을 생성해야 함
			//그래서 이 문자열을 byte[] 배열로 만들어야 함
			byte []data = msg.getBytes();
			
			//localhost(ip주소) 목적지의 주소를 갖는 InetAddress
			InetAddress addr = InetAddress.getByName("localhost");
			
			int port = 9005;
			
			//데이터를 보낼 패킷을 생성
			packet = new DatagramPacket(data, data.length, addr ,port);
			
			//
			socket.send(packet);
			
			
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
	}

}
