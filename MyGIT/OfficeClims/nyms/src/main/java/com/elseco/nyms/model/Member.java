/**
 * 
 */
package com.elseco.nyms.model;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
public class Member {

	private String memberId; 
	private String memberName; 
	private String memberSplit; 
	private String memberEmail; 
	private String memberCollectionType; 

	/**
	 * 
	 */
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String memberName, String memberSplit, String memberEmail, String memberCollectionType) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberSplit = memberSplit;
		this.memberEmail = memberEmail;
		this.memberCollectionType = memberCollectionType;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the memberSplit
	 */
	public String getMemberSplit() {
		return memberSplit;
	}

	/**
	 * @param memberSplit the memberSplit to set
	 */
	public void setMemberSplit(String memberSplit) {
		this.memberSplit = memberSplit;
	}

	/**
	 * @return the memberEmail
	 */
	public String getMemberEmail() {
		return memberEmail;
	}

	/**
	 * @param memberEmail the memberEmail to set
	 */
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	/**
	 * @return the memberCollectionType
	 */
	public String getMemberCollectionType() {
		return memberCollectionType;
	}

	/**
	 * @param memberCollectionType the memberCollectionType to set
	 */
	public void setMemberCollectionType(String memberCollectionType) {
		this.memberCollectionType = memberCollectionType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberCollectionType == null) ? 0 : memberCollectionType.hashCode());
		result = prime * result + ((memberEmail == null) ? 0 : memberEmail.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberSplit == null) ? 0 : memberSplit.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (memberCollectionType == null) {
			if (other.memberCollectionType != null)
				return false;
		} else if (!memberCollectionType.equals(other.memberCollectionType))
			return false;
		if (memberEmail == null) {
			if (other.memberEmail != null)
				return false;
		} else if (!memberEmail.equals(other.memberEmail))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberSplit == null) {
			if (other.memberSplit != null)
				return false;
		} else if (!memberSplit.equals(other.memberSplit))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberSplit=" + memberSplit
				+ ", memberEmail=" + memberEmail + ", memberCollectionType=" + memberCollectionType + "]";
	}

	
	
}
