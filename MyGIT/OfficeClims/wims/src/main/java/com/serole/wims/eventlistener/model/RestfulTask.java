package com.serole.wims.eventlistener.model;

public class RestfulTask extends AbstractTask {

	private String id;
	private String name;
	private String activityUniqueName;
	private String productUniqueName;
	private String moduleUniqueName;
	private String perishObjName;
	private String documentation;
	private String endpoint;
	private String requestmapping;
	private String responsemapping;
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
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}
	/**
	 * @param endpoint the endpoint to set
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	/**
	 * @return the requestmapping
	 */
	public String getRequestmapping() {
		return requestmapping;
	}
	/**
	 * @param requestmapping the requestmapping to set
	 */
	public void setRequestmapping(String requestmapping) {
		this.requestmapping = requestmapping;
	}
	/**
	 * @return the responsemapping
	 */
	public String getResponsemapping() {
		return responsemapping;
	}
	/**
	 * @param responsemapping the responsemapping to set
	 */
	public void setResponsemapping(String responsemapping) {
		this.responsemapping = responsemapping;
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
	 * @param endpoint
	 * @param requestmapping
	 * @param responsemapping
	 * @param oldstatus
	 * @param newstatus
	 * @param autoswitchtaskid
	 * @param autoswitchtasktype
	 * @param oldusergroupassigned
	 * @param newusergroupassigned
	 */
	public RestfulTask(String id, String name, String activityUniqueName, String productUniqueName,
			String moduleUniqueName, String perishObjName, String documentation, String endpoint, String requestmapping,
			String responsemapping, String oldstatus, String newstatus, String autoswitchtaskid,
			String autoswitchtasktype, String oldusergroupassigned, String newusergroupassigned) {
		super();
		this.id = id;
		this.name = name;
		this.activityUniqueName = activityUniqueName;
		this.productUniqueName = productUniqueName;
		this.moduleUniqueName = moduleUniqueName;
		this.perishObjName = perishObjName;
		this.documentation = documentation;
		this.endpoint = endpoint;
		this.requestmapping = requestmapping;
		this.responsemapping = responsemapping;
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
	public RestfulTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestfulTask [id=" + id + ", name=" + name + ", activityUniqueName=" + activityUniqueName
				+ ", productUniqueName=" + productUniqueName + ", moduleUniqueName=" + moduleUniqueName
				+ ", perishObjName=" + perishObjName + ", documentation=" + documentation + ", endpoint=" + endpoint
				+ ", requestmapping=" + requestmapping + ", responsemapping=" + responsemapping + ", oldstatus="
				+ oldstatus + ", newstatus=" + newstatus + ", autoswitchtaskid=" + autoswitchtaskid
				+ ", autoswitchtasktype=" + autoswitchtasktype + ", oldusergroupassigned=" + oldusergroupassigned
				+ ", newusergroupassigned=" + newusergroupassigned + "]";
	}



}