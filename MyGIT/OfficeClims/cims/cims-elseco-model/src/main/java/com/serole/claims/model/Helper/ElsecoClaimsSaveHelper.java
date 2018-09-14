package com.serole.claims.model.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import com.google.gson.Gson;
import com.serole.claims.model.Dao.ElClaimsEntityRepository;
import com.serole.claims.model.Dao.ElClaimsProcessRepository;
import com.serole.claims.model.Elseco.ElsecoClaimDetails;
import com.serole.claims.model.Elseco.ElsecoClaimReserve;
import com.serole.claims.model.Elseco.ElsecoClaimsAuditTrail;
import com.serole.claims.model.Elseco.ElsecoClaimsFile;
import com.serole.claims.model.Elseco.ElsecoClaimsHeader;
import com.serole.claims.model.Elseco.ElsecoClaimsInternalReference;
import com.serole.claims.model.Elseco.ElsecoClaimsItems;
import com.serole.claims.model.Elseco.ElsecoClaimsNotes;
import com.serole.claims.model.Elseco.ElsecoClaimsTransaction;
import com.serole.claims.model.Elseco.ElsecoMemberInfo;
import com.serole.claims.model.Elseco.ElsecoMemberResult;
import com.serole.claims.model.Elseco.ElsecoMemberRiskcode;
import com.serole.claims.model.Elseco.ElsecoRiskObject;
import com.serole.claims.model.constants.ElsecoClaimsConstant;
import com.serole.claims.model.json.JsonHandlerForAuditTrace;
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;



/**
 * a helper class that acts as a delegate between the Claims Manager and the Data Layer.
 * Here Data Layer is invoked in two ways - Using Spring JDBCTemplate and Another is Making use of a JPARespository 
 * 
 * @author Serole_Vijay
 *
 */
@Component
public class ElsecoClaimsSaveHelper {
	
	private static final Logger LOG = LoggerFactory.getLogger(ElsecoClaimsSaveHelper.class);
	
	@Autowired
	ElClaimsEntityRepository entityDao;
	
	@Autowired
	ElClaimsProcessRepository processDao;

	@Autowired
	ElsecoClaimsConstant elsecoClaimsConstant;
	
	JSONObject newHeaderInfoObj= null;
	JSONArray newDetailInfoObj = null;
	JSONArray newRiskInfoObj = null;
	JSONArray newMarketTransInfoObj = null;
	JSONArray newPolicyTransInfoObj = null;
	JSONArray newIntRefObj = null;
	JSONArray newMemInfoIntReflObj = null;
	JSONArray newMemRestIntRefObj = null;
	JSONObject newMemRiskIntRefObj = null;
	JSONArray newMemInfoDtlObj = null;
	JSONArray newMemRestDtlObj = null;
	JSONObject newMemRiskDtlObj = null;	

	JSONObject oldHeaderInfoObj= null;
	JSONArray oldDetailInfoObj = null;
	JSONArray oldRiskInfoObj = null;
	JSONArray oldMarketTransInfoObj = null;
	JSONArray oldPolicyTransInfoObj = null;
	JSONArray oldIntRefObj = null;
	JSONArray oldMemInfoIntReflObj = null;
	JSONArray oldMemRestIntRefObj = null;
	JSONObject oldMemRiskIntRefObj = null;
	JSONArray oldMemInfoDtlObj = null;
	JSONArray oldMemRestDtlObj = null;
	JSONObject oldMemRiskDtlObj = null;	
	
	ElsecoClaimDetails[] newClaimDetail = null;
	ElsecoClaimReserve newClaimReserve = null;
	ElsecoClaimsFile newClaimFile = null;
	ElsecoClaimsHeader newClaimHeader = null;
	ElsecoClaimsInternalReference[] newClaimIntRef = null;
	ElsecoClaimsItems newClaimItem = null;
	ElsecoClaimsNotes newClaimNotes = null;
	ElsecoClaimsTransaction[] newMarketTrans = null;
	ElsecoClaimsTransaction[] newPolicyTrans = null;
	ElsecoMemberInfo[] newIntRefMemInfo = null;
	ElsecoMemberResult[] newIntRefMemResult = null;
	ElsecoMemberRiskcode newIntRefMemRiskcode = null;
	ElsecoMemberInfo[] newDtlMemInfo = null;
	ElsecoMemberResult[] newDtlMemResult = null;
	ElsecoMemberRiskcode newDtlMemRiskcode = null;
	ElsecoRiskObject [] newRiskObj = null;

	List<Object> oldClaimDetail = null;
	ElsecoClaimReserve oldClaimReserve = null;
	ElsecoClaimsFile oldClaimFile = null;
	ElsecoClaimsHeader oldClaimHeader = null;
	List<Object> oldClaimIntRef = null;
	ElsecoClaimsItems oldClaimItem = null;
	ElsecoClaimsNotes oldClaimNotes = null;
	List<Object> oldMarketTrans = null;
	List<Object> oldPolicyTrans = null;
	List<Object> oldIntRefMemInfo = null;
	List<Object> oldIntRefMemResult = null;
	ElsecoMemberRiskcode oldIntRefMemRiskcode = null;
	ElsecoMemberInfo[] oldDtlMemInfo = null;
	ElsecoMemberResult[] oldDtlMemResult = null;
	ElsecoMemberRiskcode oldDtlMemRiskcode = null;
	ElsecoRiskObject [] oldRiskObj = null;
	
	ModelMapper modelMapper = new ModelMapper();
	//ObjectMapper objectMapper = new ObjectMapper();
	 //Gson googleJson = new Gson();
	/**
	 * Save the complete JSON structure from UI
	 * @param saveClaims
	 * @return
	 */
	@Transactional 
	public int saveClaims(JsonHandlerForWorklistAndSaveClaims newClaims, JsonHandlerForWorklistAndSaveClaims oldClaims, ElsecoClaimsAuditTrail auditTrail) throws Exception {
		populateEachHandlerFromNewJson(newClaims);
		populateEachHandlerFromOldJson(oldClaims);
		
		return 0;
	}
		
	/**
	 * 
	 * @param newClaims
	 */
	private void populateEachHandlerFromNewJson(JsonHandlerForWorklistAndSaveClaims newClaims) {	
			LOG.info("*****	Received a call to ElsecoClaimsSaveHelper - populateEachHandlerFromNewJson ");	
			newHeaderInfoObj= new JSONObject(newClaims);
			newClaimHeader = modelMapper.map(newClaims, ElsecoClaimsHeader.class);
			
			@SuppressWarnings("rawtypes")
		    Iterator keys = newHeaderInfoObj.keys();
		    while (keys.hasNext()) {
		        String key = (String) keys.next();
		        if (key.equals("claimDetailsInfo")) {
		        	newDetailInfoObj = newHeaderInfoObj.getJSONArray("claimDetailsInfo");
		        	LOG.info("claimDetailsInfo "+ newDetailInfoObj.toString() );
		        	//newClaimDetail = objectMapper.readValue(newDetailInfoObj, ElsecoClaimDetails[].class);
		        	//newClaimDetail = newDetailInfoObj.toList();
		        	
		        	
		        	 ArrayList javaArrayListFromGSON = null;//googleJson.fromJson(newDetailInfoObj.toString(), ArrayList.class);
		        	 LOG.info("claimDetailsInfo -  javaArrayListFromGSON"+ javaArrayListFromGSON.toString() );
		        }
		        if (key.equals("marketTransactionsInfo")) {
		        	newMarketTransInfoObj = newHeaderInfoObj.getJSONArray("marketTransactionsInfo");
		        	LOG.info("marketTransactionsInfo "+ newMarketTransInfoObj.toString() );		        	
		        	//newMarketTrans = newMarketTransInfoObj.toList();
		        	
		        }
		        if (key.equals("claimRiskInfo")) {
		        	newRiskInfoObj = newHeaderInfoObj.getJSONArray("claimRiskInfo");
		        	LOG.info("claimRiskInfo "+ newRiskInfoObj.toString() );
		        	//newRiskObj = newRiskInfoObj.toList();
		        }        
		    }
		   
		    for (int i = 0; i < newDetailInfoObj.length(); i++) {
                JSONObject claimDetail = (JSONObject) newDetailInfoObj.get(i);
                Iterator<String> detailKeys = claimDetail.keys();
                
			    while (detailKeys.hasNext()) {
			        String key = (String) detailKeys.next(); 
			        if (key.equals("policyTransactionsInfo")) {
			        	newPolicyTransInfoObj = claimDetail.getJSONArray("policyTransactionsInfo");
			        	LOG.info("policyTransactionsInfo"+ newPolicyTransInfoObj.toString() );
			        	//newPolicyTrans = newPolicyTransInfoObj.toList();
			        	
			        	 for (int j = 0; j < newPolicyTransInfoObj.length(); j++) {
			        		JSONObject policyTrans = (JSONObject) newPolicyTransInfoObj.get(j);
			        		newIntRefObj = policyTrans.getJSONArray("claimsInternalRef");					       	
					       	LOG.info("claimsInternalRef"+ newIntRefObj.toString() );
					       //	newClaimIntRef = newIntRefObj.toList();
					       	
					       	for (int k = 0; k < newIntRefObj.length(); k++) {					       		
					       		JSONObject intRef = (JSONObject) newIntRefObj.get(k);
					       		newMemInfoIntReflObj = intRef.getJSONArray("memberInfo");		
						       	LOG.info("memberInfo"+ newMemInfoIntReflObj.toString() );
						      // 	newIntRefMemInfo = newMemInfoIntReflObj.toList();
						       	
						       	for (int l = 0; l < newMemInfoIntReflObj.length(); l++) {	
						    		JSONObject memInfoIntRef = (JSONObject) newMemInfoIntReflObj.get(l);
						    		newMemRestIntRefObj = memInfoIntRef.getJSONArray("memberResults");					        	
						        	LOG.info("memberResults"+ newMemRestIntRefObj.toString() );
						        //	newIntRefMemResult = newMemRestIntRefObj.toList();
						        	
						        	for (int m = 0; m < newMemRestIntRefObj.length(); m++) {	
						        		JSONObject newMemRest = (JSONObject) newMemRestIntRefObj.get(m);							       					        	
							        	LOG.info("Each memberResults"+ newMemRest.toString() );							        	
							        	newMemRiskIntRefObj = (JSONObject) newMemRest.get("memberRiskCodeInfo");			        	
							        	LOG.info("memberRiskCodeInfo"+ newMemRiskIntRefObj.toString() );							        	
							        	newIntRefMemRiskcode = modelMapper.map(newMemRiskIntRefObj, ElsecoMemberRiskcode.class);
							        }						        	
						        }					       
					       	}
					    }			        	 
			        } 
			        
			        if (key.equals("memberInfo")) {
			        	newMemInfoDtlObj = claimDetail.getJSONArray("memberInfo");
			        	LOG.info("memberInfo"+ newMemInfoDtlObj.toString() );
			        //	newDtlMemInfo = newMemInfoDtlObj.toList();
			        	
			         	for (int l = 0; l < newMemInfoDtlObj.length(); l++) {	
				    		JSONObject memInfoDtl = (JSONObject) newMemInfoDtlObj.get(l);
				    		newMemRestDtlObj = memInfoDtl.getJSONArray("memberResults");					        	
				        	LOG.info("memberResults"+ newMemRestDtlObj.toString() );
				        //	newDtlMemResult = newMemRestDtlObj.toList();
				        	
				        	for (int m = 0; m < newMemRestDtlObj.length(); m++) {	
				        		JSONObject newMemRest = (JSONObject) newMemRestIntRefObj.get(m);							       					        	
					        	LOG.info("Each memberResults"+ newMemRest.toString() );							        	
					        	newMemRiskDtlObj = (JSONObject) newMemRest.get("memberRiskCodeInfo");			        	
					        	LOG.info("memberRiskCodeInfo"+ newMemRiskDtlObj.toString() );
					        	newDtlMemRiskcode = modelMapper.map(newMemRiskDtlObj, ElsecoMemberRiskcode.class);
					        }						        	
				        }
			        }
			    }
		    }	
	}
	
	/**
	 * 
	 * @param oldClaims
	 */
	private void populateEachHandlerFromOldJson(JsonHandlerForWorklistAndSaveClaims oldClaims) {	
		LOG.info("*****	Received a call to ElsecoClaimsSaveHelper - populateEachHandlerFromOldJson ");	
		oldHeaderInfoObj= new JSONObject(oldClaims);
		oldClaimHeader = modelMapper.map(oldClaims, ElsecoClaimsHeader.class);
		
		@SuppressWarnings("rawtypes")
	    Iterator keys = oldHeaderInfoObj.keys();
	    while (keys.hasNext()) {
	        String key = (String) keys.next();
	        if (key.equals("claimDetailsInfo")) {
	        	oldDetailInfoObj = oldHeaderInfoObj.getJSONArray("claimDetailsInfo");
	        	LOG.info("claimDetailsInfo "+ oldDetailInfoObj.toString() );
	        	//oldClaimDetail = oldDetailInfoObj.toList();
	        }
	        if (key.equals("marketTransactionsInfo")) {
	        	oldMarketTransInfoObj = oldHeaderInfoObj.getJSONArray("marketTransactionsInfo");
	        	LOG.info("marketTransactionsInfo "+ oldMarketTransInfoObj.toString() );		        	
	        	//oldMarketTrans = oldMarketTransInfoObj.toList();
	        	
	        }
	        if (key.equals("claimRiskInfo")) {
	        	oldRiskInfoObj = oldHeaderInfoObj.getJSONArray("claimRiskInfo");
	        	LOG.info("claimRiskInfo "+ oldRiskInfoObj.toString() );
	        	//oldRiskObj = oldRiskInfoObj.toList();
	        }        
	    }
	   
	    for (int i = 0; i < oldDetailInfoObj.length(); i++) {
            JSONObject claimDetail = (JSONObject) oldDetailInfoObj.get(i);
            Iterator<String> detailKeys = claimDetail.keys();
            
		    while (detailKeys.hasNext()) {
		        String key = (String) detailKeys.next(); 
		        if (key.equals("policyTransactionsInfo")) {
		        	oldPolicyTransInfoObj = claimDetail.getJSONArray("policyTransactionsInfo");
		        	LOG.info("policyTransactionsInfo"+ oldPolicyTransInfoObj.toString() );
		        	//oldPolicyTrans = oldPolicyTransInfoObj.toList();
		        	
		        	 for (int j = 0; j < oldPolicyTransInfoObj.length(); j++) {
		        		JSONObject policyTrans = (JSONObject) oldPolicyTransInfoObj.get(j);
		        		oldIntRefObj = policyTrans.getJSONArray("claimsInternalRef");					       	
				       	LOG.info("claimsInternalRef"+ oldIntRefObj.toString() );
				       //	oldClaimIntRef = oldIntRefObj.toList();
				       	
				       	for (int k = 0; k < oldIntRefObj.length(); k++) {					       		
				       		JSONObject intRef = (JSONObject) oldIntRefObj.get(k);
				       		oldMemInfoIntReflObj = intRef.getJSONArray("memberInfo");		
					       	LOG.info("memberInfo"+ oldMemInfoIntReflObj.toString() );
					       //	oldIntRefMemInfo = oldMemInfoIntReflObj.toList();
					       	
					       	for (int l = 0; l < oldMemInfoIntReflObj.length(); l++) {	
					    		JSONObject memInfoIntRef = (JSONObject) oldMemInfoIntReflObj.get(l);
					    		oldMemRestIntRefObj = memInfoIntRef.getJSONArray("memberResults");					        	
					        	LOG.info("memberResults"+ oldMemRestIntRefObj.toString() );
					        //	oldIntRefMemResult = oldMemRestIntRefObj.toList();
					        	
					        	for (int m = 0; m < oldMemRestIntRefObj.length(); m++) {	
					        		JSONObject oldMemRest = (JSONObject) oldMemRestIntRefObj.get(m);							       					        	
						        	LOG.info("Each memberResults"+ oldMemRest.toString() );							        	
						        	oldMemRiskIntRefObj = (JSONObject) oldMemRest.get("memberRiskCodeInfo");			        	
						        	LOG.info("memberRiskCodeInfo"+ oldMemRiskIntRefObj.toString() );							        	
						        //	oldIntRefMemRiskcode = modelMapper.map(oldMemRiskIntRefObj, ElsecoMemberRiskcode.class);
						        }						        	
					        }					       
				       	}
				    }			        	 
		        } 
		        
		        if (key.equals("memberInfo")) {
		        	oldMemInfoDtlObj = claimDetail.getJSONArray("memberInfo");
		        	LOG.info("memberInfo"+ oldMemInfoDtlObj.toString() );
		        //	oldDtlMemInfo = oldMemInfoDtlObj.toList();
		        	
		         	for (int l = 0; l < oldMemInfoDtlObj.length(); l++) {	
			    		JSONObject memInfoDtl = (JSONObject) oldMemInfoDtlObj.get(l);
			    		oldMemRestDtlObj = memInfoDtl.getJSONArray("memberResults");					        	
			        	LOG.info("memberResults"+ oldMemRestDtlObj.toString() );
			       // 	oldDtlMemResult = oldMemRestDtlObj.toList();
			        	
			        	for (int m = 0; m < oldMemRestDtlObj.length(); m++) {	
			        		JSONObject oldMemRest = (JSONObject) oldMemRestIntRefObj.get(m);							       					        	
				        	LOG.info("Each memberResults"+ oldMemRest.toString() );							        	
				        	oldMemRiskDtlObj = (JSONObject) oldMemRest.get("memberRiskCodeInfo");			        	
				        	LOG.info("memberRiskCodeInfo"+ oldMemRiskDtlObj.toString() );
				      //  	oldDtlMemRiskcode = modelMapper.map(oldMemRiskDtlObj, ElsecoMemberRiskcode.class);
				        }						        	
			        }
		        }
		    }
	    }	
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
	 * A method to a add the Audit Trail to the backend Database
	 * 
	 * @param auditTrail
	 * @return
	 */
	public long addAuditTrail(ElsecoClaimsAuditTrail auditTrail) throws Exception{
		LOG.info("*****	Received a call to ElsecoClaimsHelper - addAuditTrail");		
		return entityDao.insertAuditTrail(auditTrail);
	}
	
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
            LOG.info("Instance of JSONObject::   "+names+" \t "+names2);            
            if (names.length != names2.length)
            {
            	throw new Exception("Invalid JSON - Number of fields are different in both the Json for \'"+entity+"\'");
                //return false;
            }

            for (String fieldName:names)
            {
            	
                Object obj1FieldValue = jsonObj1.get(fieldName);
                Object obj2FieldValue = jsonObj2.get(fieldName);
                LOG.info("Instance of JSONObject::  fieldName:: "+fieldName+"  ::  "+obj1FieldValue.toString()+"  :.:.:  "+obj2FieldValue.toString());
                if (!jsonCompare(obj1FieldValue, obj2FieldValue, entity, isChanged, isAdded, isDeleted))
                {
                    //return false;
                	isChanged = true;
                }
            }
        }
        else if (obj1 instanceof JSONArray)
        {
        	LOG.info("Instance of JSONArray::  obj1:: "+obj1);
        	
            JSONArray obj1Array = (JSONArray) obj1;
            JSONArray obj2Array = (JSONArray) obj2;
            LOG.info("Instance of JSONArray::  obj1Array:: "+obj1Array);
            LOG.info("Instance of JSONArray::  obj2Array:: "+obj2Array);
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
            	LOG.info("Fields are not equal : "+obj1+ " <><><> "+obj2);
                //return false;
            	isChanged = true;
            }
        }

        return true;
    }
	
	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	private static Map<String, List<Object>> jsonDiff(Object obj1, Object obj2, String entity) throws Exception {	
		//LOG.info("*****	Received a call to ElsecoClaimsHelper - jsonDiff");
		Map<String, List<Object>> mp = new HashMap<String, List<Object>>();
		 if (obj1 instanceof JSONObject)
	        {
	            JSONObject jsonObj1 = (JSONObject) obj1;
	            JSONObject jsonObj2 = (JSONObject) obj2;
	            String[] names = JSONObject.getNames(jsonObj1);
	            String[] names2 = JSONObject.getNames(jsonObj1);
	            //LOG.info("Instance of JSONObject::   "+names+" \t "+names2);            
	            if (names.length != names2.length)
	            {
	            	throw new Exception("Invalid JSON - Number of fields are different in both the Json for \'"+entity+"\'");	            
	            }

	            for (String fieldName:names)
	            {	     
	            	//LOG.info("           jsonObj1::"+jsonObj1.toString()    );
	            	//LOG.info("           jsonObj2::"+jsonObj2.toString()    );
	                Object obj1FieldValue = jsonObj1.get(fieldName);
	                Object obj2FieldValue = jsonObj2.get(fieldName);
	              
	                if (!obj1FieldValue.equals(obj2FieldValue))
	                {
	                	//LOG.info("Fields are not equal : "+obj1FieldValue+ " <><><> "+obj2FieldValue+" == "+fieldName);
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
		//LOG.info("-------------- In saveEntityAndAuditForAnObject ----------------"+entity);
		//Map<String, List<Object>> mpElmts = jsonDiff(new JSONObject(newClaims), new JSONObject(oldClaims), entity);
		//ElsecoClaimsAuditTrail auditTrail = new ElsecoClaimsAuditTrail();
		//BeanUtils.copyProperties(inputAuditTrail, auditTrail);
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
				
			
			if (entity.equals(elsecoClaimsConstant.CLAIM_ITEMS)) {
				ElsecoClaimsItems claimItems = (ElsecoClaimsItems) newClaims;				
				if (claimItems.getClaimItemId() > 0	&& entityDao.isClaimsTransactionExists(claimItems.getClaimItemId())) {
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
				}
			}	
			
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
			
			if (entity.equals(elsecoClaimsConstant.CLAIM_MEMBER_RESULT)) {
				ElsecoMemberResult memberResult = (ElsecoMemberResult) newClaims;				
				if (memberResult.getResultId() > 0	&& entityDao.isMemberInfoExists(memberResult.getResultId())) {
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
				if (memberRiskcode.getLlRiskCodeId() > 0	&& entityDao.isMemberInfoExists(memberRiskcode.getLlRiskCodeId())) {
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
			
			List<JsonHandlerForAuditTrace> differenceList =  getFieldsInJsonDifference(new JSONObject(newClaims).toString(), new JSONObject(oldClaims).toString());
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
	 * 
	 * @param oldjson
	 * @param newjson
	 * @return
	 * @throws Exception
	 */
	private static List<JsonHandlerForAuditTrace> getFieldsInJsonDifference(String newjson, String oldjson) throws Exception {	
		LOG.info("*****	Received a call to ElsecoClaimsHelper - getFieldsInJsonDifference: ");				
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
	            			if (newFieldName.equalsIgnoreCase(oldFieldName)
	            					&& (!newFieldValue.equals(oldFieldValue))) {
	            				JsonHandlerForAuditTrace trace = new JsonHandlerForAuditTrace();
	            				trace.setFieldName(String.valueOf(newFieldName));
	            				trace.setNewValue(String.valueOf(newFieldValue));
	            				trace.setOldValue(String.valueOf(oldFieldValue));
	            				fields.add(trace);
	            			}            		
	            		}
	            	}else {	            	    
            			String newFieldValue = String.valueOf(newjsonObj.get(newFieldName));
            			String oldFieldValue = "";
            			if (!newFieldValue.equals(oldFieldValue)) {
            				JsonHandlerForAuditTrace trace = new JsonHandlerForAuditTrace();
            				trace.setFieldName(String.valueOf(newFieldName));
            				trace.setNewValue(String.valueOf(newFieldValue));
            				trace.setOldValue(String.valueOf(oldFieldValue));
            				fields.add(trace);
            			}           		
	            	}
	            }	           
	        }		
		 return fields;
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
}
