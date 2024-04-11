package serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.rpc.ServiceException;

import FxtopAPI.FxtopServicesLocator;
import FxtopAPI.FxtopServicesPortType;
import banque.Banque;
import banque.BanqueServiceLocator;
import common.IPlateforme;
import common.ITuteur;
import etudiant.Etudiant;
import tuteurservice.TuteurService;

public class Plateforme {

	private final IPlateforme plateforme;

	public Plateforme() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		this.plateforme = (IPlateforme) Naming.lookup("plateforme");

	}

	private TuteurService[] listToArray(List<ITuteur> t1) throws RemoteException {
		TuteurService[] t2 = new TuteurService[t1.size()];
		int cursorT2 = 0;
		for (int i = 0; i < t1.size(); i++) {
			TuteurService tmp = new TuteurService();
			tmp.setName(t1.get(i).getName());
			List<String> domainesExpertises = t1.get(i).getDomainesExpertise();
			String[] domainesExpertisesTmp = new String[domainesExpertises.size()];
			for (int j = 0; j < domainesExpertises.size(); j++) {
				domainesExpertisesTmp[j] = domainesExpertises.get(j);
			}
			tmp.setDomainesExpertise(domainesExpertisesTmp);
			Map<Integer, Map<Double, Double>> calendrier = t1.get(i).getCalendrier();
			int[] calendrierJours = new int[7];
			double[] calendrierHoraires = new double[0];
			int cursor = 0;
			for (int j = 0; j < 7; j++) {
				Map<Double, Double> horaires = calendrier.get(j + 1);
				if (horaires != null) {
					calendrierHoraires = Arrays.copyOf(calendrierHoraires,
							calendrierHoraires.length + horaires.size() * 2);
					for (Entry<Double, Double> entry : horaires.entrySet()) {
						calendrierHoraires[cursor] = entry.getKey();
						cursor += 1;
						calendrierHoraires[cursor] = entry.getValue();
						cursor += 1;
					}
				} else {
					calendrierJours[j] = 0;
				}
			}
			tmp.setCalendrierJours(calendrierJours);
			tmp.setCalendrierHoraires(calendrierHoraires);
			tmp.setTarifHoraire(t1.get(i).getTarifHoraire());
			t2[cursorT2] = tmp;
			cursorT2 += 1;
		}
		return t2;
	}

	public TuteurService[] rechercherToutLesTuteurs() throws RemoteException {
		List<ITuteur> t1 = plateforme.rechercherToutLesTuteurs();
		return listToArray(t1);

	}

	public TuteurService[] rechercherParNom(String nom) throws RemoteException {
		List<ITuteur> t1 = plateforme.rechercherParNom(nom);
		return listToArray(t1);
	}

	public TuteurService[] rechercherParTarif(double tarifMax) throws RemoteException {
		List<ITuteur> t1 = plateforme.rechercherParTarif(tarifMax);
		return listToArray(t1);
	}

	public TuteurService[] rechercherParDisponibilite(Integer jour, Double heureDebut, Double heureFin)
			throws RemoteException {
		List<ITuteur> t1 = plateforme.rechercherParDisponibilite(jour, heureDebut, heureFin);
		return listToArray(t1);
	}

	public TuteurService[] rechercherParMatiere(String matiere) throws RemoteException {
		List<ITuteur> t1 = plateforme.rechercherParMatiere(matiere);
		return listToArray(t1);
	}

	public int prendreRendezVous(String name, TuteurService tuteur, Integer jour, Double heureDebut,
			Double heureFin) throws RemoteException, ServiceException {
		FxtopServicesPortType service = new FxtopServicesLocator().getFxtopServicesPort();
		Banque banque = new BanqueServiceLocator().getBanque();
		double taux = Double.parseDouble(service.convert(new Double(banque.getSolde(name)).toString(), banque.getDevise(name) , "EUR", "", "", "").getExchangeRate());
		for (ITuteur tuteurs : plateforme.rechercherToutLesTuteurs()) {
			if (tuteurs.getName().equals(tuteur.getName())) {
				if (tuteur.getTarifHoraire() * (heureFin - heureDebut) <= taux * banque.getSolde(name)) {
					Etudiant e = new Etudiant();
					e.setName(name);
					e.setIsInterne(false);
					int rdv = plateforme.prendreRendezVous(e, tuteurs, jour, heureDebut, heureFin);
					if (rdv > -1) {
						banque.retirerFond(name, tuteur.getTarifHoraire() * (heureFin - heureDebut) * Double.parseDouble(service.convert(new Double(banque.getSolde(name)).toString(), "EUR" , banque.getDevise(name), "", "", "").getExchangeRate()));
						return rdv;
					}
				}
			}
		}
		return -1;
	}

	public void faireRendezVous(Integer rdv) throws RemoteException {
		plateforme.faireRDV(null, rdv); 
	}
}