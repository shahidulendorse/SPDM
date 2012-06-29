package eu.aniketos.wp3.components.spdm.jpa.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Console Command Activator class which registers a list of Commands 
 * as properties with OSGi containers (Felix, Equinox, knopflerfish)
 * @author Bernard Butler
 *
 */
public class Activator implements BundleActivator {
	
    private ServiceRegistration serviceRegistration;

    /**
     * Register Console Command and notify user
     * @BundleContext context
     */
    public void start(BundleContext context) throws Exception {
    	
    	System.out.println("++++++++++++ Persistence Activator isalive ++++++++++");

        Dictionary<String, Object> props = new Hashtable<String, Object>();
        props.put("org.knowhowlab.osgi.shell.group.id", "jpa");
        props.put("org.knowhowlab.osgi.shell.group.name", "JPA tips commands");
        props.put("org.knowhowlab.osgi.shell.commands", new String[][]{
                {"lssp", "lssp - list Security Properties"},
                {"lsag", "lsag - list Agreement Templates"},
                {"delag", "delag <id> - delete Agreement Template"},
                {"delsp", "delsp <id> - delete Security Property"},
                {"addag", "addag <value> - add Agreement Template"},
                {"addsp", "addsp <value> <freshness> <agreementtemplate_id> - add Security Property"},
                {"commands", "commands - List All Commands"}});
        
        serviceRegistration = context.registerService(CommandLineService.class.getName(), new CommandLineService(context), props);
    }

    /**
     * Stop bundle of Command Class
     * @BundleContext context
     */
    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
    }
}
