package com.serole.claims.model.Helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serole.claims.model.Dao.ElClaimsEntityRepository;
import com.serole.claims.model.Dao.ElClaimsProcessRepository;
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
import com.serole.claims.model.constants.ElsecoClaimsConstant;

/**
 * a helper class that acts as a delegate between the Claims Manager and the Data Layer.
 * Here Data Layer is invoked in two ways - Using Spring JDBCTemplate and Another is Making use of a JPARespository 
 * 
 * @author Serole_Vijay
 *
 */
@Component
public class ElsecoClaimsEntityHelper {
	
	private static final Logger LOG = LoggerFactory.getLogger(ElsecoClaimsEntityHelper.class);
	
	@Autowired
	ElClaimsEntityRepository entityDao;
	
	@Autowired
	ElClaimsProcessRepository processDao;

	@Autowired
	ElsecoClaimsConstant elsecoClaimsConstant;
	
	/*               U S I N G     S P R I N G     J D B C     T E M P L A T E       D A O        */
	
	/**
	 * A method to a Get all the Claims from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsHeader> getAllElsecoClaimHeader() throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimHeader");		
		return entityDao.getAllClaimHeaders();
	}
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsHeader> getElsecoClaimHeaderById(int claimsHeaderId) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimHeaderById");	
		List<ElsecoClaimsHeader> lstClaims =  new ArrayList<ElsecoClaimsHeader>();
		lstClaims.add(entityDao.getClaimHeaderById(claimsHeaderId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimHeader(ElsecoClaimsHeader elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimHeader");		
		return entityDao.insertClaimHeader(elsecoClaims);
	}
	
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimHeader(ElsecoClaimsHeader elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimHeader");		
		entityDao.updateClaimHeader(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimsHeader(int claimsHeaderId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimsHeader");		
		entityDao.deleteClaimsHeaderById(claimsHeaderId);
	}
	
	/**
	 * @return
	 */
	public List<ElsecoClaimsItems> getAllElsecoClaimItems() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimItems");		
		return entityDao.getAllClaimsItems();
	}
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsItems> getElsecoClaimItemById(int claimItemId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimItemById");	
		List<ElsecoClaimsItems> lstClaims =  new ArrayList<ElsecoClaimsItems>();
		lstClaims.add(entityDao.getClaimItemById(claimItemId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimItem(ElsecoClaimsItems elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimItem");		
		return entityDao.insertClaimItem(elsecoClaims);
	}
	
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimItem(ElsecoClaimsItems elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimItem");		
		entityDao.updateClaimItem(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimItem(int claimItemId) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimItem");		
		entityDao.deleteClaimsItemById(claimItemId);
	}
	
	/**
	 * A method to a Get all the Claims from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimDetails> getAllElsecoClaimDetails() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimDetails");		
		return entityDao.getAllClaimDetails();
	}
		
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimDetails> getElsecoClaimDetailById(int claimsDetailId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimDetailById");	
		List<ElsecoClaimDetails> lstClaims =  new ArrayList<ElsecoClaimDetails>();
		lstClaims.add(entityDao.getClaimDetailById(claimsDetailId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimDetail(ElsecoClaimDetails elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimDetail");		
		return entityDao.insertClaimDetail(elsecoClaims);
	}
	
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimDetail(ElsecoClaimDetails elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimDetail");		
		entityDao.updateClaimDetail(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimDetail(int claimsHeaderId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimDetail");		
		entityDao.deleteClaimDetailById(claimsHeaderId);
	}
	
	/**
	 * A method to a Get all the Claims from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimReserve> getAllElsecoClaimReserve() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimReserve");		
		return entityDao.getAllClaimReserves();
	}
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimReserve> getElsecoClaimReserveById(int claimsReserveId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimReserveById");	
		List<ElsecoClaimReserve> lstClaims =  new ArrayList<ElsecoClaimReserve>();
		lstClaims.add(entityDao.getClaimReserveById(claimsReserveId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimReserve(ElsecoClaimReserve elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimReserve");		
		return entityDao.insertClaimReserve(elsecoClaims);
	}
	
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimReserve(ElsecoClaimReserve elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimReserve");		
		entityDao.updateElsecoClaimReserve(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimReserve(int claimsReserveId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimReserve");		
		entityDao.deleteElsecoClaimReserveById(claimsReserveId);
	}
	
	/**
	 * A method to a Get all the Claims from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsNotes> getAllElsecoClaimNotes() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimNotes");		
		return entityDao.getAllClaimNotes();
	}
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsNotes> getElsecoClaimNotesById(int claimsNotesId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimNotesById");	
		List<ElsecoClaimsNotes> lstClaims =  new ArrayList<ElsecoClaimsNotes>();
		lstClaims.add(entityDao.getClaimNotesById(claimsNotesId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimNotes(ElsecoClaimsNotes elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimNotes");		
		return entityDao.insertClaimNotes(elsecoClaims);
	}
	
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimNotes(ElsecoClaimsNotes elsecoClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimNotes");		
		entityDao.updateElsecoClaimNotes(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimNotes(int claimsNotesId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimNotes");		
		entityDao.deleteElsecoClaimNotesById(claimsNotesId);
	}
	
	/**
	 * A method to a Get all the Claims from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsTasks> getAllElsecoClaimTasks() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimTasks");		
		return entityDao.getAllClaimTasks();
	}
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsTasks> getElsecoClaimTaskById(int claimsTaskId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimTaskById");	
		List<ElsecoClaimsTasks> lstClaims =  new ArrayList<ElsecoClaimsTasks>();
		lstClaims.add(entityDao.getClaimTaskById(claimsTaskId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimTask(ElsecoClaimsTasks elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimTask");		
		return entityDao.insertClaimTask(elsecoClaims);
	} 
		
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimTask(ElsecoClaimsTasks elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimTask");		
		entityDao.updateElsecoClaimTask(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimTask(int claimsTaskId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimTask");		
		entityDao.deleteElsecoClaimTasksById(claimsTaskId);
	}
		
	/**
	 * A method to a Get all the Claims from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsFile> getAllElsecoClaimFiles() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimFiles");		
		return entityDao.getAllClaimFile();
	}
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsFile> getElsecoClaimFilesById(int claimsFileId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimFilesById");	
		List<ElsecoClaimsFile> lstClaims =  new ArrayList<ElsecoClaimsFile>();
		lstClaims.add(entityDao.getClaimFileById(claimsFileId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimFiles(ElsecoClaimsFile elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimFiles");		
		return entityDao.insertClaimFile(elsecoClaims);
	} 
		
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimFiles(ElsecoClaimsFile elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimTask");		
		entityDao.updateElsecoClaimFile(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimFiles(int claimsFileId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimFiles");		
		entityDao.deleteElsecoClaimFileById(claimsFileId);
	}
	
	/**
	 * A method to a Get all the Claims from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsTransaction> getAllElsecoClaimTransaction() throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimTransaction");		
		return entityDao.getAllClaimTransaction();
	}
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsTransaction> getElsecoClaimTransactionById(int claimsTransactionId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getElsecoClaimTransactionById");	
		List<ElsecoClaimsTransaction> lstClaims =  new ArrayList<ElsecoClaimsTransaction>();
		lstClaims.add(entityDao.getClaimTransactionById(claimsTransactionId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims to the backend Database
	 * @return
	 */
	public long addElsecoClaimTransaction(ElsecoClaimsTransaction elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoClaimTransaction");		
		return entityDao.insertClaimTransaction(elsecoClaims);
	} 
		
	/**
	 * A method to update the Claims in Database 
	 * @return
	 */
	public void updateElsecoClaimTransaction(ElsecoClaimsTransaction elsecoClaims) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateElsecoClaimTransaction");		
		entityDao.updateElsecoClaimTransaction(elsecoClaims);
	}
	
	/**
	 * A method to delete the Claims from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimTransaction(int claimsTransactionId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimTransaction");		
		entityDao.deleteElsecoClaimTransactionById(claimsTransactionId);
	}
		
	/**
	 * A method to a Get all the RiskObjects from Data Layer 
	 * @return
	 */
	public List<ElsecoRiskObject> getAllElsecoRiskObject() throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getAllElsecoRiskObject");		
		return entityDao.getAllRiskObjects();
	}
	
	/**
	 * A method to a Get a specific RiskObject based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoRiskObject> getElsecoRiskObjects(int riskobjid) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getElsecoRiskObjects");	
		List<ElsecoRiskObject> lstClaims =  new ArrayList<ElsecoRiskObject>();
		lstClaims.add(entityDao.getRiskObjectById(riskobjid));
		return lstClaims;
	}
	
	/**
	 * A method to a add the RiskObject to the backend Database
	 * @return
	 */
	public long addElsecoRiskObject(ElsecoRiskObject riskobject) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - addElsecoRiskObject");		
		return entityDao.insertRiskObject(riskobject);
	}
	
	/**
	 * A method to update the RiskObject in Database 
	 * @return
	 */
	public void updateElsecoRiskObject(ElsecoRiskObject riskobject) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - updateElsecoRiskObject");		
		entityDao.updateRiskObject(riskobject);
	}
	
	/**
	 * A method to delete the RiskObject from Data Layer 
	 * @return
	 */
	public void deleteElsecoRiskObject(int riskobid) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoRiskObject");		
		entityDao.deleteRiskObjectId(riskobid);
	}
	
	/**
	 * A method to a Get all the MemberInfo from Data Layer 
	 * @return
	 */
	public List<ElsecoMemberInfo> getAllElsecoMemberInfo() throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getAllElsecoMemberInfo");		
		return entityDao.getAllMemberInfo();
	}
	
	/**
	 * A method to a Get a specific MemberInfo based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoMemberInfo> getElsecoMemberInfoById(int memInfoId) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getElsecoMemberInfo");	
		List<ElsecoMemberInfo> lstClaims =  new ArrayList<ElsecoMemberInfo>();
		lstClaims.add(entityDao.getMemberInfoById(memInfoId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the MemberInfo to the backend Database
	 * @return
	 */
	public long addElsecoMemberInfo(ElsecoMemberInfo memberInfo) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - addElsecoMemberInfo");		
		return entityDao.insertMemberInfo(memberInfo);
	}
	
	/**
	 * A method to update the MemberInfo in Database 
	 * @return
	 */
	public void updateElsecoMemberInfo(ElsecoMemberInfo memberInfo) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - updateElsecoMemberInfo");		
		entityDao.updateMemberInfo(memberInfo);
	}
	
	/**
	 * A method to delete the MemberInfo from Data Layer 
	 * @return
	 */
	public void deleteElsecoMemberInfo(int memInfoId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoMemberInfo");		
		entityDao.deleteMemberInfoId(memInfoId);
	}
	
	/**
	 * A method to a Get all the MemberResult from Data Layer 
	 * @return
	 */
	public List<ElsecoMemberResult> getAllElsecoMemberResult() throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getAllElsecoMemberResult");		
		return entityDao.getAllMemberResults();
	}
	
	/**
	 * A method to a Get a specific MemberResult based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoMemberResult> getElsecoMemberResultById(int resultId) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getElsecoMemberResult");	
		List<ElsecoMemberResult> lstClaims =  new ArrayList<ElsecoMemberResult>();
		lstClaims.add(entityDao.getMemberResultsById(resultId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the MemberResult to the backend Database
	 * @return
	 */
	public long addElsecoMemberResult(ElsecoMemberResult memberResult) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - addElsecoMemberResult");		
		return entityDao.insertMemberResults(memberResult);
	}
	
	/**
	 * A method to update the MemberResult in Database 
	 * @return
	 */
	public void updateElsecoMemberResult(ElsecoMemberResult memberResult) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - updateElsecoMemberResult");		
		entityDao.updateMemberResults(memberResult);
	}
	
	/**
	 * A method to delete the MemberResult from Data Layer 
	 * @return
	 */
	public void deleteElsecoMemberResult(int resultId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoMemberResult");		
		entityDao.deleteMemberResultsById(resultId);
	}
	
	/**
	 * A method to a Get all the MemberRiskcode from Data Layer 
	 * @return
	 */
	public List<ElsecoMemberRiskcode> getAllElsecoMemberRiskcode() throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getAllElsecoMemberRiskcode");		
		return entityDao.getAllMemberRiskcode();
	}
	
	/**
	 * A method to a Get a specific MemberRiskcode based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoMemberRiskcode> getElsecoMemberRiskcodeById(int riskcodeId) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getElsecoMemberRiskcode");	
		List<ElsecoMemberRiskcode> lstClaims =  new ArrayList<ElsecoMemberRiskcode>();
		lstClaims.add(entityDao.getMemberRiskcodeById(riskcodeId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the MemberRiskcode to the backend Database
	 * @return
	 */
	public long addElsecoMemberRiskcode(ElsecoMemberRiskcode memberRiskcode) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - addElsecoMemberRiskcode");		
		return entityDao.insertMemberRiskcode(memberRiskcode);
	}
	
	/**
	 * A method to update the MemberRiskcode in Database 
	 * @return
	 */
	public void updateElsecoMemberRiskcode(ElsecoMemberRiskcode memberRiskcode) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - updateElsecoMemberRiskcode");		
		entityDao.updateMemberRiskcode(memberRiskcode);
	}
	
	/**
	 * A method to delete the MemberRiskcode from Data Layer 
	 * @return
	 */
	public void deleteElsecoMemberRiskcode(int riskcodeId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoMemberRiskcode");		
		entityDao.deleteMemberRiskcodeById(riskcodeId);
	}
	
	/**
	 * A method to a Get all the InternalReference from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsInternalReference> getAllElsecoInternalReference() throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getAllElsecoInternalReference");		
		return entityDao.getAllClaimsInternalReference();
	}
	
	/**
	 * A method to a Get a specific InternalReference based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsInternalReference> getElsecoInternalReferenceById(int intRefId) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getElsecoInternalReference");	
		List<ElsecoClaimsInternalReference> lstClaims =  new ArrayList<ElsecoClaimsInternalReference>();
		lstClaims.add(entityDao.getClaimsInternalReferenceById(intRefId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the InternalReference to the backend Database
	 * @return
	 */
	public long addElsecoInternalReference(ElsecoClaimsInternalReference intReference) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - addElsecoInternalReference");		
		return entityDao.insertClaimsInternalReference(intReference);
	}
	
	/**
	 * A method to update the InternalReference in Database 
	 * @return
	 */
	public void updateElsecoInternalReference(ElsecoClaimsInternalReference intReference) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - updateElsecoInternalReference");		
		entityDao.updateClaimsInternalReference(intReference);
	}
	
	/**
	 * A method to delete the InternalReference from Data Layer 
	 * @return
	 */
	public void deleteElsecoInternalReference(int intRefId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoInternalReference");		
		entityDao.deleteClaimsInternalReferenceById(intRefId);
	}

	/**
	 * A method to a Get all the Claims Party from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsParty> getAllElsecoClaimsParty() throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getAllElsecoClaimsParty");		
		return entityDao.getAllClaimsParty();
	}
	
	/**
	 * A method to a Get a specific Claims Party based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsParty> getElsecoClaimsPartyById(int partyId) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getElsecoClaimsPartyById");	
		List<ElsecoClaimsParty> lstClaims =  new ArrayList<ElsecoClaimsParty>();
		lstClaims.add(entityDao.getClaimsPartyById(partyId));
		return lstClaims;
	}
	
	/**
	 * A method to a add the Claims Party to the backend Database
	 * @return
	 */
	public long addElsecoClaimsParty(ElsecoClaimsParty party) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - addElsecoClaimsParty");		
		return entityDao.insertClaimsParty(party);
	}
	
	/**
	 * A method to update the Claims Party in Database 
	 * @return
	 */
	public void updateElsecoClaimsParty(ElsecoClaimsParty party) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - updateElsecoClaimsParty");		
		entityDao.updateClaimsParty(party);
	}
	
	/**
	 * A method to delete the Claims Party from Data Layer 
	 * @return
	 */
	public void deleteElsecoClaimsParty(int partyId) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoClaimsParty");		
		entityDao.deleteClaimsPartyById(partyId);
	}
	/**
	 * A method to a Get all the InternalReference from Data Layer 
	 * @return
	 */
	public List<ElsecoCheckList> getAllCheckList() throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getAllElsecoCheckList");		
		return entityDao.getAllCheckList();
	}
	
	/**
	 * A method to a Get a specific MemberRiskcode based on its unique key from Data Layer 
	 * @return
	 */
	public List<ElsecoCheckList> getCheckListById(int checklistid) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - getElsecoCheckList");	
		List<ElsecoCheckList> lstClaims =  new ArrayList<ElsecoCheckList>();
		lstClaims.add(entityDao.getCheckListById(checklistid));
		return lstClaims;
	}
	
	/**
	 * A method to a add the MemberRiskcode to the backend Database
	 * @return
	 */
	public long addElsecoCheckList(ElsecoCheckList checkList) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - addElsecoCheckList");		
		return entityDao.insertCheckList(checkList);
	}
	
	/**
	 * A method to update the MemberRiskcode in Database 
	 * @return
	 */
	public void updateElsecoCheckList(ElsecoCheckList checkList) throws Exception{
		LOG.info("****	Received a call to ElsecoClaimsHelper - updateElsecoCheckList");		
		entityDao.updateCheckList(checkList);
	}
	
	/**
	 * A method to delete the MemberRiskcode from Data Layer 
	 * @return
	 */
	public void deleteElsecoCheckList(int checklistid) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - deleteElsecoCheckList");		
		entityDao.deleteCheckListById(checklistid);
	}		
}
