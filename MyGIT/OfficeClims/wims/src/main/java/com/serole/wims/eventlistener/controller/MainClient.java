/**
 * 
 */
package com.serole.wims.eventlistener.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.serole.wims.eventlistener.model.ActivitiLog;
import com.serole.wims.eventlistener.service.DefaultWorkflowService;
import com.serole.wims.eventlistener.service.DefaultWorkflowServiceImpl;
import com.serole.wims.eventlistener.utils.JsonUtils;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
public class MainClient {

	// @Autowired
	// private static DefaultWorkflowService oDefaultWorkflowService;

	/**
	 * 
	 */
	public MainClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		try {
			String jsonData = new String(Files.readAllBytes(Paths.get("e://jsondata1.txt")));

			// ActivitiLog oActivitiLog = (ActivitiLog) JsonUtils.processJsonReq(jsonData);

			// String ret = JsonUtils.convertObjTojson(oActivitiLog);
			DefaultWorkflowService oDefaultWorkflowService = new DefaultWorkflowServiceImpl();
			String ret = oDefaultWorkflowService.startProcessFlow(jsonData);
			System.out.println(ret);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
