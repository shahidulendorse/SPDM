package eu.aniketos.wp3.components.spdm.ds.test;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.component.ComponentContext;

import eu.aniketos.wp3.components.spdm.ds.api.HelloWorldService;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.data.IContract;
import eu.aniketos.data.ISecurityProperty;
import eu.aniketos.data.IServiceCentre;
import eu.aniketos.data.IServiceProvider;

//This is a component and it consumes a service
@Component
public class ServiceConsumer {

  //  @Reference(
    //        cardinality=ReferenceCardinality.OPTIONAL_MULTIPLE,
      //      referenceInterface=EntityPropertiesIdentifier.class,
         //   strategy=ReferenceStrategy.EVENT,
        //    policy=ReferencePolicy.DYNAMIC,
          //  bind="bindEntityPropertiesIdentifier",
           // unbind="unbindEntityPropertiesIdentifier")
    
	// Service reference is preserved in a field
//	@Reference
//	private HelloWorldService service;
//	@Reference
//	private ICompositionPlan composition_plan;
//	@Reference
//	private IConsumerPolicy consumer_policy;
//	@Reference
//	private IAgreementTemplate agreement_template;
//	@Reference
//	private IContract contract;
//	@Reference
//	private IServiceCentre service_centre;
//	@Reference
//	private IServiceProvider service_provider;
//	@Reference
//	private ISecurityProperty security_property;

	// When needs of the component is staisfied the component will be activated
	// by calling this function
	@Activate
	public void activate(ComponentContext cc) {

//		System.out.println("Calling Declarative Service HelloWorld: "
//				+ this.service.helloWorld());

//		System.out
//				.println("Calling Declarative Service --- CompositionPlan - toString: "
//						+ this.composition_plan);
//		System.out
//				.println("Calling Declarative Service --- ConsumerPolicy - toString: "
//						+ this.consumer_policy);
//		this.agreement_template.setAgreementTemplateID("TestAgreementTemplate@ TSSG");
//		System.out
//				.println("Calling Declarative Service --- AgreementTemplate - toString: "
//						+ this.agreement_template);
//		System.out
//				.println("Calling Declarative Service --- Contract - toString: "
//						+ this.contract);
//
//		System.out
//				.println("Calling Declarative Service --- ServiceCentre - toString: "
//						+ this.service_centre);
//		System.out
//				.println("Calling Declarative Service --- ServiceProvider - toString: "
//						+ this.service_provider);
//		System.out
//				.println("Calling Declarative Service --- SecurityProperty - toString: "
//						+ this.security_property);
	}

	// When a HelloWorldService service is discovered it will be given to this
	// component through this method
	
//	public void bindService(HelloWorldService service) {
//		this.service = service;
//		System.out.println("Binding Service --- HelloWorld");
//	}

//	public void bindService(ICompositionPlan composition_plan) {
//		this.composition_plan = composition_plan;
//		System.out.println("Binding Service --- Composition Plan");
//	}

//	public void bindService(IConsumerPolicy consumer_policy) {
//		this.consumer_policy = consumer_policy;
//		System.out.println("Binding Service --- Consumer Policy");
//	}

//	public void bindService(IAgreementTemplate agreement_template) {
//		this.agreement_template = agreement_template;
//		System.out.println("Binding Service --- AgreementTemplate");
//
//	}

//	public void bindService(IContract contract) {
//		this.contract = contract;
//		System.out.println("Binding Service --- Contract");
//
//	}

//	public void bindService(IServiceCentre service_centre) {
//		this.service_centre = service_centre;
//		System.out.println("Binding Service --- Service Centre");
//
//	}

//	public void bindService(IServiceProvider service_provider) {
//		this.service_provider = service_provider;
//		System.out.println("Binding Service --- Service Provider");
//
//	}

//	public void bindService(ISecurityProperty security_property) {
//		this.security_property = security_property;
//		System.out.println("Binding Service --- Security Property");
//
//	}
//
//	public void unbindService(HelloWorldService service) {
//		this.service = null;
//		System.out.println("Unbinding Service --- HelloWorld");
//	}

//	public void unbindService(IAgreementTemplate agreement_template) {
//		this.agreement_template = null;
//		System.out.println("Unbinding Service --- AgreementTemplate");
//
//	}

//	public void undbindService(ICompositionPlan composition_plan) {
//		this.composition_plan = null;
//		System.out.println("Unbinding Service --- Composition Plan");
//	}

//	public void unbindService(IConsumerPolicy consumer_policy) {
//		this.consumer_policy = null;
//		System.out.println("Unbinding Service --- Consumer Policy");
//	}
//

//	public void unbindService(IServiceCentre service_centre) {
//		this.service_centre = null;
//		System.out.println("Unbinding Service --- Service Centre");
//
//	}

//	public void unbindService(IServiceProvider service_provider) {
//		this.service_provider = null;
//		System.out.println("Unbinding Service --- Service Provider");
//
//	}

//	public void unbindService(ISecurityProperty security_property) {
//		this.security_property = null;
//		System.out.println("Unbinding Service --- Security Property");
//
//	}
}