package com.serole.wims.eventlistener.model;


import java.util.List;

public class RestfulTasks {
	
    private List<RestfulTask> restfultasks;

	/**
	 * @return the restfultasks
	 */
	public List<RestfulTask> getRestfultasks() {
		return restfultasks;
	}

	/**
	 * @param restfultasks the restfultasks to set
	 */
	public void setRestfultasks(List<RestfulTask> restfultasks) {
		this.restfultasks = restfultasks;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestfulTasks [restfultasks=" + restfultasks + "]";
	}


}

