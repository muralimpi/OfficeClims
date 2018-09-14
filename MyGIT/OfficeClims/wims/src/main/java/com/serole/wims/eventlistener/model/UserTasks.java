package com.serole.wims.eventlistener.model;


import java.util.List;

public class UserTasks {
	
    private List<UserTask> usertasks;

	/**
	 * @return the usertasks 
	 */
	public List<UserTask> getUsertasks() {
		return usertasks;
	}

	/**
	 * @param usertasks the usertasks to set
	 */
	public void setUsertasks(List<UserTask> usertasks) {
		this.usertasks = usertasks;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserTasks [usertasks=" + usertasks + "]";
	}


}

