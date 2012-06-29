package eu.aniketos.wp3.components.spdm.jpa.model;

import javax.persistence.*;

/**
 * JPA enabled @SecurityProperty class used to persist a @SecurityProperty instance.
 * @author Bernard Butler
 *
 */
@NamedQueries({
        @NamedQuery(name = SecurityProperty.GET_SECURITIY_PROPERTIES, query = "SELECT DISTINCT record"
                + " FROM SecurityProperty record"
                + " ORDER BY record.freshness"),
        @NamedQuery(name = SecurityProperty.GET_SECURITY_PROPERTY_BY_ID, query = "SELECT DISTINCT record"
                + " FROM SecurityProperty record"
                + " WHERE record.id =: securitypropertyId")
})
@Entity
@Table(name = "SECURITYPROPERTIES")
public class SecurityProperty {
    public static final String GET_SECURITIY_PROPERTIES = "GET_SECURITIY_PROPERTIES";
    public static final String GET_SECURITY_PROPERTY_BY_ID = "GET_SECURITY_PROPERTY_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;
    private String freshness;

    @ManyToOne(optional = false)
    private AgreementTemplate template;

    public SecurityProperty() {
    }

    /**
     * Constructor for @SecurityProperty object.
     * @param value
     * @param freshness
     * @param template
     */
    public SecurityProperty(String value, String freshness, AgreementTemplate template) {
        this.value = value;
        this.freshness = freshness;
        this.template = template;
    }

    /**
     * Value of @SecurityProperty
     * @return
     */
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Signed verfication date of @SecurityProperty
     * @return
     */
    public String getFreshness() {
        return freshness;
    }

    public void setFreshness(String freshness) {
        this.freshness = freshness;
    }

    public int getId() {
        return id;
    }

    /**
     * Obtain an @AgreementTempalte Object.
     * @return
     */
    public AgreementTemplate getAgreementTemplate() {
        return template;
    }

    /**
     * Set a reference to an @AgreementTemplate Object.
     * @param template
     */
    public void setAgreementTempalte(AgreementTemplate template) {
        this.template = template;
    }
}
