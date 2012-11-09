/*
Copyright (c) 2012, Bernard Butler and Arif Fareed (Waterford Institute of Technology, Ireland), Project: FP7-ICT-257930 Aniketos
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 -  Neither the name of WATERFORD INSTITUTE OF TECHNOLOGY nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package eu.aniketos.wp3.components.spdm.ds.test;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.component.ComponentContext;

import eu.aniketos.wp3.components.spdm.ds.api.ISPSRepository;
import eu.aniketos.wp3.components.spdm.ds.api.IWebService;

import eu.aniketos.data.ISecurityDescriptor;
import eu.aniketos.data.ISecurityProperty;

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