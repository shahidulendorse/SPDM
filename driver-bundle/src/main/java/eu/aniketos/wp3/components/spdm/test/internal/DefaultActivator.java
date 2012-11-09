/*
Copyright (c) 2012, Bernard Butler and Arif Fareed (Waterford Institute of Technology, Ireland), Project: FP7-ICT-257930 Aniketos
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 -  Neither the name of WATERFORD INSTITUTE OF TECHNOLOGY nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package eu.aniketos.wp3.components.spdm.test.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceReference;
//import org.osgi.util.tracker.ServiceTracker;

import eu.aniketos.wp3.components.spdm.ds.api.ISPSRepository;
import eu.aniketos.data.ISecurityDescriptor;
import eu.aniketos.data.ISecurityProperty;

/**
 * Class which is Invoking DS service using default Activator
 * 
 * @author Bernard Butler and M. Arif Fareed (TSSG)
 * 
 */
public final class DefaultActivator implements BundleActivator {
	// private static ServiceTracker componentHelloWorldServiceTracker;
	private HelloWorldService hello_world;
	private ISecurityDescriptor security_descriptor;
	private ISecurityProperty security_property;
	private ISPSRepository sps_repository;

	/**
	 * 
	 * @param context
	 */
	public void start(BundleContext context) throws Exception {

		// Retrieveing Bundle Context
		// BundleContext bundleContext =
		// FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		// REGISTERING a service with BundleContext
		// bundleContext.registerService(IMyService.class.getName(), new
		// ServiceImpl(), null);
		// bundleContext.ungetService(serviceReference);

		// 1.)SERVICE TRACKER
		// componentHelloWorldServiceTracker = new ServiceTracker(context,
		// HelloWorldService.class.getName(),null);
		// this.hello_world =
		// (HelloWorldService)componentHelloWorldServiceTracker.getService();

		// 2.) Accessing Service With Classical OSGi Call
		System.out.println("=== Default Activator ====");

		// AgreementTemplate
		ServiceReference security_descriptor_serviceReference = context
				.getServiceReference(ISecurityDescriptor.class.getName());
		this.security_descriptor = (ISecurityDescriptor) context
				.getService(security_descriptor_serviceReference);
		System.out.println("Calling Declarative service using Bundle: "
				+ this.security_descriptor);

		// SecurityProperty
		ServiceReference security_property_serviceReference = context
				.getServiceReference(ISecurityProperty.class.getName());
		this.security_property = (ISecurityProperty) context
				.getService(security_property_serviceReference);
		System.out.println("Calling Declarative service using Bundle: "
				+ this.security_property);

		// ServiceCentre
		ServiceReference sps_repository_serviceReference = context
				.getServiceReference(ISPSRepository.class.getName());
		this.sps_repository = (ISPSRepository) context
				.getService(sps_repository_serviceReference);
		System.out.println("Calling Declarative service using Bundle: "
				+ this.sps_repository);

	}

	/**
	 * 
	 */
	public void stop(BundleContext context) throws Exception {

		System.out.println("Bundle Activator Stop");

		// this.hello_world = null;
		// this.agreement_template = null;
		// this.security_property = null;
		// this.service_centre = null;
		// @TODO

	}
}
