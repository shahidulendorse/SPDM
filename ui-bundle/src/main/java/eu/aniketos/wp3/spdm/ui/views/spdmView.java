package eu.aniketos.wp3.spdm.ui.views;


//import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
//import org.osgi.framework.BundleContext;
//import org.osgi.framework.ServiceReference;


import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ISecurityProperty;
import eu.aniketos.data.IServiceCentre;

import eu.aniketos.wp3.components.spdm.ds.impl.SecurityProperty;
import eu.aniketos.wp3.components.spdm.ds.impl.AgreementTemplate;

import eu.aniketos.wp3.spdm.ui.entry.Activator;


/*  We use this class to implement
the user interface view and access to other defined services */


public class spdmView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "aniketos.wp3.spdm.userinterface.views.spdmView";

	private IServiceCentre serviceCentre;
//	private TableViewer viewer;
	private Label labelService;
	private Label labelServiceProvider;
	private Label labelProperty;
	private Label labelValue;
	private Text textService;
	private Text textServiceProvider;
	private Text textProperty;
	private Text textValue;
	private Button buttonGet;
	private Button buttonSet;
	private Button buttonAll;
	String inputServiceID;
	String inputServiceProviderID;
	String inputPropertyID;
	String inputValue;
	String outputValue;


	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public spdmView() {
 		serviceCentre = (IServiceCentre) Activator.getDefault().getSPDM();
	}

	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		// set text fields,labels and buttons to get service id and property id
		parent.setLayout(new GridLayout(1,true));
		
		labelService = new Label(parent, 0);
		labelService.setText("Service ID:");
		textService=new Text(parent,SWT.CENTER);
		
		labelServiceProvider = new Label(parent, 0);
		labelServiceProvider.setText("Service ID:");
		textServiceProvider=new Text(parent,SWT.CENTER);
		
		labelProperty = new Label(parent, 0);
		labelProperty.setText("SecurityProperty ID:");
		textProperty=new Text(parent,SWT.CENTER);
		
		labelValue = new Label(parent, 0);
		labelValue.setText("Value:");
		textValue=new Text(parent,SWT.CENTER);
		
		buttonGet=new Button(parent,SWT.CENTER);
		buttonGet.setText("getProperty");
	
		buttonSet=new Button(parent,SWT.CENTER);
		buttonSet.setText("setProperty");
		
		buttonAll=new Button(parent,SWT.CENTER);
		buttonAll.setText("Get All");
		
		buttonGet.addSelectionListener(new SelectionAdapter() {
				
		 	  public void widgetSelected(SelectionEvent event) {
		 		//get input from the text fields, to be used as a parameters for the getProperty method
		 		inputServiceID=textService.getText();
		 		inputPropertyID=textProperty.getText();
		 		//inputValue=textValue.getText(); 		
		 		System.out.println("Retrieved: "+serviceCentre.getService(inputServiceID).getProperty(inputPropertyID).toString()+" From ServiceID: "+inputServiceID);
		      }	
		});
		
		buttonSet.addSelectionListener(new SelectionAdapter() {
			
		 	  public void widgetSelected(SelectionEvent event) {
		 		//get input from the text fields, to be used as a parameters for the getProperty method
		 		inputServiceID=textService.getText();
		 		inputServiceProviderID=textServiceProvider.getText();
		 		inputPropertyID=textProperty.getText();
		 		inputValue=textValue.getText();
		 		
		 		IAgreementTemplate inputService = (IAgreementTemplate) serviceCentre.getService(inputServiceID);
		 		if(null == inputService){
		 			inputService = new AgreementTemplate(inputServiceID, inputServiceProviderID);
			 		serviceCentre.addService(inputService);
		 			System.out.println("Created Service: "+inputServiceID);
		 		}
		 		
		 		ISecurityProperty inputProperty = (ISecurityProperty) inputService.getProperty(inputPropertyID);
		 		if(null == inputProperty){
		 			inputProperty = new SecurityProperty(inputPropertyID, inputValue);
		 			inputService.addProperty(inputProperty);
		 			System.out.println("Created SecurityProperty: "+inputPropertyID);
		 		}
		 		else{
		 			inputService.getProperty(inputPropertyID).setValue(inputValue);
		 		}
		 		
				System.out.println("Set: ServiceID: "+inputServiceID+" "+serviceCentre.getService(inputServiceID).getProperty(inputPropertyID).toString());
		      }
	     
		});
		
		buttonAll.addSelectionListener(new SelectionAdapter() {
			
		 	  public void widgetSelected(SelectionEvent event) {

		 		  System.out.println(serviceCentre.toString());
		      }
		});
	
	}

	

	
	
	public void setFocus() {
		//viewer.getControl().setFocus();
	}
}