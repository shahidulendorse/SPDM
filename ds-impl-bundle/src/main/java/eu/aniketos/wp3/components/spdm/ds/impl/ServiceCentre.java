package eu.aniketos.wp3.components.spdm.ds.impl;

import java.util.Map;

import java.util.TreeMap;

import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.IServiceCentre;
import eu.aniketos.data.IServiceProvider;

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

/**
 * A local class for manuplating @AgreementTemplate & @SecurityProperty.
 * 
 * @author  Bernard Butler
 */

@Component(name="service-centre-component")@Service
public class ServiceCentre implements IServiceCentre {
	
	@Property(value="Security Centre Service")
	static final String CONSTANT_NAME = "service.description";
	@Property(value="Aniketos SPDM")
	static final String CONSTANT_NAME_1 = "service.vendor";

	@Property(value="*")
	static final String CONSTANT_NAME_2 = "service.exported.interfaces";
	@Property(value="org.apache.cxf.ws")
	static final String CONSTANT_NAME_3 = "service.exported.configs";
	@Property(value="http://localhost:9091/spdm_servicecentre")
	static final String CONSTANT_NAME_4 = "org.apache.cxf.ws.address";
	//HowTo Reference this classes in client application
	// @Reference(name = "service_centre",
	// cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	// referenceInterface = IServiceCentre.class,
	// strategy = ReferenceStrategy.EVENT,
	// policy = ReferencePolicy.DYNAMIC,
	// bind = "bindServiceCentre",
	// unbind = "unbindServiceCentre")
	// private IServiceCentre service_centre;
	
//	@Reference(name = "log",
//	cardinality = ReferenceCardinality.MANDATORY_UNARY,
//	referenceInterface = org.osgi.service.log.LogService.class,
//	policy = ReferencePolicy.STATIC,
//	bind = "bindLog",
//	unbind = "unbindLog")
//    private LogService log;
	// static Logger log = Logger.getLogger(HelloWorldServiceImp.class);
	
	
	private Map<String, IAgreementTemplate> agreementTemplates;
	//There will be a certificate object here in the future.
	
	/**
     * Register @ServiceCentre service with OSGi container
	 * @param context
	 */
	@Activate
	protected void activateServiceCentre(ComponentContext context) {
		// log.debug("Activate ReferenceManager");
		System.out.println("Activate Service Centre Component");
//		log.log(LogService.LOG_INFO, "Activate Service Centre Component!");

		// @TODO
	}

	/**
	 * UnRegister @ServiceCentre Service with OSCi container 
	 * @param context
	 */
	@Deactivate
	protected void deactivateServiceCentre(ComponentContext context) {
		// log.debug("Deactivate ReferenceManager");
		System.out.println("Deactivate Service Centre Component");
//	    log.log(LogService.LOG_INFO, "Deactivate Service Centre Component!");
	    
	    //@TODO
	}
	 
    //Binding signatures for this service for client applications
	// public void bindServiceCentre(ISecurityCentre service_property) {
	// this.service_centre = service_centre;
	// System.out.println("Binding Service --- ServiceCentre");
	// }
	//
	// public void unbindService(ISecurityCentre service_centre) {
	// this.service_centre = null;
	// System.out.println("Unbinding Service --- ServiceCentre");
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
	 * 
	 */
	public ServiceCentre(){		
		agreementTemplates = new TreeMap<String, IAgreementTemplate>();	
	}
	
	/**
	 * Get stored @AgreementTemplates.
	 * @return
	 */
	public Map<String, IAgreementTemplate> getAgreementTemplates() {
		return agreementTemplates;
	}

	/**
	 * 
	 * @param agreementTemplateID
	 * @return
	 */
	public IAgreementTemplate getService(String agreementTemplateID) {
		return agreementTemplates.get(agreementTemplateID);
	}
	
	/**
	 * Add a new @AgreementTemplate to service store
	 * @param agreementTemplate
	 */
	public void addService(IAgreementTemplate agreementTemplate) {
		agreementTemplates.put(agreementTemplate.getAgreementTemplateID(), agreementTemplate);
	}

	/**
	 * Move an existing @AgreementTemplate from service store.
	 * @param agreementTemplateID
	 */
	public void removeAgreementTemplate(String agreementTemplateID) {
		agreementTemplates.remove(agreementTemplateID);
	}
	
	
	/**
	 * Add a ServiceProvider
	 * @param serviceProviderID
	 * @return
	 */
	public Map<String, IAgreementTemplate> getProviderAgreementTemplates(
			String serviceProviderID) {
		// TODO Auto-generated method stub: Filtered by serviceProviderID
		return null;
	}

	/**
	 * Obtain a composition Plan
	 * @return
	 */
	public Map<String, ICompositionPlan> getCompositionPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return a composition plan
	 * @return
	 */
	public Map<String, IServiceProvider> getServiceProviders() {
		// TODO Auto-generated method stub
		Map<String, IServiceProvider> serviceProviderMap = new TreeMap<String, IServiceProvider>();
		for (String agreementTemplateID : agreementTemplates.keySet()) {
//			if (agreementTemplates.get(agreementTemplateID).getServiceProviderID())
		}
		return null;
	}

	/**
	 * 
	 */
	public String toString(){
		String temp = "Service Centre: \n";
		for(String agreementTemplateID:agreementTemplates.keySet()){
			temp = temp + agreementTemplates.get(agreementTemplateID).toString()+"\n";
		}
		return temp;
	}
	
}
