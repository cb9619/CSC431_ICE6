import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer
{
	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;

		try
		{
			/// Create server socket and bind port 7777
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + " Server is read.");

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			System.out.println(getTime() + "Waiting for connection request");
			// Set request wiat time (Execption: SocketTImeoutException)
			serverSocket.setSoTimeout(5 * 1000);

			// Server socket stops execution and waits for connection request from client
			// when client connection request arrives, server creates new socket for
			// communication.
			Socket socket = serverSocket.accept();
			System.out.println(getTime() + " " + " From " + socket.getInetAddress()
				+ ", connection request is coming.");

			// From socket, corresponding port and local server port are obtained.
			System.out.println("getPort() : " + socket.getPort());
			System.out.println("getLocalPort() : " + socket.getLocalPort());

			// Outstream of socket
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);

			// Send data to remoce socket
			dos.writeUTF("[Notice] Test Message from server.");
			System.out.println(getTime() + " Data has been sent.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}


	}
	public static String getTime()
	{
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
