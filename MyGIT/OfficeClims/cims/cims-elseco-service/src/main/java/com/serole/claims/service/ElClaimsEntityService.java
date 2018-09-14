package com.serole.claims.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.serole.claims.model.Elseco.ElsecoClaimDetails;
import com.serole.claims.model.Elseco.ElsecoClaimReserve;
import com.serole.claims.model.Elseco.ElsecoClaimsHeader;
import com.serole.claims.model.Elseco.ElsecoClaimsInternalReference;
import com.serole.claims.model.Elseco.ElsecoClaimsItems;
import com.serole.claims.model.Elseco.ElsecoClaimsNotes;
import com.serole.claims.model.Elseco.ElsecoClaimsParty;
import com.serole.claims.model.Elseco.ElsecoClaimsTasks;
import com.serole.claims.model.Elseco.ElsecoMemberInfo;
import com.serole.claims.model.Elseco.ElsecoMemberResult;
import com.serole.claims.model.Elseco.ElsecoMemberRiskcode;

@Component
public interface ElClaimsEntityService {	
		
	public List<ElsecoClaimsHeader> getAllElsecoClaims() throws Exception;
	
	public List<ElsecoClaimsItems> getAllElsecoClaimItems() throws Exception;
	
	public List<ElsecoClaimDetails> getAllElsecoClaimDetails() throws Exception;
	
	public List<ElsecoClaimReserve> getAllElsecoClaimsReserve() throws Exception;
	
	public List<ElsecoClaimsNotes> getAllElsecoClaimNotes() throws Exception;

	public List<ElsecoClaimsTasks> getAllElsecoClaimsTasks() throws Exception;
	
	public List<ElsecoClaimsInternalReference> getAllElsecoClaimInternalReference() throws Exception;

	public List<ElsecoMemberInfo> getAllElsecoMemberInfo() throws Exception;

	public List<ElsecoMemberResult> getAllElsecoMemberResult() throws Exception;

	public List<ElsecoMemberRiskcode> getAllElsecoMemberRiskcode() throws Exception;
	
	public List<ElsecoClaimsParty> getAllElsecoClaimsParty() throws Exception;
	
	public List<Object> getElsecoClaimsBySearchCriteria(JSONObject jsonObject) throws Exception;
		
	//Filter service
	public Object getClaimDetailsBySearchCriteria(JSONObject jsonObject) throws Exception;	
	
	//new claims search
	public Object getClaimBySearchCriteria(JSONObject jsonObject) throws Exception;	
		
	public long addElsecoClaims(Map<String, Object> queryMap) throws Exception;
	
	public void updateElsecoClaims(Map<String, Object> queryMap) throws Exception;

	public void deleteElsecoClaims(String table, int claimsHeaderId) throws Exception;
	
}
