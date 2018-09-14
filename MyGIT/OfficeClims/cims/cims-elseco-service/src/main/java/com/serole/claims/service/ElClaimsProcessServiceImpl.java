package com.serole.claims.service;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.serole.claims.core.claimsFactory.AbstractClaimsMgmtFactory;
import com.serole.claims.core.constants.AppConstants;
import com.serole.claims.model.Elseco.ElsecoClaimsAuditTrail;
import com.serole.claims.model.constants.ElsecoClaimsToHybrisConstant;
import com.serole.claims.model.exceptions.ElsecoClaimsServiceException;
import com.serole.claims.model.filterbeans.CriteriaEntity;
import com.serole.claims.model.json.JsonHandlerForSaveUcrExtRef;
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;
import com.serole.claims.service.factoryManager.ElsecoClaimsFactoryManager;
import com.serole.claims.service.factoryManager.ElsecoClaimsProcessManager;
import com.serole.claims.service.util.ElsecoClaimsUtil;


/**
 * A implementation Class at a service layer for the interface IElsecoAviationService
 * @author Serole_Vijay
 *
 */
@Component
public class ElClaimsProcessServiceImpl implements ElClaimsProcessService {
	private static final Logger LOG = LogManager.getLogger(ElClaimsProcessServiceImpl.class);
		
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
	
	public ElClaimsProcessServiceImpl() {
		if(abstractClaimsMgmtFactory == null) {
			abstractClaimsMgmtFactory = ElsecoClaimsFactoryManager.getFactory(AppConstants.AVIATION);
		}
		if(claimsManager == null) {
			claimsManager = (ElsecoClaimsProcessManager) abstractClaimsMgmtFactory.getInstance();
		}
	}	
	
	/**
	 * A method to service the saving of the Entire Claims structure at one single instance and audit the records.
	 */
	public int saveClaims(JsonHandlerForWorklistAndSaveClaims newClaims, JsonHandlerForWorklistAndSaveClaims oldClaims, ElsecoClaimsAuditTrail auditTrail) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - saveClaims ");
		return claimsManager.saveClaims(newClaims, oldClaims, auditTrail);
	}
	
	/**
	 * A method to service the saving of the UCR along with External References in a Json structure at one single instance and audit the records.
	 */
	public int saveExtReference(JsonHandlerForSaveUcrExtRef newClaims) throws Exception {
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - saveExtReference ");
		return claimsManager.saveExtReference(newClaims);
	}
	
	public void saveAudit(ElsecoClaimsAuditTrail audit) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - saveAudit ");
		claimsManager.saveAudit(audit);
	}
	
	/**
	 * A method to a add the Audit Trail Entry to the backend Database using jdbctemplate
	 * @return
	 * @throws JSONException 
	 */
	public void addAuditTrail(JSONObject jsonObject) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - addAuditTrail ");
		ModelMapper modelMapper = new ModelMapper();		
		Map<String, String> propertyMap = ElsecoClaimsUtil.getJsonAsMap(jsonObject.toString());		
		ElsecoClaimsAuditTrail auditObj = modelMapper.map(propertyMap, ElsecoClaimsAuditTrail.class);
		claimsManager.addAuditTrail(auditObj);		
	}
	
	/**
	 * 
	 */
	public List<?> getAuditDetailsBySearchCriteria(JSONObject jsonObject) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - getAuditDetailsBySearchCriteria ");		
		CriteriaEntity criteriaEntity = new CriteriaEntity();
		Map<String, String> propertyMap = null;
		if (jsonObject.length() > 0) {
			propertyMap = ElsecoClaimsUtil.getJsonAsMap(jsonObject.toString());
			if (propertyMap instanceof Map) {
				ModelMapper modelMapper = new ModelMapper();
				criteriaEntity = modelMapper.map(propertyMap, CriteriaEntity.class);				
			}
		}
		return claimsManager.getAuditDetailsBySearchCriteria(criteriaEntity);	
	}
	
	public void claimStatusNotification(String headerId, String detailId, String statusHandle) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - claimStatusNotification ");	
		claimsManager.claimDetailStatusChange(headerId, detailId, statusHandle);
	}
	
	/**
	 * A method to a Get all the Static Data from JDBC Data Layer 
	 * @return
	 */
	public Object lookUpDataSearch(String sceenhandle, String entityhandle) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - lookUpDataSearch ");		
		return claimsManager.lookUpDataSearch(sceenhandle, entityhandle);
	}
	
	/**
	 * 
	 * @param handle
	 * @return
	 */
	public Object lookUpStaticData(String sceenhandle) throws Exception{
		LOG.info("*****	Received a call to ElClaimsProcessServiceImpl - lookUpStaticData ");		
		return claimsManager.lookUpStaticData(sceenhandle);
	}
}
