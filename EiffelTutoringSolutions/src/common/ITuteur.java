package common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface ITuteur extends Remote {
	String getName() throws RemoteException;
	List<String> getDomainesExpertise() throws RemoteException;
	Map<Integer, Map<Double, Double>> getCalendrier() throws RemoteException;
	double getTarifHoraire() throws RemoteException;
	boolean ajouterRendezVous(IRendezVous rdv) throws RemoteException;
	List<IRendezVous> getRDV() throws RemoteException;
	boolean faireRDV(IRendezVous rdv)throws RemoteException;
}