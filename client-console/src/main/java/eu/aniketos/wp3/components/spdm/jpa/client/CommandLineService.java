package eu.aniketos.wp3.components.spdm.jpa.client;

import eu.aniketos.wp3.components.spdm.jpa.model.AgreementTemplate;
import eu.aniketos.wp3.components.spdm.jpa.model.SecurityProperty;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;

import javax.persistence.*;
import java.io.PrintWriter;
import java.util.List;

/**
 * CommandLineService provides the implementation of the service
 * commands registered with an OSGi container. 
 * The following commands can be used to persist Agreement Templates
 * and its relevant Security Properties.
 * lssp - list Security Properties
 * lsag - list Agreement Templates
 * delsp <id> - delete Security Property
 * addag <value> - add Agreement Template
 * addsp <value> <freshness> <agreementtemplate_id> - add Security Property
 * commands - list of commands
 * 
 * @author Bernard Butler
 *
 */
public class CommandLineService {
	
    private BundleContext bc;
    private static final String STUDENTS_UNIT = "jpa.students";

    /**
     * Obtain @BundleContext Handler
     * @param bc
     */
    public CommandLineService(BundleContext bc) {
        this.bc = bc;
    }
    
    /**
     * Help command which list the commands descriptions
     * @param out
     * @param args
     */
    public void commands(PrintWriter out, String... args) {
    	try{
    		out.println("lssp - list Security Properties");
    		out.println("lsag - list Agreement Templates");
	    	out.println("delag <id> - delete Agreement Template");
	    	out.println("delsp <id> - delete Security Property");
	    	out.println("addag <value> - add Agreement Template");
	    	out.println("addsp <value> <freshness> <agreementtemplate_id> - add Security Property");
	    	out.println("commands - list of commands");
            
         } catch (Exception e) {
    			e.printStackTrace(out);
        }
    }

    /**
     * List @SecurityProperty Command which returns all existing @SecurityPropreties
     * @param out
     * @param args
     */
    public void lssp(PrintWriter out, String... args) {
        try {
            ServiceReference reference = getEntityManagerFactoryServiceReference();
            try {
                EntityManagerFactory emf = (EntityManagerFactory) bc.getService(reference);
                EntityManager em = emf.createEntityManager();
                Query query = em.createNamedQuery(SecurityProperty.GET_SECURITIY_PROPERTIES);
                List<SecurityProperty> result = query.getResultList();
                if (result != null) {
                    out.println(String.format("SecurityProperties: %d", result.size()));
                    for (SecurityProperty security_property : result) {
                        out.println(String.format("%d %s %s %d", security_property.getId(), security_property.getValue(), security_property.getFreshness(), security_property.getAgreementTemplate().getId()));
                    }
                } else {
                    out.println("Result is null");
                }
                em.close();
            } finally {
                bc.ungetService(reference);
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }


    /**
     * List @AgreementTemplate Command which return all existing @AgreementTemplate(s)
     * @param out
     * @param args
     */
    public void lsag(PrintWriter out, String... args) {
        try {
            ServiceReference reference = getEntityManagerFactoryServiceReference();
            try {
                EntityManagerFactory emf = (EntityManagerFactory) bc.getService(reference);
                EntityManager em = emf.createEntityManager();
                Query query = em.createNamedQuery(AgreementTemplate.GET_AGREEMENT_TEMPLATES);
                List<AgreementTemplate> result = query.getResultList();
                if (result != null) {
                    out.println(String.format("AgrementTemplates: %d", result.size()));
                    for (AgreementTemplate agreement_template : result) {
                        out.println(String.format("%d %s", agreement_template.getId(), agreement_template.getValue()));
                    }
                } else {
                    out.println("Result is null");
                }
                em.close();
            } finally {
                bc.ungetService(reference);
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }


    /**
     * Add a new @AgreementTemplate command 
     * @param out
     * @param args
     */
    public void addag(PrintWriter out, String... args) {
        if (args == null || args.length != 1) {
            out.println("Agreement Template value param is missed");
            return;
        }
        try {
            ServiceReference reference = getEntityManagerFactoryServiceReference();
            try {
                EntityManagerFactory emf = (EntityManagerFactory) bc.getService(reference);
                EntityManager em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                try {
                    transaction.begin();
                    AgreementTemplate agreement_template = new AgreementTemplate(args[0]);
                    em.persist(agreement_template);
                    transaction.commit();
                    out.println(String.format("Agreement Template is persisted with ID: %d", agreement_template.getId()));
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace(out);
                }
                em.close();
            } finally {
                bc.ungetService(reference);
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    /**
     * Delete an exisitng @AgreementTemplate Command
     * @param out
     * @param args
     */
    public void delag(PrintWriter out, String... args) {
        if (args == null || args.length != 1) {
            out.println("Agreement Template ID param is missed");
            return;
        }
        try {
            ServiceReference reference = getEntityManagerFactoryServiceReference();
            try {
                EntityManagerFactory emf = (EntityManagerFactory) bc.getService(reference);
                EntityManager em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                try {
                    transaction.begin();
                    int templateId = Integer.valueOf(args[0]);
                    AgreementTemplate agreement_template = getAgreementTemplate(em, templateId);
                    if (agreement_template == null) {
                        throw new Exception(String.format("Unknown Agreement Template ID: %d", templateId));
                    }
                    em.remove(agreement_template);
                    transaction.commit();
                    out.println(String.format("Agreement with ID: %d is removed", templateId));
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace(out);
                }
                em.close();
            } finally {
                bc.ungetService(reference);
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    /**
     * Delete an exisiting @SecurityProperty command.
     * @param out
     * @param args
     */
    public void delsp(PrintWriter out, String... args) {
        if (args == null || args.length != 1) {
            out.println("Security Property ID param is missed");
            return;
        }
        try {
            ServiceReference reference = getEntityManagerFactoryServiceReference();
            try {
                EntityManagerFactory emf = (EntityManagerFactory) bc.getService(reference);
                EntityManager em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                try {
                    transaction.begin();
                    int propertyId = Integer.valueOf(args[0]);
                    SecurityProperty security_property = getSecurityProperty(em, propertyId);
                    if (security_property == null) {
                        throw new Exception(String.format("Unknown Security Property ID: %d", propertyId));
                    }
                    em.remove(security_property);
                    transaction.commit();
                    out.println(String.format("Security Property with ID: %d is removed", propertyId));
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace(out);
                }
                em.close();
            } finally {
                bc.ungetService(reference);
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    /**
     * Add a new @SecurityProperty command
     * @param out
     * @param args
     */
    public void addsp(PrintWriter out, String... args) {
        if (args == null || args.length != 3) {
            out.println("Wrong params");
            return;
        }
        try {
            ServiceReference reference = getEntityManagerFactoryServiceReference();
            try {
                EntityManagerFactory emf = (EntityManagerFactory) bc.getService(reference);
                EntityManager em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                try {
                    transaction.begin();
                    int templateId = Integer.valueOf(args[2]);
                    AgreementTemplate agreement_template = getAgreementTemplate(em, templateId);
                    if (agreement_template == null) {
                        throw new Exception(String.format("Unknown Agreement Tempalte ID: %d", templateId));
                    }
                    SecurityProperty security_property = new SecurityProperty(args[0], args[1], agreement_template);
                    em.persist(security_property);
                    transaction.commit();
                    out.println(String.format("Security Property is persisted with ID: %d", security_property.getId()));
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace(out);
                }
                em.close();
            } finally {
                bc.ungetService(reference);
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    /**
     * Local method to obtain an @AgreementTemplate given it's ID.
     * @param em
     * @param templateId
     * @return
     */
    private AgreementTemplate getAgreementTemplate(EntityManager em, int templateId) {
        Query query = em.createNamedQuery(AgreementTemplate.GET_AGREEMENT_TEMPLATE_BY_ID);
        query.setParameter("agreementtemplateId", templateId);
        try {
            return (AgreementTemplate) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Local method to obtain an @SecurityProperty given it's ID.
     * @param em
     * @param securitypropertyId
     * @return
     */
    private SecurityProperty getSecurityProperty(EntityManager em, int securitypropertyId) {
        Query query = em.createNamedQuery(SecurityProperty.GET_SECURITY_PROPERTY_BY_ID);
        query.setParameter("securitypropertyId", securitypropertyId);
        try {
            return (SecurityProperty) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Local method to obtain an @EntityManager Reference for persistence.
     * @return
     * @throws Exception
     */
    private ServiceReference getEntityManagerFactoryServiceReference() throws Exception {
        ServiceReference[] serviceReferences = bc.getServiceReferences(EntityManagerFactory.class.getName(),
                String.format("(%s=%s)", EntityManagerFactoryBuilder.JPA_UNIT_NAME, STUDENTS_UNIT));
        if (serviceReferences != null && serviceReferences.length > 0) {
            return serviceReferences[0];
        } else {
            throw new Exception("EntityManagerFactory is not available");
        }
    }
}
