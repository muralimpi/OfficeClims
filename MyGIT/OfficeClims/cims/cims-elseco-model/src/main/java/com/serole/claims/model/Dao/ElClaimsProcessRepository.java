package com.serole.claims.model.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
import com.serole.claims.model.filterbeans.CriteriaEntity;
import com.serole.claims.model.json.JsonHandlerForWorklistAndSaveClaims;


/**
 * A class that implements the Spring based JDBCTemplate for all the Database
 * operations
 * 
 * @author Serole_Vijay
 *
 */
@Repository
public class ElClaimsProcessRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ElClaimsEntityRepository entityRepo;
			
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public ElsecoClaimsHeader getClaimHeaderById(CriteriaEntity criteriaEntity) throws Exception{
		//LOG.info("About to getClaimHeaderBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT H.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H "				
				+ " WHERE H.CLAIM_HEADER_ID = ?";
		return (ElsecoClaimsHeader) jdbcTemplate.queryForObject(qry, new Object[] { criteriaEntity.getClaimHeaderId() }, entityRepo.new ElsecoClaimsHeaderRowMapper());		
	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<JsonHandlerForWorklistAndSaveClaims> getClaimHeaderBySearchCriteria(CriteriaEntity criteriaEntity, boolean flag) throws Exception{
		//LOG.info("About to getClaimHeaderBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT H.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ";
				//+ " LEFT JOIN \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\" D ON D.\"CLAIM_HEADER_ID\" = H.\"CLAIM_HEADER_ID\" "; 
		StringBuffer criteriaQry = new StringBuffer();

		if(flag) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.DELETE_FLAG <> 'S' ");
		}
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getEffectiveDate() != null && !("").equals(criteriaEntity.getEffectiveDate().toString())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.EFFECTIVE_DATE = '" + criteriaEntity.getEffectiveDate()+"' ");
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}
		if (criteriaEntity.getUcrName() != null && !("").equals(criteriaEntity.getUcrName())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NAME = '" + criteriaEntity.getUcrName()+"' ");
		}
		if (criteriaEntity.getUmrNumber() != null && !("").equals(criteriaEntity.getUmrNumber())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UMR_NO = '" + criteriaEntity.getUmrNumber()+"' ");
		}
		if (criteriaEntity.getStatus() != null && !("").equals(criteriaEntity.getStatus())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.STATUS = '" + criteriaEntity.getStatus()+"' ");
		}
		if (criteriaEntity.getDealId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.DEAL_ID = " + criteriaEntity.getDealId());
		}
		if (criteriaEntity.getLloydsRiskCode() != null && !("").equals(criteriaEntity.getLloydsRiskCode())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.LLOYDS_RISK_CD = '" + criteriaEntity.getLloydsRiskCode()+"' ");
		}
		if (criteriaEntity.getProductCode() != null && !("").equals(criteriaEntity.getProductCode())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.PRODUCT_CD = '" + criteriaEntity.getProductCode()+"' ");
		}
		if (criteriaEntity.getLobCode() != null && !("").equals(criteriaEntity.getLobCode())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.LOB_CD = '" + criteriaEntity.getLobCode()+"' ");
		}	
		if (criteriaEntity.getExtRefNo() != null && !("").equals(criteriaEntity.getExtRefNo())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.EXTREFNO = '" + criteriaEntity.getExtRefNo()+"' "); // ExtRefNo in Header will never exists and always be blank
		}	
		if (criteriaEntity.getDateOfLoss() != null && !("").equals(criteriaEntity.getDateOfLoss().toString())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.DT_OF_LOSS = '" + criteriaEntity.getDateOfLoss()+"' ");
		}
		if (criteriaEntity.getClaimReporter() != null && !("").equals(criteriaEntity.getClaimReporter())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_REPORTER = '" + criteriaEntity.getClaimReporter()+"' ");
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}

		//LOG.info("Final query is :" + qry);
		return (List<JsonHandlerForWorklistAndSaveClaims>) jdbcTemplate.query(qry + " ORDER BY H.CLAIM_HEADER_ID DESC ", new Object[] {}, entityRepo.new WorkListRowMapper()); 		
	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimDetails> getClaimDetailBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception{
		//LOG.info("About to getClaimDetailBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT D.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D " + 
				" left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  H.CLAIM_HEADER_ID = D.CLAIM_HEADER_ID ";
				//+ " WHERE \"STATUS\" = 'Open' ";

		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" D.DELETE_FLAG <> 'S' ");
	
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}
		if (criteriaEntity.getUcrName() != null && !("").equals(criteriaEntity.getUcrName())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NAME = '" + criteriaEntity.getUcrName()+"' ");
		}
		if (criteriaEntity.getStatus() != null && !("").equals(criteriaEntity.getStatus())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.STATUS = '" + criteriaEntity.getStatus()+"' ");
		}
		if (criteriaEntity.getDealId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.DEAL_ID = " + criteriaEntity.getDealId());
		}
		if (criteriaEntity.getUmrNumber() != null && !("").equals(criteriaEntity.getUmrNumber())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UMR_NO = '" + criteriaEntity.getUmrNumber()+"' ");
		}		
		if (criteriaEntity.getProductCode() != null && !("").equals(criteriaEntity.getProductCode())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.PRODUCT_CD = '" + criteriaEntity.getProductCode()+"' ");
		}
		if (criteriaEntity.getLobCode() != null && !("").equals(criteriaEntity.getLobCode())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.LOB_CD = '" + criteriaEntity.getLobCode()+"' ");
		}
		if (criteriaEntity.getExtRefNo() != null && !("").equals(criteriaEntity.getExtRefNo())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" D.EXTREFNO = '" + criteriaEntity.getExtRefNo()+"' "); // ExtRefNo does not exists in Header, it exists in Detail level
		}	
		if (criteriaEntity.getClaimReporter() != null && !("").equals(criteriaEntity.getClaimReporter())) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_REPORTER = '" + criteriaEntity.getClaimReporter()+"' ");
		}				
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}

		try {
			//LOG.info("Final query is :" + qry);
			return (List<ElsecoClaimDetails>) jdbcTemplate.query(qry, new Object[] {},
					entityRepo.new ElsecoClaimDetailRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}

	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimReserve> getClaimReserveBySearchCriteria(CriteriaEntity criteriaEntity) throws Exception{
		//LOG.info("About to getClaimReserveBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT R.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimReserve_T\"  R "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H  ON  R.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID ";
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" R.DELETE_FLAG <> 'S' ");
	
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" R.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimReserveRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoRiskObject> getClaimRiskobjBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimRiskobjBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT R.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_RiskObject_T\"  R "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H  ON  R.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID ";
		StringBuffer criteriaQry = new StringBuffer();	
		
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" R.DELETE_FLAG <> 'S' ");
	
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" R.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {			
			criteriaQry.append(" AND R.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}
		if (criteriaEntity.getExtRefNo() != null && !("").equals(criteriaEntity.getExtRefNo())) {			
			criteriaQry.append(" AND R.EXTREFNO = '" + criteriaEntity.getExtRefNo()+"' ");
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimRiskobjRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}
		
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsNotes> getClaimNotesBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimHeaderBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT R.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimNotes_T\"  R "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H  ON  R.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID ";
		StringBuffer criteriaQry = new StringBuffer();	
		
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" R.DELETE_FLAG <> 'S' ");
	
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" R.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimsNotesRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsTasks> getClaimTasksBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimHeaderBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT R.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimTasks_T\"  R "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H  ON  R.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID ";
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" R.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" R.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimTaskRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}

	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsFile> getClaimFilesBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimFilesBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT F.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimFile_T\"  F "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  F.CLAIM_ID = D.CLAIM_ID "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;	
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" F.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimsFileRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsItems> getClaimItemsBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimFilesBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT F.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimItem_T\"  F "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  D.CLAIM_ID = F.CLAIM_ID "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;			
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" F.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimsItemRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsParty> getClaimPartyBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimPartyBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT P.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimParty_T\"  P "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  D.CLAIM_ID = P.CLAIM_ID "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;			
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" P.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimsPartyRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsPayee> getClaimPayeeBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimPayeeBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT P.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimPayee_T\"  P "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  D.CLAIM_ID = P.CLAIM_ID "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;			
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" P.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimsPayeeRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
		
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoCheckList> getClaimChecklistBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimHeaderBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT R.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_CheckList_T\"  R "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H  ON  R.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID ";
		StringBuffer criteriaQry = new StringBuffer();	
		
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" R.DELETE_FLAG <> 'S' ");
	
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" R.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoCheckListRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}
	
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsTransaction> getClaimTransBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimTransBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT T.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_Transactions_T\"  T "		
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  T.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;			
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" T.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {	
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}	
		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry  + " ORDER BY T.CREATEDDATE DESC ", new Object[] {}, entityRepo.new ElsecoClaimsTransactionRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
		
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoClaimsInternalReference> getClaimIntReferenceBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimIntReferenceBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT I.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\"  I "	
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D ON  D.CLAIM_ID = I.CLAIM_ID "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;			
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" I.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {	
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoClaimsIntReferenceRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoHybrisPayHistory> getHybrisPaymentBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimMemberInfoBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT M.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_HybrisPayHistory_T\"  M "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_InternalReference_T\"  I  ON  I.INTREF_ID = M.CLAIM_INTREF_ID "		
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  D.CLAIM_ID = M.CLAIM_DETAIL_ID "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;			
		StringBuffer criteriaQry = new StringBuffer();
				
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {	
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoHybrisPayHistoryRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
		
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoMemberInfo> getClaimMemberInfoBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimMemberInfoBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT M.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\"  M "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  D.CLAIM_ID = M.CLAIM_ID "
		+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;			
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" M.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {	
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoMemberInfoRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoMemberResult> getClaimMemberResultBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimMemberResultBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT R.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\"  R "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\"   M  ON  R.MEMBER_ID = M.MEMBER_ID "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  D.CLAIM_ID = M.CLAIM_ID "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H  ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;	
		
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" R.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {	
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoMemberResultRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ElsecoMemberRiskcode> getClaimMemberRiskCodeBySearchCriteria(CriteriaEntity criteriaEntity)  throws Exception{
		//LOG.info("About to getClaimMemberRiskCodeBySearchCriteria :" + criteriaEntity.toString());

		String qry = "SELECT C.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberRiskcode_T\"  C "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberResult_T\" R  ON  R.RESULT_ID = C.RESULT_ID "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\"   M  ON  R.MEMBER_ID = M.MEMBER_ID "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  D  ON  D.CLAIM_ID = M.CLAIM_ID "
				+ " left join  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H  ON  D.CLAIM_HEADER_ID = H.CLAIM_HEADER_ID "	;	
		
		StringBuffer criteriaQry = new StringBuffer();
		if (criteriaQry.length() > 1)
			criteriaQry.append(" AND ");
		criteriaQry.append(" C.DELETE_FLAG <> 'S' ");
		
		if (criteriaEntity.getClaimHeaderId() > 0) {
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.CLAIM_HEADER_ID = " + criteriaEntity.getClaimHeaderId());
		}
		if (criteriaEntity.getUcrNumber() != null && !("").equals(criteriaEntity.getUcrNumber())) {	
			if (criteriaQry.length() > 1)
				criteriaQry.append(" AND ");
			criteriaQry.append(" H.UCR_NO = '" + criteriaEntity.getUcrNumber()+"' ");
		}		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + " WHERE " + criteriaQry;
		}
		try {
			//LOG.info("Final query is :" + qry);
			return jdbcTemplate.query(qry, new Object[] {}, entityRepo.new ElsecoMemberRiskcodeRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	
	/**
	 * Retrieve the data from static table for Lookup from UI
	 * 
	 * @param handle
	 * @param id
	 * @return
	 */
	public List<ElsecoClaimsStaticData> lookUpDataSearch(String screenHandle, String entityHandle )  throws Exception{
		String qry = "SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_StaticData_T\" WHERE  \"IsEnable\" = \'Y\'  ";
		
		StringBuffer criteriaQry = new StringBuffer();
		if (screenHandle!=null && !screenHandle.equals("")) {			
			criteriaQry.append(" AND \"ScreenHandle\" like '%" + screenHandle+ "%' ");
		}
		
		if (entityHandle!=null && !entityHandle.equals("")) {			
			criteriaQry.append(" AND \"EntityHandle\" = '"+entityHandle.toUpperCase()+"' ");
		}
		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + criteriaQry;
		}
		
		try {
			//LOG.info("Final query is :" + qry);
			return (List<ElsecoClaimsStaticData>) jdbcTemplate.query(qry, new Object[] {}, entityRepo.new StaticDataRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}		
	
	}
	
	/**
	 * Retrieve All the static data from static table 
	 * 
	 * @param handle
	 * @param id
	 * @return
	 */
	public List<ElsecoClaimsStaticData> lookUpStaticData(String screenHandle)  throws Exception{
		String qry = "SELECT * FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_StaticData_T\" WHERE  \"IsEnable\" = \'Y\'  ";
		
		StringBuffer criteriaQry = new StringBuffer();
		if (screenHandle!=null && !screenHandle.equals("")) {			
			criteriaQry.append(" AND \"ScreenHandle\" like '%" + screenHandle+ "%' ");
		}		
		
		if (criteriaQry.toString().length() > 1) {
			qry = qry + criteriaQry;
		}
		
		try {
			//LOG.info("Final query is :" + qry);
			return (List<ElsecoClaimsStaticData>) jdbcTemplate.query(qry, new Object[] {}, entityRepo.new StaticDataRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}		
	}
	
	/**
	 * updateMemberInfoAfterPayment - Update the Member Info section with Collected status after the Hybris payment call
	 * 
	 * @param isCollected
	 * @param status
	 */
	public void updateMemberInfoAfterPayment(ElsecoHybrisPayHistory hybrisPay)  throws Exception{		
		jdbcTemplate.update(" UPDATE  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_MemberInfo_T\" SET IS_COLLECTED = ?, STATUS = ? "
				+ " WHERE CLAIM_ID = ? AND CLAIM_HEADER_ID = ? AND MEMBER_BP_ID = ? AND INTREF_ID = ? ",
				new Object[] {hybrisPay.getIsCollected(), hybrisPay.getStatus(), hybrisPay.getClaimDetailId(), hybrisPay.getClaimHeaderId(), 
						hybrisPay.getMemberId(), hybrisPay.getClaimIntRefId() });
	}	
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = true)
	public List<ElsecoClaimsStaticData> getCompleteStaticData()  throws Exception{
		return jdbcTemplate.query("select * from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_StaticData_T\" ",
				new BeanPropertyRowMapper(ElsecoClaimsStaticData.class));
	}

	/**
	 * Get the Audit Trail details based on the Search Criteria
	 * 
	 * @param criteriaEntity
	 * @return
	 */
	public List<ElsecoClaimsAuditTrail> getAuditDetailsBySearchCriteria(String uniqueId, String entityHandler) throws Exception{	
		String qry = " SELECT A.* FROM  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_AuditTrail_T\" A  "
				+ " WHERE A.UNIQUEID = ? AND A.CRUDENTITYHANDLE = ? ";
		//LOG.info("Final query is :" + qry);
		return jdbcTemplate.query(qry, new Object[] {uniqueId, entityHandler}, entityRepo.new AuditDataRowMapper());				
	}
	
	/**
	 * Update the status of the claim based on headerId and detailId
	 * 
	 * @param headerId
	 * @param detailId
	 * @param statusHandle
	 */
	public void updateClaimDetailStatus(String headerId, String detailId, String statusHandle)  throws Exception{
		jdbcTemplate.update(" UPDATE  \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\" SET CLAIM_DETAIL_STATUS = ? WHERE CLAIM_ID = ? AND CLAIM_HEADER_ID = ? ",
				new Object[] {statusHandle, detailId, headerId });
	}
	
	/**
	 * Validate whether any Claims exists with given UMR and UCR number to avoid duplicates
	 * 
	 * @param Umr
	 * @param Ucr
	 * @return
	 * @throws Exception
	 */
	public List<ElsecoClaimsHeader> isClaimExistsWithUmrAndUcr(String Umr, String Ucr) throws Exception {		
		String qry = "SELECT H.* from \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"  H WHERE H.UMR_NO = ? AND H.UCR_NO = ? ";
		return jdbcTemplate.query(qry, new Object[] { Umr, Ucr }, entityRepo.new ElsecoClaimsHeaderRowMapper());
	}
		
	/**
	 * A method to update the Claims in Database
	 * 
	 * @return
	 */
	/*public int updateClaimDetailNextAppStatus(String nextStatus, int claimId, int headerId) throws Exception{
		LOG.info("About to updateClaimDetailNextAppStatus :"+nextStatus+"    claimId:"+claimId+ "   headerId:"+headerId );

		return jdbcTemplate.update("update \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimDetail_T\"  set  NEXT_APP_STATUS = ?"
				+ " where CLAIM_ID = ? AND CLAIM_HEADER_ID = ? ",
				new Object[] { nextStatus, claimId, headerId });
	}*/	
}
