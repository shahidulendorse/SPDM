package eu.aniketos.wp3.components.spdm.jpa.model;

import javax.persistence.*;
import java.util.List;

/**
 * 
 * JPA enabled @AgreementTempalte class used to persist a @AgreementTempalte instance.
 * @author Bernard Butler
 *
 */
@NamedQueries({
        @NamedQuery(name = AgreementTemplate.GET_AGREEMENT_TEMPLATES, query = "SELECT DISTINCT record"
                + " FROM AgreementTemplate record"
                + " ORDER BY record.value"),
        @NamedQuery(name = AgreementTemplate.GET_AGREEMENT_TEMPLATE_BY_ID, query = "SELECT DISTINCT record"
                + " FROM AgreementTemplate record"
                + " WHERE record.id =: agreementtemplateId")
})
@Entity
@Table(name = "AGREEMENTTEMPLATES")
public class AgreementTemplate {
    public static final String GET_AGREEMENT_TEMPLATES = "GET_AGREEMENT_TEMPLATES";
    public static final String GET_AGREEMENT_TEMPLATE_BY_ID= "GET_AGREEMENT_TEMPLATE_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String value;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "template")
    private List<SecurityProperty> security_properties;

    public AgreementTemplate() {
    }

    /**
     * Value is an Conspect Description
     * @param value
     */
    public AgreementTemplate(String value) {
        this.value = value;
    }

    /**
     * 
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Lsit all security properties exist in an @AgreementTemplate.
     * @return
     */
    public List<SecurityProperty> getSecurityProperties() {
        return security_properties;
    }

    public void setSecurityProperties(List<SecurityProperty> security_properties) {
        this.security_properties = security_properties;
    }
}
