package extras;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class XyloPlayer {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		Xylo xylofon = (Xylo) Naming.lookup("xylophon");
		System.out.println(xylofon.play());
	}
}
