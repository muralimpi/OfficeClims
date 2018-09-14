package com.serole.wims.eventlistener.model;


import java.util.List;

public class ServiceTasks {
	
    private List<ServiceTask> servicetasks;

	/**
	 * @return the servicetasks
	 */
	public List<ServiceTask> getServicetasks() {
		return servicetasks;
	}

	/**
	 * @param servicetasks the servicetasks to set
	 */
	public void setServicetasks(List<ServiceTask> servicetasks) {
		this.servicetasks = servicetasks;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceTasks [servicetasks=" + servicetasks + "]";
	}


}

