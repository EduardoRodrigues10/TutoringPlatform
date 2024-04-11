/**
 * EtudiantService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package etudiantservice;

public class EtudiantService  implements java.io.Serializable {
    private rendezvousservice.RendezVousService[] RDV;

    private boolean isInterne;

    private java.lang.String name;

    public EtudiantService() {
    }

    public EtudiantService(
           rendezvousservice.RendezVousService[] RDV,
           boolean isInterne,
           java.lang.String name) {
           this.RDV = RDV;
           this.isInterne = isInterne;
           this.name = name;
    }


    /**
     * Gets the RDV value for this EtudiantService.
     * 
     * @return RDV
     */
    public rendezvousservice.RendezVousService[] getRDV() {
        return RDV;
    }


    /**
     * Sets the RDV value for this EtudiantService.
     * 
     * @param RDV
     */
    public void setRDV(rendezvousservice.RendezVousService[] RDV) {
        this.RDV = RDV;
    }


    /**
     * Gets the isInterne value for this EtudiantService.
     * 
     * @return isInterne
     */
    public boolean isIsInterne() {
        return isInterne;
    }


    /**
     * Sets the isInterne value for this EtudiantService.
     * 
     * @param isInterne
     */
    public void setIsInterne(boolean isInterne) {
        this.isInterne = isInterne;
    }


    /**
     * Gets the name value for this EtudiantService.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this EtudiantService.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EtudiantService)) return false;
        EtudiantService other = (EtudiantService) obj;
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
            this.isInterne == other.isIsInterne() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        _hashCode += (isIsInterne() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EtudiantService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://etudiantservice", "EtudiantService"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RDV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://etudiantservice", "RDV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rendezvousservice", "RendezVousService"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://serveur", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInterne");
        elemField.setXmlName(new javax.xml.namespace.QName("http://etudiantservice", "isInterne"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://etudiantservice", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
