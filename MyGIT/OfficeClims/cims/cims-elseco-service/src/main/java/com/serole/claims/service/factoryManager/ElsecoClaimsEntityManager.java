package com.serole.claims.service.factoryManager;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.serole.claims.core.claimsFactory.GenericClaimsMgmtFactory;
import com.serole.claims.model.Elseco.ElsecoCheckList;
import com.serole.claims.model.Elseco.ElsecoClaimDetails;
import com.serole.claims.model.Elseco.ElsecoClaimReserve;
import com.serole.claims.model.Elseco.ElsecoClaimsFile;
import com.serole.claims.model.Elseco.ElsecoClaimsHeader;
import com.serole.claims.model.Elseco.ElsecoClaimsInternalReference;
import com.serole.claims.model.Elseco.ElsecoClaimsItems;
import com.serole.claims.model.Elseco.ElsecoClaimsNotes;
import com.serole.claims.model.Elseco.ElsecoClaimsParty;
import com.serole.claims.model.Elseco.ElsecoClaimsTasks;
import com.serole.claims.model.Elseco.ElsecoClaimsTransaction;
import com.serole.claims.model.Elseco.ElsecoMemberInfo;
import com.serole.claims.model.Elseco.ElsecoMemberResult;
import com.serole.claims.model.Elseco.ElsecoMemberRiskcode;
import com.serole.claims.model.Elseco.ElsecoRiskObject;
import com.serole.claims.model.Helper.ElsecoClaimsEntityHelper;
import com.serole.claims.model.Helper.ElsecoClaimsProcessHelper;
import com.serole.claims.model.filterbeans.CriteriaEntity;

/**
 * A Claims Manager class with all the Methods which can be exposed from a Factory Layer
 * 
 * @author Serole_Vijay
 *
 */
@Component("demoClaimsManager")
@ComponentScan(basePackages = {"com.serole.claims", "com.serole.claims.model"})
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ElsecoClaimsEntityManager extends GenericClaimsMgmtFactory{
	private static final Logger LOG = LogManager.getLogger(ElsecoClaimsEntityManager.class);
	
	@Autowired
	ElsecoClaimsProcessHelper processHelper;
	
	@Autowired
	ElsecoClaimsEntityHelper entityHelper;
	
	private static ElsecoClaimsEntityManager instance;
	
	public void printClaimDetails() {
		LOG.info("In a AviationClaimsMgmtFactory... ");
	}
	
	@Lazy
	public ElsecoClaimsEntityManager getInstance()  {		
		if(instance == null) {
			instance = new ElsecoClaimsEntityManager();
			LOG.info("*****************      Creating a singleton instance of ElsecoClaimsEntityManager... ");
		}
		LOG.info("*****************      Returning the instance of ElsecoClaimsEntityManager... ");
		return instance;
	}
		
	
	/*               U S I N G     S P R I N G     J D B C     T E M P L A T E       D A O        */
	
	public List<ElsecoClaimsHeader> getAllElsecoClaimHeader() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimHeader");			
		 return entityHelper.getAllElsecoClaimHeader();
	}
	
	/*public List<ElsecoClaimsIncident> getAllElsecoClaimIncidents() {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimHeader");			
		 return entityentityHelper.getAllElsecoClaimIncidents();
	}*/
	
	public List<ElsecoClaimsHeader> getElsecoClaimHeaderById(ElsecoClaimsHeader elsecoQueryObj) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimHeaderById");
		if(elsecoQueryObj.getClaimHeaderId()>0) {
			return entityHelper.getElsecoClaimHeaderById(elsecoQueryObj.getClaimHeaderId());
		}
		return entityHelper.getAllElsecoClaimHeader();		
	}
	
	public long insertElsecoClaimHeader(ElsecoClaimsHeader elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimHeader");		
		return entityHelper.addElsecoClaimHeader(elsecoClaims);
	}
	
	public void updateElsecoClaimHeader(ElsecoClaimsHeader elsecoClaims)  throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimHeader");		
		entityHelper.updateElsecoClaimHeader(elsecoClaims);
	}
	
	public void deleteElsecoClaimsHeader(int claimsHeaderId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsHeader");		
		entityHelper.deleteElsecoClaimsHeader(claimsHeaderId);
	}
	
	
	/*   -------------       E L   C L A I M   I T E M    T        ----------------------------------------------------------------------*/
	public List<ElsecoClaimsItems> getAllElsecoClaimItems() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimItems");			
		 return entityHelper.getAllElsecoClaimItems();
	}
	
	public List<ElsecoClaimsItems> getElsecoClaimItemById(ElsecoClaimsItems elsecoQueryObj) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimItemById");
		if(elsecoQueryObj.getClaimItemId()>0) {
			return entityHelper.getElsecoClaimItemById(elsecoQueryObj.getClaimItemId());
		}
		return entityHelper.getAllElsecoClaimItems();		
	}
	
	public long insertElsecoClaimItem(ElsecoClaimsItems elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimItem");		
		return entityHelper.addElsecoClaimItem(elsecoClaims);
	}
	
	public void updateElsecoClaimItem(ElsecoClaimsItems elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimItem");		
		entityHelper.updateElsecoClaimItem(elsecoClaims);
	}
	
	public void deleteElsecoClaimsItem(int claimItemId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsHeader");		
		entityHelper.deleteElsecoClaimItem(claimItemId);
	}
	
	/* ----------------------- E L   C L A I M   D E T A I L    T     ---------------------------------------------------------------------------*/
	/**
	 * Get all the records from table 
	 * @return
	 */
	public List<ElsecoClaimDetails> getAllElsecoClaimDetails() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimDetails");			
		 return entityHelper.getAllElsecoClaimDetails();
	}
	
	/**
	 * 
	 * @param elsecoQueryObj
	 * @return
	 */
	public List<ElsecoClaimDetails> getElsecoClaimDetailById(ElsecoClaimDetails elsecoQueryObj) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimDetailById");
		if(elsecoQueryObj.getClaimHeaderId()>0) {
			return entityHelper.getElsecoClaimDetailById(elsecoQueryObj.getClaimId());
		}
		return entityHelper.getAllElsecoClaimDetails();		
	}
	
	/**
	 * 
	 * @param elsecoClaims
	 * @return
	 */
	public long insertElsecoClaimDetail(ElsecoClaimDetails elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimDetail");		
		return entityHelper.addElsecoClaimDetail(elsecoClaims);
	}
	
	/**
	 * A method to Update the Claims to data layer
	 * 
	 * @param elsecoClaims
	 * @return
	 */
	public void updateElsecoClaimDetail(ElsecoClaimDetails elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimDetail");		
		entityHelper.updateElsecoClaimDetail(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims to data layer
	 * @param claimsHeaderId
	 */
	public void deleteElsecoClaimDetail(int claimsHeaderId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimDetail");		
		entityHelper.deleteElsecoClaimDetail(claimsHeaderId);
	}
	
	/**
	 * A method to search based on filter criteria
	 * @param claimsHeaderId
	 
	public Object getClaimDetailsByFilterCriteria(CriteriaEntity criteriaEntity) {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getClaimDetailsByFilterCriteria");
		return entityHelper.getClaimDetailsByFilterCriteria(criteriaEntity);		
	}*/
	
	/**
	 * A method to retrieve the data based on various search criteria
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	public Object getClaimDetailsBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getClaimDetailsBySearchCriteria");
		return processHelper.populateClaimsBySearchCriteria(criteriaEntity);		
	}
	
	
	/**
	 * A method to retrieve the data based on various search criteria
	 * new claims search
	 * @param criteriaEntity
	 * @return
	 */
	public Object getClaimBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getClaimBySearchCriteria");
		return processHelper.retrieveClaimsBySearchCriteria(criteriaEntity);		
	}
	

	/*   -------------       E L   C L A I M     N O T E S      T        ----------------------------------------------------------------------*/
	public List<ElsecoClaimsNotes> getAllElsecoClaimNotes() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimNotes");			
		 return entityHelper.getAllElsecoClaimNotes();
	}
	
	public List<ElsecoClaimsNotes> getElsecoClaimNotesById(ElsecoClaimsNotes elsecoQueryObj) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimNotesById");
		if(elsecoQueryObj.getClaimNotesId() >0) {
			return entityHelper.getElsecoClaimNotesById(elsecoQueryObj.getClaimNotesId());
		}
		return entityHelper.getAllElsecoClaimNotes();		
	}
	
	public long insertElsecoClaimNotes(ElsecoClaimsNotes elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimNotes");		
		return entityHelper.addElsecoClaimNotes(elsecoClaims);
	}
	
	public void updateElsecoClaimNotes(ElsecoClaimsNotes elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimNotes");		
		entityHelper.updateElsecoClaimNotes(elsecoClaims);
	}
	
	public void deleteElsecoClaimsNotes(int claimNotesId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsNotes");		
		entityHelper.deleteElsecoClaimNotes(claimNotesId);
	}
	
	
	/*   -------------       E L   C L A I M   T A S K S      T        ----------------------------------------------------------------------*/
	public List<ElsecoClaimsTasks> getAllElsecoClaimTasks() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimTasks");			
		 return entityHelper.getAllElsecoClaimTasks();
	}
	
	public List<ElsecoClaimsTasks> getElsecoClaimTasksById(ElsecoClaimsTasks elsecoQueryObj) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimTasksById");
		if(elsecoQueryObj.getClaimTaskId() >0) {
			return entityHelper.getElsecoClaimTaskById(elsecoQueryObj.getClaimTaskId());
		}
		return entityHelper.getAllElsecoClaimTasks();		
	}
	
	public long insertElsecoClaimTasks(ElsecoClaimsTasks elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimTasks");		
		return entityHelper.addElsecoClaimTask(elsecoClaims);
	}
		
	public void updateElsecoClaimTasks(ElsecoClaimsTasks elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimTasks");		
		entityHelper.updateElsecoClaimTask(elsecoClaims);
	}
	
	public void deleteElsecoClaimsTasks(int claimTaskId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsTasks");		
		entityHelper.deleteElsecoClaimTask(claimTaskId);
	}

	/*   -------------       E L   C L A I M   R E S E R V E      T        ----------------------------------------------------------------------*/
	public List<ElsecoClaimReserve> getAllElsecoClaimReserve() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimReserve");			
		 return entityHelper.getAllElsecoClaimReserve();
	}
	
	public List<ElsecoClaimReserve> getElsecoClaimReserveById(ElsecoClaimReserve elsecoQueryObj) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimReserveById");
		if(elsecoQueryObj.getClaimReserveId()>0) {
			return entityHelper.getElsecoClaimReserveById(elsecoQueryObj.getClaimReserveId());
		}
		return entityHelper.getAllElsecoClaimReserve();		
	}
	
	public long insertElsecoClaimReserve(ElsecoClaimReserve elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimReserve");		
		return entityHelper.addElsecoClaimReserve(elsecoClaims);
	}
	
	public void updateElsecoClaimReserve(ElsecoClaimReserve elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimReserve");		
		entityHelper.updateElsecoClaimReserve(elsecoClaims);
	}
	
	public void deleteElsecoClaimsReserve(int claimReserveId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsReserve");		
		entityHelper.deleteElsecoClaimReserve(claimReserveId);
	}
	
	/*   -------------       E L   C L A I M     F I L E S      T        ----------------------------------------------------------------------*/
	public List<ElsecoClaimsFile> getAllElsecoClaimFiles() throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimFiles");			
		 return entityHelper.getAllElsecoClaimFiles();
	}
	
	public List<ElsecoClaimsFile> getElsecoClaimFilesById(ElsecoClaimsFile elsecoQueryObj) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimFilesById");
		if(elsecoQueryObj.getClaimFileId() >0) {
			return entityHelper.getElsecoClaimFilesById(elsecoQueryObj.getClaimFileId());
		}
		return entityHelper.getAllElsecoClaimFiles();		
	}
	
	public long insertElsecoClaimFiles(ElsecoClaimsFile elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimFiles");		
		return entityHelper.addElsecoClaimFiles(elsecoClaims);
	}
	
	public void updateElsecoClaimFiles(ElsecoClaimsFile elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimFiles");		
		entityHelper.updateElsecoClaimFiles(elsecoClaims);
	}
	
	public void deleteElsecoClaimsFiles(int claimFilesId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsFiles");		
		entityHelper.deleteElsecoClaimFiles(claimFilesId);
	}
	
	
	/*   -------------       E L   C L A I M     T R A N S A C T I O N S      T        ----------------------------------------------------------------------*/
	public List<ElsecoClaimsTransaction> getAllElsecoClaimTransactions() throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimTransactions");			
		 return entityHelper.getAllElsecoClaimTransaction();
	}
	
	public List<ElsecoClaimsTransaction> getElsecoClaimTransactionById(ElsecoClaimsTransaction elsecoQueryObj) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimTransactionById");
		if(elsecoQueryObj.getClaimsTransactionId() >0) {
			return entityHelper.getElsecoClaimTransactionById(elsecoQueryObj.getClaimsTransactionId());
		}
		return entityHelper.getAllElsecoClaimTransaction();		
	}
	
	public long insertElsecoClaimsTransaction(ElsecoClaimsTransaction elsecoClaims)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimsTransaction");		
		return entityHelper.addElsecoClaimTransaction(elsecoClaims);
	}
	
	public void updateElsecoClaimsTransaction(ElsecoClaimsTransaction elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimsTransaction");		
		entityHelper.updateElsecoClaimTransaction(elsecoClaims);
	}
	
	public void deleteElsecoClaimsTransaction(int claimNotesId) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsTransaction");		
		entityHelper.deleteElsecoClaimTransaction(claimNotesId);
	}
		
	/*   --------------------------       E L   C L A I M     R I S K   O B J E C T        ----------------------------------------*/
	public List<ElsecoRiskObject> getAllElsecoRiskObject() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoRiskObject");			
		 return entityHelper.getAllElsecoRiskObject();
	}
	
	public List<ElsecoRiskObject> getElsecoRiskObjectById(ElsecoRiskObject riskobject) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoRiskObjectById");
		if(riskobject.getRiskObjId() >0) {
			return entityHelper.getElsecoRiskObjects(riskobject.getRiskObjId());
		}
		return entityHelper.getAllElsecoRiskObject();		
	}
	
	public long insertElsecoRiskObject(ElsecoRiskObject riskobject) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoRiskObject");		
		return entityHelper.addElsecoRiskObject(riskobject);
	}
	
	public void updateElsecoRiskObject(ElsecoRiskObject riskobject) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoRiskObject");		
		entityHelper.updateElsecoRiskObject(riskobject);
	}
	
	public void deleteElsecoRiskObject(int riskobid) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoRiskObject");		
		entityHelper.deleteElsecoRiskObject(riskobid);
	}
	
	/*   --------------------------       E L   C L A I M     I N T E R N A L      R E F E R E N C E       -----------------------*/
	public List<ElsecoClaimsInternalReference> getAllElsecoInternalReference() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimsInternalReference");			
		 return entityHelper.getAllElsecoInternalReference();
	}
	
	public List<ElsecoClaimsInternalReference> getElsecoInternalRefById(ElsecoClaimsInternalReference intRef) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoInternalRefById");
		if(intRef.getIntRefId() >0) {
			return entityHelper.getElsecoInternalReferenceById(intRef.getIntRefId());
		}
		return entityHelper.getAllElsecoInternalReference();	
	}
	
	public long insertElsecoInternalReference(ElsecoClaimsInternalReference intRef) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoInternalReference");		
		return entityHelper.addElsecoInternalReference(intRef);
	}
	
	public void updateElsecoInternalReference(ElsecoClaimsInternalReference intRef) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoInternalReference");		
		entityHelper.updateElsecoInternalReference(intRef);
	}
	
	public void deleteElsecoInternalReference(int intRefId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoInternalReference");		
		entityHelper.deleteElsecoInternalReference(intRefId);
	}
	
	/*   --------------------------       E L   C L A I M     M E M B E R       I N F O       -----------------------------*/
	public List<ElsecoMemberInfo> getAllElsecoMemberInfo() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoMemberInfo");			
		 return entityHelper.getAllElsecoMemberInfo();
	}
	
	public List<ElsecoMemberInfo> getElsecoMemberInfoById(ElsecoMemberInfo memberInfo) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoMemberInfoById");
		if(memberInfo.getMemberId() >0) {
			return entityHelper.getElsecoMemberInfoById(memberInfo.getMemberId());
		}
		return entityHelper.getAllElsecoMemberInfo();		
	}
	
	public long insertElsecoMemberInfo(ElsecoMemberInfo memberInfo) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoMemberInfo");		
		return entityHelper.addElsecoMemberInfo(memberInfo);
	}
	
	public void updateElsecoMemberInfo(ElsecoMemberInfo memberInfo) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoMemberInfo");		
		entityHelper.updateElsecoMemberInfo(memberInfo);
	}
	
	public void deleteElsecoMemberInfo(int memberId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoMemberInfo");		
		entityHelper.deleteElsecoMemberInfo(memberId);
	}
	
	/*   --------------------------       E L   C L A I M     M E M B E R       R  E S U L T        ------------------------*/
	public List<ElsecoMemberResult> getAllElsecoMemberResult() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoMemberResult");			
		 return entityHelper.getAllElsecoMemberResult();
	}
	
	public List<ElsecoMemberResult> getElsecoMemberResultById(ElsecoMemberResult result) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoMemberResultById");
		if(result.getResultId() >0) {
			return entityHelper.getElsecoMemberResultById(result.getResultId());
		}
		return entityHelper.getAllElsecoMemberResult();		
	}
	
	public long insertElsecoMemberResult(ElsecoMemberResult riskobject) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoMemberResult");		
		return entityHelper.addElsecoMemberResult(riskobject);
	}
	
	public void updateElsecoMemberResult(ElsecoMemberResult riskobject) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoMemberResult");		
		entityHelper.updateElsecoMemberResult(riskobject);
	}
	
	public void deleteElsecoMemberResult(int resultId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoMemberResult");		
		entityHelper.deleteElsecoMemberResult(resultId);
	}
	
	/*   --------------------------       E L     C L A I M     M E M B E R     R I S K    C O D E       --------------------------*/
	public List<ElsecoMemberRiskcode> getAllElsecoMemberRiskcode() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoMemberRiskcode");			
		 return entityHelper.getAllElsecoMemberRiskcode();
	}
	
	public List<ElsecoMemberRiskcode> getElsecoMemberRiskcode(ElsecoMemberRiskcode riskCode) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoMemberRiskcode");
		if(riskCode.getLlRiskCodeId() >0) {
			return entityHelper.getElsecoMemberRiskcodeById(riskCode.getLlRiskCodeId());
		}
		return entityHelper.getAllElsecoMemberRiskcode();		
	}
	
	public long insertElsecoMemberRiskcode(ElsecoMemberRiskcode riskobject) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoMemberRiskcode");		
		return entityHelper.addElsecoMemberRiskcode(riskobject);
	}
	
	public void updateElsecoMemberRiskcode(ElsecoMemberRiskcode riskobject) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoMemberRiskcode");		
		entityHelper.updateElsecoMemberRiskcode(riskobject);
	}
	
	public void deleteElsecoMemberRiskcode(int riskCodeId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoMemberRiskcode");		
		entityHelper.deleteElsecoMemberRiskcode(riskCodeId);
	}
	
	/*   --------------------------       E L     C L A I M     P A R T Y       --------------------------*/
	public List<ElsecoClaimsParty> getAllElsecoClaimsParty() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimsParty");			
		 return entityHelper.getAllElsecoClaimsParty();
	}
	
	public List<ElsecoClaimsParty> getElsecoClaimsPartyById(ElsecoClaimsParty party) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimsParty");
		if(party.getPartyId() >0) {
			return entityHelper.getElsecoClaimsPartyById(party.getPartyId());
		}
		return entityHelper.getAllElsecoClaimsParty();		
	}
	
	public long insertElsecoClaimsParty(ElsecoClaimsParty party) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimsParty");		
		return entityHelper.addElsecoClaimsParty(party);
	}
	
	public void updateElsecoClaimsParty(ElsecoClaimsParty party) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimsParty");		
		entityHelper.updateElsecoClaimsParty(party);
	}
	
	public void deleteElsecoClaimsParty(int partyId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsParty");		
		entityHelper.deleteElsecoClaimsParty(partyId);
	}

	/*   --------------------------       E L     C L A I M    C H E C K L I S T       --------------------------*/
	public List<ElsecoCheckList> getAllCheckList() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getAllElsecoClaimsCheckList");			
		 return entityHelper.getAllCheckList();
	}
	
	public List<ElsecoCheckList> getElsecoClaimsCheckListById(ElsecoCheckList check) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - getElsecoClaimsCheckList");
		if(check.getCheckListId() >0) {
			return entityHelper.getCheckListById(check.getCheckListId());
		}
		return entityHelper.getAllCheckList();		
	}
	
	public long insertElsecoClaimsCheckLis(ElsecoCheckList CheckList) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - insertElsecoClaimsCheckList");		
		return entityHelper.addElsecoCheckList(CheckList);
	}
	
	public void updateElsecoClaimsCheckList(ElsecoCheckList CheckList) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - updateElsecoClaimsCheckList");		
		entityHelper.updateElsecoCheckList(CheckList);
	}
	
	public void deleteElsecoClaimsCheckList(int checklistid) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsEntityManager - deleteElsecoClaimsCheckList");		
		entityHelper.deleteElsecoCheckList(checklistid);
	}
}
