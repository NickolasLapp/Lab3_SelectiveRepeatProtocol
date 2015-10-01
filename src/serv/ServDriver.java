package serv;

public class ServDriver {
	public static void main (String [] args) {
		byte[] data;
		
		if(args.length != 4) {
			System.out.println("Error: invalid input number.");
			System.out.println("Usage: java srv.ServDriver.jar <<recvPort>> <<sendPort>> <<WindowSz>> <<Packet(s) To Drop (i.e. \"1,4,5\")>>");
			return;
		}
		
		System.out.println("Starting Java Server: recvPort="+args[0]+" sendPort="+args[1]+" WindowSz="+args[2]+" DropPackets="+args[3]);


		TCP_Serv myServ = new TCP_Serv(11112, 11111, "localhost");
		if(myServ.initSocket() != 0)
		{
			System.out.println("Error Initializing ");
			return;
		}
		
		if((data = myServ.receiveDatagram()) == null)
		{
			System.out.println("Error receiving datagram.");
			return;
		} else {
			System.out.println("Received Message: " + new String(data));
		}
	}
}
