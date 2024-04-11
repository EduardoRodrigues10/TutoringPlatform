package serveur;

public class PlateformeProxy implements serveur.Plateforme {
  private String _endpoint = null;
  private serveur.Plateforme plateforme = null;
  
  public PlateformeProxy() {
    _initPlateformeProxy();
  }
  
  public PlateformeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPlateformeProxy();
  }
  
  private void _initPlateformeProxy() {
    try {
      plateforme = (new serveur.PlateformeServiceLocator()).getPlateforme();
      if (plateforme != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)plateforme)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)plateforme)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (plateforme != null)
      ((javax.xml.rpc.Stub)plateforme)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public serveur.Plateforme getPlateforme() {
    if (plateforme == null)
      _initPlateformeProxy();
    return plateforme;
  }
  
  public tuteurservice.TuteurService[] rechercherParTarif(double tarifMax) throws java.rmi.RemoteException{
    if (plateforme == null)
      _initPlateformeProxy();
    return plateforme.rechercherParTarif(tarifMax);
  }
  
  public int prendreRendezVous(java.lang.String name, tuteurservice.TuteurService tuteur, int jour, double heureDebut, double heureFin) throws java.rmi.RemoteException{
    if (plateforme == null)
      _initPlateformeProxy();
    return plateforme.prendreRendezVous(name, tuteur, jour, heureDebut, heureFin);
  }
  
  public tuteurservice.TuteurService[] rechercherParNom(java.lang.String nom) throws java.rmi.RemoteException{
    if (plateforme == null)
      _initPlateformeProxy();
    return plateforme.rechercherParNom(nom);
  }
  
  public void faireRendezVous(int rdv) throws java.rmi.RemoteException{
    if (plateforme == null)
      _initPlateformeProxy();
    plateforme.faireRendezVous(rdv);
  }
  
  public tuteurservice.TuteurService[] rechercherParDisponibilite(int jour, double heureDebut, double heureFin) throws java.rmi.RemoteException{
    if (plateforme == null)
      _initPlateformeProxy();
    return plateforme.rechercherParDisponibilite(jour, heureDebut, heureFin);
  }
  
  public tuteurservice.TuteurService[] rechercherParMatiere(java.lang.String matiere) throws java.rmi.RemoteException{
    if (plateforme == null)
      _initPlateformeProxy();
    return plateforme.rechercherParMatiere(matiere);
  }
  
  public tuteurservice.TuteurService[] rechercherToutLesTuteurs() throws java.rmi.RemoteException{
    if (plateforme == null)
      _initPlateformeProxy();
    return plateforme.rechercherToutLesTuteurs();
  }
  
  
}