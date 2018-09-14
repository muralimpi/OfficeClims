package com.serole.claims.model.Dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;


/**
 * A class that implements the Spring based JDBCTemplate for all the Database
 * operations
 * 
 * @author Serole_Vijay
 *
 */
@Repository
public class ElClaimsEntityRepository {

	static final Logger LOG = LoggerFactory.getLogger(ElClaimsEntityRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ElsecoClaimsConstant elsecoClaimsConstant;

	/**
	 * A method to a Get all the Claims from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsHeader> getAllClaimHeaders() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\" ",
				new ElsecoClaimsHeaderRowMapper());
	}			
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer
	 * 
	 * @return
	 */
	// @Cacheable(value="elsecoClaims", unless="#result == null")
	@Transactional(readOnly = true)
	public ElsecoClaimsHeader getClaimHeaderById(int claimHeaderId) throws Exception{		
		try {
			return (ElsecoClaimsHeader) jdbcTemplate.queryForObject(
					"SELECT * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\" WHERE CLAIM_HEADER_ID = ?",
					new Object[] { claimHeaderId }, new ElsecoClaimsHeaderRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * A method to a add the Claims to the backend Database
	 * 
	 * @return
	 */
	// @CacheEvict(value = "elsecoClaims", key = "#elsecoClaims.claimHeaderId")
	public long insertClaimHeader(final ElsecoClaimsHeader elsecoClaims) throws Exception{
		LOG.info("About to insertClaimHeader :"+elsecoClaims.toString());
		final String sqlQ = "INSERT INTO \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\" (CLAIM_HEADER_ID, "
				+ " VERSION, CHNG_INDICATOR, EFFECTIVE_DATE, UCR_NO, UCR_NAME, EVENT_CATEGORY, EVENT_TYPE, "
				+ " EVENT_ID, DT_EVENT_FROM, DT_EVENT_TO, EVENT_DESCRIPTION, LOSS_TYPE, DT_OF_LOSS, TIME_OF_LOSS, LOSS_TIME_ZONE, "
				+ " CAUSE_OF_LOSS, STREET, HOUSE_NUM, ZIP_CODE, CITY, COUNTRY, REGION, STATUS, NEXT_STATUS, CLAIM_HANDLER, DEAL_ID, DEAL_TYPE, PRODUCT_CD, UMR_NO, LOB_CD,"
				+ " CLAIM_REPORTER, INSURED, REINSURED, INSURED_ID, REINSURED_ID, LOCATION, SUBMISSION_ID,BROKER_ID, EVENTDATENOTIF, LLOYDS_RISK_CD, RISK_EXPIRY_DT, RISK_INCEPTION_DT,"
				+ " SECTION_NAME, NEW_RECORD_IN, ELSECO_RISK_CD, LEADER_NAME, LEADER_LINE_VL, RISK_DOMICILE_FG, RISK_LOCATION_CD, ELSECO_LEADER_FLAG, INCEPTION_DATE, "
				+ " EXPIRY_DATE, LIMIT_CURRENCY_CD, DELETE_FLAG ) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_HEADER);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, elsecoClaims.getVersion(), 
						 /*getIncrementedMaxVersion(elsecoClaimsConstant.CLAIM_HEADER),	*/					
						elsecoClaims.getChangeIndicator(), elsecoClaims.getEffectiveDate(), elsecoClaims.getUcrNumber(),
						elsecoClaims.getUcrName(), elsecoClaims.getEventCategory(), elsecoClaims.getEventType(),
						elsecoClaims.getEventId(), elsecoClaims.getEventFromDate(), elsecoClaims.getEventToDate(),
						elsecoClaims.getEventDescription(), elsecoClaims.getLossType(), elsecoClaims.getDateOfLoss(),
						elsecoClaims.getTimeOfLoss(), elsecoClaims.getLossTimeZone(), elsecoClaims.getCauseOfLoss(),
						elsecoClaims.getStreet(), elsecoClaims.getHouseNumber(), elsecoClaims.getZipCode(),
						elsecoClaims.getCity(), elsecoClaims.getCountry(), elsecoClaims.getRegion(),
						elsecoClaims.getStatus(), elsecoClaims.getNextStatus(), elsecoClaims.getClaimHandler(), elsecoClaims.getDealId(), elsecoClaims.getDealType(),
						elsecoClaims.getProductCode(), elsecoClaims.getUmrNumber(), elsecoClaims.getLobCode(),
						elsecoClaims.getClaimReporter(), elsecoClaims.getInsured(), elsecoClaims.getReinsured(), elsecoClaims.getInsuredId(), elsecoClaims.getReinsuredId(), elsecoClaims.getLocation(),
						elsecoClaims.getSubmissionId(),elsecoClaims.getBrokerId(), elsecoClaims.getEventDateNotif(), elsecoClaims.getLloydsRiskCode(),
						elsecoClaims.getRiskExpiryDate(), elsecoClaims.getRiskInceptionDate(), elsecoClaims.getSectionName(), elsecoClaims.getNewRecordIn(),
						elsecoClaims.getElsecoRiskCd(), elsecoClaims.getLeaderName(), elsecoClaims.getLeaderLineVl(), elsecoClaims.getRiskDomicileFg(),
						elsecoClaims.getRiskLocationCode(), elsecoClaims.getElsecoLeaderFlag(), elsecoClaims.getInceptionDate(), elsecoClaims.getExpiryDate(),
						elsecoClaims.getLimitCurrencyCode(), (elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():"")});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims in Database
	 * 
	 * @return
	 */
	public int updateClaimHeader(ElsecoClaimsHeader elsecoClaims) throws Exception{
		LOG.info("About to updateClaimHeader :"+elsecoClaims.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  set "
				+ " VERSION = ?, CHNG_INDICATOR = ?, EFFECTIVE_DATE = ?, UCR_NO = ?, UCR_NAME = ?, EVENT_CATEGORY = ?, EVENT_TYPE = ?, "
				+ " EVENT_ID = ?, DT_EVENT_FROM = ?, DT_EVENT_TO = ?, EVENT_DESCRIPTION = ?, LOSS_TYPE = ?, DT_OF_LOSS = ?, "
				+ " TIME_OF_LOSS = ?, LOSS_TIME_ZONE = ?, CAUSE_OF_LOSS = ?, STREET = ?, HOUSE_NUM = ?, ZIP_CODE = ?, CITY = ?, "
				+ " COUNTRY = ?, REGION = ?, STATUS = ?, NEXT_STATUS = ?, CLAIM_HANDLER = ?, DEAL_ID = ?, DEAL_TYPE = ?, "
				+ " PRODUCT_CD= ?, UMR_NO= ?, LOB_CD =?, CLAIM_REPORTER = ?, INSURED = ?, REINSURED = ?, INSURED_ID =?, REINSURED_ID =?, LOCATION = ?,"
				+ " SUBMISSION_ID = ?, BROKER_ID=?,EVENTDATENOTIF = ?, LLOYDS_RISK_CD = ?, RISK_EXPIRY_DT = ?, RISK_INCEPTION_DT = ?, "
				+ " SECTION_NAME = ?, NEW_RECORD_IN = ?, ELSECO_RISK_CD = ?, LEADER_NAME = ?, LEADER_LINE_VL = ?, RISK_DOMICILE_FG = ?, RISK_LOCATION_CD = ?, "
				+ " ELSECO_LEADER_FLAG = ?, EXPIRY_DATE = ?, INCEPTION_DATE =?, LIMIT_CURRENCY_CD = ?, DELETE_FLAG = ?  where CLAIM_HEADER_ID = ? ",
				new Object[] { elsecoClaims.getVersion(), elsecoClaims.getChangeIndicator(), elsecoClaims.getEffectiveDate(),
						elsecoClaims.getUcrNumber(), elsecoClaims.getUcrName(), elsecoClaims.getEventCategory(),
						elsecoClaims.getEventType(), elsecoClaims.getEventId(), elsecoClaims.getEventFromDate(),
						elsecoClaims.getEventToDate(), elsecoClaims.getEventDescription(), elsecoClaims.getLossType(),
						elsecoClaims.getDateOfLoss(), elsecoClaims.getTimeOfLoss(), elsecoClaims.getLossTimeZone(),
						elsecoClaims.getCauseOfLoss(), elsecoClaims.getStreet(), elsecoClaims.getHouseNumber(),
						elsecoClaims.getZipCode(), elsecoClaims.getCity(), elsecoClaims.getCountry(), elsecoClaims.getRegion(), 
						elsecoClaims.getStatus(), elsecoClaims.getNextStatus(), elsecoClaims.getClaimHandler(), elsecoClaims.getDealId(), elsecoClaims.getDealType(), elsecoClaims.getProductCode(), 
						elsecoClaims.getUmrNumber(), elsecoClaims.getLobCode(), elsecoClaims.getClaimReporter(), elsecoClaims.getInsured(), 
						elsecoClaims.getReinsured(), elsecoClaims.getInsuredId(), elsecoClaims.getReinsuredId(), elsecoClaims.getLocation(), elsecoClaims.getSubmissionId(),
						elsecoClaims.getBrokerId(),elsecoClaims.getEventDateNotif(), elsecoClaims.getLloydsRiskCode(), elsecoClaims.getRiskExpiryDate(), elsecoClaims.getRiskInceptionDate(), 
						elsecoClaims.getSectionName(), elsecoClaims.getNewRecordIn(), elsecoClaims.getElsecoRiskCd(), elsecoClaims.getLeaderName(), elsecoClaims.getLeaderLineVl(),
						elsecoClaims.getRiskDomicileFg(), elsecoClaims.getRiskLocationCode(), elsecoClaims.getElsecoLeaderFlag(),  elsecoClaims.getExpiryDate(),  elsecoClaims.getInceptionDate(), elsecoClaims.getLimitCurrencyCode(),
						(elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():""), elsecoClaims.getClaimHeaderId() });
	}

	/**
	 * A method to delete the Claims from Data Layer
	 * 
	 * @return
	 */
	public int deleteClaimsHeaderById(long id)  throws Exception {
		LOG.info("About to delete ClaimsHeader By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  where CLAIM_HEADER_ID=?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsHeaderExists(int id) throws Exception{
		ElsecoClaimsHeader claimsHeader = getClaimHeaderById(id);
		if(claimsHeader == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * A method to a Get all the Claim Items from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsItems> getAllClaimsItems() throws Exception{
		return jdbcTemplate.query("SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\" ",
				new ElsecoClaimsItemRowMapper());
				//new BeanPropertyRowMapper(ElsecoClaimsItems.class));
	}		

	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer
	 * 
	 * @return
	 */
	// @Cacheable(value="elsecoClaims", unless="#result == null")
	@Transactional(readOnly = true)
	public ElsecoClaimsItems getClaimItemById(int claimsItemId) throws Exception{
		LOG.info("About to getClaimItemById :" + claimsItemId);
		try {
			return (ElsecoClaimsItems) jdbcTemplate.queryForObject(
					"SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\" WHERE CLAIM_ITEM_ID=?",
					new Object[] { claimsItemId }, new ElsecoClaimsItemRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	
	/**
	 * A method to a add the Claims to the backend Database
	 * 
	 * @return
	 */
	// @CacheEvict(value = "elsecoClaims", key = "#elsecoClaims.claimHeaderId")
	@Transactional
	public long insertClaimItem(final ElsecoClaimsItems elsecoClaims) throws Exception{
		LOG.info("About to insertClaimItem :" + elsecoClaims.toString());

		final String sqlQ = "INSERT INTO \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\" (CLAIM_ID, CLAIM_HEADER_ID, CLAIM_ITEM_ID, SUBCLAIM_ID, "
				+ " VERSION, EFFECTIVE_DATE, CHNG_INDICATOR, EXT_CLAIM_ITEM_NO, BENEFIT_TYPE, ITEM_OBJ_TYPE,  COVG_TYPE, "
				+ " AMT_EVALUATED, CURR_EVAL, EVAL_AMT_PERUNIT, EVAL_QUANTITY, EVAL_QUANT_UNIT, STATUS_ITEM, DESCRIPTION_ITEM, DELETE_FLAG) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_ITEMS);
		int result = jdbcTemplate.update(sqlQ, new Object[] { elsecoClaims.getClaimId(), elsecoClaims.getClaimHeaderId(),
				generatedId, elsecoClaims.getSubClaimId(), elsecoClaims.getVersion(), 
				/*getIncrementedMaxVersion(elsecoClaimsConstant.CLAIM_ITEMS),*/  elsecoClaims.getEffectiveDate(),
				elsecoClaims.getChngIndicator(), elsecoClaims.getExtClaimItemNo(), elsecoClaims.getBenefitType(),
				elsecoClaims.getItemObjType(), elsecoClaims.getCovgType(), elsecoClaims.getAmtEvaluated(),
				elsecoClaims.getCurrEval(), elsecoClaims.getEvalAmtPerUnit(), elsecoClaims.getEvalQuantity(),
				elsecoClaims.getEvalQuantUnit(), elsecoClaims.getStatusItem(), elsecoClaims.getDescriptionItem(),
				(elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():"") });
		
		if(result ==1) {
			return generatedId;
		}
		return 0;

	}

	/**
	 * A method to update the Claims in Database
	 * 
	 * @return
	 */
	@Transactional
	public int updateClaimItem(ElsecoClaimsItems elsecoClaims) throws Exception{
		LOG.info("About to updateClaimItem :" + elsecoClaims.toString());

		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\"  set "
				+ " VERSION = ?, CLAIM_HEADER_ID = ?, SUBCLAIM_ID = ?, EFFECTIVE_DATE = ?, CHNG_INDICATOR = ?, EXT_CLAIM_ITEM_NO = ?, BENEFIT_TYPE = ?, ITEM_OBJ_TYPE = ?, "
				+ " COVG_TYPE = ?, AMT_EVALUATED = ?, CURR_EVAL = ?, EVAL_AMT_PERUNIT = ?, EVAL_QUANTITY = ?, EVAL_QUANT_UNIT = ?, "
				+ " STATUS_ITEM = ?, DESCRIPTION_ITEM = ?, DELETE_FLAG = ?  where CLAIM_ID = ? AND CLAIM_ITEM_ID = ? ",
				new Object[] { elsecoClaims.getVersion(), elsecoClaims.getClaimHeaderId(), elsecoClaims.getSubClaimId(), elsecoClaims.getEffectiveDate(),
						elsecoClaims.getChngIndicator(), elsecoClaims.getExtClaimItemNo(),
						elsecoClaims.getBenefitType(), elsecoClaims.getItemObjType(), elsecoClaims.getCovgType(),
						elsecoClaims.getAmtEvaluated(), elsecoClaims.getCurrEval(), elsecoClaims.getEvalAmtPerUnit(),
						elsecoClaims.getEvalQuantity(), elsecoClaims.getEvalQuantUnit(), elsecoClaims.getStatusItem(),
						elsecoClaims.getDescriptionItem(), (elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():""), 
						elsecoClaims.getClaimId(), elsecoClaims.getClaimItemId() });
	}

	/**
	 * A method to delete the ClaimItems from Data Layer
	 * 
	 * @return
	 */
	@Transactional
	public int deleteClaimsItemById(long id) throws Exception{
		LOG.info("About to delete ClaimsItem By Id :" + id);
		return jdbcTemplate.update(
				"delete from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\"  where CLAIM_ITEM_ID=?",
				new Object[] { id });
	}
	
	public boolean isClaimsItemExists(int id) throws Exception {
		ElsecoClaimsItems claims = getClaimItemById(id);
		if(claims == null) {
			return false;
		}
		return true;
	}

	/**
	 * A method to a Get all the Claim Items from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimDetails> getAllClaimDetails() throws Exception{
		LOG.info("About to getAllClaimDetails ");
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\" ",
				new ElsecoClaimDetailRowMapper());
	}	

	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer
	 * 
	 * @return
	 */
	// @Cacheable(value="elsecoClaims", unless="#result == null")
	@Transactional(readOnly = true)
	public ElsecoClaimDetails getClaimDetailById(int claimsDetailId) throws Exception{	
		LOG.info("About to getClaimDetailById :"+claimsDetailId);
		
		try {
			return (ElsecoClaimDetails) jdbcTemplate.queryForObject(
					"select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\" where CLAIM_ID=?",
					new Object[] { claimsDetailId }, new ElsecoClaimDetailRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
		
	/**
	 * A method to a add the Claims to the backend Database
	 * 
	 * @return
	 */
	// @CacheEvict(value = "elsecoClaims", key = "#elsecoClaims.claimHeaderId")
	public long insertClaimDetail(final ElsecoClaimDetails elsecoClaims) throws Exception{
		LOG.info("About to insertClaimDetail :"+elsecoClaims.toString());

		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\" (CLAIM_ID, CLAIM_HEADER_ID, "
				+ " VERSION, CHNG_INDICATOR, EFFECTIVE_DATE, CLAIM_REFERENCE_NO, FLG_AUTH_REPORTED, CLAIM_DETAIL_STATUS, NEXT_STATUS, CLAIM_REPORTER, "
				+ " CLAIM_AUTHORITY, LOSS_TYPE, POLICY_TYPE, DT_OF_LOSS, TIME_OF_LOSS, LOSS_TIME_ZONE, CAUSE_OF_LOSS, STREET, HOUSE_NUM, ZIP_CODE, CITY, COUNTRY, "
				+ " REGION, STATUS_CHNG_REASON, CLM_AUTH_GRP, COMPLEXITY, DT_CLAIM_OPEN, DT_CLAIM_EXPIRY, DT_LOSS_REPT_COMPANY, DT_LOSS_REPORTED_AGENT, CLAIM_PROC_TIME, "
				+ " STATUSCHG, FLG_SENSITIVE, FLG_COVERED, DT_EFFECTIVE, DT_LOSS_REPORTED, EXTREFNO, LLOYDS_RISK_CD, LOB_CD,"
				+ " SECTION_NAME, INCEPTION_DATE, EXPIRY_DATE, SUBJECT,  TOTAL_PRICE_AM, ORDER_PREC_VL, SIGNING_PERC_VL,"
				+ " ESTIMATED_PREMIUM_AM, TEMP_LLOYDS_RISK_CD, LINE_SIZE_VL, PRM_SPLIT_PERC_VL, PREMIUM_AMT, BUTTON_INDICATOR, SETTLEMENT_DATE,  "
				+ " PREVPDCLAMT_INDEMNITY,PREVPDCLAMT_FEES,PREVPDCLAMT_EXPENSES,SETLMNTCLAMT_INDEMNITY,SETLMNTCLAMT_FEES,SETLMNTCLAMT_EXPENSES,"
				+ " RESERVEAMOUNT_INDEMNITY,RESERVEAMOUNT_FEES,RESERVEAMOUNT_EXPENSES,DELETE_FLAG) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_DETAIL);
		int result = jdbcTemplate.update(sqlQ, new Object[] { generatedId, 	elsecoClaims.getClaimHeaderId(),
				elsecoClaims.getVersion(), elsecoClaims.getChangeIndicator(),
				elsecoClaims.getEffctiveDate(), elsecoClaims.getClaimReferenceNo(), elsecoClaims.getFlagAuthReported(),
				elsecoClaims.getClaimDetailStatus(), elsecoClaims.getNextStatus(), elsecoClaims.getClaimReporter(), elsecoClaims.getClaimAuthority(),
				elsecoClaims.getLossType(), elsecoClaims.getPolicyType(), elsecoClaims.getDateOfLoss(), elsecoClaims.getTimeOfLoss(),
				elsecoClaims.getLossTimeZone(), elsecoClaims.getCauseOfLoss(), elsecoClaims.getStreet(),
				elsecoClaims.getHouseNumber(), elsecoClaims.getZipCode(), elsecoClaims.getCity(),
				elsecoClaims.getCountry(), elsecoClaims.getRegion(), elsecoClaims.getStatusChangeReason(),
				elsecoClaims.getClaimAuthGroup(), elsecoClaims.getComplexity(), elsecoClaims.getDateClaimOpen(), elsecoClaims.getDateClaimExpiry(),
				elsecoClaims.getDateLossReptCompany(), elsecoClaims.getDateLossReportedAgent(),
				elsecoClaims.getClaimProcTime(), elsecoClaims.getStatusChg(), elsecoClaims.getFlagSensitive(),
				elsecoClaims.getFlagCovered(), elsecoClaims.getDtEffctive(), elsecoClaims.getDateLossReported(),
				elsecoClaims.getExtRefNo(), elsecoClaims.getLloydsRiskCode(), elsecoClaims.getLobCode(),
				elsecoClaims.getSectionName(), elsecoClaims.getInceptionDate(), elsecoClaims.getExpiryDate(), elsecoClaims.getSubject(),
			    elsecoClaims.getTotalPriceAm(), elsecoClaims.getOrderPrecVl(), elsecoClaims.getSigningPercVl(),
				elsecoClaims.getEstimatedPremiumAM(), elsecoClaims.getTempLloydsRiskCd(), elsecoClaims.getLineSizeVl(), elsecoClaims.getPrmSplitPercVl(), elsecoClaims.getPremiumAmt(),
				elsecoClaims.getButtonIndicator(), elsecoClaims.getSettlementDate(),elsecoClaims.getPrevpaidAmtIndemnityER(),
				elsecoClaims.getPrevpaidAmtFeesER(),elsecoClaims.getPrevpaidAmtExpensesER(),returnValidAmount(elsecoClaims.getSettlementAmtIndemnityER()), returnValidAmount(elsecoClaims.getSettlementAmtFeesER()),
				returnValidAmount(elsecoClaims.getSettlementAmtExpensesER()),elsecoClaims.getReserveAmountIndemnityER(),elsecoClaims.getReserveAmountFeesER(),
				elsecoClaims.getReserveAmountExpensesER(), elsecoClaims.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims in Database
	 * 
	 * @return
	 */
	public int updateClaimDetail(ElsecoClaimDetails elsecoClaims) throws Exception{
		LOG.info("About to updateClaimDetail :"+elsecoClaims.toString());

		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  set   VERSION = ?, "
				+ " CHNG_INDICATOR = ?, EFFECTIVE_DATE = ?, CLAIM_REFERENCE_NO = ?, FLG_AUTH_REPORTED = ?, CLAIM_DETAIL_STATUS = ?, NEXT_STATUS = ?, CLAIM_REPORTER = ?, "
				+ " CLAIM_AUTHORITY = ?, LOSS_TYPE = ?, POLICY_TYPE =?, DT_OF_LOSS = ?, TIME_OF_LOSS = ?, LOSS_TIME_ZONE = ?, CAUSE_OF_LOSS = ?, "
				+ " STREET = ?, HOUSE_NUM = ?, ZIP_CODE = ?, CITY = ?, COUNTRY = ?, REGION = ?, STATUS_CHNG_REASON = ?, CLM_AUTH_GRP = ?, "
				+ " COMPLEXITY = ?, DT_CLAIM_OPEN = ?, DT_CLAIM_EXPIRY = ?, DT_LOSS_REPT_COMPANY = ?, DT_LOSS_REPORTED_AGENT = ?, CLAIM_PROC_TIME = ?, STATUSCHG = ?, "
				+ " FLG_SENSITIVE = ?, FLG_COVERED = ?, DT_EFFECTIVE = ?, DT_LOSS_REPORTED = ?, EXTREFNO = ?, LLOYDS_RISK_CD = ?, LOB_CD = ?, "
				+ " SECTION_NAME = ?, INCEPTION_DATE = ?, EXPIRY_DATE = ?, SUBJECT = ?,  TOTAL_PRICE_AM = ?, ORDER_PREC_VL = ?, SIGNING_PERC_VL = ?, "  
				+ " ESTIMATED_PREMIUM_AM = ?, TEMP_LLOYDS_RISK_CD = ?, LINE_SIZE_VL =?, PRM_SPLIT_PERC_VL = ?, PREMIUM_AMT = ?, BUTTON_INDICATOR = ?, SETTLEMENT_DATE = ?, "
				+ " PREVPDCLAMT_INDEMNITY=?,PREVPDCLAMT_FEES=?,PREVPDCLAMT_EXPENSES=?,SETLMNTCLAMT_INDEMNITY=?,SETLMNTCLAMT_FEES=?,SETLMNTCLAMT_EXPENSES=?,"
				+ "RESERVEAMOUNT_INDEMNITY=?,RESERVEAMOUNT_FEES=?,RESERVEAMOUNT_EXPENSES=?, DELETE_FLAG = ? where CLAIM_ID = ? AND CLAIM_HEADER_ID = ? ",
				new Object[] { elsecoClaims.getVersion(), elsecoClaims.getChangeIndicator(), elsecoClaims.getEffctiveDate(),
						elsecoClaims.getClaimReferenceNo(), elsecoClaims.getFlagAuthReported(),
						elsecoClaims.getClaimDetailStatus(), elsecoClaims.getNextStatus(), elsecoClaims.getClaimReporter(),
						elsecoClaims.getClaimAuthority(), elsecoClaims.getLossType(), elsecoClaims.getPolicyType(), elsecoClaims.getDateOfLoss(),
						elsecoClaims.getTimeOfLoss(), elsecoClaims.getLossTimeZone(), elsecoClaims.getCauseOfLoss(),
						elsecoClaims.getStreet(), elsecoClaims.getHouseNumber(), elsecoClaims.getZipCode(),
						elsecoClaims.getCity(), elsecoClaims.getCountry(), elsecoClaims.getRegion(),
						elsecoClaims.getStatusChangeReason(), elsecoClaims.getClaimAuthGroup(),
						elsecoClaims.getComplexity(), elsecoClaims.getDateClaimOpen(), elsecoClaims.getDateClaimExpiry(),
						elsecoClaims.getDateLossReptCompany(), elsecoClaims.getDateLossReportedAgent(),
						elsecoClaims.getClaimProcTime(), elsecoClaims.getStatusChg(), elsecoClaims.getFlagSensitive(),
						elsecoClaims.getFlagCovered(), elsecoClaims.getDtEffctive(), elsecoClaims.getDateLossReported(),
						elsecoClaims.getExtRefNo(), elsecoClaims.getLloydsRiskCode(),
						elsecoClaims.getLobCode(), elsecoClaims.getSectionName(), elsecoClaims.getInceptionDate(), elsecoClaims.getExpiryDate(),
						elsecoClaims.getSubject(),  elsecoClaims.getTotalPriceAm(), elsecoClaims.getOrderPrecVl(), elsecoClaims.getSigningPercVl(),
						elsecoClaims.getEstimatedPremiumAM(), elsecoClaims.getTempLloydsRiskCd(), elsecoClaims.getLineSizeVl(), elsecoClaims.getPrmSplitPercVl(), 
						elsecoClaims.getPremiumAmt(), elsecoClaims.getButtonIndicator(),elsecoClaims.getSettlementDate(),elsecoClaims.getPrevpaidAmtIndemnityER(),
						elsecoClaims.getPrevpaidAmtFeesER(),elsecoClaims.getPrevpaidAmtExpensesER(),returnValidAmount(elsecoClaims.getSettlementAmtIndemnityER()),returnValidAmount(elsecoClaims.getSettlementAmtFeesER()),
						returnValidAmount(elsecoClaims.getSettlementAmtExpensesER()),elsecoClaims.getReserveAmountIndemnityER(),elsecoClaims.getReserveAmountFeesER(),
						elsecoClaims.getReserveAmountExpensesER(), elsecoClaims.getDeleteFlag().toUpperCase(), elsecoClaims.getClaimId(), elsecoClaims.getClaimHeaderId() });
	}	

	/**
	 * A method to delete the ClaimItems from Data Layer
	 * 
	 * @return
	 */
	public int deleteClaimDetailById(long id) throws Exception{
		LOG.info("About to delete ClaimDetail By Id :"+id);
		return jdbcTemplate.update(
				"delete from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  where CLAIM_ID = ?",
				new Object[] { id });
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsDetailExists(int id) throws Exception{
		ElsecoClaimDetails claims = getClaimDetailById(id);
		if(claims == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * A method to a Get all the Claims from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimReserve> getAllClaimReserves() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimReserve_T\" ",
				new ElsecoClaimReserveRowMapper());
	}
	
	/**
	 * Get the Claim Reserve based on  Id
	 * 
	 * @param claimsReserveId
	 * @return
	 */
	@Transactional(readOnly = true)
	public ElsecoClaimReserve getClaimReserveById(int claimsReserveId) throws Exception{	
		try {
			return (ElsecoClaimReserve) jdbcTemplate.queryForObject(
					"select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimReserve_T\" where CLAIM_RESERVE_ID=?",
					new Object[] { claimsReserveId }, new ElsecoClaimReserveRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	/**
	 * A method to a add the Claims Reserve to the backend Database
	 * 
	 * @return
	 */	
	public long insertClaimReserve(final ElsecoClaimReserve elsecoClaims) throws Exception{
		LOG.info("About to insertClaimReserve :"+elsecoClaims.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimReserve_T\" (CLAIM_RESERVE_ID, "
				+ " RESERVE_FLAG, RESERVE_AMT, INITIAL_DETAILS, CLAIM_HEADER_ID, CLAIM_ID, RESERVE_TYPE, POOL_NAME, MEMBER_NAME, "
				+ " ALLOCATION_PERCENT, PRIVILEDGE_TYPE, BALANCE_AMT, INDEMNITY_RESERVE_AMT, FEE_RESERVE_AMT, DELETE_FLAG) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_RESERVE);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, elsecoClaims.getReserveFlag(), elsecoClaims.getReserveAmt(),
						elsecoClaims.getInitialDetails(), elsecoClaims.getClaimHeaderId(), elsecoClaims.getClaimDetId(), elsecoClaims.getReserveType(), elsecoClaims.getPoolName(), 
						elsecoClaims.getMemberName(), elsecoClaims.getAllocationPercent(), elsecoClaims.getPriviledgeType(), elsecoClaims.getBalanceAmt(), elsecoClaims.getIndemnityAmt(), 
						elsecoClaims.getFeeReserveAmt(), elsecoClaims.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims Reserve in Database
	 * 
	 * @return
	 */
	public int updateElsecoClaimReserve(ElsecoClaimReserve elsecoClaims) throws Exception{
		LOG.info("About to updateElsecoClaimReserve :"+elsecoClaims.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimReserve_T\"  set "
				+ " RESERVE_FLAG = ?, RESERVE_AMT = ?, INITIAL_DETAILS = ?, CLAIM_HEADER_ID = ?, CLAIM_ID = ?,RESERVE_TYPE = ?, POOL_NAME = ?, MEMBER_NAME = ?, " 
				+ " ALLOCATION_PERCENT = ?, PRIVILEDGE_TYPE = ?, BALANCE_AMT = ?, INDEMNITY_RESERVE_AMT = ?, FEE_RESERVE_AMT = ?, DELETE_FLAG = ?  where CLAIM_RESERVE_ID = ? ",
				new Object[] { elsecoClaims.getReserveFlag(), elsecoClaims.getReserveAmt(),
						elsecoClaims.getInitialDetails(), elsecoClaims.getClaimHeaderId(), elsecoClaims.getClaimDetId(), elsecoClaims.getReserveType(),
						elsecoClaims.getPoolName(), elsecoClaims.getMemberName(), elsecoClaims.getAllocationPercent(),
						elsecoClaims.getPriviledgeType(), elsecoClaims.getBalanceAmt(), elsecoClaims.getIndemnityAmt(), elsecoClaims.getFeeReserveAmt(),
						elsecoClaims.getDeleteFlag().toUpperCase(), elsecoClaims.getClaimReserveId() });
	}

	/**
	 * A method to delete the Claims from Data Layer
	 * 
	 * @return
	 */
	public int deleteElsecoClaimReserveById(long id) throws Exception{
		LOG.info("About to delete ElsecoClaimReserve By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimReserve_T\"  where CLAIM_RESERVE_ID=?",
				new Object[] { id });
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsReserveExists(int id) throws Exception{
		ElsecoClaimReserve claims = getClaimReserveById(id);
		if(claims == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * A method to a Get all the Claims Notes from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsNotes> getAllClaimNotes() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimNotes_T\" ",
				new ElsecoClaimsNotesRowMapper());
	}
	
	/**
	 * Get the Claim Notes based on  Id
	 * 
	 * @param claimsReserveId
	 * @return
	 */
	@Transactional(readOnly = true)
	public ElsecoClaimsNotes getClaimNotesById(int claimsNotesId) throws Exception{	
		try {
			return (ElsecoClaimsNotes) jdbcTemplate.queryForObject(
					"select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimNotes_T\" where CLAIM_NOTES_ID=?",
					new Object[] { claimsNotesId }, new ElsecoClaimsNotesRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	/**
	 * A method to a add the Claims Notes to the backend Database
	 * 
	 * @return
	 */	
	public long insertClaimNotes(final ElsecoClaimsNotes elsecoClaims) throws Exception{
		LOG.info("About to insertClaimNotes :"+elsecoClaims.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimNotes_T\" (CLAIM_NOTES_ID, CLAIM_NOTES_VERSION, "
				+ " CLAIM_HEADER_ID, CLAIM_HEADER_VERSION, CLAIM_ID, CLAIM_VERSION, CLAIM_ITEM_ID, CLAIM_ITEM_VERSION, CLAIM_FILE_ID, CLAIM_FILE_VERSION, "
				+ " CLAIM_RESERVE_ID, CLAIM_RESERVE_VERSION, CLAIM_TRANS_ID, CLAIM_TRANS_VERSION, NOTES_MESSAGE, NOTES_DESC, CREATEDBY, CREATEDDATE, DELETE_FLAG) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_NOTES);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId,  elsecoClaims.getClaimNotesVersion(), elsecoClaims.getClaimHeaderId(),
						elsecoClaims.getClaimHeaderVersion(), elsecoClaims.getClaimDtlId(), elsecoClaims.getClaimVersion(), elsecoClaims.getClaimItemId(), 
						elsecoClaims.getClaimItemVersion(), elsecoClaims.getClaimFileId(), elsecoClaims.getClaimFileVersion(), elsecoClaims.getClaimReserveId(),
						elsecoClaims.getClaimReserveVersion(), elsecoClaims.getClaimTransId(), elsecoClaims.getClaimTransVersion(), elsecoClaims.getNotesMessage(), 
						elsecoClaims.getNotesDesc(), elsecoClaims.getCreatedBy(), getCurrentTimestampForSQL(), elsecoClaims.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims Notes in Database
	 * 
	 * @return
	 */
	public int updateElsecoClaimNotes(ElsecoClaimsNotes elsecoClaims) throws Exception{
		LOG.info("About to updateElsecoClaimReserve :"+elsecoClaims.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimNotes_T\"  set CLAIM_NOTES_VERSION = ?, "
				+ " CLAIM_HEADER_ID = ?, CLAIM_HEADER_VERSION = ?, CLAIM_ID = ?, CLAIM_VERSION = ?, CLAIM_ITEM_ID = ?, CLAIM_ITEM_VERSION = ?, CLAIM_FILE_ID = ?, " 
				+ " CLAIM_FILE_VERSION = ?, CLAIM_RESERVE_ID = ?, CLAIM_RESERVE_VERSION = ?, CLAIM_TRANS_ID = ?, CLAIM_TRANS_VERSION = ?, NOTES_MESSAGE = ?, "
				+ " NOTES_DESC = ?, CREATEDBY = ?, CREATEDDATE = ?, DELETE_FLAG = ?  where CLAIM_NOTES_ID = ?  ",
				new Object[] { elsecoClaims.getClaimNotesVersion(), elsecoClaims.getClaimHeaderId(), elsecoClaims.getClaimHeaderVersion(), elsecoClaims.getClaimDtlId(), elsecoClaims.getClaimVersion(),
						elsecoClaims.getClaimItemId(), elsecoClaims.getClaimItemVersion(), elsecoClaims.getClaimFileId(), elsecoClaims.getClaimFileVersion(), 
						elsecoClaims.getClaimReserveId(), elsecoClaims.getClaimReserveVersion(), elsecoClaims.getClaimTransId(), elsecoClaims.getClaimTransVersion(), 
						elsecoClaims.getNotesMessage(), elsecoClaims.getNotesDesc(), elsecoClaims.getCreatedBy(), getCurrentTimestampForSQL(), 
						elsecoClaims.getDeleteFlag().toUpperCase(), elsecoClaims.getClaimNotesId()});
	}

	/**
	 * A method to delete the Claims Notes from Data Layer
	 * 
	 * @return
	 */
	public int deleteElsecoClaimNotesById(long id) throws Exception{
		LOG.info("About to delete ElsecoClaimReserve By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimNotes_T\"  where CLAIM_NOTES_ID=?",
				new Object[] { id });
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsNoteExists(int id) throws Exception{
		ElsecoClaimsNotes claims = getClaimNotesById(id);
		if(claims == null) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * A method to a Get all the Claims Tasks from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsTasks> getAllClaimTasks() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimTasks_T\" ",
				new ElsecoClaimTaskRowMapper());
	}	

	/**
	 * Get the Claim Tasks based on  Id
	 * 
	 * @param claimsTaskId
	 * @return
	 */
	@Transactional(readOnly = true)
	public ElsecoClaimsTasks getClaimTaskById(int claimsTaskId) throws Exception{	
		try {
			return (ElsecoClaimsTasks) jdbcTemplate.queryForObject(
					"select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimTasks_T\" where CLAIM_TASK_ID=?",
					new Object[] { claimsTaskId }, new ElsecoClaimTaskRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	/**
	 * A method to a add the Claims Reserve to the backend Database
	 * 
	 * @return
	 */	
	public long insertClaimTask(final ElsecoClaimsTasks elsecoClaims) throws Exception{
		LOG.info("About to insertClaimTask :"+elsecoClaims.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimTasks_T\" (CLAIM_TASK_ID, " + 
				" CLAIM_FILE_ID, CLAIM_ITEM_ID, CLAIM_ID, CLAIM_HEADER_ID, VERSION, EFFECTIVE_DATE, TASK_CD, FLG_MANUAL, STATUS, " + 
				" SUBOBJ_CATG, SUB_OBJECT, TASK_NAME, TASK_DESC, ACTIVITY_USED, DT_FIRST_SUBM, DT_LATEST_START, DT_LATEST_END, " + 
				" DT_FIRST_SUBM_TIME, DT_LATEST_END_TIME, TASK_PRIORITY, TASK_HANDLR_CATG, TASK_HANDLER, AUTH_GRP, AUTH_USR, NOTIFY_SENT, " + 
				" NOTIFY_RECEIPIENTS, DELETE_FLAG ) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_TASKS);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, elsecoClaims.getClaimFileId(), elsecoClaims.getClaimItemId(), elsecoClaims.getClaimId(),
						elsecoClaims.getClaimHeaderId(), elsecoClaims.getVersion(), elsecoClaims.getEffectiveDate(), elsecoClaims.getTaskCode(), 
						elsecoClaims.getFlgManual(), elsecoClaims.getStatus(), elsecoClaims.getSubObjCatgory(), elsecoClaims.getSubObject()  ,
						elsecoClaims.getTaskName() , elsecoClaims.getTaskDesc() , elsecoClaims.getActivityUsed() , elsecoClaims.getDateFirstSubmitted() , elsecoClaims.getDateLatestStart() ,
						elsecoClaims.getDateLatestEnd() , elsecoClaims.getDateFirstSubmittedTime() , elsecoClaims.getDateLatestEndTime() , elsecoClaims.getTaskPriority() , elsecoClaims.getTaskHandlerCatgory() ,
						elsecoClaims.getTaskHandler(), elsecoClaims.getAuthGroup(), elsecoClaims.getAuthUser(), elsecoClaims.getNotifySent(), elsecoClaims.getNotifyReceipients(),elsecoClaims.getDeleteFlag().toUpperCase() });
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims Tasks in Database
	 * 
	 * @return
	 */
	public int updateElsecoClaimTask(ElsecoClaimsTasks elsecoClaims) throws Exception{
		LOG.info("About to updateElsecoClaimTask :"+elsecoClaims.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimTasks_T\"  set "
				+ " EFFECTIVE_DATE = ?, TASK_CD = ?, FLG_MANUAL = ?, STATUS = ?, SUBOBJ_CATG = ?, SUB_OBJECT = ?, TASK_NAME = ?, " 
				+ " TASK_DESC = ?, ACTIVITY_USED = ?, DT_FIRST_SUBM = ?, DT_LATEST_START = ?, DT_LATEST_END = ?, DT_FIRST_SUBM_TIME = ?, "
				+ " DT_LATEST_END_TIME = ?, TASK_PRIORITY = ?, TASK_HANDLR_CATG = ?, TASK_HANDLER = ?, AUTH_GRP = ?, "
				+ " AUTH_USR = ?, NOTIFY_SENT = ?, NOTIFY_RECEIPIENTS = ?, DELETE_FLAG = ? WHERE CLAIM_TASK_ID = ? AND CLAIM_FILE_ID = ? AND CLAIM_ITEM_ID = ? "
				+ " AND CLAIM_ID = ? AND  CLAIM_HEADER_ID = ? AND VERSION = ? ",
				new Object[] { elsecoClaims.getEffectiveDate(), elsecoClaims.getTaskCode(), elsecoClaims.getFlgManual(), elsecoClaims.getStatus(),
						elsecoClaims.getSubObjCatgory(), elsecoClaims.getSubObject(), elsecoClaims.getTaskName(), elsecoClaims.getTaskDesc(),
						elsecoClaims.getActivityUsed(), elsecoClaims.getDateFirstSubmitted(), elsecoClaims.getDateLatestStart(), 
						elsecoClaims.getDateLatestEnd(), elsecoClaims.getDateFirstSubmittedTime(), elsecoClaims.getDateLatestEndTime(),
						elsecoClaims.getTaskPriority(), elsecoClaims.getTaskHandlerCatgory(), elsecoClaims.getTaskHandler(),
						elsecoClaims.getAuthGroup(), elsecoClaims.getAuthUser(), elsecoClaims.getNotifySent(), elsecoClaims.getNotifyReceipients(), elsecoClaims.getDeleteFlag().toUpperCase(),
						elsecoClaims.getClaimTaskId(), elsecoClaims.getClaimFileId(), elsecoClaims.getClaimItemId(),  elsecoClaims.getClaimId(),  
						elsecoClaims.getClaimHeaderId(), elsecoClaims.getVersion() });
	}

	/**
	 * A method to delete the Claim Tasks from Data Layer
	 * 
	 * @return
	 */
	public int deleteElsecoClaimTasksById(long id) throws Exception{
		LOG.info("About to delete ElsecoClaimsTasks By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimTasks_T\"  where CLAIM_TASK_ID = ?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsTaskExists(int claimTaskId) throws Exception{
		ElsecoClaimsTasks claims = getClaimTaskById(claimTaskId);
		if(claims == null) {
			return false;					
		}
		return true;
	}
		

	/**
	 * A method to a Get all the Claims Files from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsFile> getAllClaimFile() throws Exception{
		return jdbcTemplate.query("SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimFile_T\" ",
				new ElsecoClaimsFileRowMapper());
	}	

	/**
	 * Get the Claim Tasks based on  Id
	 * 
	 * @param claimsTaskId
	 * @return
	 */
	@Transactional(readOnly = true)
	public ElsecoClaimsFile getClaimFileById(int claimFileId) throws Exception{	
		try {
			return (ElsecoClaimsFile) jdbcTemplate.queryForObject(
					"select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimFile_T\" where CLAIM_FILE_ID=? ",
					new Object[] { claimFileId }, new ElsecoClaimsFileRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	/**
	 * A method to a add the Claims Reserve to the backend Database
	 * 
	 * @return
	 */	
	public long insertClaimFile(final ElsecoClaimsFile elsecoClaims) throws Exception{
		//LOG.info("About to insertClaimFile :"+elsecoClaims.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimFile_T\" (CLAIM_FILE_ID, " + 
				" CLAIM_ID, CLAIM_HEADER_ID, VERSION, CLAIM_FILE_TYPE, CHNG_INDICATOR, STATUS_CHNG_REASON, FILE_STATUS, STATUSCHNG_BY, STATUSCHNG_TIME, DELETE_FLAG ) "
				+ " values  (?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_FILES);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, elsecoClaims.getClaimId(), elsecoClaims.getClaimHeaderId(), elsecoClaims.getVersion(), elsecoClaims.getClaimFileType(), elsecoClaims.getChangeIndicator(),
						elsecoClaims.getStatusChangeReason(), elsecoClaims.getFileStatus(), elsecoClaims.getStatusChangeBy(), elsecoClaims.getStatusChangeTime(),
						elsecoClaims.getDeleteFlag().toUpperCase() });
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}
	
	/**
	 * A method to update the Claims Files in Database
	 * 
	 * @return
	 */
	public int updateElsecoClaimFile(ElsecoClaimsFile elsecoClaims) throws Exception{
		//LOG.info("About to updateElsecoClaimFile :"+elsecoClaims.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimFile_T\"  set "
				+ " VERSION = ?, CLAIM_HEADER_ID = ?, CLAIM_FILE_TYPE = ?, CHNG_INDICATOR = ?, STATUS_CHNG_REASON = ?, FILE_STATUS = ?, STATUSCHNG_BY = ?, " 
				+ " STATUSCHNG_TIME = ?, DELETE_FLAG = ? WHERE CLAIM_ID = ? AND CLAIM_FILE_ID = ?",
				new Object[] { elsecoClaims.getVersion(), elsecoClaims.getClaimHeaderId(), elsecoClaims.getClaimFileType(), elsecoClaims.getChangeIndicator(),
						elsecoClaims.getStatusChangeReason(), elsecoClaims.getFileStatus(), elsecoClaims.getStatusChangeBy(), elsecoClaims.getStatusChangeTime(),
						elsecoClaims.getDeleteFlag().toUpperCase(), elsecoClaims.getClaimId(), elsecoClaims.getClaimFileId() });
	}
	
	/**
	 * A method to delete the Claim files from Data Layer
	 * 
	 * @return
	 */
	public int deleteElsecoClaimFileById(long id) throws Exception{
		LOG.info("About to delete ElsecoClaimsFile By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimFile_T\"  where CLAIM_FILE_ID = ?",
				new Object[] { id });
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsFileExists(int claimFileId) throws Exception{
		ElsecoClaimsFile claims = getClaimFileById(claimFileId);
		if(claims == null) {
			return false;					
		}
		return true;
	}
	
	
	/**
	 * A method to a Get all the Claims Transactions from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsTransaction> getAllClaimTransaction() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_Transactions_T\" ",	new ElsecoClaimsTransactionRowMapper());
	}

	/**
	 * Get the Claim Transaction based on Id
	 * 
	 * @param Id
	 * @return
	 */
	@Transactional(readOnly = true)
	public ElsecoClaimsTransaction getClaimTransactionById(int Id) throws Exception{
		try {
			return (ElsecoClaimsTransaction) jdbcTemplate.queryForObject("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_Transactions_T\" where CLAIM_TRANSACTION_ID=?",
					new Object[] { Id }, new ElsecoClaimsTransactionRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * A method to a add the Claims Transaction to the backend Database
	 * 
	 * @return
	 */
	public long insertClaimTransaction(final ElsecoClaimsTransaction elsecoClaims) throws Exception{
		LOG.info("About to insertClaimTransaction :" + elsecoClaims.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_Transactions_T\" (CLAIM_TRANSACTION_ID, CLAIM_HEADER_ID, CLAIM_ID, CLAIM_ITEM_ID, "
				+ " APPLICATIONHANDLE, MODULEHANDLE, SCREENHANDLE, UMR_NO, UCR_NO, POLICY_TRANSREF_NO, MARKET_TRANSREF_NO, TRANSACTIONTYPE, TRANSACTIONSUBTYPE, TRANSACTION_DESCRIPTION, COMMENT, "
				+ " OUTSTNDCLAMT, PREVPDCLAMT_INDEMNITY, PREVPDCLAMT_FEES, PREVPDCLAMT_EXPENSES, NWINCURDCLAMT, SETLMNTCLAMT_INDEMNITY, SETLMNTCLAMT_FEES, SETLMNTCLAMT_EXPENSES, RESERVEAMOUNT_INDEMNITY, "
				+ " RESERVEAMOUNT_FEES, RESERVEAMOUNT_EXPENSES, ORIGINALCURRENCY,DUEDATE, INCOMING_PAYMENT,OUTGOING_PAYMENT, SPLIT_CLAIM_PERC_VL,"
				+ " SPLIT_CLAIM_PERC_AMT,INTERNALSTATUS,EXTERNALSTATUS, NEXT_STATUS, PARTY_ID, PARTY_NAME, PARTY_BP_ID, TRANSACTIONCURRENCY, RATE_OF_EXCH, ORIGINAL_AMT, "
				+ " AUTHOR, EXTRNL_ID, PRINT_SORT_CODE, ECF_INDICATOR, CARRIER_CODE, CARRIER_PERCENTAGE, CARRIER_REFERENCE, ROLE, CLAIM_REFERENCE_1, CLAIM_REFERENCE_2, "
				+ " LLOYDS_CATASTROPHE_CODE, PCS_CODE, COLLECTION_TYPE, CREATEDBY, CREATEDDATE, RESERVE_UPDATE_FLAG, VERF_PAID_FLAG, APPROVE_ENABLED,"
				+ " REJECT_ENABLED, RELEASE_PAY_ENABLED, RESERVE_ENABLED, COLLECT_PAY_ENABLED, TRANS_RECORD_TYPE, LIMIT_CURRENCY_CD, DELETE_FLAG )  values "
				+ " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_TRANSACTIONS);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, elsecoClaims.getClaimHeaderid(), elsecoClaims.getClaimid(), elsecoClaims.getClaimItemId(), elsecoClaims.getApplicationhandle(),
						elsecoClaims.getModulehandle(), elsecoClaims.getScreenhandle(), elsecoClaims.getUmrNumber(), elsecoClaims.getUcrNumber(), elsecoClaims.getPolicyTransRefNo(),
						elsecoClaims.getMarketTransRefNo(),elsecoClaims.getTransactionType(),elsecoClaims.getTransactionSubType(), elsecoClaims.getTransDescription(), elsecoClaims.getComment(), elsecoClaims.getOutStndclamt(), 
						elsecoClaims.getPrevpaidAmtIndemnityTR(), elsecoClaims.getPrevpaidAmtFeesTR(), elsecoClaims.getPrevpaidAmtExpensesTR(), returnValidAmount(elsecoClaims.getNwincurdclamt()), returnValidAmount(elsecoClaims.getSettlementAmtIndemnityTR()), 
						returnValidAmount(elsecoClaims.getSettlementAmtFeesTR()), returnValidAmount(elsecoClaims.getSettlementAmtExpensesTR()), elsecoClaims.getReserveAmountIndemnityTR(), elsecoClaims.getReserveAmountFeesTR(), 
						elsecoClaims.getReserveAmountExpensesTR(), elsecoClaims.getOriginalCurrency(), elsecoClaims.getDueDate(), elsecoClaims.getIncomingPayment(), elsecoClaims.getOutgoingPayment(), elsecoClaims.getSplitClaimPercVl(),
						elsecoClaims.getSplitClaimPercAmt(), elsecoClaims.getInternalStatus(),elsecoClaims.getExternalStatus(),elsecoClaims.getNextStatus(), elsecoClaims.getPartyId(), elsecoClaims.getPartyName(), elsecoClaims.getPartyBpId(),
						elsecoClaims.getTransactionCurrency(), elsecoClaims.getRateOfExchange(), elsecoClaims.getOriginalAmount(),
						elsecoClaims.getAuthor(), elsecoClaims.getExtrnlid(), elsecoClaims.getPrintSortCode(), elsecoClaims.getEcfIndicator(), elsecoClaims.getCarrierCode(),
						elsecoClaims.getCarrierPercentage(), elsecoClaims.getCarrierReference(), elsecoClaims.getRole(), elsecoClaims.getClaimReference1(), elsecoClaims.getClaimReference2(),
						elsecoClaims.getLloydsCatastropheCode(), elsecoClaims.getPcsCode(), elsecoClaims.getCollectionType(), elsecoClaims.getCreatedby(), getCurrentTimestampForSQL(), elsecoClaims.getReserveUpdateFlag(),
						elsecoClaims.getVerfPaidFlag(), elsecoClaims.getApproveEnabled(), elsecoClaims.getRejectEnabled(), elsecoClaims.getReleasePayEnabled(), 
						elsecoClaims.getReserveEnabled(), elsecoClaims.getCollectPayEnabled(), elsecoClaims.getTransactionRecordType(), elsecoClaims.getLimitCurrencyCode(), elsecoClaims.getDeleteFlag().toUpperCase() });
		if (result == 1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the claim Transaction in Database
	 * 
	 * @return
	 */
	public int updateElsecoClaimTransaction(ElsecoClaimsTransaction elsecoClaims) throws Exception{
		LOG.info("About to updateElsecoClaimTransaction :" + elsecoClaims.toString());
		//Note: Please do not include the CREATEDDATE column here. Its a Update method, and CREATEDDATE is used only during INSERT operation
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_Transactions_T\"  set  CLAIM_HEADER_ID=?, CLAIM_ID=?, CLAIM_ITEM_ID=?, " 
						+ " APPLICATIONHANDLE=?, MODULEHANDLE=?, SCREENHANDLE=?, UMR_NO=?, UCR_NO=?, POLICY_TRANSREF_NO=?, MARKET_TRANSREF_NO=?, TRANSACTIONTYPE=?, TRANSACTIONSUBTYPE=?, TRANSACTION_DESCRIPTION=?, COMMENT=?, " 
						+ " OUTSTNDCLAMT=?, PREVPDCLAMT_INDEMNITY=?, PREVPDCLAMT_FEES=?, PREVPDCLAMT_EXPENSES =?, NWINCURDCLAMT=?, SETLMNTCLAMT_INDEMNITY=?, SETLMNTCLAMT_FEES=?, SETLMNTCLAMT_EXPENSES=?, "
						+ " RESERVEAMOUNT_INDEMNITY=?, RESERVEAMOUNT_FEES=?, RESERVEAMOUNT_EXPENSES=?, ORIGINALCURRENCY=?, DUEDATE=?, INCOMING_PAYMENT=?,OUTGOING_PAYMENT=?, SPLIT_CLAIM_PERC_VL=?,"
						+ " SPLIT_CLAIM_PERC_AMT=?,INTERNALSTATUS=?,EXTERNALSTATUS=?, NEXT_STATUS=?, PARTY_ID = ?, PARTY_NAME =?, PARTY_BP_ID = ?, TRANSACTIONCURRENCY = ?, RATE_OF_EXCH = ?, ORIGINAL_AMT = ?, "
						+ " AUTHOR=?, EXTRNL_ID=?, PRINT_SORT_CODE=?, ECF_INDICATOR=?, CARRIER_CODE=?, CARRIER_PERCENTAGE=?, CARRIER_REFERENCE=?, ROLE=?, CLAIM_REFERENCE_1=?, CLAIM_REFERENCE_2=?,"  
						+ " LLOYDS_CATASTROPHE_CODE=?, PCS_CODE=?, COLLECTION_TYPE=?, CREATEDBY=?, RESERVE_UPDATE_FLAG=?, VERF_PAID_FLAG=?, APPROVE_ENABLED =? , "  
						+ "	REJECT_ENABLED =?, RELEASE_PAY_ENABLED =?, RESERVE_ENABLED =?, COLLECT_PAY_ENABLED =?, TRANS_RECORD_TYPE = ?, LIMIT_CURRENCY_CD = ?,DELETE_FLAG=?"
				+ " WHERE CLAIM_TRANSACTION_ID = ? ",
				new Object[] { elsecoClaims.getClaimHeaderid(), elsecoClaims.getClaimid(), elsecoClaims.getClaimItemId(), elsecoClaims.getApplicationhandle(),
						elsecoClaims.getModulehandle(), elsecoClaims.getScreenhandle(), elsecoClaims.getUmrNumber(), elsecoClaims.getUcrNumber(), elsecoClaims.getPolicyTransRefNo(),
						elsecoClaims.getMarketTransRefNo(),elsecoClaims.getTransactionType(),elsecoClaims.getTransactionSubType(), elsecoClaims.getTransDescription(), elsecoClaims.getComment(), elsecoClaims.getOutStndclamt(), 
						elsecoClaims.getPrevpaidAmtIndemnityTR(), elsecoClaims.getPrevpaidAmtFeesTR(), elsecoClaims.getPrevpaidAmtExpensesTR(), returnValidAmount(elsecoClaims.getNwincurdclamt()), returnValidAmount(elsecoClaims.getSettlementAmtIndemnityTR()), 
						returnValidAmount(elsecoClaims.getSettlementAmtFeesTR()), returnValidAmount(elsecoClaims.getSettlementAmtExpensesTR()), elsecoClaims.getReserveAmountIndemnityTR(), elsecoClaims.getReserveAmountFeesTR(), 
						elsecoClaims.getReserveAmountExpensesTR(), elsecoClaims.getOriginalCurrency(), elsecoClaims.getDueDate(), elsecoClaims.getIncomingPayment(), elsecoClaims.getOutgoingPayment(), elsecoClaims.getSplitClaimPercVl(),
						elsecoClaims.getSplitClaimPercAmt(),elsecoClaims.getInternalStatus(),elsecoClaims.getExternalStatus(),elsecoClaims.getNextStatus(), elsecoClaims.getPartyId(), elsecoClaims.getPartyName(),  elsecoClaims.getPartyBpId(),
						elsecoClaims.getTransactionCurrency(), elsecoClaims.getRateOfExchange(), elsecoClaims.getOriginalAmount(), elsecoClaims.getAuthor(), elsecoClaims.getExtrnlid(), elsecoClaims.getPrintSortCode(), elsecoClaims.getEcfIndicator(), elsecoClaims.getCarrierCode(),
						elsecoClaims.getCarrierPercentage(), elsecoClaims.getCarrierReference(), elsecoClaims.getRole(), elsecoClaims.getClaimReference1(), elsecoClaims.getClaimReference2(),
						elsecoClaims.getLloydsCatastropheCode(), elsecoClaims.getPcsCode(),  elsecoClaims.getCollectionType(), elsecoClaims.getCreatedby(), elsecoClaims.getReserveUpdateFlag(),
						elsecoClaims.getVerfPaidFlag(), elsecoClaims.getApproveEnabled(), elsecoClaims.getRejectEnabled(), elsecoClaims.getReleasePayEnabled(), elsecoClaims.getReserveEnabled(),
						elsecoClaims.getCollectPayEnabled(), elsecoClaims.getTransactionRecordType(), elsecoClaims.getLimitCurrencyCode(), elsecoClaims.getDeleteFlag().toUpperCase(), elsecoClaims.getClaimsTransactionId() });
	}

	/**
	 * A method to delete the Claim Transaction from Data Layer
	 * 
	 * @return
	 */
	public int deleteElsecoClaimTransactionById(long id) throws Exception{
		LOG.info("About to delete ElsecoClaimsTransaction By Id :" + id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_Transactions_T\"  where CLAIM_TRANSACTION_ID = ?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsTransactionExists(int Id) throws Exception{
		ElsecoClaimsTransaction claims = getClaimTransactionById(Id);
		if (claims == null) {
			return false;
		}
		return true;
	}	
	
	/**
	 * A method to a Get all the RiskObjects from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoRiskObject> getAllRiskObjects() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\" ",
				new ElsecoClaimRiskobjRowMapper() );
	}			
	
	/**
	 * A method to a Get a specific RiskObjects based on its unique key from Data Layer
	 * 
	 * @return
	 */
	
	@Transactional(readOnly = true)
	public ElsecoRiskObject getRiskObjectById(int riskid) throws Exception{		
		try {
			return (ElsecoRiskObject) jdbcTemplate.queryForObject(
					"SELECT * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\" WHERE RISKOBJ_ID = ?",
					new Object[] { riskid }, new ElsecoClaimRiskobjRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * A method to a add the RiskObjects to the backend Database
	 * 
	 * @return
	 */
	
	public long insertRiskObject(final ElsecoRiskObject riskobject) throws Exception{
		LOG.info("About to insertRiskObject :"+riskobject.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\" (RISKOBJ_ID, "
				+ " RISKOBJ_NAME, RISKOBJ_DESC, RISKOBJ_REGNO, RISKOBJ_START_DATE, RISKOBJ_END_DATE, RISKSUMINSURED, CLAIM_HEADER_ID, "
				+ " UCR_NO, CLAIM_DETAIL_ID, EXTREFNO, CREATED_DATE, CREATED_BY, MODIFIED_DATE, MODIFIED_BY, DELETE_FLAG ) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_RISKOBJ);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, riskobject.getRiskObjName(),riskobject.getRiskObjDesc(),
						 riskobject.getRiskObjRegNo(),riskobject.getRiskObjStDt(),riskobject.getRiskObjEdDt(),
						 riskobject.getRiskSumInsured(),riskobject.getClaimHeaderId(),riskobject.getUcrNo(),
						 riskobject.getClaimDetailId(), riskobject.getExternalRefNo(),riskobject.getCreatedDt(),
						 riskobject.getCreatedBy(),riskobject.getModifiedDate(),riskobject.getModifiedBy(),
						 riskobject.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the RiskObjects in Database
	 * 
	 * @return
	 */
	public int updateRiskObject(ElsecoRiskObject riskobject) throws Exception{
		LOG.info("About to updateRiskObject :"+riskobject.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\"  set "
				+ "RISKOBJ_NAME = ?,RISKOBJ_DESC = ?,RISKOBJ_REGNO=?,RISKOBJ_START_DATE=?,RISKOBJ_END_DATE=?,RISKSUMINSURED=?,"
				+ "UCR_NO=?, EXTREFNO=?,CREATED_DATE=?,CREATED_BY=?,MODIFIED_DATE=?,MODIFIED_BY=?,DELETE_FLAG=? "
				+ "where   RISKOBJ_ID = ? AND CLAIM_HEADER_ID = ? AND CLAIM_DETAIL_ID=? ",
				new Object[] {riskobject.getRiskObjName(),riskobject.getRiskObjDesc(),riskobject.getRiskObjRegNo(),
						 riskobject.getRiskObjStDt(),riskobject.getRiskObjEdDt(),riskobject.getRiskSumInsured(),						 
						 riskobject.getUcrNo(), riskobject.getExternalRefNo(), riskobject.getCreatedDt(), riskobject.getCreatedBy(), 
						 riskobject.getModifiedDate(), riskobject.getModifiedBy(), riskobject.getDeleteFlag().toUpperCase(), riskobject.getRiskObjId(),
						 riskobject.getClaimHeaderId(), riskobject.getClaimDetailId()});
	}

	/**
	 * A method to delete the RiskObjects from Data Layer
	 * 
	 * @return
	 */
	public int deleteRiskObjectId(long id) throws Exception{
		LOG.info("About to delete RiskObject By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\"  where RISKOBJ_ID=?",
				new Object[] { id });
	}
		
	/**
	 * A method to delete the RiskObjects from Data Layer
	 * 
	 * @return
	 */
//	public int deleteTemporaryRiskObject(ElsecoRiskObject newClaimRisk) throws Exception{
//		LOG.info(" Temporary Method to delete for RiskObject By Id :"+newClaimRisk.getRiskObjId());
//		return jdbcTemplate.update(
//				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\"  where RISKOBJ_ID <> ? AND CLAIM_DETAIL_ID = ? AND CLAIM_HEADER_ID = ?",
//				new Object[] { newClaimRisk.getRiskObjId(), newClaimRisk.getClaimDetailId(), newClaimRisk.getClaimHeaderId() });
//	}
	
	/**
	 * A method to Know the RiskObjects is in Database or not
	 * 
	 * @return
	 */
	public boolean isRiskObjectExists(int id) throws Exception{
		ElsecoRiskObject riskobject = getRiskObjectById(id);
		if(riskobject == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * A method to a Get all the MemberInfo from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoMemberInfo> getAllMemberInfo() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\" ",
				new ElsecoMemberInfoRowMapper() );
	}			
	
	/**
	 * A method to a Get a specific MemberInfo based on its unique key from Data Layer
	 * 
	 * @return
	 */
	
	@Transactional(readOnly = true)
	public ElsecoMemberInfo getMemberInfoById(int MEMBER_ID) throws Exception{		
		try {
			return (ElsecoMemberInfo) jdbcTemplate.queryForObject(
					"SELECT * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\" WHERE MEMBER_ID = ?",
					new Object[] { MEMBER_ID }, new ElsecoMemberInfoRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * A method to a add the MemberInfo to the backend Database
	 * 
	 * @return
	 */	
	public long insertMemberInfo(final ElsecoMemberInfo memberInfo) throws Exception{
		LOG.info("About to insertMemberInfo :"+memberInfo.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\" (MEMBER_ID, CLAIM_ID, MARKET_TRANSACTION_ID, "
				+ " POLICY_TRANSACTION_ID, INTREF_ID, STAMP_ID, CLAIM_HEADER_ID, MEMBER_BP_ID, STAMP_NAME, STAMPSTART_DT, STAMPEND_DT, STAMPSTATUS_ID, STAMP_DESCRIPTION, FRONTIER, TRANSACTIONING, PAYER_ID, PAYER_NAME, CREATEDON, APPROVEDON, "
				+ " CREATEDBY, SUBMITTEDBY, SUBMITTEDON, APPROVEDBY, POOLUWY_ID,PREVPDCLAMT_INDEMNITY,PREVPDCLAMT_FEES,PREVPDCLAMT_EXPENSES,SETLMNTCLAMT_INDEMNITY,SETLMNTCLAMT_FEES,SETLMNTCLAMT_EXPENSES,"
				+ " RESERVEAMOUNT_INDEMNITY,RESERVEAMOUNT_FEES,RESERVEAMOUNT_EXPENSES, IS_COLLECTED, STATUS, SPLIT_CLAIM_PERC_VL,SPLIT_CLAIM_PERC_AMT, COLLECTION_TYPE,"
				+ " AVAILCLM_FUND, AVAILOFFSET_PRMIUM, MEMBER_NAME, MEMBER_EMAIL, NOTIFY_ENABLED, DUE_DATE, COLLECTED_DATE, DELETE_FLAG ) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_MEMBER_INFO);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, memberInfo.getClaimId(), memberInfo.getMarketTransactionId(), memberInfo.getPolicyTransactionId(), 
						memberInfo.getIntRefId(), memberInfo.getStampId(), memberInfo.getClaimHeaderId(), memberInfo.getMemberBpId(), memberInfo.getStampName(), memberInfo.getStampStartDate(), memberInfo.getStampEndDate(), 
						memberInfo.getStampStatusId(), memberInfo.getStampDescription(), memberInfo.getFrontier(), memberInfo.getTransactioning(), memberInfo.getPayerId(), memberInfo.getPayerName(), memberInfo.getCreatedOn(), memberInfo.getApprovedOn(), 
						memberInfo.getCreatedBy(), memberInfo.getSubmittedBy(), memberInfo.getSubmittedOn(), memberInfo.getApprovedBy(), memberInfo.getPoolUWYId(), memberInfo.getPrevpaidAmtIndemnityMI(),
						memberInfo.getPrevpaidAmtFeesMI(),memberInfo.getPrevpaidAmtExpensesMI(),returnValidAmount(memberInfo.getSettlementAmtIndemnityMI()),returnValidAmount(memberInfo.getSettlementAmtFeesMI()),
						returnValidAmount(memberInfo.getSettlementAmtExpensesMI()),memberInfo.getReserveAmountIndemnityMI(),memberInfo.getReserveAmountFeesMI(),
						memberInfo.getReserveAmountExpensesMI(), memberInfo.getIsCollected(), memberInfo.getStatus(), memberInfo.getSplitClaimPercVl(),memberInfo.getSplitClaimPercAmt(), memberInfo.getCollectionType(), 
						memberInfo.getAvailableClmFund(), memberInfo.getAvailableOffSetPrm(), memberInfo.getMemberName(), memberInfo.getMemberEmail(), memberInfo.getNotifyEnabled(),
						memberInfo.getDueDate(), memberInfo.getCollectedDate(), memberInfo.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the MemberInfo in Database
	 * 
	 * @return
	 */
	public int updateMemberInfo(ElsecoMemberInfo memberInfo) throws Exception{
		LOG.info("About to updateMemberInfo :"+memberInfo.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\"  set CLAIM_ID=?, MARKET_TRANSACTION_ID=?, MEMBER_BP_ID = ?, "
						+ " POLICY_TRANSACTION_ID=?, INTREF_ID=?, STAMP_ID=?, CLAIM_HEADER_ID=?, STAMP_NAME=?, STAMPSTART_DT=?, STAMPEND_DT=?, STAMPSTATUS_ID=?, STAMP_DESCRIPTION=?, FRONTIER=?, TRANSACTIONING=?, PAYER_ID =?, PAYER_NAME = ?, CREATEDON=?, APPROVEDON=?, "
						+ " CREATEDBY=?, SUBMITTEDBY=?, SUBMITTEDON=?, APPROVEDBY=?, POOLUWY_ID=?,PREVPDCLAMT_INDEMNITY=?,PREVPDCLAMT_FEES=?,PREVPDCLAMT_EXPENSES=?,SETLMNTCLAMT_INDEMNITY=?,SETLMNTCLAMT_FEES=?,SETLMNTCLAMT_EXPENSES=?,"
						+ " RESERVEAMOUNT_INDEMNITY=?,RESERVEAMOUNT_FEES=?,RESERVEAMOUNT_EXPENSES=?,IS_COLLECTED=?, STATUS=?, SPLIT_CLAIM_PERC_VL=?,SPLIT_CLAIM_PERC_AMT=?, COLLECTION_TYPE=?,"
						+ " AVAILCLM_FUND=?, AVAILOFFSET_PRMIUM=?, MEMBER_NAME=?, MEMBER_EMAIL=?, NOTIFY_ENABLED=?, DUE_DATE=?, COLLECTED_DATE=?, DELETE_FLAG=? where MEMBER_ID=? ",
				new Object[] {memberInfo.getClaimId(), memberInfo.getMarketTransactionId(), memberInfo.getMemberBpId(), memberInfo.getPolicyTransactionId(), 
						memberInfo.getIntRefId(), memberInfo.getStampId(), memberInfo.getClaimHeaderId(), memberInfo.getStampName(), memberInfo.getStampStartDate(), memberInfo.getStampEndDate(), 
						memberInfo.getStampStatusId(), memberInfo.getStampDescription(), memberInfo.getFrontier(), memberInfo.getTransactioning(), memberInfo.getPayerId(), memberInfo.getPayerName(), memberInfo.getCreatedOn(), 
						memberInfo.getApprovedOn(), memberInfo.getCreatedBy(), memberInfo.getSubmittedBy(), memberInfo.getSubmittedOn(),memberInfo.getApprovedBy(),
						memberInfo.getPoolUWYId(),memberInfo.getPrevpaidAmtIndemnityMI(), memberInfo.getPrevpaidAmtFeesMI(),memberInfo.getPrevpaidAmtExpensesMI(), returnValidAmount(memberInfo.getSettlementAmtIndemnityMI()),
						returnValidAmount(memberInfo.getSettlementAmtFeesMI()), returnValidAmount(memberInfo.getSettlementAmtExpensesMI()),memberInfo.getReserveAmountIndemnityMI(),memberInfo.getReserveAmountFeesMI(),
						memberInfo.getReserveAmountExpensesMI(),memberInfo.getIsCollected(),memberInfo.getStatus(),memberInfo.getSplitClaimPercVl(),memberInfo.getSplitClaimPercAmt(), memberInfo.getCollectionType(), 
						memberInfo.getAvailableClmFund(), memberInfo.getAvailableOffSetPrm(), memberInfo.getMemberName(), memberInfo.getMemberEmail(), memberInfo.getNotifyEnabled(),
						memberInfo.getDueDate(), memberInfo.getCollectedDate(), memberInfo.getDeleteFlag().toUpperCase(),memberInfo.getMemberId()});
	}

	/**
	 * A method to delete the MemberInfo from Data Layer
	 * 
	 * @return
	 */
	public int deleteMemberInfoId(long id) throws Exception{
		LOG.info("About to delete MemberInfo By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\"  where MEMBER_ID=?",
				new Object[] { id });
	}
	/**
	 * A method to Know the MemberInfo is in Database or not
	 * 
	 * @return
	 */
	public boolean isMemberInfoExists(int id) throws Exception{
		ElsecoMemberInfo memberInfo = getMemberInfoById(id);
		if(memberInfo == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	@Deprecated
	public List<ElsecoMemberResult> getAllMemberResults() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\" ",
				new ElsecoMemberResultRowMapper());
	}			
		
	/**
	 * 
	 * @param resultId
	 * @return
	 */
	@Transactional(readOnly = true)
	@Deprecated
	public ElsecoMemberResult getMemberResultsById(int resultId) throws Exception{		
		try {
			return (ElsecoMemberResult) jdbcTemplate.queryForObject(
					"SELECT * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\" WHERE RESULT_ID = ?",
					new Object[] { resultId }, new ElsecoMemberResultRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	
	/**
	 * 
	 * @param memberResult
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public long insertMemberResults(final ElsecoMemberResult memberResult) throws Exception{
		LOG.info("About to insertMemberResults :"+memberResult.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\" (RESULT_ID, MEMBER_ID, MARKET_TRANSACTION_ID, POLICY_TRANSACTION_ID, CLAIM_ID, CLAIM_HEADER_ID, "
				+ " INTREF_ID, STAMP_ID, ELRISKCODE_ID, MEMBER_BPID, MEMBER_NAME, TOTAL_CAPACITY_AMT, TOTAL_SHARE_VL, OWN_CAPACITY_AMT, "
				+ " OWN_SHARE_VL, PAY_PREMIUM_TO_BPID, PAY_POLICY_BR_TO_BPID, PAY_FF_TO_BPID, PAY_PB_TO_BPID, PAY_RIB_TO_BPID, POLICY_BROKERAGE_VL,  "
				+ " ELSECO_COMMISSION_VL, FF_VL, PB_VL, RIB_VL, PROFIT_COMMISSION_VL, PB_BASIS, FF_BASIS, RIB_BASIS, AGREEMENT_ID, DELETE_FLAG ) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_MEMBER_RESULT);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, memberResult.getMemberId(), memberResult.getMarketTransactionId(), memberResult.getPolicyTransactionId(),
						memberResult.getClaimId(), memberResult.getClaimHeaderId(), memberResult.getIntRefId(),
						memberResult.getStampId(), memberResult.getElRiskCodeId(),memberResult.getMemberBpId(), memberResult.getMemberName(), 
						memberResult.getTotalCapacityAmount(), memberResult.getTotalShareVl(), memberResult.getOwnCapacityAmt(),memberResult.getOwnShareVl(),
						memberResult.getPayPremiumToBpId(), memberResult.getPayPolicyBRtoBpId(),memberResult.getPayFFtoBpId(),memberResult.getPayPBtoBpId(),
						memberResult.getPayRibToBpId(), memberResult.getPolicyBrokerageVl(),memberResult.getElsecoCommissionVl(),
						memberResult.getFfVl(),memberResult.getPbVl(),memberResult.getRibVl(),memberResult.getProfitCommisionVl(),
						memberResult.getPbBasis(),memberResult.getFfBasis(),memberResult.getRibBasis(),memberResult.getAgreementId(),
						memberResult.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * 
	 * @param memberResult
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public int updateMemberResults(ElsecoMemberResult memberResult) throws Exception{
		LOG.info("About to updateMemberResults :"+memberResult.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\"  SET MEMBER_ID=?, MARKET_TRANSACTION_ID =?, POLICY_TRANSACTION_ID = ?, CLAIM_ID=?, CLAIM_HEADER_ID=?, "
				+ " INTREF_ID = ?, STAMP_ID = ?, ELRISKCODE_ID = ?, MEMBER_BPID = ?, MEMBER_NAME = ?, TOTAL_CAPACITY_AMT = ?, TOTAL_SHARE_VL = ?,  "
				+ " OWN_CAPACITY_AMT = ?, OWN_SHARE_VL = ?, PAY_PREMIUM_TO_BPID = ?, PAY_POLICY_BR_TO_BPID = ?, PAY_FF_TO_BPID = ?, PAY_PB_TO_BPID = ?, "
				+ " PAY_RIB_TO_BPID = ?, POLICY_BROKERAGE_VL = ?, ELSECO_COMMISSION_VL = ?, FF_VL = ?, PB_VL = ?, RIB_VL = ?, PROFIT_COMMISSION_VL = ?, "
				+ " PB_BASIS = ?, FF_BASIS = ?, RIB_BASIS = ?, AGREEMENT_ID = ?, DELETE_FLAG = ? WHERE RESULT_ID = ? ",
				new Object[] {memberResult.getMemberId(), memberResult.getMarketTransactionId(), memberResult.getPolicyTransactionId(), memberResult.getClaimId(),
						memberResult.getClaimHeaderId(), memberResult.getIntRefId(), memberResult.getStampId(), 
						memberResult.getElRiskCodeId(),	memberResult.getMemberBpId(), memberResult.getMemberName(),	memberResult.getTotalCapacityAmount(),	
						memberResult.getTotalShareVl(), memberResult.getOwnCapacityAmt(),	memberResult.getOwnShareVl(),	memberResult.getPayPremiumToBpId(),
						memberResult.getPayPolicyBRtoBpId(),	memberResult.getPayFFtoBpId(),	memberResult.getPayPBtoBpId(),
						memberResult.getPayRibToBpId(),	memberResult.getPolicyBrokerageVl(),	memberResult.getElsecoCommissionVl(),
						memberResult.getFfVl(),	memberResult.getPbVl(),memberResult.getRibVl(),	memberResult.getProfitCommisionVl(),
						memberResult.getPbBasis(),	memberResult.getFfBasis(),memberResult.getRibBasis(),	memberResult.getAgreementId(),
						memberResult.getDeleteFlag().toUpperCase(),	memberResult.getResultId() });
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public int deleteMemberResultsById(long id)  throws Exception {
		LOG.info("About to delete MemberResults By Id :"+id);
		return jdbcTemplate.update("DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\"  where RESULT_ID=?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Deprecated
	public boolean iseMemberResultsExists(int id) throws Exception{
		ElsecoMemberResult memberResult = getMemberResultsById(id);
		if(memberResult == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	@Deprecated
	@Transactional(readOnly = true)
	public List<ElsecoMemberRiskcode> getAllMemberRiskcode() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberRiskcode_T\" ",
				new ElsecoMemberRiskcodeRowMapper());
	}			
		
	/**
	 * 
	 * @param resultId
	 * @return
	 */
	@Deprecated
	@Transactional(readOnly = true)
	public ElsecoMemberRiskcode getMemberRiskcodeById(int riskcodeId) throws Exception{		
		try {
			return (ElsecoMemberRiskcode) jdbcTemplate.queryForObject(
					"SELECT * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberRiskcode_T\" WHERE LLRISKCODE_ID = ?",
					new Object[] { riskcodeId }, new ElsecoMemberRiskcodeRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	
	/**
	 * 
	 * @param memberRiskcode
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public long insertMemberRiskcode(final ElsecoMemberRiskcode memberRiskcode) throws Exception{
		LOG.info("About to insertMemberRiskcode :"+memberRiskcode.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberRiskcode_T\" (LLRISKCODE_ID, "				
				+ " RESULT_ID, MEMBER_ID, CLAIM_ID, CLAIM_HEADER_ID, INTREF_ID, MARKET_TRANSACTION_ID, POLICY_TRANSACTION_ID, ELRISK_CODE, ELRISK_DESCRIPTION, LOB_ID, SEGMENT_ID, DELETE_FLAG ) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, memberRiskcode.getResultId(), memberRiskcode.getMemberId(),	memberRiskcode.getClaimId(), 
						memberRiskcode.getClaimHeaderId(),  memberRiskcode.getIntRefId(), memberRiskcode.getMarketTransactionId(), memberRiskcode.getPolicyTransactionId(),
						memberRiskcode.getElRiskCode(), memberRiskcode.getElRiskDescription(), 
						memberRiskcode.getLobId(),	memberRiskcode.getSegmentId(), memberRiskcode.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * 
	 * @param memberRiskcode
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public int updateMemberRiskcode(ElsecoMemberRiskcode memberRiskcode) throws Exception{
		LOG.info("About to updateMemberRiskcode :"+memberRiskcode.toString());
		
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberRiskcode_T\"  SET  RESULT_ID = ?, "
				+ " MEMBER_ID = ?, CLAIM_ID = ?, CLAIM_HEADER_ID =?, INTREF_ID =?, MARKET_TRANSACTION_ID =?, POLICY_TRANSACTION_ID =?, ELRISK_CODE = ?, ELRISK_DESCRIPTION = ?, LOB_ID = ?, SEGMENT_ID = ?, DELETE_FLAG = ? WHERE LLRISKCODE_ID = ? ",
				new Object[] {memberRiskcode.getResultId(), memberRiskcode.getMemberId(), memberRiskcode.getClaimId(), memberRiskcode.getClaimHeaderId(), 
						memberRiskcode.getIntRefId(), memberRiskcode.getMarketTransactionId(), memberRiskcode.getPolicyTransactionId(), memberRiskcode.getElRiskCode(),
						memberRiskcode.getElRiskDescription(), memberRiskcode.getLobId(), memberRiskcode.getSegmentId(), 
						memberRiskcode.getDeleteFlag().toUpperCase(),	memberRiskcode.getLlRiskCodeId() });
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public int deleteMemberRiskcodeById(long id)  throws Exception {
		LOG.info("About to delete MemberRiskcode By Id :"+id);
		return jdbcTemplate.update("DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberRiskcode_T\"  where LLRISKCODE_ID=?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Deprecated
	public boolean iseMemberRiskcodeExists(int id) throws Exception {
		ElsecoMemberRiskcode memberResult = getMemberRiskcodeById(id);
		if(memberResult == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsInternalReference> getAllClaimsInternalReference() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\" ",
				new ElsecoClaimsIntReferenceRowMapper());
	}			
		
	/**
	 * 
	 * @param intRefId
	 * @return
	 */
	@Transactional(readOnly = true)
	public ElsecoClaimsInternalReference getClaimsInternalReferenceById(int intRefId) throws Exception{		
		try {
			return (ElsecoClaimsInternalReference) jdbcTemplate.queryForObject(
					"SELECT * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\" WHERE INTREF_ID = ?",
					new Object[] { intRefId }, new ElsecoClaimsIntReferenceRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	
	/**
	 * 
	 * @param intReference
	 * @return
	 * @throws Exception
	 */
	public long insertClaimsInternalReference(final ElsecoClaimsInternalReference intReference) throws Exception{
		LOG.info("About to insertClaimsInternalReference :"+intReference.toString());
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\" (INTREF_ID, STAMP_ID, CLAIM_HEADER_ID, "				
				+ " CLAIM_ID, POLICY_TRANSACTION_ID, MARKET_TRANSACTION_ID, ELSECO_RISK_CD, INTERNAL_REFERENCE_NO, SPLIT_CLAIM_PERC_VL, SPLIT_CLAIM_PERC_AMT, PREMIUM_SPLIT_VL, "
				+ " STAMP_NAME,IS_COLLECTED, FUNDS_COLLECTED,TRANSACTIONTYPE,TRANSACTIONSUBTYPE,NWINCURDCLAMT,COLLECT_PAY_ENABLED,"
				+ " SETLMNTCLAMT,COMMENT,PREVPDCLAMT,ORIGINALCURRENCY,DUEDATE,PREVPDCLAMT_INDEMNITY,PREVPDCLAMT_FEES,PREVPDCLAMT_EXPENSES,SETLMNTCLAMT_INDEMNITY,SETLMNTCLAMT_FEES,SETLMNTCLAMT_EXPENSES,"
				+ " RESERVEAMOUNT_INDEMNITY,RESERVEAMOUNT_FEES,RESERVEAMOUNT_EXPENSES, DELETE_FLAG ) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_INTERNAL_REF);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, intReference.getStampId(), intReference.getClaimHeaderId(), intReference.getClaimId(), intReference.getPolicyTransactionId(), intReference.getMarketTransactionId(),
						intReference.getElsecoRiskCode(), intReference.getIntReferenceNo(), intReference.getSplitClaimPercVl(), intReference.getSplitClaimPercAmt(),
						intReference.getPremiumSplitVl(), intReference.getStampName(), intReference.getIsCollected(),intReference.getFundsCollected(), intReference.getTransactionType(),
						intReference.getTransactionSubType(),returnValidAmount(intReference.getNwincurdclamt()),intReference.getCollectPayEnabled(), returnValidAmount(intReference.getSetlmntclamt()),
						intReference.getComment(),intReference.getPrevpdclamt(),intReference.getOriginalCurrency(),intReference.getDueDate(),intReference.getPrevpaidAmtIndemnityIR(),
						intReference.getPrevpaidAmtFeesIR(),intReference.getPrevpaidAmtExpensesIR(),returnValidAmount(intReference.getSettlementAmtIndemnityIR()),returnValidAmount(intReference.getSettlementAmtFeesIR()),
						returnValidAmount(intReference.getSettlementAmtExpensesIR()),intReference.getReserveAmountIndemnityIR(),intReference.getReserveAmountFeesIR(),
						intReference.getReserveAmountExpensesIR(),intReference.getDeleteFlag().toUpperCase()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * 
	 * @param intReference
	 * @return
	 * @throws Exception
	 */
	public int updateClaimsInternalReference(ElsecoClaimsInternalReference intReference) throws Exception{
		LOG.info("About to updateClaimsInternalReference :"+intReference.toString());
		
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\"  SET  CLAIM_HEADER_ID = ?, CLAIM_ID = ?, "
				+ " POLICY_TRANSACTION_ID = ?, MARKET_TRANSACTION_ID = ?, ELSECO_RISK_CD = ?, INTERNAL_REFERENCE_NO = ?, SPLIT_CLAIM_PERC_VL = ?, SPLIT_CLAIM_PERC_AMT = ?, PREMIUM_SPLIT_VL = ?, STAMP_ID = ?, STAMP_NAME = ?,"
				+ "IS_COLLECTED=?, FUNDS_COLLECTED = ?, TRANSACTIONTYPE=?,TRANSACTIONSUBTYPE=?,NWINCURDCLAMT=?, COLLECT_PAY_ENABLED=?,"
				+ "SETLMNTCLAMT=?,COMMENT=?,PREVPDCLAMT=?,ORIGINALCURRENCY=?,DUEDATE=?, PREVPDCLAMT_INDEMNITY=?,PREVPDCLAMT_FEES=?,PREVPDCLAMT_EXPENSES=?,SETLMNTCLAMT_INDEMNITY=?,SETLMNTCLAMT_FEES=?,SETLMNTCLAMT_EXPENSES=?,"
				+ " RESERVEAMOUNT_INDEMNITY=?,RESERVEAMOUNT_FEES=?,RESERVEAMOUNT_EXPENSES=?, DELETE_FLAG = ? WHERE INTREF_ID = ? ",
				new Object[] {intReference.getClaimHeaderId(), intReference.getClaimId(), intReference.getPolicyTransactionId(), intReference.getMarketTransactionId(), intReference.getElsecoRiskCode(), 
						intReference.getIntReferenceNo(), intReference.getSplitClaimPercVl(), intReference.getSplitClaimPercAmt(), intReference.getPremiumSplitVl(), 
						intReference.getStampId(), intReference.getStampName(),intReference.getIsCollected(),intReference.getFundsCollected(), intReference.getTransactionType(),
						intReference.getTransactionSubType(),returnValidAmount(intReference.getNwincurdclamt()), intReference.getCollectPayEnabled(), returnValidAmount(intReference.getSetlmntclamt()),
						intReference.getComment(),intReference.getPrevpdclamt(),intReference.getOriginalCurrency(),intReference.getDueDate(),intReference.getPrevpaidAmtIndemnityIR(),
						intReference.getPrevpaidAmtFeesIR(),intReference.getPrevpaidAmtExpensesIR(),returnValidAmount(intReference.getSettlementAmtIndemnityIR()),returnValidAmount(intReference.getSettlementAmtFeesIR()),
						returnValidAmount(intReference.getSettlementAmtExpensesIR()),intReference.getReserveAmountIndemnityIR(),intReference.getReserveAmountFeesIR(),
						intReference.getReserveAmountExpensesIR(),intReference.getDeleteFlag().toUpperCase(),	
						intReference.getIntRefId() });
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteClaimsInternalReferenceById(long id)  throws Exception {
		LOG.info("About to delete Internal Reference By Id :"+id);
		return jdbcTemplate.update("DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\"  where INTREF_ID=?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsInternalReferenceExists(int id) throws Exception{
		ElsecoClaimsInternalReference intRef = getClaimsInternalReferenceById(id);
		if(intRef == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * A method to a Get all the Claims from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsParty> getAllClaimsParty() throws Exception{
		return jdbcTemplate.query("SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimParty_T\" ",
				new ElsecoClaimsPartyRowMapper());
	}			
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer
	 * 
	 * @return
	 */
	// @Cacheable(value="elsecoClaims", unless="#result == null")
	@Transactional(readOnly = true)
	public ElsecoClaimsParty getClaimsPartyById(int partyId) throws Exception{		
		try {
			return (ElsecoClaimsParty) jdbcTemplate.queryForObject(
					"SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimParty_T\" WHERE PARTY_ID = ?",
					new Object[] { partyId }, new ElsecoClaimsPartyRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * A method to a add the Claims to the backend Database
	 * 
	 * @return
	 */
	// @CacheEvict(value = "elsecoClaims", key = "#elsecoClaims.claimHeaderId")
	public long insertClaimsParty(final ElsecoClaimsParty elsecoClaims) throws Exception{
		LOG.info("About to insertClaimsParty :"+elsecoClaims.toString());
		
		final String sqlQ = "INSERT INTO \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimParty_T\" (PARTY_ID, "
				+ " CLAIM_HEADER_ID,UCR_NO,EXTERNAL_REF_NO,PARTY_NAME, PARTY_BP_ID, PARTY_DESCRIPTION,PARTY_INV_SOURCE,"
				+ " PARTY_INTRODUCER_ID,PARTY_INTRODUCER_NAME,PARTY_SERVICE_AMT_INCURED,PARTY_PERC_SERVICE_CHRG_INV1,"
				+ " PARTY_PERC_SERVICE_CHRG_INV2,PARTY_PERC_SERVICE_CHRG_INV3,PARTY_PERC_SERVICE_CHRG_INV4,PARTY_SERVICE_AMT_ADDSUBCHRG,"
				+ " PARTY_SERVICE_AMT_PREVPAID,PARTY_SERVICE_AMT_SETTLED,PARTY_SERVICE_DETAILS,PARTY_INV_INTERNAL_STATUS,"
				+ " PARTY_INV_EXTERNAL_STATUS,PARTY_INV_DATE,PARTY_REMITANCE_ACCT_DTS,PARTY_INV_APPROVAL, COLLECTION_TYPE, DELETE_FLAG ) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_PARTY);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId,elsecoClaims.getClaimHeaderId(), elsecoClaims.getUcrNumber(),elsecoClaims.getExtRefNo(),elsecoClaims.getPartyName(), 
						elsecoClaims.getPartyBpId(), elsecoClaims.getPartyDescription(),elsecoClaims.getPartyInvSource(),elsecoClaims.getPartyIntroducerID(),
						elsecoClaims.getPartyIntroducerName(),elsecoClaims.getPartySrvceAmtIncured(),elsecoClaims.getPartyPercSrvChrgInv1(),
						elsecoClaims.getPartyPercSrvChrgInv2(),elsecoClaims.getPartyPercSrvChrgInv3(),elsecoClaims.getPartyPercSrvChrgInv4(),
						elsecoClaims.getPartyAmtAddSubChrg(),elsecoClaims.getPartySrvcAmtPrevPaid(),elsecoClaims.getPartySrvcAmtSettled(),
						elsecoClaims.getPartySrvcDetails(),elsecoClaims.getPartyInvInternalStatus(),elsecoClaims.getPartyInvExternalStatus(),
						elsecoClaims.getPartyInvDate(),elsecoClaims.getPartyRemitanceAcctDts(),elsecoClaims.getPartyInvApporval(), elsecoClaims.getCollectionType(),
						(elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():"")});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims in Database
	 * 
	 * @return
	 */
	public int updateClaimsParty(ElsecoClaimsParty elsecoClaims) throws Exception{
		LOG.info("About to updateClaimHeader :"+elsecoClaims.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimParty_T\"  set "
						+"	CLAIM_HEADER_ID= ?, UCR_NO= ?,EXTERNAL_REF_NO= ?,PARTY_NAME= ?, PARTY_BP_ID = ?, PARTY_DESCRIPTION= ?,PARTY_INV_SOURCE= ?,"
						+"	PARTY_INTRODUCER_ID= ?,PARTY_INTRODUCER_NAME= ?,PARTY_SERVICE_AMT_INCURED= ?,PARTY_PERC_SERVICE_CHRG_INV1= ?,"
						+"	PARTY_PERC_SERVICE_CHRG_INV2= ?,PARTY_PERC_SERVICE_CHRG_INV3= ?,PARTY_PERC_SERVICE_CHRG_INV4= ?,PARTY_SERVICE_AMT_ADDSUBCHRG= ?,"
						+"	PARTY_SERVICE_AMT_PREVPAID= ?,PARTY_SERVICE_AMT_SETTLED= ?,PARTY_SERVICE_DETAILS= ?,PARTY_INV_INTERNAL_STATUS= ?,"
						+" 	PARTY_INV_EXTERNAL_STATUS= ?,PARTY_INV_DATE= ?,PARTY_REMITANCE_ACCT_DTS= ?,PARTY_INV_APPROVAL= ?, COLLECTION_TYPE =?, DELETE_FLAG = ? where PARTY_ID = ? ",
				new Object[] { elsecoClaims.getClaimHeaderId(), elsecoClaims.getUcrNumber(),elsecoClaims.getExtRefNo(),elsecoClaims.getPartyName(), 
						elsecoClaims.getPartyBpId(), elsecoClaims.getPartyDescription(),elsecoClaims.getPartyInvSource(),elsecoClaims.getPartyIntroducerID(),
						elsecoClaims.getPartyIntroducerName(),elsecoClaims.getPartySrvceAmtIncured(),elsecoClaims.getPartyPercSrvChrgInv1(),
						elsecoClaims.getPartyPercSrvChrgInv2(),elsecoClaims.getPartyPercSrvChrgInv3(),elsecoClaims.getPartyPercSrvChrgInv4(),
						elsecoClaims.getPartyAmtAddSubChrg(),elsecoClaims.getPartySrvcAmtPrevPaid(),elsecoClaims.getPartySrvcAmtSettled(),
						elsecoClaims.getPartySrvcDetails(),elsecoClaims.getPartyInvInternalStatus(),elsecoClaims.getPartyInvExternalStatus(),
						elsecoClaims.getPartyInvDate(),elsecoClaims.getPartyRemitanceAcctDts(),elsecoClaims.getPartyInvApporval(), elsecoClaims.getCollectionType(),
						(elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():""), elsecoClaims.getPartyId() });
	}

	/**
	 * A method to delete the Claims from Data Layer
	 * 
	 * @return
	 */
	public int deleteClaimsPartyById(long id)  throws Exception {
		LOG.info("About to delete ClaimsHeader By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimParty_T\"  where PARTY_ID=?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsPartyExists(int id) throws Exception{
		ElsecoClaimsParty claimparty = getClaimsPartyById(id);
		if(claimparty == null) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * A method to a Get all the Claims from Data Layer
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsPayee> getAllClaimsPayee() throws Exception{
		return jdbcTemplate.query("SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimPayee_T\" ",
				new ElsecoClaimsPayeeRowMapper());
	}			
	
	/**
	 * A method to a Get a specific Claims based on its unique key from Data Layer
	 * 
	 * @return
	 */
	// @Cacheable(value="elsecoClaims", unless="#result == null")
	@Transactional(readOnly = true)
	public ElsecoClaimsPayee getClaimsPayeeById(int payeeId) throws Exception{		
		try {
			return (ElsecoClaimsPayee) jdbcTemplate.queryForObject("SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimPayee_T\" WHERE PAYEE_ID = ?",
					new Object[] { payeeId }, new ElsecoClaimsPayeeRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * A method to a add the Claims to the backend Database
	 * 
	 * @return
	 */
	public long insertClaimsPolicyPayee(final ElsecoClaimsPayee elsecoClaims) throws Exception{
		LOG.info("About to insertClaimsParty :"+elsecoClaims.toString());
		
		final String sqlQ = "INSERT INTO \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimPayee_T\" (PAYEE_ID, "
				+ " CLAIM_HEADER_ID, CLAIM_ID, CLAIM_TRANSACTION_ID, UCR_NO, EXTERNAL_REF_NO, TRANSACTION_REF_NO, PAYEE_BP_ID, PAYEE_NAME, "
				+ " PAYEE_EMAIL, PAYEE_ACCOUNT, PAYEE_AMOUNT, PAYEE_OUTSTNDING_AMOUNT, PAYEE_CURRENCY, PAYEE_TYPE, STATUS, DELETE_FLAG ) values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_POLICY_PAYEE);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId,elsecoClaims.getClaimHeaderId(), elsecoClaims.getClaimId(), elsecoClaims.getClaimTransactionId(),
						elsecoClaims.getUcrNumber(),elsecoClaims.getExtRefNo(),elsecoClaims.getTransRefNo(), elsecoClaims.getPayeeBpId(),
						elsecoClaims.getPayeeName(),elsecoClaims.getPayeeEmail(), elsecoClaims.getPayeeAccount(),elsecoClaims.getPayeeAmount(),
						elsecoClaims.getPayeeOutStandingAmt(), elsecoClaims.getPayeeCurrency(), elsecoClaims.getPayeeType(), elsecoClaims.getStatus(),
						(elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():"")});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims in Database
	 * 
	 * @return
	 */
	public int updateClaimsPayee(ElsecoClaimsPayee elsecoClaims) throws Exception{
		LOG.info("About to updateClaimsPayee :"+elsecoClaims.toString());
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimPayee_T\"  set "
						+"	CLAIM_HEADER_ID= ?, CLAIM_ID= ?, CLAIM_TRANSACTION_ID =?, UCR_NO= ?,EXTERNAL_REF_NO= ?, TRANSACTION_REF_NO =?, PAYEE_BP_ID =?, PAYEE_NAME= ?, "
						+ " PAYEE_EMAIL= ?, PAYEE_ACCOUNT= ?, PAYEE_AMOUNT=?, PAYEE_OUTSTNDING_AMOUNT = ?, PAYEE_CURRENCY= ?, PAYEE_TYPE=?, STATUS= ?, DELETE_FLAG = ? where PAYEE_ID = ? ",
				new Object[] { 
						elsecoClaims.getClaimHeaderId() ,elsecoClaims.getClaimId(), elsecoClaims.getClaimTransactionId(), elsecoClaims.getUcrNumber(),elsecoClaims.getExtRefNo(),
						elsecoClaims.getTransRefNo(),  elsecoClaims.getPayeeBpId(), elsecoClaims.getPayeeName(), elsecoClaims.getPayeeEmail(), elsecoClaims.getPayeeAccount(),
						elsecoClaims.getPayeeAmount(), elsecoClaims.getPayeeOutStandingAmt(), elsecoClaims.getPayeeCurrency(),	elsecoClaims.getPayeeType(), elsecoClaims.getStatus(),
						(elsecoClaims.getDeleteFlag()!=null? elsecoClaims.getDeleteFlag().toUpperCase():""), elsecoClaims.getPayeeId() });
	}

	/**
	 * A method to delete the Claims from Data Layer
	 * 
	 * @return
	 */
	public int deleteClaimsPayeeById(long id)  throws Exception {
		LOG.info("About to delete Elseco Claims Payee By Id :"+id);
		return jdbcTemplate.update("DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimPayee_T\"  where PAYEE_ID=?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimsPayeeExists(int id) throws Exception{
		ElsecoClaimsPayee claimpayee = getClaimsPayeeById(id);
		if(claimpayee == null) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Get the complete list of Check_list from database
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoCheckList> getAllCheckList() throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_CheckList_T\" ",
				new ElsecoCheckListRowMapper());
	}			
	
	/**
	 * A method to a Get a specific Claims check list based on its unique key from Data Layer
	 * 
	 * @return
	 */
	// @Cacheable(value="elsecoClaims", unless="#result == null")
	@Transactional(readOnly = true)
	public ElsecoCheckList getCheckListById(int checklistid) throws Exception{		
		try {
			return (ElsecoCheckList) jdbcTemplate.queryForObject("SELECT * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_CheckList_T\" WHERE CHECKLIST_ID = ?",
					new Object[] { checklistid }, new ElsecoCheckListRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * A method to a add the Claims Check list to the backend Database
	 * 
	 * @return
	 */
	// @CacheEvict(value = "elsecoClaims", key = "#elsecoClaims.claimHeaderId")
	public long insertCheckList(final ElsecoCheckList elsecoClaims) throws Exception{
		LOG.info("About to insertCheckList :"+elsecoClaims.toString());
		final String sqlQ = "INSERT INTO \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_CheckList_T\" (CHECKLIST_ID, "
				+ " CHECKLIST_NAME, CHECKLIST_GROUP, CLAIM_HEADER_ID, CLAIM_DETAIL_ID, CLAIM_FILE_ID, CLAIM_ITEM_ID, UCR_NO, EXTERNAL_REF, LEVEL, "
				+ " IS_CHECKED, CHECKED_BY, CHECKED_DATE, DELETE_FLAG ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.CLAIM_CHECK_LIST);
		int result = jdbcTemplate.update(sqlQ, 	new Object[] { generatedId, elsecoClaims.getCheckListName(),elsecoClaims.getCheckListGroup(),						 
						elsecoClaims.getClaimHeaderId(), elsecoClaims.getClaimDetailId(), elsecoClaims.getClaimFileId(), elsecoClaims.getClaimItemId(),
						elsecoClaims.getUcrNumber(), elsecoClaims.getExternalRef(),	elsecoClaims.getLevel(), elsecoClaims.getIsChecked(), 
						elsecoClaims.getCheckedBy(), getCurrentTimestampForSQL(), elsecoClaims.getDeleteFlag() });
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}

	/**
	 * A method to update the Claims check list in Database
	 * 
	 * @return
	 */
	public int updateCheckList(ElsecoCheckList elsecoClaims) throws Exception{
		LOG.info("About to updateClaimHeader :"+elsecoClaims.toString());
		
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_CheckList_T\"  set CHECKLIST_NAME =?, CHECKLIST_GROUP =?, "
				+ " CLAIM_HEADER_ID =?, CLAIM_DETAIL_ID =?, CLAIM_FILE_ID =?, CLAIM_ITEM_ID =?, UCR_NO =?, EXTERNAL_REF =?, LEVEL =?, IS_CHECKED =?, "
				+ " CHECKED_BY=?, CHECKED_DATE=?, DELETE_FLAG=? where CHECKLIST_ID=?",
				new Object[] {elsecoClaims.getCheckListName(), elsecoClaims.getCheckListGroup(), elsecoClaims.getClaimHeaderId(), elsecoClaims.getClaimDetailId(),
						elsecoClaims.getClaimFileId(), elsecoClaims.getClaimItemId(), elsecoClaims.getUcrNumber(), elsecoClaims.getExternalRef(),
						elsecoClaims.getLevel(), elsecoClaims.getIsChecked(), elsecoClaims.getCheckedBy(), getCurrentTimestampForSQL(), elsecoClaims.getDeleteFlag(),
						elsecoClaims.getCheckListId() });
	}

	/**
	 * A method to delete the Claims from Data Layer
	 * 
	 * @return
	 */
	public int deleteCheckListById(long id)  throws Exception {
		LOG.info("About to delete checkList By Id :"+id);
		return jdbcTemplate.update(
				"DELETE FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_CheckList_T\"  where CHECKLIST_ID=?",
				new Object[] { id });
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isClaimschecklistExists(int id) throws Exception{
		ElsecoCheckList checklist = getCheckListById(id);
		if(checklist == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * A method to a add the Audit Trail data to the backend Database
	 * 
	 * @param auditTrail
	 * @return
	 */
	public long insertAuditTrail(final ElsecoClaimsAuditTrail auditTrail) throws Exception{
		LOG.info("About to insertAuditTrail :"+auditTrail.toString());

		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_AuditTrail_T\" (ID, APPLICATIONHANDLE, MODULEHANDLE, SCREENHANDLE,"
				+ "  CRUDENTITYHANDLE, UNIQUEID, OPERATORTYPE, OLDCLOBJSON, NEWCLOBJSON, SOURCEIPADDRESS, CREATEDBY, CREATEDDATETIME) values (?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedAuditId();
		int result = jdbcTemplate.update(sqlQ, new Object[] { generatedId, auditTrail.getApplicationHandle(), auditTrail.getModuleHandle(), 
				auditTrail.getScreenHandle(), auditTrail.getCrudEntityHandle(), auditTrail.getUniqueId(), auditTrail.getOperatorType(), auditTrail.getOldClobJson(), 
				auditTrail.getNewClobJson(), auditTrail.getSourceIPAddress(), auditTrail.getCreatedBy(), getCurrentTimestampForSQL()});
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}	
	
	/**
	 * A method to a add the Hybris Payment History to the Database
	 * 
	 * @return
	 */
	public long insertHybrisPayHistory(ElsecoHybrisPayHistory elsecoHybris) throws Exception{
		LOG.info("About to insertHybrisPayHistory :"+elsecoHybris.toString());
		
		final String sqlQ = "insert into \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_HybrisPayHistory_T\" (PAYHISTORY_ID, CLAIM_HEADER_ID, "
				+ " CLAIM_DETAIL_ID, CLAIM_TRANSACTION_ID, CLAIM_INTREF_ID, MEMBER_ID, PAYER_ID, UCR, UMR, EL_CLAIM_ID, SETTLEMENT_AM_INDEM, "
				+ " SETTLEMENT_AM_FEES, SETTLEMENT_AM_EXP, RESERVE_AM_INDEM, RESERVE_AM_FEES, RESERVE_AM_EXP, INCURRED_AM, PAYMT_TYP, CURRENCY, STATUS, "
				+ " IS_COLLECTED) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		long generatedId = getIncrementedMaxId(elsecoClaimsConstant.HYBRIS_PAYHISTORY);
		int result = jdbcTemplate.update(sqlQ,
				new Object[] { generatedId, elsecoHybris.getClaimHeaderId(),elsecoHybris.getClaimDetailId(), elsecoHybris.getClaimTransId(),
						elsecoHybris.getClaimIntRefId(), elsecoHybris.getMemberId(), elsecoHybris.getPayerId(), elsecoHybris.getUcr(), elsecoHybris.getUmr(),
						elsecoHybris.getElClaimId(), elsecoHybris.getSettlementAmtIndem(), elsecoHybris.getSettlementAmtFees(), elsecoHybris.getSettlementAmtExpense(),
						elsecoHybris.getReserveAmtIndem(), elsecoHybris.getReserveAmtFees(), elsecoHybris.getReserveAmtExpense(), elsecoHybris.getIncurredAmt(),
						elsecoHybris.getPaymentType(), elsecoHybris.getCurrency(), elsecoHybris.getStatus(), elsecoHybris.getIsCollected() });
		if(result ==1) {
			return generatedId;
		}
		return 0;
	}
	/**
	 * A method to update the  Hybris Payment History in Database
	 * 
	 * @return
	 */
	public int updateHybrisPayHistory(ElsecoHybrisPayHistory elsecoHybris) throws Exception{
		LOG.info("About to updateHybrisPayHistory :"+elsecoHybris.toString());
		
		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_HybrisPayHistory_T\"  set "
				+ " CLAIM_HEADER_ID = ?,  CLAIM_DETAIL_ID =?, CLAIM_TRANSACTION_ID =?, CLAIM_INTREF_ID =?, MEMBER_ID =?, PAYER_ID = ?, UCR =?, UMR =?, EL_CLAIM_ID =?, "
				+ " SETTLEMENT_AM_INDEM =?, SETTLEMENT_AM_FEES =?, SETTLEMENT_AM_EXP =?, RESERVE_AM_INDEM =?, RESERVE_AM_FEES =?, RESERVE_AM_EXP =?, INCURRED_AM =?, "
				+ " PAYMT_TYP = ?, CURRENCY =?, STATUS =?, IS_COLLECTED=? WHERE  PAYHISTORY_ID=?  ",
				new Object[] {elsecoHybris.getClaimHeaderId(),elsecoHybris.getClaimDetailId(), elsecoHybris.getClaimTransId(), elsecoHybris.getClaimIntRefId(),
						elsecoHybris.getMemberId(), elsecoHybris.getPayerId(), elsecoHybris.getUcr(),	elsecoHybris.getUmr(), elsecoHybris.getElClaimId(), elsecoHybris.getSettlementAmtIndem(),
						elsecoHybris.getSettlementAmtFees(),elsecoHybris.getSettlementAmtExpense(), elsecoHybris.getReserveAmtIndem(), elsecoHybris.getReserveAmtFees(),
						elsecoHybris.getReserveAmtExpense(), elsecoHybris.getIncurredAmt(), elsecoHybris.getPaymentType(), elsecoHybris.getCurrency(), elsecoHybris.getStatus(), 
						elsecoHybris.getIsCollected(), elsecoHybris.getPayHistoryId()});
	}

	/**
	 * A utility to get the Max Claim Header Id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public int getIncrementedMaxId(String table) throws Exception{
		String maxPrimaryId = "1000";
		if (table.equals(elsecoClaimsConstant.CLAIM_HEADER)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_HEADER_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\" ",
					String.class);
		} else if (table.equals(elsecoClaimsConstant.CLAIM_ITEMS)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_ITEM_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\" ",
					String.class);
		} else if (table.equals(elsecoClaimsConstant.CLAIM_DETAIL)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\" ",
					String.class);
		} else if (table.equals(elsecoClaimsConstant.CLAIM_RESERVE)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_RESERVE_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimReserve_T\" ",
					String.class);
		} else if (table.equals(elsecoClaimsConstant.CLAIM_NOTES)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_NOTES_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimNotes_T\" ",
					String.class);
		} else if (table.equals(elsecoClaimsConstant.CLAIM_FILES)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_FILE_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimFile_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_TRANSACTIONS)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_TRANSACTION_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_Transactions_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_INTERNAL_REF)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(INTREF_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_RISKOBJ)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(RISKOBJ_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_TASKS)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CLAIM_TASK_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimTasks_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_MEMBER_INFO)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(MEMBER_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_MEMBER_RESULT)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(RESULT_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\" ",
					String.class);  
		}else if (table.equals(elsecoClaimsConstant.CLAIM_MEMBER_RISKCODE)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(LLRISKCODE_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberRiskcode_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.HYBRIS_PAYHISTORY)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(PAYHISTORY_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_HybrisPayHistory_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_PARTY)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(PARTY_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimParty_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_CHECK_LIST)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(CHECKLIST_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_CheckList_T\" ",
					String.class);
		}else if (table.equals(elsecoClaimsConstant.CLAIM_POLICY_PAYEE)) {
			maxPrimaryId = jdbcTemplate.queryForObject(
					"select max(PAYEE_ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimPayee_T\" ",
					String.class);
		}
		if(maxPrimaryId == null) maxPrimaryId = "1000"; 
		int returnVal = (Integer.valueOf(maxPrimaryId) + 1);
		// LOG.info("getIncrementedMaxClaimHeaderId :: " +returnVal);
		return returnVal;
	}
	
	
	/**
	 * A utility to get the Max Version
	 * 
	 * @return
	 
	@Transactional(readOnly = true)
	public String getIncrementedMaxVersion(String table) {
		String version = "0";
		if (table.equals(elsecoClaimsConstant.CLAIM_HEADER)) {
			version = jdbcTemplate.queryForObject(
					"select MAX( CAST(VERSION AS INT)) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\" ",
					String.class);
		} else if (table.equals(elsecoClaimsConstant.CLAIM_ITEMS)) {
			version = jdbcTemplate.queryForObject(
					"select MAX( CAST(VERSION AS INT)) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\" ",
					String.class);
		} else if (table.equals(elsecoClaimsConstant.CLAIM_DETAIL)) {
			version = jdbcTemplate.queryForObject(
					"select MAX( CAST(VERSION AS INT)) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\" ",
					String.class);
		}
		if(version == null) version = "0";
		String returnVal = "" + (Integer.valueOf(version) + 1);
		// LOG.info("getIncrementedMaxVersion :: " +returnVal);
		return returnVal;
	}*/
	
	
	/**
	 * A utility to get the Max Audit Id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public int getIncrementedAuditId() throws Exception{
		Integer Id = jdbcTemplate.queryForObject(
					"select max(ID) from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_AuditTrail_T\" ", Integer.class);
		if(Id == null) Id = 0;
		int returnVal = (Id + 1);
		//LOG.info("getIncrementedAuditId :: " +returnVal);
		return returnVal;
	}	
	
	/**
	 * Returns the current date for storing in database compatible
	 * 
	 * @return
	 */
	public static Date getCurrentDateForSQL() throws Exception{
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis); 
        return date;
	}
	
	/**
	 * Returns the current date for storing in database compatible
	 * 
	 * @return
	 * @throws ParseException 
	 */
	public static Timestamp getCurrentTimestampForSQL() throws ParseException {
		LocalDateTime ldt = LocalDateTime.now();	  
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
		ZonedDateTime gmt = zdt.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
		Timestamp timestamp = Timestamp.valueOf(gmt.toLocalDateTime());
	    return timestamp;
	}
				
	/**
	 * Return or save the Amount value at Zero if its a negative
	 *  
	 * @param value
	 * @return
	 */
	public BigDecimal returnValidAmount(BigDecimal value) throws Exception{
		if((value==null || value.toString().trim().length() == 0) || value.signum()==-1) {
			return BigDecimal.ZERO; 
		}
		return value;
	}
		
	/**
	 * RowMapper for the ElsecoClaimsHeader
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimsHeaderRowMapper implements RowMapper<ElsecoClaimsHeader> {
		public ElsecoClaimsHeader mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsHeader elsecoClaims = new ElsecoClaimsHeader();
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setVersion(rs.getString("VERSION"));
			elsecoClaims.setChangeIndicator(rs.getString("CHNG_INDICATOR"));
			elsecoClaims.setUcrNumber(rs.getString("UCR_NO"));
			elsecoClaims.setUcrName(rs.getString("UCR_NAME"));
			elsecoClaims.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
			elsecoClaims.setEventCategory(rs.getString("EVENT_CATEGORY"));
			elsecoClaims.setEventType(rs.getString("EVENT_TYPE"));
			elsecoClaims.setEventId(rs.getInt("EVENT_ID"));
			elsecoClaims.setEventFromDate(rs.getDate("DT_EVENT_FROM"));
			elsecoClaims.setEventToDate(rs.getDate("DT_EVENT_TO"));
			elsecoClaims.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
			elsecoClaims.setLossType(rs.getString("LOSS_TYPE"));
			elsecoClaims.setDateOfLoss(rs.getDate("DT_OF_LOSS"));
			elsecoClaims.setTimeOfLoss(rs.getString("TIME_OF_LOSS"));
			elsecoClaims.setLossTimeZone(rs.getString("LOSS_TIME_ZONE"));
			elsecoClaims.setCauseOfLoss(rs.getString("CAUSE_OF_LOSS"));
			elsecoClaims.setStreet(rs.getString("STREET"));
			elsecoClaims.setHouseNumber(rs.getString("HOUSE_NUM"));
			elsecoClaims.setZipCode(rs.getString("ZIP_CODE"));
			elsecoClaims.setCity(rs.getString("CITY"));
			elsecoClaims.setCountry(rs.getString("COUNTRY"));
			elsecoClaims.setRegion(rs.getString("REGION"));
			elsecoClaims.setStatus(rs.getString("STATUS"));
			elsecoClaims.setNextStatus(rs.getString("NEXT_STATUS"));
			elsecoClaims.setClaimHandler(rs.getString("CLAIM_HANDLER"));
			elsecoClaims.setDealId(rs.getInt("DEAL_ID"));
			elsecoClaims.setDealType(rs.getString("DEAL_TYPE"));
			elsecoClaims.setProductCode(rs.getString("PRODUCT_CD"));
			elsecoClaims.setUmrNumber(rs.getString("UMR_NO"));
			elsecoClaims.setLobCode(rs.getString("LOB_CD"));
			elsecoClaims.setClaimReporter(rs.getString("CLAIM_REPORTER"));
			elsecoClaims.setInsured(rs.getString("INSURED"));
			elsecoClaims.setReinsured(rs.getString("REINSURED"));
			elsecoClaims.setInsuredId(rs.getString("INSURED_ID"));
			elsecoClaims.setReinsuredId(rs.getString("REINSURED_ID"));
			elsecoClaims.setLocation(rs.getString("LOCATION"));			
			elsecoClaims.setSubmissionId(rs.getInt("SUBMISSION_ID"));
			elsecoClaims.setBrokerId(rs.getInt("BROKER_ID"));
			elsecoClaims.setEventDateNotif(rs.getDate("EVENTDATENOTIF"));
			elsecoClaims.setLloydsRiskCode(rs.getString("LLOYDS_RISK_CD"));
			elsecoClaims.setRiskExpiryDate(rs.getDate("RISK_EXPIRY_DT"));
			elsecoClaims.setRiskInceptionDate(rs.getDate("RISK_INCEPTION_DT"));
			elsecoClaims.setSectionName(rs.getString("SECTION_NAME"));			
			elsecoClaims.setNewRecordIn(rs.getString("NEW_RECORD_IN"));
			elsecoClaims.setElsecoRiskCd(rs.getString("ELSECO_RISK_CD"));
			elsecoClaims.setLeaderName(rs.getString("LEADER_NAME"));
			elsecoClaims.setLeaderLineVl(rs.getString("LEADER_LINE_VL"));
			elsecoClaims.setRiskDomicileFg(rs.getString("RISK_DOMICILE_FG"));
			elsecoClaims.setRiskLocationCode(rs.getString("RISK_LOCATION_CD"));		
			elsecoClaims.setElsecoLeaderFlag(rs.getString("ELSECO_LEADER_FLAG"));
			elsecoClaims.setExpiryDate(rs.getDate("EXPIRY_DATE"));
			elsecoClaims.setInceptionDate(rs.getDate("INCEPTION_DATE"));	
			elsecoClaims.setLimitCurrencyCode(rs.getString("LIMIT_CURRENCY_CD"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info(" claims header:: "+elsecoClaims.toString());
			return elsecoClaims;
		}
	}
	
	/**
	 * RowMapper for the ElsecoClaims
	 * 
	 * @author Serole_Vijay
	 */
	class WorkListRowMapper implements RowMapper<JsonHandlerForWorklistAndSaveClaims> {
		public JsonHandlerForWorklistAndSaveClaims mapRow(ResultSet rs, int rowNum) throws SQLException {
			JsonHandlerForWorklistAndSaveClaims elsecoClaims = new JsonHandlerForWorklistAndSaveClaims();
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setVersion(rs.getString("VERSION"));
			elsecoClaims.setChangeIndicator(rs.getString("CHNG_INDICATOR"));
			elsecoClaims.setUcrNumber(rs.getString("UCR_NO"));
			elsecoClaims.setUcrName(rs.getString("UCR_NAME"));
			elsecoClaims.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
			elsecoClaims.setEventCategory(rs.getString("EVENT_CATEGORY"));
			elsecoClaims.setEventType(rs.getString("EVENT_TYPE"));
			elsecoClaims.setEventId(rs.getInt("EVENT_ID"));
			elsecoClaims.setEventFromDate(rs.getDate("DT_EVENT_FROM"));
			elsecoClaims.setEventToDate(rs.getDate("DT_EVENT_TO"));
			elsecoClaims.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
			elsecoClaims.setLossType(rs.getString("LOSS_TYPE"));
			elsecoClaims.setDateOfLoss(rs.getDate("DT_OF_LOSS"));
			elsecoClaims.setTimeOfLoss(rs.getString("TIME_OF_LOSS"));
			elsecoClaims.setLossTimeZone(rs.getString("LOSS_TIME_ZONE"));
			elsecoClaims.setCauseOfLoss(rs.getString("CAUSE_OF_LOSS"));
			elsecoClaims.setStreet(rs.getString("STREET"));
			elsecoClaims.setHouseNumber(rs.getString("HOUSE_NUM"));
			elsecoClaims.setZipCode(rs.getString("ZIP_CODE"));
			elsecoClaims.setCity(rs.getString("CITY"));
			elsecoClaims.setCountry(rs.getString("COUNTRY"));
			elsecoClaims.setRegion(rs.getString("REGION"));
			elsecoClaims.setStatus(rs.getString("STATUS"));
			elsecoClaims.setNextStatus(rs.getString("NEXT_STATUS"));
			elsecoClaims.setClaimHandler(rs.getString("CLAIM_HANDLER"));
			elsecoClaims.setDealId(rs.getInt("DEAL_ID"));
			elsecoClaims.setDealType(rs.getString("DEAL_TYPE"));
			elsecoClaims.setProductCode(rs.getString("PRODUCT_CD"));
			elsecoClaims.setUmrNumber(rs.getString("UMR_NO"));
			elsecoClaims.setLobCode(rs.getString("LOB_CD"));
			elsecoClaims.setClaimReporter(rs.getString("CLAIM_REPORTER"));
			elsecoClaims.setInsured(rs.getString("INSURED"));
			elsecoClaims.setReinsured(rs.getString("REINSURED"));
			elsecoClaims.setInsuredId(rs.getString("INSURED_ID"));
			elsecoClaims.setReinsuredId(rs.getString("REINSURED_ID"));			
			elsecoClaims.setLocation(rs.getString("LOCATION"));
			elsecoClaims.setExtRefNo(rs.getString("EXTREFNO"));
			elsecoClaims.setSubmissionId(rs.getInt("SUBMISSION_ID"));
			elsecoClaims.setLloydsRiskCode(rs.getString("LLOYDS_RISK_CD"));
			elsecoClaims.setRiskExpiryDate(rs.getDate("RISK_EXPIRY_DT"));
			elsecoClaims.setRiskInceptionDate(rs.getDate("RISK_INCEPTION_DT"));
			elsecoClaims.setSectionName(rs.getString("SECTION_NAME"));
			elsecoClaims.setNewRecordIn(rs.getString("NEW_RECORD_IN"));
			elsecoClaims.setElsecoRiskCd(rs.getString("ELSECO_RISK_CD"));
			elsecoClaims.setLeaderName(rs.getString("LEADER_NAME"));
			elsecoClaims.setLeaderLineVl(rs.getString("LEADER_LINE_VL"));
			elsecoClaims.setRiskDomicileFg(rs.getString("RISK_DOMICILE_FG"));
			elsecoClaims.setRiskLocationCode(rs.getString("RISK_LOCATION_CD"));	
			elsecoClaims.setElsecoLeaderFlag(rs.getString("ELSECO_LEADER_FLAG"));
			elsecoClaims.setExpiryDate(rs.getDate("EXPIRY_DATE"));
			elsecoClaims.setInceptionDate(rs.getDate("INCEPTION_DATE"));	
			elsecoClaims.setLimitCurrencyCode(rs.getString("LIMIT_CURRENCY_CD"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));				
			
			//LOG.info(" claims header:: "+elsecoClaims.toString());
			return elsecoClaims;
		}
	}
	
	/**
	 * RowMapper for the ElsecoClaimsItems
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimsItemRowMapper implements RowMapper<ElsecoClaimsItems> {
		public ElsecoClaimsItems mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsItems elsecoClaims = new ElsecoClaimsItems();
			elsecoClaims.setClaimId(rs.getInt("CLAIM_ID"));
			elsecoClaims.setClaimItemId(rs.getInt("CLAIM_ITEM_ID"));
			elsecoClaims.setSubClaimId(rs.getInt("SUBCLAIM_ID"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setVersion(rs.getString("VERSION"));
			elsecoClaims.setChngIndicator(rs.getString("CHNG_INDICATOR"));
			elsecoClaims.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
			elsecoClaims.setExtClaimItemNo(rs.getString("EXT_CLAIM_ITEM_NO"));
			elsecoClaims.setBenefitType(rs.getString("BENEFIT_TYPE"));
			elsecoClaims.setItemObjType(rs.getString("ITEM_OBJ_TYPE"));
			elsecoClaims.setCovgType(rs.getString("COVG_TYPE"));
			elsecoClaims.setAmtEvaluated(rs.getBigDecimal("AMT_EVALUATED"));
			elsecoClaims.setCurrEval(rs.getString("CURR_EVAL"));
			elsecoClaims.setEvalAmtPerUnit(rs.getBigDecimal("EVAL_AMT_PERUNIT"));
			elsecoClaims.setEvalQuantity(rs.getString("EVAL_QUANTITY"));
			elsecoClaims.setEvalQuantUnit(rs.getString("EVAL_QUANT_UNIT"));
			elsecoClaims.setStatusItem(rs.getString("STATUS_ITEM"));
			elsecoClaims.setDescriptionItem(rs.getString("DESCRIPTION_ITEM"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info(" Claim Items      " + elsecoClaims.toString());
			return elsecoClaims;
		}
	}
	
	/**
	 * RowMapper for the ElsecoClaimDetails
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimDetailRowMapper implements RowMapper<ElsecoClaimDetails> {
		public ElsecoClaimDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimDetails elsecoClaims = new ElsecoClaimDetails();
			elsecoClaims.setClaimId(rs.getInt("CLAIM_ID"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setVersion(rs.getString("VERSION"));
			elsecoClaims.setChangeIndicator(rs.getString("CHNG_INDICATOR"));
			elsecoClaims.setEffctiveDate(rs.getDate("EFFECTIVE_DATE"));
			elsecoClaims.setClaimReferenceNo(rs.getString("CLAIM_REFERENCE_NO"));
			elsecoClaims.setFlagAuthReported(rs.getString("FLG_AUTH_REPORTED"));
			elsecoClaims.setClaimDetailStatus(rs.getString("CLAIM_DETAIL_STATUS"));
			elsecoClaims.setNextStatus(rs.getString("NEXT_STATUS"));
			elsecoClaims.setClaimReporter(rs.getString("CLAIM_REPORTER"));
			elsecoClaims.setClaimAuthority(rs.getString("CLAIM_AUTHORITY"));
			elsecoClaims.setLossType(rs.getString("LOSS_TYPE"));
			elsecoClaims.setPolicyType(rs.getString("POLICY_TYPE"));
			elsecoClaims.setDateOfLoss(rs.getDate("DT_OF_LOSS"));
			elsecoClaims.setTimeOfLoss(rs.getString("TIME_OF_LOSS"));
			elsecoClaims.setLossTimeZone(rs.getDate("LOSS_TIME_ZONE"));
			elsecoClaims.setCauseOfLoss(rs.getString("CAUSE_OF_LOSS"));
			elsecoClaims.setStreet(rs.getString("STREET"));
			elsecoClaims.setHouseNumber(rs.getString("HOUSE_NUM"));
			elsecoClaims.setZipCode(rs.getString("ZIP_CODE"));
			elsecoClaims.setCity(rs.getString("CITY"));
			elsecoClaims.setCountry(rs.getString("COUNTRY"));
			elsecoClaims.setRegion(rs.getString("REGION"));
			elsecoClaims.setStatusChangeReason(rs.getString("STATUS_CHNG_REASON"));
			elsecoClaims.setClaimAuthGroup(rs.getString("CLM_AUTH_GRP"));
			elsecoClaims.setComplexity(rs.getInt("COMPLEXITY"));
			elsecoClaims.setDateClaimOpen(rs.getDate("DT_CLAIM_OPEN"));
			elsecoClaims.setDateClaimExpiry(rs.getDate("DT_CLAIM_EXPIRY"));
			elsecoClaims.setDateLossReptCompany(rs.getDate("DT_LOSS_REPT_COMPANY"));
			elsecoClaims.setDateLossReportedAgent(rs.getDate("DT_LOSS_REPORTED_AGENT"));
			elsecoClaims.setClaimProcTime(rs.getString("CLAIM_PROC_TIME"));
			elsecoClaims.setStatusChg(rs.getInt("STATUSCHG"));
			elsecoClaims.setFlagSensitive(rs.getString("FLG_SENSITIVE"));
			elsecoClaims.setFlagCovered(rs.getString("FLG_COVERED"));
			elsecoClaims.setDtEffctive(rs.getDate("DT_EFFECTIVE"));
			elsecoClaims.setDateLossReported(rs.getDate("DT_LOSS_REPORTED"));
			elsecoClaims.setExtRefNo(rs.getString("EXTREFNO"));
			elsecoClaims.setLloydsRiskCode(rs.getString("LLOYDS_RISK_CD"));
			elsecoClaims.setLobCode(rs.getString("LOB_CD"));			
			elsecoClaims.setSectionName(rs.getString("SECTION_NAME"));		
			elsecoClaims.setInceptionDate(rs.getDate("INCEPTION_DATE"));
			elsecoClaims.setExpiryDate(rs.getDate("EXPIRY_DATE"));	
			elsecoClaims.setSubject(rs.getString("SUBJECT"));
			elsecoClaims.setTotalPriceAm(rs.getBigDecimal("TOTAL_PRICE_AM"));
			elsecoClaims.setOrderPrecVl(rs.getString("ORDER_PREC_VL"));
			elsecoClaims.setSigningPercVl(rs.getString("SIGNING_PERC_VL"));
			elsecoClaims.setEstimatedPremiumAM(rs.getBigDecimal("ESTIMATED_PREMIUM_AM"));
			elsecoClaims.setTempLloydsRiskCd(rs.getString("TEMP_LLOYDS_RISK_CD"));
			elsecoClaims.setLineSizeVl(rs.getString("LINE_SIZE_VL"));
			elsecoClaims.setPrmSplitPercVl(rs.getString("PRM_SPLIT_PERC_VL"));
			elsecoClaims.setPremiumAmt(rs.getBigDecimal("PREMIUM_AMT"));
			elsecoClaims.setButtonIndicator(rs.getString("BUTTON_INDICATOR"));	
			elsecoClaims.setSettlementDate(rs.getDate("SETTLEMENT_DATE"));
			elsecoClaims.setPrevpaidAmtIndemnityER(rs.getBigDecimal("PREVPDCLAMT_INDEMNITY"));
			elsecoClaims.setPrevpaidAmtFeesER(rs.getBigDecimal("PREVPDCLAMT_FEES"));
			elsecoClaims.setPrevpaidAmtExpensesER(rs.getBigDecimal("PREVPDCLAMT_EXPENSES"));			
			elsecoClaims.setSettlementAmtIndemnityER(rs.getBigDecimal("SETLMNTCLAMT_INDEMNITY"));
			elsecoClaims.setSettlementAmtFeesER(rs.getBigDecimal("SETLMNTCLAMT_FEES"));
			elsecoClaims.setSettlementAmtExpensesER(rs.getBigDecimal("SETLMNTCLAMT_EXPENSES"));
			elsecoClaims.setReserveAmountIndemnityER(rs.getBigDecimal("RESERVEAMOUNT_INDEMNITY"));
			elsecoClaims.setReserveAmountFeesER(rs.getBigDecimal("RESERVEAMOUNT_FEES"));
			elsecoClaims.setReserveAmountExpensesER(rs.getBigDecimal("RESERVEAMOUNT_EXPENSES"));			
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info("Claims Details ::  "+elsecoClaims.toString());
			return elsecoClaims;
		}		
	}
	
	/**
	 * RowMapper for the ElsecoClaimsStaticDatas
	 * 
	 * @author Serole_Vijay
	 */
	class StaticDataRowMapper implements RowMapper<ElsecoClaimsStaticData> {
		public ElsecoClaimsStaticData mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsStaticData lookup = new ElsecoClaimsStaticData();
			lookup.setID(rs.getInt("ID"));				
			lookup.setApplicationHandle(rs.getString("ApplicationHandle"));
			lookup.setScreenHandle(rs.getString("ScreenHandle"));
			lookup.setDepend1(rs.getString("Depend1"));
			lookup.setDepend2(rs.getString("Depend2"));
			lookup.setEntityHandle(rs.getString("EntityHandle"));
			lookup.setEntityCode(rs.getString("EntityCode"));				
			lookup.setEntityName1(rs.getString("EntityName1"));
			lookup.setEntityName2(rs.getString("EntityName2"));
			lookup.setEntityDesc(rs.getString("EntityDesc"));			
			lookup.setIsEnable(rs.getString("IsEnable"));
			lookup.setStatus(rs.getString("Status"));	
			
			//LOG.info(" Claim Look Up Table Data      " + lookup.toString());
			return lookup;				
		}
	}	
	
	/**
	 * RowMapper for the ElsecoClaimReserve
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimReserveRowMapper implements RowMapper<ElsecoClaimReserve> {
		public ElsecoClaimReserve mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimReserve elsecoClaims = new ElsecoClaimReserve();
			elsecoClaims.setClaimReserveId(rs.getInt("CLAIM_RESERVE_ID"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setClaimDetId(rs.getInt("CLAIM_ID"));
			elsecoClaims.setReserveAmt(rs.getBigDecimal("RESERVE_AMT"));
			elsecoClaims.setInitialDetails(rs.getString("INITIAL_DETAILS"));
			elsecoClaims.setReserveType(rs.getString("RESERVE_TYPE"));
			elsecoClaims.setPoolName(rs.getString("POOL_NAME"));
			elsecoClaims.setMemberName(rs.getString("MEMBER_NAME"));
			elsecoClaims.setAllocationPercent(rs.getBigDecimal("ALLOCATION_PERCENT"));
			elsecoClaims.setPriviledgeType(rs.getString("PRIVILEDGE_TYPE"));
			elsecoClaims.setReserveFlag(rs.getString("RESERVE_FLAG"));
			elsecoClaims.setBalanceAmt(rs.getBigDecimal("BALANCE_AMT"));
			elsecoClaims.setIndemnityAmt(rs.getBigDecimal("INDEMNITY_RESERVE_AMT"));
			elsecoClaims.setFeeReserveAmt(rs.getBigDecimal("FEE_RESERVE_AMT"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info("Claims Details ::  "+elsecoClaims.toString());
			return elsecoClaims;
		}		
	}  
	
	/**
	 * RowMapper for the ElsecoClaimReserve
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimRiskobjRowMapper implements RowMapper<ElsecoRiskObject> {
		public ElsecoRiskObject mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoRiskObject elsecoClaims = new ElsecoRiskObject();
			elsecoClaims.setRiskObjId(rs.getInt("RISKOBJ_ID"));
			elsecoClaims.setRiskObjName(rs.getString("RISKOBJ_NAME"));
			elsecoClaims.setRiskObjDesc(rs.getString("RISKOBJ_DESC"));
			elsecoClaims.setRiskObjRegNo(rs.getString("RISKOBJ_REGNO"));
			elsecoClaims.setRiskObjStDt(rs.getDate("RISKOBJ_START_DATE"));
			elsecoClaims.setRiskObjEdDt(rs.getDate("RISKOBJ_END_DATE"));
			elsecoClaims.setRiskSumInsured(rs.getBigDecimal("RISKSUMINSURED"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setUcrNo(rs.getString("UCR_NO"));
			elsecoClaims.setClaimDetailId(rs.getInt("CLAIM_DETAIL_ID"));
			elsecoClaims.setExternalRefNo(rs.getString("EXTREFNO"));
			elsecoClaims.setCreatedDt(rs.getDate("CREATED_DATE"));
			elsecoClaims.setCreatedBy(rs.getString("CREATED_BY"));
			elsecoClaims.setModifiedDate(rs.getDate("MODIFIED_DATE"));
			elsecoClaims.setModifiedBy(rs.getString("MODIFIED_BY"));			
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info("Claims Details ::  "+elsecoClaims.toString());
			return elsecoClaims;
		}		
	}
	
	/**
	 * RowMapper for the ElsecoClaimTask
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimTaskRowMapper implements RowMapper<ElsecoClaimsTasks> {
		public ElsecoClaimsTasks mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsTasks elsecoClaims = new ElsecoClaimsTasks();
			elsecoClaims.setClaimTaskId(rs.getInt("CLAIM_TASK_ID"));
			elsecoClaims.setClaimFileId(rs.getInt("CLAIM_FILE_ID"));
			elsecoClaims.setClaimItemId(rs.getInt("CLAIM_ITEM_ID"));
			elsecoClaims.setClaimId(rs.getInt("CLAIM_ID"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setVersion(rs.getString("VERSION"));
			elsecoClaims.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
			elsecoClaims.setTaskCode(rs.getString("TASK_CD"));
			elsecoClaims.setFlgManual(rs.getString("FLG_MANUAL"));
			elsecoClaims.setStatus(rs.getString("STATUS"));
			elsecoClaims.setSubObjCatgory(rs.getString("SUBOBJ_CATG"));
			elsecoClaims.setSubObject(rs.getString("SUB_OBJECT"));
			elsecoClaims.setTaskName(rs.getString("TASK_NAME"));
			elsecoClaims.setTaskDesc(rs.getString("TASK_DESC"));
			elsecoClaims.setActivityUsed(rs.getString("ACTIVITY_USED"));
			elsecoClaims.setDateFirstSubmitted(rs.getDate("DT_FIRST_SUBM"));
			elsecoClaims.setDateLatestStart(rs.getDate("DT_LATEST_START"));
			elsecoClaims.setDateLatestEnd(rs.getDate("DT_LATEST_END"));
			elsecoClaims.setDateFirstSubmittedTime(rs.getDate("DT_FIRST_SUBM_TIME"));
			elsecoClaims.setDateLatestEndTime(rs.getDate("DT_LATEST_END_TIME"));
			elsecoClaims.setTaskPriority(rs.getString("TASK_PRIORITY"));
			elsecoClaims.setTaskHandlerCatgory(rs.getString("TASK_HANDLR_CATG"));
			elsecoClaims.setTaskHandler(rs.getString("TASK_HANDLER"));
			elsecoClaims.setAuthGroup(rs.getString("AUTH_GRP"));
			elsecoClaims.setAuthUser(rs.getString("AUTH_USR"));
			elsecoClaims.setNotifySent(rs.getString("NOTIFY_SENT"));
			elsecoClaims.setNotifyReceipients(rs.getString("NOTIFY_RECEIPIENTS"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info("Claims Details ::  "+elsecoClaims.toString());
			return elsecoClaims;
		}		
	}
	
	/**
	 * RowMapper for the ElsecoClaimNotes
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimsNotesRowMapper implements RowMapper<ElsecoClaimsNotes> {
		public ElsecoClaimsNotes mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsNotes elsecoClaims = new ElsecoClaimsNotes();
			elsecoClaims.setClaimNotesId(rs.getInt("CLAIM_NOTES_ID"));
			elsecoClaims.setClaimNotesVersion(rs.getString("CLAIM_NOTES_VERSION"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setClaimHeaderVersion(rs.getString("CLAIM_HEADER_VERSION"));
			elsecoClaims.setClaimDtlId(rs.getInt("CLAIM_ID"));
			elsecoClaims.setClaimVersion(rs.getString("CLAIM_VERSION"));
			elsecoClaims.setClaimItemId(rs.getInt("CLAIM_ITEM_ID"));
			elsecoClaims.setClaimItemVersion(rs.getString("CLAIM_ITEM_VERSION"));
			elsecoClaims.setClaimFileId(rs.getInt("CLAIM_FILE_ID"));
			elsecoClaims.setClaimFileVersion(rs.getString("CLAIM_FILE_VERSION"));			
			elsecoClaims.setClaimReserveId(rs.getInt("CLAIM_RESERVE_ID"));
			elsecoClaims.setClaimReserveVersion(rs.getString("CLAIM_RESERVE_VERSION"));
			elsecoClaims.setClaimReserveId(rs.getInt("CLAIM_TRANS_ID"));
			elsecoClaims.setClaimReserveVersion(rs.getString("CLAIM_TRANS_VERSION"));
			elsecoClaims.setNotesMessage(rs.getString("NOTES_MESSAGE"));
			elsecoClaims.setNotesDesc(rs.getString("NOTES_DESC"));
			elsecoClaims.setCreatedBy(rs.getString("CREATEDBY"));
			elsecoClaims.setCreatedDate(rs.getTimestamp("CREATEDDATE"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info("Claims Notes ::  "+elsecoClaims.toString());
			return elsecoClaims;
		}		
	}
	
	/**
	 * RowMapper for the ElsecoClaimFile
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimsFileRowMapper implements RowMapper<ElsecoClaimsFile> {
		public ElsecoClaimsFile mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsFile elsecoClaims = new ElsecoClaimsFile();
			elsecoClaims.setClaimFileId(rs.getInt("CLAIM_FILE_ID"));
			elsecoClaims.setClaimFileType(rs.getString("CLAIM_FILE_TYPE"));
			elsecoClaims.setClaimId(rs.getInt("CLAIM_ID"));
			elsecoClaims.setVersion(rs.getString("VERSION"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setChangeIndicator(rs.getString("CHNG_INDICATOR"));
			elsecoClaims.setStatusChangeReason(rs.getString("STATUS_CHNG_REASON"));
			elsecoClaims.setFileStatus(rs.getString("FILE_STATUS"));
			elsecoClaims.setStatusChangeBy(rs.getString("STATUSCHNG_BY"));
			elsecoClaims.setStatusChangeTime(rs.getDate("STATUSCHNG_TIME"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info("Claims Files ::  "+elsecoClaims.toString());
			return elsecoClaims;
		}		
	}
	
	/**
	 * RowMapper for the ElsecoClaimsParty
	 * 
	 * @author Serole_Vijay
	 *
	 */
	class ElsecoClaimsPartyRowMapper implements RowMapper<ElsecoClaimsParty> {
		public ElsecoClaimsParty mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsParty party =new ElsecoClaimsParty();
			party.setPartyId(rs.getInt("PARTY_ID"));			
			party.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));				
			party.setUcrNumber(rs.getString("UCR_NO"));	
			party.setExtRefNo(rs.getString("EXTERNAL_REF_NO"));	
			party.setPartyName(rs.getString("PARTY_NAME"));
			party.setPartyBpId(rs.getInt("PARTY_BP_ID"));
			party.setPartyDescription(rs.getString("PARTY_DESCRIPTION"));
			party.setPartyInvSource(rs.getString("PARTY_INV_SOURCE"));
			party.setPartyIntroducerID(rs.getInt("PARTY_INTRODUCER_ID"));
			party.setPartyIntroducerName(rs.getString("PARTY_INTRODUCER_NAME"));
			party.setPartySrvceAmtIncured(rs.getBigDecimal("PARTY_SERVICE_AMT_INCURED"));
			party.setPartyPercSrvChrgInv1(rs.getBigDecimal("PARTY_PERC_SERVICE_CHRG_INV1"));
			party.setPartyPercSrvChrgInv2(rs.getBigDecimal("PARTY_PERC_SERVICE_CHRG_INV2"));
			party.setPartyPercSrvChrgInv3(rs.getBigDecimal("PARTY_PERC_SERVICE_CHRG_INV3"));
			party.setPartyPercSrvChrgInv4(rs.getBigDecimal("PARTY_PERC_SERVICE_CHRG_INV4"));
			party.setPartyAmtAddSubChrg(rs.getBigDecimal("PARTY_SERVICE_AMT_ADDSUBCHRG"));
			party.setPartySrvcAmtPrevPaid(rs.getBigDecimal("PARTY_SERVICE_AMT_PREVPAID"));
			party.setPartySrvcAmtSettled(rs.getBigDecimal("PARTY_SERVICE_AMT_SETTLED"));
			party.setPartySrvcDetails(rs.getString("PARTY_SERVICE_DETAILS"));
			party.setPartyInvInternalStatus(rs.getString("PARTY_INV_INTERNAL_STATUS"));
			party.setPartyInvExternalStatus(rs.getString("PARTY_INV_EXTERNAL_STATUS"));
			party.setPartyInvDate(rs.getDate("PARTY_INV_DATE"));
			party.setPartyRemitanceAcctDts(rs.getString("PARTY_REMITANCE_ACCT_DTS"));
			party.setPartyInvApporval(rs.getString("PARTY_INV_APPROVAL"));
			party.setCollectionType(rs.getString("COLLECTION_TYPE"));
			party.setDeleteFlag(rs.getString("DELETE_FLAG"));			
			return party;
		}
	}
		
	/**
	 * RowMapper for the ElsecoClaimsPayee
	 * 
	 * @author Serole_Vijay
	 *
	 */
	class ElsecoClaimsPayeeRowMapper implements RowMapper<ElsecoClaimsPayee> {
		public ElsecoClaimsPayee mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsPayee payee =new ElsecoClaimsPayee();
			payee.setPayeeId(rs.getInt("PAYEE_ID"));			
			payee.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			payee.setClaimId(rs.getInt("CLAIM_ID"));	
			payee.setClaimTransactionId(rs.getInt("CLAIM_TRANSACTION_ID"));				
			payee.setUcrNumber(rs.getString("UCR_NO"));	
			payee.setExtRefNo(rs.getString("EXTERNAL_REF_NO"));	
			payee.setTransRefNo(rs.getString("TRANSACTION_REF_NO"));			
			payee.setPayeeBpId(rs.getString("PAYEE_BP_ID"));
			payee.setPayeeName(rs.getString("PAYEE_NAME"));
			payee.setPayeeEmail(rs.getString("PAYEE_EMAIL"));
			payee.setPayeeAccount(rs.getString("PAYEE_ACCOUNT"));
			payee.setPayeeAmount(rs.getBigDecimal("PAYEE_AMOUNT"));
			payee.setPayeeOutStandingAmt(rs.getString("PAYEE_OUTSTNDING_AMOUNT"));
			payee.setPayeeCurrency(rs.getString("PAYEE_CURRENCY"));
			payee.setPayeeType(rs.getString("PAYEE_TYPE"));
			payee.setStatus(rs.getString("STATUS"));			
			payee.setDeleteFlag(rs.getString("DELETE_FLAG"));			
			return payee;
		}
	}
	
	/**
	 * RowMapper for the ElsecoClaimFile
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimsTransactionRowMapper implements RowMapper<ElsecoClaimsTransaction> {
		public ElsecoClaimsTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsTransaction elsecoClaims = new ElsecoClaimsTransaction();
			elsecoClaims.setClaimsTransactionId(rs.getInt("CLAIM_TRANSACTION_ID"));
			elsecoClaims.setClaimHeaderid(rs.getInt("CLAIM_HEADER_ID"));
			elsecoClaims.setClaimid(rs.getInt("CLAIM_ID"));
			elsecoClaims.setClaimItemId(rs.getInt( "CLAIM_ITEM_ID"));
			elsecoClaims.setApplicationhandle(rs.getString("APPLICATIONHANDLE"));
			elsecoClaims.setModulehandle(rs.getString("MODULEHANDLE"));
			elsecoClaims.setScreenhandle(rs.getString("SCREENHANDLE"));
			elsecoClaims.setUmrNumber(rs.getString("UMR_NO"));
			elsecoClaims.setUcrNumber(rs.getString("UCR_NO"));
			elsecoClaims.setPolicyTransRefNo(rs.getString("POLICY_TRANSREF_NO"));
			elsecoClaims.setMarketTransRefNo(rs.getString("MARKET_TRANSREF_NO"));
			elsecoClaims.setTransactionRecordType(rs.getString("TRANS_RECORD_TYPE"));
			elsecoClaims.setTransactionType(rs.getString("TRANSACTIONTYPE"));
			elsecoClaims.setTransactionSubType(rs.getString("TRANSACTIONSUBTYPE"));
			elsecoClaims.setTransDescription(rs.getString("TRANSACTION_DESCRIPTION"));
			elsecoClaims.setComment(rs.getString("COMMENT"));
			elsecoClaims.setPartyId(rs.getInt("PARTY_ID"));
			elsecoClaims.setPartyName(rs.getString("PARTY_NAME"));
			elsecoClaims.setPartyBpId(rs.getInt("PARTY_BP_ID"));
			elsecoClaims.setTransactionCurrency(rs.getString("TRANSACTIONCURRENCY"));
			elsecoClaims.setRateOfExchange(rs.getString("RATE_OF_EXCH"));
			elsecoClaims.setOriginalAmount(rs.getString("ORIGINAL_AMT"));			
			elsecoClaims.setOutStndclamt(rs.getBigDecimal("OUTSTNDCLAMT"));
			elsecoClaims.setPrevpaidAmtIndemnityTR(rs.getBigDecimal("PREVPDCLAMT_INDEMNITY"));
			elsecoClaims.setPrevpaidAmtFeesTR(rs.getBigDecimal("PREVPDCLAMT_FEES"));
			elsecoClaims.setPrevpaidAmtExpensesTR(rs.getBigDecimal("PREVPDCLAMT_EXPENSES"));			
			elsecoClaims.setNwincurdclamt(rs.getBigDecimal("NWINCURDCLAMT"));
			elsecoClaims.setSettlementAmtIndemnityTR(rs.getBigDecimal("SETLMNTCLAMT_INDEMNITY"));
			elsecoClaims.setSettlementAmtFeesTR(rs.getBigDecimal("SETLMNTCLAMT_FEES"));
			elsecoClaims.setSettlementAmtExpensesTR(rs.getBigDecimal("SETLMNTCLAMT_EXPENSES"));			
			elsecoClaims.setReserveAmountIndemnityTR(rs.getBigDecimal("RESERVEAMOUNT_INDEMNITY"));
			elsecoClaims.setReserveAmountFeesTR(rs.getBigDecimal("RESERVEAMOUNT_FEES"));
			elsecoClaims.setReserveAmountExpensesTR(rs.getBigDecimal("RESERVEAMOUNT_EXPENSES"));					
			elsecoClaims.setOriginalCurrency(rs.getString("ORIGINALCURRENCY"));
			elsecoClaims.setDueDate(rs.getDate("DUEDATE"));
			elsecoClaims.setIncomingPayment(rs.getString("INCOMING_PAYMENT"));
			elsecoClaims.setOutgoingPayment(rs.getString("OUTGOING_PAYMENT"));
			elsecoClaims.setSplitClaimPercVl(rs.getString("SPLIT_CLAIM_PERC_VL"));
			elsecoClaims.setSplitClaimPercAmt(rs.getBigDecimal("SPLIT_CLAIM_PERC_AMT"));
			elsecoClaims.setInternalStatus(rs.getString("INTERNALSTATUS"));
			elsecoClaims.setExternalStatus(rs.getString("EXTERNALSTATUS"));
			elsecoClaims.setNextStatus(rs.getString("NEXT_STATUS"));
			elsecoClaims.setAuthor(rs.getString("AUTHOR"));
			elsecoClaims.setExtrnlid(rs.getInt("EXTRNL_ID"));			
			elsecoClaims.setPrintSortCode(rs.getString("PRINT_SORT_CODE"));
			elsecoClaims.setEcfIndicator(rs.getString("ECF_INDICATOR"));
			elsecoClaims.setCarrierCode(rs.getString("CARRIER_CODE"));
			elsecoClaims.setCarrierPercentage(rs.getString("CARRIER_PERCENTAGE"));
			elsecoClaims.setCarrierReference(rs.getString("CARRIER_REFERENCE"));
			elsecoClaims.setRole(rs.getString("ROLE"));
			elsecoClaims.setClaimReference1(rs.getString("CLAIM_REFERENCE_1"));
			elsecoClaims.setClaimReference2(rs.getString("CLAIM_REFERENCE_2"));
			elsecoClaims.setLloydsCatastropheCode(rs.getString("LLOYDS_CATASTROPHE_CODE"));
			elsecoClaims.setPcsCode(rs.getString("PCS_CODE"));
			elsecoClaims.setCollectionType(rs.getString("COLLECTION_TYPE"));
			elsecoClaims.setReserveUpdateFlag(rs.getString("RESERVE_UPDATE_FLAG"));
			elsecoClaims.setVerfPaidFlag(rs.getString("VERF_PAID_FLAG"));	
			elsecoClaims.setApproveEnabled(rs.getString("APPROVE_ENABLED"));  
			elsecoClaims.setRejectEnabled(rs.getString("REJECT_ENABLED"));  
			elsecoClaims.setReleasePayEnabled(rs.getString("RELEASE_PAY_ENABLED")); 
			elsecoClaims.setReserveEnabled(rs.getString("RESERVE_ENABLED")); 
			elsecoClaims.setCollectPayEnabled(rs.getString("COLLECT_PAY_ENABLED"));
			elsecoClaims.setCreatedby(rs.getString("CREATEDBY"));
			elsecoClaims.setCreateddate(rs.getTimestamp("CREATEDDATE"));			
			elsecoClaims.setLimitCurrencyCode(rs.getString("LIMIT_CURRENCY_CD"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));	
			
			//LOG.info("Claims Transaction ::  "+elsecoClaims.toString());
			return elsecoClaims;
		}		
	}
	
	/**
	 * RowMapper for the ElsecoMemberInfo
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoMemberInfoRowMapper implements RowMapper<ElsecoMemberInfo> {
		public ElsecoMemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoMemberInfo elsecoClaims = new ElsecoMemberInfo();
			elsecoClaims.setMemberId(rs.getInt("MEMBER_ID"));
			elsecoClaims.setStampId(rs.getInt("STAMP_ID"));
			elsecoClaims.setIntRefId(rs.getInt("INTREF_ID"));
			elsecoClaims.setPolicyTransactionId(rs.getInt("POLICY_TRANSACTION_ID"));	
			elsecoClaims.setMarketTransactionId(rs.getInt("MARKET_TRANSACTION_ID"));		
			elsecoClaims.setClaimId(rs.getInt("CLAIM_ID"));
			elsecoClaims.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));	
			elsecoClaims.setMemberBpId(rs.getInt("MEMBER_BP_ID"));
			elsecoClaims.setStampName(rs.getString("STAMP_NAME"));
			elsecoClaims.setStampStartDate(rs.getDate("STAMPSTART_DT"));
			elsecoClaims.setStampEndDate(rs.getDate("STAMPEND_DT"));
			elsecoClaims.setStampStatusId(rs.getInt("STAMPSTATUS_ID"));
			elsecoClaims.setStampDescription(rs.getString("STAMP_DESCRIPTION"));
			elsecoClaims.setFrontier(rs.getString("FRONTIER"));
			elsecoClaims.setTransactioning(rs.getString("TRANSACTIONING"));
			elsecoClaims.setPayerId(rs.getString("PAYER_ID"));
			elsecoClaims.setPayerName(rs.getString("PAYER_NAME"));
			elsecoClaims.setCreatedOn(rs.getDate("CREATEDON"));
			elsecoClaims.setApprovedOn(rs.getDate("APPROVEDON"));
			elsecoClaims.setCreatedBy(rs.getString("CREATEDBY"));
			elsecoClaims.setSubmittedBy(rs.getString("SUBMITTEDBY"));			
			elsecoClaims.setSubmittedOn(rs.getDate("SUBMITTEDON"));
			elsecoClaims.setApprovedBy(rs.getString("APPROVEDBY"));
			elsecoClaims.setPoolUWYId(rs.getString("POOLUWY_ID"));		
			elsecoClaims.setStatus(rs.getString("STATUS"));
			elsecoClaims.setIsCollected(rs.getString("IS_COLLECTED"));
			elsecoClaims.setCollectionType(rs.getString("COLLECTION_TYPE"));
			elsecoClaims.setPrevpaidAmtIndemnityMI(rs.getBigDecimal("PREVPDCLAMT_INDEMNITY"));
			elsecoClaims.setPrevpaidAmtFeesMI(rs.getBigDecimal("PREVPDCLAMT_FEES"));
			elsecoClaims.setPrevpaidAmtExpensesMI(rs.getBigDecimal("PREVPDCLAMT_EXPENSES"));			
			elsecoClaims.setSettlementAmtIndemnityMI(rs.getBigDecimal("SETLMNTCLAMT_INDEMNITY"));
			elsecoClaims.setSettlementAmtFeesMI(rs.getBigDecimal("SETLMNTCLAMT_FEES"));
			elsecoClaims.setSettlementAmtExpensesMI(rs.getBigDecimal("SETLMNTCLAMT_EXPENSES"));
			elsecoClaims.setReserveAmountIndemnityMI(rs.getBigDecimal("RESERVEAMOUNT_INDEMNITY"));
			elsecoClaims.setReserveAmountFeesMI(rs.getBigDecimal("RESERVEAMOUNT_FEES"));
			elsecoClaims.setReserveAmountExpensesMI(rs.getBigDecimal("RESERVEAMOUNT_EXPENSES"));
			elsecoClaims.setAvailableClmFund(rs.getBigDecimal("AVAILCLM_FUND"));
			elsecoClaims.setAvailableOffSetPrm(rs.getBigDecimal("AVAILOFFSET_PRMIUM"));			
			elsecoClaims.setSplitClaimPercVl(rs.getString("SPLIT_CLAIM_PERC_VL"));
			elsecoClaims.setSplitClaimPercAmt(rs.getBigDecimal("SPLIT_CLAIM_PERC_AMT"));			
			elsecoClaims.setDueDate(rs.getDate("DUE_DATE"));
			elsecoClaims.setCollectedDate(rs.getDate("COLLECTED_DATE"));			
			elsecoClaims.setMemberName(rs.getString("MEMBER_NAME"));
			elsecoClaims.setMemberEmail(rs.getString("MEMBER_EMAIL"));
			elsecoClaims.setNotifyEnabled(rs.getString("NOTIFY_ENABLED"));
			elsecoClaims.setDeleteFlag(rs.getString("DELETE_FLAG"));
			return elsecoClaims;
		}		
	}
	
	/**
	 * RowMapper for the ElsecoMemberResult
	 * 
	 * @author Serole_Vijay
	 */
	@Deprecated
	class ElsecoMemberResultRowMapper implements RowMapper<ElsecoMemberResult> {
		public ElsecoMemberResult mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoMemberResult memberresult=new ElsecoMemberResult();
			memberresult.setResultId(rs.getInt("RESULT_ID"));
			memberresult.setMemberId(rs.getInt("MEMBER_ID"));
			memberresult.setStampId(rs.getInt("STAMP_ID"));
			memberresult.setIntRefId(rs.getInt("INTREF_ID"));
			memberresult.setPolicyTransactionId(rs.getInt("POLICY_TRANSACTION_ID"));
			memberresult.setMarketTransactionId(rs.getInt("MARKET_TRANSACTION_ID"));
			memberresult.setClaimId(rs.getInt("CLAIM_ID"));
			memberresult.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			memberresult.setElRiskCodeId(rs.getInt("ELRISKCODE_ID"));
			memberresult.setMemberBpId(rs.getInt("MEMBER_BPID"));
			memberresult.setMemberName(rs.getString("MEMBER_NAME"));
			memberresult.setTotalCapacityAmount(rs.getBigDecimal("TOTAL_CAPACITY_AMT"));
			memberresult.setTotalShareVl(rs.getString("TOTAL_SHARE_VL"));
			memberresult.setOwnCapacityAmt(rs.getBigDecimal("OWN_CAPACITY_AMT"));
			memberresult.setOwnShareVl(rs.getString("OWN_SHARE_VL"));
			memberresult.setPayPremiumToBpId(rs.getInt("PAY_PREMIUM_TO_BPID"));
			memberresult.setPayPolicyBRtoBpId(rs.getInt("PAY_POLICY_BR_TO_BPID"));
			memberresult.setPayFFtoBpId(rs.getInt("PAY_FF_TO_BPID"));
			memberresult.setPayPBtoBpId(rs.getInt("PAY_PB_TO_BPID"));
			memberresult.setPayRibToBpId(rs.getInt("PAY_RIB_TO_BPID"));
			memberresult.setPolicyBrokerageVl(rs.getString("POLICY_BROKERAGE_VL"));
			memberresult.setElsecoCommissionVl(rs.getString("ELSECO_COMMISSION_VL"));
			memberresult.setFfVl(rs.getString("FF_VL"));
			memberresult.setPbVl(rs.getString("PB_VL"));
			memberresult.setRibVl(rs.getString("RIB_VL"));
			memberresult.setProfitCommisionVl(rs.getString("PROFIT_COMMISSION_VL"));
			memberresult.setPbBasis(rs.getString("PB_BASIS"));
			memberresult.setFfBasis(rs.getString("FF_BASIS"));
			memberresult.setRibBasis(rs.getString("RIB_BASIS"));
			memberresult.setAgreementId(rs.getInt("AGREEMENT_ID"));
			memberresult.setDeleteFlag(rs.getString("DELETE_FLAG"));			
			return memberresult;
			
		}
	}
		
	/**
	 * RowMapper for the ElsecoMemberRiskcode
	 * 
	 * @author Serole_Vijay
	 */
	@Deprecated
	class ElsecoMemberRiskcodeRowMapper implements RowMapper<ElsecoMemberRiskcode> {
		public ElsecoMemberRiskcode mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoMemberRiskcode memberRiskcode=new ElsecoMemberRiskcode();
			memberRiskcode.setLlRiskCodeId(rs.getInt("LLRISKCODE_ID"));
			memberRiskcode.setResultId(rs.getInt("RESULT_ID"));
			memberRiskcode.setMemberId(rs.getInt("MEMBER_ID"));	
			memberRiskcode.setIntRefId(rs.getInt("INTREF_ID"));	
			memberRiskcode.setPolicyTransactionId(rs.getInt("POLICY_TRANSACTION_ID"));
			memberRiskcode.setMarketTransactionId(rs.getInt("MARKET_TRANSACTION_ID"));
			memberRiskcode.setClaimId(rs.getInt("CLAIM_ID"));
			memberRiskcode.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			memberRiskcode.setElRiskCode(rs.getString("ELRISK_CODE"));
			memberRiskcode.setElRiskDescription(rs.getString("ELRISK_DESCRIPTION"));
			memberRiskcode.setLobId(rs.getInt("LOB_ID"));
			memberRiskcode.setSegmentId(rs.getInt("SEGMENT_ID"));
			memberRiskcode.setDeleteFlag(rs.getString("DELETE_FLAG"));		
			
			return memberRiskcode;
			
		}
	}
	
	
	/**
	 * RowMapper for the ElsecoMemberRiskcode
	 * 
	 * @author Serole_Vijay
	 */
	class ElsecoClaimsIntReferenceRowMapper implements RowMapper<ElsecoClaimsInternalReference> {
		public ElsecoClaimsInternalReference mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsInternalReference intRef =new ElsecoClaimsInternalReference();
			intRef.setIntRefId(rs.getInt("INTREF_ID"));			
			intRef.setStampId(rs.getInt("STAMP_ID"));	
			intRef.setPolicyTransactionId(rs.getInt("POLICY_TRANSACTION_ID"));	
			intRef.setMarketTransactionId(rs.getInt("MARKET_TRANSACTION_ID"));				
			intRef.setClaimId(rs.getInt("CLAIM_ID"));
			intRef.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			intRef.setSplitClaimPercVl(rs.getString("SPLIT_CLAIM_PERC_VL"));
			intRef.setSplitClaimPercAmt(rs.getBigDecimal("SPLIT_CLAIM_PERC_AMT"));
			intRef.setFundsCollected(rs.getString("FUNDS_COLLECTED"));					
			intRef.setElsecoRiskCode(rs.getString("ELSECO_RISK_CD"));			
			intRef.setIntReferenceNo(rs.getString("INTERNAL_REFERENCE_NO"));
			intRef.setPremiumSplitVl(rs.getString("PREMIUM_SPLIT_VL"));
			intRef.setStampId(rs.getInt("STAMP_ID"));
			intRef.setIsCollected(rs.getString("IS_COLLECTED"));
			intRef.setStampName(rs.getString("STAMP_NAME"));
			intRef.setTransactionType(rs.getString("TRANSACTIONTYPE"));
			intRef.setTransactionSubType(rs.getString("TRANSACTIONSUBTYPE"));
			intRef.setComment(rs.getString("COMMENT"));
			intRef.setDueDate(rs.getDate("DUEDATE"));
			intRef.setNwincurdclamt(rs.getBigDecimal("NWINCURDCLAMT"));
			intRef.setCollectPayEnabled(rs.getString("COLLECT_PAY_ENABLED"));
			intRef.setOriginalCurrency(rs.getString("ORIGINALCURRENCY"));
			intRef.setPrevpdclamt(rs.getBigDecimal("PREVPDCLAMT"));			
			intRef.setSetlmntclamt(rs.getBigDecimal("SETLMNTCLAMT"));	
			intRef.setPrevpaidAmtIndemnityIR(rs.getBigDecimal("PREVPDCLAMT_INDEMNITY"));
			intRef.setPrevpaidAmtFeesIR(rs.getBigDecimal("PREVPDCLAMT_FEES"));
			intRef.setPrevpaidAmtExpensesIR(rs.getBigDecimal("PREVPDCLAMT_EXPENSES"));			
			intRef.setSettlementAmtIndemnityIR(rs.getBigDecimal("SETLMNTCLAMT_INDEMNITY"));
			intRef.setSettlementAmtFeesIR(rs.getBigDecimal("SETLMNTCLAMT_FEES"));
			intRef.setSettlementAmtExpensesIR(rs.getBigDecimal("SETLMNTCLAMT_EXPENSES"));
			intRef.setReserveAmountIndemnityIR(rs.getBigDecimal("RESERVEAMOUNT_INDEMNITY"));
			intRef.setReserveAmountFeesIR(rs.getBigDecimal("RESERVEAMOUNT_FEES"));
			intRef.setReserveAmountExpensesIR(rs.getBigDecimal("RESERVEAMOUNT_EXPENSES"));
			intRef.setDeleteFlag(rs.getString("DELETE_FLAG"));		
			
			return intRef;
			
		}
	}
	
	/**
	 * RowMapper for the Audit Trail 
	 * 
	 * @author Serole_Vijay
	 */
	class AuditDataRowMapper implements RowMapper<ElsecoClaimsAuditTrail> {
		public ElsecoClaimsAuditTrail mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoClaimsAuditTrail lookup = new ElsecoClaimsAuditTrail();
			lookup.setID(rs.getInt("ID"));				
			lookup.setApplicationHandle(rs.getString("APPLICATIONHANDLE"));
			lookup.setModuleHandle(rs.getString("MODULEHANDLE"));
			lookup.setScreenHandle(rs.getString("SCREENHANDLE"));
			lookup.setCrudEntityHandle(rs.getString("CRUDENTITYHANDLE"));
			lookup.setUniqueId(rs.getString("UNIQUEID"));
			lookup.setOperatorType(rs.getString("OPERATORTYPE"));				
			lookup.setSourceIPAddress(rs.getString("SOURCEIPADDRESS"));
			lookup.setCreatedBy(rs.getString("CREATEDBY"));
			lookup.setCreatedDateTime(rs.getTimestamp("CREATEDDATETIME"));
			lookup.setOldClobJson(rs.getString("OLDCLOBJSON"));
			lookup.setNewClobJson(rs.getString("NEWCLOBJSON"));	
			
			//LOG.info(" Audit Trail Lookup Data      " + lookup.toString());
			return lookup;				
		}
	}
	
	/**
	 * RowMapper for the Check List
	 * 
	 *@author Serole_Vijay
	 */
	class ElsecoCheckListRowMapper implements RowMapper<ElsecoCheckList> {
		public ElsecoCheckList mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoCheckList checklist = new ElsecoCheckList();
			checklist.setCheckListId(rs.getInt("CHECKLIST_ID"));
			checklist.setCheckListName(rs.getString("CHECKLIST_NAME"));
			checklist.setCheckListGroup(rs.getString("CHECKLIST_GROUP"));
			checklist.setClaimHeaderId(rs.getInt("CLAIM_HEADER_ID"));
			checklist.setClaimDetailId(rs.getInt("CLAIM_DETAIL_ID"));
			checklist.setClaimFileId(rs.getInt("CLAIM_FILE_ID"));
			checklist.setClaimItemId(rs.getInt("CLAIM_ITEM_ID"));
			checklist.setUcrNumber(rs.getString("UCR_NO"));
			checklist.setExternalRef(rs.getString("EXTERNAL_REF"));
			checklist.setLevel(rs.getString("LEVEL"));
			checklist.setCheckedBy(rs.getString("CHECKED_BY"));
			checklist.setIsChecked(rs.getString("IS_CHECKED"));
			checklist.setCheckedDate(rs.getTimestamp("CHECKED_DATE"));
			checklist.setDeleteFlag(rs.getString("DELETE_FLAG"));
			
			return checklist;				
		}
	}
		
	/**
	 * RowMapper for the Hybris Payment History
	 * 
	 *@author Serole_Vijay
	 */
	class ElsecoHybrisPayHistoryRowMapper implements RowMapper<ElsecoHybrisPayHistory> {
		public ElsecoHybrisPayHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
			ElsecoHybrisPayHistory hybrisPayment = new ElsecoHybrisPayHistory();
			hybrisPayment.setPayHistoryId(rs.getString("PAYHISTORY_ID"));
			hybrisPayment.setClaimHeaderId(rs.getString("CLAIM_HEADER_ID"));
			hybrisPayment.setClaimDetailId(rs.getString("CLAIM_DETAIL_ID"));
			hybrisPayment.setClaimTransId(rs.getString("CLAIM_TRANSACTION_ID"));
			hybrisPayment.setClaimIntRefId(rs.getString("CLAIM_INTREF_ID"));
			hybrisPayment.setMemberId(rs.getString("MEMBER_ID"));
			hybrisPayment.setUcr(rs.getString("UCR"));
			hybrisPayment.setUmr(rs.getString("UMR"));
			hybrisPayment.setElClaimId(rs.getString("EL_CLAIM_ID"));
			hybrisPayment.setSettlementAmtIndem(rs.getString("SETTLEMENT_AM_INDEM"));
			hybrisPayment.setSettlementAmtFees(rs.getString("SETTLEMENT_AM_FEES"));
			hybrisPayment.setSettlementAmtExpense(rs.getString("SETTLEMENT_AM_EXP"));
			hybrisPayment.setReserveAmtIndem(rs.getString("RESERVE_AM_INDEM"));
			hybrisPayment.setReserveAmtFees(rs.getString("RESERVE_AM_FEES"));
			hybrisPayment.setReserveAmtExpense(rs.getString("RESERVE_AM_EXP"));
			hybrisPayment.setIncurredAmt(rs.getString("INCURRED_AM"));
			hybrisPayment.setCurrency(rs.getString("CURRENCY"));
			hybrisPayment.setPaymentType(rs.getString("PAYMT_TYP"));
			hybrisPayment.setStatus(rs.getString("STATUS"));
			hybrisPayment.setIsCollected(rs.getString("IS_COLLECTED"));
						
			return hybrisPayment;				
		}
	}
}
