package com.serole.wims.eventlistener.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serole.wims.eventlistener.SingleTonDataLoader;
import com.serole.wims.eventlistener.processor.UserTaskProcessorHelper;

/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
@Service
public class WorkflowService {

	private static final Logger LOG = LoggerFactory.getLogger(WorkflowService.class);
	
	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	public String startProcess(String message, String assignee) {

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("message", message);
		variables.put("person", assignee);

		runtimeService.startProcessInstanceByMessage(message, variables);

		return "Process started";
	}

	public String startProcessByGroup(String message, String assigneeGroup, String serviceUri) {

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("message", message);
		variables.put("group", assigneeGroup);
		variables.put("service", serviceUri);

		runtimeService.startProcessInstanceByMessage(message, variables);

		return "Process started";
	}

	public List<Task> getTasks(String group, String assignee) {
		if ((SingleTonDataLoader.getUsers().contains(assignee))) {
			return taskService.createTaskQuery().taskCandidateGroup(group).list();
		} else {

			return taskService.createTaskQuery().taskAssignee(assignee).list();
		}

	}

	public List<Task> getGroupTasks(String groupName) {
		return taskService.createTaskQuery().taskCandidateGroup(groupName).list();
	}

	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

	public void completegroupTask(String taskId) {
		taskService.complete(taskId);
	}

}
