package eu.aniketos.data;

import java.util.Date;
import java.util.Set;

/**
 * ISecurityProerpty is an interface that specify the behavior of the
 * Security Properties.
 * 
 * @author Bernard Butler
 *
 */
public interface ISecurityProperty {
	
	public abstract String getPropertyID();

	public abstract String getValue();

	public abstract Date getFreshness();

	public abstract void setPropertyID(String propertyID);

	public abstract void setValue(String value);

	public abstract void setFreshness(Date freshness);

	public abstract Set<IAgreementTemplate> getAgreementTemplates();

	public abstract void setAgreementTemplates(Set<IAgreementTemplate> agreementTemplates);
}
