package rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Client {

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Echo e = (Echo)Naming.lookup("echo");
		Adder a = (Adder)Naming.lookup("adder");
		
		System.out.println(e.echo("Hallo"));
		System.out.println(a.add(15, 6));

	}

}
