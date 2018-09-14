package com.serole.claims.model.Helper;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
//import java.util.stream.Collectors;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.serole.claims.model.Dao.ElClaimsEntityRepository;
import com.serole.claims.model.Dao.ElClaimsProcessRepository;
import com.serole.claims.model.Elseco.ElsecoCheckList;
import com.serole.claims.model.Elseco.ElsecoClaimDetails;
import com.serole.claims.model.Elseco.ElsecoClaimReserve;
import com.serole.claims.model.Elseco.ElsecoClaimsAuditTrail;
import com.serole.claims.model.Elseco.ElsecoClaimsFile;
import com.serole.claims.model.Elseco.ElsecoClaimsHeader;
import com.serole.claims.model.Elseco.ElsecoClaimsInternalReference;
import com.serole.claims.model.Elseco.ElsecoClaimsItems;
import com.serole.claims.model.Elseco.ElsecoClaimsNotes;
import com.serole.claims.model.Elseco.ElsecoClaimsParty;
import com.serole.claims.model.Elseco.ElsecoClaimsPayee;
import com.serole.claims.model.Elseco.ElsecoClaimsStaticData;
import com.serole.claims.model.Elseco.ElsecoClaimsTasks;
import com.serole.claims.model.Elseco.ElsecoClaimsTransaction;
import com.serole.claims.model.Elseco.ElsecoHybrisPayHistory;
import com.serole.claims.model.Elseco.ElsecoMemberInfo;
import com.serole.claims.model.Elseco.ElsecoMemberResult;
import com.serole.claims.model.Elseco.ElsecoMemberRiskcode;
import com.serole.claims.model.Elseco.ElsecoRiskObject;
import com.serole.claims.model.constants.ElsecoClaimsConstant;
import com.serole.claims.model.exceptions.ElsecoClaimsServiceException;
import com.serole.claims.model.filterbeans.CriteriaEntity;
import com.serole.claims.model.json.JsonHandlerForAuditTrace;
import com.serole.claims.model.json.JsonHandlerForClaimsDetails;
import com.serole.claims.model.json.JsonHandlerForSaveUcrExtRef;
import com.serole.claims.model.json.JsonHandlerForStaticData;
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;



/**
 * a helper class that acts as a delegate between the Claims Manager and the Data Layer.
 * Here Data Layer is invoked in two ways - Using Spring JDBCTemplate and Another is Making use of a JPARespository 
 * 
 * @author Serole_Vijay
 *
 */
@Component
public class ElsecoClaimsProcessHelper {
	
	private static final Logger LOG = LoggerFactory.getLogger(ElsecoClaimsProcessHelper.class);
	
	@Autowired
	ElClaimsEntityRepository entityDao;
	
	@Autowired
	ElClaimsProcessRepository processDao;

	@Autowired
	ElsecoClaimsConstant elsecoClaimsConstant;
		
	/**
	 * A method to get the ClaimDetails By Search Criteria
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	public Object populateClaimsBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - populateClaimsBySearchCriteria");

		ElsecoClaimsHeader elClmHeader = processDao.getClaimHeaderById(criteriaEntity);
		List<ElsecoClaimDetails> elsecoClaimDetailsList = processDao.getClaimDetailBySearchCriteria(criteriaEntity);
		List<ElsecoRiskObject> elsecoRiskObjList = processDao.getClaimRiskobjBySearchCriteria(criteriaEntity);		
		List<ElsecoClaimReserve> elsecoClaimsReserveList = processDao.getClaimReserveBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsNotes> elsecoClaimsNotesList = processDao.getClaimNotesBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsTasks> elsecoClaimsTasksList = processDao.getClaimTasksBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsFile> elsecoClaimsFileList = processDao.getClaimFilesBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsItems> elsecoClaimItemsList = processDao.getClaimItemsBySearchCriteria(criteriaEntity);		
		List<ElsecoClaimsTransaction> elsecoClaimsTransactionList = processDao.getClaimTransBySearchCriteria(criteriaEntity);	
		List<ElsecoClaimsInternalReference> elsecoClaimsInternalReferenceList = processDao.getClaimIntReferenceBySearchCriteria(criteriaEntity);	
				
		List<ElsecoMemberInfo> elsecoMemberInfoList = processDao.getClaimMemberInfoBySearchCriteria(criteriaEntity);
		List<ElsecoMemberResult> elsecoMemberResultList = processDao.getClaimMemberResultBySearchCriteria(criteriaEntity);
		List<ElsecoMemberRiskcode> elsecoMemberRiskCodeList = processDao.getClaimMemberRiskCodeBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsParty> elsecoClaimPartyList = processDao.getClaimPartyBySearchCriteria(criteriaEntity);	
		List<ElsecoClaimsPayee> elsecoClaimPayeeList = processDao.getClaimPayeeBySearchCriteria(criteriaEntity);	
		List<ElsecoCheckList> elsecoClaimChecklists = processDao.getClaimChecklistBySearchCriteria(criteriaEntity);	
		List<ElsecoHybrisPayHistory> elsecoHybrisPayHistories = processDao.getHybrisPaymentBySearchCriteria(criteriaEntity);	
				
		JsonHandlerForWorklistAndSaveClaims claimsForJson = new JsonHandlerForWorklistAndSaveClaims();
		BeanUtils.copyProperties(elClmHeader, claimsForJson);

		ArrayList<JsonHandlerForClaimsDetails> newElsecoClaimDetailsList  = new ArrayList<JsonHandlerForClaimsDetails>();				
		ArrayList<ElsecoClaimsTasks> newElsecoClaimTasksList = new ArrayList<ElsecoClaimsTasks>();
										
		for (ElsecoClaimDetails elsecoClaimDetails : elsecoClaimDetailsList) {
			ArrayList<ElsecoMemberInfo> newElsecoMemberInfoList = null;
			ArrayList<ElsecoHybrisPayHistory> newElsecoHybrisPayHistoryList = null;
			if (claimsForJson.getClaimHeaderId() == elsecoClaimDetails.getClaimHeaderId()) {
				JsonHandlerForClaimsDetails claimsDetail = new JsonHandlerForClaimsDetails();
				BeanUtils.copyProperties(elsecoClaimDetails, claimsDetail);
				
				//Adding Claim Items
				ArrayList<ElsecoClaimsItems> newElsecoClaimsItemsList = new ArrayList<ElsecoClaimsItems>();
				for (ElsecoClaimsItems claimItems : elsecoClaimItemsList) {
					if (claimItems.getClaimId() == elsecoClaimDetails.getClaimId()) {	
						
						//Adding Claim Check List in Items
						ArrayList<ElsecoCheckList> newElsecoClaimItemChecklistsList = new ArrayList<ElsecoCheckList>();
						for (ElsecoCheckList elsecoClaimChkList: elsecoClaimChecklists) {
							if (elsecoClaimChkList.getClaimDetailId() == elsecoClaimDetails.getClaimId()
									&& elsecoClaimChkList.getClaimHeaderId() == elsecoClaimDetails.getClaimHeaderId()
										&& elsecoClaimChkList.getClaimItemId() == claimItems.getClaimItemId()
											&& elsecoClaimChkList.getLevel().equalsIgnoreCase("I")) {				
								newElsecoClaimItemChecklistsList.add(elsecoClaimChkList);
							}
						}
						claimItems.setClaimsCheckListInfo(newElsecoClaimItemChecklistsList);						
						newElsecoClaimsItemsList.add(claimItems);
					}
				}
				claimsDetail.setClaimsItemsInfo(newElsecoClaimsItemsList);	
								
				//Adding Claim Files
				ArrayList<ElsecoClaimsFile> newElsecoClaimFilesList  = new ArrayList<ElsecoClaimsFile>();
				for (ElsecoClaimsFile claimsFile : elsecoClaimsFileList) {
					if (claimsFile.getClaimId() == elsecoClaimDetails.getClaimId()) {
						
						//Adding Claim Check List in Items
						ArrayList<ElsecoCheckList> newElsecoClaimFileChecklistsList = new ArrayList<ElsecoCheckList>();
						for (ElsecoCheckList elsecoClaimChkList: elsecoClaimChecklists) {
							if (elsecoClaimChkList.getClaimDetailId() == elsecoClaimDetails.getClaimId()
									&& elsecoClaimChkList.getClaimHeaderId() == elsecoClaimDetails.getClaimHeaderId()
										&& elsecoClaimChkList.getClaimFileId() == claimsFile.getClaimFileId()
												&& elsecoClaimChkList.getLevel().equalsIgnoreCase("F")) {			
								newElsecoClaimFileChecklistsList.add(elsecoClaimChkList);
							}
						}
						claimsFile.setClaimsCheckListInfo(newElsecoClaimFileChecklistsList);					
						newElsecoClaimFilesList.add(claimsFile);
					}
				}
				claimsDetail.setClaimsFileInfo(newElsecoClaimFilesList);	
				
				//Adding Claims Reserve
				ArrayList<ElsecoClaimReserve> newElsecoClaimDetailReserveList = new ArrayList<ElsecoClaimReserve>();
				for (ElsecoClaimReserve elsecoClaimReserve : elsecoClaimsReserveList) {					
					if (claimsForJson.getClaimHeaderId() == elsecoClaimReserve.getClaimHeaderId()
							&& elsecoClaimDetails.getClaimId() == elsecoClaimReserve.getClaimDetId()) {
						newElsecoClaimDetailReserveList.add(elsecoClaimReserve);
					}
				}
				claimsDetail.setClaimReserveInfo(newElsecoClaimDetailReserveList);
				
				//Adding Claim Notes
				ArrayList<ElsecoClaimsNotes> newElsecoClaimDetailNotesList = new ArrayList<ElsecoClaimsNotes>();
				for (ElsecoClaimsNotes elsecoClaimNotes : elsecoClaimsNotesList) {
					if (claimsForJson.getClaimHeaderId() == elsecoClaimNotes.getClaimHeaderId()
							&& elsecoClaimDetails.getClaimId() == elsecoClaimNotes.getClaimDtlId()) {				
						newElsecoClaimDetailNotesList.add(elsecoClaimNotes);
					}
				}
				claimsDetail.setClaimNotesInfo(newElsecoClaimDetailNotesList);
				
				//Adding Claim Check List
				ArrayList<ElsecoCheckList> newElsecoClaimChecklistsList = new ArrayList<ElsecoCheckList>();
				for (ElsecoCheckList elsecoClaimChkList: elsecoClaimChecklists) {
					if (elsecoClaimChkList.getClaimDetailId() == elsecoClaimDetails.getClaimId()
							&& elsecoClaimChkList.getClaimHeaderId() == elsecoClaimDetails.getClaimHeaderId()								
										&& elsecoClaimChkList.getLevel().equalsIgnoreCase("D")) {			
						newElsecoClaimChecklistsList.add(elsecoClaimChkList);
					}
				}
				claimsDetail.setClaimsCheckListInfo(newElsecoClaimChecklistsList);
								
				//Adding Claim Detail Transaction -  used in Policy Transactions TAB
				ArrayList<ElsecoClaimsTransaction> newElsecoClaimsDetailTransactionList  = new ArrayList<ElsecoClaimsTransaction>();
				for (ElsecoClaimsTransaction elsecoClaimTrans : elsecoClaimsTransactionList) {
					if ((claimsForJson.getClaimHeaderId() == elsecoClaimTrans.getClaimHeaderid())
							&& ((elsecoClaimTrans.getClaimid()!=0) && (elsecoClaimDetails.getClaimId() == elsecoClaimTrans.getClaimid()))) {
						
						/**  Claims  Policy  Payee    **/
						ArrayList<ElsecoClaimsPayee> newElsecoClaimsPayeeList  = new ArrayList<ElsecoClaimsPayee>();
						for(ElsecoClaimsPayee payee:elsecoClaimPayeeList) {
							if(payee.getClaimTransactionId()!=0 
									&& (payee.getClaimTransactionId() ==  elsecoClaimTrans.getClaimsTransactionId())
										&& (payee.getClaimId() ==  elsecoClaimTrans.getClaimid())
											&& (payee.getClaimHeaderId() ==  elsecoClaimTrans.getClaimHeaderid())) {
								newElsecoClaimsPayeeList.add(payee);
							}
						}
						elsecoClaimTrans.setClaimsPayeeInfo(newElsecoClaimsPayeeList);
						
						/**  Claims Interenal Reference   **/
						ArrayList<ElsecoClaimsInternalReference> newElsecoClaimsInternalReferenceList  = new ArrayList<ElsecoClaimsInternalReference>();
						for(ElsecoClaimsInternalReference intRef:elsecoClaimsInternalReferenceList) {
							if(intRef.getPolicyTransactionId()!=0 
									&& (intRef.getPolicyTransactionId() ==  elsecoClaimTrans.getClaimsTransactionId())
										&& (intRef.getClaimId() ==  elsecoClaimTrans.getClaimid())) {
								
								//Adding Member Info 
								newElsecoMemberInfoList = new ArrayList<ElsecoMemberInfo>();	
								for (ElsecoMemberInfo elsecoMemberInfo : elsecoMemberInfoList) {
									if (intRef.getClaimHeaderId() == elsecoMemberInfo.getClaimHeaderId()
											&& intRef.getClaimId() == elsecoMemberInfo.getClaimId()
													&& intRef.getIntRefId() == elsecoMemberInfo.getIntRefId()) {			
										
														ArrayList<ElsecoMemberResult> newElsecoMemberResultList = new ArrayList<ElsecoMemberResult>();
														for(ElsecoMemberResult memberResult:elsecoMemberResultList) {
																if(memberResult.getClaimHeaderId() == elsecoMemberInfo.getClaimHeaderId()
																		&& memberResult.getMemberId() == elsecoMemberInfo.getMemberId()
																			&& memberResult.getClaimId() == elsecoMemberInfo.getClaimId()) {
																				//Loop thru  Member Riskcodes
																				for(ElsecoMemberRiskcode riskCode:elsecoMemberRiskCodeList) {
																						if(memberResult.getMemberId() == riskCode.getMemberId()
																								&& memberResult.getResultId() == riskCode.getResultId()
																								 	&& memberResult.getClaimId() ==  riskCode.getClaimId()) {
																									//Adding Member Riskcode 
																									memberResult.setMemberRiskCodeInfo(riskCode);
																									//Temporary added email from appilcation.properties file untill Service sends the actual value
																									//memberResult.setMemberEmail(elsecoClaimsConstant.MEMBER_RESULT_EMAIL);
																						}									
																				}
																				//Adding Member Result 								
																				newElsecoMemberResultList.add(memberResult);								
																}
														}					
										elsecoMemberInfo.setMemberResultsInfo(newElsecoMemberResultList);
										newElsecoMemberInfoList.add(elsecoMemberInfo);						
									}
								}
								intRef.setMemberInfo(newElsecoMemberInfoList);
								
								//Add Hybris Payment History for the List of Members present in that Internal Reference
								newElsecoHybrisPayHistoryList = new ArrayList<ElsecoHybrisPayHistory>();	
								for (ElsecoHybrisPayHistory elsecoHybrisPay : elsecoHybrisPayHistories) {
									if (intRef.getClaimHeaderId() == Integer.valueOf(elsecoHybrisPay.getClaimHeaderId())
											&& intRef.getClaimId() == Integer.valueOf(elsecoHybrisPay.getClaimDetailId())
													&& intRef.getIntRefId() == Integer.valueOf(elsecoHybrisPay.getClaimIntRefId()) ) {	
										newElsecoHybrisPayHistoryList.add(elsecoHybrisPay);
									}
								}
								intRef.setHybrisPayHistoryInfo(newElsecoHybrisPayHistoryList);								
								//Add the final list of internal reference
								newElsecoClaimsInternalReferenceList.add(intRef);								
							}
						}					
						
						elsecoClaimTrans.setClaimsInternalRefInfo(newElsecoClaimsInternalReferenceList);						
						setApprovedAndRejectUrl(elsecoClaimTrans);
						newElsecoClaimsDetailTransactionList.add(elsecoClaimTrans);
					}
				}				
				claimsDetail.setPolicyTransactionsInfo(newElsecoClaimsDetailTransactionList);							
				
				//Added a copy of the internal reference in a claimsDetail section -  as per May 25th discussion with Amitav and Maxim
				ArrayList<ElsecoClaimsInternalReference> newClaimDetailsInternalReferenceList  = new ArrayList<ElsecoClaimsInternalReference>();
				for(ElsecoClaimsInternalReference detailIntRef:elsecoClaimsInternalReferenceList) {
					if(detailIntRef.getClaimId()!=0 && (detailIntRef.getPolicyTransactionId() == 0)
							&& (detailIntRef.getMarketTransactionId() == 0) 
									&& (detailIntRef.getClaimId() ==  claimsDetail.getClaimId())
											&& (detailIntRef.getClaimHeaderId() ==  claimsDetail.getClaimHeaderId())) {
						
						//Adding Member Info 
						newElsecoMemberInfoList = new ArrayList<ElsecoMemberInfo>();	
						for (ElsecoMemberInfo elsecoMemberInfo : elsecoMemberInfoList) {
							if (detailIntRef.getClaimHeaderId() == elsecoMemberInfo.getClaimHeaderId()
								&& detailIntRef.getClaimId() == elsecoMemberInfo.getClaimId()
									&& (elsecoMemberInfo.getPolicyTransactionId() == 0)
										&& (elsecoMemberInfo.getMarketTransactionId() == 0)
											&& detailIntRef.getIntRefId() == elsecoMemberInfo.getIntRefId()) {			
								
												ArrayList<ElsecoMemberResult> newElsecoMemberResultList = new ArrayList<ElsecoMemberResult>();
												for(ElsecoMemberResult memberResult:elsecoMemberResultList) {
														if(memberResult.getClaimHeaderId() == elsecoMemberInfo.getClaimHeaderId()
																&& memberResult.getMemberId() == elsecoMemberInfo.getMemberId()
																	&& memberResult.getClaimId() == elsecoMemberInfo.getClaimId()) {
																		//Loop thru  Member Riskcodes
																		for(ElsecoMemberRiskcode riskCode:elsecoMemberRiskCodeList) {
																				if(memberResult.getMemberId() == riskCode.getMemberId()
																						&& memberResult.getResultId() == riskCode.getResultId()
																						 	&& memberResult.getClaimId() ==  riskCode.getClaimId()) {
																							//Adding Member Riskcode 
																							memberResult.setMemberRiskCodeInfo(riskCode);
																							//Temporary added email from appilcation.properties file untill Service sends the actual value
																							//memberResult.setMemberEmail(elsecoClaimsConstant.MEMBER_RESULT_EMAIL);
																				}									
																		}
																		//Adding Member Result 								
																		newElsecoMemberResultList.add(memberResult);								
														}
												}					
								elsecoMemberInfo.setMemberResultsInfo(newElsecoMemberResultList);
								newElsecoMemberInfoList.add(elsecoMemberInfo);						
							}
						}
						detailIntRef.setMemberInfo(newElsecoMemberInfoList);																					
						//Add the final list of internal reference
						newClaimDetailsInternalReferenceList.add(detailIntRef);								
					}						
				}						
				claimsDetail.setClaimDetailInternalReferenceInfo(newClaimDetailsInternalReferenceList);
				//till here a copy of internal reference
								
				//Add the Complete ClaimDetails List
				newElsecoClaimDetailsList.add(claimsDetail);
			}
		}
		
		//Adding Claim Risk - For Header only
		ArrayList<ElsecoRiskObject> newElsecoClaimRiskList = new ArrayList<ElsecoRiskObject>();	
		for (ElsecoRiskObject elsecoClaimRisk : elsecoRiskObjList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimRisk.getClaimHeaderId()) {
				newElsecoClaimRiskList.add(elsecoClaimRisk);
			}
		}		
		
		//Adding Claim Party
		ArrayList<ElsecoClaimsParty> newElsecoClaimPartyList = new ArrayList<ElsecoClaimsParty>();
		for (ElsecoClaimsParty claimParty : elsecoClaimPartyList) {
			if (claimParty.getClaimHeaderId() == claimsForJson.getClaimHeaderId()) {
				newElsecoClaimPartyList.add(claimParty);
			}
		}			
		
		//Adding Claim Check List
		ArrayList<ElsecoCheckList> newElsecoHeaderChecklistsList = new ArrayList<ElsecoCheckList>();
		for (ElsecoCheckList elsecoClaimChkList: elsecoClaimChecklists) {
			if (elsecoClaimChkList.getClaimHeaderId() == claimsForJson.getClaimHeaderId()	
					&& elsecoClaimChkList.getClaimDetailId() == 0  && elsecoClaimChkList.getClaimFileId() == 0 
						&& elsecoClaimChkList.getClaimItemId() == 0 && elsecoClaimChkList.getLevel().equalsIgnoreCase("H")) {				
				newElsecoHeaderChecklistsList.add(elsecoClaimChkList);
			}
		}
		
		//Adding Claim Header level Notes - For Header only
		ArrayList<ElsecoClaimsNotes> newElsecoClaimHeaderNotesList = new ArrayList<ElsecoClaimsNotes>();
		for (ElsecoClaimsNotes elsecoClaimNotes : elsecoClaimsNotesList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimNotes.getClaimHeaderId()
					&& elsecoClaimNotes.getClaimDtlId() == 0) {				
				newElsecoClaimHeaderNotesList.add(elsecoClaimNotes);
			}
		}
		
		for (ElsecoClaimsTasks elsecoClaimTasks : elsecoClaimsTasksList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimTasks.getClaimHeaderId()) {
				newElsecoClaimTasksList.add(elsecoClaimTasks);
			}
		}
		
		//Adding Claim Detail Transaction -  used in Market Transactions TAB
		ArrayList<ElsecoClaimsTransaction> newElsecoClaimsHeaderTransactionList  = new ArrayList<ElsecoClaimsTransaction>();
		for (ElsecoClaimsTransaction elsecoClaimHTrans : elsecoClaimsTransactionList) {			
			if (claimsForJson.getClaimHeaderId() == elsecoClaimHTrans.getClaimHeaderid()
					&& elsecoClaimHTrans.getClaimid() == 0) {					
				newElsecoClaimsHeaderTransactionList.add(elsecoClaimHTrans);						
			}
		}	
		
		claimsForJson.setMarketTransactionsInfo(newElsecoClaimsHeaderTransactionList);			
		claimsForJson.setClaimDetailsInfo(newElsecoClaimDetailsList);		
		claimsForJson.setClaimRiskInfo(newElsecoClaimRiskList);  
		claimsForJson.setClaimNotesInfo(newElsecoClaimHeaderNotesList);
		claimsForJson.setClaimsCheckListInfo(newElsecoHeaderChecklistsList);
		claimsForJson.setClaimPartyInfo(newElsecoClaimPartyList);
		
		return claimsForJson;
	}
		
	/**
	 * A method to get the ClaimDetails By Search Criteria
	 * 
	 * @param criteriaEntity
	 * @return
	 *//*
	public Object populateClaimBySearchCriterias(CriteriaEntity criteriaEntity) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - populateClaimsBySearchCriteria");

		ElsecoClaimsHeader elClmHeader = processDao.getClaimHeaderById(criteriaEntity);
		List<ElsecoClaimDetails> elsecoClaimDetailsList = processDao.getClaimDetailBySearchCriteria(criteriaEntity);
		List<ElsecoRiskObject> elsecoRiskObjList = processDao.getClaimRiskobjBySearchCriteria(criteriaEntity);
		//List<ElsecoClaimsParticipant> elsecoClaimsParticipantList = new ArrayList<ElsecoClaimsParticipant>();
		List<ElsecoClaimReserve> elsecoClaimsReserveList = processDao.getClaimReserveBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsNotes> elsecoClaimsNotesList = processDao.getClaimNotesBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsTasks> elsecoClaimsTasksList = processDao.getClaimTasksBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsFile> elsecoClaimsFileList = processDao.getClaimFilesBySearchCriteria(criteriaEntity);
		List<ElsecoClaimsItems> elsecoClaimItemsList = processDao.getClaimItemsBySearchCriteria(criteriaEntity);	
						
		JsonHandlerForCompleteClaims claimsForJson = new JsonHandlerForCompleteClaims();
		BeanUtils.copyProperties(elClmHeader, claimsForJson);
		
		List<JsonHandlerForClaimsDetails> newElsecoClaimDetailsList  = new ArrayList<JsonHandlerForClaimsDetails>();
		List<ElsecoClaimReserve> newElsecoClaimReserveList = new ArrayList<ElsecoClaimReserve>();
		List<ElsecoRiskObject> newElsecoClaimRiskList = new ArrayList<ElsecoRiskObject>();
		List<ElsecoClaimsNotes> newElsecoClaimNotesList = new ArrayList<ElsecoClaimsNotes>();
		List<ElsecoClaimsTasks> newElsecoClaimTasksList = new ArrayList<ElsecoClaimsTasks>();
		List<ElsecoClaimsItems> newElsecoClaimsItemsList = new ArrayList<ElsecoClaimsItems>();
		//List<ElsecoClaimsTransaction> claimTransactionList  = new ArrayList<ElsecoClaimsTransaction>();
		List<ElsecoClaimsFile> newElsecoClaimFilesList  = new ArrayList<ElsecoClaimsFile>();
		
		List<ElsecoClaimDetails> claimdetail=elsecoClaimDetailsList.stream()				
				.filter(d -> (claimsForJson.getClaimHeaderId() == d.getClaimHeaderId()))
				.collect(Collectors.toList());
		System.out.println("--------------  CLAIM_DETAIS ARE ----------------" + claimdetail.toString());		
		
		JsonHandlerForClaimsDetails claimsDetails = new JsonHandlerForClaimsDetails();
		BeanUtils.copyProperties(claimdetail, claimsForJson);
		BeanUtils.copyProperties(claimdetail,claimsDetails);
	
		List<Integer> claimid=claimdetail.stream().map(c->c.getClaimId()).collect(Collectors.toList());
		List<ElsecoClaimsItems> items=elsecoClaimItemsList.stream()
				//.filter(e -> details.stream().anyMatch(i -> (i.getClaimId())==(e.getClaimId())))
				.filter(i  ->(claimid.contains(i.getClaimId())) )
			.collect(Collectors.toList());
		
		newElsecoClaimsItemsList.addAll(items);
		claimsDetails.setClaimsItems(newElsecoClaimsItemsList);
		List<ElsecoClaimsFile> file=elsecoClaimsFileList.stream()
				.filter(f  -> (claimid.contains(f.getClaimId())) )
			.collect(Collectors.toList());
		
		newElsecoClaimFilesList.addAll(file);
		claimsDetails.setClaimsFile(newElsecoClaimFilesList);		
		claimsDetails.setClaimNotes(newElsecoClaimNotesList);				
		newElsecoClaimDetailsList.add(claimsDetails);	//Add the Complete ClaimDetails List
		
		List<ElsecoClaimReserve> ClaimReserve=elsecoClaimsReserveList.stream()				
				.filter(r -> (claimsForJson.getClaimHeaderId() == r.getClaimHeaderId()))
				.collect(Collectors.toList());
		newElsecoClaimReserveList.addAll(ClaimReserve);
		claimsDetails.setClaimReserve(newElsecoClaimReserveList);
		
		List<ElsecoRiskObject> ClaimRisk=elsecoRiskObjList.stream()				
				.filter(o -> (claimsForJson.getClaimHeaderId() == o.getClaimHeaderId()))
				.collect(Collectors.toList());
		newElsecoClaimRiskList.addAll(ClaimRisk);
		List<ElsecoClaimsNotes> ClaimNotes=elsecoClaimsNotesList.stream()				
				.filter(n -> (claimsForJson.getClaimHeaderId() == n.getClaimHeaderId()))
				.collect(Collectors.toList());
		     newElsecoClaimNotesList.addAll(ClaimNotes);
		     List<ElsecoClaimsTasks> ClaimTasks=elsecoClaimsTasksList.stream()				
						.filter(t -> (claimsForJson.getClaimHeaderId() == t.getClaimHeaderId()))
						.collect(Collectors.toList());
				newElsecoClaimTasksList.addAll(ClaimTasks);
				claimsForJson.setClaimDetails(newElsecoClaimDetailsList);
				claimsForJson.setClaimReserve(newElsecoClaimReserveList);		
				claimsForJson.setClaimRisk(newElsecoClaimRiskList);  
				// claimsForJson.setClaimTasks(newElsecoClaimTasksList);
				
				return claimsForJson;
		*/		
					
	/*	for (ElsecoClaimDetails elsecoClaimDetails : elsecoClaimDetailsList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimDetails.getClaimHeaderId()) {
				JsonHandlerForClaimsDetails claimsDetail = new JsonHandlerForClaimsDetails();
				BeanUtils.copyProperties(elsecoClaimDetails, claimsDetail);
				
				//Adding Claim Items
				for (ElsecoClaimsItems claimItems : elsecoClaimItemsList) {
					if (claimItems.getClaimId() == elsecoClaimDetails.getClaimId()) {
						newElsecoClaimsItemsList.add(claimItems);
					}
				}
				claimsDetail.setClaimsItems(newElsecoClaimsItemsList);				
				
				//Adding Claim Files
				for (ElsecoClaimsFile claimsFile : elsecoClaimsFileList) {
					if (claimsFile.getClaimId() == elsecoClaimDetails.getClaimId()) {
						newElsecoClaimFilesList.add(claimsFile);
					}
				}
				claimsDetail.setClaimsFile(newElsecoClaimFilesList);	
										
				//claimsDetail.setClaimParticipant(elsecoClaimsParticipantList);
				claimsDetail.setClaimReserve(newElsecoClaimReserveList);
				claimsDetail.setClaimNotes(newElsecoClaimNotesList);
				//claimsDetail.setClaimsTransaction(claimsTransactionList);					
				//Add the Complete ClaimDetails List
				newElsecoClaimDetailsList.add(claimsDetail);
			}
		}
		for (ElsecoClaimReserve elsecoClaimReserve : elsecoClaimsReserveList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimReserve.getClaimHeaderId()) {
				newElsecoClaimReserveList.add(elsecoClaimReserve);
			}
		}		
		for (ElsecoRiskObject elsecoClaimRisk : elsecoRiskObjList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimRisk.getClaimHeaderId()) {
				newElsecoClaimRiskList.add(elsecoClaimRisk);
			}
		}		
		for (ElsecoClaimsNotes elsecoClaimNotes : elsecoClaimsNotesList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimNotes.getClaimHeaderId()) {				
				newElsecoClaimNotesList.add(elsecoClaimNotes);
			}
		}
		for (ElsecoClaimsTasks elsecoClaimTasks : elsecoClaimsTasksList) {
			if (claimsForJson.getClaimHeaderId() == elsecoClaimTasks.getClaimHeaderId()) {
				newElsecoClaimTasksList.add(elsecoClaimTasks);
			}
		}*/
		/*claimsForJson.setClaimDetails(newElsecoClaimDetailsList);
		claimsForJson.setClaimReserve(newElsecoClaimReserveList);		
		claimsForJson.setClaimRisk(newElsecoClaimRiskList);  
		// claimsForJson.setClaimTasks(newElsecoClaimTasksList);

		return claimsForJson;
		*/
	//}


	

	/**
	 * A method to get the ClaimDetails By Search Criteria
	 * Consider this as new Claims search
	 * @param criteriaEntity
	 * @return
	 */
	public Object retrieveClaimsBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - retrieveClaimsBySearchCriteria");
			
		List<JsonHandlerForWorklistAndSaveClaims> clmsHeaderList = processDao.getClaimHeaderBySearchCriteria(criteriaEntity, true);		
		return clmsHeaderList;	
	}
		
	/**
	 * Populate the Complete JSON for the static data
	 * 
	 * @return
	 */
	public Object populateCompleteStaticData()  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - populateCompleteStaticData");
		return populateStaticData(processDao.getCompleteStaticData());
	}
	
	/**
	 * A method to save External References
	 * 
	 * @param newClaims
	 * @param oldClaims
	 * @param auditTrail
	 * @return
	 * @throws Exception
	 */
	@Transactional 
	public int saveExtReference(JsonHandlerForSaveUcrExtRef newClaims) throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - saveExtReference ");
		int headerId = 0;
		long claimDetailId = 0;
		// Claims Details
		Collection<ElsecoClaimDetails> newElsecoClaimDetailList = newClaims.getClaimDetailsInfo();

		if (newElsecoClaimDetailList != null) {
			Set<String> extRefNos = new HashSet<String>();
			for (ElsecoClaimDetails newClaimDetails : newElsecoClaimDetailList) {
				if(newClaimDetails.getClaimId() == 0) {
					if(extRefNos.add(newClaimDetails.getExtRefNo()) == false){
						LOG.info("-------------------     DUPLICATE EXT_REF_NO EXISTS WHILE SAVING THE CLAIMS   ----------------------------"   );
						throw new ElsecoClaimsServiceException("DUPLICATE EXT_REF_NO EXISTS WHILE SAVING THE CLAIMS.", 
								new Throwable("A Claim already exists with the given UMR Number, UCR Number and External Reference No. Please correct them and submit again."));	
					}
					//Verify the given UMR Number, UCR Number and External Reference No in database
					if(isNotValidClaimCombo(newClaims.getUmrNumber(), newClaims.getUcrNumber(), newClaimDetails.getExtRefNo())) {
						LOG.info("-------------------     ALREADY RECORD EXITS WITH SAME UCR, UMR AND EXT_REF_NO   ----------------------------"   );
						throw new ElsecoClaimsServiceException("ALREADY RECORD EXITS WITH SAME UCR, UMR AND EXT_REF_NO", 
								new Throwable("A Claim already exists with the given UMR Number, UCR Number and External Reference No. Please correct them and submit again."));	
					}
				}
				
				for (int i = 1; i <= newElsecoClaimDetailList.size(); i++) {
					if (i <= 9) {
						newClaimDetails.setClaimReferenceNo(newClaimDetails.getExtRefNo() + "-00" + i + "-"+ getShortSectionName(newClaimDetails.getSectionName()));
					} else {
						newClaimDetails.setClaimReferenceNo(newClaimDetails.getExtRefNo() + "-0" + i + "-"+ getShortSectionName(newClaimDetails.getSectionName()));
					}
				}
				if (newClaimDetails.getClaimHeaderId() == 0) {
					// To fetch the headerId from DB based on UCR and UMR numbers
					CriteriaEntity criteriaEntity = new CriteriaEntity();
					criteriaEntity.setUcrNumber(newClaims.getUcrNumber());
					criteriaEntity.setUmrNumber(newClaims.getUmrNumber());

					List<JsonHandlerForWorklistAndSaveClaims> headerList = processDao.getClaimHeaderBySearchCriteria(criteriaEntity, false);
					if (headerList != null)
						headerId = headerList.get(0).getClaimHeaderId();
					
					newClaimDetails.setClaimHeaderId(headerId);

					if (newClaimDetails.getClaimId() == 0) {
						LOG.info("-------------- Insert EL_CLAIM_DETAIL ----------------" + newClaimDetails.toString());
						claimDetailId = entityDao.insertClaimDetail(newClaimDetails);	
												
						//Adding a placeholder for the Checklist for newly created Claim Detail												
						Map<String, Map<String,String>> checklistMap = assignChecklistsForEachLevel(""+headerId, ""+claimDetailId, null, null);
						Map<String,String> mapCheckList = checklistMap.get(elsecoClaimsConstant.CHECKLIST_DETAIL_GRP);						 
						Set<String> desc =  mapCheckList.keySet();						
					
						ElsecoCheckList checkListObj = null;
						for(String checklistDesc:  desc) {
							 checkListObj = new ElsecoCheckList();
							 checkListObj.setCheckListId(0);
							 checkListObj.setClaimHeaderId(headerId);
							 checkListObj.setClaimDetailId(Integer.valueOf(""+claimDetailId));
							 checkListObj.setClaimFileId(0);
							 checkListObj.setClaimItemId(0);
							 checkListObj.setCheckListName(checklistDesc);
							 checkListObj.setCheckListGroup(elsecoClaimsConstant.CHECKLIST_DETAIL_GRP);
							 checkListObj.setIsChecked(mapCheckList.get(checklistDesc));
							 checkListObj.setLevel("D");
							 LOG.info("  ---------------  Insert the CheckList  Items for both Header and Details  ------------------  ");
							 entityDao.insertCheckList(checkListObj);
						 }						
					}
				}
			}
			extRefNos = null;
		}

		return headerId;
	}
	
	/**
	 * Save the complete JSON structure from UI
	 * 
	 * @param newClaims
	 * @param oldClaims
	 * @param auditTrail
	 * @return
	 * @throws Exception
	 */
	@Transactional 
	public int saveClaims(JsonHandlerForWorklistAndSaveClaims newClaims, JsonHandlerForWorklistAndSaveClaims oldClaims, 
																						ElsecoClaimsAuditTrail auditTrail)  {
		try {
			LOG.info("*****	Received a call to ElsecoClaimsHelper - saveClaims ");	
		
			ModelMapper modelMapper = new ModelMapper();
			ElsecoClaimsAuditTrail sAuditTrail = new ElsecoClaimsAuditTrail();
			BeanUtils.copyProperties(auditTrail, sAuditTrail);
			
			//Claims Header
			ElsecoClaimsHeader newClaimsHeader = modelMapper.map(newClaims, ElsecoClaimsHeader.class);
			ElsecoClaimsHeader oldClaimsHeader = modelMapper.map(oldClaims, ElsecoClaimsHeader.class);
			/*if(newClaimsHeader.getClaimHeaderId() == 0 && 
						isNotValidClaim(newClaimsHeader.getUmrNumber(), newClaimsHeader.getUcrNumber())) {
				throw new ElsecoClaimsServiceException("ALREADY RECORD EXITS WITH SAME UCR AND UMR", 
						new Throwable("A Claim already exists with the given UMR Number and UCR Number."));				
			}*/
			
			// Validate the Mandatory fields before saving the claims
			if(newClaimsHeader.getClaimHeaderId() == 0 && isNotValidClaimsInfo(newClaimsHeader)) {
					LOG.info("  ---------------  Cannot proceed with save. Mandatory fields are missing in Claims Header.  ------------------  ");
					throw new ElsecoClaimsServiceException("MANDATORY FIELDS ARE MISSING IN CLAIMS INFORMATION.", 
							new Throwable("Cannot proceed with save. Please enter the mandatory fields."));				
			}
			
			//Validate whether its a Unique combination of UCR-UMR-EXTREFNO
			Collection<JsonHandlerForClaimsDetails> inClaimDetailList = newClaims.getClaimDetailsInfo();
			if (inClaimDetailList != null) {
				Set<String> extRefNos = new HashSet<String>();
				for (JsonHandlerForClaimsDetails newClaimDetails : inClaimDetailList) {	
					if(newClaimDetails.getClaimId() == 0) {
						if(extRefNos.add(newClaimDetails.getExtRefNo()) == false){
							LOG.info("-------------------     DUPLICATE EXT_REF_NO EXISTS WHILE SAVING THE CLAIMS   ----------------------------"   );
							throw new ElsecoClaimsServiceException("DUPLICATE EXT_REF_NO EXISTS WHILE SAVING THE CLAIMS.", 
									new Throwable("A Claim already exists with the given UMR Number, UCR Number and External Reference No. Please correct them and submit again."));	
						}
						//Verify the given UMR Number, UCR Number and External Reference No in database
						if(isNotValidClaimCombo(newClaimsHeader.getUmrNumber(), newClaimsHeader.getUcrNumber(), newClaimDetails.getExtRefNo())) {
							LOG.info("-------------------     ALREADY RECORD EXITS WITH SAME UCR, UMR AND EXT_REF_NO   ----------------------------"   );
							throw new ElsecoClaimsServiceException("ALREADY RECORD EXITS WITH SAME UCR, UMR AND EXT_REF_NO", 
									new Throwable("A Claim already exists with the given UMR Number, UCR Number and External Reference No. Please correct them and submit again."));	
						}
					}
				}
			}
			
			// Validate the Mandatory fields of Transaction before saving the claims
			List<ElsecoClaimsTransaction> newMrktTransactionList = newClaims.getMarketTransactionsInfo();
			if(newMrktTransactionList!=null) {
				for (ElsecoClaimsTransaction newClaimsMrktTrans : newMrktTransactionList) {		
					if(newClaimsMrktTrans.getClaimsTransactionId() == 0 && isNotValidTransInfo(newClaimsMrktTrans)) {
							LOG.info("  ---------------  Cannot proceed with save. Mandatory fields are missing in Transaction.  ------------------  ");
							throw new ElsecoClaimsServiceException("MANDATORY FIELDS ARE MISSING IN TRANSACTION INFORMATION", 
									new Throwable("Cannot proceed with save. Please enter the mandatory fields."));				
					}
				}
			}
			
			//Assign the primary Identity values
			int headerId = saveEntityAndAuditForAnObject(newClaimsHeader, oldClaimsHeader, elsecoClaimsConstant.CLAIM_HEADER, auditTrail);
			int detailId = 0;
			long marketTransId = 0;
			long policyTransId = 0;			
			int intRefId = 0;
			int memberId = 0;
			int resultId = 0;
			int ItemId = 0;		
			int fileId = 0;
			boolean isMarketTransactionCreated = false;
			
			//Claims Header Transactions - Market Transaction
			List<ElsecoClaimsTransaction> newClaimHeaderTransactionList = newClaims.getMarketTransactionsInfo();
			List<ElsecoClaimsTransaction> oldClaimHeaderTransactionList = newClaims.getMarketTransactionsInfo();	
			if(newClaimHeaderTransactionList!=null) {
				for (ElsecoClaimsTransaction newClaimsTrans : newClaimHeaderTransactionList) {					
					if(newClaimsTrans.getClaimHeaderid() == 0) {
						newClaimsTrans.setClaimHeaderid(headerId);
					}
					newClaimsTrans.setClaimid(0);					
					if ((oldClaimHeaderTransactionList!=null && oldClaimHeaderTransactionList.size() > 0) && newClaimsTrans.getClaimsTransactionId() > 0) {
						for (ElsecoClaimsTransaction oldClaimsTrans : oldClaimHeaderTransactionList) {
							if(newClaimsTrans.getClaimsTransactionId()>0 && oldClaimsTrans.getClaimsTransactionId()>0 && 
								(newClaimsTrans.getClaimsTransactionId() == oldClaimsTrans.getClaimsTransactionId())) {
								saveEntityAndAuditForAnObject(newClaimsTrans, oldClaimsTrans, elsecoClaimsConstant.UCR_TRANSACTIONS, auditTrail);
								marketTransId = newClaimsTrans.getClaimsTransactionId();
								LOG.info("-------------- Updated a market transaction with transaction id ----------------"+marketTransId);
							}				
						}
					} else if (newClaimsTrans.getClaimsTransactionId() > 0) {
						throw new Exception("Improper JSON - " + elsecoClaimsConstant.UCR_TRANSACTIONS+ " has elements in ClaimsInfo and not in AuditInfo.");
					} else if (newClaimsTrans.getClaimsTransactionId() == 0) {
						LOG.info("-------------- Insert UCR_TRANSACTIONS ----------------" + newClaimsTrans.toString());						
						marketTransId = entityDao.insertClaimTransaction(newClaimsTrans);
						sAuditTrail.setUniqueId(""+marketTransId);
						saveAuditInfo(new JSONObject(newClaimsTrans).toString(), elsecoClaimsConstant.UCR_TRANSACTIONS, sAuditTrail);	
						isMarketTransactionCreated = true;
						LOG.info("-------------- Inserted a new market transaction with transaction id ----------------"+marketTransId);
					}						
				}
			}
			
			//Claims Details			
			Collection<JsonHandlerForClaimsDetails> newElsecoClaimDetailList = newClaims.getClaimDetailsInfo();
			Collection<JsonHandlerForClaimsDetails> oldElsecoClaimDetailList = oldClaims.getClaimDetailsInfo();
			if(newElsecoClaimDetailList!=null) {
				for (JsonHandlerForClaimsDetails newClaimDetails : newElsecoClaimDetailList) {
					detailId = 0;
					for(int i=1;i<=newElsecoClaimDetailList.size();i++) {			
						if(i<=9) {
							newClaimDetails.setClaimReferenceNo(newClaimDetails.getExtRefNo()+"-00"+i+"-"+getShortSectionName(newClaimDetails.getSectionName()));
						}
						else {
							newClaimDetails.setClaimReferenceNo(newClaimDetails.getExtRefNo()+"-0"+i+"-"+getShortSectionName(newClaimDetails.getSectionName()));
						}					
					}
				
					if(newClaimDetails.getClaimHeaderId() == 0) {
						newClaimDetails.setClaimHeaderId(headerId);
					}
					if ((oldElsecoClaimDetailList!=null && oldElsecoClaimDetailList.size() > 0) &&
							newClaimDetails.getClaimId() > 0) {
						for (JsonHandlerForClaimsDetails oldClaimDetails : oldElsecoClaimDetailList) {
							//Claim Details
							if (newClaimDetails.getClaimId() > 0 && oldClaimDetails.getClaimId() > 0
									&& (newClaimDetails.getClaimId() == oldClaimDetails.getClaimId())) {
									saveEntityAndAuditForAnObject(newClaimDetails, oldClaimDetails, elsecoClaimsConstant.CLAIM_DETAIL, auditTrail);
									detailId = newClaimDetails.getClaimId();
							}					
						}
					}else  if (newClaimDetails.getClaimId() > 0){
						throw new Exception("Improper JSON - "+elsecoClaimsConstant.CLAIM_DETAIL+" has elements in ClaimsInfo and not in AuditInfo.");
					}else if (newClaimDetails.getClaimId() == 0) {
						LOG.info("-------------- Insert EL_CLAIM_DETAIL ----------------" + newClaimDetails.toString());
						ElsecoClaimDetails claimsDetails = new ElsecoClaimDetails();
						BeanUtils.copyProperties(newClaimDetails, claimsDetails);		
						detailId = Integer.valueOf(""+entityDao.insertClaimDetail(claimsDetails));
						sAuditTrail.setUniqueId(""+detailId);
						saveAuditInfo(new JSONObject(newClaimDetails).toString(), elsecoClaimsConstant.CLAIM_DETAIL, sAuditTrail);	
						
						//Adding a placeholder for the Checklist for newly created Claim Detail
						Map<String, Map<String,String>> checklistMap = assignChecklistsForEachLevel(""+headerId, ""+detailId, null, null);
						Map<String,String> mapCheckList = checklistMap.get(elsecoClaimsConstant.CHECKLIST_DETAIL_GRP);						 
						Set<String> desc =  mapCheckList.keySet();						
					
						ElsecoCheckList checkListObj = null;
						for(String checklistDesc:  desc) {
							 checkListObj = new ElsecoCheckList();
							 checkListObj.setCheckListId(0);
							 checkListObj.setClaimHeaderId(headerId);
							 checkListObj.setClaimDetailId(detailId);
							 checkListObj.setClaimFileId(0);
							 checkListObj.setClaimItemId(0);
							 checkListObj.setCheckListName(checklistDesc);
							 checkListObj.setCheckListGroup(elsecoClaimsConstant.CHECKLIST_DETAIL_GRP);
							 checkListObj.setIsChecked(mapCheckList.get(checklistDesc));
							 checkListObj.setLevel("D");
							 entityDao.insertCheckList(checkListObj);
						 }
					}
				
				
				if(isMarketTransactionCreated){
					LOG.info("===============about to create  policy trannsactions   ====== ");
					List<ElsecoClaimsTransaction> newClaimTransactionList = newClaimHeaderTransactionList;
					for(ElsecoClaimsTransaction trans: newClaimTransactionList) {
																		
						if(trans.getClaimsTransactionId() == 0) {														
							BigDecimal lineSizeVl = BigDecimal.ONE;
							BigDecimal marketSettlementAmtIndemnity = BigDecimal.ZERO;
							BigDecimal marketSettlementAmtFees = BigDecimal.ZERO;
							BigDecimal marketSettlementAmtExpenses = BigDecimal.ZERO;
							BigDecimal marketReserveAmtIndemnity = BigDecimal.ZERO;
							BigDecimal marketReserveAmtFees = BigDecimal.ZERO;
							BigDecimal marketReserveAmtExpenses = BigDecimal.ZERO;
							BigDecimal marketPrepaidAmtIndemnity = BigDecimal.ZERO;
							BigDecimal marketPrepaidAmtFees = BigDecimal.ZERO;
							BigDecimal marketPrepaidAmtExpenses = BigDecimal.ZERO;							
							BigDecimal incurredAmt = BigDecimal.ZERO;
							
							if(newClaimDetails.getLineSizeVl()!=null && !newClaimDetails.getLineSizeVl().equals("")) {
								lineSizeVl = new BigDecimal(newClaimDetails.getLineSizeVl());								
							}							
							//settlement
							if(trans.getSettlementAmtIndemnityTR()!=null && (!("").equals(trans.getSettlementAmtIndemnityTR().toString()))) {
								marketSettlementAmtIndemnity = trans.getSettlementAmtIndemnityTR();	
							}							
							if(trans.getSettlementAmtFeesTR()!=null && (!("").equals(trans.getSettlementAmtFeesTR().toString()))) {
								marketSettlementAmtFees = trans.getSettlementAmtFeesTR();
							}						
							if(trans.getSettlementAmtExpensesTR()!=null && (!("").equals(trans.getSettlementAmtExpensesTR().toString()))) {
								marketSettlementAmtExpenses = trans.getSettlementAmtExpensesTR();
							}
														
							//reserve
							if(trans.getReserveAmountIndemnityTR()!=null && (!("").equals(trans.getReserveAmountIndemnityTR().toString()))) {
								marketReserveAmtIndemnity = trans.getReserveAmountIndemnityTR();	
							}														
							if(trans.getReserveAmountFeesTR()!=null && (!("").equals(trans.getReserveAmountFeesTR().toString()))) {
								marketReserveAmtFees = trans.getReserveAmountFeesTR();
							}
							if(trans.getReserveAmountExpensesTR()!=null && (!("").equals(trans.getReserveAmountExpensesTR().toString()))) {
								marketReserveAmtExpenses = trans.getReserveAmountExpensesTR();
							}
														
							//preapid
							if(trans.getPrevpaidAmtIndemnityTR()!=null && (!("").equals(trans.getPrevpaidAmtIndemnityTR().toString()))) {
								marketPrepaidAmtIndemnity = trans.getPrevpaidAmtIndemnityTR();	
							}							
							if(trans.getPrevpaidAmtFeesTR()!=null && (!("").equals(trans.getPrevpaidAmtFeesTR().toString()))) {
								marketPrepaidAmtFees = trans.getPrevpaidAmtFeesTR();
							}							
							if(trans.getPrevpaidAmtExpensesTR()!=null && (!("").equals(trans.getPrevpaidAmtExpensesTR().toString()))) {
								marketPrepaidAmtExpenses = trans.getPrevpaidAmtExpensesTR();
							}
														
							if(trans.getNwincurdclamt()!=null && (!("").equals(trans.getNwincurdclamt().toString()))) {
								incurredAmt = trans.getNwincurdclamt();
							}
							
							
							//settlement
							trans.setSettlementAmtIndemnityTR(marketSettlementAmtIndemnity.multiply((lineSizeVl.divide(new BigDecimal("100")))));								
							trans.setSettlementAmtFeesTR(marketSettlementAmtFees.multiply((lineSizeVl.divide(new BigDecimal("100")))));									
							trans.setSettlementAmtExpensesTR(marketSettlementAmtExpenses.multiply((lineSizeVl.divide(new BigDecimal("100")))));
								
							//reserve
							trans.setReserveAmountIndemnityTR(marketReserveAmtIndemnity.multiply((lineSizeVl.divide(new BigDecimal("100")))));									
							trans.setReserveAmountFeesTR(marketReserveAmtFees.multiply((lineSizeVl.divide(new BigDecimal("100")))));									
							trans.setReserveAmountExpensesTR(marketReserveAmtExpenses.multiply((lineSizeVl.divide(new BigDecimal("100")))));
								
							//prepaid
							trans.setPrevpaidAmtIndemnityTR(marketPrepaidAmtIndemnity.multiply((lineSizeVl.divide(new BigDecimal("100")))));								
							trans.setPrevpaidAmtFeesTR(marketPrepaidAmtFees.multiply((lineSizeVl.divide(new BigDecimal("100")))));									
							trans.setPrevpaidAmtExpensesTR(marketPrepaidAmtExpenses.multiply((lineSizeVl.divide(new BigDecimal("100")))));
								
							//incurred amt
							trans.setNwincurdclamt(incurredAmt.multiply((lineSizeVl.divide(new BigDecimal("100")))));
							
							trans.setSplitClaimPercVl(""+lineSizeVl);	
							//Default to 'C'
							trans.setApproveEnabled((trans.getApproveEnabled()==null ||  trans.getApproveEnabled().equals(""))?"C":trans.getApproveEnabled());
							//Default to 'Waiting for Approval'
							trans.setInternalStatus((trans.getInternalStatus()==null ||  trans.getInternalStatus().equals(""))?"Waiting for Approval":trans.getInternalStatus());
							
							//If Transaction Type is Payment Request, Final Payment, A Subrogation, A Salvage
							if(trans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_PAYMNT_REQUEST)
									|| trans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_FINAL_PAYMENT)
										|| trans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_SOBGRATION)
											|| trans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_SALVAGE)
												|| trans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_SOBGRATION_TEX)) {
								trans.setReserveAmountIndemnityTR(entityDao.returnValidAmount(trans.getReserveAmountIndemnityTR()) );									
								trans.setReserveAmountFeesTR(entityDao.returnValidAmount(trans.getReserveAmountFeesTR()) );									
								trans.setReserveAmountExpensesTR(entityDao.returnValidAmount(trans.getReserveAmountExpensesTR()) );									
							}							
							
							trans.setClaimsTransactionId(0);
							if(newClaimDetails.getClaimId() == 0) {
								trans.setClaimid(detailId);
							}else {
								trans.setClaimid(newClaimDetails.getClaimId());
							}							
							if(newClaimDetails.getClaimHeaderId() == 0) {
								trans.setClaimHeaderid(headerId);
							}else {
								trans.setClaimHeaderid(newClaimDetails.getClaimHeaderId());
							}					
							
							//Have a same Copy as Market Transaction into Policy Transaction when the Claim Detail is Created for the first Time
							if (trans.getClaimsTransactionId() == 0) {
								LOG.info("-------------- Insert EXTREF_TRANSACTIONS ----------------"+ trans.toString());
								policyTransId = Integer.valueOf(""+entityDao.insertClaimTransaction(trans));
								sAuditTrail.setUniqueId(""+policyTransId);
								saveAuditInfo(new JSONObject(trans).toString(), elsecoClaimsConstant.EXTREF_TRANSACTIONS, sAuditTrail);
								LOG.info("-------------- Inserted a new policy transaction with transaction id ----------------"+policyTransId);
							}
						}
					}
				}
			  }			
			}
			//Claims Details			
			Collection<JsonHandlerForClaimsDetails> newClaimDetailList = newClaims.getClaimDetailsInfo();
			Collection<JsonHandlerForClaimsDetails> oldClaimDetailList = oldClaims.getClaimDetailsInfo();			
			for (JsonHandlerForClaimsDetails newClaimDetails : newClaimDetailList) {
				if (oldElsecoClaimDetailList!=null && oldElsecoClaimDetailList.size() > 0) {
					for (JsonHandlerForClaimsDetails oldClaimDetails : oldClaimDetailList) {
						if(newClaimDetails.getClaimId() == oldClaimDetails.getClaimId()) {
							
						//Claims Reserve
						List<ElsecoClaimReserve> newClaimReserveList = newClaimDetails.getClaimReserveInfo();			
						List<ElsecoClaimReserve> oldClaimReserveList = oldClaimDetails.getClaimReserveInfo();			
						for (ElsecoClaimReserve newClaimReserve : newClaimReserveList) {
							if(newClaimReserve.getClaimHeaderId() == 0) {
								newClaimReserve.setClaimHeaderId(headerId);
							}
							if(newClaimReserve.getClaimDetId() == 0) {
								if(newClaimDetails.getClaimId() == 0) {
									newClaimReserve.setClaimDetId(detailId);
								}else {
									newClaimReserve.setClaimDetId(newClaimDetails.getClaimId());
								}			
							}
							if ((oldClaimReserveList!=null && oldClaimReserveList.size() > 0) && newClaimReserve.getClaimReserveId() > 0) {
								for (ElsecoClaimReserve oldClaimReserve : oldClaimReserveList) {
									if ((newClaimReserve.getClaimReserveId() > 0 && oldClaimReserve.getClaimReserveId() > 0)
											&& (newClaimReserve.getClaimReserveId() == oldClaimReserve.getClaimReserveId())) {
										saveEntityAndAuditForAnObject(newClaimReserve, oldClaimReserve,	elsecoClaimsConstant.CLAIM_RESERVE, auditTrail);																		
									} 
								}
							} else if (newClaimReserve.getClaimReserveId() > 0) {
								throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_RESERVE + " has elements in ClaimsInfo and not in AuditInfo.");
							} else if (newClaimReserve.getClaimReserveId() == 0) {
								LOG.info("-------------- Insert CLAIM_RESERVE ----------------" + newClaimReserve.toString());
								sAuditTrail.setUniqueId(""+entityDao.insertClaimReserve(newClaimReserve));
								newClaimReserve.setClaimReserveId(Integer.valueOf(sAuditTrail.getUniqueId()));
								saveAuditInfo(new JSONObject(newClaimReserve).toString(), elsecoClaimsConstant.CLAIM_RESERVE, sAuditTrail);	
							}
						}
						
						//Claims Items
						List<ElsecoClaimsItems> newClaimItemsList = newClaimDetails.getClaimsItemsInfo();			
						List<ElsecoClaimsItems> oldClaimItemsList = oldClaimDetails.getClaimsItemsInfo();			
						for (ElsecoClaimsItems newClaimItems : newClaimItemsList) {
							ItemId = 0;
							if(newClaimItems.getClaimId() == 0) {
								if(newClaimDetails.getClaimId() == 0) {
									newClaimItems.setClaimId(detailId);
								}else {
									newClaimItems.setClaimId(newClaimDetails.getClaimId());
								}
							}							
							if(newClaimItems.getClaimHeaderId() == 0) {
								if(newClaimDetails.getClaimHeaderId() == 0) {
									newClaimItems.setClaimHeaderId(headerId);
								}else {
									newClaimItems.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
								}
							}							
							if ((oldClaimItemsList!=null &&  oldClaimItemsList.size() > 0) && newClaimItems.getClaimItemId()>0 ){
								for (ElsecoClaimsItems oldClaimItems : oldClaimItemsList) {
									if (newClaimItems.getClaimItemId() > 0 && oldClaimItems.getClaimItemId() > 0
											&& (newClaimItems.getClaimItemId() == oldClaimItems.getClaimItemId())) {
										saveEntityAndAuditForAnObject(newClaimItems, oldClaimItems, elsecoClaimsConstant.CLAIM_ITEMS, auditTrail);
										ItemId = newClaimItems.getClaimItemId();
									} 
								}
							} else if (newClaimItems.getClaimItemId() > 0) {
								throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_ITEMS + " has elements in ClaimsInfo and not in AuditInfo.");
							} else if (newClaimItems.getClaimItemId() == 0) {
								LOG.info("-------------- Insert CLAIM_ITEMS ----------------" + newClaimItems.toString());
								ItemId = (int) entityDao.insertClaimItem(newClaimItems);
								sAuditTrail.setUniqueId(""+ItemId);
								saveAuditInfo(new JSONObject(newClaimItems).toString(), elsecoClaimsConstant.CLAIM_ITEMS, sAuditTrail);	
								
								//Adding a placeholder for the Checklist for newly created Claim Detail
								Map<String, Map<String,String>> checklistMap = assignChecklistsForEachLevel(""+headerId, ""+detailId, ""+ItemId, null);
								Map<String,String> mapCheckList = checklistMap.get(elsecoClaimsConstant.CHECKLIST_ITEM_GRP);						 
								Set<String> desc =  mapCheckList.keySet();						
							
								ElsecoCheckList checkListObj = null;
								for(String checklistDesc:  desc) {
									 checkListObj = new ElsecoCheckList();
									 checkListObj.setCheckListId(0);
									 checkListObj.setClaimHeaderId(headerId);
									 checkListObj.setClaimDetailId(detailId);
									 checkListObj.setClaimFileId(0);
									 checkListObj.setClaimItemId(ItemId);
									 checkListObj.setCheckListName(checklistDesc);
									 checkListObj.setCheckListGroup(elsecoClaimsConstant.CHECKLIST_ITEM_GRP);
									 checkListObj.setIsChecked(mapCheckList.get(checklistDesc));
									 checkListObj.setLevel("I");
									 entityDao.insertCheckList(checkListObj);
								 }
							}
						}
						
						//Claims Items -  Claims Check List							
						if (newClaimItemsList != null) {
							for (ElsecoClaimsItems newClaimItems : newClaimItemsList) {
								if ((oldClaimItemsList != null && oldClaimItemsList.size() > 0)
										&& newClaimItems.getClaimItemId() > 0) {
									for (ElsecoClaimsItems oldClaimItems : oldClaimItemsList) {
										if (newClaimItems.getClaimItemId() > 0 && oldClaimItems.getClaimItemId() > 0
												&& (newClaimItems.getClaimItemId() == oldClaimItems.getClaimItemId())) {
											
											//Claims Check List
											List<ElsecoCheckList> newHeaderClaimChklistList = newClaimItems.getClaimsCheckListInfo();
											List<ElsecoCheckList> oldHeaderClaimChklistList = oldClaimItems.getClaimsCheckListInfo();
											if(newHeaderClaimChklistList!=null) {
												for (ElsecoCheckList newClaimsChklist : newHeaderClaimChklistList) {				
													if(newClaimsChklist.getClaimDetailId() == 0) {
														if(newClaimItems.getClaimId() == 0) {
															newClaimsChklist.setClaimDetailId(detailId);
														}else {
															newClaimsChklist.setClaimDetailId(newClaimItems.getClaimId());
														}
													}							
													if(newClaimsChklist.getClaimHeaderId() == 0) {
														if(newClaimItems.getClaimHeaderId() == 0) {
															newClaimsChklist.setClaimHeaderId(headerId);
														}else {
															newClaimsChklist.setClaimHeaderId(newClaimItems.getClaimHeaderId());
														}
													}	
													if(newClaimsChklist.getClaimItemId() == 0) {
														if(newClaimItems.getClaimItemId() == 0) {
															newClaimsChklist.setClaimItemId(ItemId);
														}else {
															newClaimsChklist.setClaimItemId(newClaimItems.getClaimItemId());
														}
													}	
													newClaimsChklist.setClaimFileId(0);
													if ((oldHeaderClaimChklistList!=null && oldHeaderClaimChklistList.size() > 0) && newClaimsChklist.getCheckListId() > 0){
														for (ElsecoCheckList oldClaimsChklist : oldHeaderClaimChklistList) {
															if(newClaimsChklist.getCheckListId()>0 && oldClaimsChklist.getCheckListId()>0 && 
																	(newClaimsChklist.getCheckListId() == oldClaimsChklist.getCheckListId())
																	&& newClaimsChklist.getLevel().equalsIgnoreCase("I") ) {
																saveEntityAndAuditForAnObject(newClaimsChklist, oldClaimsChklist, elsecoClaimsConstant.CLAIM_CHECK_LIST, auditTrail);
															} 				
														}
													} else if (newClaimsChklist.getCheckListId() > 0) {
														throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_CHECK_LIST+ " has elements in ClaimsInfo and not in AuditInfo.");
													} else if ((newClaimsChklist.getCheckListId() == 0)  && newClaimsChklist.getLevel().equalsIgnoreCase("I")) {
														LOG.info("-------------- Insert CLAIM_CHECK_LIST FOR ITEM LEVEL----------------" + newClaimsChklist.toString());
														sAuditTrail.setUniqueId(""+entityDao.insertCheckList(newClaimsChklist));
														saveAuditInfo(new JSONObject(newClaimsChklist).toString(), elsecoClaimsConstant.CLAIM_CHECK_LIST, sAuditTrail);											
													}
												}
											}
										}
									}
								}
							}
						}
												
						//Claims Check List -  update of a Claim Detail
						List<ElsecoCheckList> newDetailClaimChklistList = newClaimDetails.getClaimsCheckListInfo();
						List<ElsecoCheckList> oldDetailClaimChklistList = newClaimDetails.getClaimsCheckListInfo();
						if(newDetailClaimChklistList!=null) {
							for (ElsecoCheckList newClaimsChklist : newDetailClaimChklistList) {				
								if(newClaimsChklist.getClaimDetailId() == 0) {
									if(newClaimDetails.getClaimId() == 0) {
										newClaimsChklist.setClaimDetailId(detailId);
									}else {
										newClaimsChklist.setClaimDetailId(newClaimDetails.getClaimId());
									}
								}							
								if(newClaimsChklist.getClaimHeaderId() == 0) {
									if(newClaimDetails.getClaimHeaderId() == 0) {
										newClaimsChklist.setClaimHeaderId(headerId);
									}else {
										newClaimsChklist.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
									}
								}	
								newClaimsChklist.setClaimFileId(0);									
								newClaimsChklist.setClaimItemId(0);
								if ((oldDetailClaimChklistList!=null && oldDetailClaimChklistList.size() > 0) && newClaimsChklist.getCheckListId() > 0){
									for (ElsecoCheckList oldClaimsChklist : oldDetailClaimChklistList) {
										if(newClaimsChklist.getCheckListId()>0 && oldClaimsChklist.getCheckListId()>0 && 
												(newClaimsChklist.getCheckListId() == oldClaimsChklist.getCheckListId())
												&& newClaimsChklist.getLevel().equalsIgnoreCase("D") ) {
											saveEntityAndAuditForAnObject(newClaimsChklist, oldClaimsChklist, elsecoClaimsConstant.CLAIM_CHECK_LIST, auditTrail);
										} 				
									}
								} else if (newClaimsChklist.getCheckListId() > 0) {
									throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_CHECK_LIST+ " has elements in ClaimsInfo and not in AuditInfo.");
								} else if ((newClaimsChklist.getCheckListId() == 0)  && newClaimsChklist.getLevel().equalsIgnoreCase("D")) {
									LOG.info("-------------- Insert CLAIM_CHECK_LIST FOR DETAIL LEVEL----------------" + newClaimsChklist.toString());
									sAuditTrail.setUniqueId(""+entityDao.insertCheckList(newClaimsChklist));
									saveAuditInfo(new JSONObject(newClaimsChklist).toString(), elsecoClaimsConstant.CLAIM_CHECK_LIST, sAuditTrail);	
								}
							}
						}
						
						//Claims Detail Notes
						List<ElsecoClaimsNotes> newElsecoClaimNotesList = newClaimDetails.getClaimNotesInfo();
						List<ElsecoClaimsNotes> oldElsecoClaimNotesList = oldClaimDetails.getClaimNotesInfo();	
						for (ElsecoClaimsNotes newClaimsNotes : newElsecoClaimNotesList) {							
							if(newClaimsNotes.getClaimDtlId() == 0) {
								if(newClaimDetails.getClaimId() == 0) {
									newClaimsNotes.setClaimDtlId(detailId);
								}else {
									newClaimsNotes.setClaimDtlId(newClaimDetails.getClaimId());
								}
							}													
							if(newClaimsNotes.getClaimHeaderId() == 0) {
								if(newClaimDetails.getClaimHeaderId() == 0) {
									newClaimsNotes.setClaimHeaderId(headerId);
								}else {
									newClaimsNotes.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
								}
							}						
							if(newClaimsNotes.getClaimItemId() == 0) {
								newClaimsNotes.setClaimItemId(ItemId);
							}
							if ((oldElsecoClaimNotesList!=null && oldElsecoClaimNotesList.size() > 0) && newClaimsNotes.getClaimNotesId() > 0){
								for (ElsecoClaimsNotes oldClaimsNotes : oldElsecoClaimNotesList) {
									if(newClaimsNotes.getClaimNotesId()>0 && oldClaimsNotes.getClaimNotesId()>0 && 
											(newClaimsNotes.getClaimNotesId() == oldClaimsNotes.getClaimNotesId())) {
										saveEntityAndAuditForAnObject(newClaimsNotes, oldClaimsNotes, elsecoClaimsConstant.EXTREF_NOTES, auditTrail);
									} 				
								}
							} else if (newClaimsNotes.getClaimNotesId() > 0) {
								throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_NOTES+ " has elements in ClaimsInfo and not in AuditInfo.");
							} else if (newClaimsNotes.getClaimNotesId() == 0) {
								LOG.info("-------------- Insert EXTREF_NOTES ----------------" + newClaimsNotes.toString());
								sAuditTrail.setUniqueId(""+entityDao.insertClaimNotes(newClaimsNotes));
								saveAuditInfo(new JSONObject(newClaimsNotes).toString(), elsecoClaimsConstant.EXTREF_NOTES, sAuditTrail);	
							}
						}
						
						//Claims Detail - Policy Transactions - update
						List<ElsecoClaimsTransaction> newClaimTransactionList = newClaimDetails.getPolicyTransactionsInfo();
						List<ElsecoClaimsTransaction> oldClaimTransactionList = oldClaimDetails.getPolicyTransactionsInfo();	
						if(newClaimTransactionList!=null) {
							for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {								
								if(newClaimsTrans.getClaimid() == 0) {
									if(newClaimDetails.getClaimId() == 0) {
										newClaimsTrans.setClaimid(detailId);
									}else {
										newClaimsTrans.setClaimid(newClaimDetails.getClaimId());
									}									
								}
								if(newClaimsTrans.getClaimHeaderid() == 0) {
									if(newClaimDetails.getClaimHeaderId() == 0) {
										newClaimsTrans.setClaimHeaderid(headerId);
									}else {
										newClaimsTrans.setClaimHeaderid(newClaimDetails.getClaimHeaderId());
									}
								}	
								if ((oldClaimTransactionList!=null && oldClaimTransactionList.size() > 0) && newClaimsTrans.getClaimsTransactionId() > 0) {
									for (ElsecoClaimsTransaction oldClaimsTrans : oldClaimTransactionList) {
										if(newClaimsTrans.getClaimsTransactionId()>0 && oldClaimsTrans.getClaimsTransactionId()>0 && 
											(newClaimsTrans.getClaimsTransactionId() == oldClaimsTrans.getClaimsTransactionId())) {
											saveEntityAndAuditForAnObject(newClaimsTrans, oldClaimsTrans, elsecoClaimsConstant.EXTREF_TRANSACTIONS, auditTrail);
											policyTransId = newClaimsTrans.getClaimsTransactionId();
											LOG.info("-------------- Updated a policy transaction at detail level with transaction id ----------------"+policyTransId);
										}				
									}
								} else if (newClaimsTrans.getClaimsTransactionId() > 0) {
									throw new Exception("Improper JSON - " + elsecoClaimsConstant.EXTREF_TRANSACTIONS+ " has elements in ClaimsInfo and not in AuditInfo.");
								} else if (newClaimsTrans.getClaimsTransactionId() == 0) {
									LOG.info("-------------- Insert CLAIM_TRANSACTIONS ----------------" + newClaimsTrans.toString());
									policyTransId = Integer.valueOf(""+entityDao.insertClaimTransaction(newClaimsTrans));
									sAuditTrail.setUniqueId(""+policyTransId);
									saveAuditInfo(new JSONObject(newClaimsTrans).toString(), elsecoClaimsConstant.EXTREF_TRANSACTIONS, sAuditTrail);	
									LOG.info("-------------- Inserted a new policy transaction at detail level with transaction id ----------------"+policyTransId);
								}
								
							}
						}
						
						//Claim Detail - Policy Transaction - Policy Payee
						if(newClaimTransactionList!=null) {
							for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {								
								if ((oldClaimTransactionList!=null && oldClaimTransactionList.size() > 0) && newClaimsTrans.getClaimsTransactionId() > 0) {
									for (ElsecoClaimsTransaction oldClaimsTrans : oldClaimTransactionList) {
										if(newClaimsTrans.getClaimsTransactionId()>0 && oldClaimsTrans.getClaimsTransactionId()>0 && 
											(newClaimsTrans.getClaimsTransactionId() == oldClaimsTrans.getClaimsTransactionId())) {
																														
											//Claims Payee
											List<ElsecoClaimsPayee> newPayeeList = newClaimsTrans.getClaimsPayeeInfo();
											List<ElsecoClaimsPayee> oldPayeeList = oldClaimsTrans.getClaimsPayeeInfo();
											if(newPayeeList!=null) {
												for (ElsecoClaimsPayee newClaimsPayee : newPayeeList) {
													if(newClaimsPayee.getClaimId() == 0) {									
														if(newClaimsTrans.getClaimid() == 0) {
															newClaimsPayee.setClaimId(detailId);
														}else {
															newClaimsPayee.setClaimId(newClaimsTrans.getClaimid());
														}
													}
													if(newClaimsPayee.getClaimHeaderId() == 0) {
														if(newClaimsTrans.getClaimHeaderid() == 0) {
															newClaimsPayee.setClaimHeaderId(headerId);
														}else {
															newClaimsPayee.setClaimHeaderId(newClaimsTrans.getClaimHeaderid());
														}													
													}													
													if(newClaimsPayee.getClaimTransactionId() == 0) {
														if(newClaimsTrans.getClaimsTransactionId() == 0) {
															newClaimsPayee.setClaimTransactionId(Integer.valueOf(""+policyTransId));
														}else {
															newClaimsPayee.setClaimTransactionId(newClaimsTrans.getClaimsTransactionId());
														}													
													}													
													if ((oldPayeeList!=null && oldPayeeList.size() > 0) && newClaimsPayee.getPayeeId() > 0){
														for (ElsecoClaimsPayee oldClaimsPayee : oldPayeeList) {
															if(newClaimsPayee.getPayeeId()>0 && oldClaimsPayee.getPayeeId()>0 && 
																(newClaimsPayee.getPayeeId() == oldClaimsPayee.getPayeeId())) {
																saveEntityAndAuditForAnObject(newClaimsPayee, oldClaimsPayee, elsecoClaimsConstant.CLAIM_POLICY_PAYEE, auditTrail);
																intRefId = newClaimsPayee.getPayeeId();
															}					
														}
													} else if (newClaimsPayee.getPayeeId() > 0) {
														throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_POLICY_PAYEE+ " has elements in ClaimsInfo and not in AuditInfo.");
													} else if (newClaimsPayee.getPayeeId() == 0) {
														LOG.info("-------------- Insert  POLICY TRANS LEVEL CLAIM_POLICY_PAYEE ----------------" + newClaimsPayee.toString());														
														sAuditTrail.setUniqueId(""+entityDao.insertClaimsPolicyPayee(newClaimsPayee));
														saveAuditInfo(new JSONObject(newClaimsPayee).toString(), elsecoClaimsConstant.CLAIM_POLICY_PAYEE, sAuditTrail);														
													}
												}
											}										
										}				
									}
								} 
							}
						}
						
						//Claim Detail - Policy Transaction - Internal Reference
						if(newClaimTransactionList!=null) {
							for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {								
								if ((oldClaimTransactionList!=null && oldClaimTransactionList.size() > 0) && newClaimsTrans.getClaimsTransactionId() > 0) {
									for (ElsecoClaimsTransaction oldClaimsTrans : oldClaimTransactionList) {
										if(newClaimsTrans.getClaimsTransactionId()>0 && oldClaimsTrans.getClaimsTransactionId()>0 && 
											(newClaimsTrans.getClaimsTransactionId() == oldClaimsTrans.getClaimsTransactionId())) {
																														
											//Claims Internal Reference
											List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
											List<ElsecoClaimsInternalReference> oldIntRefList = oldClaimsTrans.getClaimsInternalRefInfo();
											if(newIntRefList!=null) {
												for (ElsecoClaimsInternalReference newClaimsIntRef : newIntRefList) {
													if(newClaimsIntRef.getClaimId() == 0) {									
														if(newClaimDetails.getClaimId() == 0) {
															newClaimsIntRef.setClaimId(detailId);
														}else {
															newClaimsIntRef.setClaimId(newClaimDetails.getClaimId());
														}
													}
													if(newClaimsIntRef.getClaimHeaderId() == 0) {
														if(newClaimDetails.getClaimHeaderId() == 0) {
															newClaimsIntRef.setClaimHeaderId(headerId);
														}else {
															newClaimsIntRef.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
														}													
													}
													
													if(newClaimsIntRef.getPolicyTransactionId() == 0) {
														if(newClaimsTrans.getClaimsTransactionId() == 0) {
															newClaimsIntRef.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
														}else {
															newClaimsIntRef.setPolicyTransactionId(newClaimsTrans.getClaimsTransactionId());
														}													
													}													
													if(newClaimsIntRef.getMarketTransactionId() == 0) {
														newClaimsIntRef.setMarketTransactionId(Integer.valueOf(""+marketTransId));
													}
													if ((oldIntRefList!=null && oldIntRefList.size() > 0) && newClaimsIntRef.getIntRefId() > 0){
														for (ElsecoClaimsInternalReference oldClaimsIntRef : oldIntRefList) {
															if(newClaimsIntRef.getIntRefId()>0 && oldClaimsIntRef.getIntRefId()>0 && 
																(newClaimsIntRef.getIntRefId() == oldClaimsIntRef.getIntRefId())) {
																saveEntityAndAuditForAnObject(newClaimsIntRef, oldClaimsIntRef, elsecoClaimsConstant.CLAIM_INTERNAL_REF, auditTrail);
																intRefId = newClaimsIntRef.getIntRefId();
															}					
														}
													} else if (newClaimsIntRef.getIntRefId() > 0) {
														throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_INTERNAL_REF+ " has elements in ClaimsInfo and not in AuditInfo.");
													} else if (newClaimsIntRef.getIntRefId() == 0) {
														LOG.info("-------------- Insert  TRANS LEVEL CLAIM_INTERNAL_REF ----------------" + newClaimsIntRef.toString());
														intRefId = Integer.valueOf(""+entityDao.insertClaimsInternalReference(newClaimsIntRef));
														sAuditTrail.setUniqueId(""+intRefId);
														saveAuditInfo(new JSONObject(newClaimsIntRef).toString(), elsecoClaimsConstant.CLAIM_INTERNAL_REF, sAuditTrail);														
													}
												}
											}										
										}				
									}
								} 
							}
						}
						
						//Claim Detail - Policy Transaction - Internal Reference - MemberInfo
						if(newClaimTransactionList!=null) {
							for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {								
								if ((oldClaimTransactionList!=null && oldClaimTransactionList.size() > 0) && newClaimsTrans.getClaimsTransactionId() > 0) {
									for (ElsecoClaimsTransaction oldClaimsTrans : oldClaimTransactionList) {
										if(newClaimsTrans.getClaimsTransactionId()>0 && oldClaimsTrans.getClaimsTransactionId()>0 && 
											(newClaimsTrans.getClaimsTransactionId() == oldClaimsTrans.getClaimsTransactionId())) {
																														
											//Claims Internal Reference
											List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
											List<ElsecoClaimsInternalReference> oldIntRefList = oldClaimsTrans.getClaimsInternalRefInfo();
											if(newIntRefList!=null) {
												for (ElsecoClaimsInternalReference newClaimsIntRef : newIntRefList) {													
													if ((oldIntRefList!=null && oldIntRefList.size() > 0) && newClaimsIntRef.getIntRefId() > 0){
														for (ElsecoClaimsInternalReference oldClaimsIntRef : oldIntRefList) {															
															if(newClaimsIntRef.getIntRefId()>0 && oldClaimsIntRef.getIntRefId()>0 && 
																		(newClaimsIntRef.getIntRefId() == oldClaimsIntRef.getIntRefId())) {																
																
																//Claims Member Info
																List<ElsecoMemberInfo> newMemberInfoList = newClaimsIntRef.getMemberInfo();
																List<ElsecoMemberInfo> oldMemberInfoList = oldClaimsIntRef.getMemberInfo();
																if(newMemberInfoList!=null) {
																	for (ElsecoMemberInfo newMemberInfo : newMemberInfoList) {																		
																		if(newMemberInfo.getClaimId() == 0) {									
																			if(newClaimDetails.getClaimId() == 0) {
																				newMemberInfo.setClaimId(detailId);
																			}else {
																				newMemberInfo.setClaimId(newClaimDetails.getClaimId());
																			}
																		}
																		if(newMemberInfo.getClaimHeaderId() == 0) {
																			if(newClaimDetails.getClaimHeaderId() == 0) {
																				newMemberInfo.setClaimHeaderId(headerId);
																			}else {
																				newMemberInfo.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
																			}													
																		}					
																		if(newMemberInfo.getPolicyTransactionId() == 0) {
																			if(newClaimsIntRef.getPolicyTransactionId() == 0) {
																				newMemberInfo.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
																			}else {
																				newMemberInfo.setPolicyTransactionId(newClaimsIntRef.getPolicyTransactionId());
																			}
																		}
																		if(newMemberInfo.getMarketTransactionId() == 0) {
																			if(newClaimsIntRef.getMarketTransactionId() == 0) {
																				newMemberInfo.setMarketTransactionId(Integer.valueOf(""+marketTransId));
																			}else {
																				newMemberInfo.setMarketTransactionId(newClaimsIntRef.getMarketTransactionId());
																			}
																		}																			
																		if(newMemberInfo.getIntRefId() == 0) {
																			if(newClaimsIntRef.getIntRefId() == 0) {
																				newMemberInfo.setIntRefId(Integer.valueOf(""+intRefId));
																			}else {
																				newMemberInfo.setIntRefId(newClaimsIntRef.getIntRefId());
																			}
																		}
																		if ((oldMemberInfoList!=null && oldMemberInfoList.size() > 0) && newMemberInfo.getMemberId() > 0) {
																			for (ElsecoMemberInfo oldMemberInfo : oldMemberInfoList) {
																				if(newMemberInfo.getMemberId()>0 && oldMemberInfo.getMemberId()>0 && 
																						(newMemberInfo.getMemberId() == oldMemberInfo.getMemberId())) {
																					saveEntityAndAuditForAnObject(newMemberInfo, oldMemberInfo, elsecoClaimsConstant.CLAIM_MEMBER_INFO, auditTrail);												
																					memberId = newMemberInfo.getMemberId();
																				}																			
																			}
																		}else if (newMemberInfo.getMemberId() > 0) {
																			throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_INFO+ " has elements in ClaimsInfo and not in AuditInfo.");
																		} else if (newMemberInfo.getMemberId() == 0) {
																			LOG.info("-------------- Insert  TRANS LEVEL CLAIM_MEMBER_INFO 2 ----------------" + newMemberInfo.toString());
																			memberId = Integer.valueOf(""+entityDao.insertMemberInfo(newMemberInfo));
																			sAuditTrail.setUniqueId(""+memberId);
																			saveAuditInfo(new JSONObject(newMemberInfo).toString(), elsecoClaimsConstant.CLAIM_MEMBER_INFO, sAuditTrail);																		
																		}
																	}
																}																
															}					
														}
													} else {														
														
														//Claims Member Info
														List<ElsecoMemberInfo> newMemberInfoList = newClaimsIntRef.getMemberInfo();									
														if(newMemberInfoList!=null) {															
															for (ElsecoMemberInfo newMemberInfo : newMemberInfoList) {	
																if(newMemberInfo.getClaimId() == 0) {									
																	if(newClaimDetails.getClaimId() == 0) {
																		newMemberInfo.setClaimId(detailId);
																	}else {
																		newMemberInfo.setClaimId(newClaimDetails.getClaimId());
																	}
																}
																if(newMemberInfo.getClaimHeaderId() == 0) {
																	if(newClaimDetails.getClaimHeaderId() == 0) {
																		newMemberInfo.setClaimHeaderId(headerId);
																	}else {
																		newMemberInfo.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
																	}													
																}		
																if(newMemberInfo.getPolicyTransactionId() == 0) {
																	if(newClaimsIntRef.getPolicyTransactionId() == 0) {
																		newMemberInfo.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
																	}else {
																		newMemberInfo.setPolicyTransactionId(newClaimsIntRef.getPolicyTransactionId());
																	}
																}
																if(newMemberInfo.getMarketTransactionId() == 0) {
																	if(newClaimsIntRef.getMarketTransactionId() == 0) {
																		newMemberInfo.setMarketTransactionId(Integer.valueOf(""+marketTransId));
																	}else {
																		newMemberInfo.setMarketTransactionId(newClaimsIntRef.getMarketTransactionId());
																	}
																}	
																if(newMemberInfo.getIntRefId() == 0) {
																	if(newClaimsIntRef.getIntRefId() == 0) {
																		newMemberInfo.setIntRefId(Integer.valueOf(""+intRefId));
																	}else {
																		newMemberInfo.setIntRefId(newClaimsIntRef.getIntRefId());
																	}
																}
																if (newMemberInfo.getMemberId() > 0) {
																	throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_INFO+ " has elements in ClaimsInfo and not in AuditInfo.");
																} else if (newMemberInfo.getMemberId() == 0) {
																	LOG.info("-------------- Insert  TRANS LEVEL CLAIM_MEMBER_INFO 3----------------" + newMemberInfo.toString());
																	memberId = Integer.valueOf(""+entityDao.insertMemberInfo(newMemberInfo));
																	sAuditTrail.setUniqueId(""+memberId);
																	saveAuditInfo(new JSONObject(newMemberInfo).toString(), elsecoClaimsConstant.CLAIM_MEMBER_INFO, sAuditTrail);	
																}
															}
														}
													}
												}
											}										
										}				
									}
								}else {
									List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
									for(ElsecoClaimsInternalReference newClaimsIntRef : newIntRefList) {
										
										//Claims Member Info
										List<ElsecoMemberInfo> newMemberInfoList = newClaimsIntRef.getMemberInfo();									
										if(newMemberInfoList!=null) {
											for (ElsecoMemberInfo newMemberInfo : newMemberInfoList) {	
												if(newMemberInfo.getClaimId() == 0) {									
													if(newClaimDetails.getClaimId() == 0) {
														newMemberInfo.setClaimId(detailId);
													}else {
														newMemberInfo.setClaimId(newClaimDetails.getClaimId());
													}
												}
												if(newMemberInfo.getClaimHeaderId() == 0) {
													if(newClaimDetails.getClaimHeaderId() == 0) {
														newMemberInfo.setClaimHeaderId(headerId);
													}else {
														newMemberInfo.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
													}													
												}	
												if(newMemberInfo.getPolicyTransactionId() == 0) {
													if(newClaimsIntRef.getPolicyTransactionId() == 0) {
														newMemberInfo.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
													}else {
														newMemberInfo.setPolicyTransactionId(newClaimsIntRef.getPolicyTransactionId());
													}
												}
												if(newMemberInfo.getMarketTransactionId() == 0) {
													if(newClaimsIntRef.getMarketTransactionId() == 0) {
														newMemberInfo.setMarketTransactionId(Integer.valueOf(""+marketTransId));
													}else {
														newMemberInfo.setMarketTransactionId(newClaimsIntRef.getMarketTransactionId());
													}
												}	
												if(newMemberInfo.getIntRefId() == 0) {
													if(newClaimsIntRef.getIntRefId() == 0) {
														newMemberInfo.setIntRefId(Integer.valueOf(""+intRefId));
													}else {
														newMemberInfo.setIntRefId(newClaimsIntRef.getIntRefId());
													}
												}
												if (newMemberInfo.getMemberId() > 0) {
													throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_INFO+ " has elements in ClaimsInfo and not in AuditInfo.");
												} else if (newMemberInfo.getMemberId() == 0) {
													LOG.info("-------------- Insert  TRANS LEVEL CLAIM_MEMBER_INFO 1 ----------------" + newMemberInfo.toString());
													memberId = Integer.valueOf(""+entityDao.insertMemberInfo(newMemberInfo));
													sAuditTrail.setUniqueId(""+memberId);
													saveAuditInfo(new JSONObject(newMemberInfo).toString(), elsecoClaimsConstant.CLAIM_MEMBER_INFO, sAuditTrail);	
												}
											}
										}
									}
								}
							}
						}												
						
						//Claims Files
						List<ElsecoClaimsFile> newClaimFileList = newClaimDetails.getClaimsFileInfo();
						List<ElsecoClaimsFile> oldClaimFileList = oldClaimDetails.getClaimsFileInfo();	
						if(newClaimFileList!=null) {
							for (ElsecoClaimsFile newClaimsFile : newClaimFileList) {
								if(newClaimsFile.getClaimId() == 0) {									
									if(newClaimDetails.getClaimId() == 0) {
										newClaimsFile.setClaimId(detailId);
									}else {
										newClaimsFile.setClaimId(newClaimDetails.getClaimId());
									}
								}
								if ((oldClaimFileList!=null && oldClaimFileList.size() > 0) && newClaimsFile.getClaimFileId() > 0){
									for (ElsecoClaimsFile oldClaimsFile : oldClaimFileList) {
										if(newClaimsFile.getClaimFileId()>0 && oldClaimsFile.getClaimFileId()>0 && 
											(newClaimsFile.getClaimFileId() == oldClaimsFile.getClaimFileId())) {
											saveEntityAndAuditForAnObject(newClaimsFile, oldClaimsFile, elsecoClaimsConstant.CLAIM_FILES, auditTrail);
											fileId = newClaimsFile.getClaimFileId();
										}					
									}
								} else if (newClaimsFile.getClaimFileId() > 0) {
									throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_FILES+ " has elements in ClaimsInfo and not in AuditInfo.");
								} else if (newClaimsFile.getClaimFileId() == 0) {
									LOG.info("-------------- Insert CLAIM_FILES ----------------" + newClaimsFile.toString());
									fileId = Integer.valueOf(""+entityDao.insertClaimFile(newClaimsFile));
									sAuditTrail.setUniqueId(""+fileId);
									saveAuditInfo(new JSONObject(newClaimsFile).toString(), elsecoClaimsConstant.CLAIM_FILES, sAuditTrail);	
								}
							}
						}
						
						//Claims Files - Claims Check List 
						if(newClaimFileList!=null) {
							for (ElsecoClaimsFile newClaimsFile : newClaimFileList) {								
								if ((oldClaimFileList!=null && oldClaimFileList.size() > 0) && newClaimsFile.getClaimFileId() > 0){
									for (ElsecoClaimsFile oldClaimsFile : oldClaimFileList) {
										if(newClaimsFile.getClaimFileId()>0 && oldClaimsFile.getClaimFileId()>0 && 
												(newClaimsFile.getClaimFileId() == oldClaimsFile.getClaimFileId())) {
											
											//Claims Check List
											List<ElsecoCheckList> newHeaderClaimChklistList = newClaimsFile.getClaimsCheckListInfo();
											List<ElsecoCheckList> oldHeaderClaimChklistList = oldClaimsFile.getClaimsCheckListInfo();
											if(newHeaderClaimChklistList!=null) {
												for (ElsecoCheckList newClaimsChklist : newHeaderClaimChklistList) {				
													if(newClaimsChklist.getClaimDetailId() == 0) {
														if(newClaimsFile.getClaimId() == 0) {
															newClaimsChklist.setClaimDetailId(detailId);
														}else {
															newClaimsChklist.setClaimDetailId(newClaimsFile.getClaimId());
														}
													}							
													if(newClaimsChklist.getClaimHeaderId() == 0) {
														if(newClaimsFile.getClaimHeaderId() == 0) {
															newClaimsChklist.setClaimHeaderId(headerId);
														}else {
															newClaimsChklist.setClaimHeaderId(newClaimsFile.getClaimHeaderId());
														}
													}	
													if(newClaimsChklist.getClaimFileId() == 0) {
														if(newClaimsFile.getClaimFileId() == 0) {
															newClaimsChklist.setClaimFileId(fileId);
														}else {
															newClaimsChklist.setClaimFileId(newClaimsFile.getClaimFileId());
														}
													}	
													newClaimsChklist.setClaimItemId(0);
													if ((oldHeaderClaimChklistList!=null && oldHeaderClaimChklistList.size() > 0) && newClaimsChklist.getCheckListId() > 0){
														for (ElsecoCheckList oldClaimsChklist : oldHeaderClaimChklistList) {
															if(newClaimsChklist.getCheckListId()>0 && oldClaimsChklist.getCheckListId()>0 && 
																	(newClaimsChklist.getCheckListId() == oldClaimsChklist.getCheckListId())
																	&& newClaimsChklist.getLevel().equalsIgnoreCase("F") ) {
																saveEntityAndAuditForAnObject(newClaimsChklist, oldClaimsChklist, elsecoClaimsConstant.CLAIM_CHECK_LIST, auditTrail);
															} 				
														}
													} else if (newClaimsChklist.getCheckListId() > 0) {
														throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_CHECK_LIST+ " has elements in ClaimsInfo and not in AuditInfo.");
													} else if ((newClaimsChklist.getCheckListId() == 0)  && newClaimsChklist.getLevel().equalsIgnoreCase("F")) {
														LOG.info("-------------- Insert CLAIM_CHECK_LIST FOR FILE LEVEL----------------" + newClaimsChklist.toString());
														sAuditTrail.setUniqueId(""+entityDao.insertCheckList(newClaimsChklist));
														saveAuditInfo(new JSONObject(newClaimsChklist).toString(), elsecoClaimsConstant.CLAIM_CHECK_LIST, sAuditTrail);	
													}
												}
											}											
										}					
									}
								}
							}
						}
						
						//Claim Detail - Policy Transaction - Internal Reference - MemberInfo - Member Result
						if(newClaimTransactionList!=null) {
							for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {								
								if ((oldClaimTransactionList!=null && oldClaimTransactionList.size() > 0) && newClaimsTrans.getClaimsTransactionId() > 0) {
									for (ElsecoClaimsTransaction oldClaimsTrans : oldClaimTransactionList) {
										if(newClaimsTrans.getClaimsTransactionId()>0 && oldClaimsTrans.getClaimsTransactionId()>0 && 
											(newClaimsTrans.getClaimsTransactionId() == oldClaimsTrans.getClaimsTransactionId())) {
																														
											//Claims Internal Reference
											List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
											List<ElsecoClaimsInternalReference> oldIntRefList = oldClaimsTrans.getClaimsInternalRefInfo();
											if(newIntRefList!=null) {
												for (ElsecoClaimsInternalReference newClaimsIntRef : newIntRefList) {																	
													if ((oldIntRefList!=null && oldIntRefList.size() > 0) && newClaimsIntRef.getIntRefId() > 0){
														for (ElsecoClaimsInternalReference oldClaimsIntRef : oldIntRefList) {
															if(newClaimsIntRef.getIntRefId()>0 && oldClaimsIntRef.getIntRefId()>0 && 
																(newClaimsIntRef.getIntRefId() == oldClaimsIntRef.getIntRefId())) {
																
																//Claims Member Info
																List<ElsecoMemberInfo> newMemberInfoList = newClaimsIntRef.getMemberInfo();
																List<ElsecoMemberInfo> oldMemberInfoList = oldClaimsIntRef.getMemberInfo();
																if(newMemberInfoList!=null) {
																	for (ElsecoMemberInfo newMemberInfo : newMemberInfoList) {
																		List<ElsecoMemberResult> newMemberResultsList =  newMemberInfo.getMemberResultsInfo();
																		if(newMemberResultsList!=null) {
																			for (ElsecoMemberResult newMemberResult : newMemberResultsList) {										
																				if(newMemberResult.getClaimId() == 0) {									
																					if(newClaimDetails.getClaimId() == 0) {
																						newMemberResult.setClaimId(detailId);
																					}else {
																						newMemberResult.setClaimId(newClaimDetails.getClaimId());
																					}
																				}
																				if(newMemberResult.getClaimHeaderId() == 0) {
																					newMemberResult.setClaimHeaderId(headerId);
																				}
																				if(newMemberResult.getMemberId() == 0) {
																					newMemberResult.setMemberId(memberId);
																				}																																							
																				if(newMemberResult.getPolicyTransactionId() == 0) {
																					if(newMemberInfo.getPolicyTransactionId() == 0) {
																						newMemberResult.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
																					}else {
																						newMemberResult.setPolicyTransactionId(newMemberInfo.getPolicyTransactionId());
																					}
																				}
																				if(newMemberResult.getMarketTransactionId() == 0) {
																					if(newMemberInfo.getMarketTransactionId() == 0) {
																						newMemberResult.setMarketTransactionId(Integer.valueOf(""+marketTransId));
																					}else {
																						newMemberResult.setMarketTransactionId(newMemberInfo.getMarketTransactionId());
																					}
																				}	
																				
																				if(newMemberResult.getIntRefId() == 0) {
																					newMemberResult.setIntRefId(Integer.valueOf(""+intRefId));
																				}
																				if(oldMemberInfoList!=null) {											
																					for(ElsecoMemberInfo oldMemberInfo:  oldMemberInfoList) {
																						List<ElsecoMemberResult> oldClaimMemberResultList = oldMemberInfo.getMemberResultsInfo();
																						if ((oldClaimMemberResultList!=null && oldClaimMemberResultList.size() > 0) && newMemberResult.getResultId() > 0){
																							for (ElsecoMemberResult oldMemberResult : oldClaimMemberResultList) {
																								if(newMemberResult.getResultId()>0 && oldMemberResult.getResultId()>0 && 
																										(newMemberResult.getResultId() == oldMemberResult.getResultId())) {
																										saveEntityAndAuditForAnObject(newMemberResult, oldMemberResult, elsecoClaimsConstant.CLAIM_MEMBER_RESULT, auditTrail);
																										resultId = newMemberResult.getResultId();															
																										//Rebuild the logic for Member Riskcode
																										if((newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId()>0) && 
																												(oldMemberResult.getMemberRiskCodeInfo()!=null && oldMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId()>0) && 
																													(newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId() == oldMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId())) {
																												saveEntityAndAuditForAnObject(newMemberResult.getMemberRiskCodeInfo(), oldMemberResult.getMemberRiskCodeInfo(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, auditTrail);
																										}else if ((newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId()>0)) {
																												throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE+ " has elements in ClaimsInfo and not in AuditInfo.");
																										} else if (newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId() == 0) {
																											LOG.info("-------------- Insert CLAIM_MEMBER_RISKCODE ----------------" + newMemberResult.getMemberRiskCodeInfo().toString());																
																											sAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(newMemberResult.getMemberRiskCodeInfo()));									
																											saveAuditInfo(new JSONObject(newMemberResult.getMemberRiskCodeInfo()).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, sAuditTrail);	
																										}
																								}					
																							}
																						} else if (newMemberResult.getResultId() > 0) {
																							throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RESULT+ " has elements in ClaimsInfo and not in AuditInfo.");
																						} else if (newMemberResult.getResultId() == 0) {
																							LOG.info("-------------- Insert CLAIM_MEMBER_RESULT ----------------" + newMemberResult.toString());
																							resultId = Integer.valueOf(""+entityDao.insertMemberResults(newMemberResult));
																							sAuditTrail.setUniqueId(""+resultId);									
																							saveAuditInfo(new JSONObject(newMemberResult).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RESULT, sAuditTrail);	
																							
																							if ((newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId()>0)) {
																								throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE+ " has elements in ClaimsInfo and not in AuditInfo.");
																							} else if (newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId() == 0) {
																								LOG.info("-------------- Insert CLAIM_MEMBER_RISKCODE ----------------" + newMemberResult.getMemberRiskCodeInfo().toString());																
																								sAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(newMemberResult.getMemberRiskCodeInfo()));									
																								saveAuditInfo(new JSONObject(newMemberResult.getMemberRiskCodeInfo()).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, sAuditTrail);	
																							}
																						}												
																					}
																				}else if (newMemberResult.getResultId() > 0)  {
																					throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RESULT +" has elements in ClaimsInfo and not in AuditInfo.");
																				} else if (newMemberResult.getResultId() == 0) {
																					LOG.info("-------------- Insert CLAIM_MEMBER_RESULT ----------------"+ newMemberResult.toString());
																					sAuditTrail.setUniqueId(""+entityDao.insertMemberResults(newMemberResult));
																					saveAuditInfo(new JSONObject(newMemberResult).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RESULT, sAuditTrail);
																					
																					if ((newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId()>0)) {
																						throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE+ " has elements in ClaimsInfo and not in AuditInfo.");
																					} else if (newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId() == 0) {
																						LOG.info("-------------- Insert CLAIM_MEMBER_RISKCODE ----------------" + newMemberResult.getMemberRiskCodeInfo().toString());																
																						sAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(newMemberResult.getMemberRiskCodeInfo()));									
																						saveAuditInfo(new JSONObject(newMemberResult.getMemberRiskCodeInfo()).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, sAuditTrail);	
																					}
																				}											
																			}
																		}
																	}
																}
															}
														}
													}else {											
															//Claims Member Result
															List<ElsecoMemberInfo> newMemberInfoList = newClaimsIntRef.getMemberInfo();									
															if(newMemberInfoList!=null) {
																for (ElsecoMemberInfo newMemberInfo : newMemberInfoList) {
																	List<ElsecoMemberResult> newMemberResultsList =  newMemberInfo.getMemberResultsInfo();
																	if(newMemberResultsList!=null) {
																		for (ElsecoMemberResult newMemberResult : newMemberResultsList) {										
																			if(newMemberResult.getClaimId() == 0) {									
																				if(newClaimDetails.getClaimId() == 0) {
																					newMemberResult.setClaimId(detailId);
																				}else {
																					newMemberResult.setClaimId(newClaimDetails.getClaimId());
																				}
																			}
																			if(newMemberResult.getClaimHeaderId() == 0) {
																				newMemberResult.setClaimHeaderId(headerId);
																			}
																			if(newMemberResult.getMemberId() == 0) {
																				newMemberResult.setMemberId(memberId);
																			}
																			if(newMemberResult.getPolicyTransactionId() == 0) {
																				if(newMemberInfo.getPolicyTransactionId() == 0) {
																					newMemberResult.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
																				}else {
																					newMemberResult.setPolicyTransactionId(newMemberInfo.getPolicyTransactionId());
																				}
																			}
																			if(newMemberResult.getMarketTransactionId() == 0) {
																				if(newMemberInfo.getMarketTransactionId() == 0) {
																					newMemberResult.setMarketTransactionId(Integer.valueOf(""+marketTransId));
																				}else {
																					newMemberResult.setMarketTransactionId(newMemberInfo.getMarketTransactionId());
																				}
																			}	
																			if(newMemberResult.getIntRefId() == 0) {
																				if(newMemberInfo.getIntRefId() == 0) {
																					newMemberResult.setIntRefId(Integer.valueOf(""+intRefId));
																				}else {
																					newMemberResult.setIntRefId(newMemberInfo.getIntRefId());
																				}
																			}
																			if (newMemberResult.getResultId() > 0)  {
																				throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RESULT +" has elements in ClaimsInfo and not in AuditInfo.");
																			} else if (newMemberResult.getResultId() == 0) {
																				LOG.info("-------------- Insert CLAIM_MEMBER_RESULT ----------------"+ newMemberResult.toString());
																				sAuditTrail.setUniqueId(""+entityDao.insertMemberResults(newMemberResult));
																				saveAuditInfo(new JSONObject(newMemberResult).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RESULT, sAuditTrail);
																				
																				if ((newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId()>0)) {
																					throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE+ " has elements in ClaimsInfo and not in AuditInfo.");
																				} else if (newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId() == 0) {
																					LOG.info("-------------- Insert CLAIM_MEMBER_RISKCODE ----------------" + newMemberResult.getMemberRiskCodeInfo().toString());																
																					sAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(newMemberResult.getMemberRiskCodeInfo()));									
																					saveAuditInfo(new JSONObject(newMemberResult.getMemberRiskCodeInfo()).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, sAuditTrail);	
																				}
																			}														
																		}
																	}												
																}
															}																						
													}
												}
											}
										}
									}
								}else {

									List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
									for(ElsecoClaimsInternalReference newClaimsIntRef : newIntRefList) {
										//Claims Member Info
										List<ElsecoMemberInfo> newMemberInfoList = newClaimsIntRef.getMemberInfo();									
										if(newMemberInfoList!=null) {
											for (ElsecoMemberInfo newMemberInfo : newMemberInfoList) {
												List<ElsecoMemberResult> newMemberResultsList =  newMemberInfo.getMemberResultsInfo();
												if(newMemberResultsList!=null) {
													for (ElsecoMemberResult newMemberResult : newMemberResultsList) {										
														if(newMemberResult.getClaimId() == 0) {									
															if(newClaimDetails.getClaimId() == 0) {
																newMemberResult.setClaimId(detailId);
															}else {
																newMemberResult.setClaimId(newClaimDetails.getClaimId());
															}
														}
														if(newMemberResult.getClaimHeaderId() == 0) {
															newMemberResult.setClaimHeaderId(headerId);
														}
														if(newMemberResult.getMemberId() == 0) {
															newMemberResult.setMemberId(memberId);
														}
														if(newMemberResult.getPolicyTransactionId() == 0) {
															if(newMemberInfo.getPolicyTransactionId() == 0) {
																newMemberResult.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
															}else {
																newMemberResult.setPolicyTransactionId(newMemberInfo.getPolicyTransactionId());
															}
														}
														if(newMemberResult.getMarketTransactionId() == 0) {
															if(newMemberInfo.getMarketTransactionId() == 0) {
																newMemberResult.setMarketTransactionId(Integer.valueOf(""+marketTransId));
															}else {
																newMemberResult.setMarketTransactionId(newMemberInfo.getMarketTransactionId());
															}
														}	
														if(newMemberResult.getIntRefId() == 0) {
															if(newMemberInfo.getIntRefId() == 0) {
																newMemberResult.setIntRefId(Integer.valueOf(""+intRefId));
															}else {
																newMemberResult.setIntRefId(newMemberInfo.getIntRefId());
															}
														}
														if (newMemberResult.getResultId() > 0)  {
															throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RESULT +" has elements in ClaimsInfo and not in AuditInfo.");
														} else if (newMemberResult.getResultId() == 0) {
															LOG.info("-------------- Insert CLAIM_MEMBER_RESULT ----------------"+ newMemberResult.toString());
															sAuditTrail.setUniqueId(""+entityDao.insertMemberResults(newMemberResult));
															saveAuditInfo(new JSONObject(newMemberResult).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RESULT, sAuditTrail);
															
															if ((newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId()>0)) {
																throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE+ " has elements in ClaimsInfo and not in AuditInfo.");
															} else if (newMemberResult.getMemberRiskCodeInfo()!=null && newMemberResult.getMemberRiskCodeInfo().getLlRiskCodeId() == 0) {
																LOG.info("-------------- Insert CLAIM_MEMBER_RISKCODE ----------------" + newMemberResult.getMemberRiskCodeInfo().toString());																
																sAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(newMemberResult.getMemberRiskCodeInfo()));									
																saveAuditInfo(new JSONObject(newMemberResult.getMemberRiskCodeInfo()).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, sAuditTrail);	
															}
														}														
													}
												}												
											}
										}
									}								
								}
							}
						}													
					}
				}
			} else {
				
				// Claims Reserve
				List<ElsecoClaimReserve> newClaimReserveList = newClaimDetails.getClaimReserveInfo();
				if (newClaimReserveList != null) {
					for (ElsecoClaimReserve newClaimReserve : newClaimReserveList) {
						if(newClaimReserve.getClaimHeaderId() == 0) {
							newClaimReserve.setClaimHeaderId(headerId);
						}	
						if(newClaimReserve.getClaimDetId() == 0) {
							if(newClaimDetails.getClaimId() == 0) {
								newClaimReserve.setClaimDetId(detailId);
							}else {
								newClaimReserve.setClaimDetId(newClaimDetails.getClaimId());
							}			
						}
						if (newClaimReserve.getClaimReserveId() > 0) {
							throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_RESERVE +" has elements in ClaimsInfo and not in AuditInfo.");
						} else if (newClaimReserve.getClaimReserveId() == 0) {
							LOG.info("-------------- Insert CLAIM_RESERVE ----------------"+ newClaimReserve.toString());
							sAuditTrail.setUniqueId(""+entityDao.insertClaimReserve(newClaimReserve));
							saveAuditInfo(new JSONObject(newClaimReserve).toString(), elsecoClaimsConstant.CLAIM_RESERVE, sAuditTrail);
						}
					}
				}

				// Claims Items
				List<ElsecoClaimsItems> newClaimItemsList = newClaimDetails.getClaimsItemsInfo();
				if (newClaimItemsList != null) {
					for (ElsecoClaimsItems newClaimItems : newClaimItemsList) {
						if(newClaimItems.getClaimId() == 0) {
							if(newClaimDetails.getClaimId() == 0) {
								newClaimItems.setClaimId(detailId);
							}else {
								newClaimItems.setClaimId(newClaimDetails.getClaimId());
							}
						}
						
						if (newClaimItems.getClaimItemId() > 0) {
							throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_ITEMS+ " has elements in ClaimsInfo and not in AuditInfo.");
						} else if (newClaimItems.getClaimItemId() == 0) {
							LOG.info("-------------- Insert CLAIM_ITEMS ----------------" + newClaimItems.toString());
							ItemId = (int) entityDao.insertClaimItem(newClaimItems);
							sAuditTrail.setUniqueId(""+ItemId);
							saveAuditInfo(new JSONObject(newClaimItems).toString(), elsecoClaimsConstant.CLAIM_ITEMS, sAuditTrail);
						}
					}
				}
				
				// Claims Notes
				List<ElsecoClaimsNotes> newElsecoClaimNotesList = newClaimDetails.getClaimNotesInfo();
				if(newElsecoClaimNotesList!=null) {
					for (ElsecoClaimsNotes newClaimsNotes : newElsecoClaimNotesList) {
						if(newClaimsNotes.getClaimDtlId() == 0) {
							if(newClaimDetails.getClaimId() == 0) {
								newClaimsNotes.setClaimDtlId(detailId);
							}else {
								newClaimsNotes.setClaimDtlId(newClaimDetails.getClaimId());
							}
						}
						if(newClaimsNotes.getClaimHeaderId() == 0) {
							newClaimsNotes.setClaimHeaderId(headerId);
						}
						if(newClaimsNotes.getClaimItemId() == 0) {
							newClaimsNotes.setClaimItemId(ItemId);
						}
						if (newClaimsNotes.getClaimNotesId() > 0) {
							throw new Exception("Improper JSON - " + elsecoClaimsConstant.EXTREF_NOTES+ " has elements in ClaimsInfo and not in AuditInfo.");
						} else if (newClaimsNotes.getClaimNotesId() == 0) {
							LOG.info("-------------- Insert EXTREF_NOTES----------------" + newClaimsNotes.toString());
							sAuditTrail.setUniqueId(""+entityDao.insertClaimNotes(newClaimsNotes));
							saveAuditInfo(new JSONObject(newClaimsNotes).toString(), elsecoClaimsConstant.EXTREF_NOTES, sAuditTrail);
						}
					}
				}
				
				//Claims Check List - in New Claims Detail
				List<ElsecoCheckList> newDetailClaimChklistList = newClaimDetails.getClaimsCheckListInfo();				
				if(newDetailClaimChklistList!=null) {
					for (ElsecoCheckList newClaimsChklist : newDetailClaimChklistList) {				
						if(newClaimsChklist.getClaimHeaderId() == 0) {
							newClaimsChklist.setClaimHeaderId(headerId);
						}						
						if(newClaimsChklist.getClaimDetailId() == 0) {
							if(newClaimDetails.getClaimId() == 0) {
								newClaimsChklist.setClaimDetailId(detailId);
							}else {
								newClaimsChklist.setClaimDetailId(newClaimDetails.getClaimId());
							}
						}						
						newClaimsChklist.setClaimFileId(0);
						newClaimsChklist.setClaimItemId(0);
						if (newClaimsChklist.getCheckListId() > 0) {
							throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_CHECK_LIST+ " has elements in ClaimsInfo and not in AuditInfo.");
						} else if ((newClaimsChklist.getCheckListId() == 0)  && newClaimsChklist.getLevel().equalsIgnoreCase("D")) {
							LOG.info("-------------- Insert CLAIM_CHECK_LIST FOR DETAIL----------------" + newClaimsChklist.toString());
							sAuditTrail.setUniqueId(""+entityDao.insertCheckList(newClaimsChklist));
							saveAuditInfo(new JSONObject(newClaimsChklist).toString(), elsecoClaimsConstant.CLAIM_CHECK_LIST, sAuditTrail);	
						}
					}
				}

				// Claims Detail Transactions - New
				List<ElsecoClaimsTransaction> newClaimTransactionList = newClaimDetails.getPolicyTransactionsInfo();
				if (newClaimTransactionList != null) {
					for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {
						if(newClaimsTrans.getClaimid() == 0) {
							if(newClaimDetails.getClaimId() == 0) {
								newClaimsTrans.setClaimid(detailId);
							}else {
								newClaimsTrans.setClaimid(newClaimDetails.getClaimId());
							}									
						}
						if(newClaimsTrans.getClaimHeaderid() == 0) {
							newClaimsTrans.setClaimHeaderid(headerId);
						}
						if (newClaimsTrans.getClaimsTransactionId() > 0) {
							throw new Exception("Improper JSON - " + elsecoClaimsConstant.EXTREF_TRANSACTIONS+ " has elements in ClaimsInfo and not in AuditInfo.");
						} else if (newClaimsTrans.getClaimsTransactionId() == 0) {
							LOG.info("-------------- Insert EXTREF_TRANSACTIONS ----------------"+ newClaimsTrans.toString());
							policyTransId = Integer.valueOf(""+entityDao.insertClaimTransaction(newClaimsTrans));
							sAuditTrail.setUniqueId(""+policyTransId);
							saveAuditInfo(new JSONObject(newClaimsTrans).toString(), elsecoClaimsConstant.EXTREF_TRANSACTIONS, sAuditTrail);
							LOG.info("-------------- inserted a new policy transaction at detail level when its a new Detail Id --> with transaction id ----------------"+policyTransId);
						}
					}
				} 
				
				// Claims Detail Transactions - New Internal Reference
				if (newClaimTransactionList != null) {
					for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {
						List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
						if(newIntRefList!=null) {
							for(ElsecoClaimsInternalReference newIntRef:newIntRefList) {
								if(newIntRef.getClaimId() == 0) {
									if(newClaimDetails.getClaimId() == 0) {
										newIntRef.setClaimId(detailId);
									}else {
										newIntRef.setClaimId(newClaimDetails.getClaimId());
									}									
								}
								if(newIntRef.getClaimHeaderId() == 0) {
									newIntRef.setClaimHeaderId(headerId);
								}
								if(newIntRef.getPolicyTransactionId() == 0) {
									newIntRef.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
								}								
								if(newIntRef.getMarketTransactionId() == 0) {
									newIntRef.setMarketTransactionId(Integer.valueOf(""+marketTransId));
								}						
								if (newIntRef.getIntRefId() > 0) {
									throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_INTERNAL_REF+ " has elements in ClaimsInfo and not in AuditInfo.");
								} else if (newIntRef.getIntRefId() == 0) {
									LOG.info("-------------- Insert CLAIM_INTERNAL_REF ----------------"+ newIntRef.toString());
									intRefId = Integer.valueOf(""+entityDao.insertClaimsInternalReference(newIntRef));
									sAuditTrail.setUniqueId(""+intRefId);
									saveAuditInfo(new JSONObject(newIntRef).toString(), elsecoClaimsConstant.CLAIM_INTERNAL_REF, sAuditTrail);
								}
							}
						}
					}
				}
				
				// Claims Detail Transactions - Policy Payee
				if (newClaimTransactionList != null) {
					for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {
						List<ElsecoClaimsPayee> newPayeeList = newClaimsTrans.getClaimsPayeeInfo();
						if(newPayeeList!=null) {
							for(ElsecoClaimsPayee newPayee:newPayeeList) {
								if(newPayee.getClaimId() == 0) {
									if(newClaimDetails.getClaimId() == 0) {
										newPayee.setClaimId(detailId);
									}else {
										newPayee.setClaimId(newClaimDetails.getClaimId());
									}									
								}
								if(newPayee.getClaimHeaderId() == 0) {
									newPayee.setClaimHeaderId(headerId);
								}
								if(newPayee.getClaimTransactionId() == 0) {
									if(newClaimsTrans.getClaimsTransactionId() == 0) {
										newPayee.setClaimTransactionId(Integer.valueOf(""+policyTransId));
									}else {
										newPayee.setClaimTransactionId(newClaimsTrans.getClaimsTransactionId());
									}													
								}														
								if (newPayee.getPayeeId() > 0) {
									throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_POLICY_PAYEE+ " has elements in ClaimsInfo and not in AuditInfo.");
								} else if (newPayee.getPayeeId() == 0) {
									LOG.info("-------------- Insert CLAIM_POLICY_PAYEE ----------------"+ newPayee.toString());									
									sAuditTrail.setUniqueId(""+entityDao.insertClaimsPolicyPayee(newPayee));
									saveAuditInfo(new JSONObject(newPayee).toString(), elsecoClaimsConstant.CLAIM_POLICY_PAYEE, sAuditTrail);
								}
							}
						}
					}
				}

				//Add the newly included Internal Reference when claim is saved for first time
				List<ElsecoClaimsInternalReference> newIntRefDetailList = newClaimDetails.getClaimDetailInternalReferenceInfo();
				if(newIntRefDetailList!=null) {
					for(ElsecoClaimsInternalReference newIntRefDetail:newIntRefDetailList) {
						if(newIntRefDetail.getClaimId() == 0) {
							if(newClaimDetails.getClaimId() == 0) {
								newIntRefDetail.setClaimId(detailId);
							}else {
								newIntRefDetail.setClaimId(newClaimDetails.getClaimId());
							}									
						}
						if(newIntRefDetail.getClaimHeaderId() == 0) {
							newIntRefDetail.setClaimHeaderId(headerId);
						}
						newIntRefDetail.setPolicyTransactionId(0);
						newIntRefDetail.setMarketTransactionId(0);												
						if (newIntRefDetail.getIntRefId() > 0) {
							throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_INTERNAL_REF+ " has elements in ClaimsInfo and not in AuditInfo.");
						} else if (newIntRefDetail.getIntRefId() == 0) {
							LOG.info("-------------- Insert DETAIL LEVEL CLAIM_INTERNAL_REF ----------------"+ newIntRefDetail.toString());
							intRefId = Integer.valueOf(""+entityDao.insertClaimsInternalReference(newIntRefDetail));
							sAuditTrail.setUniqueId(""+intRefId);
							saveAuditInfo(new JSONObject(newIntRefDetail).toString(), elsecoClaimsConstant.CLAIM_INTERNAL_REF, sAuditTrail);
						}
					}
				}
				
				//Adding a MemberInfo section from - Claim Details, Internal Reference
				if(newIntRefDetailList!=null) {
					for(ElsecoClaimsInternalReference newIntRef:newIntRefDetailList) {
						List<ElsecoMemberInfo> newClaimMemberInfoList = newIntRef.getMemberInfo();
						if (newClaimMemberInfoList != null) {
							for (ElsecoMemberInfo newMemberInfo : newClaimMemberInfoList) {
								if (newMemberInfo.getClaimId() == 0) {
									if (newIntRef.getClaimId() == 0) {
										newMemberInfo.setClaimId(detailId);
									} else {
										newMemberInfo.setClaimId(newIntRef.getClaimId());
									}
								}
								if (newMemberInfo.getClaimHeaderId() == 0) {
									newMemberInfo.setClaimHeaderId(headerId);
								} else {
									newMemberInfo.setClaimHeaderId(newIntRef.getClaimHeaderId());
								}
								newMemberInfo.setPolicyTransactionId(0);
								newMemberInfo.setMarketTransactionId(0);									
								if(newMemberInfo.getIntRefId() == 0) {
									newMemberInfo.setIntRefId(Integer.valueOf(""+intRefId));
								}else {
									newMemberInfo.setIntRefId(newIntRef.getIntRefId());
								}
								if (newMemberInfo.getMemberId() > 0) {
									throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_INFO + " has elements in ClaimsInfo and not in AuditInfo.");
								} else if (newMemberInfo.getMemberId() == 0) {
									LOG.info("-------------- Insert DETAIL LEVEL CLAIM_MEMBER_INFO ----------------"+ newMemberInfo.toString());
									memberId = Integer.valueOf("" + entityDao.insertMemberInfo(newMemberInfo));
									sAuditTrail.setUniqueId("" + memberId);
									saveAuditInfo(new JSONObject(newMemberInfo).toString(),	elsecoClaimsConstant.CLAIM_MEMBER_INFO, sAuditTrail);
								}
							}
						}
					}
				}
			
				//Added Member Result - from Claim Detail level, Internal Reference , Member Info
				if(newIntRefDetailList!=null) {
					for(ElsecoClaimsInternalReference newIntRef:newIntRefDetailList) {
						List<ElsecoMemberInfo> newClaimMemberInfoList = newIntRef.getMemberInfo();
						if(newClaimMemberInfoList!=null) {
							for (ElsecoMemberInfo newMemberInfo : newClaimMemberInfoList) {
																								
								//MemberResult
								List<ElsecoMemberResult> newMemberResultList = newMemberInfo.getMemberResultsInfo();
								if(newMemberResultList!=null) {
									for (ElsecoMemberResult newMemberResult : newMemberResultList) {
										if(newMemberResult.getClaimId() == 0) {									
											if(newClaimDetails.getClaimId() == 0) {
												newMemberResult.setClaimId(detailId);
											}else {
												newMemberResult.setClaimId(newClaimDetails.getClaimId());
											}
										}													
										if(newMemberResult.getClaimHeaderId() == 0) {										
											newMemberResult.setClaimHeaderId(headerId);
										}
										if(newMemberResult.getPolicyTransactionId() == 0) {
											newMemberResult.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
										}								
										if(newMemberResult.getMarketTransactionId() == 0) {
											newMemberResult.setMarketTransactionId(Integer.valueOf(""+marketTransId));
										}	
										if(newMemberResult.getIntRefId() == 0) {
											newMemberResult.setIntRefId(Integer.valueOf(""+intRefId));
										}
										if(newMemberResult.getMemberId() == 0) {										
											newMemberResult.setMemberId(memberId);
										}
										if (newMemberResult.getResultId() > 0) {
											throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RESULT+ " has elements in ClaimsInfo and not in AuditInfo.");
										} else if (newMemberInfo.getMemberId() == 0) {
											LOG.info("-------------- Insert DETAIL LEVEL CLAIM_MEMBER_RESULT ----------------" + newMemberResult.toString());
											resultId = Integer.valueOf(""+entityDao.insertMemberResults(newMemberResult));
											sAuditTrail.setUniqueId(""+resultId);
											saveAuditInfo(new JSONObject(newMemberResult).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RESULT, sAuditTrail);	
										}
						
										//Member Riskcode
										ElsecoMemberRiskcode newRiskCode = newMemberResult.getMemberRiskCodeInfo();												
										if(newRiskCode.getClaimId() == 0) {
											newRiskCode.setClaimId(detailId);
										}
										if(newRiskCode.getPolicyTransactionId() == 0) {
											newRiskCode.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
										}								
										if(newRiskCode.getMarketTransactionId() == 0) {
											newRiskCode.setMarketTransactionId(Integer.valueOf(""+marketTransId));
										}	
										if(newRiskCode.getIntRefId() == 0) {
											newRiskCode.setIntRefId(Integer.valueOf(""+intRefId));
										}
										if(newRiskCode.getMemberId() == 0) {										
											newRiskCode.setMemberId(memberId);
										}
										if(newRiskCode.getResultId() == 0) {
											newRiskCode.setResultId(resultId);
										}
						
										if (newRiskCode.getLlRiskCodeId() > 0) {
											throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE+ " has elements in ClaimsInfo and not in AuditInfo.");
										} else if (newRiskCode.getLlRiskCodeId() == 0) {
											LOG.info("-------------- Insert DETAIL LEVEL CLAIM_MEMBER_RISKCODE ----------------" + newRiskCode.toString());
											sAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(newRiskCode));									
											saveAuditInfo(new JSONObject(newRiskCode).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, sAuditTrail);	
										}
									}
								}
				
							}
						}
					}
				}
				
				//Claims MemberInfo -  from Transaction Level, Internal Reference, MemberInfo
				if (newClaimTransactionList != null) {
					for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {
						List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
						if(newIntRefList!=null) {
							for(ElsecoClaimsInternalReference newIntRef:newIntRefList) {
								List<ElsecoMemberInfo> newClaimMemberInfoList = newIntRef.getMemberInfo();
								if (newClaimMemberInfoList != null) {
									for (ElsecoMemberInfo newMemberInfo : newClaimMemberInfoList) {
										if (newMemberInfo.getClaimId() == 0) {
											if (newClaimsTrans.getClaimid() == 0) {
												newMemberInfo.setClaimId(detailId);
											} else {
												newMemberInfo.setClaimId(newClaimsTrans.getClaimid());
											}
										}
										if (newMemberInfo.getClaimHeaderId() == 0) {
											newMemberInfo.setClaimHeaderId(headerId);
										} else {
											newMemberInfo.setClaimHeaderId(newClaimsTrans.getClaimHeaderid());
										}
										if(newMemberInfo.getPolicyTransactionId() == 0) {
											if(newClaimsTrans.getClaimsTransactionId() == 0) {
												newMemberInfo.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
											}else {
												newMemberInfo.setPolicyTransactionId(newClaimsTrans.getClaimsTransactionId());
											}
										}								
										if(newMemberInfo.getMarketTransactionId() == 0) {
											newMemberInfo.setMarketTransactionId(Integer.valueOf(""+marketTransId));
										}	
										if(newMemberInfo.getIntRefId() == 0) {
											if(newIntRef.getIntRefId() == 0) {
												newMemberInfo.setIntRefId(Integer.valueOf(""+intRefId));
											}else {
												newMemberInfo.setIntRefId(newIntRef.getIntRefId());
											}
										}
										if (newMemberInfo.getMemberId() > 0) {
											throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_INFO + " has elements in ClaimsInfo and not in AuditInfo.");
										} else if (newMemberInfo.getMemberId() == 0) {
											LOG.info("-------------- Insert TRANS LEVEL CLAIM_MEMBER_INFO ----------------"+ newMemberInfo.toString());
											memberId = Integer.valueOf("" + entityDao.insertMemberInfo(newMemberInfo));
											sAuditTrail.setUniqueId("" + memberId);
											saveAuditInfo(new JSONObject(newMemberInfo).toString(),	elsecoClaimsConstant.CLAIM_MEMBER_INFO, sAuditTrail);
										}
									}
								}
							}
						}
					}
				}								
				
				//Claims MemberResult	
				if (newClaimTransactionList != null) {
					for (ElsecoClaimsTransaction newClaimsTrans : newClaimTransactionList) {
						List<ElsecoClaimsInternalReference> newIntRefList = newClaimsTrans.getClaimsInternalRefInfo();
						if(newIntRefList!=null) {
							for(ElsecoClaimsInternalReference newIntRef:newIntRefList) {
								List<ElsecoMemberInfo> newClaimMemberInfoList = newIntRef.getMemberInfo();
								if(newClaimMemberInfoList!=null) {
									for (ElsecoMemberInfo newMemberInfo : newClaimMemberInfoList) {
																										
										//MemberResult
										List<ElsecoMemberResult> newMemberResultList = newMemberInfo.getMemberResultsInfo();
										if(newMemberResultList!=null) {
											for (ElsecoMemberResult newMemberResult : newMemberResultList) {
												if(newMemberResult.getClaimId() == 0) {									
													if(newClaimDetails.getClaimId() == 0) {
														newMemberResult.setClaimId(detailId);
													}else {
														newMemberResult.setClaimId(newClaimDetails.getClaimId());
													}
												}													
												if(newMemberResult.getClaimHeaderId() == 0) {										
													newMemberResult.setClaimHeaderId(headerId);
												}
												if(newMemberResult.getPolicyTransactionId() == 0) {
													newMemberResult.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
												}								
												if(newMemberResult.getMarketTransactionId() == 0) {
													newMemberResult.setMarketTransactionId(Integer.valueOf(""+marketTransId));
												}	
												if(newMemberResult.getIntRefId() == 0) {
													newMemberResult.setIntRefId(Integer.valueOf(""+intRefId));
												}
												if(newMemberResult.getMemberId() == 0) {										
													newMemberResult.setMemberId(memberId);
												}
												if (newMemberResult.getResultId() > 0) {
													throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RESULT+ " has elements in ClaimsInfo and not in AuditInfo.");
												} else if (newMemberInfo.getMemberId() == 0) {
													LOG.info("-------------- Insert TRANS LEVEL CLAIM_MEMBER_RESULT ----------------" + newMemberResult.toString());
													resultId = Integer.valueOf(""+entityDao.insertMemberResults(newMemberResult));
													sAuditTrail.setUniqueId(""+resultId);
													saveAuditInfo(new JSONObject(newMemberResult).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RESULT, sAuditTrail);	
												}
								
												//Member Riskcode
												ElsecoMemberRiskcode newRiskCode = newMemberResult.getMemberRiskCodeInfo();												
												if(newRiskCode.getClaimId() == 0) {
													newRiskCode.setClaimId(detailId);
												}
												if(newRiskCode.getPolicyTransactionId() == 0) {
													newRiskCode.setPolicyTransactionId(Integer.valueOf(""+policyTransId));
												}								
												if(newRiskCode.getMarketTransactionId() == 0) {
													newRiskCode.setMarketTransactionId(Integer.valueOf(""+marketTransId));
												}	
												if(newRiskCode.getIntRefId() == 0) {
													newRiskCode.setIntRefId(Integer.valueOf(""+intRefId));
												}
												if(newRiskCode.getMemberId() == 0) {										
													newRiskCode.setMemberId(memberId);
												}
												if(newRiskCode.getResultId() == 0) {
													newRiskCode.setResultId(resultId);
												}
								
												if (newRiskCode.getLlRiskCodeId() > 0) {
													throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE+ " has elements in ClaimsInfo and not in AuditInfo.");
												} else if (newRiskCode.getLlRiskCodeId() == 0) {
													LOG.info("-------------- Insert TRANS LEVEL CLAIM_MEMBER_RISKCODE ----------------" + newRiskCode.toString());
													sAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(newRiskCode));									
													saveAuditInfo(new JSONObject(newRiskCode).toString(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE, sAuditTrail);	
												}
											}
										}
						
									}
								}
							}
						}
					}
				}
								
				// Claims Files
				List<ElsecoClaimsFile> newClaimFileList = newClaimDetails.getClaimsFileInfo();
				if (newClaimFileList != null) {
					for (ElsecoClaimsFile newClaimsFile : newClaimFileList) {
						if(newClaimsFile.getClaimId() == 0) {									
							if(newClaimDetails.getClaimId() == 0) {
								newClaimsFile.setClaimId(detailId);
							}else {
								newClaimsFile.setClaimId(newClaimDetails.getClaimId());
							}
						}
						if(newClaimsFile.getClaimHeaderId() == 0) {									
							if(newClaimDetails.getClaimHeaderId() == 0) {
								newClaimsFile.setClaimHeaderId(headerId);
							}else {
								newClaimsFile.setClaimHeaderId(newClaimDetails.getClaimHeaderId());
							}
						}
						if (newClaimsFile.getClaimFileId() > 0) {
							throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_FILES+ " has elements in ClaimsInfo and not in AuditInfo.");
						} else if (newClaimsFile.getClaimFileId() == 0) {
							LOG.info("-------------- Insert CLAIM_FILES ----------------" + newClaimsFile.toString());
							sAuditTrail.setUniqueId(""+entityDao.insertClaimFile(newClaimsFile));
							saveAuditInfo(new JSONObject(newClaimsFile).toString(), elsecoClaimsConstant.CLAIM_FILES, sAuditTrail);
						}
					}
				}				
			 }//end of else of New Claim Detail				
	
			}
			
			//Claims RiskObj		
			Collection<ElsecoRiskObject> newClaimsRiskList = newClaims.getClaimRiskInfo();
			Collection<ElsecoRiskObject> oldClaimsRiskList = oldClaims.getClaimRiskInfo();
			if(newClaimsRiskList!=null) {
				for (ElsecoRiskObject newClaimRisk : newClaimsRiskList) {					
					if(newClaimRisk.getClaimHeaderId() == 0) {									
						if(newClaims.getClaimHeaderId() == 0) {
							newClaimRisk.setClaimHeaderId(headerId);
						}else {
							newClaimRisk.setClaimHeaderId(newClaims.getClaimHeaderId());
						}
					}
					newClaimRisk.setClaimDetailId(0);
					if ((oldClaimsRiskList!=null && oldClaimsRiskList.size() > 0) &&  newClaimRisk.getRiskObjId() > 0) {
						for (ElsecoRiskObject oldClaimRisk : oldClaimsRiskList) {
							//Claim RiskObj
							if (newClaimRisk.getRiskObjId() > 0 && oldClaimRisk.getRiskObjId() > 0
								&& (newClaimRisk.getRiskObjId() == oldClaimRisk.getRiskObjId())) {
								saveEntityAndAuditForAnObject(newClaimRisk, oldClaimRisk, elsecoClaimsConstant.CLAIM_RISKOBJ, auditTrail);
								//entityDao.deleteTemporaryRiskObject(newClaimRisk);
							}					
						}
					}else  if (newClaimRisk.getRiskObjId() > 0){
						throw new Exception("Improper JSON - "+elsecoClaimsConstant.CLAIM_RISKOBJ+" has elements in ClaimsInfo and not in AuditInfo.");
					}else if (newClaimRisk.getRiskObjId() == 0) {
						LOG.info("-------------- Insert CLAIM_RISKOBJ ----------------" + newClaimRisk.toString());					
						sAuditTrail.setUniqueId(""+entityDao.insertRiskObject(newClaimRisk));
						saveAuditInfo(new JSONObject(newClaimRisk).toString(), elsecoClaimsConstant.CLAIM_RISKOBJ, sAuditTrail);
					}
				}	
			}
			
			//Claims Notes
			List<ElsecoClaimsNotes> newHeaderClaimNotesList = newClaims.getClaimNotesInfo();
			List<ElsecoClaimsNotes> oldHeaderClaimNotesList = oldClaims.getClaimNotesInfo();
			if(newHeaderClaimNotesList!=null) {
				for (ElsecoClaimsNotes newClaimsNotes : newHeaderClaimNotesList) {				
					if(newClaimsNotes.getClaimHeaderId() == 0) {									
						if(newClaims.getClaimHeaderId() == 0) {
							newClaimsNotes.setClaimHeaderId(headerId);
						}else {
							newClaimsNotes.setClaimHeaderId(newClaims.getClaimHeaderId());
						}
					}
					newClaimsNotes.setClaimDtlId(0);
					if ((oldHeaderClaimNotesList!=null && oldHeaderClaimNotesList.size() > 0) && newClaimsNotes.getClaimNotesId() > 0){
						for (ElsecoClaimsNotes oldClaimsNotes : oldHeaderClaimNotesList) {
							if(newClaimsNotes.getClaimNotesId()>0 && oldClaimsNotes.getClaimNotesId()>0 && 
									(newClaimsNotes.getClaimNotesId() == oldClaimsNotes.getClaimNotesId())) {
								saveEntityAndAuditForAnObject(newClaimsNotes, oldClaimsNotes, elsecoClaimsConstant.UCR_NOTES, auditTrail);
							} 				
						}
					} else if (newClaimsNotes.getClaimNotesId() > 0) {
						throw new Exception("Improper JSON - " + elsecoClaimsConstant.UCR_NOTES+ " has elements in ClaimsInfo and not in AuditInfo.");
					} else if (newClaimsNotes.getClaimNotesId() == 0) {
						LOG.info("-------------- Insert UCR_NOTES FOR HEADER----------------" + newClaimsNotes.toString());
						sAuditTrail.setUniqueId(""+entityDao.insertClaimNotes(newClaimsNotes));
						saveAuditInfo(new JSONObject(newClaimsNotes).toString(), elsecoClaimsConstant.UCR_NOTES, sAuditTrail);	
					}
				}
			}	
			
			//Claims Check List
			List<ElsecoCheckList> newHeaderClaimChklistList = newClaims.getClaimsCheckListInfo();
			List<ElsecoCheckList> oldHeaderClaimChklistList = oldClaims.getClaimsCheckListInfo();
			if(newHeaderClaimChklistList!=null) {
				for (ElsecoCheckList newClaimsChklist : newHeaderClaimChklistList) {				
					if(newClaimsChklist.getClaimHeaderId() == 0) {									
						if(newClaims.getClaimHeaderId() == 0) {
							newClaimsChklist.setClaimHeaderId(headerId);
						}else {
							newClaimsChklist.setClaimHeaderId(newClaims.getClaimHeaderId());
						}
					}
					newClaimsChklist.setClaimDetailId(0);
					newClaimsChklist.setClaimFileId(0);
					newClaimsChklist.setClaimItemId(0);
					if ((oldHeaderClaimChklistList!=null && oldHeaderClaimChklistList.size() > 0) && newClaimsChklist.getCheckListId() > 0){
						for (ElsecoCheckList oldClaimsChklist : oldHeaderClaimChklistList) {
							if(newClaimsChklist.getCheckListId()>0 && oldClaimsChklist.getCheckListId()>0 && 
									(newClaimsChklist.getCheckListId() == oldClaimsChklist.getCheckListId())
									&& newClaimsChklist.getLevel().equalsIgnoreCase("H") ) {
								saveEntityAndAuditForAnObject(newClaimsChklist, oldClaimsChklist, elsecoClaimsConstant.CLAIM_CHECK_LIST, auditTrail);
							} 				
						}
					} else if (newClaimsChklist.getCheckListId() > 0) {
						throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_CHECK_LIST+ " has elements in ClaimsInfo and not in AuditInfo.");
					} else if ((newClaimsChklist.getCheckListId() == 0)  && newClaimsChklist.getLevel().equalsIgnoreCase("H")) {
						LOG.info("-------------- Insert CLAIM_CHECK_LIST FOR HEADER----------------" + newClaimsChklist.toString());
						sAuditTrail.setUniqueId(""+entityDao.insertCheckList(newClaimsChklist));
						saveAuditInfo(new JSONObject(newClaimsChklist).toString(), elsecoClaimsConstant.CLAIM_CHECK_LIST, sAuditTrail);	
					}
				}
			}
			
			//Claims Party
			List<ElsecoClaimsParty> newClaimPartyList = newClaims.getClaimPartyInfo();			
			List<ElsecoClaimsParty> oldClaimPartyList = oldClaims.getClaimPartyInfo();		
			if (newClaimPartyList != null) {
				for (ElsecoClaimsParty newClaimsParty : newClaimPartyList) {
					if (newClaimsParty.getClaimHeaderId() == 0) {
						if (newClaims.getClaimHeaderId() == 0) {
							newClaimsParty.setClaimHeaderId(headerId);
						} else {
							newClaimsParty.setClaimHeaderId(newClaims.getClaimHeaderId());
						}
					}
					if ((oldClaimPartyList != null && oldClaimPartyList.size() > 0) && newClaimsParty.getPartyId() > 0) {
						for (ElsecoClaimsParty oldClaimParty : oldClaimPartyList) {
							if (newClaimsParty.getPartyId() > 0 && oldClaimParty.getPartyId() > 0
								&& (newClaimsParty.getPartyId() == oldClaimParty.getPartyId())) {
								saveEntityAndAuditForAnObject(newClaimsParty, oldClaimParty,
									elsecoClaimsConstant.CLAIM_PARTY, auditTrail);
							}
						}
					} else if (newClaimsParty.getPartyId() > 0) {
						throw new Exception("Improper JSON - " + elsecoClaimsConstant.CLAIM_PARTY
							+ " has elements in ClaimsInfo and not in AuditInfo.");
					} else if (newClaimsParty.getPartyId() == 0) {
						LOG.info("-------------- Insert CLAIM_PARTY ----------------" + newClaimsParty.toString());
						sAuditTrail.setUniqueId("" + entityDao.insertClaimsParty(newClaimsParty));
						saveAuditInfo(new JSONObject(newClaimsParty).toString(), elsecoClaimsConstant.CLAIM_PARTY, sAuditTrail);
				}
			}
		}
			return headerId;
		}catch(Exception e) {
			//e.printStackTrace();
			LOG.error("Exception occured is: ",e);
		}
		return 0;
	}
	
		
	/**
	 * Save the audit information into AuditTrail for future reference.
	 * 
	 * @param audit
	 * @throws Exception
	 */
	public void saveAudit(ElsecoClaimsAuditTrail audit) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - saveAudit ");	
		entityDao.insertAuditTrail(audit);
		
	}
	
	/**
	 * Add the Hybris Payment Data for persisting in DB
	 * 
	 * @param elsecoHybris
	 * @return
	 * @throws Exception
	 */
	public long addElsecoHybrisPayHistory(ElsecoHybrisPayHistory elsecoHybris) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addElsecoHybrisPayHistory");		
		return entityDao.insertHybrisPayHistory(elsecoHybris);
	} 
		
	/**
	 *  Update the Payment History after the call with Hybris service
	 *  
	 * @param elsecoHybris
	 * @throws Exception
	 */
	public void updateHybrisPayHistory(ElsecoHybrisPayHistory elsecoHybris) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateHybrisPayHistory ");	
		entityDao.updateHybrisPayHistory(elsecoHybris);
	} 
	
	/**
	 * A method to a Get specific the static data from Data Layer
	 *  
	 * @param handle
	 * @param id
	 * @return
	 */
	public Object lookUpDataSearch(String sceenhandle, String entityhandle)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - lookUpDataSearch ");	
		if(entityhandle != null && !entityhandle.equals("")) {
			return populateSpecificStaticData(processDao.lookUpDataSearch(sceenhandle, entityhandle), entityhandle);
		}
		return populateStaticData(processDao.lookUpDataSearch(sceenhandle, entityhandle));
	}
		
	/**
	 * updateMemberInfoAfterPayment - Update the Member Info section with Collected status after the Hybris payment call
	 * 
	 * @param isCollected
	 * @param status
	 */
	public void updateMemberInfoAfterPayment(ElsecoHybrisPayHistory hybrisPay)  throws Exception {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - updateMemberInfoAfterPayment");		
		processDao.updateMemberInfoAfterPayment(hybrisPay);
	}
	
	/**
	 * A method to a Get All the static data from Data Layer
	 *  
	 * @param handle
	 * @param id
	 * @return
	 */
	public Object lookUpStaticData(String sceenhandle)  throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - lookUpStaticData ");		
		return populateStaticData(processDao.lookUpStaticData(sceenhandle));
	}
	
	/**
	 * A method to a add the Audit Trail to the backend Database
	 * 
	 * @param auditTrail
	 * @return
	 */
	public long addAuditTrail(ElsecoClaimsAuditTrail auditTrail) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addAuditTrail");		
		return entityDao.insertAuditTrail(auditTrail);
	}
	
	/**
	 * Get the Audit Trail details for displaying on the UI
	 *  
	 * @param criteriaEntity
	 * @return
	 * @throws Exception
	 */
	public List<?> getAuditDetailsBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception {	
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getAuditDetailsBySearchCriteria");
		Map<String, String> fetchAuditMap = new HashMap<String, String>(); 
		
		List<String> tablesList = getTableslistForEachLevel(criteriaEntity.getTabHandler());		
		List<JsonHandlerForWorklistAndSaveClaims> headerList = processDao.getClaimHeaderBySearchCriteria(criteriaEntity,false);		
		
		if (headerList != null && headerList.size() > 0) {
			//When passing  UCR_No  as the serach criteria
			for (JsonHandlerForWorklistAndSaveClaims header : headerList) {				
				criteriaEntity.setClaimHeaderId(header.getClaimHeaderId());
								
				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_HEADER))) {
					fetchAuditMap.put("H" + header.getClaimHeaderId(), elsecoClaimsConstant.CLAIM_HEADER);
				}
				List<ElsecoClaimDetails> details = processDao.getClaimDetailBySearchCriteria(criteriaEntity);	
				for (ElsecoClaimDetails dtls : details) {
					criteriaEntity.setClaimDetailId(dtls.getClaimId());

					if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_DETAIL))) {
						fetchAuditMap.put("D" + dtls.getClaimId(), elsecoClaimsConstant.CLAIM_DETAIL);
					}

					if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_ITEMS))) {
						List<ElsecoClaimsItems> items = processDao.getClaimItemsBySearchCriteria(criteriaEntity);
						for (ElsecoClaimsItems claimItem : items) {
							fetchAuditMap.put("I" + claimItem.getClaimItemId(), elsecoClaimsConstant.CLAIM_ITEMS);
						}
					}

					if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_FILES))) {
						List<ElsecoClaimsFile> files = processDao.getClaimFilesBySearchCriteria(criteriaEntity);
						for (ElsecoClaimsFile claimFile : files) {
							fetchAuditMap.put("F" + claimFile.getClaimFileId(), elsecoClaimsConstant.CLAIM_FILES);
						}
					}

					if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_RESERVE))) {
						List<ElsecoClaimReserve> reserve = processDao.getClaimReserveBySearchCriteria(criteriaEntity);
						for (ElsecoClaimReserve claimRserve : reserve) {
							fetchAuditMap.put("R" + claimRserve.getClaimReserveId(), elsecoClaimsConstant.CLAIM_RESERVE);
						}
					}

					if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_CHECK_LIST))) {
						List<ElsecoCheckList> chkLists = processDao.getClaimChecklistBySearchCriteria(criteriaEntity);
						for (ElsecoCheckList claimChkList : chkLists) {
							fetchAuditMap.put("S" + claimChkList.getCheckListId(), elsecoClaimsConstant.CLAIM_CHECK_LIST);
						}
					}

					if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.UCR_NOTES)
							|| tablesList.contains(elsecoClaimsConstant.EXTREF_NOTES))) {
						List<ElsecoClaimsNotes> notes = processDao.getClaimNotesBySearchCriteria(criteriaEntity);
						for (ElsecoClaimsNotes claimNotes : notes) {
							if (tablesList.contains(elsecoClaimsConstant.UCR_NOTES)) {
								fetchAuditMap.put("N" + claimNotes.getClaimNotesId(), elsecoClaimsConstant.UCR_NOTES);
							} else {
								fetchAuditMap.put("N" + claimNotes.getClaimNotesId(), elsecoClaimsConstant.EXTREF_NOTES);
							}
						}
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_RISKOBJ))) {
					List<ElsecoRiskObject> risk = processDao.getClaimRiskobjBySearchCriteria(criteriaEntity);
					for (ElsecoRiskObject claimRisk : risk) {
						fetchAuditMap.put("K" + claimRisk.getRiskObjId(), elsecoClaimsConstant.CLAIM_RISKOBJ);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.UCR_TRANSACTIONS)
						|| tablesList.contains(elsecoClaimsConstant.EXTREF_TRANSACTIONS))) {
					List<ElsecoClaimsTransaction> trans = processDao.getClaimTransBySearchCriteria(criteriaEntity);
					for (ElsecoClaimsTransaction claimTrans : trans) {
						if((criteriaEntity.getTabHandler().equals("UCR_TRANSACTIONS") 
								|| criteriaEntity.getTabHandler().equals("EXTREF_TRANSACTIONS")) 
									&& criteriaEntity.getId().equals(""+claimTrans.getClaimsTransactionId())) {
							if (tablesList.contains(elsecoClaimsConstant.UCR_TRANSACTIONS)) {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.UCR_TRANSACTIONS);
							} else {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.EXTREF_TRANSACTIONS);
							}
						}else if(criteriaEntity.getTabHandler().equals("UCR_MKT_TRANS") 
								|| criteriaEntity.getTabHandler().equals("EXT_POLICY_TRANS")){
							if (tablesList.contains(elsecoClaimsConstant.UCR_TRANSACTIONS)) {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.UCR_TRANSACTIONS);
							} else {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.EXTREF_TRANSACTIONS);
							}
						}
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_INTERNAL_REF))) {
					List<ElsecoClaimsInternalReference> intRefs = processDao
							.getClaimIntReferenceBySearchCriteria(criteriaEntity);
					for (ElsecoClaimsInternalReference claimIntRef : intRefs) {
						fetchAuditMap.put("C" + claimIntRef.getIntRefId(), elsecoClaimsConstant.CLAIM_INTERNAL_REF);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_MEMBER_INFO))) {
					List<ElsecoMemberInfo> memberInfos = processDao.getClaimMemberInfoBySearchCriteria(criteriaEntity);
					for (ElsecoMemberInfo claimMemInfo : memberInfos) {
						fetchAuditMap.put("M" + claimMemInfo.getMemberId(), elsecoClaimsConstant.CLAIM_MEMBER_INFO);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_MEMBER_RESULT))) {
					List<ElsecoMemberResult> memRslts = processDao.getClaimMemberResultBySearchCriteria(criteriaEntity);
					for (ElsecoMemberResult claimMemRslts : memRslts) {
						fetchAuditMap.put("E" + claimMemRslts.getResultId(), elsecoClaimsConstant.CLAIM_MEMBER_RESULT);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE))) {
					List<ElsecoMemberRiskcode> riskCodes = processDao
							.getClaimMemberRiskCodeBySearchCriteria(criteriaEntity);
					for (ElsecoMemberRiskcode claimRiskCdes : riskCodes) {
						fetchAuditMap.put("L" + claimRiskCdes.getLlRiskCodeId(), elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE);
					}
				}
			}
		}else {
			//When passing  Ext_Ref_No  as the serach criteria
			List<ElsecoClaimDetails> details = processDao.getClaimDetailBySearchCriteria(criteriaEntity);	
			for (ElsecoClaimDetails dtls : details) {
				criteriaEntity.setClaimDetailId(dtls.getClaimId());

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_DETAIL))) {
					fetchAuditMap.put("D" + dtls.getClaimId(), elsecoClaimsConstant.CLAIM_DETAIL);
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_ITEMS))) {
					List<ElsecoClaimsItems> items = processDao.getClaimItemsBySearchCriteria(criteriaEntity);
					for (ElsecoClaimsItems claimItem : items) {
						fetchAuditMap.put("I" + claimItem.getClaimItemId(), elsecoClaimsConstant.CLAIM_ITEMS);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_FILES))) {
					List<ElsecoClaimsFile> files = processDao.getClaimFilesBySearchCriteria(criteriaEntity);
					for (ElsecoClaimsFile claimFile : files) {
						fetchAuditMap.put("F" + claimFile.getClaimFileId(), elsecoClaimsConstant.CLAIM_FILES);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_RESERVE))) {
					List<ElsecoClaimReserve> reserve = processDao.getClaimReserveBySearchCriteria(criteriaEntity);
					for (ElsecoClaimReserve claimRserve : reserve) {
						fetchAuditMap.put("R" + claimRserve.getClaimReserveId(), elsecoClaimsConstant.CLAIM_RESERVE);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.CLAIM_CHECK_LIST))) {
					List<ElsecoCheckList> chkLists = processDao.getClaimChecklistBySearchCriteria(criteriaEntity);
					for (ElsecoCheckList claimChkList : chkLists) {
						fetchAuditMap.put("S" + claimChkList.getCheckListId(), elsecoClaimsConstant.CLAIM_CHECK_LIST);
					}
				}

				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.UCR_NOTES)
						|| tablesList.contains(elsecoClaimsConstant.EXTREF_NOTES))) {
					List<ElsecoClaimsNotes> notes = processDao.getClaimNotesBySearchCriteria(criteriaEntity);
					for (ElsecoClaimsNotes claimNotes : notes) {
						if (tablesList.contains(elsecoClaimsConstant.UCR_NOTES)) {
							fetchAuditMap.put("N" + claimNotes.getClaimNotesId(), elsecoClaimsConstant.UCR_NOTES);
						} else {
							fetchAuditMap.put("N" + claimNotes.getClaimNotesId(), elsecoClaimsConstant.EXTREF_NOTES);
						}
					}
				}
				
				if (tablesList != null && (tablesList.contains(elsecoClaimsConstant.UCR_TRANSACTIONS)
						|| tablesList.contains(elsecoClaimsConstant.EXTREF_TRANSACTIONS))) {
					List<ElsecoClaimsTransaction> trans = processDao.getClaimTransBySearchCriteria(criteriaEntity);
					for (ElsecoClaimsTransaction claimTrans : trans) {
						if((criteriaEntity.getTabHandler().equals("UCR_TRANSACTIONS") 
								|| criteriaEntity.getTabHandler().equals("EXTREF_TRANSACTIONS")) 
									&& criteriaEntity.getId().equals(""+claimTrans.getClaimsTransactionId())) {
							if (tablesList.contains(elsecoClaimsConstant.UCR_TRANSACTIONS)) {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.UCR_TRANSACTIONS);
							} else {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.EXTREF_TRANSACTIONS);
							}
						}else if(criteriaEntity.getTabHandler().equals("UCR_MKT_TRANS") 
								|| criteriaEntity.getTabHandler().equals("EXT_POLICY_TRANS")){
							if (tablesList.contains(elsecoClaimsConstant.UCR_TRANSACTIONS)) {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.UCR_TRANSACTIONS);
							} else {
								fetchAuditMap.put("T" + claimTrans.getClaimsTransactionId(), elsecoClaimsConstant.EXTREF_TRANSACTIONS);
							}
						}
					}
				}
			}
			
		}
						
		List<ElsecoClaimsAuditTrail> auditDetails = new ArrayList<ElsecoClaimsAuditTrail>(); 
		for (Map.Entry<String, String> entry : fetchAuditMap.entrySet()) {				
			auditDetails.addAll(processDao.getAuditDetailsBySearchCriteria(entry.getKey().substring(1), entry.getValue()));
	    }
		
		for(ElsecoClaimsAuditTrail auditTrail: auditDetails) {
			if(auditTrail.getCrudEntityHandle().equalsIgnoreCase(elsecoClaimsConstant.CLAIM_CHECK_LIST)) {
				List<JsonHandlerForAuditTrace> fields = getFieldsInChecklist(auditTrail.getNewClobJson(), auditTrail.getOldClobJson());
				auditTrail.setFields(fields);
			}else {
				List<JsonHandlerForAuditTrace> fields = getAuditFields(auditTrail.getNewClobJson(), auditTrail.getOldClobJson());
				auditTrail.setFields(fields);
			}
		}
		return auditDetails;
	}
	
	/**
	 * 
	 * @param headerId
	 * @param detailId
	 * @param itemId
	 * @param fileId
	 * @return
	 * @throws Exception 
	 */
	public List<String> getTableslistForEachLevel(String propsKey) throws Exception {
		List<String> tableList = new ArrayList<String>();
		if(propsKey!= null) { 	
			Field field = elsecoClaimsConstant.getClass().getDeclaredField("TAB_HANDLER_"+propsKey+"_TABLES");
			field.setAccessible(true);
			String value = (String)field.get(elsecoClaimsConstant); 			
			String[] propTablesList = value.split("\\|");							
			for(String eachTable : propTablesList) {
				tableList.add(eachTable);					
			}	
		}		
		return tableList;
	}
	
	/**
	 * Change the status of the claim in Claim Detail
	 * 
	 * @param headerId
	 * @param detailId
	 * @param claimStatus
	 */
	public void claimDetailStatusChange(String headerId, String detailId, String claimStatus)  throws Exception{
		if (claimStatus != null && !("").equals(claimStatus)) {
			if (claimStatus.equalsIgnoreCase(elsecoClaimsConstant.STATUS_APPROVED)) {
				processDao.updateClaimDetailStatus(headerId, detailId, elsecoClaimsConstant.STATUS_APPROVED);
			} else if (claimStatus.equalsIgnoreCase(elsecoClaimsConstant.STATUS_REJECT)) {
				processDao.updateClaimDetailStatus(headerId, detailId, elsecoClaimsConstant.STATUS_REJECT);
			} else if (claimStatus.equalsIgnoreCase(elsecoClaimsConstant.STATUS_PENDING)) {
				processDao.updateClaimDetailStatus(headerId, detailId, elsecoClaimsConstant.STATUS_PENDING);
			} else if (claimStatus.equalsIgnoreCase(elsecoClaimsConstant.STATUS_PARTIAL_APPROVE)) {
				processDao.updateClaimDetailStatus(headerId, detailId, elsecoClaimsConstant.STATUS_PARTIAL_APPROVE);
			}
		}
	}
	
	/**
	 * Load the checklist items for each level 
	 * 
	 * @param headerId
	 * @param detailId
	 * @param itemId
	 * @param fileId
	 */
	public Map<String, Map<String,String>> assignChecklistsForEachLevel(String headerId, String detailId, String itemId, String fileId) {
		Map<String, Map<String,String>> checklistsMap = new HashMap<String, Map<String,String>>();
		
		if(headerId!= null) { 
			Map<String,String> headerChecklistMap = new HashMap<String,String>();
			String headerGrp = elsecoClaimsConstant.CHECKLIST_HEADER_GRP;					
			String[] descList = elsecoClaimsConstant.CHECKLIST_HEADER_DESC_LIST.split("\\|");							
			for(String desc : descList) {
				headerChecklistMap.put(desc, "0");					
			}
			checklistsMap.put(headerGrp, headerChecklistMap);			
		}
		
		if(detailId!= null) {			 
			Map<String,String> detailChecklistMap = new HashMap<String,String>();
			String detailGrp = elsecoClaimsConstant.CHECKLIST_DETAIL_GRP;
			String[] descList = elsecoClaimsConstant.CHECKLIST_DETAIL_DESC_LIST.split("\\|");		
			for(String desc : descList) {
				detailChecklistMap.put(desc, "0");
				//LOG.info(" detailChecklist: "+desc   );
			}
			checklistsMap.put(detailGrp, detailChecklistMap);			
		}
		
		if(itemId!= null) {
			Map<String,String> itemChecklistMap = new HashMap<String,String>();
			String detailGrp = elsecoClaimsConstant.CHECKLIST_ITEM_GRP;
			String[] descList = elsecoClaimsConstant.CHECKLIST_ITEM_DESC_LIST.split("\\|");		
			for(String desc : descList) {
				itemChecklistMap.put(desc, "0");
				//LOG.info(" itemChecklist: "+desc   );
			}
			checklistsMap.put(detailGrp, itemChecklistMap);	
		}
		
		if(fileId!= null ) {
			Map<String,String> fileChecklistMap = new HashMap<String,String>();
			String detailGrp = elsecoClaimsConstant.CHECKLIST_FILE_GRP;
			String[] descList = elsecoClaimsConstant.CHECKLIST_FILE_DESC_LIST.split("\\|");		
			for(String desc : descList) {
				fileChecklistMap.put(desc, "0");
				//LOG.info(" fileChecklist: "+desc   );
			}
			checklistsMap.put(detailGrp, fileChecklistMap);	
		}
		
		return checklistsMap;
	}
	
	
	/**
	 * Populate the JSON for the static data
	 * 
	 * @return
	 */
	private Object populateStaticData(List<ElsecoClaimsStaticData> staticDataList) {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - populateStaticData");	
		
		JsonHandlerForStaticData staticinfo = new JsonHandlerForStaticData();
				
		List<Object> continentList = new ArrayList<Object>();
		List<Object> countryList = new ArrayList<Object>();
		List<Object> cityList = new ArrayList<Object>();
		List<Object> timezoneList = new ArrayList<Object>();
		
		Map<String,String> header = new  HashMap<String,String>();
		header.put("screenheader", "1,2,3");
		header.put("Accept", "application/json");
		header.put("user_restriction", "Acceped");
		header.put("attributes", "all");
		header.put("", "");
		header.put("other", "any");
		
		for(ElsecoClaimsStaticData staticData: staticDataList) {
			if(staticData.getEntityHandle().equalsIgnoreCase("CONTINENT")){  
				Map<String,String> continentMap = new HashMap<String,String>();
				continentMap.put("depend1", staticData.getDepend1());
				continentMap.put("depend2", staticData.getDepend2());
				continentMap.put("code", staticData.getEntityCode());
				continentMap.put("name", staticData.getEntityName1());
				continentMap.put("name2", staticData.getEntityName2());
				continentMap.put("desc", staticData.getEntityDesc());
				continentList.add(continentMap);
			}
			
			if(staticData.getEntityHandle().equalsIgnoreCase("COUNTRY")){ 
				Map<String,String> countryMap = new HashMap<String,String>();
				countryMap.put("depend1", staticData.getDepend1());
				countryMap.put("depend2", staticData.getDepend2());
				countryMap.put("code", staticData.getEntityCode());
				countryMap.put("name", staticData.getEntityName1());	
				countryMap.put("name2", staticData.getEntityName2());
				countryMap.put("desc", staticData.getEntityDesc());
				countryList.add(countryMap);
			}
			
			if(staticData.getEntityHandle().equalsIgnoreCase("CITY")){ 
				Map<String,String> cityMap = new HashMap<String,String>();
				cityMap.put("depend1", staticData.getDepend1());
				cityMap.put("depend2", staticData.getDepend2());
				cityMap.put("code", staticData.getEntityCode());
				cityMap.put("name", staticData.getEntityName1());	
				cityMap.put("name2", staticData.getEntityName2());
				cityMap.put("desc", staticData.getEntityDesc());
				cityList.add(cityMap);
			}
			
			if(staticData.getEntityHandle().equalsIgnoreCase("TIMEZONE")){  
				Map<String,String> timezoneMap = new  HashMap<String,String>();
				timezoneMap.put("depend1", staticData.getDepend1());
				timezoneMap.put("depend2", staticData.getDepend2());
				timezoneMap.put("code", staticData.getEntityCode());
				timezoneMap.put("name", staticData.getEntityName1());	
				timezoneMap.put("name2", staticData.getEntityName2());
				timezoneMap.put("desc", staticData.getEntityDesc());
				timezoneList.add(timezoneMap);
			}
		}
		
		Map<String, Object> finalMap = new HashMap<String, Object>();		
		finalMap.put("continent", continentList);
		finalMap.put("country", countryList);
		finalMap.put("city", cityList);
		finalMap.put("lossTimeZone", timezoneList);
		finalMap.put("header", header);
		
		staticinfo.setStaticinfo(finalMap);
		
		return staticinfo;		
	}
	
	/**
	 * 
	 * @param staticDataList
	 * @return
	 */
	private Object populateSpecificStaticData(List<ElsecoClaimsStaticData> staticDataList, String handle) {
		LOG.info("*****	Received a call to ElsecoClaimsHelper - populateSpecificStaticData");	
		JsonHandlerForStaticData staticinfo = new JsonHandlerForStaticData();
						
		List<Object> continentList = new ArrayList<Object>();
		List<Object> countryList = new ArrayList<Object>();
		List<Object> cityList = new ArrayList<Object>();
		List<Object> timezoneList = new ArrayList<Object>();
			
		for(ElsecoClaimsStaticData staticData: staticDataList) {
			if(staticData.getEntityHandle().equalsIgnoreCase("CONTINENT") 
					&& handle.equalsIgnoreCase("CONTINENT")){  
				Map<String,String> continentMap = new HashMap<String,String>();
				continentMap.put("depend1", staticData.getDepend1());
				continentMap.put("depend2", staticData.getDepend2());
				continentMap.put("code", staticData.getEntityCode());
				continentMap.put("name", staticData.getEntityName1());
				continentMap.put("name2", staticData.getEntityName2());
				continentMap.put("desc", staticData.getEntityDesc());
				continentList.add(continentMap);
			}
			
			if(staticData.getEntityHandle().equalsIgnoreCase("COUNTRY")
					&& handle.equalsIgnoreCase("COUNTRY")){ 
				Map<String,String> countryMap = new HashMap<String,String>();
				countryMap.put("depend1", staticData.getDepend1());
				countryMap.put("depend2", staticData.getDepend2());
				countryMap.put("code", staticData.getEntityCode());
				countryMap.put("name", staticData.getEntityName1());	
				countryMap.put("name2", staticData.getEntityName2());
				countryMap.put("desc", staticData.getEntityDesc());
				countryList.add(countryMap);
			}
			
			if(staticData.getEntityHandle().equalsIgnoreCase("CITY")
					&& handle.equalsIgnoreCase("CITY")){ 
				Map<String,String> cityMap = new HashMap<String,String>();
				cityMap.put("depend1", staticData.getDepend1());
				cityMap.put("depend2", staticData.getDepend2());
				cityMap.put("code", staticData.getEntityCode());
				cityMap.put("name", staticData.getEntityName1());	
				cityMap.put("name2", staticData.getEntityName2());
				cityMap.put("desc", staticData.getEntityDesc());
				cityList.add(cityMap);
			}
			
			if(staticData.getEntityHandle().equalsIgnoreCase("TIMEZONE")
					&& handle.equalsIgnoreCase("lossTimeZone")){  
				Map<String,String> timezoneMap = new  HashMap<String,String>();
				timezoneMap.put("depend1", staticData.getDepend1());
				timezoneMap.put("depend2", staticData.getDepend2());
				timezoneMap.put("code", staticData.getEntityCode());
				timezoneMap.put("name", staticData.getEntityName1());	
				timezoneMap.put("name2", staticData.getEntityName2());
				timezoneMap.put("desc", staticData.getEntityDesc());
				timezoneList.add(timezoneMap);
			}
		}
		
		Map<String, Object> finalMap = new HashMap<String, Object>();
		if (continentList.size() > 0) {
			finalMap.put("continent", continentList);
		}
		if (countryList.size() > 0) {
			finalMap.put("country", countryList);
		}
		if (cityList.size() > 0) {
			finalMap.put("city", cityList);
		}
		if (timezoneList.size() > 0) {
			finalMap.put("lossTimeZone", timezoneList);
		}		
		staticinfo.setStaticinfo(finalMap);
		
		return staticinfo;		
	}
	
	/*
	@SuppressWarnings("unused")
	private static boolean jsonCompare(Object obj1, Object obj2, String entity, boolean isChanged, boolean isAdded, boolean isDeleted) throws Exception  {
        if (!obj1.getClass().equals(obj2.getClass()))
        {
        	if(obj1 == null) {
        		throw new Exception("Invalid Claims JSON");
        	}
        	if(obj2 == null) {
        		throw new Exception("Invalid Audit JSON");
        	}
        	throw new Exception("Invalid JSON when compared both Audit and Claims JSON");
            //return false;
        }

        if (obj1 instanceof JSONObject)
        {
            JSONObject jsonObj1 = (JSONObject) obj1;
            JSONObject jsonObj2 = (JSONObject) obj2;
            String[] names = JSONObject.getNames(jsonObj1);
            String[] names2 = JSONObject.getNames(jsonObj1);
            System.out.println("Instance of JSONObject::   "+names+" \t "+names2);            
            if (names.length != names2.length)
            {
            	throw new Exception("Invalid JSON - Number of fields are different in both the Json for \'"+entity+"\'");
                //return false;
            }

            for (String fieldName:names)
            {
            	
                Object obj1FieldValue = jsonObj1.get(fieldName);
                Object obj2FieldValue = jsonObj2.get(fieldName);
                System.out.println("Instance of JSONObject::  fieldName:: "+fieldName+"  ::  "+obj1FieldValue.toString()+"  :.:.:  "+obj2FieldValue.toString());
                if (!jsonCompare(obj1FieldValue, obj2FieldValue, entity, isChanged, isAdded, isDeleted))
                {
                    //return false;
                	isChanged = true;
                }
            }
        }
        else if (obj1 instanceof JSONArray)
        {
        	System.out.println("Instance of JSONArray::  obj1:: "+obj1);
        	
            JSONArray obj1Array = (JSONArray) obj1;
            JSONArray obj2Array = (JSONArray) obj2;
            System.out.println("Instance of JSONArray::  obj1Array:: "+obj1Array);
            System.out.println("Instance of JSONArray::  obj2Array:: "+obj2Array);
            if (obj1Array.length() != obj2Array.length())
            {
            	isChanged = true;
                //return false;
            }

            for (int i = 0; i < obj1Array.length(); i++)
            {
                boolean matchFound = false;
                for (int j = 0; j < obj2Array.length(); j++)
                {
                    if (jsonCompare(obj1Array.get(i), obj2Array.get(j), entity, isChanged, isAdded, isDeleted))
                    {
                        matchFound = true;
                        break;
                    }
                }

                if (!matchFound)
                {
                    return false;
                }
            }
        }
        else
        {
            if (!obj1.equals(obj2))
            {
            	System.out.println("Fields are not equal : "+obj1+ " <><><> "+obj2);
                //return false;
            	isChanged = true;
            }
        }

        return true;
    }*/
	
	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static Map<String, List<Object>> jsonDiff(Object obj1, Object obj2, String entity) throws Exception {	
		//LOG.info("*****	Received a call to ElsecoClaimsHelper - jsonDiff");
		Map<String, List<Object>> mp = new HashMap<String, List<Object>>();
		 if (obj1 instanceof JSONObject)
	        {
	            JSONObject jsonObj1 = (JSONObject) obj1;
	            JSONObject jsonObj2 = (JSONObject) obj2;
	            String[] names = JSONObject.getNames(jsonObj1);
	            String[] names2 = JSONObject.getNames(jsonObj1);
	            //System.out.println("Instance of JSONObject::   "+names+" \t "+names2);            
	            if (names.length != names2.length)
	            {
	            	throw new Exception("Invalid JSON - Number of fields are different in both the Json for \'"+entity+"\'");	            
	            }

	            for (String fieldName:names)
	            {	     
	            	//System.out.println("           jsonObj1::"+jsonObj1.toString()    );
	            	//System.out.println("           jsonObj2::"+jsonObj2.toString()    );
	                Object obj1FieldValue = jsonObj1.get(fieldName);
	                Object obj2FieldValue = jsonObj2.get(fieldName);
	              
	                if (!obj1FieldValue.equals(obj2FieldValue))
	                {
	                	//System.out.println("Fields are not equal : "+obj1FieldValue+ " <><><> "+obj2FieldValue+" == "+fieldName);
	                	List<Object> diffElements = new ArrayList<Object>();
	                	diffElements.add(obj1FieldValue);
	                	diffElements.add(obj2FieldValue);
	                	mp.put(fieldName, diffElements);
	                }
	            }
	        }
		 return mp;
	}
	
	/**
	 * 
	 * @param newClaims
	 * @param oldClaims
	 * @param entity
	 * @param inputAuditTrail
	 * @throws Exception
	 */
	@Transactional 
	private int saveEntityAndAuditForAnObject(Object newClaims, Object oldClaims, String entity, ElsecoClaimsAuditTrail inputAuditTrail) throws Exception {
			int headerId = 0;
			reset(inputAuditTrail);			
			inputAuditTrail.setCrudEntityHandle(entity);						
			inputAuditTrail.setNewClobJson(new JSONObject(newClaims).toString());
			inputAuditTrail.setOldClobJson(new JSONObject(oldClaims).toString());			
			
			if (entity.equals(elsecoClaimsConstant.CLAIM_HEADER)) {
				ElsecoClaimsHeader header = (ElsecoClaimsHeader) newClaims;				
							
				if(header.getClaimHeaderId()>0 && entityDao.isClaimsHeaderExists(header.getClaimHeaderId())) {
					if(header.getDeleteFlag()!=null && header.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteClaimsHeaderById(header.getClaimHeaderId());
						LOG.info("-------------- Delete Header ----------------"+header.getClaimHeaderId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateClaimHeader(header);
						LOG.info("-------------- Update Header ----------------"+header.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(newClaims, entity));	
					headerId = header.getClaimHeaderId();	
				}else {
					headerId = (int) entityDao.insertClaimHeader(header);
					LOG.info("-------------- Insert Header ----------------"+header.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
					inputAuditTrail.setUniqueId(""+headerId);
					inputAuditTrail.setOldClobJson("");				
					
					//Adding a placeholder for the Checklist for newly created Claim header
					Map<String, Map<String,String>> checklistMap = assignChecklistsForEachLevel(""+headerId, null, null, null);
					Map<String,String> mapCheckList = checklistMap.get(elsecoClaimsConstant.CHECKLIST_HEADER_GRP);						 
					Set<String> desc =  mapCheckList.keySet();						
				
					ElsecoCheckList checkListObj = null;
					for(String checklistDesc:  desc) {
						 checkListObj = new ElsecoCheckList();
						 checkListObj.setCheckListId(0);
						 checkListObj.setClaimHeaderId(headerId);
						 checkListObj.setClaimDetailId(0);
						 checkListObj.setClaimFileId(0);
						 checkListObj.setClaimItemId(0);
						 checkListObj.setCheckListName(checklistDesc);
						 checkListObj.setCheckListGroup(elsecoClaimsConstant.CHECKLIST_HEADER_GRP);
						 checkListObj.setIsChecked(mapCheckList.get(checklistDesc));	
						 checkListObj.setLevel("H");
						 entityDao.insertCheckList(checkListObj);
					 }	
				}			
			}  
			
			if (entity.equals(elsecoClaimsConstant.CLAIM_DETAIL)) {
				ElsecoClaimDetails details = new ElsecoClaimDetails();
				BeanUtils.copyProperties(newClaims, details);								
								
				if(details.getClaimId()>0 && entityDao.isClaimsDetailExists(details.getClaimId())) {
					if(details.getDeleteFlag()!=null && details.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteClaimDetailById(details.getClaimId());
						LOG.info("-------------- Delete Detail ----------------"+details.getClaimId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateClaimDetail(details);
						LOG.info("-------------- Update Detail ----------------"+details.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(details, entity));
				}else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimDetail(details));
					LOG.info("-------------- Insert Detail ----------------"+details.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
					
					//Adding a placeholder for the Checklist for newly created Claim detail
					Map<String, Map<String,String>> checklistMap = assignChecklistsForEachLevel(""+headerId, inputAuditTrail.getUniqueId(), null, null);
					Map<String,String> mapCheckList = checklistMap.get(elsecoClaimsConstant.CHECKLIST_DETAIL_GRP);						 
					Set<String> desc =  mapCheckList.keySet();						
				
					ElsecoCheckList checkListObj = null;
					for(String checklistDesc:  desc) {
						 checkListObj = new ElsecoCheckList();
						 checkListObj.setCheckListId(0);
						 checkListObj.setClaimHeaderId(headerId);
						 checkListObj.setClaimDetailId(Integer.valueOf(inputAuditTrail.getUniqueId()));
						 checkListObj.setClaimFileId(0);
						 checkListObj.setClaimItemId(0);
						 checkListObj.setCheckListName(checklistDesc);
						 checkListObj.setCheckListGroup(elsecoClaimsConstant.CHECKLIST_DETAIL_GRP);
						 checkListObj.setIsChecked(mapCheckList.get(checklistDesc));		
						 checkListObj.setLevel("D");
						 entityDao.insertCheckList(checkListObj);
					 }	
				}				
			}
			
			if (entity.equals(elsecoClaimsConstant.CLAIM_RESERVE)) {
				ElsecoClaimReserve reserve = (ElsecoClaimReserve) newClaims;				
				if (reserve.getClaimReserveId() > 0	&& entityDao.isClaimsReserveExists(reserve.getClaimReserveId())) {
					if(reserve.getDeleteFlag()!=null && reserve.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteElsecoClaimReserveById(reserve.getClaimReserveId());
						LOG.info("-------------- Delete Reserve ----------------"+reserve.getClaimReserveId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateElsecoClaimReserve(reserve);
						LOG.info("-------------- Update Reserve ----------------"+reserve.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(reserve, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimReserve(reserve));
					LOG.info("-------------- Insert Reserve ----------------"+reserve.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}				
			}
			
			if (entity.equals(elsecoClaimsConstant.UCR_NOTES) || entity.equals(elsecoClaimsConstant.EXTREF_NOTES)) {
				ElsecoClaimsNotes notes = (ElsecoClaimsNotes) newClaims;				
				if (notes.getClaimNotesId() > 0	&& entityDao.isClaimsNoteExists(notes.getClaimNotesId())) {
					if(notes.getDeleteFlag()!=null && notes.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteElsecoClaimNotesById(notes.getClaimNotesId());
						LOG.info("-------------- Delete "+entity+" ----------------"+notes.getClaimNotesId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateElsecoClaimNotes(notes);
						LOG.info("-------------- Update "+entity+" ----------------"+notes.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(notes, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimNotes(notes));
					LOG.info("-------------- Insert "+entity+" ----------------"+notes.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}				
			}		
						
			//CLAIMS TRANSACTIONS
			if (entity.equals(elsecoClaimsConstant.EXTREF_TRANSACTIONS) || entity.equals(elsecoClaimsConstant.UCR_TRANSACTIONS)) {
				ElsecoClaimsTransaction transClaims = (ElsecoClaimsTransaction) newClaims;				
				if (transClaims.getClaimsTransactionId() > 0	&& entityDao.isClaimsTransactionExists(transClaims.getClaimsTransactionId())) {
					if(transClaims.getDeleteFlag()!=null && transClaims.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteElsecoClaimTransactionById(transClaims.getClaimsTransactionId());
						LOG.info("-------------- Delete "+entity+" ----------------"+transClaims.getClaimsTransactionId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateElsecoClaimTransaction(transClaims);
						LOG.info("-------------- Update "+entity+" ----------------"+transClaims.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(transClaims, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimTransaction(transClaims));
					LOG.info("-------------- Insert "+entity+" ----------------"+transClaims.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}				
			}
							
			//CLAIM_CHECK_LIST - Header
			if (entity.equals(elsecoClaimsConstant.CLAIM_CHECK_LIST)) {
				ElsecoCheckList claimCheckList = (ElsecoCheckList) newClaims;				
				if (claimCheckList.getCheckListId() > 0	&& entityDao.isClaimschecklistExists(claimCheckList.getCheckListId())) {
					if(claimCheckList.getDeleteFlag()!=null && claimCheckList.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteCheckListById(claimCheckList.getCheckListId());
						LOG.info("-------------- Delete CLAIM_CHECK_LIST ----------------"+claimCheckList.getCheckListId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateCheckList(claimCheckList);
						LOG.info("-------------- Update CLAIM_CHECK_LIST ----------------"+claimCheckList.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(claimCheckList, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertCheckList(claimCheckList));
					LOG.info("-------------- Insert CLAIM_CHECK_LIST ----------------"+claimCheckList.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}
			}	
			
			//CLAIM_FILES
			if (entity.equals(elsecoClaimsConstant.CLAIM_FILES)) {
				ElsecoClaimsFile claimsFile = (ElsecoClaimsFile) newClaims;				
				if (claimsFile.getClaimFileId() > 0	&& entityDao.isClaimschecklistExists(claimsFile.getClaimFileId())) {
					if(claimsFile.getDeleteFlag()!=null && claimsFile.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteCheckListById(claimsFile.getClaimFileId());
						LOG.info("-------------- Delete CLAIM_FILES ----------------"+claimsFile.getClaimFileId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateElsecoClaimFile(claimsFile);
						LOG.info("-------------- Update CLAIM_FILES ----------------"+claimsFile.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(claimsFile, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimFile(claimsFile));
					LOG.info("-------------- Insert CLAIM_FILES ----------------"+claimsFile.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}
			}	
			
			//CLAIM_ITEMS
			if (entity.equals(elsecoClaimsConstant.CLAIM_ITEMS)) {
				ElsecoClaimsItems claimItems = (ElsecoClaimsItems) newClaims;				
				if (claimItems.getClaimItemId() > 0	&& entityDao.isClaimsItemExists(claimItems.getClaimItemId())) {
					if(claimItems.getDeleteFlag()!=null && claimItems.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteClaimsItemById(claimItems.getClaimItemId());
						LOG.info("-------------- Delete CLAIM_ITEMS ----------------"+claimItems.getClaimItemId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateClaimItem(claimItems);
						LOG.info("-------------- Update CLAIM_ITEMS ----------------"+claimItems.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(claimItems, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimItem(claimItems));
					LOG.info("-------------- Insert CLAIM_ITEMS ----------------"+claimItems.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
					
					//Adding a placeholder for the Checklist for newly created Claim Item
					Map<String, Map<String,String>> checklistMap = assignChecklistsForEachLevel(""+headerId, inputAuditTrail.getUniqueId(), inputAuditTrail.getUniqueId(), null);
					Map<String,String> mapCheckList = checklistMap.get(elsecoClaimsConstant.CHECKLIST_ITEM_GRP);						 
					Set<String> desc =  mapCheckList.keySet();						
				
					ElsecoCheckList checkListObj = null;
					for(String checklistDesc:  desc) {
						 checkListObj = new ElsecoCheckList();
						 checkListObj.setCheckListId(0);
						 checkListObj.setClaimHeaderId(headerId);
						 checkListObj.setClaimDetailId(claimItems.getClaimId());
						 checkListObj.setClaimFileId(0);
						 checkListObj.setClaimItemId(Integer.valueOf(inputAuditTrail.getUniqueId()));
						 checkListObj.setCheckListName(checklistDesc);
						 checkListObj.setCheckListGroup(elsecoClaimsConstant.CHECKLIST_ITEM_GRP);
						 checkListObj.setIsChecked(mapCheckList.get(checklistDesc));	
						 checkListObj.setLevel("I");
						 entityDao.insertCheckList(checkListObj);
					 }	
				}
			}	
			
			// CLAIM_PARTY
			if (entity.equals(elsecoClaimsConstant.CLAIM_PARTY)) {
				ElsecoClaimsParty claimParty = (ElsecoClaimsParty) newClaims;				
				if (claimParty.getPartyId() > 0	&& entityDao.isClaimsPartyExists(claimParty.getPartyId())) {
					if(claimParty.getDeleteFlag()!=null && claimParty.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteClaimsPartyById(claimParty.getPartyId());
						LOG.info("-------------- Delete CLAIM_PARTY ----------------"+claimParty.getPartyId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateClaimsParty(claimParty);
						LOG.info("-------------- Update CLAIM_PARTY ----------------"+claimParty.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(claimParty, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimsParty(claimParty));
					LOG.info("-------------- Insert CLAIM_PARTY ----------------"+claimParty.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}
			}
			
			//CLAIM_POLICY_PAYEE
			if (entity.equals(elsecoClaimsConstant.CLAIM_POLICY_PAYEE)) {
				ElsecoClaimsPayee claimPayee = (ElsecoClaimsPayee) newClaims;				
				if (claimPayee.getPayeeId() > 0	&& entityDao.isClaimsPayeeExists(claimPayee.getPayeeId())) {
					if(claimPayee.getDeleteFlag()!=null && claimPayee.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteClaimsPayeeById(claimPayee.getPayeeId());
						LOG.info("-------------- Delete CLAIM_POLICY_PAYEE ----------------"+claimPayee.getPayeeId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateClaimsPayee(claimPayee);
						LOG.info("-------------- Update CLAIM_POLICY_PAYEE ----------------"+claimPayee.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(claimPayee, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimsPolicyPayee(claimPayee));
					LOG.info("-------------- Insert CLAIM_POLICY_PAYEE ----------------"+claimPayee.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}
			}
			
			//CLAIM_RISKOBJ
			if (entity.equals(elsecoClaimsConstant.CLAIM_RISKOBJ)) {
				ElsecoRiskObject claimsRisk = (ElsecoRiskObject) newClaims;				
				if (claimsRisk.getRiskObjId() > 0	&& entityDao.isRiskObjectExists(claimsRisk.getRiskObjId())) {
					if(claimsRisk.getDeleteFlag()!=null && claimsRisk.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteRiskObjectId(claimsRisk.getRiskObjId());
						LOG.info("-------------- Delete CLAIM_RISKOBJ ----------------"+claimsRisk.getRiskObjId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateRiskObject(claimsRisk);
						LOG.info("-------------- Update CLAIM_RISKOBJ ----------------"+claimsRisk.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(claimsRisk, entity));
				} else {
					LOG.info("--------------******----------------");
					inputAuditTrail.setUniqueId(""+entityDao.insertRiskObject(claimsRisk));
					LOG.info("-------------- Insert CLAIM_RISKOBJ ----------------"+claimsRisk.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}
			}	
			
			//CLAIM_INTERNAL_REF
			if (entity.equals(elsecoClaimsConstant.CLAIM_INTERNAL_REF)) {
				ElsecoClaimsInternalReference intReference = (ElsecoClaimsInternalReference) newClaims;				
				if (intReference.getIntRefId() > 0	&& entityDao.isClaimsInternalReferenceExists(intReference.getIntRefId())) {
					if(intReference.getDeleteFlag()!=null && intReference.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteClaimsInternalReferenceById(intReference.getIntRefId());
						LOG.info("-------------- Delete CLAIM_INTERNAL_REF ----------------"+intReference.getIntRefId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateClaimsInternalReference(intReference);
						LOG.info("-------------- Update CLAIM_INTERNAL_REF ----------------"+intReference.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(intReference, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertClaimsInternalReference(intReference));
					LOG.info("-------------- Insert CLAIM_INTERNAL_REF ----------------"+intReference.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}				
			}
			
			// CLAIM_MEMBER_INFO
			if (entity.equals(elsecoClaimsConstant.CLAIM_MEMBER_INFO)) {
				ElsecoMemberInfo memberInfo = (ElsecoMemberInfo) newClaims;				
				if (memberInfo.getMemberId() > 0	&& entityDao.isMemberInfoExists(memberInfo.getMemberId())) {
					if(memberInfo.getDeleteFlag()!=null && memberInfo.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteMemberInfoId(memberInfo.getMemberId());
						LOG.info("-------------- Delete CLAIM_MEMBER_INFO ----------------"+memberInfo.getMemberId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateMemberInfo(memberInfo);
						LOG.info("-------------- Update CLAIM_MEMBER_INFO ----------------"+memberInfo.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(memberInfo, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertMemberInfo(memberInfo));
					LOG.info("-------------- Insert CLAIM_MEMBER_INFO ----------------"+memberInfo.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}				
			}
			
			// CLAIM_MEMBER_RESULT
			if (entity.equals(elsecoClaimsConstant.CLAIM_MEMBER_RESULT)) {
				ElsecoMemberResult memberResult = (ElsecoMemberResult) newClaims;				
				if (memberResult.getResultId() > 0	&& entityDao.iseMemberResultsExists(memberResult.getResultId())) {
					if(memberResult.getDeleteFlag()!=null && memberResult.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteMemberResultsById(memberResult.getResultId());
						LOG.info("-------------- Delete CLAIM_MEMBER_RESULT ----------------"+memberResult.getMemberId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateMemberResults(memberResult);
						LOG.info("-------------- Update CLAIM_MEMBER_RESULT ----------------"+memberResult.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(memberResult, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertMemberResults(memberResult));
					LOG.info("-------------- Insert CLAIM_MEMBER_RESULT ----------------"+memberResult.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}				
			}
			
			//CLAIM_MEMBER_RISKCODE
			if (entity.equals(elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE)) {
				ElsecoMemberRiskcode memberRiskcode = (ElsecoMemberRiskcode) newClaims;				
				if (memberRiskcode.getLlRiskCodeId() > 0	&& entityDao.iseMemberRiskcodeExists(memberRiskcode.getLlRiskCodeId())) {
					if(memberRiskcode.getDeleteFlag()!=null && memberRiskcode.getDeleteFlag().equalsIgnoreCase("P")) {
						entityDao.deleteMemberRiskcodeById(memberRiskcode.getLlRiskCodeId());
						LOG.info("-------------- Delete CLAIM_MEMBER_RISKCODE ----------------"+memberRiskcode.getLlRiskCodeId());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_DELETE);
					}else{
						entityDao.updateMemberRiskcode(memberRiskcode);
						LOG.info("-------------- Update CLAIM_MEMBER_RISKCODE ----------------"+memberRiskcode.toString());
						inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_UPDATE);
					}
					inputAuditTrail.setUniqueId(getUniqueId(memberRiskcode, entity));
				} else {
					inputAuditTrail.setUniqueId(""+entityDao.insertMemberRiskcode(memberRiskcode));
					LOG.info("-------------- Insert CLAIM_MEMBER_RISKCODE ----------------"+memberRiskcode.toString());
					inputAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);
				}	
			}
			
			List<JsonHandlerForAuditTrace> differenceList =  getFieldsInJsonDifference(removeJSONArray(new JSONObject(newClaims)).toString(), removeJSONArray(new JSONObject(oldClaims)).toString());
			if(differenceList.size()>0) {
				entityDao.insertAuditTrail(inputAuditTrail);
				LOG.info("-------------------  Insert into Audit Trail  --------------------------"+inputAuditTrail.toString());
			}
		
			return headerId;	
	}
	
	/**
	 * Identify the Id of the Entity and set it.
	 * 
	 * @param newClaims
	 * @param entity
	 * @return
	 */
	private String getUniqueId(Object newClaims, String entity) {
		if (entity.equals(elsecoClaimsConstant.CLAIM_HEADER)) {
			ElsecoClaimsHeader header = (ElsecoClaimsHeader) newClaims;
			return String.valueOf(header.getClaimHeaderId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_RESERVE)) {
			ElsecoClaimReserve reserve = (ElsecoClaimReserve) newClaims;
			return String.valueOf(reserve.getClaimReserveId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_DETAIL)) {
			ElsecoClaimDetails details = (ElsecoClaimDetails) newClaims;
			return String.valueOf(details.getClaimId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_NOTES)|| entity.equals(elsecoClaimsConstant.UCR_NOTES) 
				|| entity.equals(elsecoClaimsConstant.EXTREF_NOTES)) {
			ElsecoClaimsNotes notes = (ElsecoClaimsNotes) newClaims;
			return String.valueOf(notes.getClaimNotesId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_FILES)) {
			ElsecoClaimsFile files = (ElsecoClaimsFile) newClaims;
			return String.valueOf(files.getClaimFileId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_TRANSACTIONS) || entity.equals(elsecoClaimsConstant.UCR_TRANSACTIONS)
				|| entity.equals(elsecoClaimsConstant.EXTREF_TRANSACTIONS)) {
			ElsecoClaimsTransaction notes = (ElsecoClaimsTransaction) newClaims;
			return String.valueOf(notes.getClaimsTransactionId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_INTERNAL_REF)) {
			ElsecoClaimsInternalReference intRef = (ElsecoClaimsInternalReference) newClaims;
			return String.valueOf(intRef.getIntRefId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_RISKOBJ)) {
			ElsecoRiskObject risk = (ElsecoRiskObject) newClaims;
			return String.valueOf(risk.getRiskObjId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_MEMBER_INFO)) {
			ElsecoMemberInfo memberInfo = (ElsecoMemberInfo) newClaims;
			return String.valueOf(memberInfo.getMemberId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_MEMBER_RESULT)) {
			ElsecoMemberResult memberResult = (ElsecoMemberResult) newClaims;
			return String.valueOf(memberResult.getResultId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE)) {
			ElsecoMemberRiskcode memberRiskcode = (ElsecoMemberRiskcode) newClaims;
			return String.valueOf(memberRiskcode.getLlRiskCodeId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_PARTY)) {
			ElsecoClaimsParty party = (ElsecoClaimsParty) newClaims;
			return String.valueOf(party.getPartyId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_POLICY_PAYEE)) {
			ElsecoClaimsPayee payee = (ElsecoClaimsPayee) newClaims;
			return String.valueOf(payee.getPayeeId());
		}
		if (entity.equals(elsecoClaimsConstant.CLAIM_CHECK_LIST)) {
			ElsecoCheckList chkList = (ElsecoCheckList) newClaims;
			return String.valueOf(chkList.getCheckListId());
		}
		return null;
	}
	
	/**
	 * saveAuditInfo -  Save Audit Info with the Json and Entity details
	 * 
	 * @param jsonData
	 * @param entity
	 * @param sAuditTrail
	 */
	private void saveAuditInfo(String jsonData, String entity, ElsecoClaimsAuditTrail sAuditTrail) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - saveAuditInfo");
		sAuditTrail.setCrudEntityHandle(entity);
		sAuditTrail.setNewClobJson(jsonData);
		sAuditTrail.setOldClobJson("");
		sAuditTrail.setOperatorType(elsecoClaimsConstant.OPERATORTYPE_INSERT);		
		entityDao.insertAuditTrail(sAuditTrail);
	}

	
	/**
	 * A explicit method for CheckList Table  
	 * 
	 * @param oldjson
	 * @param newjson
	 * @return
	 * @throws Exception
	 */
	private static List<JsonHandlerForAuditTrace> getFieldsInChecklist(String newjson, String oldjson) throws Exception {	
		//LOG.info("*****	Received a call to ElsecoClaimsHelper - getFieldsInChecklist  ");	
		
		List<JsonHandlerForAuditTrace> fields = new ArrayList<JsonHandlerForAuditTrace>();
		Resource resource = new ClassPathResource("jsonfields.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
		
		JSONObject oldjsonObj = new JSONObject(oldjson.trim().isEmpty()?"{}":oldjson);	            
        JSONObject newjsonObj = new JSONObject(newjson);
		if (newjsonObj instanceof JSONObject)
	        {			 			 	
	            String[] oldFields = JSONObject.getNames(oldjsonObj);
	            String[] newFields = JSONObject.getNames(newjsonObj);
	            
	            for (String newFieldName:newFields)
	            {		   
				if (oldFields != null && oldFields.length > 0) {
					for (String oldFieldName : oldFields) {
						String checkListName = String.valueOf(newjsonObj.get("checkListName"));
						String newFieldValue = String.valueOf(newjsonObj.get(newFieldName));
						String oldFieldValue = String.valueOf(oldjsonObj.get(oldFieldName));
						if (newFieldName.equals("isChecked") && newFieldName.equalsIgnoreCase(oldFieldName)
								&& (!newFieldValue.equals(oldFieldValue))) {
							JsonHandlerForAuditTrace trace = new JsonHandlerForAuditTrace();
							trace.setAliasName(checkListName);// checkListName
							trace.setFieldName(properties.get(checkListName) != null ? properties.get(checkListName).toString(): checkListName);							
							if (newFieldValue.equals("0")) {
								trace.setNewValue("UNCHECKED"); // if 0 unchecked
							} else {
								trace.setNewValue("CHECKED"); // if 1 checked
							}

							if (oldFieldValue.equals("0")) {
								trace.setOldValue("UNCHECKED"); // if 0 unchecked
							} else {
								trace.setOldValue("CHECKED"); // if 1 checked
							}							
							fields.add(trace);
						}
					}
				}
	            }	           
	        }		
		 return fields;
	}
	
	/**
	 * 
	 * @param oldjson
	 * @param newjson
	 * @return
	 * @throws Exception
	 */
	private static List<JsonHandlerForAuditTrace> getFieldsInJsonDifference(String newjson, String oldjson) throws Exception {		
		//LOG.info("*****	Received a call to ElsecoClaimsHelper - getFieldsInJsonDifference ");	
		List<String> dateFields = Arrays.asList("createdDate", "createddate", "checkedDate","createdDate","createdDateTime");
		
		List<JsonHandlerForAuditTrace> fields = new ArrayList<JsonHandlerForAuditTrace>();
		JSONObject oldjsonObj = new JSONObject(oldjson.trim().isEmpty()?"{}":oldjson);	            
        JSONObject newjsonObj = new JSONObject(newjson);
		if (newjsonObj instanceof JSONObject)
	        {			 			 	
	            String[] oldFields = JSONObject.getNames(oldjsonObj);
	            String[] newFields = JSONObject.getNames(newjsonObj);
	            
	            for (String newFieldName:newFields)
	            {		   
	            	if(oldFields!=null && oldFields.length>0) {
	            		for (String oldFieldName:oldFields) {	    
	            			String newFieldValue = String.valueOf(newjsonObj.get(newFieldName));
	            			String oldFieldValue = String.valueOf(oldjsonObj.get(oldFieldName));
	            			if (!dateFields.contains(newFieldName) 
	            					&& (newFieldName.equalsIgnoreCase(oldFieldName))
	            						&& (!newFieldValue.equals(oldFieldValue))
	            							&& isNotJsonArray(newFieldValue)) {
	            				JsonHandlerForAuditTrace trace = new JsonHandlerForAuditTrace();
	            				trace.setFieldName(String.valueOf(newFieldName));	            				
	            				trace.setNewValue(String.valueOf(newFieldValue));
	            				trace.setOldValue(String.valueOf(oldFieldValue));
	            				if(!newFieldValue.equals(oldFieldValue))	 {
	            					trace.setIsChanged("Y");
	            				}else {
	            					trace.setIsChanged("N");
	            				}
	            				fields.add(trace);
	            			}            		
	            		}
	            	}else {	            	    
            			String newFieldValue = String.valueOf(newjsonObj.get(newFieldName));
            			String oldFieldValue = "";
            			if (!dateFields.contains(newFieldName) 
            					&& (!newFieldValue.equals(oldFieldValue)) 
            							&& isNotJsonArray(newFieldValue)) {
            				JsonHandlerForAuditTrace trace = new JsonHandlerForAuditTrace();
            				trace.setFieldName(String.valueOf(newFieldName));
            				trace.setNewValue(String.valueOf(newFieldValue));
            				trace.setOldValue(String.valueOf(oldFieldValue));
            				if(!newFieldValue.equals(oldFieldValue))	 {
            					trace.setIsChanged("Y");
            				}else {
            					trace.setIsChanged("N");
            				}
            				fields.add(trace);
            			}           		
	            	}
	            }	           
	        }		
		 return fields;
	}
	
	/**
	 * 
	 * @param oldjson
	 * @param newjson
	 * @return
	 * @throws Exception
	 */
	private static List<JsonHandlerForAuditTrace> getAuditFields(String newjson, String oldjson) throws Exception {	
		//LOG.info("*****	Received a call to ElsecoClaimsHelper - getAuditFields ");	
		
		Resource resource = new ClassPathResource("jsonfields.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
		
		List<JsonHandlerForAuditTrace> fields = new ArrayList<JsonHandlerForAuditTrace>();
		JSONObject oldjsonObj = new JSONObject(oldjson.trim().isEmpty()?"{}":oldjson);	            
        JSONObject newjsonObj = new JSONObject(newjson);
		if (newjsonObj instanceof JSONObject){			 			 	
	            String[] oldFields = JSONObject.getNames(oldjsonObj);
	            String[] newFields = JSONObject.getNames(newjsonObj);
	            
	            for (String newFieldName:newFields)
	            {		   
	            	if(oldFields!=null && oldFields.length>0) {
	            		for (String oldFieldName:oldFields) {	    
	            			String newFieldValue = String.valueOf(newjsonObj.get(newFieldName));
	            			String oldFieldValue = String.valueOf(oldjsonObj.get(oldFieldName));
	            			if (newFieldName.equalsIgnoreCase(oldFieldName)  //&& (!newFieldValue.equals(oldFieldValue))	            					
	            						&& isNotJsonArray(newFieldValue)) {
	            				JsonHandlerForAuditTrace trace = new JsonHandlerForAuditTrace();
	            				trace.setAliasName(String.valueOf(newFieldName));
	            				trace.setFieldName(properties.get(String.valueOf(newFieldName))!=null?properties.get(String.valueOf(newFieldName)).toString():String.valueOf(newFieldName));	            				
	            				trace.setNewValue(String.valueOf(newFieldValue));
	            				trace.setOldValue(String.valueOf(oldFieldValue));
	            				if(!newFieldValue.equals(oldFieldValue))	 {
	            					trace.setIsChanged("Y");
	            				}else {
	            					trace.setIsChanged("N");
	            				}
	            				fields.add(trace);
	            			}            		
	            		}
	            	}else {	            	    
            			String newFieldValue = String.valueOf(newjsonObj.get(newFieldName));
            			String oldFieldValue = "";
            			//if (!newFieldValue.equals(oldFieldValue) && isNotJsonArray(newFieldValue)) {
            			if (isNotJsonArray(newFieldValue)) {
            				JsonHandlerForAuditTrace trace = new JsonHandlerForAuditTrace();
            				trace.setAliasName(String.valueOf(newFieldName));
            				trace.setFieldName(properties.get(String.valueOf(newFieldName))!=null?properties.get(String.valueOf(newFieldName)).toString():String.valueOf(newFieldName));
            				trace.setNewValue(String.valueOf(newFieldValue));
            				trace.setOldValue(String.valueOf(oldFieldValue));
            				if(!newFieldValue.equals(oldFieldValue))	 {
            					trace.setIsChanged("Y");
            				}else {
            					trace.setIsChanged("N");
            				}
            				fields.add(trace);
            			}           		
	            	}
	            }	           
	        }		
		 return fields;
	}
	
	/**
	 * Short abbr for the Section Names
	 * @param sectionName
	 * @return
	 */
	private String getShortSectionName(String sectionName) {
		/*if(sectionName!=null && !("").equals(sectionName)) {
			if(sectionName.equalsIgnoreCase(elsecoClaimsConstant.SECTION_HULL)) {
				return "H"; 
			}else if(sectionName.equalsIgnoreCase(elsecoClaimsConstant.SECTION_LIABILITY)) {
				return "L";
			}else if(sectionName.equalsIgnoreCase(elsecoClaimsConstant.SECTION_SPARES)) {
				return "S";
			}else if(sectionName.equalsIgnoreCase(elsecoClaimsConstant.SECTION_TLO)) {
				return "T";
			}else if(sectionName.equalsIgnoreCase(elsecoClaimsConstant.SECTION_AV52)) {
				return "A";
			}else if(sectionName.equalsIgnoreCase(elsecoClaimsConstant.SECTION_OTHER)) {
				return "O";
			}
		}*/		
		if(sectionName!=null && !("").equals(sectionName)) {
			return sectionName.substring(0, 1).toUpperCase();
		}
		return "";
	}
	
	/**
	 * 
	 * @param elsecoClaimTrans
	 * @return
	 */
	private ElsecoClaimsTransaction setApprovedAndRejectUrl(ElsecoClaimsTransaction elsecoClaimTrans) throws Exception {
		StringBuffer approveUrl = new StringBuffer();
		approveUrl.append("http://").append(elsecoClaimsConstant.CIMS_APPLICATION_DEPLOYED_IP).append(":")
				.append(elsecoClaimsConstant.CIMS_APPLICATION_DEPLOYED_PORT)
				.append(elsecoClaimsConstant.APPLICATION_SERVICES_CONTEXTPATH)
				.append(elsecoClaimsConstant.CIMS_STATUS_CHANGE_SERVICE);
		
		String memId = "";
		try {
			if(elsecoClaimTrans.getClaimsInternalRefInfo().get(0).getMemberInfo().get(0).getMemberId()!=0) {
				memId = ""+elsecoClaimTrans.getClaimsInternalRefInfo().get(0).getMemberInfo().get(0).getMemberResultsInfo().get(0).getMemberBpId();
			}
		}catch(Exception e) {
			memId = "0000";
		}	
		
		elsecoClaimTrans.setApproveUrl(approveUrl.toString().replace(elsecoClaimsConstant.PLACEHOLDER_OPERATION_HANDLE, elsecoClaimsConstant.APPLICATIONHANDLE)
				 			 .replace(elsecoClaimsConstant.PLACEHOLDER_USERBPID, ""+memId)
							 .replace(elsecoClaimsConstant.PLACEHOLDER_HEADERID, ""+elsecoClaimTrans.getClaimHeaderid())
							 .replace(elsecoClaimsConstant.PLACEHOLDER_DETAILID, ""+elsecoClaimTrans.getClaimid())
							 .replace(elsecoClaimsConstant.PLACEHOLDER_STATUSHANDLE, "approve"));
				
		StringBuffer rejectUrl = new StringBuffer();
		rejectUrl.append("http://").append(elsecoClaimsConstant.CIMS_APPLICATION_DEPLOYED_IP).append(":")
				.append(elsecoClaimsConstant.CIMS_APPLICATION_DEPLOYED_PORT)
				.append(elsecoClaimsConstant.APPLICATION_SERVICES_CONTEXTPATH)
				.append(elsecoClaimsConstant.CIMS_STATUS_CHANGE_SERVICE);
		
		elsecoClaimTrans.setRejectUrl(rejectUrl.toString().replace(elsecoClaimsConstant.PLACEHOLDER_OPERATION_HANDLE, elsecoClaimsConstant.APPLICATIONHANDLE)
								.replace(elsecoClaimsConstant.PLACEHOLDER_USERBPID, ""+memId)
								.replace(elsecoClaimsConstant.PLACEHOLDER_HEADERID, ""+elsecoClaimTrans.getClaimHeaderid())
								.replace(elsecoClaimsConstant.PLACEHOLDER_DETAILID, ""+elsecoClaimTrans.getClaimid())
								.replace(elsecoClaimsConstant.PLACEHOLDER_STATUSHANDLE, "reject"));
				
		return elsecoClaimTrans;
	}
	
	/**
	 * isNotValidClaim - Verify whether it is not a valid claim.
	 * 
	 * @param umrNo
	 * @param ucrNo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private boolean isNotValidClaim(String umrNo, String ucrNo) throws Exception {
		List<ElsecoClaimsHeader> headers = processDao.isClaimExistsWithUmrAndUcr(umrNo, ucrNo);
		if(headers!=null && headers.size()>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * isNotValidClaimsInfo - Verify whether it is not a valid claim.
	 *	 
	 * @return
	 * @throws Exception
	 */
	private boolean isNotValidClaimsInfo(ElsecoClaimsHeader newClaimsHeader) throws Exception {
		if(newClaimsHeader.getUcrNumber() == null || ("").equals(newClaimsHeader.getUcrNumber())){
			return true;
		}
		if(newClaimsHeader.getEventDateNotif() == null || ("").equals(newClaimsHeader.getEventDateNotif().toString())){
			return true;
		}
		if(newClaimsHeader.getEventId() == 0){
			return true;
		}	
		return false;
	}
	
	/**
	 * isNotValidTransInfo - Verify whether it is not a valid claims Transaction.
	 *	 
	 * @return
	 * @throws Exception
	 */
	private boolean isNotValidTransInfo(ElsecoClaimsTransaction newClaimsTrans) throws Exception {
		
		if(newClaimsTrans.getTransactionType() == null || ("").equals(newClaimsTrans.getTransactionType())){
			return true;
		}
		if((newClaimsTrans.getMarketTransRefNo() == null || ("").equals(newClaimsTrans.getMarketTransRefNo()))
			&& (newClaimsTrans.getPolicyTransRefNo() == null || ("").equals(newClaimsTrans.getPolicyTransRefNo()))){
			return true;
		}		
		if(newClaimsTrans.getTransactionType() != null && 
			!(newClaimsTrans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_INITIAL_ADVICE) 
				|| newClaimsTrans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_ADDITIONAL_INFORMATION) 
					|| newClaimsTrans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_UPDATE_RESERVE))) {
			if(newClaimsTrans.getTransactionCurrency() == null || ("").equals(newClaimsTrans.getTransactionCurrency())){
				LOG.info(" ERROR :: THERE IS NO  TX CURRENCY  ENTERED FOR  TX_TYPE = "+newClaimsTrans.getTransactionType());
				return true;
			}	
		}else if(newClaimsTrans.getTransactionType() != null && 
			(newClaimsTrans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_INITIAL_ADVICE) 
				|| newClaimsTrans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_ADDITIONAL_INFORMATION) 
					|| newClaimsTrans.getTransactionType().equals(elsecoClaimsConstant.TX_TYP_UPDATE_RESERVE))) {
					if(newClaimsTrans.getTransactionCurrency() == null || ("").equals(newClaimsTrans.getTransactionCurrency())){
						LOG.info(" NOTE :: SET LIMIT_CURRENCY_CODE TO  TX CURRENCY WHEN IT IS NOT ENTERED FOR  TX_TYPE = "+newClaimsTrans.getTransactionType());
						newClaimsTrans.setTransactionCurrency(newClaimsTrans.getLimitCurrencyCode());
					}	
		}
		
		return false;
	}
	
	
	/**
	 * isNotValidClaimCombo - Verify whether it is not a valid claim combination.
	 * 
	 * @param umrNo
	 * @param ucrNo
	 * @return
	 * @throws Exception
	 */
	private boolean isNotValidClaimCombo(String umrNo, String ucrNo, String extRefNo) throws Exception {
		CriteriaEntity criteriaEntity = new CriteriaEntity();
		criteriaEntity.setUcrNumber(ucrNo);
		criteriaEntity.setUmrNumber(umrNo);
		criteriaEntity.setExtRefNo(extRefNo);
		
		List<ElsecoClaimDetails> details = processDao.getClaimDetailBySearchCriteria(criteriaEntity);
		if(details!=null && details.size()>0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Reset the initial values so that new values get Set.
	 * @param inputAuditTrail
	 * @return
	 * @throws Exception
	 */
	private ElsecoClaimsAuditTrail reset(ElsecoClaimsAuditTrail inputAuditTrail) throws Exception{
		inputAuditTrail.setCrudEntityHandle("");						
		inputAuditTrail.setNewClobJson("");
		inputAuditTrail.setOldClobJson("");	
		inputAuditTrail.setUniqueId("");
		inputAuditTrail.setOperatorType("");
		return inputAuditTrail;
	}
	
	/**
	 * Check whether is an Json Array or not 
	 * 
	 * @param fieldValue
	 * @return
	 * @throws Exception
	 */
	private static boolean isNotJsonArray(String fieldValue) throws Exception {
		if (fieldValue != null && !("").equals(fieldValue)) {
			String firstChar = String.valueOf(fieldValue.charAt(0));
			if (firstChar.equalsIgnoreCase("[")) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param jsonObj
	 * @return
	 */
	private JSONObject removeJSONArray(JSONObject jsonObj) {
		JSONObject newJson = new JSONObject();
		
		Iterator<String> keys = jsonObj.keys();
        while(keys.hasNext()){
        	String currentKey = keys.next();
            Object aObj = jsonObj.get(currentKey);            
            if(! (aObj instanceof JSONArray)){            	 
            	newJson.put(currentKey, aObj);
            }
        }      
		return newJson;		
	}
}
