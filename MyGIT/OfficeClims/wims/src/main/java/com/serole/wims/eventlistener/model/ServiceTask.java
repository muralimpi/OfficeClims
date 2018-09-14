package com.serole.wims.eventlistener.model;

public class ServiceTask extends AbstractTask {

	private String id;
	private String name;
	private String activityUniqueName;
	private String productUniqueName;
	private String moduleUniqueName;
	private String perishObjName;
	private String documentation;
	private String classname;
	private String expression;
	private String delegateexpression;
	private String fldextnclass;
	private String resultvariablename;
	private String executionlisteners;
	private String multiinstancetype;
	private String cardinality;
	private String collection;
	private String elementvariable;
	private String completioncondition;
	private String isforcompensation;
	private String asynchronous;
	private String exclusive;
	private String oldstatus;
	private String newstatus;
	private String autoswitchtaskid;
	private String autoswitchtasktype;
	private String oldusergroupassigned;
	private String newusergroupassigned;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	/**
	 * @return the documentation
	 */
	public String getDocumentation() {
		return documentation;
	}
	/**
	 * @param documentation the documentation to set
	 */
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	/**
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}
	/**
	 * @param classname the classname to set
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}
	/**
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}
	/**
	 * @param expression the expression to set
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}
	/**
	 * @return the delegateexpression
	 */
	public String getDelegateexpression() {
		return delegateexpression;
	}
	/**
	 * @param delegateexpression the delegateexpression to set
	 */
	public void setDelegateexpression(String delegateexpression) {
		this.delegateexpression = delegateexpression;
	}
	/**
	 * @return the fldextnclass
	 */
	public String getFldextnclass() {
		return fldextnclass;
	}
	/**
	 * @param fldextnclass the fldextnclass to set
	 */
	public void setFldextnclass(String fldextnclass) {
		this.fldextnclass = fldextnclass;
	}
	/**
	 * @return the resultvariablename
	 */
	public String getResultvariablename() {
		return resultvariablename;
	}
	/**
	 * @param resultvariablename the resultvariablename to set
	 */
	public void setResultvariablename(String resultvariablename) {
		this.resultvariablename = resultvariablename;
	}
	/**
	 * @return the executionlisteners
	 */
	public String getExecutionlisteners() {
		return executionlisteners;
	}
	/**
	 * @param executionlisteners the executionlisteners to set
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
	 * @param multiinstancetype the multiinstancetype to set
	 */
	public void setMultiinstancetype(String multiinstancetype) {
		this.multiinstancetype = multiinstancetype;
	}
	/**
	 * @return the cardinality
	 */
	public String getCardinality() {
		return cardinality;
	}
	/**
	 * @param cardinality the cardinality to set
	 */
	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}
	/**
	 * @return the collection
	 */
	public String getCollection() {
		return collection;
	}
	/**
	 * @param collection the collection to set
	 */
	public void setCollection(String collection) {
		this.collection = collection;
	}
	/**
	 * @return the elementvariable
	 */
	public String getElementvariable() {
		return elementvariable;
	}
	/**
	 * @param elementvariable the elementvariable to set
	 */
	public void setElementvariable(String elementvariable) {
		this.elementvariable = elementvariable;
	}
	/**
	 * @return the completioncondition
	 */
	public String getCompletioncondition() {
		return completioncondition;
	}
	/**
	 * @param completioncondition the completioncondition to set
	 */
	public void setCompletioncondition(String completioncondition) {
		this.completioncondition = completioncondition;
	}
	/**
	 * @return the isforcompensation
	 */
	public String getIsforcompensation() {
		return isforcompensation;
	}
	/**
	 * @param isforcompensation the isforcompensation to set
	 */
	public void setIsforcompensation(String isforcompensation) {
		this.isforcompensation = isforcompensation;
	}
	/**
	 * @return the asynchronous
	 */
	public String getAsynchronous() {
		return asynchronous;
	}
	/**
	 * @param asynchronous the asynchronous to set
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
	 * @param exclusive the exclusive to set
	 */
	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}
	/**
	 * @return the oldstatus
	 */
	public String getOldstatus() {
		return oldstatus;
	}
	/**
	 * @param oldstatus the oldstatus to set
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
	 * @param newstatus the newstatus to set
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
	 * @param autoswitchtaskid the autoswitchtaskid to set
	 */
	public void setAutoswitchtaskid(String autoswitchtaskid) {
		this.autoswitchtaskid = autoswitchtaskid;
	}
	/**
	 * @return the autoswitchtasktype
	 */
	public String getAutoswitchtasktype() {
		return autoswitchtasktype;
	}
	/**
	 * @param autoswitchtasktype the autoswitchtasktype to set
	 */
	public void setAutoswitchtasktype(String autoswitchtasktype) {
		this.autoswitchtasktype = autoswitchtasktype;
	}
	/**
	 * @return the oldusergroupassigned
	 */
	public String getOldusergroupassigned() {
		return oldusergroupassigned;
	}
	/**
	 * @param oldusergroupassigned the oldusergroupassigned to set
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
	 * @param newusergroupassigned the newusergroupassigned to set
	 */
	public void setNewusergroupassigned(String newusergroupassigned) {
		this.newusergroupassigned = newusergroupassigned;
	}
	/**
	 * @param id
	 * @param name
	 * @param activityUniqueName
	 * @param productUniqueName
	 * @param moduleUniqueName
	 * @param perishObjName
	 * @param documentation
	 * @param classname
	 * @param expression
	 * @param delegateexpression
	 * @param fldextnclass
	 * @param resultvariablename
	 * @param executionlisteners
	 * @param multiinstancetype
	 * @param cardinality
	 * @param collection
	 * @param elementvariable
	 * @param completioncondition
	 * @param isforcompensation
	 * @param asynchronous
	 * @param exclusive
	 * @param oldstatus
	 * @param newstatus
	 * @param autoswitchtaskid
	 * @param autoswitchtasktype
	 * @param oldusergroupassigned
	 * @param newusergroupassigned
	 */
	public ServiceTask(String id, String name, String activityUniqueName, String productUniqueName,
			String moduleUniqueName, String perishObjName, String documentation, String classname, String expression,
			String delegateexpression, String fldextnclass, String resultvariablename, String executionlisteners,
			String multiinstancetype, String cardinality, String collection, String elementvariable,
			String completioncondition, String isforcompensation, String asynchronous, String exclusive,
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
		this.classname = classname;
		this.expression = expression;
		this.delegateexpression = delegateexpression;
		this.fldextnclass = fldextnclass;
		this.resultvariablename = resultvariablename;
		this.executionlisteners = executionlisteners;
		this.multiinstancetype = multiinstancetype;
		this.cardinality = cardinality;
		this.collection = collection;
		this.elementvariable = elementvariable;
		this.completioncondition = completioncondition;
		this.isforcompensation = isforcompensation;
		this.asynchronous = asynchronous;
		this.exclusive = exclusive;
		this.oldstatus = oldstatus;
		this.newstatus = newstatus;
		this.autoswitchtaskid = autoswitchtaskid;
		this.autoswitchtasktype = autoswitchtasktype;
		this.oldusergroupassigned = oldusergroupassigned;
		this.newusergroupassigned = newusergroupassigned;
	}
	
	/**
	 * 
	 */
	public ServiceTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceTask [id=" + id + ", name=" + name + ", activityUniqueName=" + activityUniqueName
				+ ", productUniqueName=" + productUniqueName + ", moduleUniqueName=" + moduleUniqueName
				+ ", perishObjName=" + perishObjName + ", documentation=" + documentation + ", classname=" + classname
				+ ", expression=" + expression + ", delegateexpression=" + delegateexpression + ", fldextnclass="
				+ fldextnclass + ", resultvariablename=" + resultvariablename + ", executionlisteners="
				+ executionlisteners + ", multiinstancetype=" + multiinstancetype + ", cardinality=" + cardinality
				+ ", collection=" + collection + ", elementvariable=" + elementvariable + ", completioncondition="
				+ completioncondition + ", isforcompensation=" + isforcompensation + ", asynchronous=" + asynchronous
				+ ", exclusive=" + exclusive + ", oldstatus=" + oldstatus + ", newstatus=" + newstatus
				+ ", autoswitchtaskid=" + autoswitchtaskid + ", autoswitchtasktype=" + autoswitchtasktype
				+ ", oldusergroupassigned=" + oldusergroupassigned + ", newusergroupassigned=" + newusergroupassigned
				+ "]";
	}



}