/*
Copyright (c) 2012, Bernard Butler and Arif Fareed (Waterford Institute of Technology, Ireland), Project: FP7-ICT-257930 Aniketos
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 -  Neither the name of WATERFORD INSTITUTE OF TECHNOLOGY nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package eu.aniketos.wp3.components.spdm.console;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.io.File;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;



/**
 * Console Command Activator class which registers a list of Commands 
 * as properties with OSGi containers (Felix, Equinox and knopflerfish)
 * @author Bernard Butler and M. Arif Fareed (TSSG)
 *
 */
public class Activator implements BundleActivator {
	
    private ServiceRegistration serviceRegistration;


	
    /**
     * Register Console Command and notify user
     * BundleContext context
     */
    public void start(BundleContext context) throws Exception {
    	
    	System.out.println("++ SPDM Console Client Service Registered ++");

        Dictionary<String, Object> props = new Hashtable<String, Object>();
        props.put("org.knowhowlab.osgi.shell.group.id", "spdm");
        props.put("org.knowhowlab.osgi.shell.group.name", " commands");
        props.put("org.knowhowlab.osgi.shell.commands", new String[][]{
		{"lssp","lssp,lssp - List registered Security Properties."},
		{"lsws","lsws,lsws - List registered services."},
		{"unregister","unregister,unregister - unregister services."},
		{"delsp","delsp,delsp <id> - delete Security Property."},
		{"register","register,register - registering Service & Security Descriptor."},
		{"cache","cache,cache - Nr. of Entries in SPDM Repository."},
		{"commands","commands,commands - List supported commands."}});
        
        serviceRegistration = context.registerService(CommandLineService.class.getName(), new CommandLineService(context), props);
   
    
    }

    /**
     * Stop bundle of Command Class
     * BundleContext context
     */
    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
    }
}
