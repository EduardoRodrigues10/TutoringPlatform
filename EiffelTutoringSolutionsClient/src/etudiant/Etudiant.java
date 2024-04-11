package etudiant;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import common.IEtudiant;
import common.IRendezVous;

public class Etudiant extends UnicastRemoteObject implements IEtudiant {
	
	private String name;
	private List<IRendezVous> rendezVous;
	private boolean isInterne;

	public Etudiant() throws RemoteException {
		super();
		rendezVous = new ArrayList<IRendezVous>();
	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}
	
	public void setName(String name) throws RemoteException {
		this.name = name;
	}
	
	@Override
	public void ajouterRendezVous(IRendezVous rdv) throws RemoteException {
		rendezVous.add(rdv);
	}

	@Override
	public List<IRendezVous> getRDV() {
		return rendezVous;
	}
	
	@Override
	public boolean faireRDV(IRendezVous rdv) throws RemoteException {
		for (IRendezVous rdvPrevu : rendezVous) {
			if (rdvPrevu.getJour().equals(rdv.getJour()) && rdvPrevu.getHeureDebut() == rdv.getHeureDebut() && rdvPrevu.getHeureFin() == rdv.getHeureFin()) {
				rendezVous.remove(rdvPrevu);
				return true;
			}
		}
		return false;
	}

	@Override
	public void notifyRDV(IRendezVous rdv) throws RemoteException {
		rendezVous.add(rdv);
		System.out.println("Le rendez vous en attente entre " + name + " et " + rdv.getTuteur().getName() + " a ete planifier");
	}

	@Override
	public boolean getIsInterne() throws RemoteException {
		return isInterne;
	}
	
	public void setIsInterne(boolean isInterne) throws RemoteException {
		this.isInterne = isInterne;
	}

}
