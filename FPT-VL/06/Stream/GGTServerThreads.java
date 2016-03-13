package Stream;
import java.io.*;
import java.net.*;

public class GGTServerThreads {

	public static void main(String[] args) {

		// ServerSocket erstellen
		try (ServerSocket server = new ServerSocket(3141);) {
			int connections = 0;
			// Timeout nach 1 Minute
			// server.setSoTimeout(60000);
			while (true) {
				try {
					Socket socket = server.accept();
					connections++;
					new GGTClientThread(connections, socket).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}