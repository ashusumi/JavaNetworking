package Code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionEx {
	public static void main(String[] args) {
		try {
			// Ensure the URL includes a protocol and potentially a resource path or port if
			// necessary
			URL url = new URL("http://192.168.100.19"); // Assuming HTTP protocol and default HTTP port
			URLConnection connection = url.openConnection();

			// Buffer the InputStream to improve efficiency
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
