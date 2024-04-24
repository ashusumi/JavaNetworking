package Code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketEx {
	public static void main(String[] args) {
		try {
			byte[] buffer = new byte[655];
			InetAddress address = InetAddress.getLocalHost();
			DatagramPacket packets = new DatagramPacket(buffer, buffer.length, address, 9000);
			DatagramSocket datagramSocket = new DatagramSocket();
			System.out.println("sending packects ");
			datagramSocket.send(packets);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
