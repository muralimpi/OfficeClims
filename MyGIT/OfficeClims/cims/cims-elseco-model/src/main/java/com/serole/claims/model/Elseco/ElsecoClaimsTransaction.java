package com.serole.claims.model.Elseco;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_Transactions_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsTransaction{            
	public ElsecoClaimsTransaction(){  }
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_TRANSACTION_ID")
	private int claimsTransactionId;   						//CLAIM_TRANSACTION_ID	
	
	@Column(name = "CLAIM_HEADER_ID")						//CLAIM_HEADER_ID
	private int claimHeaderid;
	
	@Column(name = "CLAIM_ID")								//CLAIM_ID
	private int claimid;	

	@Column(name = "CLAIM_ITEM_ID")							//CLAIM_ITEM_ID
	private int claimItemId;
	
	@Column(name = "APPLICATIONHANDLE")						//APPLICATIONHANDLE
	private String applicationhandle = "";   					
		
	@Column(name = "MODULEHANDLE")							//MODULEHANDLE
	private String modulehandle = "";   					
	
	@Column(name = "SCREENHANDLE")							//SCREENHANDLE
	private String screenhandle = ""; 				
	
	@Column(name = "UMR_NO")								//UMR_NO
	private String umrNumber = "";  				
	
	@Column(name = "UCR_NO")								//UCR_NO
	private String ucrNumber = "";  				
	
	@Column(name = "POLICY_TRANSREF_NO")					//POLICY_TRANSREF_NO,
	private String policyTransRefNo = "";  				
	
	@Column(name = "MARKET_TRANSREF_NO")					//MARKET_TRANSREF_NO,
	private String marketTransRefNo = "";
	
	@Column(name = "TRANS_RECORD_TYPE")						//TRANS_RECORD_TYPE
	private String transactionRecordType = ""; 
	
	@Column(name = "TRANSACTIONTYPE")						//TRANSACTIONTYPE
	private String transactionType = "";  	
	
	@Column(name = "TRANSACTIONSUBTYPE")					//TRANSACTIONSUBTYPE
	private String transactionSubType = "";  	
	
	@Column(name = "TRANSACTION_DESCRIPTION")				//TRANSACTION_DESCRIPTION
	private String transDescription = "";  	
	
	@Column(name = "COMMENT")								//COMMENT
	private String comment = "";  				
	
	@Column(name = "OUTSTNDCLAMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal outStndclamt;  						//OUTSTNDCLAMT		
	
	@Column(name = "NWINCURDCLAMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal nwincurdclamt;  						//NWINCURDCLAMT	
		
	@Column(name = "PREVPDCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtIndemnityTR;  				//PREVPDCLAMT_INDEMNITY
	
	@Column(name = "PREVPDCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtFeesTR;  					//PREVPDCLAMT_FEES
	
	@Column(name = "PREVPDCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtExpensesTR;  				//PREVPDCLAMT_EXPENSES
	
	@Column(name = "SETLMNTCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtIndemnityTR;				//SETLMNTCLAMT_INDEMNITY
	
	@Column(name = "SETLMNTCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtFeesTR;					//SETLMNTCLAMT_FEES
	
	@Column(name = "SETLMNTCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtExpensesTR;				//SETLMNTCLAMT_EXPENSES
	
	@Column(name = "RESERVEAMOUNT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountIndemnityTR;  			//RESERVEAMOUNT_INDEMNITY
	
	@Column(name = "RESERVEAMOUNT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountFeesTR; 					//RESERVEAMOUNT_FEES
	
	@Column(name = "RESERVEAMOUNT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountExpensesTR;				//RESERVEAMOUNT_EXPENSES
	
	@Column(name = "ORIGINALCURRENCY")						//ORIGINALCURRENCY
	private String originalCurrency = "";
	
	@Column(name = "TRANSACTIONCURRENCY")					//TRANSACTIONCURRENCY
	private String transactionCurrency = "";
	
	@Column(name = "RATE_OF_EXCH")							//RATE_OF_EXCH
	private String rateOfExchange = "";
	
	@Column(name = "ORIGINAL_AMT")							//ORIGINAL_AMT
	private String originalAmount = "";
	
	@Column(name = "DUEDATE")
	private Date dueDate = null;  							//DUEDATE
	
	@Column(name = "INCOMING_PAYMENT")
	private String incomingPayment = "";  					//INCOMING_PAYMENT
	
	@Column(name = "OUTGOING_PAYMENT")
	private String outgoingPayment = "";  					//OUTGOING_PAYMENT
	
	@Column(name = "SPLIT_CLAIM_PERC_VL")
	private String splitClaimPercVl  = "";					//"SPLIT_CLAIM_PERC_VL"
	
	@Column(name = "SPLIT_CLAIM_PERC_AMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal splitClaimPercAmt ;					//"SPLIT_CLAIM_PERC_AMT"
	
	@Column(name = "INTERNALSTATUS")						//INTERNALSTATUS
	private String internalStatus = "Waiting for Approval";
	
	@Column(name = "EXTERNALSTATUS")						//EXTERNALSTATUS
	private String externalStatus = "";
	
	@Column(name = "NEXT_STATUS")							//NEXT_STATUS
	private String nextStatus = "";
	
	@Column(name = "AUTHOR")								//AUTHOR
	private String author = "";	

	@Column(name = "EXTRNL_ID")								//EXTRNL_ID
	private int extrnlid ;
	
	@Column(name = "PARTY_ID")								//PARTY_ID
	private int partyId ;
	
	@Column(name = "PARTY_NAME")							//PARTY_NAME
	private String partyName ;
	
	@Column(name = "PARTY_BP_ID")
	private int partyBpId;
	
	@Column(name = "PRINT_SORT_CODE")						//PRINT_SORT_CODE
	private String printSortCode = "";
	
	@Column(name = "ECF_INDICATOR")							//ECF_INDICATOR
	private String ecfIndicator = "";
	
	@Column(name = "CARRIER_CODE")							//CARRIER_CODE
	private String carrierCode = "";
	
	@Column(name = "CARRIER_PERCENTAGE")					//CARRIER_PERCENTAGE
	private String carrierPercentage = "";
	
	@Column(name = "CARRIER_REFERENCE")						//CARRIER_REFERENCE
	private String carrierReference = "";
	
	@Column(name = "ROLE")									//ROLE
	private String role = "";
	
	@Column(name = "CLAIM_REFERENCE_1")						//CLAIM_REFERENCE_1
	private String claimReference1 = "";
	
	@Column(name = "CLAIM_REFERENCE_2")						//CLAIM_REFERENCE_2
	private String claimReference2 = "";
	
	@Column(name = "LLOYDS_CATASTROPHE_CODE")				//LLOYDS_CATASTROPHE_CODE
	private String lloydsCatastropheCode = "";
	
	@Column(name = "PCS_CODE")								//PCS_CODE
	private String pcsCode = "";
	
	@Column(name = "COLLECTION_TYPE")						//COLLECTION_TYPE
	private String collectionType = "";
		
	@Column(name = "CREATEDBY")								//CREATEDBY
	private String createdby ="";
	
	@Column(name = "CREATEDDATE")							//CREATEDDATE
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone="Asia/Kolkata")
	private Timestamp createddate;
	
	@Column(name = "RESERVE_UPDATE_FLAG")					//RESERVE_UPDATE_FLAG
	private String reserveUpdateFlag  = "";
	
	@Column(name = "VERF_PAID_FLAG")						//VERF_PAID_FLAG
	private String verfPaidFlag  = "";
	
	@Column(name = "APPROVE_ENABLED")						//APPROVE_ENABLED
	private String approveEnabled  = "C";
	
	@Column(name = "REJECT_ENABLED")						//REJECT_ENABLED
	private String rejectEnabled  = "";
	
	@Column(name = "RELEASE_PAY_ENABLED")					//RELEASE_PAY_ENABLED
	private String releasePayEnabled  = "";
	
	@Column(name = "RESERVE_ENABLED")						//RESERVE_ENABLED
	private String reserveEnabled = "";
	
	@Column(name = "COLLECT_PAY_ENABLED")					//COLLECT_PAY_ENABLED
	private String collectPayEnabled  = "";
	
	@Column(name = "LIMIT_CURRENCY_CD")						//LIMIT_CURRENCY_CD
	private String limitCurrencyCode;
		
	@Transient
	@JsonInclude(Include.NON_NULL)
	private String approveUrl;								//Used in Notification and Workflow services
	
	@Transient
	@JsonInclude(Include.NON_NULL)
	private String rejectUrl;								//Used in Notification and Workflow services
	
	@Column(name = "DELETEFLAG")							//DELETE_FLAG
	private String deleteFlag  = "";

	@Transient
	@JsonInclude(Include.NON_NULL)
	private List<ElsecoClaimsInternalReference> claimsInternalRefInfo;  // List of Claims Internal Reference
	
	@Transient
	@JsonInclude(Include.NON_NULL)
	private ArrayList<ElsecoClaimsPayee> claimsPayeeInfo;   			// List of Claims Payee 

	/**
	 * @return the claimsTransactionId
	 */
	public int getClaimsTransactionId() {
		return claimsTransactionId;
	}

	/**
	 * @param claimsTransactionId the claimsTransactionId to set
	 */
	public void setClaimsTransactionId(int claimsTransactionId) {
		this.claimsTransactionId = claimsTransactionId;
	}

	/**
	 * @return the claimHeaderid
	 */
	public int getClaimHeaderid() {
		return claimHeaderid;
	}

	/**
	 * @param claimHeaderid the claimHeaderid to set
	 */
	public void setClaimHeaderid(int claimHeaderid) {
		this.claimHeaderid = claimHeaderid;
	}

	/**
	 * @return the claimid
	 */
	public int getClaimid() {
		return claimid;
	}

	/**
	 * @param claimid the claimid to set
	 */
	public void setClaimid(int claimid) {
		this.claimid = claimid;
	}

	/**
	 * @return the claimItemId
	 */
	public int getClaimItemId() {
		return claimItemId;
	}

	/**
	 * @param claimItemId the claimItemId to set
	 */
	public void setClaimItemId(int claimItemId) {
		this.claimItemId = claimItemId;
	}

	/**
	 * @return the applicationhandle
	 */
	public String getApplicationhandle() {
		return applicationhandle;
	}

	/**
	 * @param applicationhandle the applicationhandle to set
	 */
	public void setApplicationhandle(String applicationhandle) {
		this.applicationhandle = applicationhandle;
	}

	/**
	 * @return the modulehandle
	 */
	public String getModulehandle() {
		return modulehandle;
	}

	/**
	 * @param modulehandle the modulehandle to set
	 */
	public void setModulehandle(String modulehandle) {
		this.modulehandle = modulehandle;
	}

	/**
	 * @return the screenhandle
	 */
	public String getScreenhandle() {
		return screenhandle;
	}

	/**
	 * @param screenhandle the screenhandle to set
	 */
	public void setScreenhandle(String screenhandle) {
		this.screenhandle = screenhandle;
	}

	/**
	 * @return the umrNumber
	 */
	public String getUmrNumber() {
		return umrNumber;
	}

	/**
	 * @param umrNumber the umrNumber to set
	 */
	public void setUmrNumber(String umrNumber) {
		this.umrNumber = umrNumber;
	}

	/**
	 * @return the ucrNumber
	 */
	public String getUcrNumber() {
		return ucrNumber;
	}

	/**
	 * @param ucrNumber the ucrNumber to set
	 */
	public void setUcrNumber(String ucrNumber) {
		this.ucrNumber = ucrNumber;
	}

	/**
	 * @return the policyTransRefNo
	 */
	public String getPolicyTransRefNo() {
		return policyTransRefNo;
	}

	/**
	 * @param policyTransRefNo the policyTransRefNo to set
	 */
	public void setPolicyTransRefNo(String policyTransRefNo) {
		this.policyTransRefNo = policyTransRefNo;
	}

	/**
	 * @return the marketTransRefNo
	 */
	public String getMarketTransRefNo() {
		return marketTransRefNo;
	}

	/**
	 * @param marketTransRefNo the marketTransRefNo to set
	 */
	public void setMarketTransRefNo(String marketTransRefNo) {
		this.marketTransRefNo = marketTransRefNo;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionSubType
	 */
	public String getTransactionSubType() {
		return transactionSubType;
	}

	/**
	 * @param transactionSubType the transactionSubType to set
	 */
	public void setTransactionSubType(String transactionSubType) {
		this.transactionSubType = transactionSubType;
	}

	/**
	 * @return the transDescription
	 */
	public String getTransDescription() {
		return transDescription;
	}

	/**
	 * @param transDescription the transDescription to set
	 */
	public void setTransDescription(String transDescription) {
		this.transDescription = transDescription;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the outStndclamt
	 */
	public BigDecimal getOutStndclamt() {
		return outStndclamt;
	}

	/**
	 * @param outStndclamt the outStndclamt to set
	 */
	public void setOutStndclamt(BigDecimal outStndclamt) {
		this.outStndclamt = outStndclamt;
	}

	/**
	 * @return the nwincurdclamt
	 */
	public BigDecimal getNwincurdclamt() {
		return nwincurdclamt;
	}

	/**
	 * @param nwincurdclamt the nwincurdclamt to set
	 */
	public void setNwincurdclamt(BigDecimal nwincurdclamt) {
		this.nwincurdclamt = nwincurdclamt;
	}

	/**
	 * @return the prevpaidAmtIndemnityTR
	 */
	public BigDecimal getPrevpaidAmtIndemnityTR() {
		return prevpaidAmtIndemnityTR;
	}

	/**
	 * @param prevpaidAmtIndemnityTR the prevpaidAmtIndemnityTR to set
	 */
	public void setPrevpaidAmtIndemnityTR(BigDecimal prevpaidAmtIndemnityTR) {
		this.prevpaidAmtIndemnityTR = prevpaidAmtIndemnityTR;
	}

	/**
	 * @return the prevpaidAmtFeesTR
	 */
	public BigDecimal getPrevpaidAmtFeesTR() {
		return prevpaidAmtFeesTR;
	}

	/**
	 * @param prevpaidAmtFeesTR the prevpaidAmtFeesTR to set
	 */
	public void setPrevpaidAmtFeesTR(BigDecimal prevpaidAmtFeesTR) {
		this.prevpaidAmtFeesTR = prevpaidAmtFeesTR;
	}

	/**
	 * @return the prevpaidAmtExpensesTR
	 */
	public BigDecimal getPrevpaidAmtExpensesTR() {
		return prevpaidAmtExpensesTR;
	}

	/**
	 * @param prevpaidAmtExpensesTR the prevpaidAmtExpensesTR to set
	 */
	public void setPrevpaidAmtExpensesTR(BigDecimal prevpaidAmtExpensesTR) {
		this.prevpaidAmtExpensesTR = prevpaidAmtExpensesTR;
	}

	/**
	 * @return the settlementAmtIndemnityTR
	 */
	public BigDecimal getSettlementAmtIndemnityTR() {
		return settlementAmtIndemnityTR;
	}

	/**
	 * @param settlementAmtIndemnityTR the settlementAmtIndemnityTR to set
	 */
	public void setSettlementAmtIndemnityTR(BigDecimal settlementAmtIndemnityTR) {
		this.settlementAmtIndemnityTR = settlementAmtIndemnityTR;
	}

	/**
	 * @return the settlementAmtFeesTR
	 */
	public BigDecimal getSettlementAmtFeesTR() {
		return settlementAmtFeesTR;
	}

	/**
	 * @param settlementAmtFeesTR the settlementAmtFeesTR to set
	 */
	public void setSettlementAmtFeesTR(BigDecimal settlementAmtFeesTR) {
		this.settlementAmtFeesTR = settlementAmtFeesTR;
	}

	/**
	 * @return the settlementAmtExpensesTR
	 */
	public BigDecimal getSettlementAmtExpensesTR() {
		return settlementAmtExpensesTR;
	}

	/**
	 * @param settlementAmtExpensesTR the settlementAmtExpensesTR to set
	 */
	public void setSettlementAmtExpensesTR(BigDecimal settlementAmtExpensesTR) {
		this.settlementAmtExpensesTR = settlementAmtExpensesTR;
	}

	/**
	 * @return the reserveAmountIndemnityTR
	 */
	public BigDecimal getReserveAmountIndemnityTR() {
		return reserveAmountIndemnityTR;
	}

	/**
	 * @param reserveAmountIndemnityTR the reserveAmountIndemnityTR to set
	 */
	public void setReserveAmountIndemnityTR(BigDecimal reserveAmountIndemnityTR) {
		this.reserveAmountIndemnityTR = reserveAmountIndemnityTR;
	}

	/**
	 * @return the reserveAmountFeesTR
	 */
	public BigDecimal getReserveAmountFeesTR() {
		return reserveAmountFeesTR;
	}

	/**
	 * @param reserveAmountFeesTR the reserveAmountFeesTR to set
	 */
	public void setReserveAmountFeesTR(BigDecimal reserveAmountFeesTR) {
		this.reserveAmountFeesTR = reserveAmountFeesTR;
	}

	/**
	 * @return the reserveAmountExpensesTR
	 */
	public BigDecimal getReserveAmountExpensesTR() {
		return reserveAmountExpensesTR;
	}

	/**
	 * @param reserveAmountExpensesTR the reserveAmountExpensesTR to set
	 */
	public void setReserveAmountExpensesTR(BigDecimal reserveAmountExpensesTR) {
		this.reserveAmountExpensesTR = reserveAmountExpensesTR;
	}	

	/**
	 * @return the originalCurrency
	 */
	public String getOriginalCurrency() {
		return originalCurrency;
	}

	/**
	 * @param originalCurrency the originalCurrency to set
	 */
	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}

	/**
	 * @return the transactionCurrency
	 */
	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	/**
	 * @param transactionCurrency the transactionCurrency to set
	 */
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	/**
	 * @return the rateOfExchange
	 */
	public String getRateOfExchange() {
		return rateOfExchange;
	}

	/**
	 * @param rateOfExchange the rateOfExchange to set
	 */
	public void setRateOfExchange(String rateOfExchange) {
		this.rateOfExchange = rateOfExchange;
	}

	/**
	 * @return the originalAmount
	 */
	public String getOriginalAmount() {
		return originalAmount;
	}

	/**
	 * @param originalAmount the originalAmount to set
	 */
	public void setOriginalAmount(String originalAmount) {
		this.originalAmount = originalAmount;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the incomingPayment
	 */
	public String getIncomingPayment() {
		return incomingPayment;
	}

	/**
	 * @param incomingPayment the incomingPayment to set
	 */
	public void setIncomingPayment(String incomingPayment) {
		this.incomingPayment = incomingPayment;
	}

	/**
	 * @return the outgoingPayment
	 */
	public String getOutgoingPayment() {
		return outgoingPayment;
	}

	/**
	 * @param outgoingPayment the outgoingPayment to set
	 */
	public void setOutgoingPayment(String outgoingPayment) {
		this.outgoingPayment = outgoingPayment;
	}

	/**
	 * @return the splitClaimPercVl
	 */
	public String getSplitClaimPercVl() {
		return splitClaimPercVl;
	}

	/**
	 * @param splitClaimPercVl the splitClaimPercVl to set
	 */
	public void setSplitClaimPercVl(String splitClaimPercVl) {
		this.splitClaimPercVl = splitClaimPercVl;
	}

	/**
	 * @return the splitClaimPercAmt
	 */
	public BigDecimal getSplitClaimPercAmt() {
		return splitClaimPercAmt;
	}

	/**
	 * @param splitClaimPercAmt the splitClaimPercAmt to set
	 */
	public void setSplitClaimPercAmt(BigDecimal splitClaimPercAmt) {
		this.splitClaimPercAmt = splitClaimPercAmt;
	}

	/**
	 * @return the internalStatus
	 */
	public String getInternalStatus() {
		return internalStatus;
	}

	/**
	 * @param internalStatus the internalStatus to set
	 */
	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}

	/**
	 * @return the externalStatus
	 */
	public String getExternalStatus() {
		return externalStatus;
	}

	/**
	 * @param externalStatus the externalStatus to set
	 */
	public void setExternalStatus(String externalStatus) {
		this.externalStatus = externalStatus;
	}

	/**
	 * @return the nextStatus
	 */
	public String getNextStatus() {
		return nextStatus;
	}

	/**
	 * @param nextStatus the nextStatus to set
	 */
	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the extrnlid
	 */
	public int getExtrnlid() {
		return extrnlid;
	}

	/**
	 * @param extrnlid the extrnlid to set
	 */
	public void setExtrnlid(int extrnlid) {
		this.extrnlid = extrnlid;
	}

	/**
	 * @return the partyId
	 */
	public int getPartyId() {
		return partyId;
	}

	/**
	 * @param partyId the partyId to set
	 */
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * @return the partyBpId
	 */
	public int getPartyBpId() {
		return partyBpId;
	}

	/**
	 * @param partyBpId the partyBpId to set
	 */
	public void setPartyBpId(int partyBpId) {
		this.partyBpId = partyBpId;
	}

	/**
	 * @return the printSortCode
	 */
	public String getPrintSortCode() {
		return printSortCode;
	}

	/**
	 * @param printSortCode the printSortCode to set
	 */
	public void setPrintSortCode(String printSortCode) {
		this.printSortCode = printSortCode;
	}

	/**
	 * @return the ecfIndicator
	 */
	public String getEcfIndicator() {
		return ecfIndicator;
	}

	/**
	 * @param ecfIndicator the ecfIndicator to set
	 */
	public void setEcfIndicator(String ecfIndicator) {
		this.ecfIndicator = ecfIndicator;
	}

	/**
	 * @return the carrierCode
	 */
	public String getCarrierCode() {
		return carrierCode;
	}

	/**
	 * @param carrierCode the carrierCode to set
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	/**
	 * @return the carrierPercentage
	 */
	public String getCarrierPercentage() {
		return carrierPercentage;
	}

	/**
	 * @param carrierPercentage the carrierPercentage to set
	 */
	public void setCarrierPercentage(String carrierPercentage) {
		this.carrierPercentage = carrierPercentage;
	}

	/**
	 * @return the carrierReference
	 */
	public String getCarrierReference() {
		return carrierReference;
	}

	/**
	 * @param carrierReference the carrierReference to set
	 */
	public void setCarrierReference(String carrierReference) {
		this.carrierReference = carrierReference;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the claimReference1
	 */
	public String getClaimReference1() {
		return claimReference1;
	}

	/**
	 * @param claimReference1 the claimReference1 to set
	 */
	public void setClaimReference1(String claimReference1) {
		this.claimReference1 = claimReference1;
	}

	/**
	 * @return the claimReference2
	 */
	public String getClaimReference2() {
		return claimReference2;
	}

	/**
	 * @param claimReference2 the claimReference2 to set
	 */
	public void setClaimReference2(String claimReference2) {
		this.claimReference2 = claimReference2;
	}

	/**
	 * @return the lloydsCatastropheCode
	 */
	public String getLloydsCatastropheCode() {
		return lloydsCatastropheCode;
	}

	/**
	 * @param lloydsCatastropheCode the lloydsCatastropheCode to set
	 */
	public void setLloydsCatastropheCode(String lloydsCatastropheCode) {
		this.lloydsCatastropheCode = lloydsCatastropheCode;
	}

	/**
	 * @return the pcsCode
	 */
	public String getPcsCode() {
		return pcsCode;
	}

	/**
	 * @param pcsCode the pcsCode to set
	 */
	public void setPcsCode(String pcsCode) {
		this.pcsCode = pcsCode;
	}

	/**
	 * @return the collectionType
	 */
	public String getCollectionType() {
		return collectionType;
	}

	/**
	 * @param collectionType the collectionType to set
	 */
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	/**
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}

	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	/**
	 * @return the createddate
	 */
	public Timestamp getCreateddate() {		
		return createddate;
	}

	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(Timestamp createddate) {		
		this.createddate = createddate;
	}

	/**
	 * @return the reserveUpdateFlag
	 */
	public String getReserveUpdateFlag() {
		return reserveUpdateFlag;
	}

	/**
	 * @param reserveUpdateFlag the reserveUpdateFlag to set
	 */
	public void setReserveUpdateFlag(String reserveUpdateFlag) {
		this.reserveUpdateFlag = reserveUpdateFlag;
	}

	/**
	 * @return the verfPaidFlag
	 */
	public String getVerfPaidFlag() {
		return verfPaidFlag;
	}

	/**
	 * @param verfPaidFlag the verfPaidFlag to set
	 */
	public void setVerfPaidFlag(String verfPaidFlag) {
		this.verfPaidFlag = verfPaidFlag;
	}

	/**
	 * @return the approveUrl
	 */
	public String getApproveUrl() {
		return approveUrl;
	}

	/**
	 * @param approveUrl the approveUrl to set
	 */
	public void setApproveUrl(String approveUrl) {
		this.approveUrl = approveUrl;
	}

	/**
	 * @return the rejectUrl
	 */
	public String getRejectUrl() {
		return rejectUrl;
	}

	/**
	 * @param rejectUrl the rejectUrl to set
	 */
	public void setRejectUrl(String rejectUrl) {
		this.rejectUrl = rejectUrl;
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

	/**
	 * @return the approveEnabled
	 */
	public String getApproveEnabled() {
		return approveEnabled;
	}

	/**
	 * @param approveEnabled the approveEnabled to set
	 */
	public void setApproveEnabled(String approveEnabled) {
		this.approveEnabled = approveEnabled;
	}

	/**
	 * @return the rejectEnabled
	 */
	public String getRejectEnabled() {
		return rejectEnabled;
	}

	/**
	 * @param rejectEnabled the rejectEnabled to set
	 */
	public void setRejectEnabled(String rejectEnabled) {
		this.rejectEnabled = rejectEnabled;
	}

	/**
	 * @return the releasePayEnabled
	 */
	public String getReleasePayEnabled() {
		return releasePayEnabled;
	}

	/**
	 * @param releasePayEnabled the releasePayEnabled to set
	 */
	public void setReleasePayEnabled(String releasePayEnabled) {
		this.releasePayEnabled = releasePayEnabled;
	}

	/**
	 * @return the reserveEnabled
	 */
	public String getReserveEnabled() {
		return reserveEnabled;
	}

	/**
	 * @param reserveEnabled the reserveEnabled to set
	 */
	public void setReserveEnabled(String reserveEnabled) {
		this.reserveEnabled = reserveEnabled;
	}

	/**
	 * @return the collectPayEnabled
	 */
	public String getCollectPayEnabled() {
		return collectPayEnabled;
	}

	/**
	 * @param collectPayEnabled the collectPayEnabled to set
	 */
	public void setCollectPayEnabled(String collectPayEnabled) {
		this.collectPayEnabled = collectPayEnabled;
	}

	/**
	 * @return the claimsInternalRefInfo
	 */
	public List<ElsecoClaimsInternalReference> getClaimsInternalRefInfo() {
		return claimsInternalRefInfo;
	}

	/**
	 * @param claimsInternalRefInfo the claimsInternalRefInfo to set
	 */
	public void setClaimsInternalRefInfo(List<ElsecoClaimsInternalReference> claimsInternalRefInfo) {
		this.claimsInternalRefInfo = claimsInternalRefInfo;
	}

	/**
	 * @return the transactionRecordType
	 */
	public String getTransactionRecordType() {
		return transactionRecordType;
	}

	/**
	 * @param transactionRecordType the transactionRecordType to set
	 */
	public void setTransactionRecordType(String transactionRecordType) {
		this.transactionRecordType = transactionRecordType;
	}

	/**
	 * @return the limitCurrencyCode
	 */
	public String getLimitCurrencyCode() {
		return limitCurrencyCode;
	}

	/**
	 * @param limitCurrencyCode the limitCurrencyCode to set
	 */
	public void setLimitCurrencyCode(String limitCurrencyCode) {
		this.limitCurrencyCode = limitCurrencyCode;
	}

	/**
	 * @return the claimsPayeeInfo
	 */
	public ArrayList<ElsecoClaimsPayee> getClaimsPayeeInfo() {
		return claimsPayeeInfo;
	}

	/**
	 * @param claimsPayeeInfo the claimsPayeeInfo to set
	 */
	public void setClaimsPayeeInfo(ArrayList<ElsecoClaimsPayee> claimsPayeeInfo) {
		this.claimsPayeeInfo = claimsPayeeInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsTransaction [claimsTransactionId=" + claimsTransactionId + ", claimHeaderid="
				+ claimHeaderid + ", claimid=" + claimid + ", claimItemId=" + claimItemId + ", "
				+ (applicationhandle != null ? "applicationhandle=" + applicationhandle + ", " : "")
				+ (modulehandle != null ? "modulehandle=" + modulehandle + ", " : "")
				+ (screenhandle != null ? "screenhandle=" + screenhandle + ", " : "")
				+ (umrNumber != null ? "umrNumber=" + umrNumber + ", " : "")
				+ (ucrNumber != null ? "ucrNumber=" + ucrNumber + ", " : "")
				+ (policyTransRefNo != null ? "policyTransRefNo=" + policyTransRefNo + ", " : "")
				+ (marketTransRefNo != null ? "marketTransRefNo=" + marketTransRefNo + ", " : "")
				+ (transactionRecordType != null ? "transactionRecordType=" + transactionRecordType + ", " : "")
				+ (transactionType != null ? "transactionType=" + transactionType + ", " : "")
				+ (transactionSubType != null ? "transactionSubType=" + transactionSubType + ", " : "")
				+ (transDescription != null ? "transDescription=" + transDescription + ", " : "")
				+ (comment != null ? "comment=" + comment + ", " : "")
				+ (outStndclamt != null ? "outStndclamt=" + outStndclamt + ", " : "")
				+ (nwincurdclamt != null ? "nwincurdclamt=" + nwincurdclamt + ", " : "")
				+ (prevpaidAmtIndemnityTR != null ? "prevpaidAmtIndemnityTR=" + prevpaidAmtIndemnityTR + ", " : "")
				+ (prevpaidAmtFeesTR != null ? "prevpaidAmtFeesTR=" + prevpaidAmtFeesTR + ", " : "")
				+ (prevpaidAmtExpensesTR != null ? "prevpaidAmtExpensesTR=" + prevpaidAmtExpensesTR + ", " : "")
				+ (settlementAmtIndemnityTR != null ? "settlementAmtIndemnityTR=" + settlementAmtIndemnityTR + ", "
						: "")
				+ (settlementAmtFeesTR != null ? "settlementAmtFeesTR=" + settlementAmtFeesTR + ", " : "")
				+ (settlementAmtExpensesTR != null ? "settlementAmtExpensesTR=" + settlementAmtExpensesTR + ", " : "")
				+ (reserveAmountIndemnityTR != null ? "reserveAmountIndemnityTR=" + reserveAmountIndemnityTR + ", "
						: "")
				+ (reserveAmountFeesTR != null ? "reserveAmountFeesTR=" + reserveAmountFeesTR + ", " : "")
				+ (reserveAmountExpensesTR != null ? "reserveAmountExpensesTR=" + reserveAmountExpensesTR + ", " : "")
				+ (originalCurrency != null ? "originalCurrency=" + originalCurrency + ", " : "")
				+ (transactionCurrency != null ? "transactionCurrency=" + transactionCurrency + ", " : "")
				+ (rateOfExchange != null ? "rateOfExchange=" + rateOfExchange + ", " : "")
				+ (originalAmount != null ? "originalAmount=" + originalAmount + ", " : "")
				+ (dueDate != null ? "dueDate=" + dueDate + ", " : "")
				+ (incomingPayment != null ? "incomingPayment=" + incomingPayment + ", " : "")
				+ (outgoingPayment != null ? "outgoingPayment=" + outgoingPayment + ", " : "")
				+ (splitClaimPercVl != null ? "splitClaimPercVl=" + splitClaimPercVl + ", " : "")
				+ (splitClaimPercAmt != null ? "splitClaimPercAmt=" + splitClaimPercAmt + ", " : "")
				+ (internalStatus != null ? "internalStatus=" + internalStatus + ", " : "")
				+ (externalStatus != null ? "externalStatus=" + externalStatus + ", " : "")
				+ (nextStatus != null ? "nextStatus=" + nextStatus + ", " : "")
				+ (author != null ? "author=" + author + ", " : "") + "extrnlid=" + extrnlid + ", partyId=" + partyId
				+ ", " + (partyName != null ? "partyName=" + partyName + ", " : "") + "partyBpId=" + partyBpId + ", "
				+ (printSortCode != null ? "printSortCode=" + printSortCode + ", " : "")
				+ (ecfIndicator != null ? "ecfIndicator=" + ecfIndicator + ", " : "")
				+ (carrierCode != null ? "carrierCode=" + carrierCode + ", " : "")
				+ (carrierPercentage != null ? "carrierPercentage=" + carrierPercentage + ", " : "")
				+ (carrierReference != null ? "carrierReference=" + carrierReference + ", " : "")
				+ (role != null ? "role=" + role + ", " : "")
				+ (claimReference1 != null ? "claimReference1=" + claimReference1 + ", " : "")
				+ (claimReference2 != null ? "claimReference2=" + claimReference2 + ", " : "")
				+ (lloydsCatastropheCode != null ? "lloydsCatastropheCode=" + lloydsCatastropheCode + ", " : "")
				+ (pcsCode != null ? "pcsCode=" + pcsCode + ", " : "")
				+ (collectionType != null ? "collectionType=" + collectionType + ", " : "")
				+ (createdby != null ? "createdby=" + createdby + ", " : "")
				+ (createddate != null ? "createddate=" + createddate + ", " : "")
				+ (reserveUpdateFlag != null ? "reserveUpdateFlag=" + reserveUpdateFlag + ", " : "")
				+ (verfPaidFlag != null ? "verfPaidFlag=" + verfPaidFlag + ", " : "")
				+ (approveEnabled != null ? "approveEnabled=" + approveEnabled + ", " : "")
				+ (rejectEnabled != null ? "rejectEnabled=" + rejectEnabled + ", " : "")
				+ (releasePayEnabled != null ? "releasePayEnabled=" + releasePayEnabled + ", " : "")
				+ (reserveEnabled != null ? "reserveEnabled=" + reserveEnabled + ", " : "")
				+ (collectPayEnabled != null ? "collectPayEnabled=" + collectPayEnabled + ", " : "")
				+ (limitCurrencyCode != null ? "limitCurrencyCode=" + limitCurrencyCode + ", " : "")
				+ (approveUrl != null ? "approveUrl=" + approveUrl + ", " : "")
				+ (rejectUrl != null ? "rejectUrl=" + rejectUrl + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag + ", " : "")
				+ (claimsInternalRefInfo != null ? "claimsInternalRefInfo=" + claimsInternalRefInfo + ", " : "")
				+ (claimsPayeeInfo != null ? "claimsPayeeInfo=" + claimsPayeeInfo : "") + "]";
	}	
} 

	

	
	
	
	