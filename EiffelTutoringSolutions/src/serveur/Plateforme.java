package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import common.IEtudiant;
import common.IPlateforme;
import common.IRendezVous;
import common.ITuteur;
import rendezvous.RendezVous;

public class Plateforme extends UnicastRemoteObject implements IPlateforme {
	List<ITuteur> tuteurs;
	List<RendezVous> rdvEnAttente;
	private Integer index;

	public Plateforme() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		tuteurs = new ArrayList<ITuteur>();
		rdvEnAttente = new LinkedList<RendezVous>();
		this.index = 1;
	}

	@Override
	public void inscriptionTuteur(ITuteur tuteur) throws RemoteException {
		if (tuteur != null) {
			tuteurs.add(tuteur);
		}
	}

	@Override
	public List<ITuteur> rechercherToutLesTuteurs() {
		return tuteurs;
	}

	@Override
	public List<ITuteur> rechercherParNom(String nom) {
		List<ITuteur> resultats = new ArrayList<>();
		for (ITuteur tuteur : tuteurs) {
			try {
				if (tuteur.getName().equalsIgnoreCase(nom)) {
					resultats.add(tuteur);
				}
			} catch (RemoteException e) {
				// Gérer les exceptions RemoteException
				e.printStackTrace();
			}
		}
		return resultats;
	}

	@Override
	public List<ITuteur> rechercherParTarif(double tarifMax) {
		List<ITuteur> resultats = new ArrayList<>();
		for (ITuteur tuteur : tuteurs) {
			try {
				if (tuteur.getTarifHoraire() <= tarifMax) {
					resultats.add(tuteur);
				}
			} catch (RemoteException e) {
				// Gérer les exceptions RemoteException
				e.printStackTrace();
			}
		}
		return resultats;
	}

	@Override
	public List<ITuteur> rechercherParDisponibilite(Integer jour, Double heureDebut, Double heureFin)
			throws RemoteException {
		List<ITuteur> resultats = new ArrayList<>();
		for (ITuteur tuteur : tuteurs) {
			if (isTuteurDisponible(tuteur, jour, heureDebut, heureFin)) {
				resultats.add(tuteur);
			}
		}
		return resultats;
	}

	private boolean isTuteurDisponible(ITuteur tuteur, Integer jour, Double heureDebut, Double heureFin)
			throws RemoteException {
		Map<Integer, Map<Double, Double>> tuteurCalendrier = tuteur.getCalendrier();

		// Vérifie si le jour de la semaine est disponible
		if (tuteurCalendrier.containsKey(jour)) {
			Map<Double, Double> creneaux = tuteurCalendrier.get(jour);

			// Vérifie si le créneau horaire spécifié est disponible
			for (Entry<Double, Double> creneau : creneaux.entrySet()) {
				if (creneau.getKey().equals(heureDebut) && creneau.getValue().equals(heureFin)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Integer prendreRendezVous(IEtudiant etudiant, ITuteur tuteur, Integer jour, Double heureDebut,
			Double heureFin) throws RemoteException {
		if (isTuteurDisponible(tuteur, jour, heureDebut, heureFin)) {
			RendezVous rendezVous = new RendezVous(etudiant, tuteur, jour, heureDebut, heureFin, index);
			index += 1;
			if (tuteur.ajouterRendezVous(rendezVous)) {
				if (etudiant.getIsInterne()) {
					etudiant.ajouterRendezVous(rendezVous);
				}
				System.out.println("Le rendez vous entre " + etudiant.getName() + " et " + tuteur.getName() + " est confirmer");
				return rendezVous.getIndex();
			} else {
				if (etudiant.getIsInterne()) {
					System.out.println("Le rendez vous entre " + etudiant.getName() + " et " + rendezVous.getTuteur().getName() + " a ete mis en attente !");
					rdvEnAttente.add(rendezVous);
				} else {
					index -= 1;
				}
				return -1;
			}
		}
		return -1;
	}

	@Override
	public List<ITuteur> rechercherParMatiere(String matiere) throws RemoteException {
		List<ITuteur> resultats = new ArrayList<>();
		for (ITuteur tuteur : tuteurs) {
			try {
				if (tuteur.getDomainesExpertise().contains(matiere)) {
					resultats.add(tuteur);
				}
			} catch (RemoteException e) {
				// Gérer les exceptions RemoteException
				e.printStackTrace();
			}
		}
		return resultats;
	}

	@Override
	public void faireRDV(IRendezVous rdv, Integer index) throws RemoteException {
		if (rdv == null) {
			for (ITuteur tuteur : tuteurs) {
				for (IRendezVous r : tuteur.getRDV()) {
					if (r.getIndex().equals(index)) {
						tuteur.faireRDV(r);
						for (int i = 0; i < rdvEnAttente.size(); i++) {
							RendezVous rdvTmp = rdvEnAttente.get(i);
							if (rdvTmp.getTuteur().equals(r.getTuteur()) && rdvTmp.getJour().equals(r.getJour()) && rdvTmp.getHeureDebut() == r.getHeureDebut() && rdvTmp.getHeureFin() == r.getHeureFin()) {
								rdvTmp.getEtudiant().notifyRDV(rdvTmp);
								rdvTmp.getTuteur().ajouterRendezVous(rdvTmp);
								rdvEnAttente.remove(i);
								break;
							}
						}
						return;
					}
				}
			}
		} else {
			if (rdv.getTuteur().faireRDV(rdv)) {
				if (rdv.getEtudiant().faireRDV(rdv)) {
					for (int i = 0; i < rdvEnAttente.size(); i++) {
						RendezVous rdvTmp = rdvEnAttente.get(i);
						if (rdvTmp.getTuteur().equals(rdv.getTuteur()) && rdvTmp.getJour().equals(rdv.getJour()) && rdvTmp.getHeureDebut() == rdv.getHeureDebut() && rdvTmp.getHeureFin() == rdv.getHeureFin()) {
							rdvTmp.getEtudiant().notifyRDV(rdvTmp);
							rdvTmp.getTuteur().ajouterRendezVous(rdvTmp);
							rdvEnAttente.remove(i);
							break;
						}
					}
				}
			}
		}
	}
}