/**
 * TuteurService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tuteurservice;

public class TuteurService  implements java.io.Serializable {
    private rendezvousservice.RendezVousService[] RDV;

    private double[] calendrierHoraires;

    private int[] calendrierJours;

    private java.lang.String[] domainesExpertise;

    private java.lang.String name;

    private double tarifHoraire;

    public TuteurService() {
    }

    public TuteurService(
           rendezvousservice.RendezVousService[] RDV,
           double[] calendrierHoraires,
           int[] calendrierJours,
           java.lang.String[] domainesExpertise,
           java.lang.String name,
           double tarifHoraire) {
           this.RDV = RDV;
           this.calendrierHoraires = calendrierHoraires;
           this.calendrierJours = calendrierJours;
           this.domainesExpertise = domainesExpertise;
           this.name = name;
           this.tarifHoraire = tarifHoraire;
    }


    /**
     * Gets the RDV value for this TuteurService.
     * 
     * @return RDV
     */
    public rendezvousservice.RendezVousService[] getRDV() {
        return RDV;
    }


    /**
     * Sets the RDV value for this TuteurService.
     * 
     * @param RDV
     */
    public void setRDV(rendezvousservice.RendezVousService[] RDV) {
        this.RDV = RDV;
    }


    /**
     * Gets the calendrierHoraires value for this TuteurService.
     * 
     * @return calendrierHoraires
     */
    public double[] getCalendrierHoraires() {
        return calendrierHoraires;
    }


    /**
     * Sets the calendrierHoraires value for this TuteurService.
     * 
     * @param calendrierHoraires
     */
    public void setCalendrierHoraires(double[] calendrierHoraires) {
        this.calendrierHoraires = calendrierHoraires;
    }


    /**
     * Gets the calendrierJours value for this TuteurService.
     * 
     * @return calendrierJours
     */
    public int[] getCalendrierJours() {
        return calendrierJours;
    }


    /**
     * Sets the calendrierJours value for this TuteurService.
     * 
     * @param calendrierJours
     */
    public void setCalendrierJours(int[] calendrierJours) {
        this.calendrierJours = calendrierJours;
    }


    /**
     * Gets the domainesExpertise value for this TuteurService.
     * 
     * @return domainesExpertise
     */
    public java.lang.String[] getDomainesExpertise() {
        return domainesExpertise;
    }


    /**
     * Sets the domainesExpertise value for this TuteurService.
     * 
     * @param domainesExpertise
     */
    public void setDomainesExpertise(java.lang.String[] domainesExpertise) {
        this.domainesExpertise = domainesExpertise;
    }


    /**
     * Gets the name value for this TuteurService.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this TuteurService.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the tarifHoraire value for this TuteurService.
     * 
     * @return tarifHoraire
     */
    public double getTarifHoraire() {
        return tarifHoraire;
    }


    /**
     * Sets the tarifHoraire value for this TuteurService.
     * 
     * @param tarifHoraire
     */
    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TuteurService)) return false;
        TuteurService other = (TuteurService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.RDV==null && other.getRDV()==null) || 
             (this.RDV!=null &&
              java.util.Arrays.equals(this.RDV, other.getRDV()))) &&
            ((this.calendrierHoraires==null && other.getCalendrierHoraires()==null) || 
             (this.calendrierHoraires!=null &&
              java.util.Arrays.equals(this.calendrierHoraires, other.getCalendrierHoraires()))) &&
            ((this.calendrierJours==null && other.getCalendrierJours()==null) || 
             (this.calendrierJours!=null &&
              java.util.Arrays.equals(this.calendrierJours, other.getCalendrierJours()))) &&
            ((this.domainesExpertise==null && other.getDomainesExpertise()==null) || 
             (this.domainesExpertise!=null &&
              java.util.Arrays.equals(this.domainesExpertise, other.getDomainesExpertise()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.tarifHoraire == other.getTarifHoraire();
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
        if (getRDV() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRDV());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRDV(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCalendrierHoraires() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCalendrierHoraires());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCalendrierHoraires(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCalendrierJours() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCalendrierJours());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCalendrierJours(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDomainesExpertise() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDomainesExpertise());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDomainesExpertise(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += new Double(getTarifHoraire()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TuteurService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tuteurservice", "TuteurService"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RDV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tuteurservice", "RDV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rendezvousservice", "RendezVousService"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://serveur", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendrierHoraires");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tuteurservice", "calendrierHoraires"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://serveur", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendrierJours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tuteurservice", "calendrierJours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://serveur", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domainesExpertise");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tuteurservice", "domainesExpertise"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://serveur", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tuteurservice", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarifHoraire");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tuteurservice", "tarifHoraire"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
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
