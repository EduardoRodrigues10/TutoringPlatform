package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import common.IPlateforme;
import common.IRendezVous;
import common.ITuteur;
import etudiant.Etudiant;
import tuteur.Tuteur;

public class Main {
	public static void main(String[] args)
			throws RemoteException, MalformedURLException, NotBoundException, InterruptedException {

		/* Récupération de la plateforme */
		IPlateforme plateforme = (IPlateforme) Naming.lookup("plateforme");

		/* Inscription du premier tuteur */

		Tuteur tuteur1 = new Tuteur();
		tuteur1.setName("Tuteur_1"); // Set Name
		Map<Integer, Map<Double, Double>> calendrier_tuteur_1 = new HashMap<>(); // Calendrier
		Map<Double, Double> horaires_tuteur_1_lundi = new HashMap<>();
		horaires_tuteur_1_lundi.put(10.30, 12.30);
		horaires_tuteur_1_lundi.put(14.00, 16.00);
		calendrier_tuteur_1.put(1, horaires_tuteur_1_lundi); // Horaires du Lundi
		Map<Double, Double> horaires_tuteur_1_mercredi = new HashMap<>();
		horaires_tuteur_1_mercredi.put(10.00, 12.00);
		horaires_tuteur_1_mercredi.put(16.00, 18.00);
		calendrier_tuteur_1.put(3, horaires_tuteur_1_mercredi); // Horaires du Mercredi
		tuteur1.setCalendrier(calendrier_tuteur_1); // Set Calendrier
		List<String> domainesExpertise = new ArrayList<String>();
		domainesExpertise.add("Mathématiques");
		tuteur1.setDomaineExpertise(domainesExpertise); // Set Domaines Expertises
		tuteur1.setTarifHoraire(20.0); // Set Tarif ( en euro )
		plateforme.inscriptionTuteur(tuteur1); // Inscription de Tuteur_1

		/* Inscription du deuxième tuteur */
		Tuteur tuteur2 = new Tuteur();
		tuteur2.setName("Tuteur_2"); // Set Name
		Map<Integer, Map<Double, Double>> calendrier_tuteur_2 = new HashMap<>(); // Calendrier
		Map<Double, Double> horaires_tuteur_2_mardi = new HashMap<>();
		horaires_tuteur_2_mardi.put(10.30, 12.30);
		horaires_tuteur_2_mardi.put(14.00, 16.00);
		calendrier_tuteur_2.put(2, horaires_tuteur_2_mardi); // Horaires du Mardi
		Map<Double, Double> horaires_tuteur_2_jeudi = new HashMap<>();
		horaires_tuteur_2_jeudi.put(10.00, 12.00);
		horaires_tuteur_2_jeudi.put(16.00, 18.00);
		calendrier_tuteur_2.put(4, horaires_tuteur_2_jeudi); // Horaires du Jeudi
		tuteur2.setCalendrier(calendrier_tuteur_2); // Set Calendrier
		List<String> domainesExpertise2 = new ArrayList<String>();
		domainesExpertise2.add("C");
		domainesExpertise2.add("Python");
		domainesExpertise2.add("C++");
		tuteur2.setDomaineExpertise(domainesExpertise2); // Set Domaines Expertises
		tuteur2.setTarifHoraire(20.0); // Set Tarif
		plateforme.inscriptionTuteur(tuteur2); // Inscription de Tuteur_2
		
		Thread.sleep(120000);

		/* On parcours les rendez vous du tuteur 1 */
		System.out.println("Voici les rendez vous du tuteur 1");
		for (IRendezVous i : tuteur1.getRDV()) {
			System.out.println("Rendez vous " + tuteur1.getName() + " prevu avec " + i.getEtudiant().getName());
		}

		Thread.sleep(120000);

		/* On parcours les rendez vous du tuteur 1 */
		System.out.println("Voici les rendez vous du tuteur 1");
		for (IRendezVous i : tuteur1.getRDV()) {
			System.out.println("Rendez vous " + tuteur1.getName() + " prevu avec " + i.getEtudiant().getName());
		}

		Thread.sleep(120000);

		/* On parcours les rendez vous du tuteur 1 */
		System.out.println("Voici les rendez vous du tuteur 1");
		for (IRendezVous i : tuteur1.getRDV()) {
			System.out.println("Rendez vous " + tuteur1.getName() + " prevu avec " + i.getEtudiant().getName());
		}

		/* Premier etudiant */
		Etudiant etudiant = new Etudiant();
		etudiant.setName("Etudiant_1");
		etudiant.setIsInterne(true);

		/* On recherche tous les tuteurs de plateforme */
		System.out.println("On recherche tous les tuteurs de la plateforme :");
		List<ITuteur> liste_tuteurs = plateforme.rechercherToutLesTuteurs();
		liste_tuteurs.forEach((i) -> {
			try {
				System.out.println(i.getName());
			} catch (RemoteException e) {
			}
		});

		// RECHERCHER DES TUTEURS PAR LE NOM
		System.out.println("On recherche tous les tuteurs qui s'appelle Tuteur_2");
		liste_tuteurs = plateforme.rechercherParNom("Tuteur_2");
		liste_tuteurs.forEach((i) -> {
			try {
				System.out.println(i.getName());
			} catch (RemoteException e) {
			}
		});

		// RECHERCHER DES TUTEURS PAR LE TARIF
		System.out.println("On recherche tous les tuteurs qui ont un prix inférieur ou égale à 20 euros de l'heure");
		liste_tuteurs = plateforme.rechercherParTarif(20.0);
		liste_tuteurs.forEach((i) -> {
			try {
				System.out.println(i.getName());
			} catch (RemoteException e) {
			}
		});

		// RECHERCHER DES TUTEURS PAR LES DISPONIBILITES
		System.out.println("On recherche tous les tuteurs disponible le lundi de 10h30 à 12h30");
		liste_tuteurs = plateforme.rechercherParDisponibilite(1, 10.30, 12.30);
		liste_tuteurs.forEach((i) -> {
			try {
				System.out.println(i.getName());
			} catch (RemoteException e) {
			}
		});

		/* Etudiant_1 prend rendez vous avec le premier tuteur disponible le lundi */
		System.out.println("L'étudiant_1 prend rendez-vous avec le tuteur disponible le lundi de 10h30 à 12h30.");
		plateforme.prendreRendezVous(etudiant, liste_tuteurs.get(0), 1, 10.30, 12.30);

		/* On parcours les rendez vous du etudiant 1 */
		System.out.println("Voici les rendez vous du étudiant 1");
		for (IRendezVous i : etudiant.getRDV()) {
			System.out.println("Rendez vous " + etudiant.getName() + " prevu avec " + i.getTuteur().getName());
		}

		Thread.sleep(120000);

		/* On parcours les rendez vous du etudiant 1 */
		System.out.println("Voici les rendez vous du étudiant 1");
		for (IRendezVous i : etudiant.getRDV()) {
			System.out.println("Rendez vous " + etudiant.getName() + " prevu avec " + i.getTuteur().getName());
		}

		/* Deuxieme etudiant */
		Etudiant etudiant2 = new Etudiant();
		etudiant2.setName("Etudiant_2");
		etudiant2.setIsInterne(true);

		/* Troisieme etudiant */
		Etudiant etudiant3 = new Etudiant();
		etudiant3.setName("Etudiant_3");
		etudiant3.setIsInterne(true);

		/* Etudiant_2 prend rendez vous avec le premier tuteur disponible le lundi */
		System.out.println("L'étudiant_2 prend rendez-vous avec le tuteur disponible le lundi de 10h30 à 12h30.");
		plateforme.prendreRendezVous(etudiant2, liste_tuteurs.get(0), 1, 10.30, 12.30);

		/* On parcours les rendez vous du etudiant 2 */
		System.out.println("Voici les rendez vous du étudiant 2");
		for (IRendezVous i : etudiant2.getRDV()) {
			System.out.println("Rendez vous " + etudiant2.getName() + " prevu avec " + i.getTuteur().getName());
		}

		/* Etudiant 1 fais son rendez-vous avec le premier tuteur */
		plateforme.faireRDV(etudiant.getRDV().get(0), null);
		System.out.println("Le rendez vous à été fait pour " + etudiant.getName());

		/* On parcours les rendez vous du etudiant 2 */
		System.out.println("Voici les rendez vous du étudiant 2");
		for (IRendezVous i : etudiant2.getRDV()) {
			System.out.println("Rendez vous " + etudiant2.getName() + " prevu avec " + i.getTuteur().getName());
		}

		/* On recherche tous les tuteurs qui font du python */
		System.out.println("On recherche tous les tuteurs de la plateforme qui font du python :");
		List<ITuteur> liste_tuteurs_python = plateforme.rechercherParMatiere("Python");
		for (ITuteur tuteur : liste_tuteurs_python) {
			System.out.println("Consultation des horaires de ce tuteur");
			for (Entry<Integer, Map<Double, Double>> kv : tuteur.getCalendrier().entrySet()) {
				for (Entry<Double, Double> kv2 : kv.getValue().entrySet()) {
					System.out.println("Jour " + kv.getKey() + " de " + kv2.getKey() + " a " + kv2.getValue());
				}
			}
			System.out.println("L'étudiant_3 prend rendez-vous avec le tuteur disponible le jeudi de 16h00 à 18h00.");
			plateforme.prendreRendezVous(etudiant3, tuteur, 4, 16.00, 18.00);
			break;
		}

		/* On parcours les rendez vous du etudiant 2 */
		System.out.println("Voici les rendez vous du étudiant 2");
		for (IRendezVous i : etudiant2.getRDV()) {
			System.out.println("Rendez vous " + etudiant2.getName() + " prevu avec " + i.getTuteur().getName());
		}

		/* On parcours les rendez vous du etudiant 3 */
		System.out.println("Voici les rendez vous du étudiant 3");
		for (IRendezVous i : etudiant3.getRDV()) {
			System.out.println("Rendez vous " + etudiant3.getName() + " prevu avec " + i.getTuteur().getName());
		}

		/* Etudiant 2 fais son rendez-vous avec le premier tuteur */
		plateforme.faireRDV(etudiant2.getRDV().get(0), null);
		System.out.println("Le rendez vous à été fait pour " + etudiant2.getName());

		/* Etudiant 3 fais son rendez-vous avec le deuxieme tuteur */
		plateforme.faireRDV(etudiant3.getRDV().get(0), null);
		System.out.println("Le rendez vous à été fait pour " + etudiant3.getName());
	}
}