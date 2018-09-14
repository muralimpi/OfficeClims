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
public class MainClientJSONAuditTrail {

	// @Autowired
	// private static DefaultWorkflowService oDefaultWorkflowService;

	/**
	 * 
	 */
	public MainClientJSONAuditTrail() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		try {
			String jsonOldData = new String(Files.readAllBytes(Paths.get("e://jsonOlddata.txt")));
			String jsonNewData = new String(Files.readAllBytes(Paths.get("e://jsonNewdata.txt")));

			//System.out.println(ret);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
