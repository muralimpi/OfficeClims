package com.serole.claims.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.serole.claims.model.Elseco.ElsecoClaimsAuditTrail;
import com.serole.claims.model.json.JsonHandlerForSaveUcrExtRef;
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;

@Component
public interface ElClaimsProcessService {
	
	public void addAuditTrail(JSONObject jsonObject) throws Exception;
	
	public Object lookUpDataSearch(String handle, String id) throws Exception;
	
	public Object lookUpStaticData(String handle) throws Exception;	
	
	public int saveClaims(JsonHandlerForWorklistAndSaveClaims newClaims, JsonHandlerForWorklistAndSaveClaims oldClaims, ElsecoClaimsAuditTrail auditTrail) throws Exception;
	
	public int saveExtReference(JsonHandlerForSaveUcrExtRef newClaims) throws Exception;
	
	public void saveAudit(ElsecoClaimsAuditTrail audit) throws Exception;
	
	public List<?> getAuditDetailsBySearchCriteria(JSONObject jsonObject) throws Exception;

	public void claimStatusNotification(String headerId, String detailId, String statusHandle) throws Exception;
		
}
