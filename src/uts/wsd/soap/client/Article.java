/**
 * Article.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.wsd.soap.client;

public class Article  implements java.io.Serializable {
    private long id;

    private java.lang.String title;

    private java.util.Calendar publishedDate;

    private long authorId;

    private java.lang.String fullText;

    private java.lang.String categoryTag;

    public Article() {
    }

    public Article(
           long id,
           java.lang.String title,
           java.util.Calendar publishedDate,
           long authorId,
           java.lang.String fullText,
           java.lang.String categoryTag) {
           this.id = id;
           this.title = title;
           this.publishedDate = publishedDate;
           this.authorId = authorId;
           this.fullText = fullText;
           this.categoryTag = categoryTag;
    }


    /**
     * Gets the id value for this Article.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Article.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the title value for this Article.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Article.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the publishedDate value for this Article.
     * 
     * @return publishedDate
     */
    public java.util.Calendar getPublishedDate() {
        return publishedDate;
    }


    /**
     * Sets the publishedDate value for this Article.
     * 
     * @param publishedDate
     */
    public void setPublishedDate(java.util.Calendar publishedDate) {
        this.publishedDate = publishedDate;
    }


    /**
     * Gets the authorId value for this Article.
     * 
     * @return authorId
     */
    public long getAuthorId() {
        return authorId;
    }


    /**
     * Sets the authorId value for this Article.
     * 
     * @param authorId
     */
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }


    /**
     * Gets the fullText value for this Article.
     * 
     * @return fullText
     */
    public java.lang.String getFullText() {
        return fullText;
    }


    /**
     * Sets the fullText value for this Article.
     * 
     * @param fullText
     */
    public void setFullText(java.lang.String fullText) {
        this.fullText = fullText;
    }


    /**
     * Gets the categoryTag value for this Article.
     * 
     * @return categoryTag
     */
    public java.lang.String getCategoryTag() {
        return categoryTag;
    }


    /**
     * Sets the categoryTag value for this Article.
     * 
     * @param categoryTag
     */
    public void setCategoryTag(java.lang.String categoryTag) {
        this.categoryTag = categoryTag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Article)) return false;
        Article other = (Article) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.publishedDate==null && other.getPublishedDate()==null) || 
             (this.publishedDate!=null &&
              this.publishedDate.equals(other.getPublishedDate()))) &&
            this.authorId == other.getAuthorId() &&
            ((this.fullText==null && other.getFullText()==null) || 
             (this.fullText!=null &&
              this.fullText.equals(other.getFullText()))) &&
            ((this.categoryTag==null && other.getCategoryTag()==null) || 
             (this.categoryTag!=null &&
              this.categoryTag.equals(other.getCategoryTag())));
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
        _hashCode += new Long(getId()).hashCode();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getPublishedDate() != null) {
            _hashCode += getPublishedDate().hashCode();
        }
        _hashCode += new Long(getAuthorId()).hashCode();
        if (getFullText() != null) {
            _hashCode += getFullText().hashCode();
        }
        if (getCategoryTag() != null) {
            _hashCode += getCategoryTag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Article.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.wsd.uts/", "article"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publishedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullText");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fullText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoryTag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoryTag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
