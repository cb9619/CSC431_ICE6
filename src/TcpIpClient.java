import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient
{
	public static void main(String[] args)
	{
		try {
			String serverIp = "127.0.0.1";

			// Create sockety and request connection.
			System.out.println("Connecting server. Server IP: " + serverIp);
			Socket socket = new Socket(serverIp, 7777);

			// Obtained inputstream of scoket.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);

			// Print out data from socket.
			System.out.println("Message from server: " + dis.readUTF());
			System.out.println("Close connection.");

			dis.close();
			socket.close();
			System.out.println("Connection has been close.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
