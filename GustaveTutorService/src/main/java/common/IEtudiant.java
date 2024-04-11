package common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEtudiant extends Remote {
	String getName() throws RemoteException;
	boolean getIsInterne() throws RemoteException;
	void ajouterRendezVous(IRendezVous rdv) throws RemoteException;
	List<IRendezVous> getRDV() throws RemoteException;
	void notifyRDV(IRendezVous rdv) throws RemoteException;
	boolean faireRDV(IRendezVous rdv) throws RemoteException;
}