package Stream;
import java.io.*;
import java.net.*;

public class GGTServer {

	public static void main(String[] args) {

		// ServerSocket erstellen
		try (ServerSocket server = new ServerSocket(3141)) {

			// Timeout nach 1 Minute
			// server.setSoTimeout(60000);
			while (true) {
				try (Socket client = server.accept();
						InputStream in = client.getInputStream();
						OutputStream out = client.getOutputStream()) {

					// Streams erstellen

					// Zahlen einlesen
					int a = in.read();
					int b = in.read();

					int result = ggT(a, b);

					// Ergebnis auf Outputstream schreiben
					out.write(result);
					out.flush();

				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}

	}

	public static int ggT(int a, int b) {

		if (b == 0) {
			return a;
		} else {
			return ggT(b, a % b);
		}

	}
}