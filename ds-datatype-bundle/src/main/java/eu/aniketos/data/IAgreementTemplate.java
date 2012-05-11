package eu.aniketos.data;

import java.util.Map;
import java.util.Set;

/**
 * 
 * IAgreementTemplate - an interface specifying a Agreement Template - that is a
 * proposed contract (set of properties) offered by a service.
 * 
 * @author David Lamb, LJMU
 * @revised by Bo Zhou LJMU Aug 2011 
 * @revised by Bernard Butler & Barry Mulcahy TSSG Aug 2011
 * @revised by Bernard Butler, TSSG Dec 2011
 */
public interface IAgreementTemplate extends IPropertyBundle
{
	public abstract String getAgreementTemplateID();

	public abstract void setAgreementTemplateID(String agreementTemplateID);

	public abstract Set<ISecurityProperty> getSecurityProperties();

	public abstract void setSecurityProperties(Set<ISecurityProperty> securityProperties);
	
	public abstract Map<String, ISecurityProperty> getSecurityPropertyMap();

	public abstract void setSecurityPropertyMap(Map<String, ISecurityProperty> securityPropertyMap);
	
	public abstract String getServiceProviderID();

	public abstract void setServiceProviderID(String serviceProviderID);

	public abstract ISecurityProperty getProperty(String propertyID);
	
	public abstract void addProperty(ISecurityProperty property);

	public abstract void removeProperty(String propertyID);

}
