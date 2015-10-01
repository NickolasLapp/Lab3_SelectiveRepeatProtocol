package cli;

public class CliDriver {
	public static void main (String [] args) {
		byte[] data = new String("Hello World").getBytes();
		System.out.println(data);
		
		TCP_Cli myCli = new TCP_Cli(11111, 11112, "localhost");
		if(myCli.initSocket() != 0)
		{
			System.out.println("Error Initializing ");
			return;
		}
		
		if(myCli.sendDatagram(data) != 0)
		{
			System.out.println("Error sending datagram.");
			return;
		}
	}
}
