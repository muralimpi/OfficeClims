
package com.elseco.nyms.model.claim;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "claimsTransactionId",
    "claimHeaderid",
    "claimid",
    "claimItemId",
    "applicationhandle",
    "modulehandle",
    "screenhandle",
    "umrNumber",
    "ucrNumber",
    "policyTransRefNo",
    "marketTransRefNo",
    "transactionRecordType",
    "transactionType",
    "transactionSubType",
    "transDescription",
    "comment",
    "outStndclamt",
    "nwincurdclamt",
    "prevpaidAmtIndemnityTR",
    "prevpaidAmtFeesTR",
    "prevpaidAmtExpensesTR",
    "settlementAmtIndemnityTR",
    "settlementAmtFeesTR",
    "settlementAmtExpensesTR",
    "reserveAmountIndemnityTR",
    "reserveAmountFeesTR",
    "reserveAmountExpensesTR",
    "originalCurrency",
    "transactionCurrency",
    "rateOfExchange",
    "originalAmount",
    "dueDate",
    "incomingPayment",
    "outgoingPayment",
    "splitClaimPercVl",
    "splitClaimPercAmt",
    "internalStatus",
    "externalStatus",
    "nextStatus",
    "author",
    "extrnlid",
    "partyId",
    "partyName",
    "partyBpId",
    "printSortCode",
    "ecfIndicator",
    "carrierCode",
    "carrierPercentage",
    "carrierReference",
    "role",
    "claimReference1",
    "claimReference2",
    "lloydsCatastropheCode",
    "pcsCode",
    "collectionType",
    "createdby",
    "createddate",
    "reserveUpdateFlag",
    "verfPaidFlag",
    "approveEnabled",
    "rejectEnabled",
    "releasePayEnabled",
    "reserveEnabled",
    "collectPayEnabled",
    "limitCurrencyCode",
    "approveUrl",
    "rejectUrl",
    "deleteFlag",
    "claimsInternalRefInfo",
    "claimsPayeeInfo"
})
public class PolicyTransactionsInfo {

    @JsonProperty("claimsTransactionId")
    private BigInteger claimsTransactionId;
    @JsonProperty("claimHeaderid")
    private BigInteger claimHeaderid;
    @JsonProperty("claimid")
    private BigInteger claimid;
    @JsonProperty("claimItemId")
    private BigInteger claimItemId;
    @JsonProperty("applicationhandle")
    private String applicationhandle;
    @JsonProperty("modulehandle")
    private String modulehandle;
    @JsonProperty("screenhandle")
    private String screenhandle;
    @JsonProperty("umrNumber")
    private String umrNumber;
    @JsonProperty("ucrNumber")
    private String ucrNumber;
    @JsonProperty("policyTransRefNo")
    private String policyTransRefNo;
    @JsonProperty("marketTransRefNo")
    private String marketTransRefNo;
    @JsonProperty("transactionRecordType")
    private String transactionRecordType;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("transactionSubType")
    private String transactionSubType;
    @JsonProperty("transDescription")
    private String transDescription;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("outStndclamt")
    private Object outStndclamt;
    @JsonProperty("nwincurdclamt")
    private BigInteger nwincurdclamt;
    @JsonProperty("prevpaidAmtIndemnityTR")
    private BigInteger prevpaidAmtIndemnityTR;
    @JsonProperty("prevpaidAmtFeesTR")
    private BigInteger prevpaidAmtFeesTR;
    @JsonProperty("prevpaidAmtExpensesTR")
    private BigInteger prevpaidAmtExpensesTR;
    @JsonProperty("settlementAmtIndemnityTR")
    private BigInteger settlementAmtIndemnityTR;
    @JsonProperty("settlementAmtFeesTR")
    private BigInteger settlementAmtFeesTR;
    @JsonProperty("settlementAmtExpensesTR")
    private BigInteger settlementAmtExpensesTR;
    @JsonProperty("reserveAmountIndemnityTR")
    private BigInteger reserveAmountIndemnityTR;
    @JsonProperty("reserveAmountFeesTR")
    private BigInteger reserveAmountFeesTR;
    @JsonProperty("reserveAmountExpensesTR")
    private BigInteger reserveAmountExpensesTR;
    @JsonProperty("originalCurrency")
    private String originalCurrency;
    @JsonProperty("transactionCurrency")
    private String transactionCurrency;
    @JsonProperty("rateOfExchange")
    private String rateOfExchange;
    @JsonProperty("originalAmount")
    private String originalAmount;
    @JsonProperty("dueDate")
    private String dueDate;
    @JsonProperty("incomingPayment")
    private String incomingPayment;
    @JsonProperty("outgoingPayment")
    private String outgoingPayment;
    @JsonProperty("splitClaimPercVl")
    private String splitClaimPercVl;
    @JsonProperty("splitClaimPercAmt")
    private Object splitClaimPercAmt;
    @JsonProperty("internalStatus")
    private String internalStatus;
    @JsonProperty("externalStatus")
    private String externalStatus;
    @JsonProperty("nextStatus")
    private String nextStatus;
    @JsonProperty("author")
    private String author;
    @JsonProperty("extrnlid")
    private BigInteger extrnlid;
    @JsonProperty("partyId")
    private BigInteger partyId;
    @JsonProperty("partyName")
    private Object partyName;
    @JsonProperty("partyBpId")
    private BigInteger partyBpId;
    @JsonProperty("printSortCode")
    private String printSortCode;
    @JsonProperty("ecfIndicator")
    private String ecfIndicator;
    @JsonProperty("carrierCode")
    private String carrierCode;
    @JsonProperty("carrierPercentage")
    private String carrierPercentage;
    @JsonProperty("carrierReference")
    private String carrierReference;
    @JsonProperty("role")
    private String role;
    @JsonProperty("claimReference1")
    private String claimReference1;
    @JsonProperty("claimReference2")
    private String claimReference2;
    @JsonProperty("lloydsCatastropheCode")
    private String lloydsCatastropheCode;
    @JsonProperty("pcsCode")
    private String pcsCode;
    @JsonProperty("collectionType")
    private String collectionType;
    @JsonProperty("createdby")
    private String createdby;
    @JsonProperty("createddate")
    private String createddate;
    @JsonProperty("reserveUpdateFlag")
    private String reserveUpdateFlag;
    @JsonProperty("verfPaidFlag")
    private String verfPaidFlag;
    @JsonProperty("approveEnabled")
    private String approveEnabled;
    @JsonProperty("rejectEnabled")
    private String rejectEnabled;
    @JsonProperty("releasePayEnabled")
    private String releasePayEnabled;
    @JsonProperty("reserveEnabled")
    private String reserveEnabled;
    @JsonProperty("collectPayEnabled")
    private String collectPayEnabled;
    @JsonProperty("limitCurrencyCode")
    private String limitCurrencyCode;
    @JsonProperty("approveUrl")
    private String approveUrl;
    @JsonProperty("rejectUrl")
    private String rejectUrl;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("claimsInternalRefInfo")
    private List<ClaimsInternalRefInfo> claimsInternalRefInfo = new ArrayList<ClaimsInternalRefInfo>();
    @JsonProperty("claimsPayeeInfo")
    private List<Object> claimsPayeeInfo = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("claimsTransactionId")
    public BigInteger getClaimsTransactionId() {
        return claimsTransactionId;
    }

    @JsonProperty("claimsTransactionId")
    public void setClaimsTransactionId(BigInteger claimsTransactionId) {
        this.claimsTransactionId = claimsTransactionId;
    }

    public PolicyTransactionsInfo withClaimsTransactionId(BigInteger claimsTransactionId) {
        this.claimsTransactionId = claimsTransactionId;
        return this;
    }

    @JsonProperty("claimHeaderid")
    public BigInteger getClaimHeaderid() {
        return claimHeaderid;
    }

    @JsonProperty("claimHeaderid")
    public void setClaimHeaderid(BigInteger claimHeaderid) {
        this.claimHeaderid = claimHeaderid;
    }

    public PolicyTransactionsInfo withClaimHeaderid(BigInteger claimHeaderid) {
        this.claimHeaderid = claimHeaderid;
        return this;
    }

    @JsonProperty("claimid")
    public BigInteger getClaimid() {
        return claimid;
    }

    @JsonProperty("claimid")
    public void setClaimid(BigInteger claimid) {
        this.claimid = claimid;
    }

    public PolicyTransactionsInfo withClaimid(BigInteger claimid) {
        this.claimid = claimid;
        return this;
    }

    @JsonProperty("claimItemId")
    public BigInteger getClaimItemId() {
        return claimItemId;
    }

    @JsonProperty("claimItemId")
    public void setClaimItemId(BigInteger claimItemId) {
        this.claimItemId = claimItemId;
    }

    public PolicyTransactionsInfo withClaimItemId(BigInteger claimItemId) {
        this.claimItemId = claimItemId;
        return this;
    }

    @JsonProperty("applicationhandle")
    public String getApplicationhandle() {
        return applicationhandle;
    }

    @JsonProperty("applicationhandle")
    public void setApplicationhandle(String applicationhandle) {
        this.applicationhandle = applicationhandle;
    }

    public PolicyTransactionsInfo withApplicationhandle(String applicationhandle) {
        this.applicationhandle = applicationhandle;
        return this;
    }

    @JsonProperty("modulehandle")
    public String getModulehandle() {
        return modulehandle;
    }

    @JsonProperty("modulehandle")
    public void setModulehandle(String modulehandle) {
        this.modulehandle = modulehandle;
    }

    public PolicyTransactionsInfo withModulehandle(String modulehandle) {
        this.modulehandle = modulehandle;
        return this;
    }

    @JsonProperty("screenhandle")
    public String getScreenhandle() {
        return screenhandle;
    }

    @JsonProperty("screenhandle")
    public void setScreenhandle(String screenhandle) {
        this.screenhandle = screenhandle;
    }

    public PolicyTransactionsInfo withScreenhandle(String screenhandle) {
        this.screenhandle = screenhandle;
        return this;
    }

    @JsonProperty("umrNumber")
    public String getUmrNumber() {
        return umrNumber;
    }

    @JsonProperty("umrNumber")
    public void setUmrNumber(String umrNumber) {
        this.umrNumber = umrNumber;
    }

    public PolicyTransactionsInfo withUmrNumber(String umrNumber) {
        this.umrNumber = umrNumber;
        return this;
    }

    @JsonProperty("ucrNumber")
    public String getUcrNumber() {
        return ucrNumber;
    }

    @JsonProperty("ucrNumber")
    public void setUcrNumber(String ucrNumber) {
        this.ucrNumber = ucrNumber;
    }

    public PolicyTransactionsInfo withUcrNumber(String ucrNumber) {
        this.ucrNumber = ucrNumber;
        return this;
    }

    @JsonProperty("policyTransRefNo")
    public String getPolicyTransRefNo() {
        return policyTransRefNo;
    }

    @JsonProperty("policyTransRefNo")
    public void setPolicyTransRefNo(String policyTransRefNo) {
        this.policyTransRefNo = policyTransRefNo;
    }

    public PolicyTransactionsInfo withPolicyTransRefNo(String policyTransRefNo) {
        this.policyTransRefNo = policyTransRefNo;
        return this;
    }

    @JsonProperty("marketTransRefNo")
    public String getMarketTransRefNo() {
        return marketTransRefNo;
    }

    @JsonProperty("marketTransRefNo")
    public void setMarketTransRefNo(String marketTransRefNo) {
        this.marketTransRefNo = marketTransRefNo;
    }

    public PolicyTransactionsInfo withMarketTransRefNo(String marketTransRefNo) {
        this.marketTransRefNo = marketTransRefNo;
        return this;
    }

    @JsonProperty("transactionRecordType")
    public String getTransactionRecordType() {
        return transactionRecordType;
    }

    @JsonProperty("transactionRecordType")
    public void setTransactionRecordType(String transactionRecordType) {
        this.transactionRecordType = transactionRecordType;
    }

    public PolicyTransactionsInfo withTransactionRecordType(String transactionRecordType) {
        this.transactionRecordType = transactionRecordType;
        return this;
    }

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public PolicyTransactionsInfo withTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    @JsonProperty("transactionSubType")
    public String getTransactionSubType() {
        return transactionSubType;
    }

    @JsonProperty("transactionSubType")
    public void setTransactionSubType(String transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    public PolicyTransactionsInfo withTransactionSubType(String transactionSubType) {
        this.transactionSubType = transactionSubType;
        return this;
    }

    @JsonProperty("transDescription")
    public String getTransDescription() {
        return transDescription;
    }

    @JsonProperty("transDescription")
    public void setTransDescription(String transDescription) {
        this.transDescription = transDescription;
    }

    public PolicyTransactionsInfo withTransDescription(String transDescription) {
        this.transDescription = transDescription;
        return this;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    public PolicyTransactionsInfo withComment(String comment) {
        this.comment = comment;
        return this;
    }

    @JsonProperty("outStndclamt")
    public Object getOutStndclamt() {
        return outStndclamt;
    }

    @JsonProperty("outStndclamt")
    public void setOutStndclamt(Object outStndclamt) {
        this.outStndclamt = outStndclamt;
    }

    public PolicyTransactionsInfo withOutStndclamt(Object outStndclamt) {
        this.outStndclamt = outStndclamt;
        return this;
    }

    @JsonProperty("nwincurdclamt")
    public BigInteger getNwincurdclamt() {
        return nwincurdclamt;
    }

    @JsonProperty("nwincurdclamt")
    public void setNwincurdclamt(BigInteger nwincurdclamt) {
        this.nwincurdclamt = nwincurdclamt;
    }

    public PolicyTransactionsInfo withNwincurdclamt(BigInteger nwincurdclamt) {
        this.nwincurdclamt = nwincurdclamt;
        return this;
    }

    @JsonProperty("prevpaidAmtIndemnityTR")
    public BigInteger getPrevpaidAmtIndemnityTR() {
        return prevpaidAmtIndemnityTR;
    }

    @JsonProperty("prevpaidAmtIndemnityTR")
    public void setPrevpaidAmtIndemnityTR(BigInteger prevpaidAmtIndemnityTR) {
        this.prevpaidAmtIndemnityTR = prevpaidAmtIndemnityTR;
    }

    public PolicyTransactionsInfo withPrevpaidAmtIndemnityTR(BigInteger prevpaidAmtIndemnityTR) {
        this.prevpaidAmtIndemnityTR = prevpaidAmtIndemnityTR;
        return this;
    }

    @JsonProperty("prevpaidAmtFeesTR")
    public BigInteger getPrevpaidAmtFeesTR() {
        return prevpaidAmtFeesTR;
    }

    @JsonProperty("prevpaidAmtFeesTR")
    public void setPrevpaidAmtFeesTR(BigInteger prevpaidAmtFeesTR) {
        this.prevpaidAmtFeesTR = prevpaidAmtFeesTR;
    }

    public PolicyTransactionsInfo withPrevpaidAmtFeesTR(BigInteger prevpaidAmtFeesTR) {
        this.prevpaidAmtFeesTR = prevpaidAmtFeesTR;
        return this;
    }

    @JsonProperty("prevpaidAmtExpensesTR")
    public BigInteger getPrevpaidAmtExpensesTR() {
        return prevpaidAmtExpensesTR;
    }

    @JsonProperty("prevpaidAmtExpensesTR")
    public void setPrevpaidAmtExpensesTR(BigInteger prevpaidAmtExpensesTR) {
        this.prevpaidAmtExpensesTR = prevpaidAmtExpensesTR;
    }

    public PolicyTransactionsInfo withPrevpaidAmtExpensesTR(BigInteger prevpaidAmtExpensesTR) {
        this.prevpaidAmtExpensesTR = prevpaidAmtExpensesTR;
        return this;
    }

    @JsonProperty("settlementAmtIndemnityTR")
    public BigInteger getSettlementAmtIndemnityTR() {
        return settlementAmtIndemnityTR;
    }

    @JsonProperty("settlementAmtIndemnityTR")
    public void setSettlementAmtIndemnityTR(BigInteger settlementAmtIndemnityTR) {
        this.settlementAmtIndemnityTR = settlementAmtIndemnityTR;
    }

    public PolicyTransactionsInfo withSettlementAmtIndemnityTR(BigInteger settlementAmtIndemnityTR) {
        this.settlementAmtIndemnityTR = settlementAmtIndemnityTR;
        return this;
    }

    @JsonProperty("settlementAmtFeesTR")
    public BigInteger getSettlementAmtFeesTR() {
        return settlementAmtFeesTR;
    }

    @JsonProperty("settlementAmtFeesTR")
    public void setSettlementAmtFeesTR(BigInteger settlementAmtFeesTR) {
        this.settlementAmtFeesTR = settlementAmtFeesTR;
    }

    public PolicyTransactionsInfo withSettlementAmtFeesTR(BigInteger settlementAmtFeesTR) {
        this.settlementAmtFeesTR = settlementAmtFeesTR;
        return this;
    }

    @JsonProperty("settlementAmtExpensesTR")
    public BigInteger getSettlementAmtExpensesTR() {
        return settlementAmtExpensesTR;
    }

    @JsonProperty("settlementAmtExpensesTR")
    public void setSettlementAmtExpensesTR(BigInteger settlementAmtExpensesTR) {
        this.settlementAmtExpensesTR = settlementAmtExpensesTR;
    }

    public PolicyTransactionsInfo withSettlementAmtExpensesTR(BigInteger settlementAmtExpensesTR) {
        this.settlementAmtExpensesTR = settlementAmtExpensesTR;
        return this;
    }

    @JsonProperty("reserveAmountIndemnityTR")
    public BigInteger getReserveAmountIndemnityTR() {
        return reserveAmountIndemnityTR;
    }

    @JsonProperty("reserveAmountIndemnityTR")
    public void setReserveAmountIndemnityTR(BigInteger reserveAmountIndemnityTR) {
        this.reserveAmountIndemnityTR = reserveAmountIndemnityTR;
    }

    public PolicyTransactionsInfo withReserveAmountIndemnityTR(BigInteger reserveAmountIndemnityTR) {
        this.reserveAmountIndemnityTR = reserveAmountIndemnityTR;
        return this;
    }

    @JsonProperty("reserveAmountFeesTR")
    public BigInteger getReserveAmountFeesTR() {
        return reserveAmountFeesTR;
    }

    @JsonProperty("reserveAmountFeesTR")
    public void setReserveAmountFeesTR(BigInteger reserveAmountFeesTR) {
        this.reserveAmountFeesTR = reserveAmountFeesTR;
    }

    public PolicyTransactionsInfo withReserveAmountFeesTR(BigInteger reserveAmountFeesTR) {
        this.reserveAmountFeesTR = reserveAmountFeesTR;
        return this;
    }

    @JsonProperty("reserveAmountExpensesTR")
    public BigInteger getReserveAmountExpensesTR() {
        return reserveAmountExpensesTR;
    }

    @JsonProperty("reserveAmountExpensesTR")
    public void setReserveAmountExpensesTR(BigInteger reserveAmountExpensesTR) {
        this.reserveAmountExpensesTR = reserveAmountExpensesTR;
    }

    public PolicyTransactionsInfo withReserveAmountExpensesTR(BigInteger reserveAmountExpensesTR) {
        this.reserveAmountExpensesTR = reserveAmountExpensesTR;
        return this;
    }

    @JsonProperty("originalCurrency")
    public String getOriginalCurrency() {
        return originalCurrency;
    }

    @JsonProperty("originalCurrency")
    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public PolicyTransactionsInfo withOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
        return this;
    }

    @JsonProperty("transactionCurrency")
    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    @JsonProperty("transactionCurrency")
    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public PolicyTransactionsInfo withTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
        return this;
    }

    @JsonProperty("rateOfExchange")
    public String getRateOfExchange() {
        return rateOfExchange;
    }

    @JsonProperty("rateOfExchange")
    public void setRateOfExchange(String rateOfExchange) {
        this.rateOfExchange = rateOfExchange;
    }

    public PolicyTransactionsInfo withRateOfExchange(String rateOfExchange) {
        this.rateOfExchange = rateOfExchange;
        return this;
    }

    @JsonProperty("originalAmount")
    public String getOriginalAmount() {
        return originalAmount;
    }

    @JsonProperty("originalAmount")
    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public PolicyTransactionsInfo withOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
        return this;
    }

    @JsonProperty("dueDate")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("dueDate")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public PolicyTransactionsInfo withDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @JsonProperty("incomingPayment")
    public String getIncomingPayment() {
        return incomingPayment;
    }

    @JsonProperty("incomingPayment")
    public void setIncomingPayment(String incomingPayment) {
        this.incomingPayment = incomingPayment;
    }

    public PolicyTransactionsInfo withIncomingPayment(String incomingPayment) {
        this.incomingPayment = incomingPayment;
        return this;
    }

    @JsonProperty("outgoingPayment")
    public String getOutgoingPayment() {
        return outgoingPayment;
    }

    @JsonProperty("outgoingPayment")
    public void setOutgoingPayment(String outgoingPayment) {
        this.outgoingPayment = outgoingPayment;
    }

    public PolicyTransactionsInfo withOutgoingPayment(String outgoingPayment) {
        this.outgoingPayment = outgoingPayment;
        return this;
    }

    @JsonProperty("splitClaimPercVl")
    public String getSplitClaimPercVl() {
        return splitClaimPercVl;
    }

    @JsonProperty("splitClaimPercVl")
    public void setSplitClaimPercVl(String splitClaimPercVl) {
        this.splitClaimPercVl = splitClaimPercVl;
    }

    public PolicyTransactionsInfo withSplitClaimPercVl(String splitClaimPercVl) {
        this.splitClaimPercVl = splitClaimPercVl;
        return this;
    }

    @JsonProperty("splitClaimPercAmt")
    public Object getSplitClaimPercAmt() {
        return splitClaimPercAmt;
    }

    @JsonProperty("splitClaimPercAmt")
    public void setSplitClaimPercAmt(Object splitClaimPercAmt) {
        this.splitClaimPercAmt = splitClaimPercAmt;
    }

    public PolicyTransactionsInfo withSplitClaimPercAmt(Object splitClaimPercAmt) {
        this.splitClaimPercAmt = splitClaimPercAmt;
        return this;
    }

    @JsonProperty("internalStatus")
    public String getInternalStatus() {
        return internalStatus;
    }

    @JsonProperty("internalStatus")
    public void setInternalStatus(String internalStatus) {
        this.internalStatus = internalStatus;
    }

    public PolicyTransactionsInfo withInternalStatus(String internalStatus) {
        this.internalStatus = internalStatus;
        return this;
    }

    @JsonProperty("externalStatus")
    public String getExternalStatus() {
        return externalStatus;
    }

    @JsonProperty("externalStatus")
    public void setExternalStatus(String externalStatus) {
        this.externalStatus = externalStatus;
    }

    public PolicyTransactionsInfo withExternalStatus(String externalStatus) {
        this.externalStatus = externalStatus;
        return this;
    }

    @JsonProperty("nextStatus")
    public String getNextStatus() {
        return nextStatus;
    }

    @JsonProperty("nextStatus")
    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }

    public PolicyTransactionsInfo withNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
        return this;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    public PolicyTransactionsInfo withAuthor(String author) {
        this.author = author;
        return this;
    }

    @JsonProperty("extrnlid")
    public BigInteger getExtrnlid() {
        return extrnlid;
    }

    @JsonProperty("extrnlid")
    public void setExtrnlid(BigInteger extrnlid) {
        this.extrnlid = extrnlid;
    }

    public PolicyTransactionsInfo withExtrnlid(BigInteger extrnlid) {
        this.extrnlid = extrnlid;
        return this;
    }

    @JsonProperty("partyId")
    public BigInteger getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(BigInteger partyId) {
        this.partyId = partyId;
    }

    public PolicyTransactionsInfo withPartyId(BigInteger partyId) {
        this.partyId = partyId;
        return this;
    }

    @JsonProperty("partyName")
    public Object getPartyName() {
        return partyName;
    }

    @JsonProperty("partyName")
    public void setPartyName(Object partyName) {
        this.partyName = partyName;
    }

    public PolicyTransactionsInfo withPartyName(Object partyName) {
        this.partyName = partyName;
        return this;
    }

    @JsonProperty("partyBpId")
    public BigInteger getPartyBpId() {
        return partyBpId;
    }

    @JsonProperty("partyBpId")
    public void setPartyBpId(BigInteger partyBpId) {
        this.partyBpId = partyBpId;
    }

    public PolicyTransactionsInfo withPartyBpId(BigInteger partyBpId) {
        this.partyBpId = partyBpId;
        return this;
    }

    @JsonProperty("printSortCode")
    public String getPrintSortCode() {
        return printSortCode;
    }

    @JsonProperty("printSortCode")
    public void setPrintSortCode(String printSortCode) {
        this.printSortCode = printSortCode;
    }

    public PolicyTransactionsInfo withPrintSortCode(String printSortCode) {
        this.printSortCode = printSortCode;
        return this;
    }

    @JsonProperty("ecfIndicator")
    public String getEcfIndicator() {
        return ecfIndicator;
    }

    @JsonProperty("ecfIndicator")
    public void setEcfIndicator(String ecfIndicator) {
        this.ecfIndicator = ecfIndicator;
    }

    public PolicyTransactionsInfo withEcfIndicator(String ecfIndicator) {
        this.ecfIndicator = ecfIndicator;
        return this;
    }

    @JsonProperty("carrierCode")
    public String getCarrierCode() {
        return carrierCode;
    }

    @JsonProperty("carrierCode")
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public PolicyTransactionsInfo withCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
        return this;
    }

    @JsonProperty("carrierPercentage")
    public String getCarrierPercentage() {
        return carrierPercentage;
    }

    @JsonProperty("carrierPercentage")
    public void setCarrierPercentage(String carrierPercentage) {
        this.carrierPercentage = carrierPercentage;
    }

    public PolicyTransactionsInfo withCarrierPercentage(String carrierPercentage) {
        this.carrierPercentage = carrierPercentage;
        return this;
    }

    @JsonProperty("carrierReference")
    public String getCarrierReference() {
        return carrierReference;
    }

    @JsonProperty("carrierReference")
    public void setCarrierReference(String carrierReference) {
        this.carrierReference = carrierReference;
    }

    public PolicyTransactionsInfo withCarrierReference(String carrierReference) {
        this.carrierReference = carrierReference;
        return this;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    public PolicyTransactionsInfo withRole(String role) {
        this.role = role;
        return this;
    }

    @JsonProperty("claimReference1")
    public String getClaimReference1() {
        return claimReference1;
    }

    @JsonProperty("claimReference1")
    public void setClaimReference1(String claimReference1) {
        this.claimReference1 = claimReference1;
    }

    public PolicyTransactionsInfo withClaimReference1(String claimReference1) {
        this.claimReference1 = claimReference1;
        return this;
    }

    @JsonProperty("claimReference2")
    public String getClaimReference2() {
        return claimReference2;
    }

    @JsonProperty("claimReference2")
    public void setClaimReference2(String claimReference2) {
        this.claimReference2 = claimReference2;
    }

    public PolicyTransactionsInfo withClaimReference2(String claimReference2) {
        this.claimReference2 = claimReference2;
        return this;
    }

    @JsonProperty("lloydsCatastropheCode")
    public String getLloydsCatastropheCode() {
        return lloydsCatastropheCode;
    }

    @JsonProperty("lloydsCatastropheCode")
    public void setLloydsCatastropheCode(String lloydsCatastropheCode) {
        this.lloydsCatastropheCode = lloydsCatastropheCode;
    }

    public PolicyTransactionsInfo withLloydsCatastropheCode(String lloydsCatastropheCode) {
        this.lloydsCatastropheCode = lloydsCatastropheCode;
        return this;
    }

    @JsonProperty("pcsCode")
    public String getPcsCode() {
        return pcsCode;
    }

    @JsonProperty("pcsCode")
    public void setPcsCode(String pcsCode) {
        this.pcsCode = pcsCode;
    }

    public PolicyTransactionsInfo withPcsCode(String pcsCode) {
        this.pcsCode = pcsCode;
        return this;
    }

    @JsonProperty("collectionType")
    public String getCollectionType() {
        return collectionType;
    }

    @JsonProperty("collectionType")
    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public PolicyTransactionsInfo withCollectionType(String collectionType) {
        this.collectionType = collectionType;
        return this;
    }

    @JsonProperty("createdby")
    public String getCreatedby() {
        return createdby;
    }

    @JsonProperty("createdby")
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public PolicyTransactionsInfo withCreatedby(String createdby) {
        this.createdby = createdby;
        return this;
    }

    @JsonProperty("createddate")
    public String getCreateddate() {
        return createddate;
    }

    @JsonProperty("createddate")
    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public PolicyTransactionsInfo withCreateddate(String createddate) {
        this.createddate = createddate;
        return this;
    }

    @JsonProperty("reserveUpdateFlag")
    public String getReserveUpdateFlag() {
        return reserveUpdateFlag;
    }

    @JsonProperty("reserveUpdateFlag")
    public void setReserveUpdateFlag(String reserveUpdateFlag) {
        this.reserveUpdateFlag = reserveUpdateFlag;
    }

    public PolicyTransactionsInfo withReserveUpdateFlag(String reserveUpdateFlag) {
        this.reserveUpdateFlag = reserveUpdateFlag;
        return this;
    }

    @JsonProperty("verfPaidFlag")
    public String getVerfPaidFlag() {
        return verfPaidFlag;
    }

    @JsonProperty("verfPaidFlag")
    public void setVerfPaidFlag(String verfPaidFlag) {
        this.verfPaidFlag = verfPaidFlag;
    }

    public PolicyTransactionsInfo withVerfPaidFlag(String verfPaidFlag) {
        this.verfPaidFlag = verfPaidFlag;
        return this;
    }

    @JsonProperty("approveEnabled")
    public String getApproveEnabled() {
        return approveEnabled;
    }

    @JsonProperty("approveEnabled")
    public void setApproveEnabled(String approveEnabled) {
        this.approveEnabled = approveEnabled;
    }

    public PolicyTransactionsInfo withApproveEnabled(String approveEnabled) {
        this.approveEnabled = approveEnabled;
        return this;
    }

    @JsonProperty("rejectEnabled")
    public String getRejectEnabled() {
        return rejectEnabled;
    }

    @JsonProperty("rejectEnabled")
    public void setRejectEnabled(String rejectEnabled) {
        this.rejectEnabled = rejectEnabled;
    }

    public PolicyTransactionsInfo withRejectEnabled(String rejectEnabled) {
        this.rejectEnabled = rejectEnabled;
        return this;
    }

    @JsonProperty("releasePayEnabled")
    public String getReleasePayEnabled() {
        return releasePayEnabled;
    }

    @JsonProperty("releasePayEnabled")
    public void setReleasePayEnabled(String releasePayEnabled) {
        this.releasePayEnabled = releasePayEnabled;
    }

    public PolicyTransactionsInfo withReleasePayEnabled(String releasePayEnabled) {
        this.releasePayEnabled = releasePayEnabled;
        return this;
    }

    @JsonProperty("reserveEnabled")
    public String getReserveEnabled() {
        return reserveEnabled;
    }

    @JsonProperty("reserveEnabled")
    public void setReserveEnabled(String reserveEnabled) {
        this.reserveEnabled = reserveEnabled;
    }

    public PolicyTransactionsInfo withReserveEnabled(String reserveEnabled) {
        this.reserveEnabled = reserveEnabled;
        return this;
    }

    @JsonProperty("collectPayEnabled")
    public String getCollectPayEnabled() {
        return collectPayEnabled;
    }

    @JsonProperty("collectPayEnabled")
    public void setCollectPayEnabled(String collectPayEnabled) {
        this.collectPayEnabled = collectPayEnabled;
    }

    public PolicyTransactionsInfo withCollectPayEnabled(String collectPayEnabled) {
        this.collectPayEnabled = collectPayEnabled;
        return this;
    }

    @JsonProperty("limitCurrencyCode")
    public String getLimitCurrencyCode() {
        return limitCurrencyCode;
    }

    @JsonProperty("limitCurrencyCode")
    public void setLimitCurrencyCode(String limitCurrencyCode) {
        this.limitCurrencyCode = limitCurrencyCode;
    }

    public PolicyTransactionsInfo withLimitCurrencyCode(String limitCurrencyCode) {
        this.limitCurrencyCode = limitCurrencyCode;
        return this;
    }

    @JsonProperty("approveUrl")
    public String getApproveUrl() {
        return approveUrl;
    }

    @JsonProperty("approveUrl")
    public void setApproveUrl(String approveUrl) {
        this.approveUrl = approveUrl;
    }

    public PolicyTransactionsInfo withApproveUrl(String approveUrl) {
        this.approveUrl = approveUrl;
        return this;
    }

    @JsonProperty("rejectUrl")
    public String getRejectUrl() {
        return rejectUrl;
    }

    @JsonProperty("rejectUrl")
    public void setRejectUrl(String rejectUrl) {
        this.rejectUrl = rejectUrl;
    }

    public PolicyTransactionsInfo withRejectUrl(String rejectUrl) {
        this.rejectUrl = rejectUrl;
        return this;
    }

    @JsonProperty("deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    @JsonProperty("deleteFlag")
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public PolicyTransactionsInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("claimsInternalRefInfo")
    public List<ClaimsInternalRefInfo> getClaimsInternalRefInfo() {
        return claimsInternalRefInfo;
    }

    @JsonProperty("claimsInternalRefInfo")
    public void setClaimsInternalRefInfo(List<ClaimsInternalRefInfo> claimsInternalRefInfo) {
        this.claimsInternalRefInfo = claimsInternalRefInfo;
    }

    public PolicyTransactionsInfo withClaimsInternalRefInfo(List<ClaimsInternalRefInfo> claimsInternalRefInfo) {
        this.claimsInternalRefInfo = claimsInternalRefInfo;
        return this;
    }

    @JsonProperty("claimsPayeeInfo")
    public List<Object> getClaimsPayeeInfo() {
        return claimsPayeeInfo;
    }

    @JsonProperty("claimsPayeeInfo")
    public void setClaimsPayeeInfo(List<Object> claimsPayeeInfo) {
        this.claimsPayeeInfo = claimsPayeeInfo;
    }

    public PolicyTransactionsInfo withClaimsPayeeInfo(List<Object> claimsPayeeInfo) {
        this.claimsPayeeInfo = claimsPayeeInfo;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
