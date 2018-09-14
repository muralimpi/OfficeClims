package com.serole.wims.eventlistener.model;

public class WrapperTaskResp extends AbstractTask {

	public String id;
	public String name;
	public String documentation;
	public String oldstatus;
	public String newstatus;
	public String autoswitchtaskid;
	public String autoswitchtasktype;
	public String oldusergroupassigned;
	public String newusergroupassigned;
	
	
	/**
	 * 
	 * JSON Data Pattern 
	 * 
	 * id: null,
	 * name: null,
	 * documentation: null,
	 * oldstatus: s,
	 * newstatus: null,
	 * 
	 * 
	 */
	
	
	public WrapperTaskResp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param documentation
	 * @param oldstatus
	 * @param newstatus
	 * @param autoswitchtaskid
	 * @param autoswitchtasktype
	 * @param oldusergroupassigned
	 * @param newusergroupassigned
	 */
	public WrapperTaskResp(String id, String name, String documentation, String oldstatus, String newstatus,
			String autoswitchtaskid, String autoswitchtasktype, String oldusergroupassigned,
			String newusergroupassigned) {
		super();
		this.id = id;
		this.name = name;
		this.documentation = documentation;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WrapperTaskResp [id=" + id + ", name=" + name + ", documentation=" + documentation + ", oldstatus="
				+ oldstatus + ", newstatus=" + newstatus + ", autoswitchtaskid=" + autoswitchtaskid
				+ ", autoswitchtasktype=" + autoswitchtasktype + ", oldusergroupassigned=" + oldusergroupassigned
				+ ", newusergroupassigned=" + newusergroupassigned + "]";
	}



}