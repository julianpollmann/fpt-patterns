package url;
import java.net.*;
import java.util.*;
import java.util.regex.MatchResult;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import java.io.*;
import javax.swing.JFrame;

public class WebConnector {

	public static void main(String[] args) throws IOException {
		URL myURL = null;
		try {
			myURL = new URL("http://www.uni-due.de/");
			myURL = new URL("http","www.uni-due.de","/index.html");
			// myURL = new URL("http","www.uni-due.de","");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// gebe Informationen �ber myURL aus
		System.out.println("protocol = " + myURL.getProtocol());
		System.out.println("host = " + myURL.getHost());
		System.out.println("filename = " + myURL.getFile());
		System.out.println("port = " + myURL.getPort());
		System.out.println("default port = " + myURL.getDefaultPort());

		// erzeuge ein URLConnection Objekt
		URLConnection myURLConnection = null;
		try {
			myURLConnection = myURL.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// gebe Header Informationen der myURL-Ressource aus
		System.out.println();
		System.out.println("Header Informationen:");
		System.out.println("Date : " + new Date(myURLConnection.getDate()));
		System.out.println("Last Modified : "
				+ new Date(myURLConnection.getLastModified()));
		System.out
				.println("Content Type : " + myURLConnection.getContentType());
		System.out.println("Content Length : "
				+ myURLConnection.getContentLength());
		System.out.println("Content Encoding : "
				+ myURLConnection.getContentEncoding());
		System.out.println(myURLConnection.getContent().toString());

		// schreibe den Seiten Quelltext der myURL-Ressource in die Datei
		// "quelltext.txt"
		FileWriter fileWriter = null;
		BufferedReader in = null;
		try {
			fileWriter = new FileWriter(new File("quelltext.html"));
			in = new BufferedReader(new InputStreamReader(myURL.openStream()));
			// alternativ
			//in = new BufferedReader(new InputStreamReader(myURL
			//		.openConnection().getInputStream()));
			//in = new BufferedReader(new InputStreamReader((InputStream) myURL
			//		.getContent()));

			String s;
			while ((s = in.readLine()) != null) {
				Scanner sc = new Scanner(s);
				sc.findInLine("<img src=\"([^\"]+)\" ");
				MatchResult result;
				try {
					result = sc.match();
					for (int i = 1; i <= result.groupCount(); i++) {
						String tm = result.group(i);

						if (tm.contains("http") == false) {
							tm = myURLConnection.getURL() + tm;
						}

						System.out.println("die Image Adresse: " + tm);
						WebConnector.showImage(tm);
					}
					sc.close();

				} catch (IllegalStateException e) {
					//e.printStackTrace();
				} finally {
					sc.close();
				}

				fileWriter.write(s + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

	}

	public static void showImage(String url) {

		Image im = null;
		try {
			im = WebConnector.fetchImage(url);
			JFrame f = new JFrame("Das Fenster zur Welt");
			f.setSize(300, 200);

			ShowImage pn = new ShowImage(im);

			f.add(pn);
			f.setVisible(true);
			f.setDefaultCloseOperation(3);

		} catch (IOException e) {
			System.out.println("die Image Adresse wurde falsch ausgelesen");
		}

	}

	public static Image fetchImage(String url) throws IOException {
		URL u = new URL(url);
		Toolkit tk = Toolkit.getDefaultToolkit();
		return tk.createImage((ImageProducer) u.getContent());
	}

}
