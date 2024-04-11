package banque;

public class BanqueProxy implements banque.Banque {
  private String _endpoint = null;
  private banque.Banque banque = null;
  
  public BanqueProxy() {
    _initBanqueProxy();
  }
  
  public BanqueProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueProxy();
  }
  
  private void _initBanqueProxy() {
    try {
      banque = (new banque.BanqueServiceLocator()).getBanque();
      if (banque != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banque)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banque != null)
      ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public banque.Banque getBanque() {
    if (banque == null)
      _initBanqueProxy();
    return banque;
  }
  
  public void ajouterCompte(java.lang.String name, java.lang.String devise) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.ajouterCompte(name, devise);
  }
  
  public double getSolde(java.lang.String name) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.getSolde(name);
  }
  
  public void ajouterFond(java.lang.String name, double montant) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.ajouterFond(name, montant);
  }
  
  public void retirerFond(java.lang.String name, double montant) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.retirerFond(name, montant);
  }
  
  public java.lang.String getDevise(java.lang.String name) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.getDevise(name);
  }
  
  
}