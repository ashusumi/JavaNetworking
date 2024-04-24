package Code;

/*
 * https://jenkov.com/tutorials/java-networking/server-sockets.html
 * ServerSocket
 * this socket that listen on given port 
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(90);
			System.out.println("Server started. Waiting for client connection...");

			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client connected.");

				Thread clientThread = new Thread(new ClientHandler(clientSocket));
				clientThread.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static class ClientHandler implements Runnable {
		private Socket clientSocket;

		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println("Received from client: " + line);
				}

				reader.close();
				clientSocket.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
