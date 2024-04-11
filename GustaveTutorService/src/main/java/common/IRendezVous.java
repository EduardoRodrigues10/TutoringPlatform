package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRendezVous extends Remote {
	IEtudiant getEtudiant() throws RemoteException;
	ITuteur getTuteur() throws RemoteException;
	Integer getJour() throws RemoteException;
	double getHeureDebut() throws RemoteException;
	double getHeureFin() throws RemoteException;
}
