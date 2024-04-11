package banque;

import java.util.ArrayList;
import java.util.List;

public class Banque {
	
	class Compte {
	    private String name;
	    private double solde;
	    private String devise;

	    public Compte(String name, String devise){
	        this.name = name;
	        this.solde = 0.0;
	        this.devise = devise;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getSolde() {
	        return solde;
	    }

	    public void setSolde(double solde) {
	        this.solde = solde;
	    }
	    
	    public String getDevise() {
	        return devise;
	    }
	}
	
	private List<Compte> comptes;
	
	public Banque() {
		comptes = new ArrayList<>();
	}
	
	public void ajouterCompte(String name, String devise) {
		comptes.add(new Compte(name, devise));
	}
	
	public double getSolde(String name) {
		for (Compte compte : comptes) {
			if (compte.getName().equals(name)) {
				return compte.getSolde();
			}
		}
		return 0.0;
	}
	
	public void ajouterFond(String name, double montant) {
		for (Compte compte : comptes) {
			if (compte.getName().equals(name)) {
				compte.setSolde(compte.getSolde() + montant);
			}
		}
	}
	
	public void retirerFond(String name, double montant) {
		for (Compte compte : comptes) {
			if (compte.getName().equals(name)) {
				compte.setSolde(compte.getSolde() - montant);
			}
		}
	}
	
	public String getDevise(String name) {
		for (Compte compte : comptes) {
			if (compte.getName().equals(name)) {
				return compte.getDevise();
			}
		}
		return null;
	}
}