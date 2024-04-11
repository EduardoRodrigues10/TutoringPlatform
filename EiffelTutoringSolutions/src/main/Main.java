package main;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import serveur.Plateforme;

public class Main {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);
		Naming.rebind("plateforme", new Plateforme());
	}
}