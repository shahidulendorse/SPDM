package eu.aniketos.wp3.spdm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import eu.aniketos.wp3.spdm.dao.AgreementTemplateDao;
import eu.aniketos.data.IAgreementTemplate;

/**
 * Data Access Object for source members
 * 
 * @author: bbutler
 */
public class AgreementTemplateDaoImpl  extends JpaDaoSupport implements AgreementTemplateDao {

	private static Logger logger = Logger.getLogger(AgreementTemplateDaoImpl.class);
	
	
	public AgreementTemplateDaoImpl() {
		super();
	}

	public void addAgreementTemplate(IAgreementTemplate agreementTemplate) {

		try {
			getJpaTemplate().persist(agreementTemplate);
			getJpaTemplate().flush();

			//agreementTemplates.put(agreementTemplate.getName(), agreementTemplate);
			logger.debug("addAgreementTemplate: agreementTemplate saved");
		} catch (Exception e) {
			logger.error("addAgreementTemplate: agreementTemplate: " + e.getMessage());
		}
	}
	
	public void updateAgreementTemplate(IAgreementTemplate agreementTemplate) {

		try {
			getJpaTemplate().merge(agreementTemplate);
			getJpaTemplate().flush();

			//services.put(service.getName(), service);
			logger.debug("updateAgreementTemplate: agreementTemplate saved");
		} catch (Exception e) {
			logger.error("updateAgreementTemplate: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<IAgreementTemplate> getAllAgreementTemplates() {
		List<IAgreementTemplate> agreementTemplates = new ArrayList<IAgreementTemplate>();
		List<Object> results = null;
		
		try {
			results = (ArrayList<Object>) getJpaTemplate().find("from AgreementTemplate");
			getJpaTemplate().flush();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		if (results != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("results  " + results.size());
			}

			for (Object result : results) {
				agreementTemplates.add((IAgreementTemplate) result);
			}
		} else {
			logger.debug("getAllAgreementTemplates: query returned null");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getAllAgreementTemplates: loaded agreementTemplates " + agreementTemplates.size());
		}
		return agreementTemplates;
	}

	public IAgreementTemplate getAgreementTemplate(final String id) {
		IAgreementTemplate agreementTemplate = null;
		try {
			
			//agreementTemplate = (AgreementTemplate) getJpaTemplate().find("Select a from AgreementTemplate a where a.id='"+id+"'");
			agreementTemplate = (IAgreementTemplate) getJpaTemplate().getReference(IAgreementTemplate.class, id);
			getJpaTemplate().flush();

		} catch (Exception e) {
			logger.error("getAgreementTemplate: " + e.getMessage());
		}
		if (agreementTemplate != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("getAgreementTemplate: found agreementTemplate: " + agreementTemplate.getAgreementTemplateID());
			}
		} else {
			logger.debug("getAgreementTemplate: no agreementTemplate found");
		}
		return agreementTemplate;
	}

	public void deleteAgreementTemplate(IAgreementTemplate agreementTemplate) {
		String agreementTemplateName = agreementTemplate.getAgreementTemplateID();
		
		try {

			agreementTemplate = getJpaTemplate().merge(agreementTemplate);
			getJpaTemplate().remove(agreementTemplate);
			getJpaTemplate().flush();

			if (logger.isDebugEnabled()) {
				logger.debug("deleteAgreementTemplate: deleted record for agreementTemplate " + agreementTemplateName);
			}
		} catch (Exception e) {
			logger.error("deleteAgreementTemplate: " + e.getMessage());
		}

	}


	@SuppressWarnings("unchecked")
	public List<String> getAllAgreementTemplateNames() {
		
		List<String> agreementTemplateNames = new ArrayList<String>();
		List<Object> results = null;
		
		try {
			results = (ArrayList<Object>) getJpaTemplate().find("select name from AgreementTemplate");
			getJpaTemplate().flush();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		if (results != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("getAllAgreementTemplateNames: results  " + results.size());
			}

			for (Object result : results) {
				String agreementTemplateName = (String) result;
				agreementTemplateNames.add(agreementTemplateName);
			}
		} else {
			logger.debug("getAllAgreementTemplateNames: query returned null");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getAllAgreementTemplateNames: loaded services " + agreementTemplateNames.size());
		}
		return agreementTemplateNames;
	}
}
