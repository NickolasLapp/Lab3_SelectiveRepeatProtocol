package serv;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class TCP_Serv {
	private DatagramSocket senderSocket;
	private InetAddress IPAddress;
	private int mySocket, targetSocket;
	private String host;
	
	public TCP_Serv(int mySocket, int targetSocket, String host) {
		this.mySocket = mySocket;
		this.targetSocket = targetSocket;
		this.host = host;
	}
	
	public int initSocket() {
		try {
			this.senderSocket = new DatagramSocket(this.mySocket);
		} catch (SocketException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	public byte[] receiveDatagram() {
		byte[] rcvData = new byte[1024];
		DatagramPacket recvPacket = new DatagramPacket(rcvData, rcvData.length);
		try {
			this.senderSocket.receive(recvPacket);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return rcvData;
	}


	
}
