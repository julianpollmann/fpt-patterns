package Datagram;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Scanner;

public class DatagramServer {

	public static void main(String[] args) {
		// Socket erstellen unter dem der Server erreichbar ist
		try (DatagramSocket socket =  new DatagramSocket(3431);){
			while (true) {

				// Neues Paket anlegen mit (data, data.length)
				DatagramPacket packet = new DatagramPacket(new byte[5], 5);
				// Auf Paket warten
				try {
					socket.receive(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}

				// Daten auslesen
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				int len = packet.getLength();
				byte[] data = packet.getData();

				System.out.printf(
						"Anfrage von %s vom Port %d mit der Länge %d:%n%s%n",
						address, port, len, new String(data, 0, len));

				// Nutzdaten in ein Stringobjekt übergeben
				String da = new String(packet.getData());
				// Kommandos sollen durch : getrennt werden
				try (Scanner sc = new Scanner(da).useDelimiter(":")) {
					// Erstes Kommando filtern
					String keyword = sc.next();

					if (keyword.equals("DATE")) {

						Date dt = new Date();
						byte[] myDate =  dt.toString().getBytes();

						// Paket mit neuen Daten (Datum) als Antwort vorbereiten
						packet = new DatagramPacket(myDate, myDate.length,
								address, port);
						// Paket versenden
						socket.send(packet);

					} else {
						byte[] myDate = null;
						myDate = new String("Command unknown").getBytes();

						// Paket mit Information, dass das Schlüsselwort
						// ungültig
						// ist
						// als Antwort vorbereiten
						packet = new DatagramPacket(myDate, myDate.length,
								address, port);
						// Paket versenden
						socket.send(packet);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
