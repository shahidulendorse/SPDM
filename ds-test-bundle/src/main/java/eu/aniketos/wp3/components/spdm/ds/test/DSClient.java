package eu.aniketos.wp3.components.spdm.ds.test;
/**
 * Declarative Service Client
 * @author
 * 
 */
import org.apache.felix.scr.annotations.Activate;
import org.osgi.service.component.ComponentContext;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferenceStrategy;

import eu.aniketos.wp3.components.spdm.ds.api.HelloWorldService;
import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ISecurityProperty;
import eu.aniketos.data.IServiceCentre;

@Component
public class DSClient {

	// Hello World CLIENT SAMPLE Ref. Template
	@Reference(name = "hello_service",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = HelloWorldService.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindHelloWorld",
	 unbind = "unbindHelloWorld")
	 private HelloWorldService hello_service;
	 
	
	 //AgreementTemplate CLIENT Ref. CODE Template
	 @Reference(name = "agreement_template",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = IAgreementTemplate.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindAgreementTemplate",
	 unbind = "unbindAgreementTemplate")
	 private IAgreementTemplate agreement_template;
	 
	 //SecurityProperty CLIENT Ref. CODE Template
	 @Reference(name = "security_property",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = ISecurityProperty.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindSecurityProperty",
	 unbind = "unbindSecurityProperty")
	 private ISecurityProperty security_property;

	 //ServiceCentre CLIENT Ref. CODE Template
	 @Reference(name = "service_centre",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = IServiceCentre.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindServiceCentre",
	 unbind = "unbindServiceCentre")
	 private IServiceCentre service_centre;
			 
	@Activate
	public void activate(ComponentContext cc) {
		
		System.out.println("\n=== Declarative Service Activator ===");
		System.out.println("Calling Declarative Service: "
		+ this.hello_service.helloWorld());
		System.out.println("Calling Declarative Service: "
		+ this.agreement_template);
		System.out.println("Calling Declarative Service: "
		+ this.security_property);
		System.out.println("Calling Declarative Service: "
		+ this.service_centre);

	}

	//Binding & Unbinding HelloWorld
	 public void bindHelloWorld(HelloWorldService service) {
		 this.hello_service = service;
		 System.out.println("Binding --- HelloWorld Service");
	 }
	
	 public void unbindHelloWorld(HelloWorldService service) {
		 this.hello_service = null;
		 System.out.println("Unbinding --- HelloWorld Service");
	 }	
	 
	//Binding & Unbinding AgreementTemplate
	 public void bindAgreementTemplate(IAgreementTemplate agreement_template) {
		 this.agreement_template = agreement_template;
		 System.out.println("Binding Service --- AgreementTemplate");
	 }
	
	 public void unbindAgreementTemplate(IAgreementTemplate agreement_template) {
		 this.agreement_template = null;
		 System.out.println("Unbinding Service --- AgreementTemplate");
	 }  	 
	 
	 //Binding & Unbinding SecurityProperty 
	 public void bindSecurityProperty(ISecurityProperty security_property) {
		 this.security_property = security_property;
		 System.out.println("Binding Service --- SecurityProperty");
	 }
	
	 public void unbindSecurityProperty(ISecurityProperty security_property) {
		 this.security_property = null;
		 System.out.println("Unbinding Service --- SecurityProperty");
	 }  
	 
	 //Binding & Unbinding ServiceCentre
	 public void bindServiceCentre(IServiceCentre service_centre) {
		 this.service_centre = service_centre;
		 System.out.println("Binding Service --- ServiceCentre");
	 }
	
	 public void unbindServiceCentre(IServiceCentre service_centre) {
		 this.service_centre = null;
		 System.out.println("Unbinding Service --- ServiceCentre");
	 }  
}
