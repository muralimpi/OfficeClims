package com.serole.claims.service.factoryManager;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.serole.claims.core.claimsFactory.GenericClaimsMgmtFactory;
import com.serole.claims.model.Elseco.ElsecoClaimsAuditTrail;
import com.serole.claims.model.Elseco.ElsecoHybrisPayHistory;
import com.serole.claims.model.Helper.ElsecoClaimsProcessHelper;
import com.serole.claims.model.filterbeans.CriteriaEntity;
import com.serole.claims.model.json.JsonHandlerForSaveUcrExtRef;
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;


/**
 * A Claims Manager class with all the Methods which can be exposed from a Factory Layer
 * 
 * @author Serole_Vijay
 *
 */
@Primary
@Component("aviationClaimsManager")
@ComponentScan(basePackages = {"com.serole.claims", "com.serole.claims.model"})
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ElsecoClaimsProcessManager extends GenericClaimsMgmtFactory{
	private static final Logger LOG = LogManager.getLogger(ElsecoClaimsProcessManager.class);
	
	@Autowired
	ElsecoClaimsProcessHelper helper;
	
	private static ElsecoClaimsProcessManager instance;
	
	public void printClaimDetails() {
		LOG.info("In a AviationClaimsMgmtFactory... ");
	}
	
	@Lazy
	public ElsecoClaimsProcessManager getInstance()  {		
		if(instance == null) {
			instance = new ElsecoClaimsProcessManager();
			LOG.info("*****************      Creating a singleton instance of ElsecoClaimsProcessManager... ");
		}
		LOG.info("*****************      Returning the instance of ElsecoClaimsProcessManager... ");
		return instance;
	}
	
	/**
	 * A method to service the saving of the Entire Claims structure at one single instance and audit the records.
	 * @param newClaims
	 * @param oldClaims
	 * @param auditTrail
	 * @return
	 * @throws Exception
	 */
	public int saveClaims(JsonHandlerForWorklistAndSaveClaims newClaims, JsonHandlerForWorklistAndSaveClaims oldClaims,
			ElsecoClaimsAuditTrail auditTrail) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - saveClaims ");
		return helper.saveClaims(newClaims, oldClaims, auditTrail);
	}
	
	/**
	 *  A method to service the saving of the UCR along with External References in a Json structure at one single instance and audit the records.
	 *  
	 * @param newClaims
	 * @param oldClaims
	 * @param auditTrail
	 * @return
	 * @throws Exception
	 */
	public int saveExtReference(JsonHandlerForSaveUcrExtRef newClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - saveExtReference ");
		return helper.saveExtReference(newClaims);
	}
	
	public void saveAudit(ElsecoClaimsAuditTrail audit)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - saveAudit ");		
		helper.saveAudit(audit);
	}
	
	/**
	 * A method to a Get specific the static data from Data Layer
	 * 
	 * @param handle
	 * @param id
	 * @return
	 */
	public Object lookUpDataSearch(String sceenhandle, String entityhandle)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - lookUpDataSearch ");		
		return helper.lookUpDataSearch(sceenhandle, entityhandle);
	}
	
	/**
	 * updateMemberInfoAfterPayment - Update the Member Info section with Collected status after the Hybris payment call
	 * 
	 * @param isCollected
	 * @param status
	 */
	public void updateMemberInfoAfterPayment(ElsecoHybrisPayHistory hybrisPay)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - updateMemberInfoAfterPayment");		
		helper.updateMemberInfoAfterPayment(hybrisPay);
	}
	
	/**
	 * A method to add a Audit Trail Data 
	 * 
	 * @param auditTrail
	 * @return
	 */
	public long addAuditTrail(ElsecoClaimsAuditTrail auditTrail) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - addAuditTrail");		
		return helper.addAuditTrail(auditTrail);
	}
	
	/**
	 * A method to a Get all the static data from Data Layer
	 * 
	 * @param handle
	 * @param id
	 * @return
	 */
	public Object lookUpStaticData(String sceenhandle)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - lookUpStaticData ");		
		return helper.lookUpStaticData(sceenhandle);
	}

	/**
	 * A method 
	 * @param criteriaEntity
	 * @return
	 * @throws Exception 
	 */
	public List<?> getAuditDetailsBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - getAuditDetailsBySearchCriteria ");		
		return helper.getAuditDetailsBySearchCriteria(criteriaEntity);
	}	
	
	/**
	 * Update the Claim Status in Claim Details
	 * 
	 * @param headerId
	 * @param detailId
	 * @param claimStatus
	 */
	public void claimDetailStatusChange(String headerId,String detailId, String claimStatus)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - claimDetailStatusChange ");	
		helper.claimDetailStatusChange(headerId, detailId, claimStatus);
	}
	
/*   --------------------------       E L   H Y B R I S        P A Y         H I S T O R Y        ----------------------------------------*/
	
	/**
	 * Add the Hybris Payment Data for persisting in DB
	 * 
	 * @param hybrispay
	 * @return
	 * @throws Exception
	 */
	public long addElsecoHybrisPayHistory(ElsecoHybrisPayHistory hybrispay) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - addElsecoHybrisPayHistory");		
		return helper.addElsecoHybrisPayHistory(hybrispay);
	}
	
	/**
	 * Update the Payment History after the call with Hybris service
	 * 
	 * @param hybrispay
	 * @throws Exception
	 */
	public void updateHybrisPayHistory(ElsecoHybrisPayHistory hybrispay) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsProcessManager - updateHybrisPayHistory ");	
		helper.updateHybrisPayHistory(hybrispay);
	}
}
