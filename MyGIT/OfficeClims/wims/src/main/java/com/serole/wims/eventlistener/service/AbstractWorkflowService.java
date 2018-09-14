package com.serole.wims.eventlistener.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serole.wims.eventlistener.model.ActivitiLog;
import com.serole.wims.eventlistener.utils.JsonUtils;

@Service
public interface AbstractWorkflowService {

	/**
	 * 
	 * @param message
	 * @param assignee
	 * @return
	 */
	public String startProcessFlow(String jsonData);

	/**
	 * 
	 * @param jsonData
	 * @return
	 */
	public ActivitiLog startTask(ActivitiLog oActivitiLog);

	/**
	 * 
	 * @param jsonData
	 * @return
	 */
	public String completeTask(String jsonData) ;
	/**
	 * 
	 * @param jsonData
	 * @return
	 */
	public void performTask(List<ActivitiLog> oActivitiLogEventList, String key, Map<String, List<Object>> oMap, ActivitiLog oActivitiLog);


	/**
	 * 
	 * @param jsonData
	 * @return
	 */
	public String saveTask(String jsonData);

	/**
	 * 
	 * @param jsonData
	 * @return
	 */
	public String deleteTask(String jsonData);

}
