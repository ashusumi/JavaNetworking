package Code;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketEx {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			String a;

			do {
				System.out.println("What's your message (type 'bye' to exit):");
				a = scanner.nextLine();

				Socket socket = new Socket("192.168.100.19", 9000);
				OutputStream outputStream = socket.getOutputStream();
				outputStream.write(a.getBytes());

				// Flush and close the output stream, but keep the socket open
				outputStream.flush();
				outputStream.close();
				socket.close();
			} while (!a.equals("bye"));

			scanner.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
