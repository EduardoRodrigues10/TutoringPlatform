/**
 * PlateformeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serveur;

public interface PlateformeService extends javax.xml.rpc.Service {
    public java.lang.String getPlateformeAddress();

    public serveur.Plateforme getPlateforme() throws javax.xml.rpc.ServiceException;

    public serveur.Plateforme getPlateforme(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
