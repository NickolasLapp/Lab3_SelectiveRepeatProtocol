package cli;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class TCP_Cli {

	private DatagramSocket senderSocket;
	private InetAddress IPAddress;
	private int mySocket, targetSocket;
	private String host;
	
	public TCP_Cli(int mySocket, int targetSocket, String host) {
		this.mySocket = mySocket;
		this.targetSocket = targetSocket;
		this.host = host;
	}
	
	public int sendDatagram(byte[] data) {
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

	public int initSocket() {
		try {
			this.senderSocket = new DatagramSocket(this.mySocket);
		} catch (Exception e) {
			e.printStackTrace();
			return -1; /* Failure */
		}
		try {
			this.IPAddress = InetAddress.getByName(this.host);
		}catch (Exception e) {
			e.printStackTrace();
			return -1; /* Failure */
		}
		return 0;
	}

}
