package ch.scrt;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) {
		try {
			System.setProperty("org.apache.commons.collections.enableUnsafeSerialization", "true");
			System.out.println("Server ready");
			WizardAPIImpl w = new WizardAPIImpl();
			System.out.println("Server ready2");
			LocateRegistry.createRegistry(2020);
			Naming.bind("rmi://localhost:2020/Wizard", w);
			System.out.println("Server ready3");
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}
}
