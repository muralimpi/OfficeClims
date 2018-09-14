package com.serole.claims.service.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.DestinationDataProvider;

@Component
public class ElsecoClaimsToHybrisClient {
	private static final Logger LOG = LogManager.getLogger(ElsecoClaimsToHybrisClient.class);	
	/**
	 * Load the properties to conect to Destination on a JCO - RFC
	 * 
	 * @param host
	 * @param sysNr
	 * @param client
	 * @param user
	 * @param pswrd
	 * @param lang
	 * @return
	 */
	public Properties loadProperties(String host, String sysNr, String client, String user, String pswrd, String lang) {
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - loadProperties ");
        Properties connectProperties = new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, host);
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  sysNr);
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, client);
        connectProperties.setProperty(DestinationDataProvider.JCO_USER,   user);
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, pswrd);
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG,   lang);      
               
        return connectProperties;
    }

	/**
	 * Create Hybris Connection Data File based on the various properties
	 * 
	 * @param destinationName
	 * @param connectProperties
	 */
	public void createHybrisConnectionDataFile(String destinationPropsName, Properties connectProperties)
    {
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - createHybrisConnectionDataFile ");
        File hybrisCfg = new File(destinationPropsName+".jcoDestination");
        try
        {
            FileOutputStream fos = new FileOutputStream(hybrisCfg, false);
            connectProperties.store(fos, "Validate the Connection Parameters - Claims To Hybris.");
            fos.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to create the destination files", e);
        }
    }
	
	
	/**
	 * A method to print the Connection Attributes used to Connected to the Client
	 * 
	 * @param destination
	 * @throws JCoException
	 */
	public void printDestinationAttributes(JCoDestination destination) throws JCoException 	
	{      
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - printDestinationAttributes ");
		LOG.info("=======================  D E S T I N A T I O N      A T T R I B U T E S  ==========================");
        LOG.info(destination.getAttributes());
        LOG.info("_____________________________          C O N N E C T E D        ___________________________________");
    }

	/**
	 * A method to validate the Connection to the Destination
	 * 
	 * @throws JCoException
	 */
	public JCoDestination destionationConnectManager(String destinationName) throws JCoException
    {
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - destionationConnectManager ");
        JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
        destination.ping();
        printDestinationAttributes(destination);
        return destination;
    }
	
	/**
	 * Provide the specified function based on available 'Standard FM' on the remote Destination
	 * 
	 * @param destination
	 * @param clientStandardFM
	 * @return
	 * @throws JCoException
	 */
	public JCoFunction connToJcoFunctionUsingDestination(JCoDestination destination, String clientStandardFM) throws JCoException
    {     
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - connToJcoFunctionUsingDestination ");
        JCoFunction function = destination.getRepository().getFunction(clientStandardFM);
        if (function == null) {
            throw new RuntimeException("Unable to find the Standard FM "+clientStandardFM+" at the Destination client.");
        }
        return function;
    }
	
	/**
	 * Provide the specified function based on available 'Standard FM' using Jco Repository of the remote Destination
	 * 
	 * @param destination
	 * @param clientStandardFM
	 * @return
	 * @throws JCoException
	 */
	public JCoFunction connToJcoFunctionUsingJCoRepository(JCoDestination destination, String clientStandardFM) throws JCoException
	{
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - connToJcoFunctionUsingJCoRepository ");

		JCoContext.begin(destination);
		JCoRepository repository = destination.getRepository();
		if (repository == null) {
			throw new RuntimeException("Unable to find the Repository at Stnd FM " + clientStandardFM + " at the Destination client.");
		}
		JCoFunctionTemplate template = repository.getFunctionTemplate(clientStandardFM);
		JCoFunction function = template.getFunction();
		if (function == null) {
			throw new RuntimeException("Unable to find the Standard FM " + clientStandardFM + " at the Destination client.");
		}
		return function;
	}
	
	/**
	 * Execute the function on the Destination connected with the standard FM
	 * 
	 * @param function
	 * @param destination
	 * @param clientStandardFM
	 * @return
	 * @throws JCoException 
	 */
	public JCoFunction executeJcoFunction(JCoFunction function, JCoDestination destination, String clientStandardFM) throws JCoException
	{
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - executeJcoFunction ");
		function.execute(destination);
        LOG.info(clientStandardFM+" function execution is finished:");
		return function;
	}
	
	/**
	 * Close the connection to Destination
	 * 
	 * @param destination
	 * @throws JCoException 
	 */
	public void closeJcoConnection(JCoDestination destination) throws JCoException {
		LOG.info("*****	Received a call to ElsecoClaimsToHybrisClient - closeJcoConnection ");
		 JCoContext.end(destination);
	}
	
}
