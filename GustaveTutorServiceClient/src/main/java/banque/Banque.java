/**
 * Banque.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package banque;

public interface Banque extends java.rmi.Remote {
    public void ajouterFond(java.lang.String name, double montant) throws java.rmi.RemoteException;
    public double getSolde(java.lang.String name) throws java.rmi.RemoteException;
    public void retirerFond(java.lang.String name, double montant) throws java.rmi.RemoteException;
    public java.lang.String getDevise(java.lang.String name) throws java.rmi.RemoteException;
    public void ajouterCompte(java.lang.String name, java.lang.String devise) throws java.rmi.RemoteException;
}
