package com.serole.wims.eventlistener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serole.wims.eventlistener.service.WorkflowService;

/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
public class WorkflowEventListener implements ActivitiEventListener {

	private static final Logger LOG = LoggerFactory.getLogger(WorkflowEventListener.class);
	
	@Override
	public void onEvent(ActivitiEvent event) {
		switch (event.getType()) {
		case PROCESS_STARTED:
			System.out.println("New Process Instance has been started.");
			break;

		case PROCESS_COMPLETED:
			String message = (String) event.getEngineServices().getRuntimeService().getVariable(event.getExecutionId(),
					"message");
			System.out.println("Process (started by \"" + message + "\") has been completed.");
			break;

		case VARIABLE_CREATED:
			System.out.println("New Variable was created.");
			System.out.println(">> All Variables in execution scope: "
					+ event.getEngineServices().getRuntimeService().getVariables(event.getExecutionId()));
			break;

		case TASK_ASSIGNED:
			System.out.println("Task has been assigned.");
			break;

		case TASK_CREATED:
			System.out.println("Task has been created.");
			break;

		case TASK_COMPLETED:
			System.out.println("Task \""
					+ event.getEngineServices().getHistoryService().createHistoricTaskInstanceQuery()
							.orderByHistoricTaskInstanceEndTime().asc().list().get(0).getName()
					+ "\" has been completed.");
			break;

		default:
			break;
		}
	}

	@Override
	public boolean isFailOnException() {
		System.out.println("inside isFailOnException()");
		return false;
	}

}
