package eu.aniketos.wp3.components.spdm.test.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceReference;
//import org.osgi.util.tracker.ServiceTracker;

import eu.aniketos.wp3.components.spdm.ds.api.HelloWorldService;
import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ISecurityProperty;
import eu.aniketos.data.IServiceCentre;

/**
 * Class which is Invoking DS service using default Activator
 * 
 * @author Bernard Butler
 * 
 */
public final class DefaultActivator implements BundleActivator {
	// private static ServiceTracker componentHelloWorldServiceTracker;
	private HelloWorldService hello_world;
	private IAgreementTemplate agreement_template;
	private ISecurityProperty security_property;
	private IServiceCentre service_centre;

	/**
	 * 
	 * @para BundleContext
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
		// HelloWorldService
		ServiceReference hello_serviceReference = context
				.getServiceReference(HelloWorldService.class.getName());
		this.hello_world = (HelloWorldService) context
				.getService(hello_serviceReference);
		System.out.println("Calling Declarative service using Bundle: "
				+ this.hello_world.helloWorld());

		// AgreementTemplate
		ServiceReference agreement_tmp_serviceReference = context
				.getServiceReference(IAgreementTemplate.class.getName());
		this.agreement_template = (IAgreementTemplate) context
				.getService(agreement_tmp_serviceReference);
		System.out.println("Calling Declarative service using Bundle: "
				+ this.agreement_template);

		// SecurityProperty
		ServiceReference security_property_serviceReference = context
				.getServiceReference(ISecurityProperty.class.getName());
		this.security_property = (ISecurityProperty) context
				.getService(security_property_serviceReference);
		System.out.println("Calling Declarative service using Bundle: "
				+ this.security_property);

		// ServiceCentre
		ServiceReference service_centre_serviceReference = context
				.getServiceReference(IServiceCentre.class.getName());
		this.service_centre = (IServiceCentre) context
				.getService(service_centre_serviceReference);
		System.out.println("Calling Declarative service using Bundle: "
				+ this.service_centre);

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
