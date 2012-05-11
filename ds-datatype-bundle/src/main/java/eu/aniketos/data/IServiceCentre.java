package eu.aniketos.data;

import java.util.Map;

public interface IServiceCentre {

	public abstract Map<String, IAgreementTemplate> getAgreementTemplates();

	public abstract Map<String, IAgreementTemplate> getProviderAgreementTemplates(String serviceProviderID);
	
	public abstract Map<String, ICompositionPlan> getCompositionPlans();
	
	public abstract Map<String, IServiceProvider> getServiceProviders();
	
	public abstract IAgreementTemplate getService(String service_id);
	
	public abstract void addService(IAgreementTemplate agreementTemplate);
	
	public abstract String toString();

}
