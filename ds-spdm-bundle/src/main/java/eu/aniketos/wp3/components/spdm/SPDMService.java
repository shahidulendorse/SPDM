/*
Copyright (c) 2012, Bernard Butler and Arif Fareed (Waterford Institute of Technology, Ireland), Project: FP7-ICT-257930 Aniketos
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 -  Neither the name of WATERFORD INSTITUTE OF TECHNOLOGY nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package eu.aniketos.wp3.components.spdm;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.ReferenceStrategy;

import org.osgi.service.component.ComponentContext;

import eu.aniketos.wp3.components.spdm.ds.api.ISPSRepository;
import eu.aniketos.wp3.components.spdm.ds.api.IPersistenceManager;

import eu.aniketos.wp3.components.spdm.ds.impl.BidiMultiHashMap.EntrySet;

import eu.aniketos.wp3.components.spdm.ds.api.IWebService;
import eu.aniketos.wp3.components.spdm.ds.api.ISPDMService;

import eu.aniketos.data.ISecurityDescriptor;
import eu.aniketos.data.ISecurityProperty;

/**
 * 
 * Declarative Service Client
 * @author Bernard Butler and M. Arif Fareed (TSSG)
 *
 */
@Component(name="SPDM-service")@Service
public class SPDMService implements ISPDMService {

	@Property(value = "SPDM Service")
	static final String CONSTANT_NAME = "service.description";
	@Property(value = "Aniketos SPDM")
	static final String CONSTANT_NAME_1 = "service.vendor";
	@Property(value = "*")
	static final String CONSTANT_NAME_2 = "service.exported.interfaces";
	@Property(value = "org.apache.cxf.ws")
	static final String CONSTANT_NAME_3 = "service.exported.configs";
	@Property(value = "http://localhost:9091/spdm_service")
	static final String CONSTANT_NAME_4 = "org.apache.cxf.ws.address";
	
	 //SecurityDescriptor CLIENT Ref. CODE Template
	 @Reference(name = "security_desciptor",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = ISecurityDescriptor.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindSecurityDescriptor",
	 unbind = "unbindSecurityDescriptor")
	 private ISecurityDescriptor security_descriptor;
	 
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
	 @Reference(name = "sps_repository",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = ISPSRepository.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindSPSRepository",
	 unbind = "unbindSPSRepository")
	 private ISPSRepository sps_repository;
			 
	 
	 //ServiceCentre CLIENT Ref. CODE Template
	 @Reference(name = "web_service",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = IWebService.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindWebService",
	 unbind = "unbindWebService")
	 private IWebService web_service;
	 
		// HowTo Reference this classes in client application
	 @Reference(name = "persistence_manager",
	 cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
	 referenceInterface = IPersistenceManager.class,
	 strategy = ReferenceStrategy.EVENT,
	 policy = ReferencePolicy.DYNAMIC,
	 bind = "bindPersistenceManager",
	 unbind = "unbindPersistenceManager")
	 private IPersistenceManager persistence_manager;


	 
	 
	/**
     * Register DSClient as a service with OSGi container
	 * @param context
	 */
	@Activate
	public void activateSPDMService(ComponentContext context) {
		
		System.out.println("\n=== SPDM Declarative Service Activator ===");
		System.out.println("Calling Declarative Service: "
		+ this.security_descriptor);
		System.out.println("Calling Declarative Service: "
		+ this.security_property);

		init();
	}

	/**
	 * UnRegister SPDMService Service with OSGi container
	 * 
	 * @param context
	 */
	@Deactivate
	protected void deactivateSPDMService(ComponentContext context) {
		// log.debug("Deactivate ReferenceManager");
		System.out.println("Deactivate SPDM Service");
		// log.log(LogService.LOG_INFO,
		// "Deactivate Agreement Template Component!");
	}
	
	protected void init() {
		this.sps_repository.registerService(this.web_service, this.security_descriptor);
		System.out.println("Repository Size : "+ this.sps_repository.repository_size());
		System.out.println("+++ Printing SPS Repository +++: "+ this.sps_repository.lookUpSecurityProperty(this.web_service));
	}

	 /**
	  * Announcing SecurityDescriptor as an OSGi Service
	  * @param security_descriptor service
	  */
	//Binding & Unbinding SecurityDescriptor
	 public void bindSecurityDescriptor(ISecurityDescriptor security_descriptor) {
		 this.security_descriptor = security_descriptor;
		 System.out.println("Binding Service --- SecurityDescriptor");
	 }
	
	 /**
	  * Unbinding SecurityDescriptor service
	  * @param security_descriptor
	  */
	 public void unbindSecurityDescriptor(ISecurityDescriptor security_descriptor) {
		 this.security_descriptor = null;
		 System.out.println("Unbinding Service --- SecurityDescriptor");
	 }  	 
	 
	 /**
	  * Announcing SecurityProperty as an OSGi Service 
	  * @param security_property service
	  */
	 //Binding & Unbinding SecurityProperty 
	 public void bindSecurityProperty(ISecurityProperty security_property) {
		 this.security_property = security_property;
		 System.out.println("Binding Service --- SecurityProperty");
	 }
	
	 /**
	  * Unbinding SecurityProperty service
	  * @param security_property
	  */
	 public void unbindSecurityProperty(ISecurityProperty security_property) {
		 this.security_property = null;
		 System.out.println("Unbinding Service --- Security Property");
	 }  
	 
	 /**
	  * Announcing WebServiceas an OSGi Service 
	  * @param web_service service
	  */
	 public void bindWebService(IWebService web_service) {
		 this.web_service = web_service;
		 System.out.println("Binding Service --- Web Serive");
	 }
	
	 /**
	  * Unbinding WebService service
	  * @param web_service
	  */
	 public void unbindWebService(IWebService web_service) {
		 this.web_service = null;
		 System.out.println("Unbinding Service --- Web Service");
	 }  

	 
	 /**
	  * Announcing PersistenceManager as an OSGi Service 
	  * @param persistence_manager service
	  */
	 public void bindPersistenceManager(IPersistenceManager persistence_manager) {
		 this.persistence_manager = persistence_manager;
		 System.out.println("Binding Service --- Persistence Manager");
	 }
	
	 /**
	  * Unbinding PersistenceManager service
	  * @param persistence_manager
	  */
	 public void unbindPersistenceManager(IPersistenceManager persistence_manager) {
		 this.persistence_manager = null;
		 System.out.println("Unbinding Service --- Persistence Manager");
	 }  

	 
	 /**
	  * Announcing SPSRepository as an OSGi Service
	  * @param sps_repository
	  */
	 //Binding & Unbinding ServiceCentre
	 public void bindSPSRepository(ISPSRepository sps_repository) {
		 this.sps_repository = sps_repository;
		 System.out.println("Binding Service --- SPS Repository");
		 		 
		 
//		 this.web_service.setID( "http://testservice?wsdl");
		 
//		 this.sps_repository.put("a", "1");
//		 this.sps_repository.put("b", "1");
//		 this.sps_repository.put("c", "1");
//		 this.sps_repository.put("d", "2");
//		 this.sps_repository.put("e", "2");
//		 this.sps_repository.put("f", "3");
//		 this.sps_repository.put("g", "4");
		 System.out.println("SPS Repository Size ======:" + this.sps_repository.repository_size());
		
	 }
	
	 /**
	  * Unbinding SPSRepository
	  * @param sps_repository
	  */
	 public void unbindSPSRepository(ISPSRepository sps_repository) {
		 this.sps_repository = null;
		 System.out.println("Unbinding Service --- SPS Repository");
	 }  
	 
	 
	 public Set<ISecurityProperty> lookUpSecurityProperty(IWebService service) {
		 return this.sps_repository.lookUpSecurityProperty(service);
	 }
	 
	 public Set<IWebService> lookupService(ISecurityProperty sp) {
		 return this.sps_repository.lookupService(sp);
     }

	 public void registerService(IWebService service, ISecurityProperty sp) {
		 this.sps_repository.registerService(service, sp);
	 }
	 
	 public void unregisterService(IWebService service){
		 Set<ISecurityProperty> properties = this.lookUpSecurityProperty(service);
		 for(ISecurityProperty sp: properties) {
			 this.sps_repository.removeSecurityProperty(sp);	 
		 }		 
	 }

	 public void removeSeucrityProeprty(ISecurityProperty sp){
		this.sps_repository.removeSecurityProperty(sp);	 
	 }		 

	 public void emptyCache() {
		 this.sps_repository.clear_repository();
	 }
	 
	 public int cache_size() {
		 return this.sps_repository.repository_size();
	 }
	 
//	 public EntrySet<IService,ISecurityProperty> repository() {
//		 return this.sps_repository.
//	 
//	 }
	 
	 public void persist_cache() {
		 Set<Map.Entry<IWebService,ISecurityProperty>> sps_set = this.sps_repository.getEntriest(); 
		 
		 for(Map.Entry<IWebService,ISecurityProperty> entry: sps_set) {
			 this.persistence_manager.saveService(entry.getKey());
			 this.persistence_manager.saveSecurityProperty(entry.getValue());
		 }
		 
		 System.out.println("Cache is Persisted");	 

		 
	 }

	 public void print_repository() {
		 
		 Set<Map.Entry<IWebService,ISecurityProperty>> sps_set = this.sps_repository.getEntriest(); 
		 
		 for(Map.Entry<IWebService,ISecurityProperty> entry: sps_set) {
			 System.out.println(sps_set);	 
		 }
		 
	 }
 
 }

