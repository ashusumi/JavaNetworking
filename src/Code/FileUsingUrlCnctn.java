package Code;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileUsingUrlCnctn {
	public static void main(String[] args) {
		try {
			// Using the file: protocol to access local files
			URL url = new URL("file:///C:/Users/Nimap/Desktop/ddd.txt");
			URLConnection connection = url.openConnection();
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			int data = inputStream.read();
			while (data != -1) {
				System.out.print((char) data); // Changed to print for better readability
				data = inputStream.read();
			}
			inputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
