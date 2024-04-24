package Code;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionEx {
	public static void main(String[] args) {
		try {
			URL url = new URL("192.168.100.19");
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();
			int data = inputStream.read();
			while (data != -1) {
				System.out.println((char) data);
				data = inputStream.read();
			}
			inputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
