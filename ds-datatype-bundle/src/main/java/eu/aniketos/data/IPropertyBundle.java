package eu.aniketos.data;

import java.util.Map;

/**
 * IPropertyBundle is an interface for generic properties regardless
 * of intention or negotiation status.
 * AgreementTemplates, Contracts and ConsumerPolicies are all types of IPropertyBundle
 * 
 * @see IContract
 * @see IAgreementTemplate
 * @see IConsumerPolicy
 * 
 * @author David Lamb, LJMU
 * @revised by Bo Zhou LJMU Aug 2011 
 * @revised by Bernard Butler & Barry Mulcahy TSSG Aug 2011
 * 
 */
public interface IPropertyBundle
{
	public abstract Map<String, ISecurityProperty> getProperties();

	public abstract ISecurityProperty getProperty(String propertyID);
	
	public abstract void setProperties(Map<String, ISecurityProperty> properties);

	public abstract void addProperty(ISecurityProperty property);

	public abstract void removeProperty(String propertyID);
		
}
