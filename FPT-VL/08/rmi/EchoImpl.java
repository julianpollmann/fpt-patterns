package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class EchoImpl extends UnicastRemoteObject implements Echo {

	private static final long serialVersionUID = 2L;

	protected EchoImpl() throws RemoteException {
		super();
	}

	public String echo(String s) throws RemoteException {
		return s;
	}

}
