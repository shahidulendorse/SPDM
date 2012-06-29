package eu.aniketos.wp3.spdm.dao;

import java.util.List;

import eu.aniketos.data.ISecurityProperty;

/**
 * @SecurityPropertyDAO is an interface to @SecurityProperty persistence object.
 * @author: Bernard Butler
 */
public interface SecurityPropertyDao {
	public abstract void updateSecurityProperty(ISecurityProperty securityProperty);

	public abstract List<ISecurityProperty> getSecurityPropertiesByPropertyId(final String propertyId);
	
	public abstract void deleteSecurityProperty(ISecurityProperty securityProperty);

}
