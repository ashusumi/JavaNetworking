package Code;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * this Socket is used to listen on given port in order to accept the incoming connectionu must call the 
 * ServerSocket.accept() method which behaves likes an ordinary java socket  
 * @url:--https://jenkov.com/tutorials/java-networking/server-sockets.html
 */

public class ServerSocketEx {
	public static void main(String[] args) {
		try {

			ServerSocket serverSocket = new ServerSocket(9000);
			boolean isStoped = false;

			while (!isStoped) {
				Socket cln = serverSocket.accept();
				InputStream inputStream = cln.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println("Message recieved :" + line);
				}
				cln.close();
				bufferedReader.close();
			}
			serverSocket.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
