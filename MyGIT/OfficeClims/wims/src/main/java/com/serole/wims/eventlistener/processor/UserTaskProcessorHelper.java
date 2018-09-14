package com.serole.wims.eventlistener.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serole.wims.eventlistener.initializer.TaskMapsInitializer;
import com.serole.wims.eventlistener.model.UserTask;

public class UserTaskProcessorHelper {

	private static final Logger LOG = LoggerFactory.getLogger(UserTaskProcessorHelper.class);
	
	public UserTaskProcessorHelper() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param oUserTaskSource
	 * @return
	 */
	public static UserTask performTasks(UserTask  oUserTaskSource) {
		UserTask oUserTask  = null;
		
		try {
			oUserTask = assignUserTaskInWorkflowProcess(oUserTaskSource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return oUserTask; 
	}

	/**
	 * 
	 * @param oUserTaskSource
	 * @return
	 */
	public static UserTask assignUserTaskInWorkflowProcess(UserTask  oUserTaskSource) {
		UserTask oUserTask  = null;
		oUserTask = oUserTaskSource;
		return oUserTask ;
	}

}
