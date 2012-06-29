package eu.aniketos.wp3.components.spdm.ds.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinTable;

//import org.hibernate.validator.Length;
//import org.hibernate.validator.NotNull;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;

import eu.aniketos.data.ISecurityProperty;
import eu.aniketos.data.IAgreementTemplate;

//import org.apache.log4j.Logger;
import org.osgi.service.component.ComponentContext;
//import org.osgi.service.log.LogService;

/**
 * AgreementTemplate is the implementation of @IAgreementTemplate interface.
 * An AgreementTemplate is a collection of security properties. This class
 * provider the necessary methods to manipulate @SecurityProperty
 * 
 * @author Bernard Butler
 *
 */
@Component(name="agreemet-template-component")@Service
public class AgreementTemplate implements Serializable, IAgreementTemplate {
	
	/**
	 * @author: bbutler and bmulcahy
	 */
	private static final long serialVersionUID = 1L;

	@Property(value="Agreement Template Service")
	static final String CONSTANT_NAME = "service.description";
	@Property(value="Aniketos SPDM")
	static final String CONSTANT_NAME_1 = "service.vendor";
	@Property(value="*")
	static final String CONSTANT_NAME_2 = "service.exported.interfaces";
	@Property(value="org.apache.cxf.ws")
	static final String CONSTANT_NAME_3 = "service.exported.configs";
	@Property(value="http://localhost:9091/spdm_agreementtemplate")
	static final String CONSTANT_NAME_4 = "org.apache.cxf.ws.address";

	//HowTo Reference this classes in client application
	// @Reference(name = "agreement_template",
	// cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	// referenceInterface = IAgreementTemplate.class,
	// strategy = ReferenceStrategy.EVENT,
	// policy = ReferencePolicy.DYNAMIC,
	// bind = "bindAgreementTemplate",
	// unbind = "unbindAgreementTemplate")
	// private IAgreementTemplate agreement_template;
	
//	@Reference(name = "log",
//	cardinality = ReferenceCardinality.MANDATORY_UNARY,
//	referenceInterface = org.osgi.service.log.LogService.class,
//	policy = ReferencePolicy.STATIC,
//	bind = "bindLog",
//	unbind = "unbindLog")
//    private LogService log;
	// static Logger log = Logger.getLogger(HelloWorldServiceImp.class);
	
	@Id
	@Column(name = "at_id")
	private String agreementTemplateID;
	
	@Column(name = "at_serviceProvider_id")
	private String serviceProviderID;
	
	@JoinTable(name="FAT_sp_at", joinColumns = {@JoinColumn(name = "at_id")}, inverseJoinColumns = {@JoinColumn(name = "sp_id")})
	private Set<ISecurityProperty> securityProperties;
	
    private Map<String, ISecurityProperty> securityPropertyMap;
	//There will be a certificate object here in the future.
	
    /**
     * Register @AgreementTempalte service with OSGi container
     * @param context Handle to declarative service
     */
	@Activate
	protected void activateAgreementTemplate(ComponentContext context) {
		// log.debug("Activate ReferenceManager");
		System.out.println("Activate Agreement Template Component");
//		log.log(LogService.LOG_INFO, "Activate Agreement Template Component!");

	}
	
	/**
	 * UnRegister @AgreementTemplater Service with OSCi container 
	 * @param context
	 */
	@Deactivate
	protected void deactivateAgreementTemplate(ComponentContext context) {
		// log.debug("Deactivate ReferenceManager");
		System.out.println("Deactivate AgreementTemplate Component");
//	    log.log(LogService.LOG_INFO, "Deactivate Agreement Template Component!");
	}
	 
    //Binding signatures for this service for client applications
	// public void bindAgreementTemplate(IAgreementTemplate agreement_template) {
	// this.agreement_tempalte = agreement_template;
	// System.out.println("Binding Service --- AgreementTemplate");
	// }
	//
	// public void unbindAgreementTemplate(IAgreementTemplate agreement_template) {
	// this.agreement_template = null;
	// System.out.println("Unbinding Service --- AgreementTemplate");
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
    
	/**
	 * Constructor for instantiating @AgreementTempalte 
	 * @param agreementTemplateID
	 * @param serviceProviderID
	 */
	public AgreementTemplate(String agreementTemplateID, String serviceProviderID){		
		this.agreementTemplateID = agreementTemplateID;
		this.serviceProviderID = serviceProviderID;
		init();
	}

	/**
	 * No argument constructor for instantiating @AgreementTemplate
	 */
	public AgreementTemplate(){
		init();
	}

	private void init() {
		securityPropertyMap = new TreeMap<String, ISecurityProperty>();
		securityProperties = new HashSet<ISecurityProperty>();
	}
	
	/**
	 * Method to obtain @AgreementTemplate ID.
	 * @return String value
	 */
	public String getAgreementTemplateID() {
		return agreementTemplateID;
	}
	
	/**
	 * Method to update @AgreementTemplate ID.
	 * @param agreementTemplateID
	 */
	public void setAgreementTemplateID(String agreementTemplateID) {
		this.agreementTemplateID = agreementTemplateID;
	}

	/**
	 * Method to obtain @SecurityProperty
	 * @return @ISecurityProperty
	 */
	public Set<ISecurityProperty> getSecurityProperties() {
		return securityProperties;
	}

	/**
	 * Method to update @SecurityProperty
	 * @param securityProperties
	 */
	public void setSecurityProperties(Set<ISecurityProperty> securityProperties) {
		this.securityProperties = securityProperties;
	}

	public Map<String, ISecurityProperty> getSecurityPropertyMap() {
		return securityPropertyMap;
	}

	public void setSecurityPropertyMap(
			Map<String, ISecurityProperty> securityPropertyMap) {
		this.securityPropertyMap = securityPropertyMap;
		this.securityProperties = (Set<ISecurityProperty>) this.securityPropertyMap.values();
	}

	public Map<String, ISecurityProperty> getProperties() {
		return getSecurityPropertyMap();
	}

	public void setProperties(Map<String, ISecurityProperty> properties) {
		setSecurityPropertyMap(properties);
	}

	public String getServiceProviderID() {
		return serviceProviderID;
	}

	public void setServiceProviderID(String serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}

	public ISecurityProperty getProperty(String propertyID) {
		return securityPropertyMap.get(propertyID);
	}
	
	public void addProperty(ISecurityProperty property) {
		securityPropertyMap.put(property.getPropertyID(), property);
		securityProperties.add(property);
	}

	public void removeProperty(String propertyID) {
		ISecurityProperty delprop = securityPropertyMap.get(propertyID);
		securityPropertyMap.remove(propertyID);
		if (null != delprop) {
			securityProperties.remove(delprop);
		}
	}
	
	/**
	 * Comparision object for comparing @AgreementTemplate instances
	 */
	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (o == null || !(o instanceof AgreementTemplate)) {
			return false;
		}

		AgreementTemplate other = (AgreementTemplate) o;

		/*
		 * equivalence by agreementTemplateID
		 */
		AgreementTemplate castOther = (AgreementTemplate) other;
		EqualsBuilder eqBuilder = new EqualsBuilder().append(agreementTemplateID, castOther.getAgreementTemplateID());
		for (String propertyID:securityPropertyMap.keySet()) {
			eqBuilder.append(securityPropertyMap.get(propertyID), castOther.getProperty(propertyID));
		}
		return eqBuilder.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcBuilder = new HashCodeBuilder(441293447, 2056268651).append(agreementTemplateID);
		for (String propertyID:securityPropertyMap.keySet()) {
			hcBuilder.append(securityPropertyMap.get(propertyID));
		}
		return hcBuilder.toHashCode();
	}

	@Override
	public String toString() {
		ToStringBuilder tsBuilder = new ToStringBuilder(this).append("agreementTemplateID: ", agreementTemplateID);
		for (String propertyID:securityPropertyMap.keySet()) {
			tsBuilder.append("propertyID: ", securityPropertyMap.get(propertyID));
		}
		return tsBuilder.toString();
	}

	
}
