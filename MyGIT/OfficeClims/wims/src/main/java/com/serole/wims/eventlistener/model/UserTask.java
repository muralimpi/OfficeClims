package com.serole.wims.eventlistener.model;

public class UserTask extends AbstractTask {

	private String id;
	private String name;
	private String activityUniqueName;
	private String productUniqueName;
	private String moduleUniqueName;
	private String perishObjName;
	private String documentation;
	private String assignment;
	private String referencedform;
	private String formkey;
	private String formproperties;
	private String duedate;
	private String allowemailnotifications;
	private String asynchronous;
	private String exclusive;
	private String executionlisteners;
	private String multiinstancetype;
	private String cardinalitymultiinstance;
	private String collectionmultiinstance;
	private String elementvariablemultiinstance;
	private String completionconditionmultiinstance;
	private String isforcompensation;
	private String oldstatus;
	private String newstatus;
	private String autoswitchtaskid;
	private String autoswitchtasktype;
	private String oldusergroupassigned;
	private String newusergroupassigned;
	
	
	/**
	 * 
	 */
	public UserTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param activityUniqueName
	 * @param productUniqueName
	 * @param moduleUniqueName
	 * @param perishObjName
	 * @param documentation
	 * @param assignment
	 * @param referencedform
	 * @param formkey
	 * @param formproperties
	 * @param duedate
	 * @param allowemailnotifications
	 * @param asynchronous
	 * @param exclusive
	 * @param executionlisteners
	 * @param multiinstancetype
	 * @param cardinalitymultiinstance
	 * @param collectionmultiinstance
	 * @param elementvariablemultiinstance
	 * @param completionconditionmultiinstance
	 * @param isforcompensation
	 * @param oldstatus
	 * @param newstatus
	 * @param autoswitchtaskid
	 * @param autoswitchtasktype
	 * @param oldusergroupassigned
	 * @param newusergroupassigned
	 */
	public UserTask(String id, String name, String activityUniqueName, String productUniqueName,
			String moduleUniqueName, String perishObjName, String documentation, String assignment,
			String referencedform, String formkey, String formproperties, String duedate,
			String allowemailnotifications, String asynchronous, String exclusive, String executionlisteners,
			String multiinstancetype, String cardinalitymultiinstance, String collectionmultiinstance,
			String elementvariablemultiinstance, String completionconditionmultiinstance, String isforcompensation,
			String oldstatus, String newstatus, String autoswitchtaskid, String autoswitchtasktype,
			String oldusergroupassigned, String newusergroupassigned) {
		super();
		this.id = id;
		this.name = name;
		this.activityUniqueName = activityUniqueName;
		this.productUniqueName = productUniqueName;
		this.moduleUniqueName = moduleUniqueName;
		this.perishObjName = perishObjName;
		this.documentation = documentation;
		this.assignment = assignment;
		this.referencedform = referencedform;
		this.formkey = formkey;
		this.formproperties = formproperties;
		this.duedate = duedate;
		this.allowemailnotifications = allowemailnotifications;
		this.asynchronous = asynchronous;
		this.exclusive = exclusive;
		this.executionlisteners = executionlisteners;
		this.multiinstancetype = multiinstancetype;
		this.cardinalitymultiinstance = cardinalitymultiinstance;
		this.collectionmultiinstance = collectionmultiinstance;
		this.elementvariablemultiinstance = elementvariablemultiinstance;
		this.completionconditionmultiinstance = completionconditionmultiinstance;
		this.isforcompensation = isforcompensation;
		this.oldstatus = oldstatus;
		this.newstatus = newstatus;
		this.autoswitchtaskid = autoswitchtaskid;
		this.autoswitchtasktype = autoswitchtasktype;
		this.oldusergroupassigned = oldusergroupassigned;
		this.newusergroupassigned = newusergroupassigned;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the documentation
	 */
	public String getDocumentation() {
		return documentation;
	}

	/**
	 * @param documentation
	 *            the documentation to set
	 */
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	/**
	 * @return the assignment
	 */
	public String getAssignment() {
		return assignment;
	}

	/**
	 * @param assignment
	 *            the assignment to set
	 */
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	/**
	 * @return the referencedform
	 */
	public String getReferencedform() {
		return referencedform;
	}

	/**
	 * @param referencedform
	 *            the referencedform to set
	 */
	public void setReferencedform(String referencedform) {
		this.referencedform = referencedform;
	}

	/**
	 * @return the formkey
	 */
	public String getFormkey() {
		return formkey;
	}

	/**
	 * @param formkey
	 *            the formkey to set
	 */
	public void setFormkey(String formkey) {
		this.formkey = formkey;
	}

	/**
	 * @return the formproperties
	 */
	public String getFormproperties() {
		return formproperties;
	}

	/**
	 * @param formproperties
	 *            the formproperties to set
	 */
	public void setFormproperties(String formproperties) {
		this.formproperties = formproperties;
	}

	/**
	 * @return the duedate
	 */
	public String getDuedate() {
		return duedate;
	}

	/**
	 * @param duedate
	 *            the duedate to set
	 */
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	/**
	 * @return the allowemailnotifications
	 */
	public String getAllowemailnotifications() {
		return allowemailnotifications;
	}

	/**
	 * @param allowemailnotifications
	 *            the allowemailnotifications to set
	 */
	public void setAllowemailnotifications(String allowemailnotifications) {
		this.allowemailnotifications = allowemailnotifications;
	}

	/**
	 * @return the asynchronous
	 */
	public String getAsynchronous() {
		return asynchronous;
	}

	/**
	 * @param asynchronous
	 *            the asynchronous to set
	 */
	public void setAsynchronous(String asynchronous) {
		this.asynchronous = asynchronous;
	}

	/**
	 * @return the exclusive
	 */
	public String getExclusive() {
		return exclusive;
	}

	/**
	 * @param exclusive
	 *            the exclusive to set
	 */
	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}

	/**
	 * @return the executionlisteners
	 */
	public String getExecutionlisteners() {
		return executionlisteners;
	}

	/**
	 * @param executionlisteners
	 *            the executionlisteners to set
	 */
	public void setExecutionlisteners(String executionlisteners) {
		this.executionlisteners = executionlisteners;
	}

	/**
	 * @return the multiinstancetype
	 */
	public String getMultiinstancetype() {
		return multiinstancetype;
	}

	/**
	 * @param multiinstancetype
	 *            the multiinstancetype to set
	 */
	public void setMultiinstancetype(String multiinstancetype) {
		this.multiinstancetype = multiinstancetype;
	}

	/**
	 * @return the cardinalitymultiinstance
	 */
	public String getCardinalitymultiinstance() {
		return cardinalitymultiinstance;
	}

	/**
	 * @param cardinalitymultiinstance
	 *            the cardinalitymultiinstance to set
	 */
	public void setCardinalitymultiinstance(String cardinalitymultiinstance) {
		this.cardinalitymultiinstance = cardinalitymultiinstance;
	}

	/**
	 * @return the collectionmultiinstance
	 */
	public String getCollectionmultiinstance() {
		return collectionmultiinstance;
	}

	/**
	 * @param collectionmultiinstance
	 *            the collectionmultiinstance to set
	 */
	public void setCollectionmultiinstance(String collectionmultiinstance) {
		this.collectionmultiinstance = collectionmultiinstance;
	}

	/**
	 * @return the elementvariablemultiinstance
	 */
	public String getElementvariablemultiinstance() {
		return elementvariablemultiinstance;
	}

	/**
	 * @param elementvariablemultiinstance
	 *            the elementvariablemultiinstance to set
	 */
	public void setElementvariablemultiinstance(String elementvariablemultiinstance) {
		this.elementvariablemultiinstance = elementvariablemultiinstance;
	}

	/**
	 * @return the completionconditionmultiinstance
	 */
	public String getCompletionconditionmultiinstance() {
		return completionconditionmultiinstance;
	}

	/**
	 * @param completionconditionmultiinstance
	 *            the completionconditionmultiinstance to set
	 */
	public void setCompletionconditionmultiinstance(String completionconditionmultiinstance) {
		this.completionconditionmultiinstance = completionconditionmultiinstance;
	}

	/**
	 * @return the isforcompensation
	 */
	public String getIsforcompensation() {
		return isforcompensation;
	}

	/**
	 * @param isforcompensation
	 *            the isforcompensation to set
	 */
	public void setIsforcompensation(String isforcompensation) {
		this.isforcompensation = isforcompensation;
	}

	/**
	 * @return the oldstatus
	 */
	public String getOldstatus() {
		return oldstatus;
	}

	/**
	 * @param oldstatus
	 *            the oldstatus to set
	 */
	public void setOldstatus(String oldstatus) {
		this.oldstatus = oldstatus;
	}

	/**
	 * @return the newstatus
	 */
	public String getNewstatus() {
		return newstatus;
	}

	/**
	 * @param newstatus
	 *            the newstatus to set
	 */
	public void setNewstatus(String newstatus) {
		this.newstatus = newstatus;
	}

	/**
	 * @return the autoswitchtaskid
	 */
	public String getAutoswitchtaskid() {
		return autoswitchtaskid;
	}

	/**
	 * @param autoswitchtaskid
	 *            the autoswitchtaskid to set
	 */
	public void setAutoswitchtaskid(String autoswitchtaskid) {
		this.autoswitchtaskid = autoswitchtaskid;
	}

	/**
	 * @return the oldusergroupassigned
	 */
	public String getOldusergroupassigned() {
		return oldusergroupassigned;
	}

	/**
	 * @param oldusergroupassigned
	 *            the oldusergroupassigned to set
	 */
	public void setOldusergroupassigned(String oldusergroupassigned) {
		this.oldusergroupassigned = oldusergroupassigned;
	}

	/**
	 * @return the newusergroupassigned
	 */
	public String getNewusergroupassigned() {
		return newusergroupassigned;
	}

	/**
	 * @param newusergroupassigned
	 *            the newusergroupassigned to set
	 */
	public void setNewusergroupassigned(String newusergroupassigned) {
		this.newusergroupassigned = newusergroupassigned;
	}

	/**
	 * @return the autoswitchtasktype
	 */
	public String getAutoswitchtasktype() {
		return autoswitchtasktype;
	}

	/**
	 * @param autoswitchtasktype
	 *            the autoswitchtasktype to set
	 */
	public void setAutoswitchtasktype(String autoswitchtasktype) {
		this.autoswitchtasktype = autoswitchtasktype;
	}

	/**
	 * @return the activityUniqueName
	 */
	public String getActivityUniqueName() {
		return activityUniqueName;
	}

	/**
	 * @param activityUniqueName the activityUniqueName to set
	 */
	public void setActivityUniqueName(String activityUniqueName) {
		this.activityUniqueName = activityUniqueName;
	}

	/**
	 * @return the productUniqueName
	 */
	public String getProductUniqueName() {
		return productUniqueName;
	}

	/**
	 * @param productUniqueName the productUniqueName to set
	 */
	public void setProductUniqueName(String productUniqueName) {
		this.productUniqueName = productUniqueName;
	}

	/**
	 * @return the moduleUniqueName
	 */
	public String getModuleUniqueName() {
		return moduleUniqueName;
	}

	/**
	 * @param moduleUniqueName the moduleUniqueName to set
	 */
	public void setModuleUniqueName(String moduleUniqueName) {
		this.moduleUniqueName = moduleUniqueName;
	}

	/**
	 * @return the perishObjName
	 */
	public String getPerishObjName() {
		return perishObjName;
	}

	/**
	 * @param perishObjName the perishObjName to set
	 */
	public void setPerishObjName(String perishObjName) {
		this.perishObjName = perishObjName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserTask [id=" + id + ", name=" + name + ", activityUniqueName=" + activityUniqueName
				+ ", productUniqueName=" + productUniqueName + ", moduleUniqueName=" + moduleUniqueName
				+ ", perishObjName=" + perishObjName + ", documentation=" + documentation + ", assignment=" + assignment
				+ ", referencedform=" + referencedform + ", formkey=" + formkey + ", formproperties=" + formproperties
				+ ", duedate=" + duedate + ", allowemailnotifications=" + allowemailnotifications + ", asynchronous="
				+ asynchronous + ", exclusive=" + exclusive + ", executionlisteners=" + executionlisteners
				+ ", multiinstancetype=" + multiinstancetype + ", cardinalitymultiinstance=" + cardinalitymultiinstance
				+ ", collectionmultiinstance=" + collectionmultiinstance + ", elementvariablemultiinstance="
				+ elementvariablemultiinstance + ", completionconditionmultiinstance="
				+ completionconditionmultiinstance + ", isforcompensation=" + isforcompensation + ", oldstatus="
				+ oldstatus + ", newstatus=" + newstatus + ", autoswitchtaskid=" + autoswitchtaskid
				+ ", autoswitchtasktype=" + autoswitchtasktype + ", oldusergroupassigned=" + oldusergroupassigned
				+ ", newusergroupassigned=" + newusergroupassigned + "]";
	}



}