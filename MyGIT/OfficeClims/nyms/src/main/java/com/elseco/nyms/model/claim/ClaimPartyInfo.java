
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
    "partyId",
    "claimHeaderId",
    "claimId",
    "partyBpId",
    "ucrNumber",
    "extRefNo",
    "partyName",
    "partyEmail",
    "partyDescription",
    "partyInvSource",
    "partyIntroducerID",
    "partyIntroducerName",
    "partySrvceAmtIncured",
    "partyPercSrvChrgInv1",
    "partyPercSrvChrgInv2",
    "partyPercSrvChrgInv3",
    "partyPercSrvChrgInv4",
    "partyAmtAddSubChrg",
    "partySrvcAmtPrevPaid",
    "partySrvcAmtSettled",
    "partySrvcDetails",
    "partyInvInternalStatus",
    "partyInvExternalStatus",
    "partyInvDate",
    "partyRemitanceAcctDts",
    "partyInvApporval",
    "collectionType",
    "deleteFlag"
})
public class ClaimPartyInfo {

    @JsonProperty("partyId")
    private BigInteger partyId;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("claimId")
    private BigInteger claimId;
    @JsonProperty("partyBpId")
    private BigInteger partyBpId;
    @JsonProperty("ucrNumber")
    private String ucrNumber;
    @JsonProperty("extRefNo")
    private String extRefNo;
    @JsonProperty("partyName")
    private String partyName;
    @JsonProperty("partyEmail")
    private String partyEmail;
    @JsonProperty("partyDescription")
    private String partyDescription;
    @JsonProperty("partyInvSource")
    private String partyInvSource;
    @JsonProperty("partyIntroducerID")
    private BigInteger partyIntroducerID;
    @JsonProperty("partyIntroducerName")
    private String partyIntroducerName;
    @JsonProperty("partySrvceAmtIncured")
    private BigInteger partySrvceAmtIncured;
    @JsonProperty("partyPercSrvChrgInv1")
    private Object partyPercSrvChrgInv1;
    @JsonProperty("partyPercSrvChrgInv2")
    private Object partyPercSrvChrgInv2;
    @JsonProperty("partyPercSrvChrgInv3")
    private Object partyPercSrvChrgInv3;
    @JsonProperty("partyPercSrvChrgInv4")
    private Object partyPercSrvChrgInv4;
    @JsonProperty("partyAmtAddSubChrg")
    private BigInteger partyAmtAddSubChrg;
    @JsonProperty("partySrvcAmtPrevPaid")
    private BigInteger partySrvcAmtPrevPaid;
    @JsonProperty("partySrvcAmtSettled")
    private BigInteger partySrvcAmtSettled;
    @JsonProperty("partySrvcDetails")
    private String partySrvcDetails;
    @JsonProperty("partyInvInternalStatus")
    private String partyInvInternalStatus;
    @JsonProperty("partyInvExternalStatus")
    private String partyInvExternalStatus;
    @JsonProperty("partyInvDate")
    private String partyInvDate;
    @JsonProperty("partyRemitanceAcctDts")
    private String partyRemitanceAcctDts;
    @JsonProperty("partyInvApporval")
    private String partyInvApporval;
    @JsonProperty("collectionType")
    private Object collectionType;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("partyId")
    public BigInteger getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(BigInteger partyId) {
        this.partyId = partyId;
    }

    public ClaimPartyInfo withPartyId(BigInteger partyId) {
        this.partyId = partyId;
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

    public ClaimPartyInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
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

    public ClaimPartyInfo withClaimId(BigInteger claimId) {
        this.claimId = claimId;
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

    public ClaimPartyInfo withPartyBpId(BigInteger partyBpId) {
        this.partyBpId = partyBpId;
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

    public ClaimPartyInfo withUcrNumber(String ucrNumber) {
        this.ucrNumber = ucrNumber;
        return this;
    }

    @JsonProperty("extRefNo")
    public String getExtRefNo() {
        return extRefNo;
    }

    @JsonProperty("extRefNo")
    public void setExtRefNo(String extRefNo) {
        this.extRefNo = extRefNo;
    }

    public ClaimPartyInfo withExtRefNo(String extRefNo) {
        this.extRefNo = extRefNo;
        return this;
    }

    @JsonProperty("partyName")
    public String getPartyName() {
        return partyName;
    }

    @JsonProperty("partyName")
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public ClaimPartyInfo withPartyName(String partyName) {
        this.partyName = partyName;
        return this;
    }

    @JsonProperty("partyEmail")
    public String getPartyEmail() {
        return partyEmail;
    }

    @JsonProperty("partyEmail")
    public void setPartyEmail(String partyEmail) {
        this.partyEmail = partyEmail;
    }

    public ClaimPartyInfo withPartyEmail(String partyEmail) {
        this.partyEmail = partyEmail;
        return this;
    }

    @JsonProperty("partyDescription")
    public String getPartyDescription() {
        return partyDescription;
    }

    @JsonProperty("partyDescription")
    public void setPartyDescription(String partyDescription) {
        this.partyDescription = partyDescription;
    }

    public ClaimPartyInfo withPartyDescription(String partyDescription) {
        this.partyDescription = partyDescription;
        return this;
    }

    @JsonProperty("partyInvSource")
    public String getPartyInvSource() {
        return partyInvSource;
    }

    @JsonProperty("partyInvSource")
    public void setPartyInvSource(String partyInvSource) {
        this.partyInvSource = partyInvSource;
    }

    public ClaimPartyInfo withPartyInvSource(String partyInvSource) {
        this.partyInvSource = partyInvSource;
        return this;
    }

    @JsonProperty("partyIntroducerID")
    public BigInteger getPartyIntroducerID() {
        return partyIntroducerID;
    }

    @JsonProperty("partyIntroducerID")
    public void setPartyIntroducerID(BigInteger partyIntroducerID) {
        this.partyIntroducerID = partyIntroducerID;
    }

    public ClaimPartyInfo withPartyIntroducerID(BigInteger partyIntroducerID) {
        this.partyIntroducerID = partyIntroducerID;
        return this;
    }

    @JsonProperty("partyIntroducerName")
    public String getPartyIntroducerName() {
        return partyIntroducerName;
    }

    @JsonProperty("partyIntroducerName")
    public void setPartyIntroducerName(String partyIntroducerName) {
        this.partyIntroducerName = partyIntroducerName;
    }

    public ClaimPartyInfo withPartyIntroducerName(String partyIntroducerName) {
        this.partyIntroducerName = partyIntroducerName;
        return this;
    }

    @JsonProperty("partySrvceAmtIncured")
    public BigInteger getPartySrvceAmtIncured() {
        return partySrvceAmtIncured;
    }

    @JsonProperty("partySrvceAmtIncured")
    public void setPartySrvceAmtIncured(BigInteger partySrvceAmtIncured) {
        this.partySrvceAmtIncured = partySrvceAmtIncured;
    }

    public ClaimPartyInfo withPartySrvceAmtIncured(BigInteger partySrvceAmtIncured) {
        this.partySrvceAmtIncured = partySrvceAmtIncured;
        return this;
    }

    @JsonProperty("partyPercSrvChrgInv1")
    public Object getPartyPercSrvChrgInv1() {
        return partyPercSrvChrgInv1;
    }

    @JsonProperty("partyPercSrvChrgInv1")
    public void setPartyPercSrvChrgInv1(Object partyPercSrvChrgInv1) {
        this.partyPercSrvChrgInv1 = partyPercSrvChrgInv1;
    }

    public ClaimPartyInfo withPartyPercSrvChrgInv1(Object partyPercSrvChrgInv1) {
        this.partyPercSrvChrgInv1 = partyPercSrvChrgInv1;
        return this;
    }

    @JsonProperty("partyPercSrvChrgInv2")
    public Object getPartyPercSrvChrgInv2() {
        return partyPercSrvChrgInv2;
    }

    @JsonProperty("partyPercSrvChrgInv2")
    public void setPartyPercSrvChrgInv2(Object partyPercSrvChrgInv2) {
        this.partyPercSrvChrgInv2 = partyPercSrvChrgInv2;
    }

    public ClaimPartyInfo withPartyPercSrvChrgInv2(Object partyPercSrvChrgInv2) {
        this.partyPercSrvChrgInv2 = partyPercSrvChrgInv2;
        return this;
    }

    @JsonProperty("partyPercSrvChrgInv3")
    public Object getPartyPercSrvChrgInv3() {
        return partyPercSrvChrgInv3;
    }

    @JsonProperty("partyPercSrvChrgInv3")
    public void setPartyPercSrvChrgInv3(Object partyPercSrvChrgInv3) {
        this.partyPercSrvChrgInv3 = partyPercSrvChrgInv3;
    }

    public ClaimPartyInfo withPartyPercSrvChrgInv3(Object partyPercSrvChrgInv3) {
        this.partyPercSrvChrgInv3 = partyPercSrvChrgInv3;
        return this;
    }

    @JsonProperty("partyPercSrvChrgInv4")
    public Object getPartyPercSrvChrgInv4() {
        return partyPercSrvChrgInv4;
    }

    @JsonProperty("partyPercSrvChrgInv4")
    public void setPartyPercSrvChrgInv4(Object partyPercSrvChrgInv4) {
        this.partyPercSrvChrgInv4 = partyPercSrvChrgInv4;
    }

    public ClaimPartyInfo withPartyPercSrvChrgInv4(Object partyPercSrvChrgInv4) {
        this.partyPercSrvChrgInv4 = partyPercSrvChrgInv4;
        return this;
    }

    @JsonProperty("partyAmtAddSubChrg")
    public BigInteger getPartyAmtAddSubChrg() {
        return partyAmtAddSubChrg;
    }

    @JsonProperty("partyAmtAddSubChrg")
    public void setPartyAmtAddSubChrg(BigInteger partyAmtAddSubChrg) {
        this.partyAmtAddSubChrg = partyAmtAddSubChrg;
    }

    public ClaimPartyInfo withPartyAmtAddSubChrg(BigInteger partyAmtAddSubChrg) {
        this.partyAmtAddSubChrg = partyAmtAddSubChrg;
        return this;
    }

    @JsonProperty("partySrvcAmtPrevPaid")
    public BigInteger getPartySrvcAmtPrevPaid() {
        return partySrvcAmtPrevPaid;
    }

    @JsonProperty("partySrvcAmtPrevPaid")
    public void setPartySrvcAmtPrevPaid(BigInteger partySrvcAmtPrevPaid) {
        this.partySrvcAmtPrevPaid = partySrvcAmtPrevPaid;
    }

    public ClaimPartyInfo withPartySrvcAmtPrevPaid(BigInteger partySrvcAmtPrevPaid) {
        this.partySrvcAmtPrevPaid = partySrvcAmtPrevPaid;
        return this;
    }

    @JsonProperty("partySrvcAmtSettled")
    public BigInteger getPartySrvcAmtSettled() {
        return partySrvcAmtSettled;
    }

    @JsonProperty("partySrvcAmtSettled")
    public void setPartySrvcAmtSettled(BigInteger partySrvcAmtSettled) {
        this.partySrvcAmtSettled = partySrvcAmtSettled;
    }

    public ClaimPartyInfo withPartySrvcAmtSettled(BigInteger partySrvcAmtSettled) {
        this.partySrvcAmtSettled = partySrvcAmtSettled;
        return this;
    }

    @JsonProperty("partySrvcDetails")
    public String getPartySrvcDetails() {
        return partySrvcDetails;
    }

    @JsonProperty("partySrvcDetails")
    public void setPartySrvcDetails(String partySrvcDetails) {
        this.partySrvcDetails = partySrvcDetails;
    }

    public ClaimPartyInfo withPartySrvcDetails(String partySrvcDetails) {
        this.partySrvcDetails = partySrvcDetails;
        return this;
    }

    @JsonProperty("partyInvInternalStatus")
    public String getPartyInvInternalStatus() {
        return partyInvInternalStatus;
    }

    @JsonProperty("partyInvInternalStatus")
    public void setPartyInvInternalStatus(String partyInvInternalStatus) {
        this.partyInvInternalStatus = partyInvInternalStatus;
    }

    public ClaimPartyInfo withPartyInvInternalStatus(String partyInvInternalStatus) {
        this.partyInvInternalStatus = partyInvInternalStatus;
        return this;
    }

    @JsonProperty("partyInvExternalStatus")
    public String getPartyInvExternalStatus() {
        return partyInvExternalStatus;
    }

    @JsonProperty("partyInvExternalStatus")
    public void setPartyInvExternalStatus(String partyInvExternalStatus) {
        this.partyInvExternalStatus = partyInvExternalStatus;
    }

    public ClaimPartyInfo withPartyInvExternalStatus(String partyInvExternalStatus) {
        this.partyInvExternalStatus = partyInvExternalStatus;
        return this;
    }

    @JsonProperty("partyInvDate")
    public String getPartyInvDate() {
        return partyInvDate;
    }

    @JsonProperty("partyInvDate")
    public void setPartyInvDate(String partyInvDate) {
        this.partyInvDate = partyInvDate;
    }

    public ClaimPartyInfo withPartyInvDate(String partyInvDate) {
        this.partyInvDate = partyInvDate;
        return this;
    }

    @JsonProperty("partyRemitanceAcctDts")
    public String getPartyRemitanceAcctDts() {
        return partyRemitanceAcctDts;
    }

    @JsonProperty("partyRemitanceAcctDts")
    public void setPartyRemitanceAcctDts(String partyRemitanceAcctDts) {
        this.partyRemitanceAcctDts = partyRemitanceAcctDts;
    }

    public ClaimPartyInfo withPartyRemitanceAcctDts(String partyRemitanceAcctDts) {
        this.partyRemitanceAcctDts = partyRemitanceAcctDts;
        return this;
    }

    @JsonProperty("partyInvApporval")
    public String getPartyInvApporval() {
        return partyInvApporval;
    }

    @JsonProperty("partyInvApporval")
    public void setPartyInvApporval(String partyInvApporval) {
        this.partyInvApporval = partyInvApporval;
    }

    public ClaimPartyInfo withPartyInvApporval(String partyInvApporval) {
        this.partyInvApporval = partyInvApporval;
        return this;
    }

    @JsonProperty("collectionType")
    public Object getCollectionType() {
        return collectionType;
    }

    @JsonProperty("collectionType")
    public void setCollectionType(Object collectionType) {
        this.collectionType = collectionType;
    }

    public ClaimPartyInfo withCollectionType(Object collectionType) {
        this.collectionType = collectionType;
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

    public ClaimPartyInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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
