package eu.aniketos.wp3.spdm.dao;

import java.util.List;

import eu.aniketos.data.IAgreementTemplate;

/**
 * Data Access Object interface for AgreementTemplate
 *
 * @author: bbutler
 */
public interface AgreementTemplateDao {
	public abstract void updateAgreementTemplate(IAgreementTemplate agreementTemplate);

	public abstract IAgreementTemplate getAgreementTemplate(final String source);

	public abstract List <IAgreementTemplate> getAllAgreementTemplates();
	
	public abstract void deleteAgreementTemplate(IAgreementTemplate agreementTemplate);
	
//	public abstract List <String> getAllServiceNames();

}
