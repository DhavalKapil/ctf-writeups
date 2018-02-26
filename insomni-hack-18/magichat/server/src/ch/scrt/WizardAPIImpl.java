package ch.scrt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import ch.scrt.model.Hat;

public class WizardAPIImpl extends UnicastRemoteObject implements WizardAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1689583531382468090L;

	protected WizardAPIImpl() throws RemoteException {
		super();
	}

	@Override
	public String message(int var1) throws RemoteException {
		return "SERVER_MESSAGE";
	}

	@Override
	public Hat getMagicHat() throws RemoteException {
		return new Hat();
	}

	@Override
	public Pair<String, Hat> castASpell(Hat var1) throws RemoteException {
		return null;
	}

}
