package com.serole.wims.eventlistener.model;

public class WrapperServiceTaskResp extends WrapperTaskResp {

	public WrapperServiceTaskResp(String id, String name, String documentation, String oldstatus, String newstatus,
			String autoswitchtaskid, String autoswitchtasktype, String oldusergroupassigned,
			String newusergroupassigned) {
		super(id, name, documentation, oldstatus, newstatus, autoswitchtaskid, autoswitchtasktype, oldusergroupassigned,
				newusergroupassigned);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WrapperServiceTaskResp []";
	}
	
}