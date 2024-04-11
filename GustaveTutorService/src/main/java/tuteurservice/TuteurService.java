package tuteurservice;

import java.io.Serializable;
import java.util.Arrays;

import rendezvousservice.RendezVousService;

public class TuteurService implements Serializable {

	private String name;
	private String[] domainesExpertise;
	private int[] calendrierJours;
	private double[] calendrierHoraires;
	private double tarifHoraire;
	private RendezVousService[] rendezVous = new RendezVousService[1];
	private int cursor = 0;

	public TuteurService() {}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDomainesExpertise(String[] domainesExpertise) {
		this.domainesExpertise = domainesExpertise;
	}

	public String[] getDomainesExpertise() {
		return domainesExpertise;
	}

	public void setCalendrierJours(int[] calendrierJours) {
		this.calendrierJours = calendrierJours;
	}

	public int[] getCalendrierJours() {
		return calendrierJours;
	}
	
	public void setCalendrierHoraires(double[] calendrierHoraires) {
		this.calendrierHoraires = calendrierHoraires;
	}
	
	public double[] getCalendrierHoraires() {
		return calendrierHoraires;
	}
	
	public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

	public double getTarifHoraire() {
		return tarifHoraire;
	}

	public boolean ajouterRendezVous(RendezVousService rdv) {
		System.out.println("Verif dans le tuteur b");
		for (int i = 0; i < cursor; i++) {
			if (rendezVous[i].getJour() == rdv.getJour() && rendezVous[i].getHeureDebut() == rdv.getHeureDebut()
					&& rendezVous[i].getHeureFin() == rdv.getHeureFin()) {
				return false;
			}
		}
		if (rendezVous.length == cursor) {
			Arrays.copyOf(rendezVous, ((rendezVous.length * 2) + 1));
		}
		rendezVous[cursor] = rdv;
		cursor += 1;
		return true;
	}

	public RendezVousService[] getRDV() {
		return rendezVous;
	}

	public boolean faireRDV(RendezVousService rdv) {
		for (int i = 0; i < cursor; i++) {
			if (rendezVous[i].getJour() == rdv.getJour() && rendezVous[i].getHeureDebut() == rdv.getHeureDebut()
					&& rendezVous[i].getHeureFin() == rdv.getHeureFin()) {
				rendezVous[i] = rendezVous[cursor - 1];
				cursor -= 1;
				return true;
			}
		}
		return false;
	}
}