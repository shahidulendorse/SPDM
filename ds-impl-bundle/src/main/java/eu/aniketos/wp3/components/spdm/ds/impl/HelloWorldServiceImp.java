package eu.aniketos.wp3.components.spdm.ds.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.Property;

import org.osgi.service.component.ComponentContext;

import eu.aniketos.wp3.components.spdm.ds.api.HelloWorldService;

//import org.apache.log4j.Logger;
//import org.osgi.service.log.LogService;



@Component(name = "hello-service")@Service
public class HelloWorldServiceImp implements HelloWorldService {

	@Property(value="Hello World Service")
	static final String CONSTANT_NAME = "service.description";
	@Property(value="Aniketos SPDM")
	static final String CONSTANT_NAME_1 = "service.vendor";
	@Property(value="*")
	static final String CONSTANT_NAME_2 = "service.exported.interfaces";
	@Property(value="org.apache.cxf.ws")
	static final String CONSTANT_NAME_3 = "service.exported.configs";
	@Property(value="http://localhost:9091/spdm_helloworld")
	static final String CONSTANT_NAME_4 = "org.apache.cxf.ws.address";

	// @Reference(name = "HelloWorld",
	// cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	// referenceInterface = HelloWorldService.class,
	// strategy = ReferenceStrategy.EVENT,
	// policy = ReferencePolicy.DYNAMIC,
	// bind = "bindHelloWorld",
	// unbind = "unbindHelloWorld")
	// private HelloWorldService service;


//	@Reference(name = "log",
//	cardinality = ReferenceCardinality.MANDATORY_UNARY,
//	referenceInterface = org.osgi.service.log.LogService.class,
//	policy = ReferencePolicy.STATIC,
//	bind = "bindLog",
//	unbind = "unbindLog")
//    private LogService log;
	// static Logger log = Logger.getLogger(HelloWorldServiceImp.class);

	   
	@Activate
	protected void activateHelloWorld(ComponentContext context) {
		// log.debug("Activate ReferenceManager");
		System.out.println("Activate HelloWorld Component");
//		log.log(LogService.LOG_INFO, "Activate HelloWorld Component!");

		// @TODO
	}

	@Deactivate
	protected void deactivateHelloWorld(ComponentContext context) {
		// log.debug("Deactivate ReferenceManager");
		System.out.println("Deactivate HelloWorld Component");
//	    log.log(LogService.LOG_INFO, "Deactivate HelloWorld Component!");
	    //@TODO
	}
	
	public String helloWorld() {
//	    log.log(LogService.LOG_INFO, "Calling method HelloWorld!");
		return "Hello TSSG";
	}
	
	// public void bindHelloWorld(HelloWorldService service) {
	// this.service = service;
	// System.out.println("Binding Service --- HelloWorld");
	// }
	//
	// public void unbindHelloWorld(HelloWorldService service) {
	// this.service = null;
	// System.out.println("Unbinding Service --- HelloWorld");
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

}