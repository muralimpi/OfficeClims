/**
 * 
 */
package com.serole.wims.eventlistener.model;

import java.util.List;

/**
 * @author SONJOY CHAKRABORTY
 *
 */

public class data {
	
	private List<ActivitiLog> oActivitiLogs;

	/**
	 * @return the oActivitiLogs
	 */
	public List<ActivitiLog> getoActivitiLogs() {
		return oActivitiLogs;
	}

	/**
	 * @param oActivitiLogs the oActivitiLogs to set
	 */
	public void setoActivitiLogs(List<ActivitiLog> oActivitiLogs) {
		this.oActivitiLogs = oActivitiLogs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "data [oActivitiLogs=" + oActivitiLogs + "]";
	}

	/**
	 * @param oActivitiLogs
	 */
	public data(List<ActivitiLog> oActivitiLogs) {
		super();
		this.oActivitiLogs = oActivitiLogs;
	}

	/**
	 * 
	 */
	public data() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
