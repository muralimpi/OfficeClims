package com.serole.wims.eventlistener.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serole.wims.eventlistener.service.WorkflowService;
/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
@RestController
public class WorkflowController {

	private static final Logger LOG = LoggerFactory.getLogger(WorkflowController.class);
	
	@Autowired
	private WorkflowService oWorkflowService;

	@RequestMapping(value = "/startprocess/{message}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String startProcessInstance(@PathVariable("message") String message, @RequestParam String assignee) {
		return oWorkflowService.startProcess(message, assignee);
	}

	@RequestMapping(value = "/startprocessbygroup/{message}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String startProcessInstance(@PathVariable("message") String message, @RequestParam String assigneeGroup,
			@RequestParam String serviceUri) {
		return oWorkflowService.startProcessByGroup(message, assigneeGroup, serviceUri);
	}

	@RequestMapping(value = "/tasks/{group}/{assignee}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTasks(@PathVariable("group") String group, @PathVariable("assignee") String assignee) {
		List<Task> tasks = oWorkflowService.getTasks(group, assignee);
		return tasks.toString();
	}

	@RequestMapping(value = "/grouptasks/{group}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getGroupTasks(@PathVariable("group") String assigneeGroup) {
		List<Task> tasks = oWorkflowService.getGroupTasks(assigneeGroup);
		return tasks.toString();
	}

	@RequestMapping(value = "/completegrouptask",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String completeGroupTask(@RequestParam String id) {
		oWorkflowService.completegroupTask(id);
		return "Task with id " + id + " has been completed!";
	}

	@RequestMapping(value = "/completegrouptaskandstartnewgrouptask",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String completeGroupTaskAndStartNewGroupTask(@RequestParam String id) {
		oWorkflowService.completegroupTask(id);
		// return "Task with id " + id + " has been completed!";
		return oWorkflowService.startProcessByGroup("ourMessage", "review-users", "");
	}

	@RequestMapping(value = "/completetask",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String completeTask(@RequestParam String id) {
		oWorkflowService.completeTask(id);
		return "Task with id " + id + " has been completed!";
	}

}
