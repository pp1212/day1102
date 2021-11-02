package com.sist.echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPChatServer {

	//UDP방식으로 데이터를 주고받기 위한 DatagramSocket과 DatagramPacket을 맴버변수로 선언
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPChatServer() {
		try {
			socket = new DatagramSocket(9005);
			
			//클라이언트로부터 수신되는 데이터를 담기 위한 byte의 배열과 패킷 생성
			byte []data = new byte[100];
			packet = new DatagramPacket(data, data.length);
			
			//무한 대기 상태로 클라이언트가 보내온 데이터를 그대로 메아리 하도록 함
			while(true) {
				
				//클라이언트로부터 데이터를 수신
				//받아올 떄는 보낸측의 InetAddress가 담겨 있음
				socket.receive(packet);
				
				//클라이언트가 보내온 데이터를 출력
				String msg = new String(data);
				System.out.println("수신된데이터:"+msg.trim());
				
				//패킷안에 담긴 보내온측의 InetAddress를 확인
				InetAddress addr = packet.getAddress();
				System.out.println("보내온측의 주소:"+addr);
				
				//그 패킷을 그대로 메아리
				socket.send(packet);
				
				//다음 데이터를 수신하도록 배열을 깨끗이 비워줌
				Arrays.fill(data,(byte)0);
				
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChatServer();
		
	}

}
