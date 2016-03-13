package extras;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Xylo extends Remote{

	public String play() throws RemoteException;

}
