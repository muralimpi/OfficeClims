package com.serole.claims.model.Elseco;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.serole.claims.model.ClaimsItems;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimItem_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsItems extends ClaimsItems {
		
	public ElsecoClaimsItems(){  }
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_ITEM_ID")
	private int claimItemId;   				//CLAIM_ITEM_ID	
	
	@Column(name = "CLAIM_HEADER_ID")		//CLAIM_HEADER_ID
	private int claimHeaderId;
	
	@Column(name = "SUBCLAIM_ID")
	private int subClaimId; 				//SUBCLAIM_ID
	
	@Column(name = "CLAIM_ID")
	private int claimId;   					//CLAIM_ID	

	@Column(name = "VERSION")
	private String version;   				//VERSION	
		
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate; 			//EFFECTIVE_DATE	
	
	@Column(name = "CHNG_INDICATOR")
	private String chngIndicator; 			//CHNG_INDICATOR	
	
	@Column(name = "EXT_CLAIM_ITEM_NO")
	private String extClaimItemNo; 			//EXT_CLAIM_ITEM_NO	
	
	@Column(name = "BENEFIT_TYPE")
	private String benefitType; 			//BENEFIT_TYPE	
	
	@Column(name = "ITEM_OBJ_TYPE")
	private String itemObjType; 			//ITEM_OBJ_TYPE	
	
	@Column(name = "COVG_TYPE")
	private String covgType; 				//COVG_TYPE	
	
	@Column(name = "AMT_EVALUATED", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal  amtEvaluated;// = new BigDecimal(15); //AMT_EVALUATED	
	
	@Column(name = "CURR_EVAL")
	private String currEval; //CURR_EVAL	
	
	@Column(name = "EVAL_AMT_PERUNIT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal evalAmtPerUnit;// = new BigDecimal(15); //EVAL_AMT_PERUNIT	
	
	@Column(name = "EVAL_QUANTITY")
	private String evalQuantity; 			//EVAL_QUANTITY
	
	@Column(name = "EVAL_QUANT_UNIT")
	private String evalQuantUnit; 			//EVAL_QUANT_UNIT
	
	@Column(name = "STATUS_ITEM")
	private String statusItem; 				//STATUS_ITEM
	
	@Column(name = "DESCRIPTION_ITEM")
	private String descriptionItem; 		//DESCRIPTION_ITEM

	@Transient
	//@JsonInclude(Include.NON_NULL)
	private List<ElsecoCheckList> ClaimsCheckListInfo;
	
	/**
	 * @return the claimHeaderId
	 */
	public int getClaimHeaderId() {
		return claimHeaderId;
	}

	/**
	 * @param claimHeaderId the claimHeaderId to set
	 */
	public void setClaimHeaderId(int claimHeaderId) {
		this.claimHeaderId = claimHeaderId;
	}

	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 		//DELETE_FLAG
	
	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public int getClaimItemId() {
		return claimItemId;
	}

	public void setClaimItemId(int claimItemId) {
		this.claimItemId = claimItemId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getSubClaimId() {
		return subClaimId;
	}

	public void setSubClaimId(int subClaimId) {
		this.subClaimId = subClaimId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getChngIndicator() {
		return chngIndicator;
	}

	public void setChngIndicator(String chngIndicator) {
		this.chngIndicator = chngIndicator;
	}

	public String getExtClaimItemNo() {
		return extClaimItemNo;
	}

	public void setExtClaimItemNo(String extClaimItemNo) {
		this.extClaimItemNo = extClaimItemNo;
	}

	public String getBenefitType() {
		return benefitType;
	}

	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}

	public String getItemObjType() {
		return itemObjType;
	}

	public void setItemObjType(String itemObjType) {
		this.itemObjType = itemObjType;
	}

	public String getCovgType() {
		return covgType;
	}

	public void setCovgType(String covgType) {
		this.covgType = covgType;
	}

	public BigDecimal getAmtEvaluated() {
		return amtEvaluated;
	}

	public void setAmtEvaluated(BigDecimal amtEvaluated) {
		this.amtEvaluated = amtEvaluated;
	}

	public String getCurrEval() {
		return currEval;
	}

	public void setCurrEval(String currEval) {
		this.currEval = currEval;
	}

	public BigDecimal getEvalAmtPerUnit() {
		return evalAmtPerUnit;
	}

	public void setEvalAmtPerUnit(BigDecimal evalAmtPerUnit) {
		this.evalAmtPerUnit = evalAmtPerUnit;
	}

	public String getEvalQuantity() {
		return evalQuantity;
	}

	public void setEvalQuantity(String evalQuantity) {
		this.evalQuantity = evalQuantity;
	}

	public String getEvalQuantUnit() {
		return evalQuantUnit;
	}

	public void setEvalQuantUnit(String evalQuantUnit) {
		this.evalQuantUnit = evalQuantUnit;
	}

	public String getStatusItem() {
		return statusItem;
	}

	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}

	public String getDescriptionItem() {
		return descriptionItem;
	}

	public void setDescriptionItem(String descriptionItem) {
		this.descriptionItem = descriptionItem;
	}	

	/**
	 * @return the claimsCheckListInfo
	 */
	public List<ElsecoCheckList> getClaimsCheckListInfo() {
		return ClaimsCheckListInfo;
	}

	/**
	 * @param claimsCheckListInfo the claimsCheckListInfo to set
	 */
	public void setClaimsCheckListInfo(List<ElsecoCheckList> claimsCheckListInfo) {
		ClaimsCheckListInfo = claimsCheckListInfo;
	}

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsItems [claimId=" + claimId + ", claimItemId=" + claimItemId + ", subClaimId=" + subClaimId
				+ ", " + (version != null ? "version=" + version + ", " : "")
				+ (effectiveDate != null ? "effectiveDate=" + effectiveDate + ", " : "")
				+ (chngIndicator != null ? "chngIndicator=" + chngIndicator + ", " : "")
				+ (extClaimItemNo != null ? "extClaimItemNo=" + extClaimItemNo + ", " : "")
				+ (benefitType != null ? "benefitType=" + benefitType + ", " : "")
				+ (itemObjType != null ? "itemObjType=" + itemObjType + ", " : "")
				+ (covgType != null ? "covgType=" + covgType + ", " : "")
				+ (amtEvaluated != null ? "amtEvaluated=" + amtEvaluated + ", " : "")
				+ (currEval != null ? "currEval=" + currEval + ", " : "")
				+ (evalAmtPerUnit != null ? "evalAmtPerUnit=" + evalAmtPerUnit + ", " : "")
				+ (evalQuantity != null ? "evalQuantity=" + evalQuantity + ", " : "")
				+ (evalQuantUnit != null ? "evalQuantUnit=" + evalQuantUnit + ", " : "")
				+ (statusItem != null ? "statusItem=" + statusItem + ", " : "")
				+ (descriptionItem != null ? "descriptionItem=" + descriptionItem + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}
