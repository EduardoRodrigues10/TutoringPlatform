package etudiantservice;

import java.io.Serializable;
import java.util.Arrays;

import rendezvousservice.RendezVousService;

public class EtudiantService implements Serializable {
	
	private String name;
	private RendezVousService[] rendezVous = new RendezVousService[1];
	private int cursor = 0;
	private boolean isInterne;
	
	public EtudiantService() {
		this.rendezVous = new RendezVousService[1];
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setIsInterne(boolean isInterne) {
		this.isInterne = isInterne;
	}

	public boolean getIsInterne() {
		return isInterne;
	}

	public void ajouterRendezVous(RendezVousService rdv) {
		if (rendezVous.length == cursor) {
			Arrays.copyOf(rendezVous, ((rendezVous.length * 2) + 1));
		}
		rendezVous[cursor] = rdv;
		cursor += 1;
	}

	public RendezVousService[] getRDV() {
		return rendezVous;
	}

	public void notifyRDV(RendezVousService rdv) {
		ajouterRendezVous(rdv);
		System.out.println("Nouveau Rendez-Vous");
	}

	public boolean faireRDV(RendezVousService rdv) {
		for (int i = 0; i < cursor; i++) {
			if (rendezVous[i].getJour() == rdv.getJour() && rendezVous[i].getHeureDebut() == rdv.getHeureDebut() && rendezVous[i].getHeureFin() == rdv.getHeureFin()) {
				rendezVous[i] = rendezVous[cursor - 1];
				cursor -= 1;
				return true;
			}
		}
		return false;
	}
}