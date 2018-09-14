
package com.elseco.nyms.model.claim;

import java.math.BigInteger;
import java.util.HashMap;
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
    "resultId",
    "memberId",
    "stampId",
    "intRefId",
    "policyTransactionId",
    "marketTransactionId",
    "claimId",
    "claimHeaderId",
    "memberBpId",
    "memberName",
    "totalCapacityAmount",
    "totalShareVl",
    "ownCapacityAmt",
    "ownShareVl",
    "payPremiumToBpId",
    "payPolicyBRtoBpId",
    "payFFtoBpId",
    "payPBtoBpId",
    "payRibToBpId",
    "policyBrokerageVl",
    "elsecoCommissionVl",
    "ffVl",
    "pbVl",
    "ribVl",
    "profitCommisionVl",
    "pbBasis",
    "ffBasis",
    "ribBasis",
    "agreementId",
    "memberEmail",
    "deleteFlag",
    "elRiskCodeId",
    "memberRiskCodeInfo"
})
public class MemberResultsInfo {

    @JsonProperty("resultId")
    private BigInteger resultId;
    @JsonProperty("memberId")
    private BigInteger memberId;
    @JsonProperty("stampId")
    private BigInteger stampId;
    @JsonProperty("intRefId")
    private BigInteger intRefId;
    @JsonProperty("policyTransactionId")
    private BigInteger policyTransactionId;
    @JsonProperty("marketTransactionId")
    private BigInteger marketTransactionId;
    @JsonProperty("claimId")
    private BigInteger claimId;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("memberBpId")
    private BigInteger memberBpId;
    @JsonProperty("memberName")
    private String memberName;
    @JsonProperty("totalCapacityAmount")
    private BigInteger totalCapacityAmount;
    @JsonProperty("totalShareVl")
    private String totalShareVl;
    @JsonProperty("ownCapacityAmt")
    private BigInteger ownCapacityAmt;
    @JsonProperty("ownShareVl")
    private String ownShareVl;
    @JsonProperty("payPremiumToBpId")
    private BigInteger payPremiumToBpId;
    @JsonProperty("payPolicyBRtoBpId")
    private BigInteger payPolicyBRtoBpId;
    @JsonProperty("payFFtoBpId")
    private BigInteger payFFtoBpId;
    @JsonProperty("payPBtoBpId")
    private BigInteger payPBtoBpId;
    @JsonProperty("payRibToBpId")
    private BigInteger payRibToBpId;
    @JsonProperty("policyBrokerageVl")
    private String policyBrokerageVl;
    @JsonProperty("elsecoCommissionVl")
    private String elsecoCommissionVl;
    @JsonProperty("ffVl")
    private String ffVl;
    @JsonProperty("pbVl")
    private String pbVl;
    @JsonProperty("ribVl")
    private String ribVl;
    @JsonProperty("profitCommisionVl")
    private String profitCommisionVl;
    @JsonProperty("pbBasis")
    private String pbBasis;
    @JsonProperty("ffBasis")
    private String ffBasis;
    @JsonProperty("ribBasis")
    private String ribBasis;
    @JsonProperty("agreementId")
    private BigInteger agreementId;
    @JsonProperty("memberEmail")
    private String memberEmail;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("elRiskCodeId")
    private BigInteger elRiskCodeId;
    @JsonProperty("memberRiskCodeInfo")
    private MemberRiskCodeInfo memberRiskCodeInfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("resultId")
    public BigInteger getResultId() {
        return resultId;
    }

    @JsonProperty("resultId")
    public void setResultId(BigInteger resultId) {
        this.resultId = resultId;
    }

    public MemberResultsInfo withResultId(BigInteger resultId) {
        this.resultId = resultId;
        return this;
    }

    @JsonProperty("memberId")
    public BigInteger getMemberId() {
        return memberId;
    }

    @JsonProperty("memberId")
    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }

    public MemberResultsInfo withMemberId(BigInteger memberId) {
        this.memberId = memberId;
        return this;
    }

    @JsonProperty("stampId")
    public BigInteger getStampId() {
        return stampId;
    }

    @JsonProperty("stampId")
    public void setStampId(BigInteger stampId) {
        this.stampId = stampId;
    }

    public MemberResultsInfo withStampId(BigInteger stampId) {
        this.stampId = stampId;
        return this;
    }

    @JsonProperty("intRefId")
    public BigInteger getIntRefId() {
        return intRefId;
    }

    @JsonProperty("intRefId")
    public void setIntRefId(BigInteger intRefId) {
        this.intRefId = intRefId;
    }

    public MemberResultsInfo withIntRefId(BigInteger intRefId) {
        this.intRefId = intRefId;
        return this;
    }

    @JsonProperty("policyTransactionId")
    public BigInteger getPolicyTransactionId() {
        return policyTransactionId;
    }

    @JsonProperty("policyTransactionId")
    public void setPolicyTransactionId(BigInteger policyTransactionId) {
        this.policyTransactionId = policyTransactionId;
    }

    public MemberResultsInfo withPolicyTransactionId(BigInteger policyTransactionId) {
        this.policyTransactionId = policyTransactionId;
        return this;
    }

    @JsonProperty("marketTransactionId")
    public BigInteger getMarketTransactionId() {
        return marketTransactionId;
    }

    @JsonProperty("marketTransactionId")
    public void setMarketTransactionId(BigInteger marketTransactionId) {
        this.marketTransactionId = marketTransactionId;
    }

    public MemberResultsInfo withMarketTransactionId(BigInteger marketTransactionId) {
        this.marketTransactionId = marketTransactionId;
        return this;
    }

    @JsonProperty("claimId")
    public BigInteger getClaimId() {
        return claimId;
    }

    @JsonProperty("claimId")
    public void setClaimId(BigInteger claimId) {
        this.claimId = claimId;
    }

    public MemberResultsInfo withClaimId(BigInteger claimId) {
        this.claimId = claimId;
        return this;
    }

    @JsonProperty("claimHeaderId")
    public BigInteger getClaimHeaderId() {
        return claimHeaderId;
    }

    @JsonProperty("claimHeaderId")
    public void setClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
    }

    public MemberResultsInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("memberBpId")
    public BigInteger getMemberBpId() {
        return memberBpId;
    }

    @JsonProperty("memberBpId")
    public void setMemberBpId(BigInteger memberBpId) {
        this.memberBpId = memberBpId;
    }

    public MemberResultsInfo withMemberBpId(BigInteger memberBpId) {
        this.memberBpId = memberBpId;
        return this;
    }

    @JsonProperty("memberName")
    public String getMemberName() {
        return memberName;
    }

    @JsonProperty("memberName")
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MemberResultsInfo withMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }

    @JsonProperty("totalCapacityAmount")
    public BigInteger getTotalCapacityAmount() {
        return totalCapacityAmount;
    }

    @JsonProperty("totalCapacityAmount")
    public void setTotalCapacityAmount(BigInteger totalCapacityAmount) {
        this.totalCapacityAmount = totalCapacityAmount;
    }

    public MemberResultsInfo withTotalCapacityAmount(BigInteger totalCapacityAmount) {
        this.totalCapacityAmount = totalCapacityAmount;
        return this;
    }

    @JsonProperty("totalShareVl")
    public String getTotalShareVl() {
        return totalShareVl;
    }

    @JsonProperty("totalShareVl")
    public void setTotalShareVl(String totalShareVl) {
        this.totalShareVl = totalShareVl;
    }

    public MemberResultsInfo withTotalShareVl(String totalShareVl) {
        this.totalShareVl = totalShareVl;
        return this;
    }

    @JsonProperty("ownCapacityAmt")
    public BigInteger getOwnCapacityAmt() {
        return ownCapacityAmt;
    }

    @JsonProperty("ownCapacityAmt")
    public void setOwnCapacityAmt(BigInteger ownCapacityAmt) {
        this.ownCapacityAmt = ownCapacityAmt;
    }

    public MemberResultsInfo withOwnCapacityAmt(BigInteger ownCapacityAmt) {
        this.ownCapacityAmt = ownCapacityAmt;
        return this;
    }

    @JsonProperty("ownShareVl")
    public String getOwnShareVl() {
        return ownShareVl;
    }

    @JsonProperty("ownShareVl")
    public void setOwnShareVl(String ownShareVl) {
        this.ownShareVl = ownShareVl;
    }

    public MemberResultsInfo withOwnShareVl(String ownShareVl) {
        this.ownShareVl = ownShareVl;
        return this;
    }

    @JsonProperty("payPremiumToBpId")
    public BigInteger getPayPremiumToBpId() {
        return payPremiumToBpId;
    }

    @JsonProperty("payPremiumToBpId")
    public void setPayPremiumToBpId(BigInteger payPremiumToBpId) {
        this.payPremiumToBpId = payPremiumToBpId;
    }

    public MemberResultsInfo withPayPremiumToBpId(BigInteger payPremiumToBpId) {
        this.payPremiumToBpId = payPremiumToBpId;
        return this;
    }

    @JsonProperty("payPolicyBRtoBpId")
    public BigInteger getPayPolicyBRtoBpId() {
        return payPolicyBRtoBpId;
    }

    @JsonProperty("payPolicyBRtoBpId")
    public void setPayPolicyBRtoBpId(BigInteger payPolicyBRtoBpId) {
        this.payPolicyBRtoBpId = payPolicyBRtoBpId;
    }

    public MemberResultsInfo withPayPolicyBRtoBpId(BigInteger payPolicyBRtoBpId) {
        this.payPolicyBRtoBpId = payPolicyBRtoBpId;
        return this;
    }

    @JsonProperty("payFFtoBpId")
    public BigInteger getPayFFtoBpId() {
        return payFFtoBpId;
    }

    @JsonProperty("payFFtoBpId")
    public void setPayFFtoBpId(BigInteger payFFtoBpId) {
        this.payFFtoBpId = payFFtoBpId;
    }

    public MemberResultsInfo withPayFFtoBpId(BigInteger payFFtoBpId) {
        this.payFFtoBpId = payFFtoBpId;
        return this;
    }

    @JsonProperty("payPBtoBpId")
    public BigInteger getPayPBtoBpId() {
        return payPBtoBpId;
    }

    @JsonProperty("payPBtoBpId")
    public void setPayPBtoBpId(BigInteger payPBtoBpId) {
        this.payPBtoBpId = payPBtoBpId;
    }

    public MemberResultsInfo withPayPBtoBpId(BigInteger payPBtoBpId) {
        this.payPBtoBpId = payPBtoBpId;
        return this;
    }

    @JsonProperty("payRibToBpId")
    public BigInteger getPayRibToBpId() {
        return payRibToBpId;
    }

    @JsonProperty("payRibToBpId")
    public void setPayRibToBpId(BigInteger payRibToBpId) {
        this.payRibToBpId = payRibToBpId;
    }

    public MemberResultsInfo withPayRibToBpId(BigInteger payRibToBpId) {
        this.payRibToBpId = payRibToBpId;
        return this;
    }

    @JsonProperty("policyBrokerageVl")
    public String getPolicyBrokerageVl() {
        return policyBrokerageVl;
    }

    @JsonProperty("policyBrokerageVl")
    public void setPolicyBrokerageVl(String policyBrokerageVl) {
        this.policyBrokerageVl = policyBrokerageVl;
    }

    public MemberResultsInfo withPolicyBrokerageVl(String policyBrokerageVl) {
        this.policyBrokerageVl = policyBrokerageVl;
        return this;
    }

    @JsonProperty("elsecoCommissionVl")
    public String getElsecoCommissionVl() {
        return elsecoCommissionVl;
    }

    @JsonProperty("elsecoCommissionVl")
    public void setElsecoCommissionVl(String elsecoCommissionVl) {
        this.elsecoCommissionVl = elsecoCommissionVl;
    }

    public MemberResultsInfo withElsecoCommissionVl(String elsecoCommissionVl) {
        this.elsecoCommissionVl = elsecoCommissionVl;
        return this;
    }

    @JsonProperty("ffVl")
    public String getFfVl() {
        return ffVl;
    }

    @JsonProperty("ffVl")
    public void setFfVl(String ffVl) {
        this.ffVl = ffVl;
    }

    public MemberResultsInfo withFfVl(String ffVl) {
        this.ffVl = ffVl;
        return this;
    }

    @JsonProperty("pbVl")
    public String getPbVl() {
        return pbVl;
    }

    @JsonProperty("pbVl")
    public void setPbVl(String pbVl) {
        this.pbVl = pbVl;
    }

    public MemberResultsInfo withPbVl(String pbVl) {
        this.pbVl = pbVl;
        return this;
    }

    @JsonProperty("ribVl")
    public String getRibVl() {
        return ribVl;
    }

    @JsonProperty("ribVl")
    public void setRibVl(String ribVl) {
        this.ribVl = ribVl;
    }

    public MemberResultsInfo withRibVl(String ribVl) {
        this.ribVl = ribVl;
        return this;
    }

    @JsonProperty("profitCommisionVl")
    public String getProfitCommisionVl() {
        return profitCommisionVl;
    }

    @JsonProperty("profitCommisionVl")
    public void setProfitCommisionVl(String profitCommisionVl) {
        this.profitCommisionVl = profitCommisionVl;
    }

    public MemberResultsInfo withProfitCommisionVl(String profitCommisionVl) {
        this.profitCommisionVl = profitCommisionVl;
        return this;
    }

    @JsonProperty("pbBasis")
    public String getPbBasis() {
        return pbBasis;
    }

    @JsonProperty("pbBasis")
    public void setPbBasis(String pbBasis) {
        this.pbBasis = pbBasis;
    }

    public MemberResultsInfo withPbBasis(String pbBasis) {
        this.pbBasis = pbBasis;
        return this;
    }

    @JsonProperty("ffBasis")
    public String getFfBasis() {
        return ffBasis;
    }

    @JsonProperty("ffBasis")
    public void setFfBasis(String ffBasis) {
        this.ffBasis = ffBasis;
    }

    public MemberResultsInfo withFfBasis(String ffBasis) {
        this.ffBasis = ffBasis;
        return this;
    }

    @JsonProperty("ribBasis")
    public String getRibBasis() {
        return ribBasis;
    }

    @JsonProperty("ribBasis")
    public void setRibBasis(String ribBasis) {
        this.ribBasis = ribBasis;
    }

    public MemberResultsInfo withRibBasis(String ribBasis) {
        this.ribBasis = ribBasis;
        return this;
    }

    @JsonProperty("agreementId")
    public BigInteger getAgreementId() {
        return agreementId;
    }

    @JsonProperty("agreementId")
    public void setAgreementId(BigInteger agreementId) {
        this.agreementId = agreementId;
    }

    public MemberResultsInfo withAgreementId(BigInteger agreementId) {
        this.agreementId = agreementId;
        return this;
    }

    @JsonProperty("memberEmail")
    public String getMemberEmail() {
        return memberEmail;
    }

    @JsonProperty("memberEmail")
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public MemberResultsInfo withMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
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

    public MemberResultsInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("elRiskCodeId")
    public BigInteger getElRiskCodeId() {
        return elRiskCodeId;
    }

    @JsonProperty("elRiskCodeId")
    public void setElRiskCodeId(BigInteger elRiskCodeId) {
        this.elRiskCodeId = elRiskCodeId;
    }

    public MemberResultsInfo withElRiskCodeId(BigInteger elRiskCodeId) {
        this.elRiskCodeId = elRiskCodeId;
        return this;
    }

    @JsonProperty("memberRiskCodeInfo")
    public MemberRiskCodeInfo getMemberRiskCodeInfo() {
        return memberRiskCodeInfo;
    }

    @JsonProperty("memberRiskCodeInfo")
    public void setMemberRiskCodeInfo(MemberRiskCodeInfo memberRiskCodeInfo) {
        this.memberRiskCodeInfo = memberRiskCodeInfo;
    }

    public MemberResultsInfo withMemberRiskCodeInfo(MemberRiskCodeInfo memberRiskCodeInfo) {
        this.memberRiskCodeInfo = memberRiskCodeInfo;
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
