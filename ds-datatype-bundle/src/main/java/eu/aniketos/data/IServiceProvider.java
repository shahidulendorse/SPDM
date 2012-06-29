package eu.aniketos.data;

import java.security.cert.X509Certificate;

/**
 * IServiceProvider is an interface to helps to certify a security property
 * @author Bernard Butler
 *
 */
public interface IServiceProvider {

	public abstract String getID();
	
	public abstract X509Certificate getCertificate();
	
	public abstract void setID(String serviceProviderID);

	public abstract void setCertificate(X509Certificate serviceCertificate);

	public abstract String toString();
	
}
