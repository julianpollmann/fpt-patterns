package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AdderImpl extends UnicastRemoteObject implements Adder {

	private static final long serialVersionUID = 1L;
	
	public AdderImpl() throws RemoteException {
		super();
	}

	public int add(int a, int b) throws RemoteException {
		return a+b;
	}

}
