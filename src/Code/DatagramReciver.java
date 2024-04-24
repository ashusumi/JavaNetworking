package Code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class DatagramReciver {
	public static void main(String[] args) {
		try {

			DatagramSocket datagramSocket = new DatagramSocket(9000);
			byte[] buffer = new byte[10];
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(datagramPacket);
			System.out.println(Arrays.toString(buffer));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
