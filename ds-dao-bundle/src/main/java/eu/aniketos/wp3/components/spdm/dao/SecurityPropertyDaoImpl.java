package eu.aniketos.wp3.spdm.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import eu.aniketos.wp3.spdm.dao.SecurityPropertyDao;
import eu.aniketos.data.ISecurityProperty;

/**
 * Data Access Object for SecurityProperty
 * 
 * @author: bbutler
 */
public class SecurityPropertyDaoImpl extends JpaDaoSupport implements SecurityPropertyDao {

	private static Logger logger = Logger.getLogger(SecurityPropertyDaoImpl.class);

	public SecurityPropertyDaoImpl() {
		super();
	}
	
	public void addSecurityProperty(ISecurityProperty SecurityProperty) {

		try {
			getJpaTemplate().persist(SecurityProperty);
			getJpaTemplate().flush();

			if (logger.isDebugEnabled()) {
				logger.debug("SecurityProperty saved");
			}
		} 
		catch (Exception e) {
			logger.error("addSecurityProperty: " + e.getMessage());
		}
	}

	public void updateSecurityProperty(ISecurityProperty SecurityProperty) {

		try {
			getJpaTemplate().merge(SecurityProperty);
			getJpaTemplate().flush();

			if (logger.isDebugEnabled()) {
				logger.debug("SecurityProperty saved");
			}
		} 
		catch (Exception e) {
			logger.error("updateSecurityProperty: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<ISecurityProperty> getSecurityPropertiesByPropertyId(final String serviceId) {

		List<ISecurityProperty> securityProperties = new ArrayList<ISecurityProperty>();
		
		List<Object> results = null;
		try {
			//TODO: needs checking
			results = (ArrayList<Object>) getJpaTemplate().find("from SecurityProperty s where s.service_id = '"+serviceId+"'");
			getJpaTemplate().flush();
			//em.createQuery("s from SecurityProperty s, Agent a where s.agent = a and a.name='"+agentName+"'")
		} catch (Exception e) {
			logger.error("getSecurityPropertiesByPropertyId: " + e.getMessage());
		}
		
		if (results != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("results  " + results.size());
			}

			for (Object result : results) {

				ISecurityProperty SecurityProperty = (ISecurityProperty) result;
				securityProperties.add(SecurityProperty);
			}
		} 
		else {
			logger.warn("query returned null");
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getSecurityPropertiesByPropertyId " + securityProperties.size());
		}
		
		if (securityProperties != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("found SecurityPropertys");
			}
		} 
				
		return securityProperties;
	}

	public void deleteSecurityProperty(ISecurityProperty securityProperty) {

		String serviceId = securityProperty.getPropertyID();

		logger.info("deleting SecurityProperty from " + serviceId);
		
		try {
			
			securityProperty = getJpaTemplate().merge(securityProperty);
			getJpaTemplate().remove(securityProperty);
			getJpaTemplate().flush();

			if (logger.isDebugEnabled()) {
				logger.debug("deleted record for SecurityProperty " + securityProperty.getPropertyID());
			}

		} catch (Exception e) {
			logger.error("deleteSecurityProperty: " + e.getMessage());
		}

	}


}
