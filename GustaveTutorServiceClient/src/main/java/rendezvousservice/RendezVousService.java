/**
 * RendezVousService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package rendezvousservice;

public class RendezVousService  implements java.io.Serializable {
    private etudiantservice.EtudiantService etudiant;

    private double heureDebut;

    private double heureFin;

    private java.lang.Integer jour;

    private tuteurservice.TuteurService tuteur;

    public RendezVousService() {
    }

    public RendezVousService(
           etudiantservice.EtudiantService etudiant,
           double heureDebut,
           double heureFin,
           java.lang.Integer jour,
           tuteurservice.TuteurService tuteur) {
           this.etudiant = etudiant;
           this.heureDebut = heureDebut;
           this.heureFin = heureFin;
           this.jour = jour;
           this.tuteur = tuteur;
    }


    /**
     * Gets the etudiant value for this RendezVousService.
     * 
     * @return etudiant
     */
    public etudiantservice.EtudiantService getEtudiant() {
        return etudiant;
    }


    /**
     * Sets the etudiant value for this RendezVousService.
     * 
     * @param etudiant
     */
    public void setEtudiant(etudiantservice.EtudiantService etudiant) {
        this.etudiant = etudiant;
    }


    /**
     * Gets the heureDebut value for this RendezVousService.
     * 
     * @return heureDebut
     */
    public double getHeureDebut() {
        return heureDebut;
    }


    /**
     * Sets the heureDebut value for this RendezVousService.
     * 
     * @param heureDebut
     */
    public void setHeureDebut(double heureDebut) {
        this.heureDebut = heureDebut;
    }


    /**
     * Gets the heureFin value for this RendezVousService.
     * 
     * @return heureFin
     */
    public double getHeureFin() {
        return heureFin;
    }


    /**
     * Sets the heureFin value for this RendezVousService.
     * 
     * @param heureFin
     */
    public void setHeureFin(double heureFin) {
        this.heureFin = heureFin;
    }


    /**
     * Gets the jour value for this RendezVousService.
     * 
     * @return jour
     */
    public java.lang.Integer getJour() {
        return jour;
    }


    /**
     * Sets the jour value for this RendezVousService.
     * 
     * @param jour
     */
    public void setJour(java.lang.Integer jour) {
        this.jour = jour;
    }


    /**
     * Gets the tuteur value for this RendezVousService.
     * 
     * @return tuteur
     */
    public tuteurservice.TuteurService getTuteur() {
        return tuteur;
    }


    /**
     * Sets the tuteur value for this RendezVousService.
     * 
     * @param tuteur
     */
    public void setTuteur(tuteurservice.TuteurService tuteur) {
        this.tuteur = tuteur;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RendezVousService)) return false;
        RendezVousService other = (RendezVousService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.etudiant==null && other.getEtudiant()==null) || 
             (this.etudiant!=null &&
              this.etudiant.equals(other.getEtudiant()))) &&
            this.heureDebut == other.getHeureDebut() &&
            this.heureFin == other.getHeureFin() &&
            ((this.jour==null && other.getJour()==null) || 
             (this.jour!=null &&
              this.jour.equals(other.getJour()))) &&
            ((this.tuteur==null && other.getTuteur()==null) || 
             (this.tuteur!=null &&
              this.tuteur.equals(other.getTuteur())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEtudiant() != null) {
            _hashCode += getEtudiant().hashCode();
        }
        _hashCode += new Double(getHeureDebut()).hashCode();
        _hashCode += new Double(getHeureFin()).hashCode();
        if (getJour() != null) {
            _hashCode += getJour().hashCode();
        }
        if (getTuteur() != null) {
            _hashCode += getTuteur().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RendezVousService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rendezvousservice", "RendezVousService"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etudiant");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rendezvousservice", "etudiant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://etudiantservice", "EtudiantService"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("heureDebut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rendezvousservice", "heureDebut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("heureFin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rendezvousservice", "heureFin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jour");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rendezvousservice", "jour"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tuteur");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rendezvousservice", "tuteur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tuteurservice", "TuteurService"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
