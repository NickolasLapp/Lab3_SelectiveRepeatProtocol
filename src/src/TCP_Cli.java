package src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class TCP_Cli {

	private DatagramSocket senderSocket;
	private InetAddress IPAddress;
	private int mySocket, targetSocket;

	public static void main (String [] args) {
		byte[] data = new String("Hello World").getBytes();
		System.out.println(data);
		
		TCP_Cli myCli = new TCP_Cli();
		if(myCli.initSocket("Localhost",  11111, 11112) != 0) {
			System.out.println("Error intializing Socket.");
			return;
		}
		
		if(myCli.sendDatagram(data) != 0)
		{
			System.out.println("Error sending datagram.");
			return;
		}
	}
	
	private int sendDatagram(byte[] data) {
		DatagramPacket sendPkt = new DatagramPacket(data, data.length,
				this.IPAddress, this.targetSocket);
		try {
			senderSocket.send(sendPkt);
		} catch (IOException e) {
			e.printStackTrace();
			return -1; /* Failure */
		}
		return 0;
	}

	private int initSocket(String host, int mySocket, int targetSocket) {
		this.mySocket = mySocket;
		this.targetSocket = targetSocket;
		
		try {
			this.senderSocket = new DatagramSocket(this.mySocket);
		} catch (Exception e) {
			e.printStackTrace();
			return -1; /* Failure */
		}
		try {
			this.IPAddress = InetAddress.getByName(host);
		}catch (Exception e) {
			e.printStackTrace();
			return -1; /* Failure */
		}
		return 0;
	}


}
