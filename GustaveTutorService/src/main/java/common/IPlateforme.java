package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IPlateforme extends Remote {
	List<ITuteur> rechercherToutLesTuteurs() throws RemoteException;
	List<ITuteur> rechercherParNom(String nom) throws RemoteException;
	List<ITuteur> rechercherParTarif(double tarifMax) throws RemoteException;
	List<ITuteur> rechercherParMatiere(String matiere) throws RemoteException;
	List<ITuteur> rechercherParDisponibilite(Integer jour, Double heureDebut, Double heureFin) throws RemoteException;
	Integer prendreRendezVous(IEtudiant etudiant, ITuteur tuteur, Integer jour, Double heureDebut, Double heureFin)
			throws RemoteException;
	void faireRDV(IRendezVous rdv, Integer index) throws RemoteException;
}