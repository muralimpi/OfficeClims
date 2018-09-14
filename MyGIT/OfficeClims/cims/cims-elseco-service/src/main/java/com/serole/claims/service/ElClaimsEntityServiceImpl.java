package com.serole.claims.service;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.AbstractProvider;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.serole.claims.core.claimsFactory.AbstractClaimsMgmtFactory;
import com.serole.claims.core.constants.AppConstants;
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
import com.serole.claims.model.exceptions.ElsecoClaimsServiceException;
import com.serole.claims.model.filterbeans.CriteriaEntity;
import com.serole.claims.service.factoryManager.ElsecoClaimsEntityManager;
import com.serole.claims.service.factoryManager.ElsecoClaimsFactoryManager;
import com.serole.claims.service.util.ElsecoClaimsUtil;

/**
 * A implementation Class at a service layer for the interface IElsecoAviationService
 * @author Serole_Vijay
 *
 */
@Component
public class ElClaimsEntityServiceImpl implements ElClaimsEntityService {
	private static final Logger LOG = LogManager.getLogger(ElClaimsEntityServiceImpl.class);
		
	@Autowired
	ElsecoClaimsHeader Clm;
	
	@Autowired
	AbstractClaimsMgmtFactory  abstractClaimsMgmtFactory;
	
	@Autowired
	ElsecoClaimsServiceException exceptions;
	
	@Autowired
	@Lazy
	ElsecoClaimsEntityManager entityClaimsManager;	
	
	@Autowired
	ElsecoClaimsConstant elsecoClaimsConstant;
	
	public ElClaimsEntityServiceImpl() {		
		if(abstractClaimsMgmtFactory == null) {
			abstractClaimsMgmtFactory = ElsecoClaimsFactoryManager.getFactory(AppConstants.ENTITY);
		}		
		if(entityClaimsManager == null) {
			entityClaimsManager = (ElsecoClaimsEntityManager) abstractClaimsMgmtFactory.getInstance();
		}
	}	
	
	/**
	 * A method to a Get all the ClaimHeader data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsHeader> getAllElsecoClaims() throws Exception {
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaims ");		
		return entityClaimsManager.getAllElsecoClaimHeader();
	}
	
	/**
	 * A method to a Get all the ClaimItems data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsItems> getAllElsecoClaimItems() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimItems ");		
		return entityClaimsManager.getAllElsecoClaimItems();
	}
	
	/**
	 * A method to a Get all the ClaimDetails data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimDetails> getAllElsecoClaimDetails() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimDetails ");		
		return entityClaimsManager.getAllElsecoClaimDetails();
	}	
	
	/**
	 * A method to a Get all the ClaimReserve data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimReserve> getAllElsecoClaimsReserve() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimsReserve ");		
		return entityClaimsManager.getAllElsecoClaimReserve();
	}	
	
	/**
	 * A method to a Get all the Claim Tasks data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsTasks> getAllElsecoClaimsTasks() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimsTasks ");		
		return entityClaimsManager.getAllElsecoClaimTasks();
	}	
	
	/**
	 * A method to a Get all the Claim Notes data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsNotes> getAllElsecoClaimNotes() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimNotes ");		
		return entityClaimsManager.getAllElsecoClaimNotes();
	}	
	
	/**
	 * A method to a Get all the Claim Notes data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsFile> getAllElsecoClaimFiles() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimNotes ");		
		return entityClaimsManager.getAllElsecoClaimFiles();
	}
	
	/**
	 * A method to a Get all the Claim Notes data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsTransaction> getAllElsecoClaimTransactions() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimNotes ");		
		return entityClaimsManager.getAllElsecoClaimTransactions();
	}
	
	/**
	 * A method to a Get all the Internal Reference data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsInternalReference> getAllElsecoClaimInternalReference() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimInternalReference ");		
		return entityClaimsManager.getAllElsecoInternalReference();
	}
	
	/**
	 * A method to a Get all the Member Info data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoMemberInfo> getAllElsecoMemberInfo() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoMemberInfo ");		
		return entityClaimsManager.getAllElsecoMemberInfo();
	}
	
	/**
	 * A method to a Get all the Member Result data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoMemberResult> getAllElsecoMemberResult() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoMemberResult ");		
		return entityClaimsManager.getAllElsecoMemberResult();
	}
	
	/**
	 * A method to a Get all the Member Risk code data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoMemberRiskcode> getAllElsecoMemberRiskcode() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoMemberRiskcode ");		
		return entityClaimsManager.getAllElsecoMemberRiskcode();
	}
	
	/**
	 * A method to a Get all the Claims Party data from JDBC Data Layer 
	 * @return
	 */
	public List<ElsecoClaimsParty> getAllElsecoClaimsParty() throws Exception{
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getAllElsecoClaimsParty ");		
		return entityClaimsManager.getAllElsecoClaimsParty();
	}
		
	/**
	 * A method to a Get a specific Claims based on its unique key from JDBC Data Layer 
	 * @return
	 * @throws JSONException 
	 */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public List<Object> getElsecoClaimsBySearchCriteria(JSONObject jsonObject) throws JSONException, Exception {
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getElsecoClaimsBySearchCriteria ");	
				
		List<Object> elsecoClaimsList = null;
		Map<String, String> propertyMap = null;
		ModelMapper modelMapper = new ModelMapper();
		
		if(jsonObject.has("tableMap")) {
			propertyMap = ElsecoClaimsUtil.getJsonAsMap(jsonObject.get("tableMap").toString());
		}		
		if(jsonObject.has("id")) {			
			propertyMap = ElsecoClaimsUtil.getJsonAsMap(jsonObject.toString());
		}		
		
		if (propertyMap instanceof Map) {
			if (elsecoClaimsConstant.CLAIM_HEADER.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsHeader elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsHeader.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimHeaderById(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_ITEMS.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsItems elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsItems.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimItemById(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_DETAIL.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimDetails elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimDetails.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimDetailById(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_RESERVE.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimReserve elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimReserve.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimReserveById(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_NOTES.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsNotes elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsNotes.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimNotesById(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_TASKS.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsTasks elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsTasks.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimTasksById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_FILES.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsFile elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsFile.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimFilesById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_TRANSACTIONS.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsTransaction elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsTransaction.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimTransactionById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_INTERNAL_REF.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsInternalReference elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsInternalReference.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoInternalRefById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_MEMBER_INFO.equals(jsonObject.getString("table").toString())) {
				ElsecoMemberInfo elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberInfo.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoMemberInfoById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_MEMBER_RESULT.equals(jsonObject.getString("table").toString())) {
				ElsecoMemberResult elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberResult.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoMemberResultById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE.equals(jsonObject.getString("table").toString())) {
				ElsecoMemberRiskcode elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberRiskcode.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoMemberRiskcode(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_RISKOBJ.equals(jsonObject.getString("table").toString())) {
				ElsecoRiskObject elsecoQueryObj = modelMapper.map(propertyMap, ElsecoRiskObject.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoRiskObjectById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_PARTY.equals(jsonObject.getString("table").toString())) {
				ElsecoClaimsParty elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsParty.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimsPartyById(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_CHECK_LIST.equals(jsonObject.getString("table").toString())) {
				ElsecoCheckList elsecoQueryObj = modelMapper.map(propertyMap, ElsecoCheckList.class);
				elsecoClaimsList = (List) entityClaimsManager.getElsecoClaimsCheckListById(elsecoQueryObj);
			}
		} else if (elsecoClaimsConstant.CLAIM_HEADER.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimHeader();
		} else if (elsecoClaimsConstant.CLAIM_ITEMS.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimItems();
		} else if (elsecoClaimsConstant.CLAIM_DETAIL.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimDetails();
		} else if (elsecoClaimsConstant.CLAIM_RESERVE.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimReserve();
		} else if (elsecoClaimsConstant.CLAIM_NOTES.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimNotes();
		} else if (elsecoClaimsConstant.CLAIM_TASKS.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimTasks();
		} else if (elsecoClaimsConstant.CLAIM_FILES.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimFiles();
		} else if (elsecoClaimsConstant.CLAIM_TRANSACTIONS.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimTransactions();
		} else if (elsecoClaimsConstant.CLAIM_INTERNAL_REF.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoInternalReference();
		} else if (elsecoClaimsConstant.CLAIM_MEMBER_INFO.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoMemberInfo();
		} else if (elsecoClaimsConstant.CLAIM_MEMBER_RESULT.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoMemberResult();
		} else if (elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoMemberRiskcode();
		} else if (elsecoClaimsConstant.CLAIM_RISKOBJ.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoRiskObject();
		} else if (elsecoClaimsConstant.CLAIM_PARTY.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllElsecoClaimsParty();
		}else if (elsecoClaimsConstant.CLAIM_CHECK_LIST.equals(jsonObject.getString("table").toString())) {
			elsecoClaimsList = (List) entityClaimsManager.getAllCheckList();
		}
		
		return elsecoClaimsList;
	}
		
	/**
	 A method to a Get all the ClaimDetails based on search criteria from Data Layer 
	 * @return 
	 */
	public Object getClaimDetailsBySearchCriteria(JSONObject jsonObject) throws Exception {
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getClaimDetailsBySearchCriteria ");
		
		Object elsecoClaims = null;
		Map<String, String> propertyMap = null;
		CriteriaEntity criteriaEntity = new CriteriaEntity();
		if (jsonObject.length() > 0) {			
			if (propertyMap instanceof Map) {
				ModelMapper modelMapper = new ModelMapper();
				criteriaEntity = modelMapper.map(propertyMap, CriteriaEntity.class);
				elsecoClaims = entityClaimsManager.getClaimDetailsBySearchCriteria(criteriaEntity);				
			}
			
			if (jsonObject.has("id")) {				
				if(jsonObject.getString("id")!=null) {
					criteriaEntity.setClaimHeaderId(Integer.valueOf(jsonObject.getString("id")));
				}
				elsecoClaims = entityClaimsManager.getClaimDetailsBySearchCriteria(criteriaEntity);
			}

		} else {
			elsecoClaims = entityClaimsManager.getClaimDetailsBySearchCriteria(criteriaEntity);
		}		
		return elsecoClaims;
	}
	
	/**
	 * 
	 */
	public Object getClaimBySearchCriteria(JSONObject jsonObject) throws Exception {
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - getClaimBySearchCriteria "+jsonObject);
		CriteriaEntity criteriaEntity = new CriteriaEntity();
		Map<String, String> propertyMap = null;
		if (jsonObject.length() > 0) {
			propertyMap = ElsecoClaimsUtil.getJsonAsMap(jsonObject.toString());
			if (propertyMap instanceof Map) {
				ModelMapper modelMapper = new ModelMapper();
				criteriaEntity = modelMapper.map(propertyMap, CriteriaEntity.class);				
			}
		}
		return entityClaimsManager.getClaimBySearchCriteria(criteriaEntity);		
	}
	
	/**
	 * A method to a add the Claims to the backend Database using jdbctemplate
	 * @return
	 * @throws Exception 
	 */
	public long addElsecoClaims(Map<String, Object> queryMap) throws Exception {
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - addElsecoClaims ");
		Map<String, String> propertyMap = null;
		ModelMapper modelMapper = new ModelMapper();
		if (queryMap.containsKey("tableMap")) {
			propertyMap = ElsecoClaimsUtil.getJsonMapToHashMap(queryMap.get("tableMap"));
		}

		if (propertyMap instanceof Map) {
			if (elsecoClaimsConstant.CLAIM_HEADER.equals(queryMap.get("table").toString())) {
				ElsecoClaimsHeader elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsHeader.class);
				return entityClaimsManager.insertElsecoClaimHeader(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_ITEMS.equals(queryMap.get("table").toString())) {
				ElsecoClaimsItems elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsItems.class);
				return entityClaimsManager.insertElsecoClaimItem(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_DETAIL.equals(queryMap.get("table").toString())) {
				ElsecoClaimDetails elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimDetails.class);
				return entityClaimsManager.insertElsecoClaimDetail(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_RESERVE.equals(queryMap.get("table").toString())) {
				ElsecoClaimReserve elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimReserve.class);
				return entityClaimsManager.insertElsecoClaimReserve(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_NOTES.equals(queryMap.get("table").toString())) {
				ElsecoClaimsNotes elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsNotes.class);
				return entityClaimsManager.insertElsecoClaimNotes(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_TASKS.equals(queryMap.get("table").toString())) {
				ElsecoClaimsTasks elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsTasks.class);
				return entityClaimsManager.insertElsecoClaimTasks(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_FILES.equals(queryMap.get("table").toString())) {
				ElsecoClaimsFile elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsFile.class);
				return entityClaimsManager.insertElsecoClaimFiles(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_TRANSACTIONS.equals(queryMap.get("table").toString())) {
						
				Provider<Timestamp> localTimestampProvider = new AbstractProvider<Timestamp>() {
			        @Override
			        public Timestamp get() {
			            return new Timestamp(System.currentTimeMillis());
			        }
			    };
			    modelMapper.createTypeMap(String.class, Timestamp.class);
				modelMapper.getTypeMap(String.class, Timestamp.class).setProvider(localTimestampProvider);
				/*
			    Provider<Date> localDateProvider = new AbstractProvider<Date>() {
			        @Override
			        public Date get() {
			        	long millis=System.currentTimeMillis();  
			            return new Date(millis);			           
			        }
			    };
			    modelMapper.createTypeMap(String.class, Date.class);
				modelMapper.getTypeMap(String.class, Date.class).setProvider(localDateProvider);
			    */
				
				ElsecoClaimsTransaction elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsTransaction.class);
				return entityClaimsManager.insertElsecoClaimsTransaction(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_RISKOBJ.equals(queryMap.get("table").toString())) {
				ElsecoRiskObject elsecoQueryObj = modelMapper.map(propertyMap, ElsecoRiskObject.class);
				return entityClaimsManager.insertElsecoRiskObject(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_INTERNAL_REF.equals(queryMap.get("table").toString())) {
				ElsecoClaimsInternalReference elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsInternalReference.class);
				return entityClaimsManager.insertElsecoInternalReference(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_MEMBER_INFO.equals(queryMap.get("table").toString())) {
				ElsecoMemberInfo elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberInfo.class);
				return entityClaimsManager.insertElsecoMemberInfo(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_MEMBER_RESULT.equals(queryMap.get("table").toString())) {
				ElsecoMemberResult elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberResult.class);
				return entityClaimsManager.insertElsecoMemberResult(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE.equals(queryMap.get("table").toString())) {
				ElsecoMemberRiskcode elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberRiskcode.class);
				return entityClaimsManager.insertElsecoMemberRiskcode(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_PARTY.equals(queryMap.get("table").toString())) {
				ElsecoClaimsParty elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsParty.class);
				return entityClaimsManager.insertElsecoClaimsParty(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_CHECK_LIST.equals(queryMap.get("table").toString())) {
				ElsecoCheckList elsecoQueryObj = modelMapper.map(propertyMap, ElsecoCheckList.class);
				return entityClaimsManager.insertElsecoClaimsCheckLis(elsecoQueryObj);
			}
		} 
		
		return 0;
	}
	
	/**
	 * A method to update the Claims in Database using jdbctemplate
	 * @return
	 */
	public void updateElsecoClaims(Map<String, Object> queryMap) throws Exception {
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - updateElsecoClaims ");		
		Map<String, String> propertyMap = null;
		ModelMapper modelMapper = new ModelMapper();
		if (queryMap.containsKey("tableMap")) {
			propertyMap = ElsecoClaimsUtil.getJsonMapToHashMap(queryMap.get("tableMap"));
		}
		
		if (propertyMap instanceof Map) {
			if (elsecoClaimsConstant.CLAIM_HEADER.equals(queryMap.get("table").toString())) {
				ElsecoClaimsHeader elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsHeader.class);
				entityClaimsManager.updateElsecoClaimHeader(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_ITEMS.equals(queryMap.get("table").toString())) {
				ElsecoClaimsItems elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsItems.class);
				entityClaimsManager.updateElsecoClaimItem(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_DETAIL.equals(queryMap.get("table").toString())) {
				ElsecoClaimDetails elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimDetails.class);
				entityClaimsManager.updateElsecoClaimDetail(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_RESERVE.equals(queryMap.get("table").toString())) {
				ElsecoClaimReserve elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimReserve.class);
				entityClaimsManager.updateElsecoClaimReserve(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_NOTES.equals(queryMap.get("table").toString())) {
				ElsecoClaimsNotes elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsNotes.class);
				entityClaimsManager.updateElsecoClaimNotes(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_TASKS.equals(queryMap.get("table").toString())) {
				ElsecoClaimsTasks elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsTasks.class);
				entityClaimsManager.updateElsecoClaimTasks(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_FILES.equals(queryMap.get("table").toString())) {
				ElsecoClaimsFile elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsFile.class);
				entityClaimsManager.updateElsecoClaimFiles(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_TRANSACTIONS.equals(queryMap.get("table").toString())) {
				ElsecoClaimsTransaction elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsTransaction.class);
				entityClaimsManager.updateElsecoClaimsTransaction(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_RISKOBJ.equals(queryMap.get("table").toString())) {
				ElsecoRiskObject elsecoQueryObj = modelMapper.map(propertyMap, ElsecoRiskObject.class);
				entityClaimsManager.updateElsecoRiskObject(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_INTERNAL_REF.equals(queryMap.get("table").toString())) {
				ElsecoClaimsInternalReference elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsInternalReference.class);
				entityClaimsManager.updateElsecoInternalReference(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_MEMBER_INFO.equals(queryMap.get("table").toString())) {
				ElsecoMemberInfo elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberInfo.class);
				entityClaimsManager.updateElsecoMemberInfo(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_MEMBER_RESULT.equals(queryMap.get("table").toString())) {
				ElsecoMemberResult elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberResult.class);
				entityClaimsManager.updateElsecoMemberResult(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE.equals(queryMap.get("table").toString())) {
				ElsecoMemberRiskcode elsecoQueryObj = modelMapper.map(propertyMap, ElsecoMemberRiskcode.class);
				entityClaimsManager.updateElsecoMemberRiskcode(elsecoQueryObj);
			} else if (elsecoClaimsConstant.CLAIM_PARTY.equals(queryMap.get("table").toString())) {
				ElsecoClaimsParty elsecoQueryObj = modelMapper.map(propertyMap, ElsecoClaimsParty.class);
				entityClaimsManager.updateElsecoClaimsParty(elsecoQueryObj);
			}else if (elsecoClaimsConstant.CLAIM_CHECK_LIST.equals(queryMap.get("table").toString())) {
				ElsecoCheckList elsecoQueryObj = modelMapper.map(propertyMap, ElsecoCheckList.class);
				entityClaimsManager.updateElsecoClaimsCheckList(elsecoQueryObj);
			}
		}
	}
	
	/**
	 * A method to delete the Claims from Data Layer using jdbctemplate
	 * @return
	 */
	public void deleteElsecoClaims(String table, int primaryId)  throws Exception {
		LOG.debug("*****	Received a call to ElClaimsEntityServiceImpl - deleteElsecoClaims ");	
		if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_HEADER)) {
			entityClaimsManager.deleteElsecoClaimsHeader(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_ITEMS)) {
			entityClaimsManager.deleteElsecoClaimsItem(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_DETAIL)) {
			entityClaimsManager.deleteElsecoClaimDetail(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_RESERVE)) {
			entityClaimsManager.deleteElsecoClaimsReserve(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_NOTES)) {
			entityClaimsManager.deleteElsecoClaimsNotes(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_TASKS)) {
			entityClaimsManager.deleteElsecoClaimsTasks(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_FILES)) {
			entityClaimsManager.deleteElsecoClaimsFiles(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_TRANSACTIONS)) {
			entityClaimsManager.deleteElsecoClaimsTransaction(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_RISKOBJ)) {
			entityClaimsManager.deleteElsecoRiskObject(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_INTERNAL_REF)) {
			entityClaimsManager.deleteElsecoInternalReference(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_MEMBER_INFO)) {
			entityClaimsManager.deleteElsecoMemberInfo(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_MEMBER_RESULT)) {
			entityClaimsManager.deleteElsecoMemberResult(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE)) {
			entityClaimsManager.deleteElsecoMemberRiskcode(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_PARTY)) {
			entityClaimsManager.deleteElsecoClaimsParty(primaryId);
		}else if(table!=null && table.equals(elsecoClaimsConstant.CLAIM_CHECK_LIST)) {
			entityClaimsManager.deleteElsecoClaimsCheckList(primaryId);
		}				
	}	
				
}
