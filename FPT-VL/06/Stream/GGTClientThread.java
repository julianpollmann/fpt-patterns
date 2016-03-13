package Stream;
import java.io.*;
import java.net.*;

class GGTClientThread extends Thread {
	private int name;
	private Socket socket;

	public GGTClientThread(int name, Socket socket) {
		this.name = name;
		this.socket = socket;
	}

	public void run() {
		String msg = "EchoServer: Verbindung " + name;
		System.out.println(msg + " hergestellt");
		try (InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream()) {
			try {
				sleep((long) (Math.random() * 10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int a = in.read();
			int b = in.read();

			int result = ggT(a, b);

			// Ergebnis auf Outputstream schreiben
			out.write(result);
			out.flush();

			System.out.println("Verbindung " + name + " wird beendet");

			socket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
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
