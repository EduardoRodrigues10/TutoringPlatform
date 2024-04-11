/**
 * Plateforme.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serveur;

public interface Plateforme extends java.rmi.Remote {
    public tuteurservice.TuteurService[] rechercherParTarif(double tarifMax) throws java.rmi.RemoteException;
    public int prendreRendezVous(java.lang.String name, tuteurservice.TuteurService tuteur, int jour, double heureDebut, double heureFin) throws java.rmi.RemoteException;
    public tuteurservice.TuteurService[] rechercherParNom(java.lang.String nom) throws java.rmi.RemoteException;
    public void faireRendezVous(int rdv) throws java.rmi.RemoteException;
    public tuteurservice.TuteurService[] rechercherParDisponibilite(int jour, double heureDebut, double heureFin) throws java.rmi.RemoteException;
    public tuteurservice.TuteurService[] rechercherParMatiere(java.lang.String matiere) throws java.rmi.RemoteException;
    public tuteurservice.TuteurService[] rechercherToutLesTuteurs() throws java.rmi.RemoteException;
}
