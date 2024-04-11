package tuteur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.IRendezVous;
import common.ITuteur;

public class Tuteur extends UnicastRemoteObject implements ITuteur {
	
	private String name;
	private List<String> domainesExpertise;
	private Map<Integer, Map<Double, Double>> calendrier;
    private double tarifHoraire;
    private List<IRendezVous> rendezVous;

	public Tuteur() throws RemoteException {
		super();
		rendezVous = new ArrayList<IRendezVous>();
	}
	
	/* Setter & Getter name */
	
	public void setName(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}
	
	/* Setter & Getter domainesExpertise */
	
	public void setDomainesExpertise(List<String> domainesExpertise) throws RemoteException {
		this.domainesExpertise = domainesExpertise;
	}

	@Override
	public List<String> getDomainesExpertise() throws RemoteException {
		return domainesExpertise;
	}
	
	/* Setter & Getter calendrier */
	
    public void setCalendrier(Map<Integer, Map<Double, Double>> calendrier) throws RemoteException {
        this.calendrier = calendrier;
    }
    
    @Override
	public Map<Integer, Map<Double, Double>> getCalendrier() throws RemoteException {
        return calendrier;
    }
    
    /* Setter & Getter tarifHoraire */

    public void setTarifHoraire(double tarifHoraire) throws RemoteException {
        this.tarifHoraire = tarifHoraire;
    }
    
    @Override
    public double getTarifHoraire() throws RemoteException {
        return tarifHoraire;
    }

	@Override
	public boolean ajouterRendezVous(IRendezVous rdv) throws RemoteException {
		for (IRendezVous rdvDejaPrevu : rendezVous) {
			if (rdvDejaPrevu.getJour() == rdv.getJour() && rdvDejaPrevu.getHeureDebut() == rdv.getHeureDebut() && rdvDejaPrevu.getHeureFin() == rdv.getHeureFin()) {
				return false;
			}
		}
		rendezVous.add(rdv);
		return true;
	}
	
	@Override
	public List<IRendezVous> getRDV() {
		return rendezVous;
	}

	@Override
	public boolean faireRDV(IRendezVous rdv) throws RemoteException {
		for (IRendezVous rdvPrevu : rendezVous) {
			if (rdvPrevu.getJour() == rdv.getJour() && rdvPrevu.getHeureDebut() == rdv.getHeureDebut() && rdvPrevu.getHeureFin() == rdv.getHeureFin()) {
				rendezVous.remove(rdvPrevu);
				return true;
			}
		}
		return false;
	}

}