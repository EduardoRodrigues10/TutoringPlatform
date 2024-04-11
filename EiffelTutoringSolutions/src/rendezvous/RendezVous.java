package rendezvous;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.IEtudiant;
import common.IRendezVous;
import common.ITuteur;

public class RendezVous extends UnicastRemoteObject implements IRendezVous {
	private IEtudiant etudiant;
    private ITuteur tuteur;
    private Integer jour;
    private Double heureDebut;
    private Double heureFin;
    private Integer index;

    public RendezVous(IEtudiant etudiant, ITuteur tuteur, Integer jour, Double heureDebut, Double heureFin, Integer index) throws RemoteException {
    	super();
        this.etudiant = etudiant;
        this.tuteur = tuteur;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.index = index;
    }

	@Override
	public IEtudiant getEtudiant() throws RemoteException {
		return etudiant;
	}
	
	@Override
	public ITuteur getTuteur() throws RemoteException {
		return tuteur;
	}
	
	@Override
	public Integer getJour() throws RemoteException {
		return jour;
	}
	
	@Override
	public double getHeureDebut() throws RemoteException {
		return heureDebut;
	}
	
	@Override
	public double getHeureFin() throws RemoteException {
		return heureFin;
	}
	
	@Override
	public Integer getIndex() throws RemoteException {
		return index;
	}
}