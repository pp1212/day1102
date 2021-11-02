package com.sist.echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPChatServer {

	//UDP������� �����͸� �ְ�ޱ� ���� DatagramSocket�� DatagramPacket�� �ɹ������� ����
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPChatServer() {
		try {
			socket = new DatagramSocket(9005);
			
			//Ŭ���̾�Ʈ�κ��� ���ŵǴ� �����͸� ��� ���� byte�� �迭�� ��Ŷ ����
			byte []data = new byte[100];
			packet = new DatagramPacket(data, data.length);
			
			//���� ��� ���·� Ŭ���̾�Ʈ�� ������ �����͸� �״�� �޾Ƹ� �ϵ��� ��
			while(true) {
				
				//Ŭ���̾�Ʈ�κ��� �����͸� ����
				//�޾ƿ� ���� �������� InetAddress�� ��� ����
				socket.receive(packet);
				
				//Ŭ���̾�Ʈ�� ������ �����͸� ���
				String msg = new String(data);
				System.out.println("���ŵȵ�����:"+msg.trim());
				
				//��Ŷ�ȿ� ��� ���������� InetAddress�� Ȯ��
				InetAddress addr = packet.getAddress();
				System.out.println("���������� �ּ�:"+addr);
				
				//�� ��Ŷ�� �״�� �޾Ƹ�
				socket.send(packet);
				
				//���� �����͸� �����ϵ��� �迭�� ������ �����
				Arrays.fill(data,(byte)0);
				
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChatServer();
		
	}

}
