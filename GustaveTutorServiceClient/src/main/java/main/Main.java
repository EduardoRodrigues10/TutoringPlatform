package main;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import banque.Banque;
import banque.BanqueServiceLocator;
import serveur.Plateforme;
import serveur.PlateformeServiceLocator;
import tuteurservice.TuteurService;

public class Main {
	public static void main(String[] args) throws ServiceException, RemoteException, InterruptedException {
		
		/* Récupération des deux services */
		Plateforme service = new PlateformeServiceLocator().getPlateforme();
		Banque banque = new BanqueServiceLocator().getBanque();
		
		/* Ajout du compte de Edouardo */
		banque.ajouterCompte("Edouardo", "EUR");
		banque.ajouterFond("Edouardo", 50);
		
		/* Ajout du compte de Issam */
		banque.ajouterCompte("Issam", "USD");
		banque.ajouterFond("Issam", 50);
		
		Thread.sleep(180000);
		
		/* Nous recherchons tous les tuteurs disponibles, nous sélectionnons le premier */
		TuteurService tuteur = service.rechercherToutLesTuteurs()[0];
		
		/* Edouardo prend un rendez-vous avec le premier tuteur lundi de 10h30 à 12h30 */
		System.out.println("Edouardo prend rendez-vous avec le tuteur disponible le lundi de 10h30 à 12h30.");
		int rdv = service.prendreRendezVous("Edouardo", tuteur, 1, 10.30, 12.30);
		if (rdv > -1) {
			System.out.println("Le rendez vous à été pris pour Edouardo !");
			System.out.println("Le prix est de : " + tuteur.getTarifHoraire() * (12.30 - 10.30));
			System.out.println("Il vous reste Edouardo, comme solde : " + banque.getSolde("Edouardo") + " " + banque.getDevise("Edouardo"));
		} else {
			System.out.println("Le rendez vous, n'a pas été pris, le tuteur n'est pas disponible !");
			System.out.println("Il vous reste Edouardo, comme solde : " + banque.getSolde("Edouardo") + " " + banque.getDevise("Edouardo"));
		}

		/* Issam prend un rendez-vous avec le premier tuteur lundi de 10h30 à 12h30 */
		System.out.println("Issam prend rendez-vous avec le tuteur disponible le lundi de 10h30 à 12h30.");
		int rdv2 = service.prendreRendezVous("Issam", tuteur, 1, 10.30, 12.30);
		if (rdv2 > -1) {
			System.out.println("Le rendez vous à été pris pour Issam !");
			System.out.println("Le prix est de : " + tuteur.getTarifHoraire() * (12.30 - 10.30));
			System.out.println("Il vous reste Issam, comme solde : " + banque.getSolde("Issam") + " " + banque.getDevise("Issam"));
		} else {
			System.out.println("Le rendez vous, n'a pas été pris, le tuteur n'est pas disponible !");
			System.out.println("Il vous reste Issam, comme solde : " + banque.getSolde("Issam") + " " + banque.getDevise("Issam"));
		}

		Thread.sleep(120000);

		/* Edouardo fais son rendez-vous avec le premier tuteur */
		service.faireRendezVous(rdv);
		System.out.println("Le rendez vous à été fait pour Edouardo");

		/* Issam essaye de reprendre un rendez-vous avec le premier tuteur lundi de 10h30 à 12h30 */
		System.out.println("Issam prend rendez-vous avec le tuteur disponible le lundi de 10h30 à 12h30.");
		int rdv3 = service.prendreRendezVous("Issam", tuteur, 1, 10.30, 12.30);
		if (rdv3 > -1) {
			System.out.println("Le rendez vous à été pris pour Issam !");
			System.out.println("Le prix est de : " + tuteur.getTarifHoraire() * (12.30 - 10.30));
			System.out.println("Il vous reste Issam, comme solde : " + banque.getSolde("Issam") + " " + banque.getDevise("Issam"));
		} else {
			System.out.println("Le rendez vous, n'a pas été pris, le tuteur n'est pas disponible !");
			System.out.println("Il vous reste Issam, comme solde : " + banque.getSolde("Issam") + " " + banque.getDevise("Issam"));
		}

		Thread.sleep(120000);

		/* Issam fais son rendez-vous avec le premier tuteur */
		service.faireRendezVous(rdv3);
		System.out.println("Le rendez vous à été fait pour Issam");
	}
}
