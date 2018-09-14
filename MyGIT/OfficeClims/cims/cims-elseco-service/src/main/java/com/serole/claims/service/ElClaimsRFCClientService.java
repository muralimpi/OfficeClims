package com.serole.claims.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.serole.claims.model.rfc.hybris.ElsecoClaimsHybrisResponse;
import com.serole.claims.model.rfc.hybris.ElsecoCrmPqm;

@Component
public interface ElClaimsRFCClientService {
		
	public ElsecoClaimsHybrisResponse populateHybrisCollectPaymentDetails(Map<String, Object> queryMap) throws Exception;
	
	public ElsecoClaimsHybrisResponse populateHybrisReleasePaymentDetails(Map<String, Object> queryMap) throws Exception;
	
	public boolean isValidData(Map<String, Object> queryMap) throws Exception; 
	
	public List<ElsecoCrmPqm> populateBPBalanceAmount(List<ElsecoCrmPqm> queryMap) throws Exception;
}
