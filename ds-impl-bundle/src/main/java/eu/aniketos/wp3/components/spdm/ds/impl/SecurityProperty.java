package eu.aniketos.wp3.components.spdm.ds.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.hibernate.validator.Length;
//import org.hibernate.validator.NotNull;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ISecurityProperty;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;

//import org.osgi.service.log.LogService;

@Component(name="security-property-component")@Service
public class SecurityProperty implements Serializable, ISecurityProperty{
	
	/**
	 * @author: bbutler and bmulcahy
	 */
	private static final long serialVersionUID = 1L;
	
	@Property(value="Security Property Service")
	static final String CONSTANT_NAME = "service.description";
	@Property(value="Aniketos SPDM")
	static final String CONSTANT_NAME_1 = "service.vendor";
	
	@Property(value="*")
	static final String CONSTANT_NAME_2 = "service.exported.interfaces";
	@Property(value="org.apache.cxf.ws")
	static final String CONSTANT_NAME_3 = "service.exported.configs";
	@Property(value="http://localhost:9091/spdm_securityproperty")
	static final String CONSTANT_NAME_4 = "org.apache.cxf.ws.address";

	//HowTo Reference this classes in client application
	// @Reference(name = "security_property",
	// cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	// referenceInterface = ISecurityProperty.class,
	// strategy = ReferenceStrategy.EVENT,
	// policy = ReferencePolicy.DYNAMIC,
	// bind = "bindSecurityProperty",
	// unbind = "unbindSecurityProperty")
	// private ISecurityProperty security_property;
	
//	@Reference(name = "log",
//	cardinality = ReferenceCardinality.MANDATORY_UNARY,
//	referenceInterface = org.osgi.service.log.LogService.class,
//	policy = ReferencePolicy.STATIC,
//	bind = "bindLog",
//	unbind = "unbindLog")
//    private LogService log;
	// static Logger log = Logger.getLogger(HelloWorldServiceImp.class);
	
	
	@Id
	@Column(name = "sp_id")
	private String propertyID;
	
	@Column(name = "sp_value")
	private String value;
	
	@Column(name = "sp_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date freshness;

	@ManyToMany(mappedBy="securityProperties")
	private Set<IAgreementTemplate> agreementTemplates = new HashSet<IAgreementTemplate>();

	
	@Activate
	protected void activateSecurityProperty(ComponentContext context) {
		// log.debug("Activate ReferenceManager");
		System.out.println("Activate Security Property Component");
//		log.log(LogService.LOG_INFO, "Activate Security Property Component!");

		// @TODO
	}

	@Deactivate
	protected void deactivateSecurityProperty(ComponentContext context) {
		// log.debug("Deactivate ReferenceManager");
		System.out.println("Deactivate Security Property Component");
//	    log.log(LogService.LOG_INFO, "Deactivate Security Property Component!");
	    
	    //@TODO
	}
	 
    //Binding signatures for this service for client applications
	// public void bindSecurityProperty(ISecurityProperty security_property) {
	// this.security_property = security_property;
	// System.out.println("Binding Service --- SecurityProperty");
	// }
	//
	// public void unbindSecurityProperty(ISecurityProperty security_property) {
	// this.security_property = null;
	// System.out.println("Unbinding Service --- SecurityProperty");
	// }  
	
//	protected void bindLog(LogService log)
//	{
//	    this.log = log;
//	}
//
//	protected void unbindLog(LogService log)
//	{
//	    this.log = null;
//	}
	
	public SecurityProperty(){
	}

	public SecurityProperty(String propertyID, String value, Date freshness){
		this.propertyID = propertyID;
		this.value = value;
		this.freshness = freshness;
	}
	
	public SecurityProperty(String propertyID, String value){
		this.propertyID = propertyID;
		this.value = value;
		this.freshness = null;
	}
	
	public SecurityProperty(String propertyID){
		this.propertyID = propertyID;
		this.value = null;
		this.freshness = null;
	}
	
	public String getPropertyID(){
		return propertyID;
	}

	public String getValue(){
		return value;
	}

	public Date getFreshness(){
		return freshness;
	}

	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setFreshness(Date freshness) {
		this.freshness = freshness;
	}

	public Set<IAgreementTemplate> getAgreementTemplates() {
		return agreementTemplates;
	}

	public void setAgreementTemplates(Set<IAgreementTemplate> agreementTemplates) {
		this.agreementTemplates = agreementTemplates;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (o == null || !(o instanceof SecurityProperty)) {

			return false;
		}

		SecurityProperty other = (SecurityProperty) o;

		/*
		 * equivalence by propertyID
		 */
		SecurityProperty castOther = (SecurityProperty) other;
		return new EqualsBuilder().append(propertyID, castOther.getPropertyID()).append(value,
				castOther.getValue()).append(freshness, castOther.getFreshness()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(441293447, 2056268651).append(propertyID).append(
				value).append(freshness).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("propertyID: ", propertyID)
				.append("value: ", value).append("freshness: ", freshness).toString();
	}

}
