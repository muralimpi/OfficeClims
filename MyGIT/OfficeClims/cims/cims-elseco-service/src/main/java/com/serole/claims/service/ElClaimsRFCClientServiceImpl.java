package com.serole.claims.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.json.JSONObject;
import org.json.XML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.serole.claims.core.claimsFactory.AbstractClaimsMgmtFactory;
import com.serole.claims.core.constants.AppConstants;
import com.serole.claims.model.Elseco.ElsecoHybrisPayHistory;
import com.serole.claims.model.constants.ElsecoClaimsToHybrisConstant;
import com.serole.claims.model.exceptions.ElsecoClaimsServiceException;
import com.serole.claims.model.rfc.hybris.ElsecoClaimsHybrisResponse;
import com.serole.claims.model.rfc.hybris.ElsecoCrmPqm;
import com.serole.claims.model.rfc.hybris.HEADER_DATA_EXT;
import com.serole.claims.model.rfc.hybris.HEADER_DATA_INT;
import com.serole.claims.model.rfc.hybris.HEADER_DATA_MARKET;
import com.serole.claims.model.rfc.hybris.HEADER_DATA_PAY;
import com.serole.claims.model.rfc.hybris.HEADER_DATA_STAMP_MEMBER;
import com.serole.claims.model.rfc.hybris.IM_HEADER_DATA;
import com.serole.claims.service.factoryManager.ElsecoClaimsFactoryManager;
import com.serole.claims.service.factoryManager.ElsecoClaimsProcessManager;
import com.serole.claims.service.util.ElsecoClaimsToHybrisClient;
import com.serole.claims.service.util.ElsecoClaimsUtil;


/**
 * A implementation Class at a service layer for the interface IElsecoAviationService
 * @author Serole_Vijay
 *
 */
@Component
public class ElClaimsRFCClientServiceImpl implements ElClaimsRFCClientService {
	private static final Logger LOG = LogManager.getLogger(ElClaimsRFCClientServiceImpl.class);
		
	@Autowired
	ElsecoClaimsUtil util;
	
	@Autowired
	AbstractClaimsMgmtFactory  abstractClaimsMgmtFactory;
	
	@Autowired
	ElsecoClaimsServiceException exceptions;
	
	@Autowired
	@Lazy
	ElsecoClaimsProcessManager claimsManager;
	
	@Autowired
	ElsecoClaimsToHybrisConstant claimsHybrisConstant;
	
	@Autowired
	ElsecoClaimsToHybrisClient client;
	
	public ElClaimsRFCClientServiceImpl() {
		if(abstractClaimsMgmtFactory == null) {
			abstractClaimsMgmtFactory = ElsecoClaimsFactoryManager.getFactory(AppConstants.AVIATION);
		}
		if(claimsManager == null) {
			claimsManager = (ElsecoClaimsProcessManager) abstractClaimsMgmtFactory.getInstance();
		}
	}	
	
	/**
	 * A method thats handles a call to RFC based on Business Partner ID, fetches the Available Fund Amount
	 * @param List
	 */
	public List<ElsecoCrmPqm> populateBPBalanceAmount(List<ElsecoCrmPqm> businessPartnerList) throws Exception {
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - populateBPBalanceAmount ");	
				
		//Load the properties used to connect the Destination
		Properties connectProperties = client.loadProperties(claimsHybrisConstant.AVL_PRM_FUND_HOST, claimsHybrisConstant.AVL_PRM_FUND_INSTANCE_SYSTEM_NUM, 
									claimsHybrisConstant.AVL_PRM_FUND_CLIENT, claimsHybrisConstant.AVL_PRM_FUND_USER,
											claimsHybrisConstant.AVL_PRM_FUND_PSWRD, claimsHybrisConstant.AVL_PRM_FUND_LANG);
		//Create a connection with the Destination
		client.createHybrisConnectionDataFile(claimsHybrisConstant.AVL_PRM_FUND_DESTINATION_NAME, connectProperties);
		
		//Obtain the Destination Object using the connection
		JCoDestination destination = client.destionationConnectManager(claimsHybrisConstant.AVL_PRM_FUND_DESTINATION_NAME);		
		
		//From the Destination pass the Function Name and get the Function object
		JCoFunction function = client.connToJcoFunctionUsingJCoRepository(destination, claimsHybrisConstant.AVL_PRM_FUND_STNDRD_FM);
		
		JCoTable returnFields = function.getTableParameterList().getTable("MAINSELECTIONS");
		for(int i =0;i < businessPartnerList.size();i++) {	
			ElsecoCrmPqm pqm = businessPartnerList.get(i);
			returnFields.appendRow();
	        //returnFields.setValue("BUSPARTNER", "1100000056");    //hardcoded for testing only- remove this comment
			returnFields.setValue("BUSPARTNER", pqm.getBpId());  
		}       
		LOG.info( "======================   I N P U T / R E Q U E S T   =================================" );
		LOG.info( returnFields.toXML() );
		LOG.info( "==========================---------------------------=================================" );	
	
		function = client.executeJcoFunction(function, destination, claimsHybrisConstant.AVL_PRM_FUND_STNDRD_FM);

		LOG.info( "====================== R E C E I V E D       T H E    O U T P U T / R E S P O N S E =================================" );
		
		JCoTable resultRows = function.getTableParameterList().getTable("BALANCEITEMS");		
		int numRows = resultRows.getNumRows();
		LOG.info("Number Rows Returned from Result = " + numRows);
       			
        for (int k = 0; k < resultRows.getNumRows(); k++, resultRows.nextRow()) {
			for (int i = 0; i < businessPartnerList.size(); i++) {	
				ElsecoCrmPqm pqm = businessPartnerList.get(i);
				if (resultRows.getString("BUSPARTNER").equals(pqm.getBpId())
						&& (resultRows.getString("DOC_TYPE").equalsIgnoreCase("YA")
								|| resultRows.getString("DOC_TYPE").equalsIgnoreCase("YD"))) {
					BigDecimal avalPrmFund = new BigDecimal(pqm.getAvailPrmAmount());
					avalPrmFund = avalPrmFund.add(new BigDecimal(resultRows.getString("AMOUNT")));
					pqm.setAvailPrmAmount(avalPrmFund.toString());				
				}
			}			
		}        
       return businessPartnerList;
	}
	
	/**
	 * isValidData -  To validate whether the Input Json data passed has the valid data or not
	 * @param
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean isValidData(Map<String, Object> inputMap) throws Exception{
		HashMap inputHeaderMap = (HashMap) inputMap.get("IM_HEADER_DATA");	
		if(inputHeaderMap == null || inputHeaderMap.size()==0) {
			LOG.debug("---------   IM_HEADER_DATA  is empty    ---------  " );
			return false;
		}		
		
		HashMap marketMap = (HashMap) inputHeaderMap.get("HEADER_DATA_MARKET");
		if(marketMap == null || marketMap.size()==0) {
			LOG.debug("---------   HEADER_DATA_MARKET  is empty    ---------  " );
			return false;
		}
		
		HashMap extRefMap = (HashMap) marketMap.get("HEADER_DATA_EXT");	
		if(extRefMap == null || extRefMap.size()==0) {
			LOG.debug("---------   HEADER_DATA_EXT  is empty    ---------  " );
			return false;
		}
		
		ArrayList<HashMap> intRefInputList = (ArrayList<HashMap>) extRefMap.get("HEADER_DATA_INT");			
		if(intRefInputList == null || intRefInputList.size()==0) {
			LOG.debug("---------   HEADER_DATA_INT  is empty    ---------  " );
			return false;
		}
		
		//HEADER_DATA_STAMP_MEMBER  validation
		for(int i = 0; i < intRefInputList.size(); i++) {
			HashMap intRefInputMap = (HashMap) intRefInputList.get(i);
			ArrayList<HashMap> stampInputList = (ArrayList<HashMap>)  intRefInputMap.get("HEADER_DATA_STAMP_MEMBER");
			if(stampInputList == null || stampInputList.size()==0) {
				LOG.debug("---------   HEADER_DATA_STAMP_MEMBER  is empty    ---------  " );
				return false;
			}
		}		
		
		if(ElsecoClaimsUtil.getValidString(marketMap.get("CURRENCY")).equals("")) {
			LOG.debug("---------   CURRENCY  is empty    ---------  " );
			return false;
		}
		if(ElsecoClaimsUtil.getValidString(extRefMap.get("PMT_TYP")).equals("")) {
			LOG.debug("---------   PMT_TYP  is empty    ---------  " );
			return false;
		}		
		return true;
	}
		
	/**
	 * populateHybrisPaymentDetails - To invoke the Hybris Payment based on details in Json
	 * 
	 * @param hybrispay
	 * @throws Exception
	 */
	public ElsecoClaimsHybrisResponse populateHybrisCollectPaymentDetails(Map<String, Object> inputMap) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - populateHybrisCollectPaymentDetails ");	
		
		//Load and populate RFC data received from the input Json 
		IM_HEADER_DATA data = populateRFCClientData(inputMap);
				
		//Load the properties used to connect the Destination
		Properties connectProperties = client.loadProperties(claimsHybrisConstant.JCO_HOST, claimsHybrisConstant.JCO_INSTANCE_SYSTEM_NUM, 
									claimsHybrisConstant.JCO_CLIENT, claimsHybrisConstant.JCO_USER,
											claimsHybrisConstant.JCO_PSWRD, claimsHybrisConstant.JCO_LANG);
		//Create a connection with the Detsination
		client.createHybrisConnectionDataFile(claimsHybrisConstant.JCO_DESTINATION_NAME, connectProperties);
		
		//Obtain the Destination Object using the connection
		JCoDestination destination = client.destionationConnectManager(claimsHybrisConstant.JCO_DESTINATION_NAME);		
		
		//From the Destination pass the Funaction Name and get the Function object
		JCoFunction function = client.connToJcoFunctionUsingDestination(destination, claimsHybrisConstant.JCO_STNDRD_FM);					
		LOG.debug("Structure of the function :: " + function.toXML() );
		
		//Get all the fields and their values from Input Data (Pojo class) using the Java Reflection
		Map<String, Map<String, String>> claimDataFields = new HashMap<String, Map<String, String>>();		
		defineFieldStructure(data, claimDataFields, "0");
		
		//Iterate the field names and Values and set them to the function
		Set<String> heirarchyClassNames= claimDataFields.keySet();	
		for(String eachClassName: heirarchyClassNames) {			
			if(eachClassName.startsWith("HEADER_DATA_INT") ||
					eachClassName.startsWith("HEADER_DATA_PAY")) {
				int endIndex = eachClassName.indexOf("-");
				Map<String, String> eachParamInClass = claimDataFields.get(eachClassName);
				Map<String, String> eachParamInChildClass = claimDataFields.get("HEADER_DATA_STAMP_MEMBER-"+eachClassName);	
				//Set the field and values to the Table Parameters of a Function
				if(eachClassName.startsWith("HEADER_DATA_INT")) {
					setTableValuesForCollectPayment(function, eachClassName.substring(0, endIndex), eachParamInClass,
						"HEADER_DATA_STAMP_MEMBER-"+eachClassName, eachParamInChildClass);		
				}else {
					setTableValuesForCollectPayment(function, eachClassName.substring(0, endIndex), eachParamInClass,
							null, null);	
				}
			}else {				
				Map<String, String> eachParamInClass = claimDataFields.get(eachClassName);
				Set<String> eachParamSet = eachParamInClass.keySet();
				for(String eachField:  eachParamSet) {				
					//Set the field and values to the Import Parameters of a Function
					setScalarValuesToJcoFunction(function, eachClassName, eachField, eachParamInClass.get(eachField).toString());	
				}
			}
		}		
		LOG.info( "====================== I N P U T / R E Q U E S T =================================" );
		LOG.info( function.toXML() );
		LOG.info( "==========================---------------------------=================================" );	
		
		function = client.executeJcoFunction(function, destination, claimsHybrisConstant.JCO_STNDRD_FM);

		LOG.info( "====================== O U T P U T / R E S P O N S E =================================" );
		LOG.info( function.toXML() );
		
		/*	
		JSONObject xmlJsonObject = XML.toJSONObject(function.toXML().toString());		
		JSONObject fmPqmClmsJson = (JSONObject) xmlJsonObject.get(claimsHybrisConstant.JCO_STNDRD_FM);
		JSONObject inputJson = (JSONObject) fmPqmClmsJson.get("INPUT");
		JSONObject claimHeaderJson = (JSONObject) inputJson.get("IM_HEADER_DATA");
					
		Map<String, String> resultMap = new HashMap<String, String>();
		ElsecoClaimsUtil.jsonWithChildElementsToMap(resultMap, claimHeaderJson.toString());			
		
		IM_HEADER_DATA resultData = new IM_HEADER_DATA();
		assignValues(resultMap, resultData);
		
		*/
		JSONObject xmlJsonObject = XML.toJSONObject(function.toXML().toString());		
		JSONObject fmPqmClmsJson = (JSONObject) xmlJsonObject.get(claimsHybrisConstant.JCO_STNDRD_FM);
		JSONObject inputJson = (JSONObject) fmPqmClmsJson.get("OUTPUT");
			
		ElsecoClaimsHybrisResponse response = new ElsecoClaimsHybrisResponse();
		response.setLogNumber(inputJson.get("EX_LOG_NUMBER").toString());
		response.setResponseCode(inputJson.get("EX_RETURN").toString());
		if(response.getResponseCode()!=null && !response.getResponseCode().equals("") ) {
			 int respCode = Integer.valueOf(response.getResponseCode());
			 if(respCode == 0) {
				 response.setStatus("SUCCESS");
			 }else {
				 response.setStatus("FAILURE");
			 }
		}else {
			response.setStatus("FAILURE");
		}
		
		LOG.info( "==========================---------------------------=================================" );		
		client.closeJcoConnection(destination);
		
		List<ElsecoHybrisPayHistory> hybrisPayList = populateHybrisPayEntityData(inputMap);
		for(ElsecoHybrisPayHistory hybrisPay: hybrisPayList ) {
			claimsManager.addElsecoHybrisPayHistory(hybrisPay);		
			claimsManager.updateMemberInfoAfterPayment(hybrisPay);				
		}			
		
		response.setPaymntType(hybrisPayList.get(0).getPaymentType());
		
		return response;
	}

	/**
	 * populateHybrisReleasePaymentDetails - To populate the Hybris service to Release the Payment based on details in Json
	 * 
	 * @param hybrispay
	 * @throws Exception
	 */
	public ElsecoClaimsHybrisResponse populateHybrisReleasePaymentDetails(Map<String, Object> inputMap) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - populateHybrisReleasePaymentDetails ");	
		
		//Load and populate RFC data received from the input Json 
		IM_HEADER_DATA data = populateReleasePaymentRFCClientData(inputMap);
				
		//Load the properties used to connect the Destination
		Properties connectProperties = client.loadProperties(claimsHybrisConstant.JCO_RELPAY_HOST, claimsHybrisConstant.JCO_RELPAY_INSTANCE_SYSTEM_NUM, 
									claimsHybrisConstant.JCO_RELPAY_CLIENT, claimsHybrisConstant.JCO_RELPAY_USER,
											claimsHybrisConstant.JCO_RELPAY_PSWRD, claimsHybrisConstant.JCO_RELPAY_LANG);
		//Create a connection with the Detsination
		client.createHybrisConnectionDataFile(claimsHybrisConstant.JCO_RELPAY_DESTINATION_NAME, connectProperties);
		
		//Obtain the Destination Object using the connection
		JCoDestination destination = client.destionationConnectManager(claimsHybrisConstant.JCO_RELPAY_DESTINATION_NAME);		
		
		//From the Destination pass the Funaction Name and get the Function object
		JCoFunction function = client.connToJcoFunctionUsingDestination(destination, claimsHybrisConstant.JCO_RELPAY_STNDRD_FM);
		LOG.debug("Structure of the function :: " + function.toXML() );
		
		//Get all the fields and their values using the Java Reflection
		Map<String, Map<String, String>> claimDataFields = new HashMap<String, Map<String, String>>();		
		defineFieldStructure(data, claimDataFields, "0");
		
		//Iterate the field names and Values and set them to the function
		Set<String> heirarchyClassNames= claimDataFields.keySet();	
		for (String eachClassName : heirarchyClassNames) {
			if (eachClassName.startsWith("HEADER_DATA_PAY")) {
				int endIndex = eachClassName.indexOf("-");
				Map<String, String> eachParamInClass = claimDataFields.get(eachClassName);
				setTableValuesForReleasePayment(function, eachClassName.substring(0, endIndex), eachParamInClass, null, null);				
			} else {
				Map<String, String> eachParamInClass = claimDataFields.get(eachClassName);
				Set<String> eachParamSet = eachParamInClass.keySet();
				for (String eachField : eachParamSet) {
					// Set the field and values to the Import Parameters of a Function
					setScalarValuesToJcoFunction(function, eachClassName, eachField, eachParamInClass.get(eachField).toString());
				}
			}
		}		
		LOG.info( "====================== I N P U T / R E Q U E S T =================================" );
		LOG.info( function.toXML() );
		LOG.info( "==========================---------------------------=================================" );	
		
		function = client.executeJcoFunction(function, destination, claimsHybrisConstant.JCO_RELPAY_STNDRD_FM);

		LOG.info( "====================== O U T P U T / R E S P O N S E =================================" );
		LOG.info( function.toXML() );
		
			
		JSONObject xmlJsonObject = XML.toJSONObject(function.toXML().toString());		
		JSONObject fmPqmClmsJson = (JSONObject) xmlJsonObject.get(claimsHybrisConstant.JCO_RELPAY_STNDRD_FM);
		JSONObject inputJson = (JSONObject) fmPqmClmsJson.get("OUTPUT");
		
		ElsecoClaimsHybrisResponse response = new ElsecoClaimsHybrisResponse();
		response.setLogNumber(inputJson.get("EX_LOG_NUMBER").toString());
		response.setResponseCode(inputJson.get("EX_RETURN").toString());
		if(response.getResponseCode()!=null && !response.getResponseCode().equals("") ) {
			 int respCode = Integer.valueOf(response.getResponseCode());
			 if(respCode == 0) {
				 response.setStatus("SUCCESS");
			 }else {
				 response.setStatus("FAILURE");
			 }
		}else {
			response.setStatus("FAILURE");
		}
		response.setPaymntType("Release");
		LOG.info( "==========================---------------------------=================================" );
		
		client.closeJcoConnection(destination);
		return response;
	}
	
	/**
	 * Craete a sample test data and load it to the each field passed through a RFC
	 * 
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */	
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public IM_HEADER_DATA populateRFCClientData(Map<String, Object> inputMap) throws JsonParseException, JsonMappingException, IOException {
			
		HashMap inputHeaderMap = (HashMap) inputMap.get("IM_HEADER_DATA");	
		HashMap marketMap = (HashMap) inputHeaderMap.get("HEADER_DATA_MARKET");
		HashMap extRefMap = (HashMap) marketMap.get("HEADER_DATA_EXT");	
		//ArrayList<HashMap> payeeInputList = (ArrayList<HashMap>) extRefMap.get("HEADER_DATA_PAY");  	 // Removed Payee section later   
		ArrayList<HashMap> intRefInputList = (ArrayList<HashMap>) extRefMap.get("HEADER_DATA_INT");	
		
		/*ArrayList<HEADER_DATA_PAY> extPayeeList = new ArrayList<HEADER_DATA_PAY>();    				// Removed Payee section later   
		HEADER_DATA_PAY payee = null;
		for(int i = 0; i < payeeInputList.size(); i++) {
			HashMap payeeInputMap = (HashMap) payeeInputList.get(i);
			payee = new HEADER_DATA_PAY();
			payee.setPAYEE(ElsecoClaimsUtil.getValidString(payeeInputMap.get("PAYEE")));
			payee.setPAYEE_ACC(ElsecoClaimsUtil.getValidString(payeeInputMap.get("PAYEE_ACC")));
			payee.setPAYEE_AM(ElsecoClaimsUtil.getValidString(payeeInputMap.get("PAYEE_AM")));		
			extPayeeList.add(payee);
		}*/				
		
		ArrayList<HEADER_DATA_INT> intRefList = new ArrayList<HEADER_DATA_INT>();
		for(int i = 0; i < intRefInputList.size(); i++) {
			HashMap intRefInputMap = (HashMap) intRefInputList.get(i);
			HEADER_DATA_INT intRef = new HEADER_DATA_INT();
			intRef.setINT_REF(ElsecoClaimsUtil.getValidString(intRefInputMap.get("INT_REF")));
			intRef.setTR_ID(ElsecoClaimsUtil.getValidString(intRefInputMap.get("TR_ID")));
			intRef.setSPLIT_VL(ElsecoClaimsUtil.getValidString(intRefInputMap.get("SPLIT_VL")));	
			//intRef.setDUE_DATE(ElsecoClaimsUtil.HybrisDateFormatConversion(ElsecoClaimsUtil.getValidString(intRefInputMap.get("DUE_DATE"))));
			intRef.setDUE_DATE(ElsecoClaimsUtil.getValidString(intRefInputMap.get("DUE_DATE")));
			intRef.setSTAMP_ID(ElsecoClaimsUtil.getValidString(intRefInputMap.get("STAMP_ID")));
			intRef.setSECTION(ElsecoClaimsUtil.getValidString(intRefInputMap.get("SECTION")));
			
			ArrayList<HashMap> stampInputList = (ArrayList<HashMap>)  intRefInputMap.get("HEADER_DATA_STAMP_MEMBER");
			ArrayList<HEADER_DATA_STAMP_MEMBER> stmpList = new ArrayList<HEADER_DATA_STAMP_MEMBER>();
			for(int j = 0; j < stampInputList.size(); j++) {
				HashMap stampInputMap = (HashMap) stampInputList.get(j);
				HEADER_DATA_STAMP_MEMBER stamp = new HEADER_DATA_STAMP_MEMBER();
				stamp.setMEMBER_ID(ElsecoClaimsUtil.getValidString(stampInputMap.get("MEMBER_ID")));	
				stamp.setPAYER_ID(ElsecoClaimsUtil.getValidString(stampInputMap.get("PAYER_ID")));	
				stamp.setCOLL_TYPE(ElsecoClaimsUtil.getValidString(stampInputMap.get("COLL_TYPE")));				
				stmpList.add(stamp);				
			}	
			intRef.setHEADER_DATA_STAMP_MEMBER(stmpList);			
			intRefList.add(intRef);
		}	
		
		HEADER_DATA_EXT ext = new HEADER_DATA_EXT();	
		ext.setEXT_REF(ElsecoClaimsUtil.getValidString(extRefMap.get("EXT_REF")));
		ext.setTR_ID(ElsecoClaimsUtil.getValidString(extRefMap.get("TR_ID")));
		ext.setLINE_SPLIT_VL(ElsecoClaimsUtil.getValidString(extRefMap.get("LINE_SPLIT_VL")));			
		ext.setTR_TYP(ElsecoClaimsUtil.getValidString(extRefMap.get("TR_TYP")));		
		ext.setPMT_TYP(ElsecoClaimsUtil.getValidString(extRefMap.get("PMT_TYP")));
		ext.setPARTICIPATION_ID(ElsecoClaimsUtil.getValidString(extRefMap.get("PARTICIPATION_ID")));
		ext.setPOLICY_TYPE(ElsecoClaimsUtil.getValidString(extRefMap.get("POLICY_TYPE")));
		
		//ext.setHEADER_DATA_PAY(extPayeeList);   				// Removed Payee section later   
		ext.setHEADER_DATA_INT(intRefList);		
		
		HEADER_DATA_MARKET market  = new HEADER_DATA_MARKET();
		market.setTR_ID(ElsecoClaimsUtil.getValidString(marketMap.get("TR_ID")));
		market.setTR_TYP(ElsecoClaimsUtil.getValidString(marketMap.get("TR_TYP")));
		market.setSETTLEMENT_AM_INDEM(ElsecoClaimsUtil.getValidString(marketMap.get("SETTLEMENT_AM_INDEM")));
		market.setRESERVE_AM_INDEM(ElsecoClaimsUtil.getValidString(marketMap.get("RESERVE_AM_INDEM")));
		market.setSETTLEMENT_AM_FEES(ElsecoClaimsUtil.getValidString(marketMap.get("SETTLEMENT_AM_FEES")));
		market.setRESERVE_AM_FEES(ElsecoClaimsUtil.getValidString(marketMap.get("RESERVE_AM_FEES")));
		market.setSETTLEMENT_AM_EXP(ElsecoClaimsUtil.getValidString(marketMap.get("SETTLEMENT_AM_EXP")));
		market.setRESERVE_AM_EXP(ElsecoClaimsUtil.getValidString(marketMap.get("RESERVE_AM_EXP")));
		market.setINCURRED_AM(ElsecoClaimsUtil.getValidString(marketMap.get("INCURRED_AM")));
		market.setCURRENCY(ElsecoClaimsUtil.getValidString(marketMap.get("CURRENCY")));		
		market.setHEADER_DATA_EXT(ext);
				
		IM_HEADER_DATA headerObj = new IM_HEADER_DATA();		
		headerObj.setUCR(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("UCR")));
		headerObj.setUMR(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("UMR")));
		headerObj.setEL_CLAIM_ID(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("EL_CLAIM_ID")));
		headerObj.setPARTNER_ID(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("PARTNER_ID")));	
		headerObj.setDATE_LOSS(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("DATE_LOSS")));	
		headerObj.setAPPOINTED_LOSS_ADJUSTER(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("APPOINTED_LOSS_ADJUSTER")));	
		headerObj.setDETAILS(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("DETAILS")));	
		headerObj.setHEADER_DATA_MARKET(market);
	
		LOG.debug( "Final Value of RFC Data   "+headerObj.toString() );
				
		return headerObj;
	}
	
	/**
	 * Craete a sample test data and load it to the each field passed through a RFC
	 * 
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IM_HEADER_DATA populateReleasePaymentRFCClientData(Map<String, Object> inputMap) throws JsonParseException, JsonMappingException, IOException {
			
		HashMap inputHeaderMap = (HashMap) inputMap.get("IM_HEADER_DATA");	
		HashMap marketMap = (HashMap) inputHeaderMap.get("HEADER_DATA_MARKET");
		HashMap extRefMap = (HashMap) marketMap.get("HEADER_DATA_EXT");	
		ArrayList<HashMap> payeeInputList = (ArrayList<HashMap>) extRefMap.get("HEADER_DATA_PAY");
		
		ArrayList<HEADER_DATA_PAY> extPayeeList = new ArrayList<HEADER_DATA_PAY>();
		HEADER_DATA_PAY payee = null;
		for(int i = 0; i < payeeInputList.size(); i++) {
			HashMap payeeInputMap = (HashMap) payeeInputList.get(i);
			payee = new HEADER_DATA_PAY();
			payee.setPAYEE(ElsecoClaimsUtil.getValidString(payeeInputMap.get("PAYEE")));
			payee.setPAYEE_ACC(ElsecoClaimsUtil.getValidString(payeeInputMap.get("PAYEE_ACC")));
			payee.setPAYEE_AM(ElsecoClaimsUtil.getValidString(payeeInputMap.get("PAYEE_AM")));	
			payee.setPAY_DT(ElsecoClaimsUtil.getValidString(payeeInputMap.get("PAY_DT")));	
			extPayeeList.add(payee);
		}			
		
		HEADER_DATA_EXT ext = new HEADER_DATA_EXT();	
		ext.setEXT_REF(ElsecoClaimsUtil.getValidString(extRefMap.get("EXT_REF")));
		ext.setTR_ID(ElsecoClaimsUtil.getValidString(extRefMap.get("TR_ID")));
		ext.setHEADER_DATA_PAY(extPayeeList);
		
		HEADER_DATA_MARKET market  = new HEADER_DATA_MARKET();
		market.setTR_ID(ElsecoClaimsUtil.getValidString(marketMap.get("TR_ID")));
		market.setHEADER_DATA_EXT(ext);
				
		IM_HEADER_DATA headerObj = new IM_HEADER_DATA();		
		headerObj.setUCR(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("UCR")));
		headerObj.setUMR(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("UMR")));
		headerObj.setEL_CLAIM_ID(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("EL_CLAIM_ID")));
		headerObj.setHEADER_DATA_MARKET(market);
	
		LOG.debug( "Final Value of RFC Data   "+headerObj.toString() );
				
		return headerObj;
	}
	
	/**
	 * 
	 * @param inputMap
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ElsecoHybrisPayHistory> populateHybrisPayEntityData(Map<String, Object> inputMap) throws JsonParseException, JsonMappingException, IOException {
		
		HashMap inputHeaderMap = (HashMap) inputMap.get("IM_HEADER_DATA");	
		HashMap marketMap = (HashMap) inputHeaderMap.get("HEADER_DATA_MARKET");
		HashMap extRefMap = (HashMap) marketMap.get("HEADER_DATA_EXT");	
		//ArrayList<HashMap> payeeInputList = (ArrayList<HashMap>) extRefMap.get("HEADER_DATA_PAY");
		ArrayList<HashMap> intRefInputList = (ArrayList<HashMap>) extRefMap.get("HEADER_DATA_INT");	
		
		List<ElsecoHybrisPayHistory> hybrisPayList = new ArrayList<ElsecoHybrisPayHistory>();
		ElsecoHybrisPayHistory hybrisPay = null;		
		
		for(int i = 0; i < intRefInputList.size(); i++) {
			HashMap intRefInputMap = (HashMap) intRefInputList.get(i);			
					
			ArrayList<HashMap> stampInputList = (ArrayList<HashMap>)  intRefInputMap.get("HEADER_DATA_STAMP_MEMBER");			
			for(int j = 0; j < stampInputList.size(); j++) {
				hybrisPay = new ElsecoHybrisPayHistory();				
				HashMap stampInputMap = (HashMap) stampInputList.get(j);
				
				hybrisPay.setClaimHeaderId(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("CLAIM_HEADER_ID")));
				hybrisPay.setClaimDetailId(ElsecoClaimsUtil.getValidString(extRefMap.get("CLAIM_DETAIL_ID")));
				hybrisPay.setClaimTransId(ElsecoClaimsUtil.getValidString(marketMap.get("CLAIM_TRANSACTION_ID")));	
				hybrisPay.setClaimIntRefId(ElsecoClaimsUtil.getValidString(intRefInputMap.get("CLAIM_INTREF_ID")));	
				hybrisPay.setMemberId(ElsecoClaimsUtil.getValidString(stampInputMap.get("MEMBER_ID")));	
				hybrisPay.setPayerId(ElsecoClaimsUtil.getValidString(stampInputMap.get("PAYER_ID")));	
				hybrisPay.setUcr(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("UCR")));
				hybrisPay.setUmr(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("UMR")));
				hybrisPay.setElClaimId(ElsecoClaimsUtil.getValidString(inputHeaderMap.get("EL_CLAIM_ID")));
				hybrisPay.setSettlementAmtIndem(ElsecoClaimsUtil.getValidString(marketMap.get("SETTLEMENT_AM_INDEM")));
				hybrisPay.setReserveAmtIndem(ElsecoClaimsUtil.getValidString(marketMap.get("RESERVE_AM_INDEM")));
				hybrisPay.setSettlementAmtFees(ElsecoClaimsUtil.getValidString(marketMap.get("SETTLEMENT_AM_FEES")));
				hybrisPay.setReserveAmtFees(ElsecoClaimsUtil.getValidString(marketMap.get("RESERVE_AM_FEES")));
				hybrisPay.setSettlementAmtExpense(ElsecoClaimsUtil.getValidString(marketMap.get("SETTLEMENT_AM_EXP")));
				hybrisPay.setReserveAmtExpense(ElsecoClaimsUtil.getValidString(marketMap.get("RESERVE_AM_EXP")));
				hybrisPay.setIncurredAmt(ElsecoClaimsUtil.getValidString(marketMap.get("INCURRED_AM")));
				hybrisPay.setCurrency(ElsecoClaimsUtil.getValidString(marketMap.get("CURRENCY")));					
				hybrisPay.setPaymentType(ElsecoClaimsUtil.getValidString(extRefMap.get("PMT_TYP")));
							
				hybrisPay.setIsCollected("1"); // this will 'check' the checkbox on UI -  1 for checked and 0 for unchecked
				hybrisPay.setStatus(ElsecoClaimsUtil.getValidString(extRefMap.get("PMT_TYP")));		
				
				hybrisPayList.add(hybrisPay);			
			}				
		}	
					
		return hybrisPayList;
	}
	
	/**
	 * Assign the Function input fields with the Claims Data - that forms a RFC request
	 * 
	 * @param resultMap
	 * @param object
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */	
	public static void assignValues(Map<String, String> resultMap,  Object object) throws IllegalArgumentException, IllegalAccessException{			
		for (Field field : object.getClass().getDeclaredFields()) {
			if (field.getType().equals(Integer.TYPE) || field.getType().equals(String.class)
					|| field.getType().equals(Double.TYPE)) {
				field.setAccessible(true);				
	            field.set(object, resultMap.get(field.getName()));
			} else if (field.getType().equals(HEADER_DATA_MARKET.class)) {				
				if (object instanceof IM_HEADER_DATA) {
					IM_HEADER_DATA headerObject = (IM_HEADER_DATA) object;
					HEADER_DATA_MARKET market = headerObject.getHEADER_DATA_MARKET();
					if(market!=null) {
						assignValues(resultMap, market);
					}
				}
			} else if (field.getType().equals(HEADER_DATA_EXT.class)) {				
				if (object instanceof HEADER_DATA_MARKET) {
					HEADER_DATA_MARKET marketObject = (HEADER_DATA_MARKET) object;
					HEADER_DATA_EXT extRef = marketObject.getHEADER_DATA_EXT();
					if(extRef!=null) {
						assignValues(resultMap, extRef);
					}
				}
			} else if (field.getType().equals(List.class) || field.getType().equals(ArrayList.class)) {				
				if (object instanceof HEADER_DATA_EXT) {
					HEADER_DATA_EXT extRefObject = (HEADER_DATA_EXT) object;
					
					List<HEADER_DATA_INT> intRefList = extRefObject.getHEADER_DATA_INT();
					for(HEADER_DATA_INT intRef: intRefList) {
						if(intRef!=null) {
							assignValues(resultMap, intRef);
						}
					}
					
					List<HEADER_DATA_PAY> extPayeeList = extRefObject.getHEADER_DATA_PAY();
					for(HEADER_DATA_PAY payee: extPayeeList) {
						if(payee!=null) {
							assignValues(resultMap, payee);
						}
					}
				}
			} else if (field.getType().equals(HEADER_DATA_STAMP_MEMBER.class)) {				
				if (object instanceof HEADER_DATA_INT) {
					HEADER_DATA_INT intRefObject = (HEADER_DATA_INT) object;
					ArrayList<HEADER_DATA_STAMP_MEMBER> stampList = intRefObject.getHEADER_DATA_STAMP_MEMBER();
					for(HEADER_DATA_STAMP_MEMBER stamp: stampList) {
						if(stamp!=null) {
							assignValues(resultMap, stamp);
						}
					}
				}
			}
		}
	}
		
	/**
	 * Recursively get all the fields from the given Class(object)
	 * @param object
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */	
	public static Map<String,Map<String, String>> defineFieldStructure(Object object, 
			Map<String, Map<String, String>> fieldsStructure, String listSize) throws IllegalArgumentException, IllegalAccessException {
		//LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - defineFieldStructure ");	
		boolean alreadyProcessed = false;
		for (Field field : object.getClass().getDeclaredFields()) {	
			
			if (field.getType().equals(Integer.TYPE) || field.getType().equals(String.class)
					|| field.getType().equals(Double.TYPE)) {					
				if(object.getClass().getSimpleName().equals("HEADER_DATA_STAMP_MEMBER") ) {					
					if (fieldsStructure.containsKey(object.getClass().getSimpleName().toString()+"-"+listSize)) {					
						Map<String, String> itsFields = fieldsStructure.get(object.getClass().getSimpleName().toString()+"-"+listSize);
						itsFields.put(field.getName().toUpperCase(), (field.get(object)!=null)?field.get(object).toString():"");
						fieldsStructure.put(object.getClass().getSimpleName().toString()+"-"+listSize, itsFields);						
					}else {
						Map<String, String> itsFields = new HashMap<String, String>();
						itsFields.put(field.getName().toUpperCase(), field.get(object).toString());
						fieldsStructure.put(object.getClass().getSimpleName().toString()+"-"+listSize, itsFields);							
					}						
				}else if(object.getClass().getSimpleName().equals("HEADER_DATA_INT")
						|| object.getClass().getSimpleName().equals("HEADER_DATA_PAY")) {
					if (fieldsStructure.containsKey(object.getClass().getSimpleName().toString()+"-"+listSize)) {					
						Map<String, String> itsFields = fieldsStructure.get(object.getClass().getSimpleName().toString()+"-"+listSize);
						itsFields.put(field.getName().toUpperCase(), (field.get(object)!=null)?field.get(object).toString():"");
						fieldsStructure.put(object.getClass().getSimpleName().toString()+"-"+listSize, itsFields);						
					}else {
						Map<String, String> itsFields = new HashMap<String, String>();
						itsFields.put(field.getName().toUpperCase(), field.get(object).toString());
						fieldsStructure.put(object.getClass().getSimpleName().toString()+"-"+listSize, itsFields);							
					}	
					
					//HEADER_DATA_STMP
					if (object instanceof HEADER_DATA_INT) {
						HEADER_DATA_INT intRefObject = (HEADER_DATA_INT) object;
						ArrayList<HEADER_DATA_STAMP_MEMBER> stampList = intRefObject.getHEADER_DATA_STAMP_MEMBER();	
						for(HEADER_DATA_STAMP_MEMBER stamp: stampList ) {
							if(stamp!=null) {								
								defineFieldStructure(stamp, fieldsStructure, object.getClass().getSimpleName().toString()+"-"+listSize);
							}
						}
					}
					
				} else {				
					if (fieldsStructure.containsKey(object.getClass().getSimpleName().toString())) {					
						Map<String, String> itsFields = fieldsStructure.get(object.getClass().getSimpleName().toString());
						itsFields.put(field.getName().toUpperCase(), (field.get(object)!=null)?field.get(object).toString():"");
						fieldsStructure.put(object.getClass().getSimpleName(), itsFields);
					}else {
						Map<String, String> itsFields = new HashMap<String, String>();
						itsFields.put(field.getName().toUpperCase(), field.get(object).toString());
						fieldsStructure.put(object.getClass().getSimpleName().toString(), itsFields);					
					}		
				}				
			} else {					
				if (field.getType().equals(HEADER_DATA_MARKET.class)) {	
					IM_HEADER_DATA headerObject = (IM_HEADER_DATA) object;
					HEADER_DATA_MARKET market = headerObject.getHEADER_DATA_MARKET();
					if(market!=null) {					
						defineFieldStructure(market, fieldsStructure, "0");
					}
				}else if (field.getType().equals(HEADER_DATA_EXT.class)) {	
					HEADER_DATA_MARKET marketObject = (HEADER_DATA_MARKET) object;
					HEADER_DATA_EXT extRef = marketObject.getHEADER_DATA_EXT();
					if(extRef!=null) {						
						defineFieldStructure(extRef, fieldsStructure, "0");
					}
				}else if (field.getType().equals(List.class) ||  field.getType().equals(ArrayList.class)) {				
					if (object instanceof HEADER_DATA_EXT && alreadyProcessed == false) {
						HEADER_DATA_EXT extRefObject = (HEADER_DATA_EXT) object;
						
						List<HEADER_DATA_INT> intRefList = extRefObject.getHEADER_DATA_INT();
						if(intRefList!=null) {
							int intRefSize = intRefList.size()-1;
							for(HEADER_DATA_INT intRef: intRefList) {						
								if(intRef!=null) {							
									defineFieldStructure(intRef, fieldsStructure, ""+intRefSize);
									intRefSize--;						
								}
							}
						}
						
						List<HEADER_DATA_PAY> extPayeeList = extRefObject.getHEADER_DATA_PAY();
						if(extPayeeList!=null) {
							int payeeSize = extPayeeList.size()-1;
							for(HEADER_DATA_PAY payee: extPayeeList) {								
								if(payee!=null) {	
									defineFieldStructure(payee, fieldsStructure, ""+payeeSize);
									payeeSize--;
								}
							}
						}
						//avoid duplicate loading - set the flag to true
						alreadyProcessed = true;
					}
				} 
			}
		}
		return fieldsStructure;
	}
		
	/**
	 * Set the values from local Pojo class  to JCO Function
	 * 
	 * @param function
	 * @param structureName
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 * @throws JCoException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private JCoFunction setScalarValuesToJcoFunction(JCoFunction function, String structureName, 
					String fieldName, String fieldValue) throws JCoException, IllegalArgumentException, IllegalAccessException
	{
		//LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - setScalarValuesToJcoFunction ");
		
		JCoStructure headerStructure = function.getImportParameterList().getStructure("IM_HEADER_DATA");
		JCoStructure marketStructure = headerStructure.getStructure("HEADER_DATA_MARKET");
		JCoStructure extRefStructure = marketStructure.getStructure("HEADER_DATA_EXT");		
		//JCoTable intRefTable = extRefStructure.getTable("HEADER_DATA_INT");
				
		// HEADER DATA		
		if(structureName.equalsIgnoreCase("IM_HEADER_DATA")) {
			Iterator<JCoField> field = headerStructure.iterator();
			while (field.hasNext()) {
				JCoField jcoField = field.next();					
				if(fieldName.equals(jcoField.getName())) {							
					if(fieldValue!=null && !fieldValue.equals(""))
						jcoField.setValue(fieldValue);
				}
			}
		}	

		// MARKET DATA		
		if(structureName.equalsIgnoreCase("HEADER_DATA_MARKET")) {
			Iterator<JCoField> marketField = marketStructure.iterator();
			while (marketField.hasNext()) {
				JCoField jcoField = marketField.next();			
				if(fieldName.equals(jcoField.getName())) {									
					if(fieldValue!=null && !fieldValue.equals(""))
						jcoField.setValue(fieldValue);
				}
			}
		}

		// EXT_REF DATA
		if(structureName.equalsIgnoreCase("HEADER_DATA_EXT")) {
			Iterator<JCoField> extRefField = extRefStructure.iterator();
			while (extRefField.hasNext()) {
				JCoField jcoField = extRefField.next();			
				if(fieldName.equals(jcoField.getName())) {					
					if(fieldValue!=null && !fieldValue.equals(""))
						jcoField.setValue(fieldValue);
				}
			}
		}	
		
		return function;
	}
	
	/**
	 * 
	 * @param function
	 * @param structureName
	 * @param fieldsInStructure
	 * @return
	 * @throws JCoException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private JCoFunction setTableValuesForReleasePayment(JCoFunction function, String structureName, Map<String, String> fieldsInStructure,
					String childStructureName, Map<String, String> fieldsInChildStructure) throws JCoException, IllegalArgumentException, IllegalAccessException {
		//LOG.info("***** Received a call to ElClaimsProcessServiceImpl - setTableValuesForReleasePayment ");
				
		JCoStructure headerStructure = function.getImportParameterList().getStructure("IM_HEADER_DATA");
		JCoStructure marketStructure = headerStructure.getStructure("HEADER_DATA_MARKET");
		JCoStructure extRefStructure = marketStructure.getStructure("HEADER_DATA_EXT");
		JCoTable payeeTable = extRefStructure.getTable("HEADER_DATA_PAY");
							
		// PAYEE DATA	 --  Table
		if (structureName.equalsIgnoreCase("HEADER_DATA_PAY")) {
			if (payeeTable != null) {
				Iterator<JCoField> payeeField = payeeTable.iterator();
				payeeTable.appendRow();
				while (payeeField.hasNext()) {
					JCoField jcoField = payeeField.next();
					Set<String> keys = fieldsInStructure.keySet();

					for (String fieldName : keys) {
						if (fieldName.equals(jcoField.getName())) {							
							String fieldValue = fieldsInStructure.get(fieldName).toString();						
							if (fieldValue != null && !fieldValue.equals("")) {
								payeeTable.setValue(fieldName, fieldValue);
							}
						}
					}
				}
			}
		}	
				
		return null;
	}


	/**
	 * 
	 * @param function
	 * @param structureName
	 * @param fieldsInStructure
	 * @return
	 * @throws JCoException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private JCoFunction setTableValuesForCollectPayment(JCoFunction function, String structureName, Map<String, String> fieldsInStructure,
					String childStructureName, Map<String, String> fieldsInChildStructure) throws JCoException, IllegalArgumentException, IllegalAccessException {
		//LOG.info("***** Received a call to ElClaimsProcessServiceImpl - setTableValuesForCollectPayment ");
				
		JCoStructure headerStructure = function.getImportParameterList().getStructure("IM_HEADER_DATA");
		JCoStructure marketStructure = headerStructure.getStructure("HEADER_DATA_MARKET");
		JCoStructure extRefStructure = marketStructure.getStructure("HEADER_DATA_EXT");
		JCoTable intRefTable = extRefStructure.getTable("HEADER_DATA_INT");
		//JCoTable payeeTable = extRefStructure.getTable("HEADER_DATA_PAY");
		
		// INT_REF DATA	 --  Table
		if (structureName.equalsIgnoreCase("HEADER_DATA_INT")) {
			if (intRefTable != null) {
				Iterator<JCoField> intRefField = intRefTable.iterator();
				intRefTable.appendRow();
				while (intRefField.hasNext()) {
					JCoField jcoField = intRefField.next();
					
					if (jcoField.getName().equals("HEADER_DATA_STAMP_MEMBER")) {
						if (fieldsInChildStructure != null) {
							JCoTable stmpTable = intRefTable.getTable("HEADER_DATA_STAMP_MEMBER");
							Set<String> stampKeys = fieldsInChildStructure.keySet();
							Iterator<JCoField> stampField = stmpTable.iterator();
							stmpTable.appendRow();
							while (stampField.hasNext()) {
								JCoField jcoStampField = stampField.next();
								for (String stampFieldName : stampKeys) {
									if (stampFieldName.equals(jcoStampField.getName())) {										
										String stampFieldValue = fieldsInChildStructure.get(stampFieldName).toString();										
										if (stampFieldValue != null && !stampFieldValue.equals("")) {
											jcoStampField.setValue(stampFieldValue);
										}
									}
								}
							}
						}
					}else {
						Set<String> keys = fieldsInStructure.keySet();
						for (String fieldName : keys) {							
							if (fieldName.equals(jcoField.getName())) {
								String fieldValue = fieldsInStructure.get(fieldName).toString();								
								if (fieldValue != null && !fieldValue.equals("")) {
									intRefTable.setValue(fieldName, fieldValue);
								}
							}						
						}
					}
				}						
			}
		}
					
		// PAYEE DATA	 --  Table
	/*	if (structureName.equalsIgnoreCase("HEADER_DATA_PAY")) {
			if (payeeTable != null) {
				Iterator<JCoField> payeeField = payeeTable.iterator();
				payeeTable.appendRow();
				while (payeeField.hasNext()) {
					JCoField jcoField = payeeField.next();
					Set<String> keys = fieldsInStructure.keySet();

					for (String fieldName : keys) {
						if (fieldName.equals(jcoField.getName())) {							
							String fieldValue = fieldsInStructure.get(fieldName).toString();						
							if (fieldValue != null && !fieldValue.equals("")) {
								payeeTable.setValue(fieldName, fieldValue);
							}
						}
					}
				}
			}
		}	*/	
				
		return null;
	}
}
