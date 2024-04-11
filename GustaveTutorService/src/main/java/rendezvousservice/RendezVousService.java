package rendezvousservice;

import java.io.Serializable;

import etudiantservice.EtudiantService;
import tuteurservice.TuteurService;

public class RendezVousService implements Serializable {
	
	private EtudiantService etudiant;
    private TuteurService tuteur;
    private Integer jour;
    private Double heureDebut;
    private Double heureFin;
    
    public RendezVousService() {}
	
	public RendezVousService(EtudiantService etudiant, TuteurService tuteur, Integer jour, Double heureDebut, Double heureFin) {
		this.etudiant = etudiant;
        this.tuteur = tuteur;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
	}

	public EtudiantService getEtudiant() {
		return etudiant;
	}

	public TuteurService getTuteur() {
		return tuteur;
	}

	public Integer getJour() {
		return jour;
	}

	public double getHeureDebut() {
		return heureDebut;
	}

	public double getHeureFin() {
		return heureFin;
	}
}
