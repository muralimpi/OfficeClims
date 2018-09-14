package com.serole.claims.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.serole.claims.core.config.AbstractClaimsController;
import com.serole.claims.model.Elseco.ElsecoClaimsAuditTrail;
import com.serole.claims.model.constants.ElsecoClaimsConstant;
import com.serole.claims.model.exceptions.ElsecoClaimsServiceException;
import com.serole.claims.model.json.JsonHandlerForIncident;
import com.serole.claims.model.json.JsonHandlerForNavigation;
import com.serole.claims.model.json.JsonHandlerForSaveUcrExtRef;
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;
import com.serole.claims.model.json.UserInfo;
import com.serole.claims.model.rfc.hybris.ElsecoClaimsHybrisResponse;
import com.serole.claims.model.rfc.hybris.ElsecoCrmPqm;
import com.serole.claims.service.ElClaimsEntityService;
import com.serole.claims.service.ElClaimsProcessService;
import com.serole.claims.service.ElClaimsRFCClientService;
import com.serole.claims.service.exception.ExceptionResponse;
import com.serole.claims.service.exception.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;


@RestController
@Api(value = "Elseco Claims Service", description = "Services For Elseco Claims and Incident Management System", tags = { "Elseco Claims Service" })
@ComponentScan(basePackages="com.serole.*")
class ElsecoClaimsController extends AbstractClaimsController{
	private final Logger LOG = LogManager.getLogger(ElsecoClaimsController.class);
			
	@Autowired
	public ElClaimsEntityService service;
	
	@Autowired
	public ElClaimsProcessService lookupService;
	
	@Autowired
	public ElClaimsRFCClientService sapRFCService;
		
	@Autowired
	ElsecoClaimsConstant elsecoClaimsConstant;
		        
    /**
     * ClaimsBySearchCriteria -  Claims on Search Criteria
     * 
     * @param queryMap
     * @return
     */
    @ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Object.class, responseContainer = "Object", value = "getClaimsBySearchCriteria")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)       
    @PostMapping("/claimsWorklist")
	public Object getClaimsBySearchCriteria(@RequestBody(required=false) Map<String, Object> queryMap) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/claimsWorklist/    "+queryMap);
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		List<?> claimsobj = null;
		
		try {
			if(queryMap==null) {
				JSONObject jsonObject = new JSONObject();				
				claimsobj = (List<?>) service.getClaimBySearchCriteria(jsonObject);
			}			
			
			if (queryMap != null && queryMap instanceof Map) {
				JSONObject jsonObject = new JSONObject(queryMap);				
				 claimsobj = (List<?>) service.getClaimBySearchCriteria(jsonObject);		
			}	
			if(claimsobj==null || claimsobj.size()==0) {
				exceptionResponse.setErrorCode("NO RESULTS FOUND");
				exceptionResponse.setErrorMessage("No Results are Found with the given Search Criteria");
				return exceptionResponse;
			}
		} catch (ResourceNotFoundException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("NO RESULTS FOUND");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		} catch (JSONException e) {
			LOG.error(e.toString());
		} catch (Exception e) {
			LOG.error(e.toString());
		}		
		return claimsobj;
	}
    
    /**
     * A method to handle the Delete Operation 
     * 
     * @param ids
     * @return
     */
    @GetMapping("/claimsSearch/{id}")
	public Map<String, Object> getClaimsBySearchCriteriaById(@PathVariable(required = false) String id) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/claimsSearch/{"+id+"}");
		Object elsecoClaims = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (id == null || "".equals(id)) {
				JSONObject jsonObject = new JSONObject();
				elsecoClaims = service.getClaimDetailsBySearchCriteria(jsonObject);
			} else {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", id);
				elsecoClaims = service.getClaimDetailsBySearchCriteria(jsonObject);
			}
		} catch (EmptyResultDataAccessException e) {
			LOG.error(e.toString());
		} catch (ResourceNotFoundException e) {
			LOG.error(e.toString());
		} catch (JSONException e) {
			LOG.error(e.toString());
			map.put("ERROR_CODE", "IMPROPER JSON DATA IS PASSED THROUGH REQUEST");
			map.put("ERROR_MSG", e.getCause().getMessage());
			return map;
		} catch (Exception e) {
			LOG.error(e.toString());
			map.put("ERROR_CODE", "SOMETHING WENT WRONG. CONTACT ADMINISTRATOR");
			map.put("ERROR_MSG", e.getCause().getMessage());
			return map;
		}	

		if (elsecoClaims != null) {					
			map.put(elsecoClaimsConstant.HANDLER_NAVIGATION, new JsonHandlerForNavigation());
			map.put(elsecoClaimsConstant.HANDLER_DEAL, Json.createObjectBuilder().build());
			map.put(elsecoClaimsConstant.HANDLER_INCIDENT, new JsonHandlerForIncident());
			map.put(elsecoClaimsConstant.HANDLER_USER, new UserInfo());  //Json.createObjectBuilder().build());
			map.put(elsecoClaimsConstant.HANDLER_CLAIMS, elsecoClaims);			
			map.put(elsecoClaimsConstant.HANDLER_AUDIT, Json.createObjectBuilder().build());			
			return map;			
		}
		map.put("RESULT NOT FOUND", "No Results are Found with the given Id "+id);
		return map;
	}
        
    /**
     * 
     * @param claims
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/saveClaims")
    public Object saveClaims(@RequestBody Map<String, Object> claims){
    	LOG.info("------------------------------------------------------------------------------------"+claims);
    	LOG.info("Received a call to Controller  as -  http://HOST:PORT/claims/saveClaims/");		
		try {			
			JsonHandlerForNavigation navHandler = null;
			JsonHandlerForWorklistAndSaveClaims updatedClaims = null;
			JsonHandlerForWorklistAndSaveClaims oldClaims = null;
			UserInfo userInfo = null;
			boolean isNewlyCreatedClaim = false;
			
			ModelMapper modelMapper = new ModelMapper();
			Provider<Timestamp> localTimestampProvider = new AbstractProvider<Timestamp>() {
		        @Override
		        public Timestamp get() {
		            return new Timestamp(System.currentTimeMillis());
		        }
		    };
		    
		    Converter<String, Timestamp> toStringTimestamp = new AbstractConverter<String, Timestamp>() {
		    	@Override
		        protected Timestamp convert(String source) {		           
		            return new Timestamp(System.currentTimeMillis());
		        }
		    };
		    
		    modelMapper.createTypeMap(String.class, Timestamp.class);
		    modelMapper.addConverter(toStringTimestamp);
			modelMapper.getTypeMap(String.class, Timestamp.class).setProvider(localTimestampProvider);
			
			if(claims.get(elsecoClaimsConstant.HANDLER_CLAIMS)!=null) {				
				updatedClaims = modelMapper.map(claims.get(elsecoClaimsConstant.HANDLER_CLAIMS), JsonHandlerForWorklistAndSaveClaims.class);	
				if(updatedClaims.getClaimHeaderId() == 0) {
					isNewlyCreatedClaim = true;
				}
			}			
			if(claims.get(elsecoClaimsConstant.HANDLER_AUDIT)!=null) {				
				oldClaims = modelMapper.map(claims.get(elsecoClaimsConstant.HANDLER_AUDIT), JsonHandlerForWorklistAndSaveClaims.class);		
			}
			if(claims.get(elsecoClaimsConstant.HANDLER_NAVIGATION)!=null) {		
				navHandler = modelMapper.map(claims.get(elsecoClaimsConstant.HANDLER_NAVIGATION), JsonHandlerForNavigation.class);					
			}
			if(claims.get(elsecoClaimsConstant.HANDLER_USER)!=null) {		
				userInfo = modelMapper.map(claims.get(elsecoClaimsConstant.HANDLER_USER), UserInfo.class);					
			}			
						
			ElsecoClaimsAuditTrail auditTrail = new ElsecoClaimsAuditTrail();
			auditTrail.setApplicationHandle(navHandler.getApplicationHandle()!=null?navHandler.getApplicationHandle():elsecoClaimsConstant.APPLICATIONHANDLE);
			auditTrail.setModuleHandle(navHandler.getModuleHandle()!=null?navHandler.getModuleHandle():elsecoClaimsConstant.MODULEHANDLE);
			auditTrail.setScreenHandle(navHandler.getScreenHandle());
			auditTrail.setCreatedBy(userInfo.getLoginName()!=null?userInfo.getLoginName():"Guest");
			auditTrail.setSourceIPAddress(navHandler.getServerEnvOrIP());
					
			//Call the save service
			Integer headerId = lookupService.saveClaims(updatedClaims, oldClaims, auditTrail);
			
			if(isNewlyCreatedClaim && headerId!=null && headerId>0) {
				/**  	Call Nyms Notification Service			**/
				sendNotificationMsg(elsecoClaimsConstant.NYMS_EMAIL_ATTCH_SERVICE_URI, claims, ""+headerId);		
			}
			
			return new ResponseEntity(headerId, HttpStatus.OK);
		} catch(ElsecoClaimsServiceException e) {
			LOG.error(e.toString());
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode(e.getMessage());
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (JSONException e) {
			LOG.error(e.toString());
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("INVALID JSON FORMAT");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch(Exception e) {
			LOG.error(e.toString());
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("UNABLE TO PARSE THE JSON FOR SAVING CLAIMS");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		}
       //return new ResponseEntity("ElsecoClaims saved successfully", HttpStatus.OK);
    }
    
    /**
     * 
     * @param claims
     * @return
     */
	@PostMapping("/saveExternalReference")
    public Object saveExternalReference(@RequestBody Map<String, Object> claims){
		LOG.info("------------------------------------------------------------------------------------"+claims);
    	LOG.info("Received a call to Controller  as -  http://HOST:PORT/claims/saveExternalReference/");		
		try {			
			JsonHandlerForSaveUcrExtRef updatedClaims = null;									
			if(claims.get(elsecoClaimsConstant.HANDLER_CLAIMS)!=null) {
				ModelMapper modelMapper = new ModelMapper();
				updatedClaims = modelMapper.map(claims.get(elsecoClaimsConstant.HANDLER_CLAIMS), JsonHandlerForSaveUcrExtRef.class);					
			}			

			//Call the save service
			int headerId = lookupService.saveExtReference(updatedClaims);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", ""+headerId);
			Object elsecoClaims = service.getClaimDetailsBySearchCriteria(jsonObject);
			
			//Return the whole claims Json structure	
			Map<String, Object> map = new HashMap<String, Object>();
			if (elsecoClaims != null) {						
				map.put(elsecoClaimsConstant.HANDLER_CLAIMS, elsecoClaims);			
			}		
			return map;
		} catch(ElsecoClaimsServiceException e) {
			LOG.error(e.toString());
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode(e.getMessage());
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (JSONException e) {
			LOG.error(e.toString());
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("INVALID JSON FORMAT");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch(Exception e) {
			LOG.error(e.toString());
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("UNABLE TO PARSE THE JSON FOR SAVING CLAIMS");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		}
       //return new ResponseEntity("ElsecoClaims saved successfully", HttpStatus.OK);
    }
    
    /**
     * ClaimsBySearchCriteria -  Claims on Search Criteria
     * 
     * @param queryMap
     * @return
     */
    @ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Object.class, responseContainer = "Object", value = "getAuditDetailsBySearchCriteria")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)       
    @PostMapping("/auditTrace")
	public Object getAuditDetailsBySearchCriteria(@RequestBody(required=false) Map<String, Object> queryMap) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/auditTrace/    "+queryMap);
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		List<?> auditobj = null;
		
		try {
			if(queryMap==null) {
				throw new JSONException(new Throwable("There is no proper Handler specified in Json."));
			}			
			
			if (queryMap != null && queryMap instanceof Map) {
				Map<String, Object> myMap = (Map<String, Object>) queryMap;
				if(myMap.get("tabHandler") == null || myMap.get("tabHandler").equals("")) {
					/** UCR and ExtRefNo is Optional.  Handler is mandatory.  Need to change if requirement changes**/
					throw new JSONException(new Throwable("There is no proper Handler specified in Json."));
				}
				
				JSONObject jsonObject = new JSONObject(queryMap);				
				auditobj = (List<?>) lookupService.getAuditDetailsBySearchCriteria(jsonObject);		
			}	
			if(auditobj==null || auditobj.size()==0) {
				exceptionResponse.setErrorCode("NO RESULTS FOUND");
				exceptionResponse.setErrorMessage("No Results are Found with the given Search Criteria");
				return exceptionResponse;
			}
		} catch (ResourceNotFoundException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("NO RESULTS FOUND WITH THE GIVEN REQUEST DATA");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (JSONException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("IMPROPER JSON DATA IS PASSED THROUGH REQUEST");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (Exception e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("SOMETHING WENT WRONG. CONTACT ADMINISTRATOR");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		}		
		return auditobj;
	}
    
    /**
     * A method to update the status and notify the user by email. 
     *             /cims/{operationHandle}/{headerId}/{detailId}/{statusHandle}
     * 
     * @param id
     * @return
     */
	@GetMapping("/updateStatus/{operationHandle}/{bpId}/{headerId}/{detailId}/{statusHandle}")
	public Object claimStatusNotifier(@RequestParam(value = "operationHandle", required = false) String operationHandle,
			@RequestParam(value = "bpId", required = false) String memberBpId,
			@RequestParam(value = "headerId", required = false) String headerId,
			@RequestParam(value = "detailId", required = false) String detailId,
			@RequestParam(value = "statusHandle", required = false) String statusHandle) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/updateStatus/{operationHandle}/{bpId}/{headerId}/{detailId}/{statusHandle}");
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		String responseStr = null;
		try {
			lookupService.claimStatusNotification(headerId, detailId, statusHandle);
			
			if(statusHandle.equals("approve")) {
				responseStr = "Claim UCR# "+headerId+" Approved by "+memberBpId+" successfully.";
			}else {
				responseStr = "Claim UCR# "+headerId+" Approved by "+memberBpId+" successfully.";
			}			
		} catch (ResourceNotFoundException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("NO SUCH RECORD FOUND TO UPDATE");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		} catch (JSONException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("IMPROPER DATA IS PASSED THROUGH REQUEST");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		} catch (Exception e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("SOMETHING WENT WRONG. CONTACT ADMINISTRATOR");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		}	
		return responseStr; 
	}
    
	 /**
     * payThroughHybris -  A service to invoke Hybris service for Reserve and Payment and Then notify the members
     * 
     * @param queryMap
     * @return
     */
    @ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Object.class, responseContainer = "Object", value = "callHybrisAndPaymentNotify")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)     
    @PostMapping("/callHybrisResAndPayment/")
    public Object callHybrisCollectPaymentAndNotify(@RequestBody Map<String, Object> queryMap) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/callHybrisResAndPayment/ "+queryMap);
			
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		Map<String, Object> map = new HashMap<String, Object>();	
		final Map<String, Object> copyOfInput = queryMap;	
		ElsecoClaimsHybrisResponse hybrisResponse = null;
		try {
			if(queryMap==null) {
				throw new JSONException(new Throwable("There is no proper structure specified in Json."));
			}else {	
				if(!sapRFCService.isValidData(queryMap)) {
					exceptionResponse.setErrorCode("IMPROPER JSON DATA IS PASSED THROUGH REQUEST");
					exceptionResponse.setErrorMessage("Either CURRENCY or PAYMENT TYPE or MEMBER DETAILS fields are blank. Please pass a valid data. ");
					return exceptionResponse;
				}	
				hybrisResponse = sapRFCService.populateHybrisCollectPaymentDetails(queryMap);						
			}			
			
			map.put("LOG_NUMBER", hybrisResponse.getLogNumber());
			map.put("RETURN_CODE", hybrisResponse.getResponseCode());
			map.put("RETURN_MSG", hybrisResponse.getStatus());
			LOG.info("Returning the Final Json with Details ::  "+map.toString());
					 
			if(hybrisResponse.getPaymntType().equalsIgnoreCase("Collection")) {				
				sendNotificationMsg(elsecoClaimsConstant.NYMS_COLLECT_FUND_SERVICE_URI, copyOfInput, hybrisResponse.getLogNumber());										
			} else {				
				sendNotificationMsg(elsecoClaimsConstant.NYMS_RELEASE_PAYMNT_SERVICE_URI, copyOfInput, hybrisResponse.getLogNumber());			
			}
			
		} catch (JSONException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("IMPROPER JSON DATA IS PASSED THROUGH REQUEST");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (Exception e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("SOMETHING WENT WRONG. CONTACT ADMINISTRATOR");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		}			
		return map;
	}
    
    /**
     * payThroughHybris -  A service to invoke Hybris service for Releasing the Payment and Then notify the members
     * 
     * @param queryMap
     * @return
     */
    @ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Object.class, responseContainer = "Object", value = "callHybrisReleasePayment")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)     
    @PostMapping("/callHybrisReleasePayment/")
    public Object callHybrisReleasePayment(@RequestBody Map<String, Object> queryMap) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/callHybrisReleasePayment/ "+queryMap);
			
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		Map<String, Object> map = new HashMap<String, Object>();	
		Map<String, Object> copyOfInput = queryMap;	
		ElsecoClaimsHybrisResponse hybrisResponse = null;
		try {
			if (queryMap == null) {
				throw new JSONException(new Throwable("There is no proper structure specified in Json."));
			}
			
			hybrisResponse = sapRFCService.populateHybrisReleasePaymentDetails(queryMap);
			
			map.put("LOG_NUMBER", hybrisResponse.getLogNumber());
			map.put("RETURN_CODE", hybrisResponse.getResponseCode());
			map.put("RETURN_MSG", hybrisResponse.getStatus());
			LOG.info("Returning the Final Json with Details ::  "+map.toString());
					
			sendNotificationMsg(elsecoClaimsConstant.NYMS_RELEASE_PAYMNT_SERVICE_URI, copyOfInput, hybrisResponse.getLogNumber());
			
		} catch (JSONException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("IMPROPER JSON DATA IS PASSED THROUGH REQUEST");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (Exception e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("SOMETHING WENT WRONG. CONTACT ADMINISTRATOR");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		}		
		return map;
	}
    
    /**
     * notifyEmailService -  A service to send an email notification to the mentioned emails in json
     * 
     * @param queryMap
     * @return
     */
    @ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Object.class, responseContainer = "Object", value = "notifyEmailService")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)     
    @PostMapping("/notifyEmailService")
    public Object notifyEmailService(@RequestBody Map<String, Object> queryMap) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/notifyEmailService/ "+queryMap);
			
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		Map<String, Object> map = new HashMap<String, Object>();	
		
		try {
			if (queryMap == null) {
				throw new JSONException(new Throwable("There is no proper structure specified in Json."));
			}
			sendNotificationMsg(elsecoClaimsConstant.NYMS_COLLECT_FUND_SERVICE_URI, queryMap, "Notify_Srvc" );
			
			map.put("NOTIFICATION_SENT", "Email Notification is sent.");
		} catch (JSONException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("IMPROPER JSON DATA IS PASSED THROUGH REQUEST");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (Exception e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("SOMETHING WENT WRONG. CONTACT ADMINISTRATOR");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		}		
		return map;
	}
    
    
    /**
     * 
     * @param queryMap
     * @return
     */
    @PostMapping("/getBPAvailablePrmFund/")
    public Object getBPBalanceAmout(@RequestBody List<ElsecoCrmPqm> queryMap) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/getBPAvailablePrmFund/ "+queryMap);
			
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		try {
			queryMap = sapRFCService.populateBPBalanceAmount(queryMap);				
			if(queryMap==null) {
				exceptionResponse.setErrorCode("NO BALANCE AMOUNT FOUND");
				exceptionResponse.setErrorMessage("No Results are Found with the given Search Criteria");
				return exceptionResponse;
			}				
		} catch (JSONException e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("IMPROPER JSON DATA IS PASSED THROUGH REQUEST");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		} catch (Exception e) {
			LOG.error(e.toString());
			exceptionResponse.setErrorCode("SOMETHING WENT WRONG. CONTACT ADMINISTRATOR");
			exceptionResponse.setErrorMessage(e.getCause().getMessage());
			return exceptionResponse;
		}		
		return queryMap;
    }	
  
    @GetMapping("/changeLogLevelTo/{newLogLevel}")
	public void changeLogLevel(@RequestParam(value = "newLogLevel", required = false) String newLogLevel) {
    	enableDebugLogs(newLogLevel.toLowerCase());
    }
    
    private void enableDebugLogs(String logLevel){
    	LOG.info(" =============    About to Change the Log level change method   =================== " ); 
    	LoggerContext ctx = (LoggerContext) LogManager.getContext(false);             
        Level newLevel = Level.valueOf(logLevel);
        Configurator.setAllLevels(LogManager.getRootLogger().getName(), newLevel);        
        LOG.info(ctx.getRootLogger().getLevel()); 
    }
    
    /**
     * A method to call the NYMS Email Notification Service
     * 
     * @param notificationSrvcUrl
     * @param inputJson
     * @param logNumber
     */
    private void sendNotificationMsg(String notificationSrvcUrl, Map<String, Object> inputJson, String logNumber) {
    	//To Do move this to a Service and ServiceImpl class in next phase
    	// ** Call Nyms Notification Service  Asynchronously**
		java.lang.Thread asyncThread = new Thread( new Runnable() {
	         public void run(){ 
	        	  RestTemplate restTemplate = new RestTemplate();
	        	  LOG.info("Calling .... "+notificationSrvcUrl+"  with Json \n "+inputJson);	
	        	  Object result = restTemplate.postForObject(notificationSrvcUrl, inputJson, Object.class);
	        	  LOG.info("Invoked Nyms Service to Send Notifications after requesting Collect/Reserve/Release Payment services -- \n "+ result.toString());
	        return; 
		   }
		});
		asyncThread.setName("thread_"+logNumber);
		asyncThread.start();
    }
    
    /**
     * A method to get the static data Operation 
     * 
     * @param id
     * @return
     */
	/*@GetMapping("/staticdata/{screenid}/{handler}")
	public Object StaticDataLookupHandler(@RequestParam(value = "screenid", required = false) String screenid,
			@RequestParam(value = "handler", required = false) String handler) {
		LOG.info("------------------------------------------------------------------------------------");
		LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/staticdata/{screenid}/{handler}");
		return lookupService.lookUpDataSearch(screenid, handler);
	}*/
	
	
	    
    /**
     * A method to get the static data Operation 
     * 
     * @param id
     * @return
     */   
    //@RequestMapping(value = {
    //        "/staticdata/{screenid}",
    //        "/staticdata/"}, method = RequestMethod.GET)   
    //public Object StaticDataLookup(@RequestParam(value = "screenid", required = false)  String screenid ){
   /* @GetMapping("/staticdata/{screenid}")
    public Object StaticDataLookup(@RequestParam(value = "screenid", required = false)  String screenid){
    	LOG.info("------------------------------------------------------------------------------------");
    	LOG.info("Received a call to Controller  as -  http://HOST:PORT/cims/staticdata/{screenid}");    	
    	return lookupService.lookUpStaticData(screenid);       
    }*/
    
    /**
     * A method to handle the Add Operation 
     * 
     * @param id
     * @param addElsecoClaims
     * @return
     */
	/*
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Object.class, responseContainer = "Object", value = "insertClaims")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
    @PostMapping("/claims")
    public Object insertClaims(@RequestBody Map<String, Object> queryMap){
    	LOG.info("------------------------------------------------------------------------------------");
    	LOG.info("Received a call to Controller  as -  http://HOST:PORT/claims");		
		try {
			return "{\"id\":\""+service.addElsecoClaims(queryMap)+"\"}";			
		} catch (JSONException e) {
			e.printStackTrace();
			final ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("INVALID JSON FORMAT");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		}catch(Exception e) {
			e.printStackTrace();
			final ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("UNABLE TO ADD THE CLAIMS");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		}
    }*/
        
    /**
     * A method to handle the Update Operation 
     * 
     * @param id
     * @param updateElsecoClaims
     * @return
     */
	/*
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/claims")
    public Object updateClaims(@RequestBody Map<String, Object> queryMap){
    	LOG.info("------------------------------------------------------------------------------------");
    	LOG.info("Received a call to Controller  as -  http://HOST:PORT/claims");    	
    	try {			
			service.updateElsecoClaims(queryMap);			
		} catch (JSONException e) {
			e.printStackTrace();
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("INVALID JSON FORMAT");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		}catch(Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setErrorCode("UNABLE TO ADD THE CLAIMS");
			exceptionResponse.setErrorMessage(e.getMessage());
			return exceptionResponse;
		}    	
        return new ResponseEntity("Updated ElsecoClaims successfully in Table ", HttpStatus.OK);
    }*/
    
    /**
     * A method to handle the Delete Operation 
     * 
     * @param id
     * @return
     * @throws Exception 
     * @throws NumberFormatException 
     */
	/*
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/claims/{table}/{id}")
    public ResponseEntity deleteClaims(@PathVariable String table, @PathVariable String id) throws NumberFormatException, Exception{
    	LOG.info("------------------------------------------------------------------------------------");
    	LOG.info("Received a call to Controller  as -  http://HOST:PORT/claims/{table}/{id}");
    	service.deleteElsecoClaims(table, Integer.valueOf(id));    	
        return new ResponseEntity("Deleted ElsecoClaims successfully from "+table+" having Id:"+id, HttpStatus.OK);
    }*/
       
}
