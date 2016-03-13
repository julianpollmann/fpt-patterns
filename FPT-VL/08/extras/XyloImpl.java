package extras;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class XyloImpl extends UnicastRemoteObject implements Xylo {

	private static final long serialVersionUID = -6786850150920102833L;

	protected XyloImpl() throws RemoteException {
		super();
	}

	@Override
	public String play() throws RemoteException {
		return "Tüdü, tüdüdeldüüü";
	}

}
