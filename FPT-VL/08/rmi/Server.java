package rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {

	/**
	 * @param args
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws RemoteException, MalformedURLException {

		/* if(System.getSecurityManager() == null){
			 System.setSecurityManager(new NullSecurityManager());
		 }		*/
		LocateRegistry.createRegistry(1099);


		Remote adder = new AdderImpl();
		Remote echo = new EchoImpl();
		Naming.rebind("adder", adder);
		Naming.rebind("echo", echo);
		System.out.println("started...");

	}

}
