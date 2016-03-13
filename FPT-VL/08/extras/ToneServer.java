package extras;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ToneServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {

		LocateRegistry.createRegistry(1099);

		Remote xylophon = new XyloImpl();
		Naming.rebind("xylophon", xylophon);

		System.out.println("Server läuft");
	}

}
